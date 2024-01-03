//class1.js
//js에선 객체 그냥 데이터라고 생각하면 됨(다양한 기능 구현하기 위한 용도X)
/* 객체생성 3가지 방법 
   1.{}
   2.함수이용해서 객체 생성
   3.클래스로 객체 생성 --잘 사용은 X */

const obj1 = {
  name: "hong",
  age: 20,
  showInfo(){
    return `이름은 ${this.name}이고 나이는 ${this.age}입니다.`;
  }
};

//클래스 생성(틀 하나)
class Member {
  //생성자
  constructor(name, age) { 
    this.name = name;
    this.age = age;
  }
  //필드 선언 (thisX)
  titles = ['이름', '나이']; 

  showTitle(){
    this.titles.forEach(item => {
      console.log(item);
    })
  }
  showInfo(){
    return `이름은 ${this.name}이고 나이는 ${this.age}입니다.`;
  }
};//end class.


//위처럼 클래스 안에 정의해도 되고
//Member클래스의 prototype에 구현도 가능 
Member.prototype.showName = function(){
  return `이름은 ${this.name} 입니다`;
}

//위 틀가지고 실체 인스턴스 만들기
const obj2 = new Member('홍길동', 20); //(하나만 가능)
console.log(obj2.showInfo());
console.log(obj2.showTitle()); //반환값 따로 정의하지 않아 undefined출력
console.log(obj2.showName());