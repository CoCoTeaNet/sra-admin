import { http } from '@/utils/http/axios';

/**
 * @description: 获取登录验证码
 */
export function getCaptcha(params) {
  return http.request({
    url: '/system/captcha',
    method: 'post',
    params,
  });
}

/**
 * @description: 获取用户信息
 */
export function getUserInfo() {
  return http.request({
    url: '/system/loginInfo',
    method: 'get',
  });
}

/**
 * @description: 用户登录
 */
export function login(params) {
  return http.request(
    {
      url: '/system/login',
      method: 'POST',
      params,
    },
    {
      isTransformResponse: false,
    }
  );
}
