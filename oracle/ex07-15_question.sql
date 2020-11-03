--34. tblCountry. 인구가 5000 ~ 20000 사이인 국가 총 몇개입니까? 
select count(*) from tblcountry where population between 5000 and 20000; --4

--35. employees. 직업이 'IT_PROG'인 직원 중에서 급여가 5000불 넘는 직원 몇명입니까?
select count(*) from employees where job_id = 'IT_PROG' and salary > 5000; --2

--36. tblInsa. 010이 아닌 번호를 사용하는 직원은 몇명입니까?(연락처가 없는 사람 제외)
select count(*) - count(case when substr(tel, 1, 3) = '010' then 1 end) from tblinsa; --45

--37. tblInsa. 서울 사람 빼고 나머지는 모두 몇명입니까?
select count(*) - count(case when city = '서울' then 1 end) from tblinsa; --40

--38. tblInsa. 남자 직원은 모두 몇명입니까?
select count(case when substr(ssn, 8, 1) in ('1', '3') then 1 end) from tblinsa; --31

--39. tblCountry. 유럽과 아프리카에 속한 나라의 모든 인구의 합은?
select sum(population) from tblcountry where continent in ('EU', 'AF'); -- 14198

--40. employees. 매니저(108)이 관리하고 있는 직원들의 급여 총 합은?
select to_char(sum(salary), '$999,999') as salary from employees where manager_id = 108; --39600

--41. employees. 직업이 ST_CLERK, SH_CLERK인 직원들을 급여 총 합은?
select to_char(sum(salary), '$999,999') as salary from employees where job_id in ('ST_CLERK', 'SH_CLERK'); --120000

--42. tblInsa. 서울에 있는 직원들의 급여 합은(급여 + 수당)?
select sum(basicpay + sudang) from tblinsa where city = '서울'; -- 33812400

--43. tblInsa. 장급(부장+과장)들의 총 급여 합은?
select sum(basicpay) from tblinsa where jikwi in ('과장', '부장'); --36289000

--44. tblCountry. 아시아에 속한 국가의 평균 인구수는?
select avg(population) from tblcountry where continent = 'AS'; --39165

--45. employees. 이름(first_name)에 'NI'이 포함된 직원들의 평균 급여는?(대소문자 구분없이)
select avg(salary) from employees where lower(first_name) like '%' || lower('ni') || '%'; --7400

--46. tblInsa. 간부급(과장,부장)들의 평균 급여는?
select avg(basicpay) from tblinsa where jikwi in ('과장', '부장'); --2419266

--47. tblInsa. 사원급(사원,대리)들의 평균 급여는?
select avg(basicpay) from tblinsa where jikwi in ('사원', '대리'); --1268946

--48. tblCountry. 면적이 가장 넓은 나라의 면적은?
select max(area) from tblcountry; --959

--49. tblInsa. 급여(급여+수당)가 가장 적게 받는 직원의 금액은?
select min(basicpay+sudang) from tblinsa; --988000

--50. tblInsa. 직원명과 태어난 년도을 가져오되 태어난 년도를 오름차순으로 가져오시오.
select name, '19'|| substr(ssn, 1, 2) as 생년 from tblinsa order by 생년 asc ;

--51. tblInsa. 서울에 사는 여직원 중 80년대생 몇명인지?
select count(*) from tblinsa where city = '서울' and substr(ssn, 1, 1) = '8' and substr(ssn, 8, 1) = '2'; --3

--52. tblInsa. 간부급(과장/부장)들은 어떤 성(김,이,박..)들이 있는지?
select distinct substr(name, 1, 1) from tblinsa where jikwi  in ('과장', '부장'); --이 김 정 최 지 문 박 허 홍 권

--53. tblInsa. 직원들을 태어난 월순으로 정렬해서 가져오시오.(오름차순 → 월, 이름)
select * from tblinsa order by substr(ssn, 3, 2) asc, name asc;

--54. tblInsa. 모든 직원을 남자 → 여자 순으로 정렬해서 가져오시오. (같은 성별끼리는 이름순으로 정렬)
select * from tblinsa order by substr(ssn, 8, 1) asc, name asc;

--55. employees. 이름(first_name + last_name)이 가장 긴 순서대로 가져오시오.
select * from employees order by length(first_name) + length(last_name) desc;

--56. employees. 이름(first_name + last_name)이 가장 긴사람은 몇글자?
select max(length(first_name) + length(last_name)) from employees; --16

--57. employees. last_name이 5자 이상인 사람들은 first_name이 몇글자?
select length(first_name) from employees where length(last_name) >= 5;

--58. tbldiary. 다이어리를 작성한 날짜가 총 며칠분이며, 날씨가 맑음, 흐림, 비가 온 날이 각각 며칠이었는지?
select 
    count(distinct regdate) as 작성날짜, 
    count(case when weather = '맑음' then 1 end) as 맑음, 
    count(case when weather = '흐림' then 1 end) as 흐림,
    count(case when weather = '비' then 1 end) as 비 
from tbldiary;  --7 5 3 2

--59. tbldiary. 공부와 관련된 작성 게시물이 총 몇개인가?('오라클', '자바', '코딩'이 들어간 게시물 개수)
select 
    count(case when instr(subject, '오라클') > 0 then 1 end)
    +  count(case when instr(subject, '자바') > 0 then 1 end)
    +  count(case when instr(subject, '코딩') > 0 then 1 end) as 공부
from tbldiary; --3

select count(*)
from tbldiary
where instr(subject, '오라클') > 0 or instr(subject, '자바') > 0 or instr(subject, '코딩') > 0;

--60. fine_dust_standard + fine_dust. 강남구의 미세먼지(PM10) 상태가 좋음, 보통, 나쁨, 매우나쁨이 각각 며칠이었는지?
select 
    count(case when pm10 >= 71 then 1 end) as 매우나쁨,
    count(case when pm10 >= 51 and pm10 < 70 then 1 end) as 나쁨,
    count(case when pm10 >= 31 and pm10 < 50 then 1 end) as 보통,
    count(case when pm10 < 30 then 1 end) as 좋음
from fine_dust where mea_station = '강남구'; --57 93 157 127

--61. lotto_detail. 1인당 당첨금이 가장 많은 순으로 가져오시오. (1등 당첨자 수, 1등 당첨금, 총 당첨금)
select 
    win_person_no,
    win_money,
    win_person_no * win_money as 총당첨금
from lotto_detail
order by win_money desc;

--62. tblsubway. 2017년 4월 2일에 승차한 승객수가 가장 많은 순으로 가져오시오.
select * from tblsubway where boardingdate = to_date('2017-04-02', 'yyyy-mm-dd') and gubun = '승차' order by passengernumber desc;

--63. tblzoo. 다리가 있고(leg) 날지 못하는(fly) 동물들의 종(family)을 가져오시오.
select distinct family from tblzoo where leg > 0 and fly = 'n'; --포유류 양서류 조류 파충류

--65. tbltodo. 오전(0~11시)과 오후(12~23시)에 끝마친(completedate) 할일들의 개수를 각각 가져오시오.
select 
    count(case when completedate > to_date('00:00:00', 'hh24:mi:ss') and  completedate < to_date('11:00:00', 'hh24:mi:ss') then 1 end) as 오전,
    count(case when completedate > to_date('12:00:00', 'hh24:mi:ss') and  completedate < to_date('23:00:00', 'hh24:mi:ss') then 1 end) as 오후
from tbltodo; --안됨...(현재 날짜가 들어가기 때문에!) 

select
	count(*) as "총 개수",
	count(case 
		when completedate is not null then 1
	end) as "한일 개수",
	count(case
		when to_char(completedate, 'hh24') between 0 and 11 then 1
	end) as "오전",
	count(case
		when to_char(completedate, 'hh24') between 12 and 23 then 1
	end) as "오후"
from tbltodo;

select * from tbltodo;
--66. tbladdressbook. 구글 메일, 다음 메일, 네이버 메일을 사용하는 사람이 각각 몇명인지?
select * from tbladdressbook;

select 
    count(decode(substr(email, instr(email, '@')+1), 'gmail.com', 1)) as gmail,
    count(decode(substr(email, instr(email, '@')+1), 'daum.net', 1)) as daum,
    count(decode(substr(email, instr(email, '@')+1), 'naver.com', 1)) as naver
from tbladdressbook;

--67. tbladdressbook. 서울 이외의 지역에서 사는 사람들이 총 몇명인지?
select count(*) from tbladdressbook where instr(address, '서울') = 0; --772