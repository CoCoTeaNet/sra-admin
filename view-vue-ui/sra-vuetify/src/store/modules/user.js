import {online} from "@/api/system/user-api";

// initial state
const state = () => ({
    userInfo: {
        loginStatus: false,
        permissions: [],
        userDetail: {},
        token: 'sa-token',
    },
    onlineTimer: null
})

// getters
const getters = {}

// actions
const actions = {}

// mutations
const mutations = {
    /**
     * 配置用户信息
     * @param state
     * @param userInfo
     */
    setUserInfo(state, userInfo) {
        localStorage.setItem("userInfo", JSON.stringify(userInfo));
        state.userInfo = userInfo;
        if (userInfo) {
            state.onlineTimer = setInterval(() => {
                online().then(r => console.log(r.code));
            }, 29000);
        } else {
            clearInterval(state.onlineTimer);
            state.onlineTimer = null;
        }
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}