import { http } from '@/utils/http/axios';

const post = 'POST';

/**
 * 批量删除
 * @returns {Promise<*>}
 * @param params
 */
export function deleteBatch(params: any) {
  return http.request({
    url: 'schedule/jobLog/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 列表
 */
export function listByPage(params: any) {
  return http.request({
    url: 'schedule/jobLog/listByPage',
    method: post,
    params,
  });
}
