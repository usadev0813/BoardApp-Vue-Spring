<template>
  <div class="post-content">
    <p>{{ content }}</p>
  </div>
</template>

<script>
export default {
  props: {
    content: {
      type: String,
      required: true,
    },
  },
};
</script>

<style scoped>
.post-content {
  font-size: 16px;
  line-height: 1.5;
  color: #555;
  margin-bottom: 20px;
  padding: 15px;
  background-color: #fafafa;
  border-radius: 5px;
  border: 1px solid #eee;
}
</style>
