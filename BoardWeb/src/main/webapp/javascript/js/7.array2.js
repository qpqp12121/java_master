//array2.js

/* 
  reduce(4개인자) -80p 
  1.누적되는 값 담기 (이전 순번에서 반환해주는 값을 여기에 담아 줌)
  2.현재값
  3.인덱스 (생략가능)
  4.원본배열 (생략가능) */


const numAry = [23, 10, 17, 35, 9];

//합계 구하기
// let result = numAry.reduce((acc,num) =>{  //reduce가 어떤 값을 반환함(문자,배열 등등 받는 값에 따라)
//   console.log(acc, num);
//   return acc + num;
// },0); //초기값 0이 먼저 acc에 누적되고 - num:첫번째 값23 (초기값 없으면 첫번째값 23이 acc에 먼저 누적)

// console.log(`합계: ${result}`);

//최대값 구하기
// let result = numAry.reduce((acc,num) =>{ 
//   console.log(acc, num);
//   return acc > num ? acc : num; //조건에 맞는 값이 반환되고 다시 acc에 담김
// },0);

// console.log(`최대값: ${result}`);

//1.최소값
let result = numAry.reduce((acc, num) => {
  console.log(acc, num); //확인용
  return acc > num ? num : acc;
}, numAry[0])
console.log(`최소값: ${result}`);

//2.평균 구하기
let result2 = numAry.reduce((acc, num, idx) => {
  if (idx == numAry.length - 1) {
    return (acc + num) / numAry.length;
  }
  return acc + num
}, 0)
console.log(`평균: ${result2}`);
// let result2 = numAry.reduce((acc,num) => {
//   return acc + num 
// },0) 
// const average = result2 / numAry.length;
// console.log(`평균: ${average}`)


//10보다 큰 값을 새로운 배열에 담기
result = numAry.reduce((acc, num) => {
  if(num > 10){
    acc.push(num); //초기값[]배열로 줘서 데이터push로 담기
  }
  return acc;
}, []);
console.log(`결과: ${result}`)