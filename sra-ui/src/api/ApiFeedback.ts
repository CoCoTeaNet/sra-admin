import {ElMessage} from "element-plus";

/**
 * api请求反馈模板
 * @param apiFn api函数
 * @param successMsg 成功消息
 * @param errorMsg 失败消息
 * @param successCallback 成功回调
 */
export function reqFeedback(apiFn: any, successMsg: string, errorMsg: string, successCallback: Function) {
    apiFn.then((res: any) => {
        if (res.code === 200) {
            if (successMsg) {
                ElMessage.success(successMsg);
            }
            successCallback(res.data);
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
        ElMessage.error(e);
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