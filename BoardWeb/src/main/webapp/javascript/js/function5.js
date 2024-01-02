//function5.js

//Array.prototype.forEach();
const ary = ['a', 'b', 'c'];
ary.forEach(function(elem){
  console.log(elem);
})

//간단하게 화살표함수로
ary.forEach((elem) => {
  console.log(elem);
})
// 매개값 하나일 땐 더 간단
ary.forEach(elem => console.log(elem));
//(실행하는 구문도 한 라인 이상이면 중괄호 생략X)
ary.forEach((elem, idx) => {
  if(idx > 0){
    console.log(elem);
  }
})

//기능만들기 (prototype에 sum이라는 함수 만들겠다)
Array.prototype.sum = function(){
  console.log(this); //numbers배열 자기자신 출력됨(numbers.sum();호출)
  let result = 0;
  this.forEach(function(val){ //[]배열요소 자신을 루핑돌면서 값 다 더해서 result반환
    result += val;
  })
  return result;
}
const numbers = [1,2,3,4];
console.log('sum: ' + numbers.sum());