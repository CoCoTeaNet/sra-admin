package net.cocotea.admin.system.param.login;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @date 2022-1-15 16:57:57
 * @author jwss
 */
public class CaptchaParam implements Serializable {
    private static final long serialVersionUID = 8511400433671973527L;

    @NotBlank(message = "验证码类型为空")
    private String codeType;

    private String otherParam;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getOtherParam() {
        return otherParam;
    }

    public void setOtherParam(String otherParam) {
        this.otherParam = otherParam;
    }
}
