//function6.js

const args = [4, 5, 6];

function sum(num1 = 0, num2 = 2, ...args) { //펼침연산자:매개변수의 개수가 몇개인지 모르겠지만 들어온 개수만큼 연산처리하겠다
  let result = 0;
  result = num1 + num2
  if (args.length > 0) {
    args.forEach(val => {
      result += val;
    })
  }
  return result;
}

console.log(sum(10, 20, ...args)); //...args: 변수 안에 들어있는 값들 펼치겠다(args는 배열이니 펼쳐서)
//파라미터로 펼침연산자 쓸 땐 제일 마지막에만 작성가능(=나머지파라미터)

/* < 배열 + 배열 > */
//concat 
const ary1 = [10, 20];
const ary2 = ary1.concat(args); //두개 배열합쳐서 새로운 배열로 -concat(문자,배열 합치기) 
console.log(ary2);

//펼침연산자: 합쳐서 새로운 배열로 생성
const ary3 = [...ary1, ...args];
console.log(ary3);

/* < 객체 + 객체 > */
//펼침연산자 : 합쳐서 새로운 객체로 생성
const obj1 = { name: "Hong", age: 20 };
const obj2 = { name: "Hwang", height: 170};
const obj3 = { ...obj1, ...obj2 };
console.log(obj3); //중복된 속성은 마지막 값으로 / 다른 속성은 그냥 합쳐짐


/* reduce(4개인자) -80p 
  1.누적되는 값 담기 (이전 순번에서 반환해주는 값을 여기에 담아 줌)
  2.현재값
  3.인덱스
  4.원본배열 */

//args = [4, 5, 6]
// let result = args.reduce((acc, curItem, idx, ary) => {
//   console.log(acc, curItem, idx); //acc에 아래에 초기값 0이 들어가고 / curItem: 4 /
//   return curItem;//return구문 있어야 다음 순서로 acc에 들어갈 값 있음
// }, 0); //첫번째 값은 함수, 두번짼 있을 수도 없을 수도
// console.log('결과값: ' + result); //마지막 curItem 값인 6 출력

let result = args.reduce((acc, curItem, idx, ary) => {
  console.log(acc, curItem, idx);
  return acc + curItem;
}, 0);
console.log('결과값: ' + result); //15


/* map 메서드 - 배열에서 사용O, 매개값으로 함수
   (1) 배열에 들어있는 요소 하나하나의 값
   (2) 배열의 인덱스
   (3) 해당 배열 그 자체 */

//차이? forEach는 return값 X (map은 처리된 결과값을 새로운 변수에 담을 수 O)   

result = [1, 2, 3, 4].map((item, idx, ary) => { //mapping 1,2,3,4을 다른 값으로 mapping하는데 사용多
  console.log(item, idx, ary);
  return item * 2;
});
console.log('결과값: ', result); // ','쓰면 상세


/* < 변수의 스코프 > 
  - var: 함수단위 스코프 ( 함수 밖: 전역변수 / 함수 안: 지역변수 ) +중복가능(오류X)
  - let: 블록단위 스코프  --밖에서 선언해야 사용가능*/


var name = '어피치';
// function run(){
//   if(true){
//     var name = '라이언';
//   }
//   console.log(name); //function안에 있는 var변수가 있는지 찾아보고 먼저 실행
//   return name;
// }
// run();
// console.log(name); //전역

//let: 블록변수=> if문 밖이라 라이언X
// function run(){
//   if(true){
//     let name = '라이언';
//   }
//   console.log(name); 
//   return name;
// }
// run();
// console.log(name);

//선언->안에서 초기화 => 라이언출력
function run() {
  let name;
  if (true) {
    name = '라이언';
  }
  console.log(name);
  return name;
}
run();
console.log(name);


/* < 스코프 체인 > */
var a = 1;
var b = 5;

function outerFunc() { //2.실행

  function innerFunc() { //5.실행->호이스팅으로 아래 var b; 선언부분  function innerFunc() 제일 처음으로 실행O 
    a = b;
  }
  console.log(a); //3.'1'출력(안에 a선언X => 밖에 선언된 var a = 1 값)

  a = 3;
  b = 4;
  innerFunc(); //4.호출
  console.log(a, b);  //'4,4'출력 //function안에 있는 var변수가 있는지 찾아보고 먼저 실행

  var b = 2; //--호이스팅
  console.log(b);
}
outerFunc(); //1.호출


/* < try-catch문 >*/
const c = 10;
try {
  c = 20;
} catch (error) {
  console.log(error.message) //error가 가지고 있는 message출력
} finally {
  console.log(c); //error상관없이 반드시 실행되는
}
