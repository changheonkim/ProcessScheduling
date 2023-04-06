export const company = {
  state: () => ({
    company: [],
  }),
  getters: {
    company: (state) => {
      return state.company;
    },
  },
  mutations: {
    SET_CDATA(state, data) {
      state.company = data;
    },
  },
  actions: {
    setCompanyData: ({ commit }, data) => {
      if (data != null) {
        commit("SET_CDATA", data);
      }
    },
  },
};
