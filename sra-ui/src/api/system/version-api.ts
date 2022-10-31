import {request} from '@/utils/axios-util';

/**
 * 增加一名版本
 * @param data
 */
export function add(data: any) {
    return request('version/add', data, 'POST');
}

/**
 * 删除一名版本
 * @param data
 * @returns {Promise<any>}
 */
export function deleteBatch(data: any) {
    return request('version/deleteBatch', data, 'POST');
}

/**
 * 更新版本
 * @param data
 * @returns {Promise<any>}
 */
export function update(data: any) {
    return request('version/update', data, 'POST');
}

/**
 * 分页获取版本
 * @param data
 * @returns {Promise<any>}
 */
export function listByPage(data: any) {
    return request('version/listByPage', data, 'POST');
}

