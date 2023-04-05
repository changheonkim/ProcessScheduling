<template>
  <div class="input-container">
    <input class="input-todo" type="text" placeholder="회사명" />
    <input class="input-todo2" type="text" placeholder="제품명" />
    <div class="input-button">입력</div>
  </div>
</template>

<script>
export default {};
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
  height: 5.4vh;
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
  height: 5.4vh;
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
</style>