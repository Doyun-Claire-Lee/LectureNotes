/*

select 문
- select 컬럼리스트 from 테이블;
- select 컬럼리스트 from 테이블 where 조건;

컬럼리스트(조건)
- 가져올 컬럼(열)을 지정

where 절(조건절)
- 가져올 레코드(행)를 지정할 조건을 명시한다.
- 조건을 제시하면 그 조건을 모든 행을 대상으로 검사하여 만족하는 경우 결과셋에 포함시키고, 만족하지 못하는 경우 결과셋에서 제외시킴.
- 비교연산자 & 논리연산자 사용

실행 순서
1. from 테이블
    - 가져올 테이블을 선택(데이터 소스를 선택)
2. where 조건
    - 가져올 행을 검사(조건에 맞는 행만 걸러내기)
3. select 컬럼리스트
    - where을 통해 걸러진 나머지 결과셋에서 원하는 컬럼만 가져온다.



*/

select name, continent from tblcountry where continent = 'AS';
select name, city, buseo, jikwi from tblinsa where city = '서울' and buseo = '기획부';
select * from tblHouseKeeping where qty >= 10;
select * from tblHouseKeeping where price * qty > 30000;

-- tblComedian
select * from tblcomedian where weight >= 60 and height < 170 ;
select * from tblcomedian where gender = 'f';

--tblInsa
select * from tblinsa where buseo = '개발부' and basicpay >= 1500000;
select * from tblinsa where basicpay + sudang >= 2000000 and city = '서울';

/*
조건절(where)에서 사용되는 여러 구문(연산자 or 함수 등)

1. between ~ and
 - where절에서 사용(조건으로 사용)
 - 범위 조건 
 - 컬럼명 between A(최소값) and B(최대값)
 - A, B : 포함하여 출력됨(inclusive)
 - 비교연산자가 절대 속도가 더 빠르기 때문에 회사에 따라  between 연산자를 쓰지 말라는 회사도 있음. 
 
 */
 
 --몸무게가 60~70인 사람?
 select * from tblcomedian where weight >= 60 and weight <= 70;
 select * from tblcomedian where weight between 60 and 70;
  
 --비교 연산에 사용 가능한 자료형
 --1) 숫자형(number)
select * from tblinsa where sudang >= 150000;
select * from tblinsa where sudang >= 150000 and sudang <= 180000;
select * from tblinsa where sudang between 150000 and 180000;

--2) 문자형
select * from tblinsa where name >= '박';
select * from tblinsa where name >= '박길동' and name <= '최길동';
select * from tblinsa where name between '박' and '최';

--3) 날짜시간형(date)
desc tblinsa;
select * from tblinsa where ibsadate >= '2010-01-01';
select * from tblinsa where ibsadate >= '2010-01-01' and ibsadate <= '2010-12-31';
select * from tblinsa where ibsadate BETWEEN '2010-01-01' and '2010-12-31';

/*

2. in
- where 절에서 사용(조건으로  사용)
- 열거형 조건(제시된 값 중 하나라도 일치하면 만족)
- 컬럼명 in(값, 값, 값....)

*/

--tblCountry. AS, EU
select * from tblcountry where continent = 'AS' or continent = 'EU';
select * from tblcountry where continent in ('AS', 'EU');

select * from tblinsa where buseo in ('개발부', '홍보부', '총무부');
select * from tblinsa where jikwi in ('부장', '과장') and city in ('서울', '인천') and basicpay between 2500000 and 2600000;

/*

3. like
- where절에서 사용(조건으로 사용)
- 패턴 비교
- 문자형을 대상으로 사용(숫자형, 날짜형 사용 X)
- 컬럼명 like '패턴문자열'

패턴 문자열 구성 요소
    1) _ : 임의의 문자 1개
    2) % : 임의이 문자 n(0~무한대)개
    
*/

select * from tblinsa where name like '김__';
select * from tblinsa where name like '김%';
select * from tblinsa where name like '_정_';
select * from tblinsa where name like '__동';
select * from tblinsa where ssn like '______-2%';
select * from tblinsa where ssn like '______-1%';
select * from tblinsa where tel like '011%';

select * from tblcountry where name like '%국';
select * from tblcountry where name like '_국';

-- SQL은 구문(문법)에서는 대소문자를 구분하지 않지만 데이터에서는 구분한다.
select * from employees where first_name like 'A%';
select * from employees where first_name like 'a%';

select * from employees where first_name like '%a';
select * from employees where first_name like '%a%';
select * from employees where first_name like '%a%e%';

/*

4. null
- where 절에서 사용(조건으로 사용)
- 해당 컬럼이 null인지 질문
- 컬럼명 is null

RDBMS에서의 null
- 자바의 null과 유사
- 컬럼이 비어있는 상태(셀)
- null이라고 직접 표현 가눙
- 대다수의 언어에서 null은 연산의 대상이 되 수 없다, (컬럼명 = null -> 이런 대입연산자도 안됨)
- null 리터럴 /  not null 리터럴

*/

select * from tblcountry;
select * from tblcountry where population is  null;
select * from tblcountry where not population is null;
select * from tblcountry where population is not null;

select * from tbltodo where completedate is not null;
select * from tbltodo where completedate is null;

