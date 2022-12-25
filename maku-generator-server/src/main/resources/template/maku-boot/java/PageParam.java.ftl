package ${package}.${moduleName}.param.${className};

import ${package}.${moduleName}.vo.${ClassName}VO;
import org.sagacity.sqltoy.model.Page;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ${ClassName}PageParam extends Page<${ClassName}VO> implements Serializable {
    private static final long serial${ClassName}UID = -1L;

    @NotNull(message = "${className} is null")
    private ${ClassName}VO ${className};

    public ${ClassName}VO get${ClassName}() {
        return ${className};
    }

    public ${ClassName}PageParam set${ClassName}(${ClassName}VO ${className}) {
        this.${className} = ${className};
        return this;
    }
}