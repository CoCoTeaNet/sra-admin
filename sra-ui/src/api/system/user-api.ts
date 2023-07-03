import {request, post, get} from '@/utils/axios-util';

/**
 * 增加一名用户
 * @param data
 */
export function add(data: any) {
    return request('system/user/add', data, post);
}

/**
 * 删除一名用户
 * @param data
 * @returns {Promise<any>}
 */
export function deleteBatch(data: any) {
    return request('system/user/deleteBatch', data, post);
}

/**
 * 更新用户
 * @param data
 * @returns {Promise<any>}
 */
export function update(data: any) {
    return request('system/user/update', data, post);
}

/**
 * 分页获取用户
 * @param data
 * @returns {Promise<any>}
 */
export function listByPage(data: any) {
    return request('system/user/listByPage', data, post);
}

/**
 * 用户获取个人详细信息
 */
export function getDetail() {
    return request('system/user/getDetail', {}, get);
}

/**
 * 修改个人密码
 * @param data
 * @returns {Promise<any>}
 */
export function doModifyPassword(data: any) {
    return request('system/user/doModifyPassword', data, post);
}