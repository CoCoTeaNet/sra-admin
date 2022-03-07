import {request} from '@/utils/axios-util';

/**
 * 获取验证码
 */
export function verificationCode(data: any) {
    return request('file/verificationCode', data, 'POST');
}