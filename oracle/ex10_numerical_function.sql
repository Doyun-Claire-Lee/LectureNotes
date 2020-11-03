/*
숫자 함수(수학 함수)
- 자바의 Math 클래스
*/


/*
1. round()
- 반올림 함수
- number round(대상컬럼) : 정수 반환
- number round(대상컬럼, 소수이하 자릿수) : 실수 반환
*/

select height / weight, round(height / weight) from tblcomedian;

select 10/3 from dual; --계산값 하나만 보고 싶을 때 쓰는 테이블, 시스템 테이블(1행 1열)
select round(10/3) from dual;

select round(avg(basicpay)) from tblinsa;

select 
    round(987.654), 
    round(987.654, 1),  --반올림을 할 자릿수(소수 이하) 
    round(987.654, 2)
from dual;


/*
2. ceil()
- number ceil(대상 컬럼)
- 무조건 올림 함수
*/

select 
    round(3.6),
    ceil(3.6),
    round(3.1),
    ceil(3.1)
from dual;

/*
3. floor(), trunc()
- number floor(대상 컬럼)
- number trunc(대상 컬럼, 소수 이하 자릿수) 
- 무조건 내림 함수
*/

select 
    5.6789,
    floor(5.6789),
    trunc(5.6789),
    trunc(5.6789, 1),
    trunc(5.6789, 2)
from dual;

-- ceil <-> floor
-- round <-> trunc

/*
4. mod()
- number mod(피제수, 제수)
- 나머지 함수
*/

select mod(10, 3) from dual;

--100분 -> 1시간 40분으로 변환
select 
    floor(100 / 60) as 시,
    mod(100, 60) as 분
from dual;

/*
5. abs()
- 절대값 구하기
6. power(n, n)
- 제곱
7. sqrt()
- 제곱근(루트)
*/

select
    abs(-10),
    power(2, 8),    --2^8
    sqrt(4)             -- 루트4
from dual;