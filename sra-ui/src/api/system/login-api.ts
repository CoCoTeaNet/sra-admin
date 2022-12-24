import {request} from '@/utils/axios-util';

/**
 * 获取验证码
 */
export function getCaptcha(data: any) {
    return request('system/captcha', data, 'POST');
}


/**
 * 用户登录
 */
export function login(data: any) {
    return request('system/login', data, 'POST');
}

/**
 * 用户退出登录
 * @returns {Promise<*>}
 */
export function logout() {
    return request('system/logout', {}, 'POST');
}