<template>
  <div id="app">
    <div class="Header">
    <MyHeader></MyHeader>
  </div>
  <div class="Aside">
      <MyList></MyList>
    </div>
   <div class="Main">
     <router-view></router-view>
    </div>
  </div>
</template>

<script>
import MyList from './components/MyList.vue';
import MyHeader from './components/MyHeader.vue'

export default{
 
 components:{
  MyList,
  MyHeader
 }
}
</script>
<style>
@import './assets/App.css';
</style>

