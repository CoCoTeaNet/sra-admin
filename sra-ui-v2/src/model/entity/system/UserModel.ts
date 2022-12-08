/**
 * 用户模型
 */
interface UserModel {
  id?: string;
  username?: string;
  nickname?: string;
  email?: string;
  sex?: number;
  accountStatus?: number;
  avatar?: string;
  roleId?: string;
  roleName?: string;
  password?: string;
  token?: string;
  loginStatus?: boolean;
  menuList?: MenuModel[];
}
