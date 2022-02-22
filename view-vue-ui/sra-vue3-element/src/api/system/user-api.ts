import {request} from '@/utils/axios-util';

/**
 * 增加一名用户
 * @param data
 */
export function add(data: any) {
    return request('user/add', data, 'POST');
}
