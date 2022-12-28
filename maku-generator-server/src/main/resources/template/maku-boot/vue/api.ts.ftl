import {request, post} from '@/utils/axios-util';

export function add(data: any) {
	return request('${moduleName}/${functionName}/add', data, post);
}

export function deleteBatch(data: any) {
	return request('${moduleName}/${functionName}/deleteBatch', data, post);
}

export function update(data: any) {
	return request('${moduleName}/${functionName}/update', data, post);
}

export function listByPage(data: any) {
	return request('${moduleName}/${functionName}/listByPage', data, post);
}
