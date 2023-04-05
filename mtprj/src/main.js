import { createApp } from "vue";
import App from "./App.vue";
import "./index.css";
import { store } from "./store/index.js";
const app = createApp(App);
app.use(store);
// provide로 최상위 객체인 app에서 today라는 날짜 변수를 모든 하위 항목에 제공한다.
app.mount("#app");
