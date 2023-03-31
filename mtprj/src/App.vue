<template>
  <NavBar />
  <DargContainer />
</template>

<script>
import NavBar from "./components/NavBar.vue";
import DargContainer from "./components/DargContainer.vue";
export default {
  name: "App",
  components: {
    NavBar,
    DargContainer,
  },
};
</script>
