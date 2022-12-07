import { http } from '@/utils/http/axios';

const post = 'POST';

/**
 * 分页获取日志
 * @param params
 */
export function listByPage(params: any) {
  return http.request({
    url: '/system/operationLog/listByPage',
    method: post,
    params,
  });
}
