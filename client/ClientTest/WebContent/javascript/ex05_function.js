/*

JavaScript Function
- 함수, 메소드

자바 메소드 
public [static] int m1(int num) {
    return 10;
}

자바스트립트 함수
function m1(num) {
    return 10;
}

*/

function f1() {
    console.log("f1");
}
f1();

function f2() { 
    // console.log(name);
    console.log(arguments); //일종의 내장 배열? (유사배열), 매개변수 리스트를 자동으로 받아준다.
    console.log(arguments[0]);
}
//함수에 매개변수를 선언하지 않아도 모두 동작이 됨... 
f2("홍길동", 10, true, new Date());

function f3(name) {
    console.log(name);
}
//호출시 값을 안넣어줄 경우 -> undefined
f3();   //undefined

//변수를 선언하고 초기화하지 않아도 사용할 수 있음, undefined로 표현됨.
var num;
console.log(num);   //undefined

// undefined vs null
// undefined : 변수를 선언하고 초기화하지 않았을 경우
// null : 일부로 비워 둔 상태 

console.log(undefined == null);     //true로 찍힘. 그러나 다른값임.
console.log(undefined === null);    //false

// == vs ===
// == : 약간의 형변환을 해줌
// === : 진성비교연산자, 정확한 비교값을 얻고 싶을때

console.log(100 == "100");  //true
console.log(100 === "100"); //false


function f4() {
    return 10;
}
console.log(f4());  //10

//선언하기 전 호출이 가능함.
//자바스크립트 - 한줄씩 실행하기 전 전체 구문을 대충 스캔하는 작업이 일어남. 이때 선언 구문을 만나는 순간 그 구문을 맨 위로 끌어올림.
//끌어올리는 작업(호이스팅)이 끝나면 한줄씩 실행을 함.
//함수 호이스팅, Function Hoisting
//변수 호이스팅, Variable Hoisting

f5();
function f5() {
    console.log("f5");
}

console.log(m5);    //undefined
var m5 = 100;


console.log();
/*

자바: 멤버변수 vs 지역변수
    - 클래스 영역 or 메소드 영역 or 제어문 영역

자바스크립트: 전역변수 vs 지역변수
    1. 전역변수, Global Variable
        - 한 페이지(자바 스크립트의 영역 중 가장 넓은 영역) 안에서 모두 사용 가능한 변수
    2. 지역변수, Local Variable
        - 블럭(함수) 내에서 선언한 변수
        - 제어문 안은 블럭이라 인식하지 않음.
*/


var m1 = 100;           //전역변수
console.log(m1);

function c1() {
    console.log(m1);    //전역변수 호출
}
c1();

function c2() {
    var m2 = 200;       //지역변수
    console.log(m2);
}
c2();
// console.log(m2);        //에러남.  m2 is not defined

function c3() {
    if (true) {
        var m3 = 300;
        console.log(m3);
    }
    console.log(m3);    //실행 잘됨.
}
c3();


//자바스크립트는 var선언문 없이 변수를 선언할 수 있다.(그러나 쓰지말기..)
var nick1 = "강아지";   //전역 변수
nick2 = "고양이";       //전역 변수

//var 없이 선언한 변수는 지역 내에서 선언되었더라도 전역 변수이다.
function c4() {
    var gender1 = "남자";    //지역변수
    gender2 = "여자";       //★★전역변수★★
}
c4();

// console.log(gender1);   //에러남. 
console.log(gender2);   //
























