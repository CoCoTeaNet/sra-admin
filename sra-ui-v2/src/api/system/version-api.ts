import { http } from '@/utils/http/axios';

const post = 'POST';

/**
 * 增加一名版本
 * @param params
 */
export function listByTree(params: any) {
  return http.request({
    url: 'system/version/add',
    method: post,
    params,
  });
}

/**
 * 删除一名版本
 * @param params
 * @returns {Promise<any>}
 */
export function deleteBatch(params: any) {
  return http.request({
    url: 'system/version/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 更新版本
 * @param params
 * @returns {Promise<any>}
 */
export function update(params: any) {
  return http.request({
    url: 'system/version/update',
    method: post,
    params,
  });
}

/**
 * 分页获取版本
 * @param params
 * @returns {Promise<any>}
 */
export function listByPage(params: any) {
  return http.request({
    url: 'system/version/listByPage',
    method: post,
    params,
  });
}
