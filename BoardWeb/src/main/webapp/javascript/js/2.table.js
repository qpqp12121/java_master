//table.js


//user데이터 2.dom2.js에 있음(객체3개)
/* < user_data 테이블 생성 > */

let table = document.createElement('table');
//attribute 추가
table.setAttribute('border', 1);
table.setAttribute('id', 'list') //id속성추가 = tbody 여러 개일 경우, 구분하여 추가하려고 .appendChild
//생성된 노드 -> 기존 DOM트리와 연결
table.appendChild(makeHead());
table.appendChild(makeBody());
document.querySelector('body').appendChild(table);


/* < 이벤트 생성 > */

//1.추가button : input 아이디,이름,연락처 받은 데이터 -> 한 행으로 테이블에 추가
document.getElementById('addBtn').addEventListener('click', function () {
  let id = document.getElementById('uid').value; //<input>의 value값 읽어와서 담기
  let name = document.getElementById('uname').value;
  let phone = document.getElementById('uphone').value;

  if (!id || !name || !phone) {
    alert('값을 입력하세요');
    return; //종료
  }

  let obj = { id, name, phone } //{id: id, name: name, phone: phone} -- 객체의속성: "변수 = 값" 같으면 하나만 적어도 O
  document.querySelector('#list>tbody').appendChild(makeTr(obj)); //list테이블의 하위요소인 tbody에 makeTr(obj)를 붙이겠다
  //아래에 데이터 한 행 추가하기 위한 함수생성
  //추가하고 값 비우기                                                                
  document.getElementById('uid').value = '';
  document.getElementById('uname').value = '';
  document.getElementById('uphone').value = '';

  document.getElementById('uid').focus();
})


//2.변경button : 아래 테이블에서 값 눌러-해당 데이터 위 input란에 뜨면 => 값 바꿔서 변경하여 table에 추가
document.querySelector('#editBtn').addEventListener('click', function () {
  //찾을 값
  let findId = document.getElementById('uid').value;
  let phone = document.getElementById('uphone').value;
  //찾을 대상
  let target = document.querySelectorAll('#list>tbody>tr'); //querySelector는 한건만 / All붙이면 가지고 있는 값 다 //#list tr : 공백은 하위요소 아무거나 tr있으면 O
  // console.log(target);                                                                                          // #list>tr 아이디list인테이블 바로 하위tr만해당(근데이렇게하면 thㅇ인 id도가져와서 다시 바꿈)
  target.forEach(function (item, idx, ary) { //(괄호는변수명)함수가 매개값으로
    // console.log(item,idx,ary);
    let tr = item;
    if (tr.children[0].innerText == findId) {
      tr.children[2].innerText = phone;
    }
  })

})

//선택삭제button 이벤트
document.querySelector('#delBtn').addEventListener('click', function () {
  document.querySelectorAll('#list>tbody>tr>td>input:checked').forEach(function (item) { // :추가속성 
    item.parentElement.parentElement.remove();
  })

})
/////////////////////////////////////////////////////////////////////////
//1) thead 생성
function makeHead() {
  let thead = document.createElement('thead');
  let tr = document.createElement('tr');
  //th (3개-id,name,phone) 
  for (let prop in obj1) {
    let th = document.createElement('th');
    th.innerText = prop.toUpperCase();
    tr.appendChild(th);
  }
  //삭제칼럼, 선택삭제칼럼 추가
  let th = document.createElement('th');
  th.innerText = '삭제';
  tr.appendChild(th);
  th = document.createElement('th');
  th.innerText = '선택삭제';

  tr.appendChild(th);
  thead.appendChild(tr);

  return thead;
}

//2) tbody 생성
function makeBody() {
  let tbd = document.createElement('tbody');
  for (let friend of friends) {
    tbd.appendChild(makeTr(friend));      //makeTr(friend); //: 하나의 tr
  }
  return tbd;
}


//3) tr, td 생성(user데이터)
function makeTr(obj = {}) { //위에서 매개값으로 friend 넘겨주기//obj={} 값 안들어오면 초기값으로 쓰겠다

  //< 1.tr >
  let trb = document.createElement('tr'); //trb: tbody의 tr
  //click이벤트 (id/name/phone 클릭하면 - 위 빈칸에 그 사람 정보뜨도록)
  trb.addEventListener('click', function() {
    document.getElementById('uid').value = this.children[0].innerText; //(this대신 trb)로 해도 됨
    document.getElementById('uname').value = this.children[1].innerText;
    document.getElementById('uphone').value = this.children[2].innerText;
  })


  //< 2.td >
  for (let prop in obj) { //한행데이터가져옴
    let td = document.createElement('td');
    td.innerText = obj[prop];
    trb.appendChild(td);
  }
  //(1)button 생성 (삭제)
  let td = document.createElement('td');
  let btn = document.createElement('button');
  //button 이벤트
  btn.addEventListener('click', function (e) { //이벤트핸들러.
    e.stopPropagation(); //상위요소로 이벤트 전파 차단(버블링)
    console.log(this.parentElement.parentElement.remove()); //여기서 this: 이벤트를 받는 대상(여기선 버튼) => (this) or (btn) 사용O
  });

  btn.innerText = '삭제';
  td.appendChild(btn);
  trb.appendChild(td);

  //(2)checkbox 생성 (선택삭제)
  let td2 = document.createElement('td');
  td2.setAttribute('align', 'center');
  let chkbox = document.createElement('input');
  chkbox.addEventListener('click', function (e) { //function(event값)이 매개값으로 들어오도록 지정해놨음(e로쓴건그냥변수)
    e.stopPropagation();
    console.log(e);
  });

  chkbox.setAttribute('type', 'checkbox');
  td2.appendChild(chkbox);
  trb.appendChild(td2);

  return trb;
}

/* 
e.stopPropagation();  --> 상위요소로 이벤트 전파 차단(버블링) 
 ex.체크박스 input이면서 tr,td 영역이니 이벤트가 모든 곳에서 실행된다 
 => 제일 하위에 있는 input태그만 이벤트 실행되고 상위요소는 차단되도록 
*/