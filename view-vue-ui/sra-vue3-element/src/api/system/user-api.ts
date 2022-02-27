import {request} from '@/utils/axios-util';

/**
 * 增加一名用户
 * @param data
 */
export function add(data: any) {
    return request('user/add', data, 'POST');
}


/**
 * 删除一名用户
 * @param data
 * @returns {Promise<any>}
 */
export function del(data: any) {
    return request(`user/delete/${data}`, {}, 'POST');
}

/**
 * 更新用户
 * @param data
 * @returns {Promise<any>}
 */
export function update(data: any) {
    return request('user/update', data, 'POST');
}

/**
 * 分页获取用户
 * @param data
 * @returns {Promise<any>}
 */
export function listByPage(data: any) {
    return request('user/listByPage', data, 'POST');
}

/**
 * 用户登录
 */
export function login(data: any) {
    return request('user/login', data, 'POST');
}

/**
 * 用户退出登录
 * @returns {Promise<*>}
 */
export function logout() {
    return request('user/logout', {}, 'POST');
}
