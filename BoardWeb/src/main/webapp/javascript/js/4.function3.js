//function3.js

/* 객체생성 3가지 방법 
   1.{}
   2.함수이용해서 객체 생성
   3.클래스로 객체 생성 --class1.js */

//값으로 함수 O
let obj1 = {
  name: "홍길동",
  age: 20,
  showInfo: function(){
    return '이름은 ' + this.name + ', 나이는 ' + this.age;
  }
}

console.log(obj1.name);
console.log(obj1["age"]);
console.log(obj1.showInfo());

//함수를 이용한 객체 선언. (생성자함수)
function Member(name, age) {
  this.name = name; //name,age를 받아 속성값 넣기 (위 방식은 key value 계속 선언해줘야 되니 중복)
  this.age = age;
  this.showInfo = function(){
    return '이름은 ' + this.name + ', 나이는 ' + this.age; //그냥 this는 전역변수로 선언된 name을 말하는 거라X
  }
} 
let obj3 = new Member('김명철',22); //함수호출
let obj4 = new Member('이형섭',25); //함수호출

console.log(obj3.showInfo());
console.log(obj4.showInfo());
