const System = {
  out: {
    println: function (data) {
      const $boxDiv = document.getElementById('box-div');
      $boxDiv.innerHTML += data + '<br />';
    },
  },
};
