import { http } from '@/utils/http/axios';

const post = 'POST';
const get = 'GET';

/**
 * 新增文章
 */
export function add(params: any) {
  return http.request({
    url: 'cms/article/add',
    method: post,
    params,
  });
}

/**
 * 更新文章
 * @returns {Promise<any>}
 * @param params
 */
export function update(params: any) {
  return http.request({
    url: 'cms/article/update',
    method: post,
    params,
  });
}

/**
 * 批量删除文章
 * @returns {Promise<*>}
 * @param params
 */
export function deleteBatch(params: any) {
  return http.request({
    url: 'cms/article/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 文章列表
 */
export function listByPage(params: any) {
  return http.request({
    url: 'cms/article/listByPage',
    method: post,
    params,
  });
}

/**
 * 文章详细
 */
export function detail(params: any) {
  return http.request({
    url: 'cms/article/detail',
    method: get,
    params,
  });
}
