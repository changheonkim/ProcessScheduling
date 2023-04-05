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
        :list="list2"
        group="people"
        @change="log"
        itemKey="name"
      >
        <template #item="{ element }">
          <div class="st1-do">{{ element.job }}</div>
        </template>
      </draggable>
    </div>
    <div class="step3">
      <div class="cate-border">
        <div :list="categorys">
          <div v-for="element in categorys" :key="element.name" class="layout">
            <div class="cate">
              {{ element.name }}
            </div>
          </div>
        </div>
      </div>
      <div :list="list3" class="step3-border">
        <div v-for="row in list3" :key="row.index" class="layout">
          <div>
            <draggable
              :list="row.items"
              group="people"
              @change="log"
              itemKey="name"
            >
              <template #item="{ element }">
                <div class="st3-do">
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
import { axiosGet } from "../modules/axios.js";
export default {
  components: {
    draggable,
  },
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
    log(evt) {
      console.log(evt.added.element);
    },
  },
  data() {
    return {
      drag: false,
      categorys: [{ name: "A" }, { name: "B" }, { name: "c" }],
      list1: [
        { name: "John", id: 1 },
        { name: "Joao", id: 2 },
        { name: "Jean", id: 3 },
        { name: "Gerard", id: 4 },
      ],
      list2: [],
      list3: [
        {
          index: 1,
          items: [
            { name: "Juan", id: 5 },
            { name: "Edgard", id: 6 },
            { name: "Johnson", id: 7 },
          ],
        },
        {
          index: 2,
          items: [
            { name: "Jua1n", id: 5 },
            { name: "Edgard12323", id: 6 },
            { name: "Johnson", id: 7 },
          ],
        },
        {
          index: 3,
          items: [
            { name: "Jua1n12", id: 8 },
            { name: "Edgard12323", id: 9 },
            { name: "Johnson", id: 10 },
            { name: "Johnson", id: 11 },
            { name: "Johnson", id: 12 },
          ],
        },
      ],
    };
  },
};
</script>

<style>
.container {
  width: 100%;
  height: 100%;
}
.step1 {
  width: 14%;
  height: 72vh;
  margin-top: 1%;
  float: left;
}
.step2 {
  width: 14%;
  height: 72vh;
  margin-top: 1%;
  margin-left: 4%;
  float: left;
}
.step3 {
  width: 56%;
  height: 72vh;
  margin-top: 1.2%;
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