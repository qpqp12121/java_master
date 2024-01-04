//class5.js
// Map / Set

/* < Map > 컬렉션: key,value형식 */

//map인스턴스 생성
const map = new Map();

//set(key, value)
map.set('홍길동', 20);
map.set('김민수', 22);
map.set('최성우', 25);
map.set('홍길동', 21); //중복키 값은 마지막 작성한 걸로 출력

//삭제-delete속성
map.delete('최성우');
// map.clear();

//get()
console.log(map.get('김민수'));

//keys()
map.keys() //해당되는 key값을 새로운 map/?에 담아줌
//반복문으로 key값
for (let key of map.keys()) {
  // console.log(key); //key만
  console.log(`key는 ${key}, value는 ${map.get(key)}`); //key / 값
}

//
console.log(map.values()); //값만 //MapIterator {20, 22, 25}
console.log(map.entries()); //key와 value쌍으로 출력 //MapIterator {'홍길동' => 20, '김민수' => 22..}
for (let obj of map.entries()) {
  console.log(obj); //['홍길동', 20] 유사배열?
}
for (let [item, value] of map.entries()) { //반환해 주는 타입이 배열이라 받는 것도 배열을 선언해서 값 가져올 수 있
  console.log(item, value); //홍길동 20
}

map.forEach((val, key) => console.log('val: ' + val + ', key: ' + key)); //값 / 키 순으로 출력(매개값하나면값)



/* < Set > 컬렉션 */
const set = new Set();
set.add('홍길동');
set.add('김민수');
set.add('홍성길');
set.add('홍길동'); //중복X

//삭제 delete
set.delete('김민수');

console.log(set.size); //size속성으로 길이확인

set.forEach(name => console.log(name));

const numAry = [10, 14, 12, 10]; //중복값 제외시키기 위해
const num = new Set(numAry); //배열을 Set 컬렉션으로 담아줌
num.forEach(number => console.log(number));

console.clear(); //이전에 만든 콘솔들 다 제거


//김씨인 사람들 점수 합계 구하기
map.set('김명철', 80);
map.set('김익수', 70);
map.set('이명철', 80);
map.set('이익수', 85);
map.set('홍길동김', 80);

let sum = 0;

map.forEach((score, name) => {
  if(name.indexOf('김') == 0){ //성이 '김씨' 
    sum+=score;
  }
})
console.log(`합계: ${sum}`);

sum = 0;
map.forEach((score, name) => {
  if(name.indexOf('김') != -1){ //이름에 '김'포함된
    sum+=score;
  }
})
console.log(`합계: ${sum}`);







