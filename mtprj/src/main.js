import { createApp } from "vue";
import App from "./App.vue";
import "./index.css";

const app = createApp(App);
app.provide("today", new Date().toISOString().split("T")[0]);
// provide로 최상위 객체인 app에서 today라는 날짜 변수를 모든 하위 항목에 제공한다.
app.mount("#app");
