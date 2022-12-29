import {request, post} from '@/utils/axios-util';

export function deleteBatch(data: any) {
	return request('system/file/deleteBatch', data, post);
}

export function listByPage(data: any) {
	return request('system/file/listByPage', data, post);
}
