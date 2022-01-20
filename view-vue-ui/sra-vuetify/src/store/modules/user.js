// initial state
const state = () => ({
    userInfo: {
        loginStatus: false,
        permissions: [],
        userDetail: {},
        token: 'sa-token',
    }
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
    },
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}