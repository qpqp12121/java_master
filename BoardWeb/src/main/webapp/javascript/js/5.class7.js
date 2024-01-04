// class7.js
//class6에서 정의한 기능들 사용하기

import { friend, sum, getMax } from './5.class6.js'; //현재폴더class6에있는export된 요소만 사용
//export X => 사용불가

let n1 = 10, n2 = 20;
console.log(sum(n1,n2)); 
console.log(getMax(n1,n2));

console.log(friend.showInfo());

//