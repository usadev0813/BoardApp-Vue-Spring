<template>
  <section class="post-section">
    <h2>게시물 전체 조회</h2>
    <div class="table-container">
      <table class="post-table">
        <thead>
          <tr>
            <th>No</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(post, index) in posts" :key="post.id" @click="goToDetail(post.id)">
            <td>{{ index + 1 }}</td>
            <td>{{ post.title }}</td>
            <td>{{ post.content }}</td>
            <td>{{ post.writer }}</td>
            <td>{{ post.createAt }}</td>
          </tr>
        </tbody>
      </table>
    </div>
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
    },
    goToDetail(postId) {
      if (postId) {
        this.$router.push({ name: 'PostDetail', params: { id: postId } });
      } else {
        console.error('Invalid post ID');
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

.table-container {
  max-height: 400px; /* Set the max-height for scrollability */
  overflow-y: auto; /* Enable vertical scrolling */
  overflow-x: hidden; /* Disable horizontal scrolling if not needed */
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
  cursor: pointer;
}

.post-table th {
  background-color: #f2f2f2;
  position: sticky; /* Keep the header fixed */
  top: 0;
  z-index: 1;
}
</style>
