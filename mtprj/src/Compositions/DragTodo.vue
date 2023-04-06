<template>
  <div style="height: 10vh">
    <div class="input-container">
      <select :value="com" @change="setSelectCom($event)" class="input-todo">
        <option v-for="(item, id) in company" :key="id" :value="item.id">
          {{ item.cname }}
        </option>
      </select>
      <select :value="pro" class="input-todo2" @change="setSelectPro($event)">
        <option v-for="(item, index) in proList" :key="index" :value="item.id">
          {{ item.pname }}
        </option>
      </select>
      <div class="input-button" v-on:click="getStep2">입력</div>
    </div>
    <div class="save-container">
      <div class="save-todo">공정 저장</div>
    </div>
    <div class="todo-list-bar">
      <div class="category">카테고리 추가</div>
      <div class="title">Todo <span style="color: #6f00cc">List</span></div>
      <div class="calendar-button">캘린더</div>
    </div>
  </div>
  <div v-if="step2Data != null"><DargMainVue :step2Data="step2Data" /></div>
</template>

<script>
import DargMainVue from "./TodoFolder/DargMain.vue";
import { computed, onMounted, watch, ref } from "vue";
import { useStore } from "vuex";
import { axiosGet } from "./modules/axios.js";
export default {
  components: {
    DargMainVue,
  },
  data() {
    return {
      com: "",
      pro: "",
      proList: [],
      step2List: [],
    };
  },
  setup() {
    const store = useStore();
    const company = computed(() => store.getters.company);
    const product = computed(() => store.getters.product);
    const step2Data = ref(computed(() => store.getters.step2_data));

    onMounted(() => {
      axiosGet("/company", (data) => {
        store.dispatch("setCompanyData", data);
      });
      axiosGet("/product", (data) => {
        store.dispatch("setProductData", data);
      });
    });

    return { company, product, step2Data, store };
  },
  methods: {
    setSelectCom(event) {
      this.com = event.target.value;
      this.proList = this.product.filter(
        (pro) => pro.company.id == event.target.value
      );
    },
    setSelectPro(event) {
      this.pro = event.target.value;
    },
    getStep2() {
      if (this.com != "" && this.pro != "") {
        let url = "/orderProcess/" + this.com + "/" + this.pro;
        axiosGet(url, (data) => {
          console.log(data);
          this.store.dispatch("setStep2Data", data);
        });
      } else {
        alert("회사와 제품을 선택하세요!");
      }
    },
  },
};
</script>

<style>
.input-container {
  width: 15%;
  height: 6vh;
  margin: 0;
  float: left;
}
.input-todo {
  width: 32%;
  height: 6vh;
  float: left;
  border-radius: 0.8vh 0 0 0.8vh;
  border: 2px solid #e8f4ff;
  border-right: none;
  text-align: center;
  background-color: #ebf5ff;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
}
.input-todo2 {
  width: 32%;
  height: 6vh;
  float: left;
  border: 2px solid #e8f4ff;
  border-right: none;
  text-align: center;
  background-color: #ebf5ff;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
}
.input-button {
  width: 30%;
  height: 6vh;
  line-height: 6vh;
  float: left;
  color: white;
  font-size: 1.2rem;
  background-color: #6f00cc;
  border-radius: 0 0.8vh 0.8vh 0;
  cursor: pointer;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
}
/* 저장 */
.save-container {
  width: 15%;
  height: 6vh;
  margin: 0;
  float: left;
  margin-left: 3%;
}
.save-todo {
  width: 95%;
  height: 5.4vh;
  float: left;
  border-radius: 0.8vh;
  border: 2px solid #6f00cc;
  border-right: none;
  background-color: #6f00cc;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
  cursor: pointer;
  line-height: 5.4vh;
  color: white;
}
/* 메인 바 */
.todo-list-bar {
  width: 56%;
  height: 6vh;
  margin: 0;
  border: 1px solid #e8f4ff;
  float: left;
  margin-left: 3%;
  border-radius: 0.8vh 0.8vh 0.8vh 0.8vh;
  background-color: #ebf5ff;
  line-height: 6vh;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
}
.category {
  float: left;
  border-radius: 0.8vh;
  color: #ebf5ff;
  background-color: #6f00cc;
  width: 20%;
  line-height: 6vh;
  font-size: 1rem;
  cursor: pointer;
}
.calendar-button {
  float: right;
  border-radius: 0.8vh;
  color: #ebf5ff;
  background-color: #6f00cc;
  width: 14%;
  font-size: 1rem;
  cursor: pointer;
}
.title {
  margin-left: 30%;
  float: left;
  font-family: "Montserrat", sans-serif;
  font-size: 1.2rem;
}
</style>