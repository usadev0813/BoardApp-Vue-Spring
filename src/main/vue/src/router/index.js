// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import ViewPosts from '../pages/ViewPosts.vue';
import ViewPost from '../pages/ViewPost.vue';
import CreatePost from '../pages/CreatePost.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: ViewPosts
  },
  {
    path: '/post/:id',
    name: 'PostDetail',
    component: ViewPost,
    props: true  // This allows route params to be passed as props
  },
  {
    path: '/create',
    name: 'CreatePost',
    component: CreatePost
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
