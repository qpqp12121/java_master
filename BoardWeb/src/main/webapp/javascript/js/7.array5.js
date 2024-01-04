//array5.js
//sort()
const ary = [12, 20, 2, 1, 100, 88]
ary.sort((a, b) => { //원하는 순으로 정렬하겠다가 매개값으로 (a,b): 순서
  //오름차순: 음수 / 내림차순: 양수
  if(a < b) { //ex. 12 < 20 ..
    return -1 //(조건)뒤에값이 크면 오름차순
  }else{
    return 1; //앞이 크면 내림
  }
});

console.log(ary);

const friends = [
  {name: "Hong", age: 12},
  {name: "Hwang", age: 111},
  {name: "Park", age: 2},
  {name: "Kim", age: 33},
]

friends.sort((a,b) => {
  if(a.age < b.age) {
    return -1; //조건순으로 정렬하고 싶으면 -1
  }else{
    return 1;
  }

  
})
console.log(friends);

//이름순도됨
console.log("Hong" > "Park");



