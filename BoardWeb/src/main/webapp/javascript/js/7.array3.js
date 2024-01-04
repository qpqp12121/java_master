// array3.js

/* reduce() 활용 */
import { members, titles } from './7.data.js';

console.log(members);
console.log(titles);

//<th>생성
let str = titles.reduce((acc, title, idx) => {
  if (idx == 0) { //첫번째순서
    acc += '<tr>';
  }
  acc += '<th>' + title + '</th>'; //사이에 th필드

  if (idx == titles.length - 1) { //마지막순서
    acc += '<tr>';
  }
  return acc;
}, '');
// console.log(str)
document.getElementById('theader').innerHTML = str; //<tr><th.../th><tr>


//DOM으로 <td>생성
members.reduce((acc, member) => {
  let tr = document.createElement('tr');
  for (let prop in member) {
    let td = document.createElement('td');
    td.innerText = member[prop];
    tr.appendChild(td);
  }
  acc.appendChild(tr); //아래tbody가 acc임(acc의 초기값이니)
  return acc;
}, document.getElementById('tbody')); //초기값 dom오브젝트



/* map (A ->'A')
   filter(A->B) */

let result = members.map((member, idx) => {
  let obj = {}
  obj.id = member.id;
  obj.name = member.first_name + '-' + member.last_name;
  obj.email = member.email;
  return obj;
});

//메서드 체인 배열.filter().map()...
// result = members.filter(member => {return member.gender == 'Female'}); //아래생략
result = members.filter(member => member.gender == 'Female') //members배열에서 filter로 만족하는 경우의 값만 새로운 배열로 만들고
  .map((member, idx) => { //그 결과값을 map으로 아래 형태로 만들어
    let obj = {}
    obj.id = member.id;
    obj.name = member.first_name + '-' + member.last_name;
    obj.email = member.email;
    return obj;
  })
  .map(member => member.name); //위 결과배열에서 이름만 가져와 
  // console.log(result);
  result.push('charles') //result.push().push('').push XXX
  result.push('Hong')
  result.push('charles');
console.log(result.indexOf('charles', 6)); //이름 위치인덱스값 반환










