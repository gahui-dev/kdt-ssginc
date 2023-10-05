// const System = {
//   out: {
//     println: function (data) {
//       const $boxDiv = document.getElementById('box-div');
//       $boxDiv.innerHTML += data + '<br />';
//     },
//   },
// };

/*
1. <div id="box-div"></div> // body에 추가
2. onload 시 init(); 호출
window.onload = function(){
init();
System.out.println("sdfsdf");
}
*/

const TARGET_ID = 'box-div';

class System {
  static out; //onload시에 객체 생성, static을 명시해도 되고 안해도된다.
}

class Out {
  target;
  constructor(targetName) {
    this.target = document.getElementById(targetName);
  }
  println(msg) {
    if (msg == undefined) {
      msg = '';
    }
    let text = document.createTextNode(msg);
    let br = document.createElement('br');
    this.target.appendChild(text);
    this.target.appendChild(br);
  }
  clear() {
    this.target.innerHTML = '';
  }
}

function init() {
  System.out = new Out(TARGET_ID);
}
