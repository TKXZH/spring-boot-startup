<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" type="text/css" href="style.css">
  <script src="https://cdn.bootcss.com/vue/2.6.8/vue.common.dev.js"></script>
</head>
<body>
<h1>Vue Startup</h1>


<div id="app">
  <p>Hello, {{name}}!</p>
  <p>{{getInfo()}}</p>
  <label for="r1">change color</label>
  <input type="checkbox" v-model="use" id="r1">
  <div v-bind:class="{'class1': use}">
    v-bind:class 指令
  </div>
  <div v-if="use">I'm here!</div>

  <p>{{name}}</p>
  <button v-on:click="reverse">reverse the string above</button>
  <click-counter></click-counter>
</div>

</body>

<script src="/js/vue-component.js"></script>

</html>