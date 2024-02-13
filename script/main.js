// main.js
// a.js와 b.js import 해서 구성 요소 사용

import { fun } from './a.js';
import { fun2, Person, fun3 } from './b.js';
import fun3 from './c.js';

fun();
fun2();
fun3();

var p = new Person();
