<template>
  <div class="flex ">
    <div class="w-full">
      <slot name="left-window" />
    </div>
    <div class="w-full">
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
