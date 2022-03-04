/**
 * 菜单模型
 */
interface MenuModel {
    id: string,
    parentId: string,
    menuName: string,
    menuType: string,
    iconPath: string,
    routerPath: string,
    isExternalLink: string,
    isMenu: string,
    children: MenuModel[]
}