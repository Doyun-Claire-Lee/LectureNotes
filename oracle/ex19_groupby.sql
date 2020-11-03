/*

group by 절
- 레코드를 특정 컬럼값(1개 or 그 이상)에 맞춰서 그룹을 나누는 역할
- 그룹을 왜 나누는지? -> 각각의 나눠진 그룹을 대상으로 집계함수를 적용하기 위함(*****)
- group by 컬럼명

select 컬럼리스트      --> 4번
from 테이블                --> 1번
where 조건                 --> 2번
group by 절                --> 3번
order by 컬럼             --> 5번 순서 

*/

--부서별 그룹 묶기
select * from tblinsa group by buseo; --ORA-00979: not a GROUP BY expression
-- group by를 쓰는 순간 컬럼리스트에 제약이 생김. 집계함수만 올 수 있다.

select count(*) from tblinsa group by buseo;

--부서별 평균 급여?
select 
    buseo, 
    round(avg(basicpay)) as 평균급여, 
    count(*) as 직원수 
from tblinsa group by buseo; --group by에 쓰인 컬럼은 컬럼리스트에 올 수 있다. 

--남자 몇명? 여자 몇명?
select gender, count(*) from tblcomedian group by gender;


select * from tbladdressbook;
select 
    job, count(*)
from tbladdressbook
group by job 
order by count(*) desc;


select * from tblinsa;
select 
    buseo, city, count(*)
from tblinsa
group by buseo, city --2차 그룹 
order by buseo;


-- group by + 집계 함수
select
    hometown as "지역",
    count(*) as "지역별 인구수",
    round(avg(weight), 1) as "지역별 평균 몸무게",
    max(weight) as "지역별 최고 몸무게",
    min(weight) as "지역별 최저 몸무게",
    sum(weight) as "지역별 몸무게 총합"
from tblAddressBook
group by hometown;


select
    nvl2(completedate, 'O', 'X'),
    count(*)
from tbltodo
group by  nvl2(completedate, 'O', 'X'); --> 가공된 결과값도 그룹의 대상으로 삼을 수 있다.


select 
    substr(ssn, 8, 1),
    count(*)
from tblinsa 
group by substr(ssn, 8, 1);

/*

having 절
- 조건절

select 컬럼리스트      --> 5번
from 테이블                --> 1번
where 조건                 --> 2번
group by 절                --> 3번
having 절                    --> 4번
order by 컬럼             --> 6번 순서 

from 절 -> where 절 : 개인에 대한 질문(조건)
group by 절 -> having 절 : 그룹(집계 함수 결과)에 대한 질문(조건)

*/

select 
    buseo, count(*)
from tblinsa
--where count(*) >= 10 --> 안됨! where 절에는 집계함수를 쓸 수 없음.
group by buseo
having count(*) >= 10; --> 그룹 전용 조건절

select 
    buseo, round(avg(basicpay))
from tblinsa
--where basicpay >= 1550000 --> 60명을 대상으로 155만원 이상 받는 사람들을 먼저 가져와서 그룹으로 묶음
group by buseo
having avg(basicpay) >= 1550000; --> 60명을 가져와서 무조건 그룹을 묶은 후 그 그룹의 평균이 155만원 이상인 내역만 출력


--날짜로 그룹 묶기
select 
    to_char(buydate, 'dd') as day,
    count(*) as 날짜별구매횟수,
    sum(qty) as 날짜별구매개수,
    max(price) as 날짜별최대단가,
    max(qty * price) as 날짜별최대구매비용
from tblhousekeeping
group by to_char(buydate, 'dd')
order by to_char(buydate, 'dd') asc;

--가격의 범위를 나눠 그 범위대로 그룹 만들기
select 
    case
        when price >= 0 and price < 3000 then '저가'
        when price >= 3000 and price < 10000 then '중가'
        when price >= 10000 then '고가'
    end as price,
    count(*)
from tblhousekeeping
group by case
        when price >= 0 and price < 3000 then '저가'
        when price >= 3000 and price < 10000 then '중가'
        when price >= 10000 then '고가'
    end;
    
    
--부서별 직급의 인원수 가져오기
select 
    buseo,
    count(*) as 인원,
    count(decode(jikwi, '부장', 1)) as 부장,
    count(decode(jikwi, '과장', 1)) as 과장,
    count(decode(jikwi, '대리', 1)) as 대리,
    count(decode(jikwi, '사원', 1)) as 사원
from tblinsa
group by buseo;


--group by 결과를 좀 더 자세하게 출력하는 함수
--rollup(), cube()
--그러나 잘 안씀.. 업무 자체가 많이 없음. 

--rollup()
select 
    buseo,
    count(*)
from tblinsa
group by rollup(buseo);

select 
    buseo,
    count(*),
    sum(basicpay),
    round(avg(basicpay)),   --rollup : 결과의 평균값
    max(basicpay),                --rollup : 결과의 최대값
    min(basicpay)                  --rollup : 결과의 최소값
from tblinsa
group by rollup(buseo);

select 
    buseo,
    jikwi,
    city,
    count(*)
from tblinsa
group by rollup(buseo, jikwi, city)
order by buseo, jikwi, city;

--cube() : 할 수 있는 모든 집계를 낸 것?
select 
    buseo,
    count(*)
from tblinsa
group by cube(buseo)
order by buseo;

select 
    buseo,
    jikwi,
    count(*)
from tblinsa
group by cube(buseo, jikwi) --cube : 1차그룹에 상관없이 2차그룹의 통계까지 내줌. 
order by buseo, jikwi;

select 
    buseo,
    jikwi,
    city,
    count(*)
from tblinsa
group by cube(buseo, jikwi, city) --cube : 1차그룹에 상관없이 2차그룹의 통계까지 내줌. 
order by buseo, jikwi, city;


--listagg
--11g 이후

select 
    buseo,
    count(*),
    listagg(name, ', ') within group(order by name asc) as name    --group by와 상관 없는 컬럼을 넣음. 
from tblinsa
group by buseo
order by buseo;

/*
<결과>
개발부	14	김신애, 엄용수, 이기상, 이기자, 이미성, 이상헌, 이성길, 이순애, 임수봉, 장인철, 정영희, 채정희, 홍길남, 황진이
기획부	7	권옥경, 김말자, 김신제, 이영숙, 이정석, 지재환, 홍길동
영업부	16	고순정, 권영미, 김미나, 김숙남, 김인수, 김정훈, 김종서, 산마루, 손인수, 양미옥, 우재옥, 유관순, 전용재, 정한나, 지수환, 홍원신
...
*/


select 
    buydate,
    count(*),
    listagg(item, ', ') within group(order by item) as item,
    sum(qty * price) as totalprice
from tblhousekeeping
group by buydate
order by buydate;

/*
<결과>
18/08/05	1	양말	10000
18/08/06	1	티셔츠	5000
18/08/07	1	수저세트	40000
...
*/
















