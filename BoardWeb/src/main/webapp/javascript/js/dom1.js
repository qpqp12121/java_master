//dom1.js

/* [ 배열 {객체 key: value } ]
   [ {id, name,phone}... ]     */

  //객체생성 (user데이터)
  const obj1 = {
    id: 'user1', 
    name: '홍길동', 
    phone: '010-1111'
  };

  const obj2 = {
    id: 'user2',
    name: '김민수',
    phone: '010-2222'
  };
  
  const obj3 = {
    id: 'user3', 
    name: '박철호', 
    phone: '010-3333'
  };

  //객체들 배열로 저장
  const friends = [obj1, obj2, obj3];

  //for..of : 배열의 요소 인덱스 번호 없이 바로 활용O
  //for..in : 객체 key & value 가져옴 (객체순회)
  for(let friend of friends) {
    for(let prop in friend){
        console.log(prop.toUpperCase(), '-', friend[prop]); // ID - user1 
      }
  }

  /* prop: 속성출력 - obj[prop]: 값 가져오기  

  < 속성하나의 값 읽어올 때 방법 2가지 > 
    1. 객체['key']  - ex. obj1['id'], obj1['name']
    2. 객체.key     - ex. obj1.id, obj1.name...     */


