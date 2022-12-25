import {request, post} from '@/utils/axios-util';

export function add(data: any) {
	return request('${moduleName}/${className}/add', data, post);
}

export function deleteBatch(data: any) {
	return request('${moduleName}/${className}/deleteBatch', data, post);
}

export function update(data: any) {
	return request('${moduleName}/${className}/update', data, post);
}

export function listByPage(data: any) {
	return request('${moduleName}/${className}/listByPage', data, post);
}
