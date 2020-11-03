
--날짜 시간 함수

/*
sysdate
- 현재 시스템의 시간을 반환
-date sysdate
-자바 : Caledar.getInstance(), new Date()
*/


select sysdate from dual; --SQL에서는 매개변수가 없는 함수인 경우 일반적으로 소괄호를 생략함.
select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') from dual;

/*
날짜 시간 연산
- +, -
- 시각 - 시각 = 시간 (틱 - 틱) => **일 단위**
- 시각 + 시간 = 시각
- 시각 - 시간 = 시각
*/

select 
    name, ibsadate,
    round(sysdate - ibsadate)  as 근무일수,
    round((sysdate - ibsadate) / 365) as 근무년수 
from tblinsa
where sysdate - ibsadate > 3650
order by 근무일수 desc;

select 
    name, ibsadate,
    round((sysdate - ibsadate) * 24 * 60)as 근무분수,
    round((sysdate - ibsadate) * 24) as 근무시수,
    round(sysdate - ibsadate)  as 근무일수,
    round((sysdate - ibsadate) / 365) as 근무년수 
from tblinsa;

--시각 + 시간(일) = 시각
--시각 - 시간(일) = 시각
select sysdate + 100 from dual;
select sysdate - 100 from dual;
select sysdate + (1/24*6) from dual; -- 6시간 뒤

/*
last_day()
- 해당 시각이 포함된 달의 마지막 "날짜(date)"를 반환
- date last_day(date)
*/

select sysdate, last_day(sysdate) from dual;
select last_day(sysdate) - sysdate from dual; --이번달이 며칠 남았는지?

/*
months_between()
- number months_between(date, date)
- 시각 -시각 = 시간(일) => 몇개월 or 몇년?
*/

select 
    round(sysdate - ibsadate) as 근무일수,
    round(months_between(sysdate, ibsadate)) as 근무월수,
    round(months_between(sysdate, ibsadate) / 12) as 근무년수
from tblinsa
order by 근무일수 desc;

/*
add_months()
- date add_months(date, number(월))
- 시각 + 시간(월, 년) = 시각
*/

select 
    sysdate,
    sysdate + 90,
    add_months(sysdate, 3), --3개월 뒤
    add_months(sysdate, 3 * 12) --3년 뒤
from dual;

--★★★★★
--시각 - 시각 = 일 -> 연산자
--시각 + 일 = 시각 -> 연산자
--시각 - 시각 = 월 -> months_between()
--시각 + 월 = 시각 -> add_months()
-- + last_day()

