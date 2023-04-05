<template>
  <div><TodoNew /> <TodoSave /><TodoBar /></div>
  <div><DargMainVue /></div>
</template>

<script>
import TodoNew from "./TodoFolder/TodoNew.vue";
import TodoBar from "./TodoFolder/TodoBar.vue";
import TodoSave from "./TodoFolder/TodoSave.vue";
import DargMainVue from "./TodoFolder/DargMain.vue";
export default {
  components: {
    TodoNew,
    TodoBar,
    TodoSave,
    DargMainVue,
  },
};
</script>

<style>
</style>