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
      <div class="save-todo" v-on:click="saveStep2">공정 저장</div>
    </div>
    <div class="todo-list-bar">
      <div class="category" v-on:click="saveStep3">최종 공정 저장</div>
      <div class="title">Todo <span style="color: #6f00cc">List</span></div>
      <div class="calendar-button">캘린더</div>
    </div>
  </div>
  <div v-if="step2Data != null">
    <DargMainVue
      :step2Data="step2Data"
      :category="category"
      :step3List="step3List"
    />
  </div>
</template>

<script>
import DargMainVue from "./TodoFolder/DargMain.vue";
import { computed, onMounted, ref } from "vue";
import { useStore } from "vuex";
import {
  axiosGet,
  axiosPostMachine,
  axiosPostOrderProcess,
} from "./modules/axios.js";
export default {
  components: {
    DargMainVue,
  },
  data() {
    return {
      com: "",
      pro: "",
      proList: [],
      category: [],
      step3List: [],
    };
  },
  setup() {
    const store = useStore();
    const company = computed(() => store.getters.company);
    const product = computed(() => store.getters.product);

    var step2Data = ref(computed(() => store.getters.step2_data));
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
    saveStep3() {
      let url = 0;
      let obj = {};
      this.step3List.forEach((data) => {
        obj.mname = data.name;
        obj.pc_id = this.pro;
        data.items.forEach((d) => {
          obj.o_id = d.oid;
          console.log(obj);
          url = d.id ? d.id : url;
          axiosPostMachine(`/machine/${url}`, obj);
          url = 0;
        });
      });
      alert("step3 저장 성공");
    },
    getStep2() {
      if (this.com != "" && this.pro != "") {
        let url = "/orderProcess/" + this.pro + "/" + this.com;
        console.log("pro:" + this.pro, this.com);

        axiosGet(url, (data) => {
          this.Step2Data = [];
          console.log(data);
          this.store.dispatch("setStep2Data", data);
        });

        this.category = [];
        this.step3List = [];
        let mnames = new Set();

        url = "/machine/" + this.pro;

        axiosGet(url, (data) => {
          console.log(data);

          data.forEach((element) => {
            if (element.mname != null) {
              mnames.add(element.mname);
            }
          });

          let idx = 0;
          mnames.forEach((mn) => {
            let step3 = {};
            step3.index = idx;
            step3.name = mn;
            step3.items = [];
            this.step3List.push(step3);

            let obj = {};
            obj.name = mn;
            this.category.push(obj);

            idx++;
          });

          data.forEach((element) => {
            let idx = 0;
            this.step3List.forEach((list) => {
              let obj = {};
              this.step2Data.forEach((el) => {
                if (
                  (element.mname == list.name) &
                  (element.orderProcess != null)
                ) {
                  if (element.orderProcess.id == el.oid) {
                    obj.job = el.job;
                    obj.oid = element.orderProcess.id;
                    obj.id = el.mid;
                    obj.schedule = element.schedule;
                    this.step3List[idx].items.push(obj);
                  }
                }
              });
              idx++;
            });
          });

          console.log(this.step3List);
          alert("조회 성공");
        });
      } else {
        alert("회사와 제품을 선택하세요!");
      }
    },
    saveStep2() {
      this.step2Data.forEach((data) => {
        let obj = {};
        let url = data.oid ? data.oid : 0;
        obj.pcid = data.prid ? data.prid : data.id;
        obj.p_id = this.pro;
        obj.idx = this.step2Data.indexOf(data);
        axiosPostOrderProcess(`/orderProcess/${url}`, obj);
      });
      alert("step2 저장 성공, 새로고침 후 step3 등록 요망");
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