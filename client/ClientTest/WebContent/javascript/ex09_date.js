
//날짜 시간 자료형
// - new Date()
// - 자료형 : object

//현재 시각
var now = new Date(); //Calendar.getInstance()
console.log(now.toLocaleString()); //2020-07-01 T05:14:46.035Z  -> GMT0

//c.get(Calendar.YEAR)
console.log(now.getFullYear());         //2020
console.log(now.getMonth());            //6(7월)
console.log(now.getDate());             //1
console.log(now.getDay());              //3(일:0 ~ 토:6)
console.log(now.getHours());            //14
console.log(now.getMinutes());          //20
console.log(now.getSeconds());          //0
console.log(now.getMilliseconds());     //0.469
console.log(now.getTime());             //틱값

//선생님파일복사하기

console.log();
console.log(now.toLocaleDateString());  //년월일
console.log(now.toLocaleTimeString());  //시분초

var xmas = new Date();
xmas.setMonth(11);
xmas.setDate(25);
console.log(xmas.toString());

var birthday = new Date(1990, 5, 20);               //생성자로 날짜만들기
var birthday = new Date(1990, 5, 20, 12, 20, 30);   //시분초도 연속으로 넣을 수 있음

//연산
console.log(xmas - now);    //틱값으로 나옴.

//오늘 + 100일
console.log(now + 1);   //Wed Jul 01 2020 14:34:42 GMT+0900 (GMT+09:00)1 -> 문자열 + 문자열

var result = new Date();
result.setTime(now.getTime() + (100*24*60*60*1000));
console.log(result.toString());

