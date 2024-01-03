// function2.js

//문자열을
let members = `[{"id":1,"first_name":"Pandora","last_name":"O'Dogherty","email":"podogherty0@purevolume.com","gender":"Female","salary":5551},
{"id":2,"first_name":"Inigo","last_name":"Beak","email":"ibeak1@ftc.gov","gender":"Male","salary":2408},
{"id":3,"first_name":"Katina","last_name":"Gowry","email":"kgowry2@w3.org","gender":"Female","salary":1538},
{"id":4,"first_name":"Tonia","last_name":"Breawood","email":"tbreawood3@t-online.de","gender":"Female","salary":826},
{"id":5,"first_name":"Leonore","last_name":"Fransman","email":"lfransman4@columbia.edu","gender":"Female","salary":2202},
{"id":6,"first_name":"Cynthie","last_name":"Ovitz","email":"covitz5@behance.net","gender":"Female","salary":1788},
{"id":7,"first_name":"Estella","last_name":"Dunlea","email":"edunlea6@studiopress.com","gender":"Female","salary":2815},
{"id":8,"first_name":"Urson","last_name":"Jedraszczyk","email":"ujedraszczyk7@dmoz.org","gender":"Male","salary":6091},
{"id":9,"first_name":"Quentin","last_name":"Nelm","email":"qnelm8@zimbio.com","gender":"Male","salary":7067},
{"id":10,"first_name":"Joli","last_name":"Oldrey","email":"joldrey9@cpanel.net","gender":"Female","salary":6789},
{"id":11,"first_name":"Winny","last_name":"Stacey","email":"wstaceya@dot.gov","gender":"Female","salary":2361},
{"id":12,"first_name":"Saloma","last_name":"Baptist","email":"sbaptistb@admin.ch","gender":"Female","salary":6097},
{"id":13,"first_name":"Zerk","last_name":"Brough","email":"zbroughc@newyorker.com","gender":"Male","salary":9271},
{"id":14,"first_name":"Loren","last_name":"Worton","email":"lwortond@wordpress.com","gender":"Female","salary":2746},
{"id":15,"first_name":"Thedric","last_name":"Yong","email":"tyonge@tinyurl.com","gender":"Male","salary":1055}]`;

/* JSON.parse()
   : 문자열의 값을 -> 객체로 변환 (js에서 쓰기 좋게) */

// [{..},{..}] => 여러 개의 객체가 배열에 담긴 memberAry   
let memberAry = JSON.parse(members); 
console.log(memberAry[14]); //▶Object(안에 해당내용 출력-객체니까 순서X)
console.log(memberAry[14].first_name);
// console.log(memberAry);


/* < 표 만들기 > */

//<th> 데이터
let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여'];

//<th>생성
function makeHeader(fields=[], pos={}){  //fields에 titles배열받고, position 어느위치에 붙일지 
  let tr = document.createElement('tr');
  fields.forEach(function(field){
    let th = document.createElement('th');
    th.innerText = field;
    tr.appendChild(th);
  })
  pos.appendChild(tr);
};  
makeHeader(titles,document.getElementById('theader')); //function.html파일에 theader에 값 붙일 것

//<td>생성 - 위에서 만든 memberAry배열 looping
function makeBody(data=[], pos={}){ 
  data.forEach(function(item){
    //<tr>
    let tr = document.createElement('tr');
    //속성추가
    if(item.gender == 'Male'){
      tr.setAttribute('style', 'background-color: powderblue');
    }else{
      tr.setAttribute('style', 'background-color: pink');
    }
    //<td>
    for(let prop in item){
      let td = document.createElement('td');
      td.innerText = item[prop]; //속성 값 넣기
      tr.appendChild(td);
    }
    pos.appendChild(tr);
  })
}
makeBody(memberAry, document.getElementById('tbody'));


