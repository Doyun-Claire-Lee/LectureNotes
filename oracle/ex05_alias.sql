/*

select 문

- select 절 : 컬럼을 지정하는 역할, 2번
- from 절 : 테이블을 지정하는 역할, 1번

*/

select * from tblcountry;
select * from tblinsa;
select * from tblmen;
select * from tblwomen;
select * from tblcomedian;
select * from tbladdressbook;
select * from fine_dust;
select * from lotto_master;


/*

Alias, 별칭
 - 컬럼, 테이블에 별명을 붙일 수 있다.
 1. 이름을 간소화시키기 위해서
 2. 이름으로 올바르지 않은 이름을 가지는 경우  -> 올바른 이름으로 수정
 -원본 테이블의 컬럼명이 아닌 결과테이블에서만 일시적으로 바꾸어 보여주는 것
 
*/
--> select의 결과는 항상 표(결과 테이블, result table,  결과 셋, result set)로 반환됨,

--별칭을 만드는 방법(컬럼명 as 별칭)
select name as 국가명, capital as 수도명  from tblCountry;  --********제일 자주 쓰는 방법
select name 국가명, capital 수도명  from tblCountry;  -- 가독성이 낮아 쓰지 않음

select name as "국가명", capital as "수도명"  from tblCountry; --""붙이기 : 상황에 따라 씀(이름 사이에 공백을 넣어야 할 때!)
select name "국가명", capital "수도명" from tblCountry; -- 가독성이 낮아 쓰지 않음

select name as 국가명, name as "국가 이름" from tblCountry; --공백을 포함할 때(최대한 지양)
select name as "select" from tblCountry;    --쓰면 안되는 예약어나 특수문자 등등(최대한 지양)
select name, length(name) as length, area + 10 as areaPlus from tblCountry; --함수의 결과값, 연산의 결과는 반드시 alias를 만들어야 함.

select name, population as pop from tblCountry; --컬럼명이 길 때도 사용함 

--테이블명에 별칭 붙이기 (오라클에서만 as를 안씀)
select * from tblCountry c;
select c.name from tblCountry c;

--조인
select m.name, w.name from tblMen m inner join tblWomen w on m.name  = w.couple;