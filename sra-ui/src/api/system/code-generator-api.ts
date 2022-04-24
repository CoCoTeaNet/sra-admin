import {request} from '@/utils/axios-util';

/**
 * 分页获取表名称
 * @param data
 */
export function findTablesByPage(data: any) {
    return request('codeGenerator/findTablesByPage', data, 'POST');
}