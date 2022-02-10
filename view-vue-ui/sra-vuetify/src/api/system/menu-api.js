import { request } from '@/utils/axios-util';

/**
 * 新增菜单
 */
export function add(data) {
    return request('menu/add', data, 'POST');
}

/**
 * 更新菜单
 * @param data
 * @returns {Promise<any>}
 */
export function update(data) {
    return request('menu/update', data, 'POST');
}

/**
 * 删除菜单
 * @param data
 * @returns {Promise<*>}
 */
export function del(data) {
    return request(`menu/delete/${data}`, null, 'POST');
}

/**
 * 菜单列表
 */
export function listByPage(data) {
    return request('menu/listByPage', data, 'POST');
}

/**
 * 菜单树
 */
export function listByTree(data) {
    return request(`menu/listByTree/${data}`, {}, 'GET');
}

/**
 * 通过角色获取菜单
 */
export function listByRoleId(data) {
    return request(`menu/listByRoleId/${data}`, {}, 'GET');
}
