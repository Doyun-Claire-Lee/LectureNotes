/*

Node.js : JavaScript를 실행하는 환경
JavaScript : 언어

JavaScript 자료형
1. Number
    - 숫자형
    - 정수 + 실수
2. String
    -문자 + 문자열
3. Boolean
    - 논리형
    - true, false
4. Object
    - 객체형
    - 배열, 날짜시간, 수학 등...
    - 클래스 생성하기가 까다로워 사용자 정의 객체를 만들기 어렵다.
5. 기타
    - null
    - indefined
    - NaN(난) : Not a Number

변수 or 상수
- 자바스트립트는 변수의 타입이 없다.
- var : 변수 선언문(variable)
    - 동일한 변수를 여러번 선언 가능하다.(덮어쓰기됨.)

- 모든 변수는 모든 자료형을 담을 수 있다. (만능, Java의 Object같은 느낌)


*/

var num; //변수 선언

var num1 = 100;         //정수형 리터럴
var name = "홍길동";    //문자 리터럴
var name2 = '홍길동';    
var flag = true;        //논리 리터럴
var today = new Date(); //객체

console.log(num1);
console.log(typeof num1);
console.log(typeof name);
console.log(typeof flag);
console.log(typeof today);

console.log(' ');

num1 = "문자열";            //다른 자료형 넣는 것 하지말기!!
console.log(typeof num1);

console.log(typeof null);       //object
console.log(typeof undefined);  //undefined
console.log(typeof NaN);        //number

//똑같은 변수를 두번 선언해도 실행됨, var의 특징 때문
var kor = 100;
var kor = 90;
console.log(kor);       //90

//변수 선언문(var)없이도 변수를 선언할 수 없음, 그러나 절대 쓰지말기!!!!!!
eng = 100;              
console.log(eng);

//문자 이스케이프
console.log("안녕하세요.\t \"홍길동\"입니다.")

//자바스크립트는 문법이 엄격하다. (대소문자)
//자바스트립트는 자료형에 대해서는 유연하다. (자동형변환을 잘한다.)
