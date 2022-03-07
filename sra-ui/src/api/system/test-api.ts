import {request} from '@/utils/axios-util';

export function index(data: any) {
    return request('test/index', data, 'GET');
}