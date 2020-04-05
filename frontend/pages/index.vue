<template>
  <base-component>
    <template #left-window>
      <div>
        <h2>Hello World</h2>
      </div>
    </template>
    <template #right-window>
      <h3>こんにちは</h3>
    </template>
  </base-component>
</template>

<script lang="ts">
import Vue from 'vue'
import BaseComponent from '@/components/base/grid/BaseLayout.vue'

export default Vue.extend({
  components: {
    BaseComponent
  }
})
</script>

<style>
/* Sample `apply` at-rules with Tailwind CSS
.container {
  @apply min-h-screen flex justify-center items-center text-center mx-auto;
}
*/
</style>
