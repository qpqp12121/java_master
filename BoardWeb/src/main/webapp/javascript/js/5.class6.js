// class6.js
//147p
/* < module > 사용 : 특별한 기능들만 외부에 보여지고 나머지는 X */
function sum(num1, num2){
  return num1 + num2;
}

function getMax(num1, num2){
  return num1 > num2 ? num1 : num2;
}

const friend = {
  name: "hong",
  age: 20,
  showInfo(){
    return `이름은 ${this.name}, 나이는 ${this.age}입니다.`;
  }
}


//외부로 반환시킬 요소들 
export { friend, sum, getMax };

/* 
- 사용하려는 곳에서 import{friend} from './5.class6.js'; 경로 적어주고
- html파일에서 script type="module" 추가 
  ex.<script type="module" src="js/5.class7.js"></script> */
