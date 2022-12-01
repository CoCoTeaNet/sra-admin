import { http } from '@/utils/http/axios';

const post = 'POST';
const get = 'GET';

/**
 * 新增菜单
 */
export function add(params: any) {
  return http.request({
    url: 'menu/add',
    method: post,
    params,
  });
}

/**
 * 更新菜单
 * @returns {Promise<any>}
 * @param params
 */
export function update(params: any) {
  return http.request({
    url: 'menu/update',
    method: post,
    params,
  });
}

/**
 * 批量删除菜单
 * @returns {Promise<*>}
 * @param params
 */
export function deleteBatch(params: any) {
  return http.request({
    url: 'menu/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 菜单列表
 */
export function listByPage(params: any) {
  return http.request({
    url: 'menu/listByPage',
    method: post,
    params,
  });
}

/**
 * 菜单树
 */
export function listByTree(params: any) {
  return http.request({
    url: 'menu/listByTree',
    method: post,
    params,
  });
}

export function listByTreeAsRoleSelection(params: any) {
  return http.request({
    url: 'menu/listByTreeAsRoleSelection',
    method: post,
    params,
  });
}

/**
 * 通过角色获取菜单
 */
export function listByRoleId(params: any) {
  return http.request({
    url: `menu/listByRoleId/${params}`,
    method: get,
  });
}
