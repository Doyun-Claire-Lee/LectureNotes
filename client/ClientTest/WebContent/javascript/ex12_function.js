
/*

자바스크립트에서의 함수
- "함수는 1급 객체다." , first class citizen, first class object
- 함수는 객체처럼 취급된다. (데이터처럼 취급이 가능하다.)

    ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    1. 함수를 변수나 데이터 구조에 담을 수 있다.
    2. 함수를 매개변수에 전달 할 수 있다.
    3. 함수를 반환값으로 사용할 수 있다.
    ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    -> 이 특징을 살려야 자바스크립트 느낌이 많이 나는 코딩이 가능하다.

*/

var m1;
function f1() {
    console.log("f1");
}
//1. 함수를 변수나 데이터 구조에 담을 수 있다.
m1 = f1;    //함수자체를 변수에 담기, 함수가 정의된 주소값을 복사
// m1 = f1();  //함수의 반환값을 변수에 담기

m1();   //m1은 변수인데 실행할 수 있게됨.


//2. 함수를 매개변수에 전달 할 수 있다.
function f2(m) {
    m();
}
function f3() {
    console.log("f3");
}
function f4(){
    console.log("f4");
}
f2(f3);
f2(f4); 

//3. 함수를 반환값으로 사용할 수 있다.
function f5() {
    return f3;
}
f5()();
















