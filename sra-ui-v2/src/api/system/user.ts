import { http } from '@/utils/http/axios';

export interface BasicResponseModel<T = any> {
  code: number;
  message: string;
  result: T;
}

export interface BasicPageParams {
  pageNumber: number;
  pageSize: number;
  total: number;
}

/**
 * @description: 获取登录验证码
 */
export function getCaptcha(params) {
  return http.request({
    url: '/captcha',
    method: 'post',
    params
  });
}

/**
 * @description: 获取用户信息
 */
export function getUserInfo() {
  return http.request({
    url: '/loginInfo',
    method: 'get',
  });
}

/**
 * @description: 用户登录
 */
export function login(params) {
  return http.request<BasicResponseModel>(
    {
      url: '/login',
      method: 'POST',
      params,
    },
    {
      isTransformResponse: false,
    }
  );
}

/**
 * @description: 用户修改密码
 */
export function changePassword(params, uid) {
  return http.request(
    {
      url: `/user/u${uid}/changepw`,
      method: 'POST',
      params,
    },
    {
      isTransformResponse: false,
    }
  );
}

/**
 * @description: 用户登出
 */
export function logout(params) {
  return http.request({
    url: '/logout',
    method: 'POST',
    params,
  });
}
