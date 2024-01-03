//function1.js
/* < 함수정의방식 > 

  1.함수선언문 2.함수표현식(변수사용)

*/


//1.함수선언문
// -호출: 함수명으로

//매개값X
// function sum(){
//   let result = 0;
//   result = 10 + 20; //직접 더해줬으니 아래서 매개변수 활용
//   console.log(result);
// }
// // 호출
// sum();

//매개변수O
// function sum(num1, num2){
//   let result = 0;
//   result = num1 + num2;
//   console.log(result);
// }
// sum(); //undefined+undefiend = NaN 출력

//매개변수에 초기값 지정 ( 값이 안들어 오면 초기값으로 쓰겠다 (Es6부터?)
// function sum(num1 = 0, num2 = 0){ 
//   let result = 0;
//   result = num1 + num2;
//   console.log(result);
// }
// sum(); // 0
// sum(11,22); // 33

//return값
// function sum(num1 = 0, num2 = 0){
//   let result = 0;
//   result = num1 + num2;
//   return result;
// }
// let result = sum(11,22);
// console.log('결과는 ' + result);

//"arguments" (매개값 몇 개 있는지 모르지만 다 쓸 거다) --근데 불분명한 프로그램이라 있단 것만 알고 사용X
// function sum(){
//   let result = 0;
//   console.log(arguments);
//   for(let arg of arguments){
//     result += arg;
//   }
//   return result;
// }
// let result = sum(11,22,33,44);
// console.log('결과는 ' + result);

function sum(num1 = 0, num2 = 0){
  let result = 0;
  result = num1+num2
  console.log(arguments);
  if(arguments.length > 2){
  for(let arg = 2; arg < arguments.length; arg++){
    result += arguments[arg];
    }
  }
  return result;
}
let result = sum(11,22,33,44);
console.log('결과는 ' + result);


//2.함수표현식 (변수에 함수정의 담는)
// -호출(변수명으로)
let sum2 = function (num1 = 0, num2){ //함수선언문방식으로 많이 씀 
  let result = num1 + num2            //(
  return result;                      //결론은 같음(모양만다르다생각)
}
console.log('결과: ' + sum2(10,20));
  /* 
  + 함수정의 방식으로 '함수선언문'으로 많이 씀 
    : 정의 방식만 다를 뿐, 내부적으론 함수표현식 코드처럼 실제 처리되기 때문에 
      결론은 같다 (정의형식만 다르다 생각하면 됨) */



/*< 매개값 여러 타입 가능 > */

//1) "객체" 매개값
let obj1 = {
  name: "Hong",
  point: 100
}
let obj2 = {
  name: "Hwang",
  point: 80
}

let average = function(obj1={}, obj2={}){ 
  let result = 0;
  result = (obj1.point + obj2.point) / 2;  //(obj1['point'] + obj2["point"]) / 2;
  return result;
}
//호출(변수명으로)
console.log('평균값: ' + average(obj1, obj2));


//2) "배열" 매개값
let array1 = [10,20];
let array2 = [30,40];

let sum3 = function(ary1 = [], ary2 = []){
  let result = 0;
  ary1.concat(ary2).forEach(function(val) { //concat:배열합치기(결과배열이니 forEach사용)
    result += val;
  })
  return result;
}
console.log("배열의 총합: " + sum3(array1, array2));


//3) "함수" 매개값
let myfunc = function(callback){ //어떤 값이 매개값으로 들어올 진 모르겠지만
  let result = 0; 
  let num1 = 10, num2 = 5;       // 첫번째 매개값으론 num1을 두번째 매개값으론 num2를 쓰겠다
  result = callback(num1, num2);
  return result;
}
//매개값으로 들어갈 '기능' 함수로 만들기-(callback이 받아서 위 코드 실행)
let sumfunc = function(n1,n2){ //어떤 값을 받을지는 모르겠지만
  return n1 + n2;              //두 개의 값을 더한 결과를 반환하겠다
}
let minusfunc = function(n1,n2){
  return n1 - n2;
}

console.log('sumfunc함수 결과: ' + myfunc(sumfunc));
console.log('minusfunc함수 결과: ' + myfunc(minusfunc));