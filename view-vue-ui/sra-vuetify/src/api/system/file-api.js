import { request } from '@/utils/axios-util';

/**
 * 获取验证码
 */
export function verificationCode(data) {
    return request('file/verificationCode', data, 'POST');
}