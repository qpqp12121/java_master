  //var: 함수레벨변수 - let/const: block레벨변수
    
  var name = 'Hwang';
  function myfunc()
  {
    var name = 'Hong'; //var: 함수범위 안에서 유효한 값 가짐
    console.log(name);
    console.log(this);
  }
  myfunc();
  console.log(name);



  let age=20;
  function myfunc2(){
    let age = 22; //let:블록안에서만 유효
    console.log(age);
  }
  myfunc2();
  console.log(age);
  let obj = {
    id: 'Hong', //객체의 속성: 값(메서드도O)
    age: 20,
    show: function(){
        console.log(this);
    }
  }
  obj.show();

  document.body.addEventListener('click', function(){
      console.log(this);
  });
  //1.전역영역: window 객체
  //2.함수: window 객체
  //3.객체: object
  //4.이벤트: 이벤트 실행 대상  
  // console.log(this);

  // let show = 'Hello';

  // function show(){
  //   console.log('show');
  // }
  
  // 자바스크립트에서 () : 함수실행.
  let show = function() {
    console.log('show'); 
    //return undefined; --의미생략-( 반환값 따로 정의X )
    return '반환값';
  }
  console.log(show);
  console.log(show());
  
  (function(){
    console.log('익명함수');
  })(); // javascript에서 () : 함수실행.

  //함수명 규칙
  function showMyName(){
    console.log('홍길동');
  }

  //상수선언.
  const height = 167.9;
  height = 169;

  const friend = {
    name: '홍길동',
    phone: '010-1111'
  }
  friend.phone ='010-2222'; //속성값 바꾸는 건 가능
  
  // friend={}