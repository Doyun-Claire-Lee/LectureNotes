--1. tblInsa. 입사년도별 남자와 여자 인원수를 가져오시오.(groupby+decode)
select 
    to_char(ibsadate, 'yyyy') as 입사년도,
    count(decode(substr(ssn,8,1), '1', 1)) as 남자, 
    count(decode(substr(ssn,8,1), '2', 1)) as 여자
from tblinsa
    group by to_char(ibsadate, 'yyyy')
        order by 입사년도;

--2. tblInsa. 부서별 남,여 인원수 출력. 여자인원수가 5명 이상인 부서만 가져오시오.(groupby+having+decode)
select
    buseo,
    count(decode(substr(ssn,8,1), '1', 1)) as 남자, 
    count(decode(substr(ssn,8,1), '2', 1)) as 여자
from tblinsa
    group by buseo 
        having count(decode(substr(ssn,8,1), '2', 1)) >= 5;

--3. tblInsa. 입사월별 인원수 구하기. (월, 인원수)(groupby)
--출력결과
--월     인원수
--1월    10명
--2월    25명

select 
    to_number(to_char(ibsadate, 'mm')) || '월' as 월,
    count(*) || '명' as 인원수
from tblinsa
    group by to_char(ibsadate, 'mm')
        order by to_char(ibsadate, 'mm') asc;
--> 01월.. 0을 빼야함

--4. tblInsa. 전체인원수, 2000년, 1999년, 1998년도에 입사한 인원을 다음의 형식으로 가져오시오.(decode)
--전체 2000 1999 1998
--60    x    x    x

select 
    count(*) as 전체인원수,
    replace(count(case when to_char(ibsadate, 'yyyy') = '2000' then 1 end), 0, 'X') as "2000",
    replace(count(case when to_char(ibsadate, 'yyyy') = '1999' then 1 end), 0, 'X') as "1999",
    replace(count(case when to_char(ibsadate, 'yyyy') = '1998' then 1 end), 0, 'X') as "1998"
from tblinsa;

select * from tblinsa;

--5. tblInsa. 아래 형식으로 지역별 인원수를 가져오시오(decode)
--전체 서울  인천  경기
--60    x     x     x

select 
    count(*) as 전체,
    count(decode(city, '서울', 1)) as 서울,
    count(decode(city, '인천', 1)) as 인천,
    count(decode(city, '경기', 1)) as 경기
from tblinsa;

--6. tblInsa. 부서별 기본급이 가장 높은 사람을 출력하시오.(이름, 부서, 기본급) 동급은 첫번째 사람만 출력하시오.(subquery+groupby)

select name, buseo, basicpay from tblinsa
    where (basicpay, buseo) in (select max(basicpay), buseo from tblinsa group by buseo)
        order by buseo;

--7. tblInsa. 지역(city)별로 급여(기본급+수당) 1순위 직원만 출력하시오.(급여, 직원명,주민번호,입사일,지역,부서,직위)(groupby+subquery)
select (basicpay+sudang) as 급여, name, ssn, ibsadate, city, buseo, jikwi from tblinsa
    where (city, (basicpay+sudang)) in (select city, max(basicpay+sudang) from tblinsa group by city)
        order by city;

--8. tblInsa. 부서별 인원수가 가장 많은 부서 및 인원수를 출력하시오.(groupby+subquery)
select buseo, 인원수
from 
    (select a.*, rownum as rnum 
         from (select buseo, count(*) as 인원수 from tblinsa group by buseo order by 인원수 desc) a)
            where rnum = 1;

--9. tblInsa. 여자 인원수가 가장 많은 부서 및 인원수를 출력하시오.(groupby+subquery)

select buseo, 인원수 from 
    (select a.*, rownum as rnum from 
        (select buseo, count(*) as 인원수 from tblinsa 
            where substr(ssn, 8, 1) = '2'
                group by buseo
                    order by 인원수 desc) a)
                       where rnum = 1;

--10. tblInsa. 지역(city)별 평균 급여(basicpay+sudang)가 가장 높은 지역 및 평균급여를 출력하시오(groupby+subquery)

select city, 평균급여 from 
    (select a.*, rownum as rnum from 
        (select city,round(avg(basicpay + sudang)) as 평균급여 from tblinsa
            group by city
                order by 평균급여 desc) a)
                    where rnum = 1;            

--11. tblInsa. 이름, 부서, 출신도, 기본급, 수당, 기본급+수당, 세금, 실수령액 출력하시오.(case)
--- 세금: 총급여가 250만원 이상이면 2%, 200만원 이상이면 1%, 나머지 0.
--- 실수령액: 총급여-세금

select name, buseo, city, basicpay, sudang, basicpay + sudang as 총급여,
    case
        when basicpay + sudang >= 2500000 then (basicpay + sudang) * 0.02
        when basicpay + sudang >= 2000000 and basicpay + sudang < 2500000 then (basicpay + sudang) * 0.01
        when basicpay + sudang < 2000000 then 0
    end as 세금,
        case
        when basicpay + sudang >= 2500000 then  basicpay + sudang - (basicpay + sudang) * 0.02
        when basicpay + sudang >= 2000000 and basicpay + sudang < 2500000 then  basicpay + sudang -(basicpay + sudang) * 0.01
        when basicpay + sudang < 2000000 then  basicpay + sudang
    end as 실수령액
    from tblinsa;


--12. tblInsa. 부서별 평균 급여를 출력하되, A, B, C 등급으로 나눠서 출력.
--- 200만원 초과 - A등급
--- 150~200만원 - B등급
--- 150만원 미만 - C등급

select buseo, round(avg(basicpay)) as 평균급여,
    case
        when avg(basicpay) > 2000000 then 'A등급'
        when avg(basicpay) between 1500000 and 2000000 then 'B등급'
        when avg(basicpay) < 1500000 then 'C등급'
    end as 등급
from tblinsa
    group by buseo;

--13. lotto_detail. 역대 로또 1등 당첨금(1인 당첨금)이 가장 많은 순으로 5개를 가져오시오.(subquery)
select a.*, rownum from 
    (select * from lotto_detail order by win_money desc) a
        where rownum <= 5;

--14. lotto_master. 로또 번호(1~45) 중 가장 많이 나온 숫자를 6개 가져오시오.(bonus 숫자 포함)(union+groupby+subquery)
select * from lotto_master;

select a.*, rownum from 
    (select num1, count(*) 
    from (
        select num1 from lotto_master
        union all
        select num2 from lotto_master
        union all
        select num3 from lotto_master
        union all
        select num4 from lotto_master
        union all
        select num5 from lotto_master
        union all
        select num6 from lotto_master
        union all
        select bonus from lotto_master)
            group by num1
                order by count(*) desc) a
                    where rownum <= 6;

--15. tblSubway. 승차 인원의 합보다 하차 인원의 합이 더 많은 역들을 가져오시오.(groupby+having+case+sum)
select * from tblsubway;

select 
    stationname, 
    sum(case when gubun = '하차' then passengernumber end) as 하차,
    sum(case when gubun = '승차' then passengernumber end) as 승차
        from tblsubway 
            group by stationname
                having sum(case when gubun = '하차' then passengernumber end) > sum(case when gubun = '승차' then passengernumber end) ;

--16. traffic_accident. 년도별(10년단위,1차그룹)+교통수단별(2차그룹) 총 사고 인원수와 사망자수를 가져오시오.(groupby)

select 
    case 
        when year between 1980 and 1989 then '1980년대'
        when year between 1990 and 1999 then '1990년대'
        when year between 2000 and 2009 then '2000년대'
        when year between 2010 and 2019 then '2010년대'
    end as 시기,
    trans_type,
    sum(total_acct_num) as "총 사고 인원수",
    sum(death_person_num) as 사망자수
        from traffic_accident
            group by 
                    case 
                        when year between 1980 and 1989 then '1980년대'
                        when year between 1990 and 1999 then '1990년대'
                        when year between 2000 and 2009 then '2000년대'
                        when year between 2010 and 2019 then '2010년대'
                    end, 
                    trans_type
                        order by 시기;

--17. traffic_accident. 발생 년도와 상관없이 사고당 평균 사망자수가 가장 많은 교통 수단은 무엇인가?(groupby+subquery)
select a.*, rownum from 
    (select trans_type, round(avg(death_person_num)) as 평균사망자수
        from traffic_accident
            group by trans_type
                order by 평균사망자수 desc) a
                    where rownum = 1;
        
--18. tblAddressbook. BMI(체중(kg)/키(m)^2) 지수가 30이 넘는 사람들 중 가장 많은 직업은?(subquery+groupby)

select a.*, rownum from 
    (select job, count(*) from tbladdressbook
        where weight / (height * height * 0.01 * 0.01) > 30
            group by job
                order by count(*) desc) a
                    where rownum = 1;
        
--19. tblHousekeeping. 가장 과소비를 한 날짜(Top 3)와 그 날짜에 구매한 물품 명단과 총금액을 가져오시오.(subquery+groupby+listagg)

select buydate, sum(price * qty),
    listagg (item, ', ')
    within group (order by item asc) as 물품명단 
        from tblhousekeeping
            where buydate in 
            (select buydate from 
                (select a.*, rownum from 
                    (select buydate, sum(price * qty) as 총금액 from tblhousekeeping 
                        group by buydate
                            order by 총금액 desc) a
                                where rownum <= 3))
                                    group by buydate;
                                                                
--20. tblAddressBook. 고향(hometown)을 떠나 거주(address)하는 사람들 중에서 동명이인인 사람들이 어떤 직업들을 가지고 있는가?(subquery+groupby+listagg)
select name, 
    listagg(job, ', ')
    within group (order by job asc) as 직업
        from 
            (select * from tbladdressbook 
                where instr(address, hometown) = 0)
                    group by name
                       having count(*) > 1;
