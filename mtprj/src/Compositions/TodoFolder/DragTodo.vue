<template>
  <div><TodoNew /> <TodoBar /></div>
  <div><DargMainVue /></div>
</template>

<script>
import TodoNew from "./TodoNew.vue";
import TodoBar from "./TodoBar.vue";
import DargMainVue from "./DargMain.vue";
export default {
  components: {
    TodoNew,
    TodoBar,
    DargMainVue,
  },
};
</script>

<style>
</style>