import {ElMessage} from "element-plus";
import {router} from "@/router";

/**
 * api状态返回值
 */
enum ApiResultEnum {
    /**
     * 成功
     */
    SUCCESS = 200,
    /**
     * 内部错误
     */
    ERROR = 500,
    /**
     * 未找到资源
     */
    NOT_FOUNT = 404,
    /**
     * 拒绝请求
     */
    REFUSE = 401,
    /**
     * 未登录
     */
    NOT_LOGIN = 4001,
    /**
     * 无权限访问
     */
    NOT_PERMISSION = 4002,
    /**
     * token失效
     */
    TOKEN_INVALID = 4003
}

/**
 * api请求反馈模板
 * @param apiFn api函数
 * @param successMsg 成功消息
 * @param errorMsg 失败消息
 * @param successCallback 成功回调
 */
export function reqFeedback(apiFn: any, successMsg: string, errorMsg: string, successCallback: Function) {
    apiFn.then((res: any) => {
        if (res.code === ApiResultEnum.SUCCESS) {
            if (successMsg) {
                ElMessage.success(successMsg);
            }
            successCallback(res.data);
        } else if (res.code === ApiResultEnum.NOT_LOGIN || res.code === ApiResultEnum.TOKEN_INVALID) {
            router.push({path: '/login'}).then(r => ElMessage({
                message: res.message,
                type: 'warning',
            }));
            // 清除本地用户信息
            localStorage.removeItem("userInfo");
        } else {
            if (errorMsg) {
                ElMessage.error(errorMsg);
                return;
            }
            if (!res.data) {
                ElMessage.error(res.message);
            } else {
                ElMessage.error(res.data);
            }
        }
    }).catch((e: any) => {
        console.log(e)
    });
}

export function reqSuccessFeedback(apiFn: any, msg: string, successCallback: Function) {
    reqFeedback(apiFn, msg, '', successCallback);
}

/**
 * 常用api请求反馈模板
 */
export function reqCommonFeedback(apiFn: any, successCallback: Function) {
    reqFeedback(apiFn, '', '', successCallback);
}