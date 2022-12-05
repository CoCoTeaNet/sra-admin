import { http } from '@/utils/http/axios';

const post = 'POST';
const get = 'GET';

/**
 * 增加一名用户
 * @param params
 */
export function add(params: any) {
  return http.request({
    url: 'system/user/add',
    method: post,
    params,
  });
}

/**
 * 删除一名用户
 * @param params
 * @returns {Promise<any>}
 */
export function deleteBatch(params: any) {
  return http.request({
    url: 'system/user/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 更新用户
 * @param params
 * @returns {Promise<any>}
 */
export function update(params: any) {
  return http.request({
    url: 'system/user/update',
    method: post,
    params,
  });
}

/**
 * 分页获取用户
 * @param params
 * @returns {Promise<any>}
 */
export function listByPage(params: any) {
  return http.request({
    url: 'system/user/listByPage',
    method: post,
    params,
  });
}

/**
 * 用户获取个人详细信息
 */
export function getDetail(params: any) {
  return http.request({
    url: 'system/user/getDetail',
    method: get,
    params,
  });
}
