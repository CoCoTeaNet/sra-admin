import { request } from '@/utils/axios-util';

/**
 * 增加一名用户
 */
export function add(data) {
    return request('user/add', data, 'POST');
}

/**
 * 删除一名用户
 * @param data
 * @returns {Promise<any>}
 */
export function del(data) {
    return request(`user/delete/${data}`, {}, 'POST');
}

/**
 * 更新用户
 * @param data
 * @returns {Promise<any>}
 */
export function update(data) {
    return request('user/update', data, 'POST');
}

/**
 * 分页获取用户
 * @param data
 * @returns {Promise<any>}
 */
export function listByPage(data) {
    return request('user/listByPage', data, 'POST');
}

/**
 * 用户登录
 */
export function login(data) {
    return request('user/login', data, 'POST');
}

/**
 * 用户退出登录
 * @returns {Promise<*>}
 */
export function logout() {
    return request('user/logout', {}, 'POST');
}

/**
 * 记录用户在线状态
 */
export function online() {
    return request('user/online', {}, 'POST');
}