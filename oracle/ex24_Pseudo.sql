/*

의사 컬럼, Pseudo Column
- 실제 컬럼이 아닌데 컬럼처럼 행동하는 객체
- 오라클 전용(rownum), MS-SQL(top), MySQL(limit)
- rownum
- rownum은 from절이 실행된 직후 호출(+계산)이 된다. > 하나의 select from에서 단 한번만 실행

*/

--rownum --> 범위별로 잘라서 가져올 때 많이 쓰임.
select name, buseo, jikwi, rownum from tblinsa;

--질문의 조건에 1행이 포함이 되면 가져오기 가능, 포함되지 않으면 가져오기 불가능
--> 조건을 만족하는지 한 라인씩 확인하며 만족하지 않으면 그 라인을 지우고 다시 다음 라인부터 1번부터 번호를 매기기 때문
select name, buseo, jikwi, rownum from tblInsa where rownum = 1;
select name, buseo, jikwi, rownum from tblInsa where rownum <= 5;
select name, buseo, jikwi, rownum from tblInsa where rownum = 10; --> 아무것도 출력 안됨
select name, buseo, jikwi, rownum from tblInsa where rownum >= 5 and rownum <=10; --> 아무것도 출력 안됨


select name, buseo, jikwi, rownum from tblinsa order by name; --> rownum이 뒤죽박죽 됨. from 절때 rownum이 매겨지고 이 이후에 order by가 이루어졌기 때문


--급여를 가장 많이 받는 직원 top5 가져오기,,
select name, buseo, jikwi, basicpay, rownum from tblinsa order by basicpay desc; --> 로우넘이 뒤죽박죽, 쓰레기데이터임.
--원하는 sorting을 하고 제대로 된 rownum을 얻는 방법 --> 서브 쿼리 사용
select name, buseo, jikwi, basicpay, rownum
    from (select name, buseo, jikwi, basicpay from tblinsa order by basicpay desc) 
        where rownum <= 5;

--급여를 가장 많이 받는 직원 top6~top10 가져오기 
--특정 테이블을 대상으로 원하는 정렬을 하고 원하는 범위를 추출하고 싶으면 --> 서브쿼리를 최소 2개 이상 써야함. ==> 서브쿼리들을 view로 만들어서 사용!!
select name, buseo, jikwi, basicpay, rownum, rnum 
from 
    (select name, buseo, jikwi, basicpay, rownum as rnum
        from (select name, buseo, jikwi, basicpay from tblinsa order by basicpay desc)
    --        where rownum between 6 and 10; --> 실행 안됨. 1이 포함되어 있지 않기 때문
    )
where rnum between 6 and 10; --> rnum은 이미 서브쿼리 안에 포함된 결과가 되었으므로 새롭게 rownum이 매겨지지 않음. 그냥 데이터로 처리됨.

--view로 만들어서 사용
create or replace view vwbasicpay
as
select name, buseo, jikwi, basicpay, rownum as rnum
        from (select name, buseo, jikwi, basicpay from tblinsa order by basicpay desc);
        
select * from vwbasicpay where rnum = 3;

--=====================--
--추가 연습----------------

select * from tbladdressbook;

--지역별 거주자가 가장 많은 순서 3위..(1 포함)
select a.*, rownum from  
    (select hometown, count(*) as 인원수 from tbladdressbook
        group by  hometown
            order by 인원수 desc) a
                where  rownum <= 3;

--4~6위
select b.*, rownum from
    (select a.*, rownum as rnum
        from  
            (select hometown, count(*) as 인원수 from tbladdressbook
                group by  hometown
                    order by 인원수 desc) a) b
                        where rnum between 4 and 6;


--부서별 인원수가 두번째로 가장 많은 부서
select b.*, rownum from 
    (select a.*, rownum as rnum from
        (select buseo, count(*) from tblinsa 
            group by buseo
                order by count(*) desc) a) b
                    where rnum = 2;