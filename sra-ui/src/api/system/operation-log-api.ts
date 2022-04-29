import {request} from '@/utils/axios-util';

const operationLogApi = {
    listByPage: listByPage
};

/**
 * 分页获取日志
 * @param data
 */
export function listByPage (data: any) {
    return request('operationLog/listByPage', data, 'POST');
}

export default operationLogApi;