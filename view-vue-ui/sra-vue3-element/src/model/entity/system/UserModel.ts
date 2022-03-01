interface UserModel {
    id: string,
    username: string,
    nickname: string,
    token: string,
    loginStatus: boolean,
    menuList: MenuModel[]
}