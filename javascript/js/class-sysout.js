class Out {
  element;
  println(data) {
    this.element.innerHTML += data + '<br />';
  }
}

class System {
  static out = new Out();
}

function init(targetElement) {
  System.out.element = document.getElementById(targetElement);
}
