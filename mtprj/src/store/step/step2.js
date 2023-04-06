export const step2 = {
    state: () => ({
      step2: [],
    }),
    getters: {
      step2_data: (state) => {
        return state.step2;
      },
    },
    mutations: {
      SET_S2DATA(state, data) {
        state.step2 = data;
      },
    },
    actions: {
      setStep2Data: ({ commit }, data) => {
        if (data != null) {
          commit("SET_S2DATA", data);
        }
      },
    },
  };
  