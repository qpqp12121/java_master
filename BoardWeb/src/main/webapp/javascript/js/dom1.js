//dom1.js
 // [ {id, name,phone}... ] ---밖에는 []:배열 {}:object
     //데이터
     const obj1 = {id: 'user1', name: '홍길동', phone: '010-1111'} // key: value 반복해서 들어가는 게 object
     const obj2 = {id: 'user2', name: '김민수', phone: '010-2222'}
     const obj3 = {id: 'user3', name: '박철호', phone: '010-3333'}

     //배열에 데이터 담기
     const friends = [obj1, obj2, obj3];

     //속성key의 개수만큼 반복할 땐 for ... in.. 추천
      for(let friend of friends) {
        for(let prop in friend){
            console.log(prop.toUpperCase(), '-', friend[prop]);
            //prop:속성출력 - obj[prop] 값 가져오기  
            //속성하나의 값 읽어올 때 방법2가지: obj1['id'] or obj1.id / obj1['name'] or obj1.name...
          }
      }