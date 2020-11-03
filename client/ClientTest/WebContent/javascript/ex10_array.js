
//배열
// - Array + Collection의 느낌

// int[] nums = new int[3]; --> 자바

//배열의 길이를 지정해주지 않음. (길이가 정해져 있지 않음.)
var nums = new Array();     

nums[0] = 100;
nums[1] = 200;
nums[2] = 300;
// nums[3], nums[4] -> undefined가 나옴, 이렇게 쓰지 말기!
nums[5] = 600;

for (var i=0; i<nums.length; i++) {
    console.log(nums[i]);
}

//아래 모두다 정의하지 않은 변수(?) 들인데 왜 배열은 에러가 나지 않고 변수만 오류가 나는지?
//자바스크립트의 배열은 유사배열이기 때문. (순수 배열이 아닌데 배열처럼 행동하는 객체)
console.log(nums[6]);   //undefined 
console.log(nums[100]); //undefined
// console.log(n1);        //에러

//또한 해쉬맵과 비슷하게 작동함.
//key값이 스칼라 형식이 아님, 아래와같이 문자열을 넣을 수 있다.
nums["one"] = "하나";
console.log(nums["one"]);

//배열 초기화 리스트
//int[] nums = {100, 200, 300};
//중괄호가 아닌 대괄호를 씀.
var nums2 = [100, 200, 300];
console.log(nums2);

//배열 생성(빈 배열)
var m1 = new Array();   //객체 생성 방법으로 생성
var m2 = [];            //배열 리터럴

//예외처리, 다중 catch절은 없음
try {
    console.log(name);
} catch {
    console.log("예외처리");
}

//자바 조건 -> boolean만 가능
//자바스크립트 조건
// - 정수 (0: false, 이외: true)
// - 실수 (0.0: false, 이외: true)
// - 문자 ()

var n = 10;
n = 3.14;
n = 0.0;
n = "홍길동";
n = "";         //false
n = null;       //false
n = undefined;  //false
n = new Date(); //true

if (n) {    //조건 자체에 정수, 실수, 문자를 넣어도 됨.. 
    console.log("참");
} else {
    console.log("거짓");
}