/*
1. select절
2. from 절
3. where 절
4. order by절
*/

/*

정렬, sort
- order by 절
- select문과 같이 사용
- 원본 테이블을 정렬(X) -> 결과 테이블 정렬(O)
- 정렬의 기준으로 컬럼을 지정한다.
- 오름차순, 내림차순
- order by 컬럼명 [asc or desc] -> 생략하면 오름차순(asc)

*/

select * from tblInsa order by name asc;
select * from tblInsa order by name desc;

--정렬 대상으로 가능한 자료형 : 숫자, 문자, 날짜
select * from tblInsa order by basicpay + sudang desc;
select * from tblinsa order by ibsadate desc;

--부장(4), 과장(3), 대리(2), 사원(1)순으로 출력하고 싶을 때...
select 
    name, 
    jikwi,
    case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
    end as lv
from tblinsa 
order by lv desc;

select 
    name, jikwi
from tblinsa 
order by 
    case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
    end desc;

select name, jikwi
from tblinsa
where jikwi in ('과장', '부장');

select name, jikwi
from tblinsa
where case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
    end >= 3;


--다중 정렬
select * from tblinsa order by city asc, buseo desc, name asc;
