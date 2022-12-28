import {request, post} from '@/utils/axios-util';

export function add(data: any) {
	return request('system/file/add', data, post);
}

export function deleteBatch(data: any) {
	return request('system/file/deleteBatch', data, post);
}

export function update(data: any) {
	return request('system/file/update', data, post);
}

export function listByPage(data: any) {
	return request('system/file/listByPage', data, post);
}
