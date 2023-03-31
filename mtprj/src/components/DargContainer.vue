<template>
  <div class="todo-main">
    <Dragtodo />
  </div>
  <!-- <DragMain /> -->
</template>

<script>
import { ref, readonly, provide } from "vue";
import { useStorage } from "../compositions/storage";
import Dragtodo from "../Compositions/TodoFolder/DragTodo.vue";
export default {
  name: "DargContainer",
  components: {
    Dragtodo,
  },
  setup() {
    const todos = ref([]);
    const { loadTodos, saveTodos, storage_id } = useStorage();
    provide("todos", readonly(todos));

    const initTodos = (init_todos) => {
      todos.value = init_todos;
    };
    const addTodo = (job, date) => {
      todos.value.push({
        id: storage_id.value++,
        job: job,
        date: date,
        completed: false,
      });
      saveTodos(todos);
    };

    const removeTodo = (id) => {
      todos.value.splice(id, 1);
      console.log(todos.value);
      todos.value.forEach((todo, idx) => {
        todo.id = idx;
      });
      console.log(todos.value);
      saveTodos(todos);
    };

    const completeTodo = (id) => {
      todos.value.find((todo) => todo.id == id).completed = true;
      saveTodos(todos);
    };

    provide("addTodo", addTodo);
    provide("removeTodo", removeTodo);
    provide("completeTodo", completeTodo);

    loadTodos(initTodos);
  },
};
</script>

<style>
.todo-main{
  margin: 2%;
}
</style>