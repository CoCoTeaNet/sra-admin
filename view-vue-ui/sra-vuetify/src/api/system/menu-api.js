import { request } from '@/utils/axios-util';

/**
 * 新增菜单
 */
export function add(data) {
    return request('menu/add', data, 'POST');
}

/**
 * 菜单列表
 */
export function listByPage(data) {
    return request('menu/listByPage', data, 'POST');
}