package net.cocotea.admin.api.system.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.sagframe.sagacity.sqltoy.plus.conditions.Wrappers;
import com.sagframe.sagacity.sqltoy.plus.conditions.query.LambdaQueryWrapper;
import com.sagframe.sagacity.sqltoy.plus.dao.SqlToyHelperDao;
import net.cocotea.admin.api.system.model.dto.SysNotifyAddDTO;
import net.cocotea.admin.api.system.model.po.SysNotify;
import net.cocotea.admin.api.system.model.vo.SysNotifyVO;
import net.cocotea.admin.api.system.service.SysNotifyService;
import net.cocotea.admin.common.enums.IsEnum;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.util.LoginUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Service
public class SysNotifyServiceImpl implements SysNotifyService {

    private final Logger logger = LoggerFactory.getLogger(SysNotifyServiceImpl.class);

    @Resource
    private SqlToyHelperDao sqlToyHelperDao;

    @Override
    public void addNotify(SysNotifyAddDTO addDTO) throws BusinessException {
        boolean isGlobal = addDTO.getIsGlobal() == IsEnum.Y.getCode().intValue();
        LambdaQueryWrapper<SysNotify> lambdaWrapper = Wrappers.lambdaWrapper(SysNotify.class)
                .eq(SysNotify::getTitle, addDTO.getTitle())
                .eq(SysNotify::getIsDeleted, IsEnum.N.getCode());
        if (isGlobal) {
            lambdaWrapper.eq(SysNotify::getIsGlobal, IsEnum.Y.getCode());
        } else {
            if (addDTO.getReceiver() == null) {
                throw new BusinessException("非全局消息时，接收人必填");
            }
            lambdaWrapper
                    .eq(SysNotify::getIsGlobal, IsEnum.N.getCode())
                    .eq(SysNotify::getReceiver, addDTO.getReceiver());
        }
        SysNotify sysNotify = Convert.convert(SysNotify.class, addDTO);
        SysNotify sysNotifyExist = sqlToyHelperDao.findOne(lambdaWrapper);
        if (sysNotifyExist == null) {
            sqlToyHelperDao.save(sysNotify);
        }
    }

    @Override
    public List<SysNotifyVO> listByType(String notifyType) {
        BigInteger loginId = LoginUtils.loginId();
        DateTime now = DateUtil.date();
        DateTime start = DateUtil.offsetDay(now, -30);
        LambdaQueryWrapper<SysNotify> lambdaWrapper = Wrappers.lambdaWrapper(SysNotify.class)
                .between(SysNotify::getNotifyTime, start, now)
                .eq(SysNotify::getReceiver, loginId)
                .eq(SysNotify::getIsDeleted, IsEnum.N.getCode())
                .orderByDesc(SysNotify::getId);
        List<SysNotify> list = sqlToyHelperDao.findList(lambdaWrapper);
        return Convert.toList(SysNotifyVO.class, list);
    }

    @Override
    public void read(BigInteger id) {
        sqlToyHelperDao.update(new SysNotify().setId(id).setIsDeleted(IsEnum.Y.getCode()));
    }

}
