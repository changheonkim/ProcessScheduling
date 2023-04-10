<template>
  <div class="container">
    <div class="step1">
      <draggable
        class="list-group"
        :list="step1Data"
        :group="{ name: 'people', pull: 'clone', put: false }"
        itemKey="name"
      >
        <template #item="{ element }">
          <div class="st1-do">{{ element.job }}</div>
        </template>
      </draggable>
    </div>
    <div class="step2">
      <draggable
        class="list-group"
        :list="step2Data"
        :group="{ name: 'people', pull: 'clone' }"
        itemKey="job"
      >
        <template #item="{ element, index }">
          <div v-if="element.job != null" class="st2-do">
            {{ element.job }}
            <span class="del_button" v-on:click="delStep2(index)">X</span>
          </div>
        </template>
      </draggable>
    </div>
    <div class="step3">
      <div class="cate-border">
        <div :list="category">
          <div v-for="element in category" :key="element.name" class="layout">
            <div v-if="element.name != null" class="cate">
              {{ element.name }}
            </div>
          </div>
        </div>
      </div>
      <div :list="step3List" class="step3-border">
        <div v-for="row in step3List" :key="row.index" class="layout">
          <div>
            <draggable :list="row.items" group="people" itemKey="name">
              <template #item="{ element }">
                <div v-if="element.name != null" class="st3-do">
                  {{ element.name }}
                </div>
              </template>
            </draggable>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
  
<script >
import draggable from "vuedraggable";
import { computed, onMounted } from "vue";
import { useStore } from "vuex";
import { axiosDelete, axiosGet } from "../modules/axios.js";
export default {
  components: {
    draggable,
  },
  props: ["step2Data", "category", "step3List"],
  setup() {
    const store = useStore();
    const step1Data = computed(() => store.getters.step1_data);

    onMounted(() => {
      axiosGet("/process", (data) => {
        store.dispatch("setStep1Data", data);
      });
    });

    return { step1Data };
  },
  methods: {
    delStep2(idx) {
      if (this.step2Data[idx].oid) {
        axiosDelete(`/orderProcess/${this.step2Data[idx].oid}`);
        this.step2Data.splice(idx, 1);
      } else {
        this.step2Data.splice(idx, 1);
      }
    },
  },
  data() {
    return {
      drag: false,
    };
  },
};
</script>

<style>
.del_button {
  float: right;
  margin-right: 6%;
  display: inline;
}
.del_button:hover {
  color: red;
  font-size: 1.4em;
}
.container {
  width: 100%;
  height: 100%;
}
.step1 {
  width: 14%;
  height: 72vh;
  float: left;
}
.step2 {
  width: 14%;
  height: 72vh;
  margin-left: 4%;
  float: left;
}
.step3 {
  width: 56%;
  height: 72vh;
  margin-left: 4%;
  float: left;
}
.cate {
  width: 100%;
  border: 1px solid #6a5acd;
  height: 6%;
  background-color: #6a5acd;
  color: white;
  border-radius: 0.8vh;
  cursor: pointer;
  line-height: 4vh;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
  margin-bottom: 6%;
}
.cate-border {
  width: 20%;
  height: 72vh;
  margin-right: 2.4%;
  /* border: 1px solid black; */
  float: left;
}

.step3-border {
  width: 76%;
  height: 72vh;
  /* border: 1px solid black; */
  float: left;
}
.layout {
  display: flex;
  flex-direction: column;
  margin-bottom: 2%;
}

.st1-do {
  width: 100%;
  border: 1px solid #e8f4ff;
  height: 6%;
  background-color: #e8f4ff;
  border-radius: 0.8vh;
  cursor: pointer;
  line-height: 4vh;
  margin-top: 4%;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
}
.st2-do {
  width: 100%;
  border: 1px solid #e8f4ff;
  height: 6%;
  background-color: #e8f4ff;
  border-radius: 0.8vh;
  cursor: pointer;
  line-height: 4vh;
  margin-top: 4%;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
  text-align: center;
}
.st3-do {
  width: 12%;
  border: 1px solid #e8f4ff;
  height: 6%;
  background-color: #e8f4ff;
  border-radius: 0.8vh;
  cursor: pointer;
  line-height: 4vh;
  float: left;
  margin-left: 1%;
  font-size: 30%;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
}
</style>