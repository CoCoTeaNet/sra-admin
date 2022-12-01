import { http } from '@/utils/http/axios';

const post = 'POST';

/**
 * 新增任务
 */
export function add(params: any) {
  return http.request({
    url: 'schedule/job/add',
    method: post,
    params,
  });
}

/**
 * 更新任务
 * @returns {Promise<any>}
 * @param params
 */
export function update(params: any) {
  return http.request({
    url: 'schedule/job/update',
    method: post,
    params,
  });
}

/**
 * 批量删除任务
 * @returns {Promise<*>}
 * @param params
 */
export function deleteBatch(params: any) {
  return http.request({
    url: 'schedule/job/deleteBatch',
    method: post,
    params,
  });
}

/**
 * 任务列表
 */
export function listByPage(params: any) {
  return http.request({
    url: 'schedule/job/listByPage',
    method: post,
    params,
  });
}

export function execute(params: any) {
  return http.request({
    url: 'schedule/job/execute',
    method: post,
    params,
  });
}

export function queryProgress(params: any) {
  return http.request({
    url: 'schedule/job/queryProgress',
    method: post,
    params,
  });
}
