//string1.js

let str1 = "Hello";
console.log(str1, typeof str1); //string
let str2 = new String("Hello");
console.log(str2, typeof str2); //object

console.log(str1 == str2);
console.log(str1 === str2);

console.log(str2.substring(1,3)); //포함,포함X

let word = "    Hello, World  ";
console.log(word.trimStart());
console.log(word.trimEnd());
console.log(word.trim());

//const obj = new Object(); 표현식 => js에선 {} 선호
//const reg = new RegExp(); 표현식 => /값/ 선호

//정규표현식 사용
console.log(word.replace(',','.')); //값 바로 온 것
console.log(word.replace(/l/g,'L')); //l을 global전역에서 찾아서 'L'로 바꾸겠다
console.log(word.replace(/\s/g, '')); // \s:공백을 찾아와서 빈문자열로 대체

//정규표현식 사용하지 않으려면(문자열을 공백 기준으로 배열로 분리-다시 붙이는 방법)
word = '   how are you to day everyone.  ';
// word.split(' '); //배열로
// word.split(' ').filter();

//filter() : 값이 있는 것들만 배열에 담음
//join() : 배열에 담긴 요소들을 문자열로 변환
console.log(word.split(' ').filter((val) => {
  return val; 
}).join(' '));
//간단하게
console.log(word.split(' ').filter(val => val).join(' '));
/////////////////////////////////////////////////////

/* <문자열 자르기> */
//1.slice() : 문자열의 시작 인덱스와 끝 인덱스 사이의 범위에 있는 문자열 반환
// String.slice(시작,끝); --끝은 포함X
console.log('This is the only one story'.slice(1,6)); //(포함,X) - his i

//2.substring() : slice()와 기본은 동일 (포함,X)
//                음수 입력시 0으로 대체
// String.substring(10, -8); => (0,10)
console.log('This is the only one story'.substring(1,6));//(포함,X) - his i
console.log('This is the only one story'.substring(10, -8)); //This is th

//3.substr() : (시작, 문자열길이)
// 시작: 음수면 뒤에서 부터 / ※문자열길이에 음수 X => 0으로 변경되어 ''빈문자열 반환
const str3 = 'This is the only one story';
console.log(str3.substr(2,7)); //is is t -7자글자

/* < toString() : 문자열이 아닌 데이터->문자열로 */
const num1 = 123;
const bool = true;
const arr = [1,2,'a','b'];
const obj = {key:'data', value: 15};

console.log(num1.toString());
console.log(bool.toString())
console.log(arr.toString())
console.log(obj.toString()); //[object Object] 값반환XX

/* < 문자열 찾기 > */
//indexOf('문자열') : 찾는 문자열의 시작위치 숫자로 반환 / 없을시 -1 반환
//lastIndexOf('문자열') : 뒤에서 부터 
//인자2개 ('문자열', 찾을 시작위치)
console.log('This is the only one story'.indexOf('is',4)) //5
console.log('This is the only one story'.lastIndexOf('is',4)) //2




