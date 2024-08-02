<template>
  <section class="post-section">
    <h2>게시물 단건 조회</h2>
    <div class="single-post-query">
      <input type="number" v-model="singlePostId" placeholder="게시물 ID" />
      <button @click="fetchPost">조회하기</button>
    </div>
    <div v-if="singlePost" class="single-post">
      <h3>{{ singlePost.title }}</h3>
      <p>{{ singlePost.content }}</p>
    </div>
  </section>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      singlePostId: 1,
      singlePost: null
    };
  },
  methods: {
    async fetchPost() {
      try {
        const response = await axios.get(`/api/posts/${this.singlePostId}`);
        if (response.data.result === 'SUCCESS') {
          this.singlePost = response.data.data;
        }
      } catch (error) {
        console.error('단건 조회 오류:', error);
      }
    }
  }
};
</script>

<style scoped>
.post-section {
  margin: 20px 0;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.1);
}

.single-post-query {
  display: flex;
  align-items: center;
  gap: 10px;
}

.single-post {
  margin-top: 20px;
  padding: 15px;
  background-color: #e9e9e9;
  border-radius: 4px;
}
</style>
