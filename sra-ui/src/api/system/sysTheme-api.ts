import {request, post} from '@/utils/axios-util';

export function updateByUser(data: any) {
	return request('system/theme/updateByUser', data, post);
}
