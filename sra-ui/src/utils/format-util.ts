/**
 * 获取性别文本
 * @param num
 */
export function getSexText(num: string): string {
    let n = parseInt(num);
    switch (n) {
        case 0:
            return '未知';
        case 1:
            return '男';
        case 2:
            return '女';
    }
    return 'fail';
}

/**
 * 获取账号状态文本
 * @param num
 */
export function getAccountStatusText(num: string): string {
    let n = parseInt(num);
    switch (n) {
        case 0:
            return '停用';
        case 1:
            return '正常';
        case 2:
            return '冻结';
        case 3:
            return '封禁';
    }
    return 'fail';
}

/**
 * 获取菜单类型文本
 * @param v
 */
export function getMenuTypeText(v: string): string {
    switch (parseInt(v)) {
        case 0:
            return '目录';
        case 1:
            return '菜单';
        case 2:
            return '按钮';
        default:
            return 'fail';
    }
}

/**
 * 获取是否文本
 * @param v
 */
export function getIsSomethingText(v: string) {
    switch (parseInt(v)) {
        case 0:
            return '<span class="status-tag-green">是</span>';
        case 1:
            return '<span class="status-tag-red">否</span>';
        default:
            return '未知';
    }
}

/**
 * 获取 菜单状态 文本
 * @param v
 */
export function getMenuStatusText(v: string) {
    switch (parseInt(v)) {
        case 0:
            return '显示&启用';
        case 1:
            return '隐藏&启用';
        case 2:
            return '显示&关闭';
        default:
            return '隐藏&关闭';
    }
}