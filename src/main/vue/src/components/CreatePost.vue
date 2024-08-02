<template>
  <section class="post-section">
    <h2>게시물 생성</h2>
    <form @submit.prevent="createPost" class="post-form">
      <input type="text" v-model="newPost.title" placeholder="제목" required />
      <textarea v-model="newPost.content" placeholder="내용" required></textarea>
      <button type="submit">게시물 생성</button>
    </form>
  </section>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      newPost: {
        writerId: 'usadev0813',
        title: '',
        content: ''
      }
    };
  },
  methods: {
    async createPost() {
      try {
        const response = await axios.post('/api/posts/register', this.newPost);
        if (response.data.result === 'SUCCESS') {
          alert('게시물이 성공적으로 생성되었습니다.');
          this.$emit('post-created');
        }
      } catch (error) {
        console.error('게시물 생성 오류:', error);
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

.post-form {
  display: flex;
  flex-direction: column;
}

input[type="text"],
textarea {
  margin-bottom: 10px;
  padding: 12px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 4px;
  outline: none;
  transition: border-color 0.3s ease;
}

input[type="text"]:focus,
textarea:focus {
  border-color: #007bff;
}

button {
  padding: 12px 20px;
  font-size: 16px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: #0056b3;
}
</style>
