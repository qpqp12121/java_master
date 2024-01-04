//class4.js

const friend = {
  name: "홍길동",
  age: 20,
  hobbies: ['독서', '운동', '영화'],
  pets: [{
    name: '야옹이', 
    gender: 'M',
    friends: ['검양이', '빨양이']
  }, {
    name: '멍멍이', 
    gender: 'F'
  }],
  showHobby(){
    return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]}`;
  }
}
console.log(friend.name);
console.log(friend.hobbies[1]);
console.log(friend['pets'][0].name);
console.log(friend['pets'][0]['friends'][0]);
//추가
friend.pets[0]['friends'][2] = '노랑이';
console.log(friend.pets[0].friends[2]);
console.log(friend.pets[0].friends.length); //3
// friend.pets[0].friends.length = '연둥이';
// console.log(friend);

//삭제
delete friend.age;
console.log(friend);

//메서드추가
friend.showFriends = function(){ //객체 안에 있으니 메서드
  console.log(this); //그래서 this는 friend가리킴
}
console.log(friend);

///////////////////////////////////////////////////01.04

console.log(friend); //원본friend age: 20
/* 참조값을 복사 */
const fcopy = friend; //참조주소 같아서
fcopy.age = 22;       // 원본friend age도 22 변함
console.log(fcopy);

/* 객체를 복사: assign() */
// const fcopy2 = Object.assign({}, friend); // assign(초기할객체, 복사할대상)
// fcopy2.age = 24; 
// console.log(fcopy2); //객체를 복사하고 복사한 것의 age바꾼거라 원본 friend값은 변하지X

const fcopy2 = Object.assign({bloodType:'O'}, friend); // assign(초기할객체, 복사할대상) --bloodType추가
fcopy2.age = 24; 
console.log(fcopy2); //원본 friend값은 변하지X

/* 속성추가 */
Object.defineProperty(friend, 'height', {
  get: function(){ //getter속성 추가하는 방식이 함수 안에 정의한 것
    return this._height; //this._속성
  },
  set: function(value){ //setter속성 (메서드X) 추가방식이 함수
    if(value <= 0){
      alert('error');
    }else{
      this._height = value; //this.heightXX
    }
  }
});
friend.height = 162;
console.log(friend.height);