
/*

자바스크립트의 객체
1. 내장 객체
    -Array, Date, Math 등 new ___() 형식으로 만드는 객체
2. BOM 객체
3. DOM 객체
4. 사용자 정의 객체
    - 자바에서 클래스를 사용해서 객체를 생성하는 것과 유사한 작업

사용자 정의 객체 생성
1. Object 클래스 사용
2. {} : 객체 리터럴(★★많이씀★★)

ex) 자바 - 홍길동 객체 생성
class User {
    private String name;
    private int age;
    private String address;
}
User hong = new User();

유저 추가할 경우
User lee = new User();

*/

//자바스크립트로 홍길동 객체 생성하기
var hong = new Object();    //Object는 아무것도 소유하지 않은 객체임.
hong.name = "홍길동";       //선언을 하는 순간 name이라는 property가 생성됨
console.log(hong.name);
hong.age = 20;
hong.address = "서울시 강남구";
console.log(hong.age);
console.log(hong.address);
console.log(hong);          //{ name: '홍길동', age: 20, address: '서울시 강남구' }

//유저 추가하기
var lee = new Object();
//클래스 내부에서 규정된 property들이 아님.. -> 오타가 날 경우 전혀 새로운 property가 생성될 위험성이 존재함.
lee.name = "이순신";
lee.age = 30;
lee.address = "부산"
console.log(lee);

//리터럴 표기법으로 만들기
var haha = {};  //{} : new Object()
haha.name = "하하하";
haha.age = 20;
haha.address = "서울"
console.log(haha);

//보통 사용하는 방법
var hoho = {name: "호호호", age: 20, address: "서울시"};
console.log(hoho);

var huhu = {
    name: "후후후",     //멤버변수(x), property(o)
    age: 20,
    address: "서울시"
};
console.log(huhu);

//프로퍼티 접근 방법: 객체에 점찍고 프로퍼티 이름 넣기
console.log(huhu.name);     //읽기
huhu.name = "후후후후";     //쓰기
console.log(huhu["name"]);  //읽기 - 연관 배열 접근 방법(indexer

//두가지 표기법이 있음!!
huhu["gender"] = "남자";
huhu.height = 180;
huhu["mobile-number"] = "010-1111-1111";    //이렇게도 사용 가능, 그러나 쓰지 말기 
// huhu.mobile-number = "010-1111-1111";       //이건 안됨
console.log(huhu);


//프로퍼티 삭제
delete huhu.gender;
console.log(huhu);

//향상된 for문
// - 배열, 컬렉션 탐색(x)
// - 객체 프로퍼티 탐색(o)
// - 특정 객체가 가지고 있는 프로퍼티 목록을 탐색하는 제어문
for (var p in huhu) {
    console.log(p);
}

//객체(클래스) 멤버
//1. 변수
//2. 메소드

var hong = new Object();
hong.name = "홍길동";
hong.age = 20;

//함수를 변수 자체에 넣는 것도 가능, 프로퍼티나 변수 안에 넣는 함수는 이름을 적지 않음. 
// - 익명 함수
hong.hello = function() {
    console.log("안녕하세요");
}

console.log(hong);  //{ name: '홍길동', age: 20, hello: [Function] }
hong.hello();

hong.hello2 = function() {
    console.log("안녕하세요. 저는 " + this.name + "입니다.");
}
hong.hello2();

var hong = {
    name: "홍길동",
    age: 20,
    hello: function() {
        console.log("안녕하세요. 저는 " + this.name + "입니다.");
    }
};
hong.hello();


//객체 안에 객체 넣기

var hong = {
    name: "홍길동",
    age: 20,
    //함수 멤버
    hello: function() {

    },
    //객체 멤버
    address: {
        sido: "서울시",
        gugun: "강남구",
        dong: "역삼동",
        bunji: "20번지"
    },
    //배열 멤버
    job: ["학생", "직장인"]
};

console.log(hong.address.dong); //역삼동...
console.log(hong["address"]["dong"]);
console.log(hong.job[0]);


//자바스크립트는 클래스가 없다.
//그런데 new Date()와 같은 구문은 어떻게 나오는지..? -> 생성자 함수 때문!

//생성자 함수(=클래스 역할)
// - 함수의 일종
// - 목적 : 객체를 만드는데 사용하는 전용 함수

var user = {    //문제점: 멤버가 정해져있지 않고 개발자가 직접 정해야 한다. 
    name: "홍길동",
    age: 20,
    hello : function() {}
};


function User(name, age) {  //생성자 함수: 반드시 대문자로 시작해야 한다.(파스칼 표기법)
    this.name = name;       //hong.name = "홍길동";과 같은 행동을 해줌.
    this.age = age;
    this.hello = function() {
        console.log(this.name);
        console.log(this.age);
    };
}

var hong = new User("홍길동", 20);
var lee = new User("이순신", 20);
hong.hello();
lee.hello();

var list = [];
var today = new Date();

console.log(typeof hong);   //object
console.log(typeof lee);    //object
console.log(typeof list);   //object
console.log(typeof today);  //object
console.log();
//자바스크립트에서 객체 타입 구분하는 방법 -> constructor(생성자)를 찍어서 확인해본다.
console.log(hong.constructor)   //[Function: User]
console.log(lee.constructor)    //[Function: User]
console.log(list.constructor)   //[Function: Array]
console.log(today.constructor)  //[Function: Date]












