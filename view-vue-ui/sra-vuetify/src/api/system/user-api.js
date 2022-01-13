import axiosUtil from '@/utils/axios-util';

/**
 * 增加一名用户
 */
export function add(data) {
    return axiosUtil('/user/add', data, 'POST');
}