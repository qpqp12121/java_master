//class3.js

//push
const ary = [];
ary.push(1);
ary.push(2);
ary.push(3);
console.log(ary);

//find()
console.log(ary.find(item => {
  return item >= 2; //조건에 만족하는 첫번째 값을 반환 
}));


/////////////////////////////////////
//98p~

class Estimate {
  //생성자
  constructor(param) {
    this.unit = param;
  }

  //견적가
  getEstimate(unittype, width, height) {
    let priceinfo = this.unit.find(item => item.type == unittype);
    return priceinfo.price * width * height;
  }
  //배열에 요소 추가
  addUnit(unit) {
    unit.push(unit);
  }
}
let unitinfo = [{ type: "wood", price: 100 }, { type: "iron", price: 300 }, { type: "plastic", price: 200 }];

const estimator = new Estimate(unitinfo);
let result = estimator.getEstimate('wood', 20, 20);
console.log(result);

/////////////////////////////////////////////////////////

/* < this > 
  1.객체에선 자기자신을 가리킴
  2.function() : 전역객체(window);  */

function myFunc(){
  console.log(this);
}
myFunc()

//this값 확인해 보기
let obj = {};
obj.act = function(){
  this.value = 'default value'; //obj객체

  function innerAct() {
    this.value = 'inner value'; //window (value에 담음)
    console.log("this.value: " + this.value); //(1)
  }

  function innerReact(caller){
    caller.value = "innerReact value";
    console.log("this.value: " + this.value); //(3) -window가가지고있는value
    console.log("caller.value: " + caller.value); //(4)
  }
  innerAct();
  console.log("obj 객체의 this.value: " + this.value); //(2)

  innerReact(this);//obj객체가리킴

  console.log("obj 객체의 this.value: " + this.value); //(5) -obj객체가리킴
}
obj.act();

// window.location.href = "https://www.daum.net";

/////////////////////////////////////////////////////////

/* < Closure > 116p
   : 정의하는 시점의 실행환경을 기억하는 함수 
    언제 사용? 외부에서 접근하지 못하도록 막을 수 있다*/
function outerFunc(name){
  let saying = name + ' 안녕!'; //원래 saying 로컬변수로 사라지는데

  return function(){
    return saying;
  }
}

const closure1 = outerFunc('라이언');
const closure2 = outerFunc('콘');

console.log(closure1); //함수 정의문 출력
console.log(closure1()); //saying값 리턴
console.log(closure2());


let cnt = 1; //밖에 있으면 increaseCounter()계속실행되어 cnt++할 수 있는데 위에는 let이 로컬변수로 되어있으니 2에서 멈춤 그래서
function getCounter(){
  
  function increaseCounter(){
    cnt++;
    console.log(cnt);
  }
  increaseCounter();
}
getCounter();

function getCounter(){
  let cnt = 1; //내부에 선언해서 
  
  return function (){ // return값으로 익명함수를 주어 안에서 기능쓰도록 ((선언되어진 시점의 값을 계속 유지하면서 내부 처리함
    cnt++;
    console.log(cnt);
  }
 
}
const clo1 = getCounter();
clo1();
clo1();
clo1();

