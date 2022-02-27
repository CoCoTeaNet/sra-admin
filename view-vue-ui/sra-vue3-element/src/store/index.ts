import { InjectionKey } from 'vue'
import { createStore, useStore as baseUseStore, Store } from 'vuex'

export interface State {
    userInfo: UserModel
}

export const key: InjectionKey<Store<State>> = Symbol()

export const store = createStore<State>({
    state: {
        userInfo: {
            username: '',
            nickname: '',
            token: '',
            isLogin: false
        }
    }
})

// 定义自己的 `useStore` 组合式函数
export function useStore () {
    return baseUseStore(key)
}

export function setStore(v: UserModel) {
    store.state.userInfo = v;
}