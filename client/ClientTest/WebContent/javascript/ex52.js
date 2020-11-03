
// ES6(ECMAScript 2015) 이후에 생긴 문법들...

//화살표 함수, Arrow Function
// - 자바의 람다와 유사
// - () -> {} : 자바
// - () => {} : 자바스크립트

//일반 함수

//1. 함수 선언문을 통해 생성
function foo1() {
    console.log("foo1");
}
//2. 함수 표현식(함수 리터럴)
var foo2 = function() {
    console.log("foo2");
};

foo1();
foo2();

//화살표 함수(=익명 함수)
var foo3 = () => console.log("foo3");  
foo3();


//매개변수가 없는 경우
var foo = () => console.log("bar");
foo();

//매개변수가 하나인 경우
var foo = x => console.log(x);
foo("매개변수가 하나");

//매개변수가 여러개인 경우
var foo = (x, y) => console.log(x + y);
foo(1, 2);

//반환값이 있는 경우
var foo = () => { return "반환값 10";};
console.log(foo());

var foo = () => "반환값 하나";
console.log(foo());

var foo = (x, y) => x * y;
console.log(foo(2, 4));

//-----------------------------------------------------------------------------------
console.log();
//-----------------------------------------------------------------------------------

//자바스트립트의 this 키워드
console.log(this);  //node.js에서 - {} : 그냥 객체라는 표현
                    //브라우저에서 - 최상위 객체인 window객체

//화살표 함수 내에서의 this

