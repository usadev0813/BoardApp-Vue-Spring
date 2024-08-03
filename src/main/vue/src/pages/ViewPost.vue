<template>
  <section v-if="post" class="post-detail">
    <PostTitle :title="post.title" />
    <PostContent :content="post.content" />
    <p>작성자: {{ post.writer }}</p>
    <p>작성일: {{ post.createAt }}</p>
  </section>
  <section v-else>
    <p>게시물을 찾을 수 없습니다.</p>
  </section>
</template>

<script>
import axios from 'axios';
import PostTitle from '../components/PostTitle.vue';
import PostContent from '../components/PostContent.vue';

export default {
  props: ['id'], // Ensure this prop is defined
  components: {
    PostTitle,
    PostContent,
  },
  data() {
    return {
      post: null
    };
  },
  created() {
    this.fetchPost(this.id); // Fetch post on creation
  },
  watch: {
    // React to changes in the ID prop
    id(newId) {
      this.fetchPost(newId);
    }
  },
  methods: {
    async fetchPost(id) {
      try {
        const response = await axios.get(`/api/posts/${id}`);
        if (response.data.result === 'SUCCESS') {
          this.post = response.data.data;
        } else {
          this.post = null;
        }
      } catch (error) {
        console.error('Failed to fetch post details:', error);
      }
    }
  }
};
</script>

<style scoped>
.post-detail {
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
}
</style>
