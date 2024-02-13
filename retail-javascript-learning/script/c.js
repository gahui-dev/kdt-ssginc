// c.js

// export => 하나의 자바스크립트에 export 할 수 있는게 여러개!
// export default => 한 번만 export 할 때 사용
export default function fun3() {
  console.log("c.js >> fun3");
}

export function error() {
  console.log("error");
}
