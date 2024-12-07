<template>
  <div id="app">
    <h1>Vue.js with Spring Boot API</h1>
    <div>
      <button @click="fetchMessage">Get Message</button>
      <p>{{ message }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: "",
    };
  },
  methods: {
    async fetchMessage() {
      try {
        const response = await fetch(
          "http://<EC2-Instance-IP>:8080/api/message"
        );
        this.message = await response.json().message;
      } catch (error) {
        console.error("Error fetching message:", error);
      }
    },
  },
};
</script>
