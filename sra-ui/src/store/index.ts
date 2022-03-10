import {InjectionKey} from 'vue'
import {createStore, Store, useStore as baseUseStore} from 'vuex'

export interface State {
    // 用户信息
    userInfo: UserModel,
    // 是否折叠菜单
    isCollapseMenu: boolean
}

export const key: InjectionKey<Store<State>> = Symbol()

export const store = createStore<State>({
    state: {
        userInfo: {
            id: '',
            username: '',
            nickname: '',
            token: '',
            loginStatus: false,
            menuList: []
        },
        isCollapseMenu: false
    }
})

// 定义自己的 `useStore` 组合式函数
export function useStore() {
    return baseUseStore(key)
}

/**
 * 设置用户信息
 * @param v 用户模型
 */
export function setUserInfo(v: UserModel) {
    store.state.userInfo = v;
    localStorage.setItem("userInfo", JSON.stringify(v));
}

/**
 * 设置是否折叠菜单
 */
export function setCollapseMenu() {
    store.state.isCollapseMenu = !store.state.isCollapseMenu;
}