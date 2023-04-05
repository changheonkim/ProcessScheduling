<template>
  <div class="todo-list-bar">
    <div class="category">카테고리 추가</div>
    <div class="title">Todo <span style="color: #6f00cc">List</span></div>
    <div class="calendar-button">캘린더</div>
  </div>
</template>

<script>
export default {};
</script>

<style>
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
.title{
  margin-left: 30%;
  float: left;
  font-family: "Montserrat", sans-serif;
  font-size: 1.2rem;
}
</style>