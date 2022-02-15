/**
 * 获取性别文本
 * @param num
 */
export function getSexText(num) {
    num = parseInt(num);
    switch (num) {
        case 0: return '未知';
        case 1: return '男';
        case 2: return '女';
    }
    return 'fail';
}

/**
 * 获取账号状态文本
 * @param num
 */
export function getAccountStatusText(num) {
    num = parseInt(num);
    switch (num) {
        case 0: return '停用';
        case 1: return '正常';
        case 2: return '冻结';
        case 3: return '封禁';
    }
    return 'fail';
}