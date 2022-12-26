import {post, request} from '@/utils/axios-util';

const operationLogApi = {
    listByPage: listByPage,
    deleteBatch: deleteBatch
};

/**
 * 分页获取日志
 * @param data
 */
export function listByPage (data: any) {
    return request('system/operationLog/listByPage', data, 'POST');
}


/**
 * 批量删除日志
 * @param data
 * @returns {Promise<*>}
 */
export function deleteBatch(data: any) {
    return request('system/operationLog/deleteBatch', data, post);
}

export default operationLogApi;