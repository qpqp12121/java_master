//class2.js

/* < 클래스로 달력 만들기 > */
//마지막날,요일 가져오는 것 Date활용

//**여기서 날짜 바꾸기
let year = 2024;
let month = 2;

class Calendar {
  //생성자
  constructor(year, month) {
    this.year = year;
    this.month = month;
  }
  //필드(속성)
  days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thur', 'Fri', 'Sat'] //객체는 days:[]

  //최종기능 실행(마지막에 호출)
  makeCalendar() {
    // console.log('달력생성.');
    this.makeTitle(document.getElementById('theader'));
    this.makeBody(document.getElementById('tbody'));
  }

  makeTitle(pos) { //붙일 위치만 매개값으로
    let tr = document.createElement('tr');
    this.days.forEach(function (field) {
      let th = document.createElement('th');
      th.innerText = field;
      tr.appendChild(th);
    })
    pos.appendChild(tr);
  }

  makeBody(pos) { // pos = {} 
    let tr = document.createElement('tr');
    //공백
    let firstDay = this.getFirstDay();
    for (let i = 0; i < firstDay; i++) {
      let td = document.createElement('td');
      tr.appendChild(td);
    }
    //날짜
    let lastDate = this.getLastDate();
    for (let i = 1; i <= lastDate; i++) {
      //토욜:pink 일욜:aqua.
      let td = document.createElement('td');
      if ((firstDay + i) % 7 == 1) {
        td.setAttribute('style', 'background-color:pink');
      } else if ((firstDay + i) % 7 == 0) {
        td.setAttribute('style', 'background-color:aqua');
      }
      td.innerText = i;
      tr.appendChild(td);
      //7일씩 끊어서 행바꾸기
      if ((firstDay + i) % 7 == 0) { //공란+
        pos.appendChild(tr); //위에서 만든 tr붙여주고
        tr = document.createElement('tr'); //새로 생성
      }
    }
    pos.appendChild(tr);
  }

  //요일
  getFirstDay() { //매개값 생성자로 받아씀--(year,month) 안 써도 O
    // let day = new Date(this.year, this.month - 1, 1);
    // return day.getDay(); 
    return new Date(this.year, this.month - 1, 1).getDay(); //위로 해도 되고
  }

  //마지막날
  getLastDate() { 
    //연,월 : this.year, this.month
    let date = new Date(this.year, this.month, 0); //0: month의 전날
    return date.getDate();
  }

}
const cal = new Calendar(year, month);
cal.makeCalendar();


/* 날짜 관련 보기 */
// let today = new Date(); //{}new Object()
// console.log(today.getFullYear());
// console.log(today.getMonth()+1);
// console.log(today.getDate());
// console.log(today.getDay()); //0:일

// today = new Date(2023,0,1); //(2023,1,0)-- 1일에서 하루 빼서 2월1일의 전날
// console.log(today.getDay());

// let today = new Date(year, month - 1, 1); //요일 필요해서 1넣고 getFirstDay()
// today = new Date(year, month, 0); //마지막 날짜 필요 getLastDate()
// console.log(today.getDate(),today.getDay()); //마지막날/첫날요일
