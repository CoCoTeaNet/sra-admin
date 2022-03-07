/**
 * 密码规则
 * @returns {{rule: RegExp, message: string}}
 */
export function passwordRule() {
    return {rule: /(?=.*[0-9])(?=.*[a-zA-Z]).{6,30}/, message: '密码中必须包含字母、数字，至少6个字符，最多30个字符'}
}