<template>
  <section class="post-section">
    <h2>게시물 전체 조회</h2>
    <table class="post-table">
      <thead>
        <tr>
          <th>제목</th>
          <th>내용</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(post, index) in posts" :key="index">
          <td>{{ post.title }}</td>
          <td>{{ post.content }}</td>
        </tr>
      </tbody>
    </table>
  </section>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      posts: []
    };
  },
  created() {
    this.fetchPosts();
  },
  methods: {
    async fetchPosts() {
      try {
        const response = await axios.get('/api/posts');
        if (response.data.result === 'SUCCESS') {
          this.posts = response.data.data;
        }
      } catch (error) {
        console.error('게시물 조회 오류:', error);
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

.post-table {
  width: 100%;
  border-collapse: collapse;
}

.post-table th,
.post-table td {
  padding: 12px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.post-table th {
  background-color: #f2f2f2;
}
</style>
