package net.cocotea.admin.api.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import com.sagframe.sagacity.sqltoy.plus.dao.SqlToyHelperDao;
import net.cocotea.admin.api.system.model.dto.SysFileAddDTO;
import net.cocotea.admin.api.system.model.dto.SysFilePageDTO;
import net.cocotea.admin.api.system.model.dto.SysFileUpdateDTO;
import net.cocotea.admin.api.system.model.po.SysFile;
import net.cocotea.admin.api.system.model.vo.SysFileVO;
import net.cocotea.admin.api.system.service.SysFileService;
import net.cocotea.admin.common.enums.IsEnum;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.properties.FileProp;
import net.cocotea.admin.util.LoginUtils;
import org.sagacity.sqltoy.dao.LightDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 系统文件表
 *
 * @author CoCoTea 572315466@qq.com
 * @version 2.0.0
 */
@Service
public class SysFileServiceImpl implements SysFileService {

    @Resource
    private SqlToyHelperDao sqlToyHelperDao;

    @Resource
    private LightDao lightDao;

    @Resource
    private FileProp fileProp;

    @Override
    public boolean add(SysFileAddDTO fileAddDTO) {
        SysFile sysFile = Convert.convert(SysFile.class, fileAddDTO);
        Object save = sqlToyHelperDao.save(sysFile);
        return save != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBatch(List<BigInteger> param) {
        List<SysFile> sysFileList = new ArrayList<>(param.size());
        for (BigInteger id : param) {
            sysFileList.add(new SysFile().setId(id).setIsDeleted(IsEnum.Y.getCode()));
        }
        return sqlToyHelperDao.updateAll(sysFileList) > 0;
    }

    @Override
    public boolean update(SysFileUpdateDTO fileUpdateDTO) {
        SysFile sysFile = Convert.convert(SysFile.class, fileUpdateDTO);
        Long count = sqlToyHelperDao.update(sysFile);
        return count > 0;
    }

    @Override
    public ApiPage<SysFileVO> listByPage(SysFilePageDTO pageDTO) {
        Map<String, Object> sysFileMap = BeanUtil.beanToMap(pageDTO.getSysFile());
        sysFileMap.put("userId", LoginUtils.loginId());

        Page<SysFileVO> page = lightDao.findPage(ApiPage.create(pageDTO), "sys_file_JOIN_findList", sysFileMap, SysFileVO.class);
        return ApiPage.rest(page);
    }

    @Override
    public boolean delete(BigInteger id) {
        return sqlToyHelperDao.update(new SysFile().setId(id).setIsDeleted(IsEnum.Y.getCode())) > 0;
    }

    @Override
    public ApiPage<SysFileVO> recycleBinPage(SysFilePageDTO pageDTO) {
        return listByPage(pageDTO.setIsDeleted(IsEnum.Y.getCode()));
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public boolean recycleBinDeleteBatch(List<BigInteger> param) {
        List<SysFile> sysFileList = new ArrayList<>(param.size());
        for (BigInteger id : param) {
            SysFile sysFile = sqlToyHelperDao.load(new SysFile().setId(id));
            if (sysFile != null) {
                FileUtil.del(fileProp.getDefaultSavePath() + sysFile.getRealPath());
            }
            sysFileList.add(new SysFile().setId(id));
        }
        return sqlToyHelperDao.deleteAll(sysFileList) > 0;
    }

    @Override
    public boolean recoveryBatch(List<BigInteger> param) {
        List<SysFile> sysFileList = new ArrayList<>(param.size());
        for (BigInteger id : param) {
            sysFileList.add(new SysFile().setId(id).setIsDeleted(IsEnum.N.getCode()));
        }
        return sqlToyHelperDao.updateAll(sysFileList) > 0;
    }

    @Override
    public void download(BigInteger fileId, HttpServletResponse response) throws BusinessException, IOException {
        SysFileVO sysFile = getUserFile(fileId);
        String fullPath = fileProp.getDefaultSavePath() + sysFile.getRealPath();
        File file = FileUtil.file(fullPath);
        if (file.exists()) {
            FileUtil.writeToStream(file, response.getOutputStream());
        } else {
            throw new BusinessException("文件不存在");
        }
    }

    @Override
    public SysFileVO getFile(BigInteger fileId) throws BusinessException {
        SysFile sysFile = sqlToyHelperDao.load(new SysFile().setId(fileId));
        if (sysFile == null) {
            throw new BusinessException("文件不存在");
        }
        return Convert.convert(SysFileVO.class, sysFile);
    }

    @Override
    public SysFileVO getUserFile(BigInteger fileId) throws BusinessException {
        SysFileVO sysFile = getFile(fileId);
        boolean isShare = sysFile.getIsShare() == IsEnum.Y.getCode().intValue();
        if (!isShare) {
            BigInteger loginId = LoginUtils.loginId();
            if (!String.valueOf(loginId).equals(sysFile.getCreateBy())) {
                throw new BusinessException("无权限查看");
            }
        }
        return sysFile;
    }

}