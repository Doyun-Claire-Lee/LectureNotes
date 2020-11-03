
//형변환
// - 대부부 상황에서는 자바스트립트가 스스로 형변환을 한다.

console.log("100" * 2);

//형변환 함수
//"100" -> 100

//1. number(int) parseInt()
//2. number(float) parseFloat()

var n1 = 3.14;
console.log(parseInt(n1));

var n2 = "100";
console.log(parseInt(n2));
console.log(typeof parseInt(n2));


//parseInt -> 숫자로 시작하는 문자열에서 문자가 나오기 전까지의 숫자를 추출하여 정수로 변환해줌.

//숫자로 시작하는 문자열
var n3 = "200점";
console.log(parseInt(n3));  //200, "점"을 빼고 변경해줌..
n3 = "100+200";
console.log(parseInt(n3));  //100

//문자로 시작하는 문자열
n3 = "점수200";
console.log(parseInt(n3));  //NaN, 숫자가 아닙니다

//HTML + CSS
var width = "200px";
console.log(parseInt(width) + 200 + "px");      //400px
console.log(parseFloat("1.5em") * 2 + "em");    //3em


//isNaN() 
//- Is it Not a Number?
//- 자료형에 대한 질문이 아닌, 형식의 질문(숫자의 형태가 아닌지?)
var age = "20세";   //사용자 입력값

if (!isNaN(age)) {
    console.log(age);
} else {
    console.log("숫자만 입력하세요.");
}
// console.log(age);