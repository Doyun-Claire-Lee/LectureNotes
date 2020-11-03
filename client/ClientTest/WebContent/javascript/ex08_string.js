
//문자열 변수
var txt = "Hello Hello";

//1. 문자열 길이
console.log(txt.length);    //프로퍼티(property), length property

//2. 검색
// - indexOf()
// - lastIndexOf()
console.log(txt.indexOf("e"));      //1
console.log(txt.lastIndexOf("o"));  //4
console.log(txt.indexOf("?"));      //-1

//3. 대소문자 변환
console.log(txt.toUpperCase());
console.log(txt.toLowerCase());

//4. 치환
// - 처음 만나는 요소만 치환(반복X)
// - 정규 표현식을 사용하면 반복 가능
console.log(txt.replace("H", "Y"));
console.log(txt.replace(/H/gi, "Y"));

//5. 범위 추출
console.log(txt.substring(2, 7));   //llo H,        인덱스
console.log(txt.substring(2));      //llo Hello,    끝까지
console.log(txt.substr(2, 7));      //llo Hel,      2번째부터 7글자를 뽑아오라

//6. 공백제거
// - 앞뒤 공백제거
console.log(txt.trim());

//7. 분할
var result = "홍길동, 아무개, 하하하".split(",");
console.log(typeof result);         //Object..
console.log(result[0], result[2]);

//8. charAt, charCodeAt
console.log(txt.charAt(3));     //문자코드가 아닌 문자를 반환
console.log(txt.charCodeAt(3)); //문자코드를 반환

//9. startsWith, endsWith

//10. 
