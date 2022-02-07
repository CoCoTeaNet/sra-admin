import axios from "axios";
import store from '@/store';

export async function request(url, data, method) {
    // 请求服务器
    let res = await axios.request({
            // `url` 是用于请求的服务器 URL
            url: `/api/${url}`,
            // `method` 是创建请求时使用的方法
            method: method, // 默认是 get
            // `transformRequest` 允许在向服务器发送前，修改请求数据
            // 只能用在 "PUT", "POST" 和 "PATCH" 这几个请求方法
            // 后面数组中的函数必须返回一个字符串，或 ArrayBuffer，或 Stream
            transformRequest: [function (data) {
                // 对 data 进行任意转换处理
                return JSON.stringify(data);
            }],
            // `transformResponse` 在传递给 then/catch 前，允许修改响应数据
            transformResponse: [function (data) {
                // 对 data 进行任意转换处理
                return JSON.parse(data);
            }],
            // `headers` 是即将被发送的自定义请求头
            headers: {
                "X-Requested-With": "XMLHttpRequest",
                'Content-Type': 'application/json;charset=utf-8',
                "satoken": store.state.user.userInfo ? store.state.user.userInfo.token : 'sa-token',
            },
            // `params` 是即将与请求一起发送的 URL 参数
            // 必须是一个无格式对象(plain object)或 URLSearchParams 对象
            params: method === 'GET' ? data : '',
            // `data` 是作为请求主体被发送的数据
            // 只适用于这些请求方法 "PUT", "POST", 和 "PATCH"
            // 在没有设置 `transformRequest` 时，必须是以下类型之一：
            // - string, plain object, ArrayBuffer, ArrayBufferView, URLSearchParams
            // - 浏览器专属：FormData, File, Blob
            // - Node 专属： Stream
            data: method === 'GET' ? null : data,
            // `timeout` 指定请求超时的毫秒数(0 表示无超时时间)
            // 如果请求花费了超过 `timeout` 的时间，请求将被中断
            timeout: 15000,
            // `withCredentials` 表示跨域请求时是否需要使用凭证
            withCredentials: false, // 默认的
            // `responseType` 表示服务器响应的数据类型，可以是 "arraybuffer", "blob", "document", "json", "text", "stream"
            responseType: "json", // 默认的
            // `maxContentLength` 定义允许的响应内容的最大尺寸
            maxContentLength: 2000,
            // `validateStatus` 定义对于给定的HTTP 响应状态码是 resolve 或 reject  promise 。
            // 如果 `validateStatus` 返回 `true` (或者设置为 `null` 或 `undefined`)，promise 将被 resolve;
            // 否则，promise 将被 rejecte
            validateStatus: function (status) {
                return status === 200 ? status : 500; // 默认的
            }
        }
    );
    // 判断请求状态
    if (res.data.code === 4001) {
        // 未登录
        window.location.href = '/login';
        localStorage.setItem("userInfo", null);
    }
    return res.data;
}