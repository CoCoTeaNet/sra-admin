import { http } from '@/utils/http/axios';

const post = 'POST';

/**
 * 新增角色
 */
export function add(params: any) {
  return http.request({
    url: 'system/role/add',
    method: post,
    params,
  });
}

/**
 * 批量删除角色
 */
export function deleteBatch(params: any) {
  return http.request({
    url: 'system/role/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 更新角色
 */
export function update(params: any) {
  return http.request({
    url: 'system/role/update',
    method: post,
    params,
  });
}

/**
 * 分页获取角色
 */
export function listByPage(params: any) {
  return http.request({
    url: 'system/role/listByPage',
    method: post,
    params,
  });
}

/**
 * 给角色分配权限
 */
export function grantPermissionsByRoleId(params: any) {
  return http.request({
    url: 'system/role/grantPermissionsByRoleId',
    method: post,
    params,
  });
}
