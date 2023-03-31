<template>
  <div class="container">
    <div class="step1">
      <div class="col-3">
        <draggable
          class="list-group"
          :list="list1"
          group="people"
          @change="log"
          itemKey="name"
        >
          <template #item="{ element, index }">
            <div class="st1-do">{{ element.name }} {{ index }}</div>
          </template>
        </draggable>
      </div>
    </div>

    <div class="step2">
      <div class="cate-border">
        <div :list="categorys">
          <div v-for="element in categorys" :key="element.name" class="layout">
            <div class="cate">
              {{ element.name }}
            </div>
          </div>
        </div>
      </div>
      <div :list="list2" class="step2-border">
        <div v-for="row in list2" :key="row.index" class="layout">
          <div>
            <draggable
              :list="row.items"
              group="people"
              @change="log"
              itemKey="name"
            >
              <template #item="{ element }">
                <div class="st2-do">
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
export default {
  components: {
    draggable,
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
      list2: [
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
  width: 20%;
  height: 72vh;
  margin-top: 1%;
  float: left;
}
.step2 {
  width: 68%;
  height: 72vh;
  margin-top: 1.2%;
  margin-left: 10%;
  float: left;
}
.cate {
  width: 100%;
  border: 1px solid #6A5ACD;
  height: 6%;
  background-color:	#6A5ACD;
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

.step2-border {
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