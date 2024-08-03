<template>
  <div class="post-title">
    <h2>{{ title }}</h2>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      required: true,
    },
  },
};
</script>

<style scoped>
.post-title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 10px;
  color: #333;
  border-bottom: 2px solid #ddd;
  padding-bottom: 5px;
}
</style>
