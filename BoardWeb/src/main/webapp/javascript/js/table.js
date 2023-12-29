//table.js
 // < table만들기 >
 let table = document.createElement('table');
 table.setAttribute('border',1); //attribute 추가.
 table.setAttribute('id', 'list') //테이블에 id속성추가ㅅ해서 tbody여러개일경우구분해ㅓㅅ.appendChild하려고
//  table.setAttribute('border-collapse','collapse');
 table.appendChild(makeHead());
 table.appendChild(makeBody());
 document.querySelector('body').appendChild(table); // console.log(table);//확인용       
//=> table생성 end.

//추가버튼 클릭이벤트.
document.getElementById('addBtn').addEventListener('click', function(){ //doc에서 id값으로 요소 가져와 클릭이벤트 설정
    let id = document.getElementById('uid').value; //input태그의 id값으로 value값 읽어와서 담기
    let name = document.getElementById('uname').value;
    let phone = document.getElementById('uphone').value;

    if(!id || !name || !phone){
      alert('값을 입력하세요');
      return; //종료
    }

    let obj = {id, name, phone} //{id: id, name: name, phone: phone} 객체의속성: 변수id 값 (en두개같으면 하나로만 적어도 됨)
    document.querySelector('#list>tbody').appendChild(makeTr(obj)); //id가 list인테이블의 하위요소인 tbody에 makeTr(obj)를 붙이겠다

    document.getElementById('uid').value = ''; //추가하고 값 비우기
    document.getElementById('uname').value = '';
    document.getElementById('uphone').value = '';
    document.getElementById('uid').focus();
  }) 

  //변경버튼 클릭 이벤트 등록.(아래표에서 값 누르면 위에 뜨고-값 바꿔서 변경누르ㅕㅁㄴ 변경되어들어감)
  document.querySelector('#editBtn').addEventListener('click', function(){
    //찾을 값
    let findId = document.getElementById('uid').value;
    let phone = document.getElementById('uphone').value;
    //찾을 대상
    let target = document.querySelectorAll('#list>tbody>tr'); //querySelector는 한건만 / All붙이면 가지고 있는 값 다 //#list tr : 공백은 하위요소 아무거나 tr있으면 O
    // console.log(target);                                                                                          // #list>tr 아이디list인테이블 바로 하위tr만해당(근데이렇게하면 thㅇ인 id도가져와서 다시 바꿈)
    target.forEach(function(item, idx, ary){ //(괄호는변수명)함수가 매개값으로
      // console.log(item,idx,ary);
      let tr = item;
      if(tr.children[0].innerText == findId){
        tr.children[2].innerText = phone;
      }
    })

  })

  //선택삭제 이벤트 시작.
  document.querySelector('#delBtn').addEventListener('click', function(){
      document.querySelectorAll('#list>tbody>tr>td>input:checked').forEach(function(item){ // :추가속성 
      item.parentElement.parentElement.remove();
      })
    
  })

 function makeHead(){
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
      //th (3개) : for in 써서 반복 ( 굳이 배열쓸 필요X obj123 중 하나를선택해서? )-->
      for(let prop in obj1 ){ 
        let th = document.createElement('th');
        th.innerText = prop.toUpperCase();
        tr.appendChild(th);
      }
      //삭제이벤트 (버튼)
      let th = document.createElement('th');
      th.innerText = '삭제';
      tr.appendChild(th);
      th = document.createElement('th');
      th.innerText = '선택삭제';
      tr.appendChild(th);


      thead.appendChild(tr);
      return thead;
  }


  
 function makeBody(){    
   //tbody시작.
    let tbd = document.createElement('tbody');

      for(let friend of friends){ //2.배열개수만큼 반복 (tr반복하기)
        tbd.appendChild(makeTr(friend));      //makeTr(friend); //: 하나의 tr
                                             //tbd.appendChild(trb);
      }
      return tbd;
  }


  //데이터 한건 추가하기 위한 함수
  function makeTr(obj={}){ //위에서 매개값으로 friend 넘겨주기(for문밖이니)
    //tr          //obj={} 값 안들어오면 초기값으로 쓰겠다
    let trb = document.createElement('tr'); //trb: tbody의 tr
    trb.addEventListener('click', function(){
      //  console.log(this.children[0].innerText) --무슨 값 뜨는지 확인차 써본 것
      //id/name/phone 클릭하면 위 빈칸에 그 사람 정보뜨도록
       document.getElementById('uid').value = this.children[0].innerText; //(this대신 trb)로 해도 됨
      //  document.querySelector('#uid').value = this.children[0].innerText; --위랑 똑같음(괄호에 아이디명)
       document.getElementById('uname').value = this.children[1].innerText; 
       document.getElementById('uphone').value = this.children[2].innerText; 

    })
    //td
    for(let prop in obj){ //1.한행데이터가져옴
      let td = document.createElement('td');
      td.innerText = obj[prop];
      trb.appendChild(td);
    }

    //삭제버튼 생성
    let td = document.createElement('td');
    let btn = document.createElement('button');
    //button 이벤트 등록
    btn.addEventListener('click', function(e){ //이벤트핸들러.
      e.stopPropagation();
      console.log(this.parentElement.parentElement.remove()); //여기서 this: 이벤트를 받는 대상(여기선 버튼) => (this) or (btn) 사용O
    });           //btn 상위요소 td -> 그 요소의 또 상위요소 "tr"
    btn.innerText = '삭제';
    td.appendChild(btn);
    trb.appendChild(td);

    //체크박스 생성
    let td2 = document.createElement('td');
    td2.setAttribute('align', 'center');   
    let chkbox = document.createElement('input');
    chkbox.addEventListener('click', function(e){ //function(event값)이 매개값으로 들어오도록 지정해놨음(e로쓴건그냥변수)
      e.stopPropagation(); //상위요소로 이벤트 전파 차단.(그럼 위에 값XXx)
      console.log(e);
    })

    chkbox.setAttribute('type', 'checkbox'); //체크박스 input이면서 tr td 영역 다 되니 이벤트가 다 실행되어버려 input 이벤트만 실행되고 상위요소는 차다ㄴ되도록(젤하위에있는input에만)
    td2.appendChild(chkbox);
    trb.appendChild(td2);    
    

    return trb;
  }

 