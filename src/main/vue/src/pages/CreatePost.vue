<template>
  <section>
    <h2>게시물 생성</h2>
    <form @submit.prevent="createPost">
      <FormInput id="title" label="제목" v-model="post.title"/>
      <FormTextArea id="content" label="내용" v-model="post.content"/>
      <button type="submit" class="submit-button">등록</button>
    </form>
    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
  </section>
</template>

<script>
import axios from 'axios';
import FormInput from '../components/FormInput.vue';
import FormTextArea from '../components/FormTextArea.vue';
import {getOpenAIKey} from "@/config";

export default {
  components: {
    FormInput,
    FormTextArea,
  },
  data() {
    return {
      post: {
        title: '',
        content: '',
        writerId: 'usadev0813',
      },
      errorMessage: '',
    };
  },
  methods: {
    async createPost() {
      // First check the sentiment of the post content
      const isNegative = await this.checkSentiment(this.post.content);

      if (isNegative) {
        this.errorMessage = '게시물 내용이 부정적이어서 등록할 수 없습니다.';
        return;
      }

      // If the content is not negative, proceed with the registration API call
      try {
        const response = await axios.post('/api/posts/register', this.post);
        if (response.data.result === 'SUCCESS') {
          alert('게시물이 성공적으로 생성되었습니다.');
          // Clear the form after successful creation
          this.post = {title: '', content: '', writer: ''};
          this.$emit('navigate', "view");
        } else {
          this.errorMessage = '게시물 생성에 실패했습니다.';
        }
      } catch (error) {
        console.error('게시물 생성 오류:', error);
        this.errorMessage = '게시물 생성 중 오류가 발생했습니다.';
      }
    },
    async checkSentiment(content) {
      try {
        const response = await axios.post('https://api.openai.com/v1/chat/completions', {
          model: 'gpt-3.5-turbo',
          messages: [
            {
              role: 'system',
              content: 'You are a helpful assistant who analyzes sentiment.',
            },
            {
              role: 'user',
              content: `Analyze the sentiment of this text and return "positive", "neutral", or "negative":\n\n${content}\n\nSentiment:`,
            },
          ],
          max_tokens: 10,
        }, {
          headers: {
            'Authorization': `Bearer ${getOpenAIKey()}`,
            'Content-Type': 'application/json',
          }
        });

        const sentiment = response.data.choices[0].message.content.trim().toLowerCase();
        console.log('Sentiment analysis result:', sentiment);
        return sentiment.includes('negative');
      } catch (error) {
        console.error('Sentiment analysis error:', error);
        this.errorMessage = '내용 분석 중 오류가 발생했습니다.';
        return false;
      }
    }
  },
};
</script>

<style scoped>
.submit-button {
  background-color: #007bff;
  color: #fff;
  padding: 10px 15px;
  font-size: 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.submit-button:hover {
  background-color: #0056b3;
}

.error {
  color: red;
  margin-top: 10px;
}
</style>
