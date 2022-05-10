/**
 * 获取性别文本
 * @param num
 */
export function getSexText(num: string): string {
    let n = parseInt(num);
    switch (n) {
        case 0:
            return '<span class="status-tag-gray-text">未知</span>';
        case 1:
            return '<span class="status-tag-blue-text">男</span>';
        case 2:
            return '<span class="status-tag-red-text">女</span>';
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
            return '<span class="status-tag-red">停用</span>';
        case 1:
            return '<span class="status-tag-green">正常</span>';
        case 2:
            return '<span class="status-tag-blue">冻结</span>';
        case 3:
            return '<span class="status-tag-red">封禁</span>';
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

/**
 * 获取日志操作类型 文本
 * @param v
 */
export function getLogTypeText(v: string) {
    switch (parseInt(v)) {
        case 0:
            return '<span class="status-tag-green-text">登录日志</span>';
        case 1:
            return '<span class="status-tag-blue-text">操作日志</span>';
        default:
            return '';
    }
}

/**
 * 获取日志操作状态 文本
 * @param v
 */
export function getOperationStatusText(v: string) {
    switch (parseInt(v)) {
        case 0:
            return '<span class="status-tag-red">异常</span>';
        case 1:
            return '<span class="status-tag-green">成功</span>';
        default:
            return '';
    }
}

/**
 * 获取请求方式 文本
 * @param v
 */
export function getRequestWay(v: string) {
    switch (v) {
        case "GET":
            return '<span class="status-tag-green-text">GET</span>';
        case "POST":
            return '<span class="status-tag-blue-text">POST</span>';
        case "PUT":
            return '<span class="status-tag-yellow-text">PUT</span>';
        case "DELETE":
            return '<span class="status-tag-red-text">DELETE</span>';
        default:
            return v;
    }
}
