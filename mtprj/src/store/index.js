import { createStore } from "vuex";
import { step1 } from "./step/step1";
import { step2 } from "./step/step2";
import { product } from "./order/product";
import { company } from "./order/company";

export const store = createStore({
  modules: {
    step1: step1,
    step2: step2,
    product : product,
    company : company,
  },
});
