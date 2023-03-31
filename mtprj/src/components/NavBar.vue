<template>
  <div class="app-bar">
    <span class="logo">Todo<span style="color: #6f00cc">Drag</span></span>
    <span class="user">Login</span>
  </div>
</template>

<script>
export default {};
</script>

<style>
.app-bar {
  height: 6vh;
  line-height: 6vh;
  width: 100%;
  border-bottom: 0.5px solid #c0c0c0;
  box-shadow: 0px 1px 4px 0px #c0c0c0;
  position: sticky;
}
.logo {
  float: left;
  margin-left: 4%;
  font-size: 1.4rem;
  font-family: "Montserrat", sans-serif;
  cursor: pointer;
}
.user {
  float: right;
  margin-right: 2%;
  font-size: 1.2rem;
  font-family: "Montserrat", sans-serif;
  cursor: pointer;
}
</style>