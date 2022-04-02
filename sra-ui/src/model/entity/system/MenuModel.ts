/**
 * 菜单模型
 */
interface MenuModel {
    id: string,
    parentId?: string,
    menuName: string,
    menuType?: string,
    iconPath?: string,
    routerPath?: string,
    menuStatus?: string,
    isExternalLink?: string,
    isMenu: string,
    sort?: number,
    permissionCode?: string,
    children?: MenuModel[]
}