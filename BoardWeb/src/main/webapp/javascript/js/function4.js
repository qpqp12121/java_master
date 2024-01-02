//function4.js

//달력을 생성하는 객체.
//calendar.js에서 선언부분과 호출부분만 변경

//1.객체생성{}
const cal = {
  days:  ['Sun', 'Mon', 'Tue', 'Wed', 'Thur', 'Fri', 'Sat'],

  makeCalendar: function(month){
    this.makeTitle(this.days, document.getElementById('theader')); //객체라 this.로 호출
    this.makeBody(month, document.getElementById('tbody'));
  },
  
  makeTitle: function(fields, pos){
    let tr = document.createElement('tr');
    fields.forEach(function(field){
    let th = document.createElement('th');
    th.innerText = field;
    tr.appendChild(th);
  })
  pos.appendChild(tr);
  },
  
  makeBody: function(month, pos){
    let tr = document.createElement('tr');
  //공백.
  let firstDay = this.getFirstDay(month);
  for(let i = 0; i < firstDay; i++){
    let td = document.createElement('td');
    // td.innerText = ""; //안에 값 없음
    tr.appendChild(td);
  }

  //날짜.
  let lastDate = this.getLastDate(month);
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
  }, //makeBody end.
  
  getFirstDay(month){  //속성 메서드처럼 작성가능( 위 makeCalendar: function(month){ } 으로 하던 거랑 같음)방식 생김
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
  }, //getFirstDay end.

  getLastDate(month){
    switch(month){
      case 1:
      case 3:
        return 31;
        break;
      case 2:
        return 29;
        break; 
    }
  } //getLastDay end.
}

cal.makeCalendar(1);
//makeBody(){}에 getFirst/LastDate()호출하는 것 있음. 객체에서 호출할 때 this. 꼭 붙이기