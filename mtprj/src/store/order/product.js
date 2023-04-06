export const product = {
  state: () => ({
    product: [],
  }),
  getters: {
    product: (state) => {
      return state.product;
    },
  },
  mutations: {
    SET_PDATA(state, data) {
      state.product = data;
    },
  },
  actions: {
    setProductData: ({ commit }, data) => {
      if (data != null) {
        commit("SET_PDATA", data);
      }
    },
  },
};
