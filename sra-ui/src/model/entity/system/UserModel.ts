/**
 * 用户模型
 */
interface UserModel {
    id: string,
    username: string,
    nickname: string,
    email?: string,
    sex?: string,
    accountStatus?: string,
    roleId?: string,
    roleName?: string,
    password?: string,
    token?: string,
    loginStatus?: boolean,
    menuList?: MenuModel[]
}