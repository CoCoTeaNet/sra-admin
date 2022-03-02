import {request} from '@/utils/axios-util';

/**
 * 新增角色
 */
export function add(data: any) {
    return request('role/add', data, 'POST');
}

/**
 * 删除角色
 */
export function del(data: any) {
    return request(`role/delete/${data}`, {}, 'POST');
}

/**
 * 更新角色
 */
export function update(data: any) {
    return request('role/update', data, 'POST');
}

/**
 * 分页获取角色
 */
export function listByPage(data: any) {
    return request('role/listByPage', data, 'POST');
}

/**
 * 给角色分配权限
 */
export function grantPermissionsByRoleId(data: any) {
    return request('role/grantPermissionsByRoleId', data, 'POST');
}
