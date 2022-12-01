import { http } from '@/utils/http/axios';

const get = 'GET';

/**
 * 获取数量统计
 */
export function getCount(params: any) {
  return http.request({
    url: 'dashboard/getCount',
    method: get,
    params,
  });
}

/**
 * 获取系统信息
 */
export function getSystemInfo(params: any) {
  return http.request({
    url: 'dashboard/getSystemInfo',
    method: get,
    params,
  });
}
