import {request} from '@/utils/axios-util';

/**
 * 新增菜单
 */
export function add(data: any) {
    return request('menu/add', data, 'POST');
}

/**
 * 更新菜单
 * @param data
 * @returns {Promise<any>}
 */
export function update(data: any) {
    return request('menu/update', data, 'POST');
}

/**
 * 批量删除菜单
 * @param data
 * @returns {Promise<*>}
 */
export function deleteBatch(data: any) {
    return request('menu/deleteBatch', data, 'POST');
}

/**
 * 菜单列表
 */
export function listByPage(data: any) {
    return request('menu/listByPage', data, 'POST');
}

/**
 * 菜单树
 */
export function listByTree(data: any) {
    return request(`menu/listByTree/${data}`, {}, 'GET');
}

/**
 * 通过角色获取菜单
 */
export function listByRoleId(data: any) {
    return request(`menu/listByRoleId/${data}`, {}, 'GET');
}
