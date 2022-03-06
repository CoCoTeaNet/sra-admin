import { request } from '@/utils/axios-util';

/**
 * 获取验证码
 */
export function index(data) {
    return request('test/index', data, 'GET');
}