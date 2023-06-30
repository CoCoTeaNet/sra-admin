package net.cocotea.admin.system.param.file;

import net.cocotea.admin.system.vo.SysFileVO;
import org.sagacity.sqltoy.model.Page;
import com.alibaba.fastjson.JSONObject;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SysFilePageParam extends Page<SysFileVO> implements Serializable {
    private static final long serialVersionUID = -1L;

    @NotNull(message = "sysFile is null")
    private SysFileVO file;

    public SysFileVO getFile() {
        return file;
    }

    public SysFilePageParam setFile(SysFileVO file) {
        this.file = file;
        return this;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}