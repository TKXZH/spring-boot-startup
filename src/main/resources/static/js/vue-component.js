Vue.component('click-counter', {
  data: function () {
    return {
      count: 0
    }
  },
  template: '<div><button @click="count++">you click me {{count}} times!</button></div>'
});

var app = new Vue({
  el: '#app',
  data: {
    name: "zonghuixu",
    age: 24,
    use: false
  },
  methods: {
    getInfo: function () {
      return this.name + " is running!";
    },
    reverse: function () {
      this.name = this.name.split('').reverse().join('')
    }
  }
});