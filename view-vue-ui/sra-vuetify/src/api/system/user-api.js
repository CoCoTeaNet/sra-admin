import { request } from '@/utils/axios-util';

/**
 * 增加一名用户
 */
export function add(data) {
    return request('user/add', data, 'POST');
}

/**
 * 用户登录
 */
export function login(data) {
    return request('user/login', data, 'POST');
}