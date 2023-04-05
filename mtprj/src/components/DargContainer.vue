<template>
  <div class="todo-main">
    <Dragtodo />
  </div>
</template>

<script>
import Dragtodo from "../Compositions/DragTodo.vue";
export default {
  name: "DargContainer",
  components: {
    Dragtodo,
  },
  setup() {}
};
</script>

<style>
.todo-main {
  margin: 2%;
}
</style>