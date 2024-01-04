//array1.js

/* 배열 ary = [] */
const ary = [1, 2, '3', new Date()]; //js에선 여러타입가능

const numAry = [10, 20, 30, 40];
//<데이터 추가>
numAry.push(30); //끝에
numAry.unshift(40);//앞에

//<데이터 삭제>
numAry.pop(); //마지막 요소 X
numAry.shift(); //첫번째 요소 X


/* splice(시작인덱스, 삭제할요소길이, 추가할요소1, 추가할요소2 ... ) 
  : 특정요소 삭제/수정/(앞에)추가                                     */
numAry.splice(1); //특정 요소 X (몇번째위치, 개수) --기본: 위치 뒤로 다 삭제
numAry.splice(1, 1, 50); //수정 (몇번째위치, 개수, 수정값)
numAry.splice(1, 0, 50, 60); //추가 (몇번째위치, 0, 추가값,추가값,....)
// numAry.splice(0); //다 비워 줌 -> []

//* length (js에선 배열크기 변경가능(java에선 읽기전용))
// numAry.length = 1;
// console.log(numAry);

const numAry2 = [50, 60];
//* concat() : 배열병합 -> 새로운 배열 생성
// const numAry3 = numAry.concat(numAry2); //새로운 배열에 담아줘야 됨
// console.log(numAry3);

//forEach반복해서 push
numAry2.forEach(num => numAry.push(num));
console.log(numAry);








