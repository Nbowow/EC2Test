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
      message: "", // 서버에서 가져온 메시지를 저장
    };
  },
  methods: {
    async fetchMessage() {
      try {
        const response = await fetch("http://3.34.192.220:8081/api/message?id=2"); // ID가 1인 메시지 요청
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json(); // JSON 응답 파싱
        this.message = data.message; // "message" 값을 화면에 반영
      } catch (error) {
        console.error("Error fetching message:", error); // 에러 출력
      }
    },
  },
};
</script>
