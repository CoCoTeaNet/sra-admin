import {request, get, post} from '@/utils/axios-util';

/**
 * 根据表名称生成实体类属性集合
 * @param data
 */
export function getByTableName(data: any) {
    return request(`codeGenerator/getByTableName?tableName=${data.tableName}&dbName=${data.dbName}&type=${data.type}`, {}, get);
}

/**
 * 分页获取表名称
 * @param data
 */
export function findTablesByPage(data: any) {
    return request('codeGenerator/findTablesByPage', data, post);
}