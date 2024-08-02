<template>
  <div class="app-container">
    <AppHeader @navigate="changePage" />
    <main>
      <CreatePost v-if="currentPage === 'create'" @post-created="changePageToView" />
      <ViewPosts v-if="currentPage === 'view'" />
      <ViewPost v-if="currentPage === 'view-post'" />
    </main>
    <AppFooter />
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue';
import AppFooter from './components/AppFooter.vue';
import CreatePost from './components/CreatePost.vue';
import ViewPosts from './components/ViewPosts.vue';
import ViewPost from './components/ViewPost.vue';

export default {
  components: {
    AppHeader,
    AppFooter,
    CreatePost,
    ViewPosts,
    ViewPost
  },
  data() {
    return {
      currentPage: 'view' // 초기 페이지 설정
    };
  },
  methods: {
    changePage(page) {
      this.currentPage = page;
    },
    changePageToView() {
      this.currentPage = 'view';
    }
  }
};
</script>

<style>
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

main {
  flex: 1;
  padding: 20px;
}
</style>
