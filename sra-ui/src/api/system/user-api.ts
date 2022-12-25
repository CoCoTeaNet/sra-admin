import {request} from '@/utils/axios-util';

/**
 * 增加一名用户
 * @param data
 */
export function add(data: any) {
    return request('system/user/add', data, 'POST');
}

/**
 * 删除一名用户
 * @param data
 * @returns {Promise<any>}
 */
export function deleteBatch(data: any) {
    return request('system/user/deleteBatch', data, 'POST');
}

/**
 * 更新用户
 * @param data
 * @returns {Promise<any>}
 */
export function update(data: any) {
    return request('system/user/update', data, 'POST');
}

/**
 * 分页获取用户
 * @param data
 * @returns {Promise<any>}
 */
export function listByPage(data: any) {
    return request('system/user/listByPage', data, 'POST');
}

/**
 * 用户获取个人详细信息
 */
export function getDetail() {
    return request('system/user/getDetail', {}, 'GET');
}
