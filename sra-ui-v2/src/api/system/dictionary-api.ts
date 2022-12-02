import { http } from '@/utils/http/axios';

const post = 'POST';

/**
 * 新增菜单
 */
export function add(params: any) {
  return http.request({
    url: 'system/dictionary/add',
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
    url: 'system/dictionary/update',
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
    url: 'system/dictionary/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 菜单列表
 */
export function listByPage(params: any) {
  return http.request({
    url: 'system/dictionary/listByPage',
    method: post,
    params,
  });
}

/**
 * 菜单树
 */
export function listByTree(params: any) {
  return http.request({
    url: 'system/dictionary/listByTree',
    method: post,
    params,
  });
}
