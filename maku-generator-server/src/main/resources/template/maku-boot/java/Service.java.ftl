package ${package}.${moduleName}.service;

import ${package}.${moduleName}.vo.${ClassName}VO;
import ${package}.${moduleName}.param.${functionName}.${ClassName}AddParam;
import ${package}.${moduleName}.param.${functionName}.${ClassName}PageParam;
import ${package}.${moduleName}.param.${functionName}.${ClassName}UpdateParam;
import ${package}.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

/**
 * ${tableComment}
 *
 * @author ${author} ${email}
 * @since ${version} ${date}
 */
public interface I${ClassName}Service extends IBaseService<Page<${ClassName}VO>, ${ClassName}PageParam, ${ClassName}AddParam, ${ClassName}UpdateParam> {
}