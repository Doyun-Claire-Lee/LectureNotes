/*
메소드 , 함수, 서브루틴, 프로시저 등... 모두 같은 말

책 176p
집계함수, Aggregation function
- 다량의 데이터를 대상으로 통계값을 구하는 함수

1. count()
2. sum()
3. avg()
4. max()
5. min()
*/


/*
1. count()
- select로 얻어지는 결과셋의 레코드 수를 반환한다.
- number count(대상컬럼)
- 매개변수에는 단 1개의 컬럼명만 넣을 수 있다.
- 예외로 *을 넣을 수 있다.
- null은 제외한다. (**********)

*/

select count(name) from tblCountry;

select name from tblinsa;
select count(name) from tblinsa where city in ('서울', '인천');
select count(name) from tblinsa where ssn like '%-2%';
select count(name) from tblinsa where ssn like '%-1%';

select count(*) from tblcountry;
select name, capital from tblcountry;
select count(name, capital) from tblcountry; --에러 발생, 단 하나의 컬럼만 넣을 수 있음

select population from tblcountry;
select count (population) from tblcountry; -- null값은 세지 않음. 

select * from tbltodo;
select count(*) from tbltodo;

--null값을 가지고 있는 테이블에서 count
--완료한 일과 완료되지 않은 일을 따로 세어야 할 때
--1)
select * from tbltodo where completedate is not null;
select count(*) from tbltodo where completedate is not null;

select * from tbltodo where completedate is null;
select count(*) from tbltodo where completedate is null;
--2)
select count(*), count(completedate), count(*) - count(completedate) from tbltodo;

--총인원수, 연락처 있는사람, 없는사람의 수
select count(*) as 총인원수,
            count(tel) as 연락처있음, 
            count(*) - count(tel) as 연락처없음 
from tblinsa;

--null값을 가지고 있지 않은 테이블 count -> case 구문으로 null값을 일부러 만들어 준 후 count
--남자? 여자?
select * from tblcomedian;
select count(*) from tblcomedian where gender = 'm';
select count(*) from tblcomedian where gender = 'f';

select
    count (*) as 전체,
    count(case
        when gender = 'm' then 1 --when으로 지정하지 않으면 null을 반환함
    end) as 남자,
    count(case
        when gender = 'f' then 1 --when으로 지정하지 않으면 null을 반환함
    end) as 여자
from tblcomedian;


--모든 집계 함수 사용 시 주의점, 에러발생
--1, ORA-00937: not a single-group group function 
---> 컬럼 리스트에 집계 함수와 단일 컬럼은 동시에 가져올 수 없다.
select count(*), name from tblinsa;

--ORA-00934: group function is not allowed here
---> where절에는 집계 함수를 사용할 수 없다.
---> where 절은 개인에 대한 질문을 하는 곳, 집합값 사용이 불가능 
select avg(basicpay) from tblinsa;
select * from tblinsa where basicpay > avg(basicpay);

select name, 100 from tblinsa;
select 100 from tblinsa;
select count(100) from tblinsa;


/*

2. sum()
- number sum(대상컬럼)
- 해당 컬럼값의 총합을 구한다.
- 숫자형에만 사용 가능(문자형, 날짜형 X)


*/

select * from tblcomedian;
select sum(weight) from tblcomedian;
select sum(first) from tblcomedian; -- 문자열의 총합? 에러남(ORA-01722: invalid number)
select sum(ibsadate) from tblinsa; -- 날짜의 총합? 에러남(ORA-00932: inconsistent datatypes: expected NUMBER got DATE)

select 
    sum(basicpay), sum(sudang),
    sum(basicpay) + sum(sudang),
    sum(basicpay + sudang) 
from tblinsa;

select 
    count(case
        when gender = 'm' then 1    --1: 의미 없는 값
    end),
    sum (case
        when gender = 'm' then 1    --1: 의미 있는 값, count를 세기 위함
    end)
from tblcomedian;

/*

3. avg()
- number avg(대상컬럼)
- 해당 컬럼값의 평균값을 반환한다.
- 숫자형만 가능하다.


*/

select 
    avg(basicpay),
    sum(basicpay) / count(*)
from tblinsa;

select
    avg(population),                        -- 15588
    sum(population) / count(*), -- 14475
    sum(population) / count(population)     --15588
from tblCountry;

--회사 성과급 지급
--1. 균등 지급 : 총 지급액 / 모든 팀원 수 = sum() / count(*)
--2. 차등 지급 : 총 지급액 / 참여 팀원 수 = sum() / count(참여팀원) -> avg()***


/*

4. max()
5. min()
- object max(대상컬럼) : 최대값 반환
- object min(대상컬럼) : 최소값 반환
- 모든 자료형에 사용 가능

*/

select max(height), min(weight) from tblcomedian;
select max(name), min(name) from tblinsa;
select max(ibsadate), min(ibsadate) from tblinsa;

select
    count(*) as "총 직원 수",
    sum(basicpay) as "총 급여 합",
    avg(basicpay) as "평균 급여",
    max(basicpay) as "최대 급여",
    min(basicpay) as " 최소 급여"
from tblinsa
where buseo = '기획부';


--sum()
--tblCountry
--1. tblCountry.유럽과 아프리카 나라의 인구수 총 합
select sum(population) from tblcountry where continent in ('EU', 'AF');
--2. employees. 매니저(108)이 관리하고 있는 직원들의 급여 총합?
select sum(salary) from employees where manager_id = 108;
--3. 직업(ST_CLERK, SH_CLERK)을 가지고 있는 직원들의 급여 총합?
select sum(salary) from employees where job_id in ('ST_CLERK', 'SH_CLERK');
--4. tblinsa. 서울에 있는 직원들의 급여합(기본급+수당)
select sum(basicpay + sudang) from tblinsa where city = '서울';
--5. 부장, 과장들의 급여 총합?
select sum(basicpay + sudang) from tblinsa where jikwi in ('부장', '과장');

--avg()
--1. 아시아에 속한 국가의 평균 인구수?
select avg(population) from tblcountry where continent = 'AS';
--2. 부장, 과장의 평균 급여?
select avg(basicpay) from tblinsa where jikwi in ('부장', '과장');
--3. 부장, 과장의 평균 급여와 대리, 사원의 평균 급여 차액?
select
    avg(case 
        when jikwi = '부장' then basicpay
        when jikwi = '과장' then basicpay 
    end) -
     avg(case 
        when jikwi = '대리' then basicpay
        when jikwi = '사원' then basicpay 
    end) as 급여차이
from tblinsa ;

--max(), min()
--1. 면적이 가장 넓은 나라의 면적?
select max(area) from tblcountry;
--급여가 가장 적은 직원은 얼마를 받는지?
select min(basicpay + sudang) from tblinsa;

