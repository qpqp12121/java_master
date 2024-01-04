// array4.js
//map, filter, find, indexOf, some, every

const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';

//1. 콘이라는 이름이 몇번?
let friends = str.split(', ');
let con = friends.filter(val => val.indexOf('콘') != -1).length;
console.log(`콘: ${con}명`);



//2. 이름이 3자 이상이 몇명?
let three = friends.filter(val => val.length >= 3).length;
console.log(`이름3글자이상: ${three}명`)


//3. 2자인 이름이 있는지 여부
let two = friends.some(val => val.length == 2);
console.log(two);

//4. {no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입
let friend = new Map();
const strAry = friends.map((friend, idx) => {
  return{
    no: idx + 1,
    name: friend
  }
})
console.log(strAry)

/////
//1.
// console.log('콘: ', strAry.reduce((acc.obj)))

