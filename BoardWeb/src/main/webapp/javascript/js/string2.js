//string2.js

//1. 배열에서 '홍'이 들어간 단어의 개수
const keyword = '홍';
const wordAry = ['사과', '홍씨', '홍장군', '김시홍', '감자'];

// let words = wordAry.join(' ');
// let cnt = words.match(/홍/gi).length //keyword 어떻게 쓸지 모르겠
// console.log(`'홍'포함 단어 개수: ${cnt}개`);

console.log(wordAry.filter(val => val.indexOf(keyword) != -1).length)


//2. url에서 파라미터(x,y)의 값 찾기
const url = 'http://localhost/BoardWeb/index.jsp?x=12&y=23';

// console.log(url.match(/\d+/g))
console.log(url.match(/\d+/g)[0], url.match(/\d+/g)[1]); // \d:숫자 찾아서 \s:공백


//3. "안녕하세요 만나서 반갑습니다." 문장으로 변환하기
const word = '안녕하세요xx만나서xx반갑습x니x다.';
// let word2 = word.split('x');
// console.log(''.concat(...word2)); //띄어쓰기

console.log(word.replace(/xx/g, ' ').replace(/x/g, ''));