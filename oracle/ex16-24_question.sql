--1. tblInsa. 80년대생 남자 직원들의 평균 월급(basicpay)보다 더 많이 받는 80년대생 여직원들을 출력하시오.(subquery)
select * from tblinsa
    where basicpay > (select avg(basicpay) from tblinsa
                                          where substr(ssn, 8, 1) = '1' and substr(ssn, 1, 1) = '8') 
                                                 and substr(ssn, 8, 1) = '2' and substr(ssn, 1, 1) = '8';

--2. tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 출력하시오.(join)
select name, address, salary, p.project from tblstaff s
    inner join tblproject p
     on s.seq = p.staff;

--3. tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름?(join)
select m.name from tblMember m
    inner join tblrent r
        on m.seq = r.member
            inner join tblvideo v
                on r.video = v.seq
                    where v.name = '뽀뽀할까요';

--4. tblInsa. 평균 이상의 월급을 받는 직원들?(subquery)
select * from tblinsa 
    where basicpay > (select avg(basicpay) from tblinsa);

--5. tblStaff, tblProejct. 'TV 광고'을 담당한 직원의 월급?(join)
select s.salary from tblstaff s
    inner join tblproject p
        on s.seq = p.staff
            where p.project = 'TV 광고';

--6. tblMember. 가장 나이가 많은 회원의 주소? (bYear)(subquery)
select address from tblmember
    where byear = (select min(byear) from tblmember);

--7. tblVideo. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름?(join)
select m.name from tblmember m
    inner join tblrent r
        on m.seq = r.member
            inner join tblvideo v
                on r.video = v.seq
                    where v.name = '털미네이터';

--8. tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 출력하시오.(join)
select name, salary, p.project from tblstaff s
    inner join tblproject p
        on s.seq = p.staff
            where instr(s.address, '서울시') = 0;

--9. tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량 출력하시오.(join)
select * from tblcustomer;
select * from tblsales;

select c.tel, c.name, s.item, s.qty from tblcustomer c
    inner join tblsales s
        on c.seq = s.cseq
            where s.qty >= 2;

--10. tblVideo. 모든 비디오 제목, 보유수량, 대여가격을 출력하시오.(join)
select * from tblvideo;
select * from tblgenre;

select v.name, v.qty, g.price from tblvideo v
    inner join tblgenre g
        on v.genre = g.seq;

--11. tblVideo. 2007년 2월에 대여된 구매내역을 출력하시오. 회원명, 비디오명, 언제, 대여가격을 가져오시오.(join)
select m.name, v.name, r.rentdate, g.price from tblmember m
    inner join tblrent r
        on m.seq = r.member
            inner join tblvideo v
                on r.video = v.seq
                    inner join tblgenre g
                        on v.genre = g.seq
                            where r.rentdate between '2007-02-01' and '2007-03-01';

--12. tblVideo. 현재 반납을 안한 회원명과 비디오명, 대여날짜 출력하시오.(join)
select m.name, v.name, r.rentdate from tblmember m
    inner join tblrent r
        on m.seq = r.member
            inner join tblvideo v
                on r.video = v.seq
                    where r.retdate is null;

--13. tblInsa. basicpay+sudang가 100만원 미만, 100만원 이상~200만원 미만, 200만원 이상인 직원들의 수 출력하시오.(groupby)
select 
    case 
        when (basicpay + sudang) >= 2000000 then '200이상'
        when (basicpay + sudang) >= 1000000 and (basicpay + sudang) < 2000000 then '100이상' 
        when (basicpay + sudang) < 1000000 then '100미만'
    end as totalpay,
    count(*) 
from tblinsa 
    group by case 
        when (basicpay + sudang) >= 2000000 then '200이상'
        when (basicpay + sudang) >= 1000000 and (basicpay + sudang) < 2000000 then '100이상' 
        when (basicpay + sudang) < 1000000 then '100미만'
    end;
    
--14. tblInsa. 주민번호를 가지고 생년월일의 년도별 직원수 출력하시오.(group by)
select '19' || substr(ssn, 1, 2) as 생년, count(*) from tblinsa
    group by '19' || substr(ssn, 1, 2)
        order by 생년;

--15. tblInsa. 주민번호를 기준으로 월별 오름차순, 월이 같으면 년도 내림차순 출력하시오.(이름, 주민번호) . SUBSTR() 함수 이용.(orderby)
select name, ssn from tblinsa 
    order by substr(ssn, 3, 2) asc, substr(ssn, 1, 2) desc;

--16. tblInsa. 입사일을 기준으로  월별 오름차순, 월이 같으면 년도 내림차순 출력하시오.(orderby)
select * from tblinsa
    order by to_char(ibsadate, 'mm') asc, to_char(ibsadate, 'yyyy') desc;

--17. tblInsa. 전체인원수, 남자인원수, 여자인원수를 동시 출력하시오.(count+decode)
select 
    count(*) as 전체인원수,  
    count(decode(substr(ssn, 8, 1), '1', '남자')) as 남자인원수,
    count(decode(substr(ssn, 8, 1), '2', '여자')) as 여자인원수
from tblinsa;

--18. tblInsa. 개발부, 영업부, 총무부 인원수 출력하시오.(count+decode)

select 
    count(decode(buseo, '개발부', 1)) as 개발부,
    count(decode(buseo, '영업부', 1)) as 영업부,
    count(decode(buseo, '총무부', 1)) as 총무부
from tblinsa;

--19. tblInsa. 서울 사람의 남자와 여자의 기본급합을 출력하시오.(decode+group by)
select 
    sum(decode(substr(ssn, 8, 1), '1', basicpay)) as 남자,
    sum(decode(substr(ssn, 8, 1), '2', basicpay)) as 여자   
from tblinsa 
where city = '서울';

--> 선생님 답
select decode(substr(ssn, 8, 1), '1', '남자', '2', '여자') as 성별, sum(basicpay) as 급여합 from tblInsa
		where city = '서울'
				group by decode(substr(ssn, 8, 1), '1', '남자', '2', '여자');

--20. tblInsa. 부서별 남자와 여자 인원수를 출력하시오.(decode+group by)

select 
    buseo,
    count(decode(substr(ssn, 8, 1), '1', 1)) as 남자,
    count(decode(substr(ssn, 8, 1), '2', 1)) as 여자   
from tblinsa 
    group by buseo;

--21. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.(groupby+subquery)
select 
    count(*) as 총사원수,
    count(decode(to_char(hire_date, 'yyyy'), '2003', 1)) as "2003",
    count(decode(to_char(hire_date, 'yyyy'), '2004', 1)) as "2004",
    count(decode(to_char(hire_date, 'yyyy'), '2005', 1)) as "2005",
    count(decode(to_char(hire_date, 'yyyy'), '2006', 1)) as "2006"
from employees;

----다시풀기----
select 
    (select count(*) from employees) as 총사원수,
    count(*)
from employees
    group by to_char(hire_date, 'yyyy');
    
    
--> 선생님 답
select 
    (select count(*) from hr.employees), 
    to_char(hire_date, 'yyyy'), 
    count(*) 
from hr.employees
	group by to_char(hire_date, 'yyyy');

--22. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery)
select a.*, rownum 
    from (select name, buseo, jikwi, basicpay+sudang as totalpay 
                    from tblinsa 
                        order by basicpay + sudang desc) a;

--23. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery)
select a.*, rownum 
    from (select name, buseo, jikwi, basicpay+sudang as totalpay 
                    from tblinsa 
                        where substr(ssn, 8, 1) = '2'
                            order by basicpay + sudang desc) a;

--24. tblInsa. 여자 인원수가 (가장 많은 부서 및 인원수) 가져오시오.(rownum+subquery+groupby)
select a.*, rownum 
    from (select buseo, count(*) as 인원수 from tblinsa 
                    where substr(ssn, 8, 1) = '2'
                        group by buseo
                            order by count(*) desc) a
                                where rownum = 1;

--25. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)(subquery+groupby)
select city, count(*) as 인원수 from tblinsa
        group by city
            order by  count(*) desc;

--26. tblInsa. 부서별 인원수가 가장 많은 부서 및원수 출력하시오.(rownum+subquery+groupby)
select a.*, rownum as 순위 from 
    (select buseo, count(*) as 인원수 from tblinsa
        group by buseo
            order by count(*) desc) a
                where rownum = 1;

--27. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery+groupby)
select b.* from 
    (select a.*, rownum as rnum from 
        (select name, buseo, jikwi, (basicpay + sudang) as totalpay from tblinsa
            where substr(ssn, 8, 1) = '1'
                order by totalpay desc) a) b
                    where rnum between 3 and 5;

--28. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.(rownum+subquery)
select a.*, rownum from 
    (select * from tblinsa 
        order by ibsadate asc) a
            where rownum <= 5;
            
--29. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.(rownum+subquery)
select a.*,price * qty as totalprice, rownum from 
    (select * from tblhousekeeping 
        order by price * qty desc) a
            where rownum <= 3;

--30. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.(rownum+subquery+groupby)
select * from tblinsa
where buseo = 
(select buseo from
    (select a.*, rownum as rnum from 
        (select buseo, avg(basicpay) from tblinsa 
            group by buseo) a) b
                where rnum = 2);        

--31. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.(rownum+subquery)
select a.*, rownum from  
    (select * from tbltodo 
        where completedate is not null
            order by completedate asc) a
                where rownum <= 5;
                
--32. tblinsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마인가?