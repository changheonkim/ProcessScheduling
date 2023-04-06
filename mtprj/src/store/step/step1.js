export const step1 = {
  state: () => ({
    step1: [],
  }),
  getters: {
    step1_data: (state) => {
      return state.step1;
    },
  },
  mutations: {
    SET_S1DATA(state, data) {
      state.step1 = data;
    },
  },
  actions: {
    setStep1Data: ({ commit }, data) => {
      if (data != null) {
        commit("SET_S1DATA", data);
      }
    },
  },
};
