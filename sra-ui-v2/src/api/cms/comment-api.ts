import { http } from '@/utils/http/axios';

const post = 'POST';

/**
 * 新增评论
 */
export function add(params: any) {
  return http.request({
    url: 'cms/comment/add',
    method: post,
    params,
  });
}

/**
 * 更新评论
 * @returns {Promise<any>}
 * @param params
 */
export function update(params: any) {
  return http.request({
    url: 'cms/comment/update',
    method: post,
    params,
  });
}

/**
 * 批量删除评论
 * @returns {Promise<*>}
 * @param params
 */
export function deleteBatch(params: any) {
  return http.request({
    url: 'cms/comment/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 评论列表
 */
export function listByPage(params: any) {
  return http.request({
    url: 'cms/comment/listByPage',
    method: post,
    params,
  });
}
