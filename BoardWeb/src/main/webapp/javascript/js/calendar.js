//calendar.js

let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thur', 'Fri', 'Sat'];
//마지막날짜 & 시작요일 필요
let lastDate = getLastDate(1); 
let firstDay = getFirstDay(1);
// console.log(lastDate, firstDay);


//달력생성(최종)
function makeCalendar(month){
  makeTitle(days, document.getElementById('theader'));
  makeBody(month, document.getElementById('tbody'));
}
makeCalendar(1);


//< 마지막날짜 & 시작요일 조건 > (1월-3월까지)

//월입력 => 마지막날 반환. (ex.month에 1넣으면 31반환되도록)
function getLastDate(month){ // 31, 29, 31
  switch(month){
    case 1:
    case 3:
      return 31;
      break;
    case 2:
      return 29;
      break; 
  }
}

//월입력 => 앞에 공백 개수 반환.
function getFirstDay(month){
  switch(month){
    case 1:
      return 1;
      break;
    case 2:
      return 4;
      break;
    case 3:
      return 5;
      break;    
  }
}

//header생성 (makeCalendar함수 안에서 호출해서 사용함)
function makeTitle(dayAry=[], pos={}){
  let tr = document.createElement('tr');
  dayAry.forEach(function(field){
    let th = document.createElement('th');
    th.innerText = field;
    tr.appendChild(th);
  })
  pos.appendChild(tr);
};

//날짜생성
function makeBody(month=1, pos ={}){
  let tr = document.createElement('tr');
  //공백.
  let firstDay = getFirstDay(month);
  for(let i = 0; i < firstDay; i++){
    let td = document.createElement('td');
    // td.innerText = ""; //안에 값 없음
    tr.appendChild(td);
  }

  //날짜.
  let lastDate = getLastDate(month);
  for(let i = 1; i <= lastDate; i++){
    //토욜:pink 일욜:aqua.
    let td = document.createElement('td');
    if((firstDay + i) % 7 == 1){
      td.setAttribute('style','background-color:pink');
    }else if((firstDay + i) % 7 == 0){
      td.setAttribute('style','background-color:aqua');
    }

    td.innerText = i;
    tr.appendChild(td);

    //7일씩 끊어서 행바꾸기
    if((firstDay+i) % 7 == 0){ //공란+
      pos.appendChild(tr); //위에서 만든 tr붙여주고
      tr = document.createElement('tr'); //새로 생성
    }
  }  
  pos.appendChild(tr);
}
