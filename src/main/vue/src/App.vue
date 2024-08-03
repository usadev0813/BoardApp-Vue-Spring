<template>
  <div id="app">
    <AppHeader @navigate="handleNavigation"/>
    <AppFooter @navigate="handleNavigation"/>
    <router-view></router-view>
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue';

export default {
  components: {
    AppHeader
  },
  methods: {
    handleNavigation(page) {
      if (page === 'create') {
        this.$router.push({ name: 'CreatePost' });
      } else if (page === 'view') {
        this.$router.push({ name: 'Home' });
      } else if (page === 'view-post') {
        this.$router.push({ name: 'PostDetail', params: { id: this.currentPostId } });
      }
    }
  }
};
</script>
