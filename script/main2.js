// main.js
// a.js와 b.js import 해서 구성 요소 사용

import { fun as xxx } from './a.js';
import { fun2, Person } from './b.js';
import { default as yyy } from './c.js';

xxx();
fun2();
yyy();

var p = new Person();
