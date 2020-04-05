<template>
  <div class="flex ma-4">
    <div class="w-full">
      <slot name="left-window" />
    </div>
    <div>
      <slot name="right-window" />
    </div>
  </div>
</template>
<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
  name: 'BaseGrid'
})
</script>
