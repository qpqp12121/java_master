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
console.log(friend);
console.log(friend.pets[0].friends.length); //3
// friend.pets[0].friends.length = '연둥이';
//삭제
delete friend.age;
console.log(friend);

//메서드추가
friend.showFriends = function(){ //객체 안에 있으니 메서드
  console.log(this); //그래서 this는 friend가리킴
}
console.log(friend);