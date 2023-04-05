import { createStore } from "vuex";
import { step1 } from './step/step1'

export const store = createStore({
    modules: {
        step1: step1,
    }
})