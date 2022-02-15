package com.jwss.sra.system.param.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @date 2022-1-15 16:57:57
 * @author jwss
 */
@ApiModel("验证码参数")
public class VerificationCodeParam implements Serializable {
    private static final long serialVersionUID = 8511400433671973527L;

    @NotBlank(message = "验证码类型为空")
    @ApiModelProperty(value = "验证码类型", required = true)
    private String codeType;

    @NotBlank(message = "验证码其它参数：例userId")
    @ApiModelProperty(value = "其它参数", required = true)
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
