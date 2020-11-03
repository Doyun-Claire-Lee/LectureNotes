/*

형변환 함수

1. to_char()        : 숫자 -> 문자
2. to_char()        : 날짜 -> 문자 ★★★★★
3. to_number()  : 문자 -> 숫자
4. to_date()        : 문자 -> 날짜 ★★★★★

*/


/*
1. to_char()
- chat to_char(대상 컬럼, 형식문자열)

- 형식문자열 구성요소
    a. 9
    b. 0
    c. $
    d. L
    e. .
    f. ,
 
 */
 
select 
    100 as 컬럼입니다,        --숫자: 우측정렬
    '100' as 컬럼입니다,      --문자: 좌측정렬
    to_char(100) as 컬럼입니다,
    to_char(100, '999') as 컬럼입니다,   --한 칸이 자동으로 띄워짐, (부호 자리)   
    to_char(-100, '999') as 컬럼입니다,   
    to_char(10, '999') as 컬럼입니다,
    trim(to_char(100, '999')) as 컬럼입니다, --trim처리도 됨
    to_char(1, '999') as 컬럼입니다,
    to_char(1000, '999') as 컬럼입니다,  --일종의 에러가 남. (#### 반환)
    to_char(100, '000') as 컬럼입니다,   
    to_char(10, '000') as 컬럼입니다,
    to_char(1, '000') as 컬럼입니다,
    to_char(1000, '000') as 컬럼입니다   --일종의 에러가 남. (#### 반환)
from dual;
 
select 
    100,
    to_char(100, '$999'), --통화(Currency)
    to_char(100, '999') || '원',
    to_char(100, 'L999')    -- Locale(지역 설정)
from dual;
 
select
    1234567,
    to_char(1234567, '9,999,999'), --자동화 되어있지 않음.
    to_char(123.456, '999.999'),
    to_char(123.456, '99999.9') --소수 이하 자릿수 반올림 
from dual;
  

/*

2. to_char()
- char to_char(대상 컬럼, '형식 문자열')

형식 문자열 구성요소
    a. yyyy ★★
    b. yy
    c. month
    d. mon
    e. mm ★★
    f. day
    g. dy
    h. ddd, dd ★★, d
    i. hh, hh24 ★★
    j. mi ★★
    k. ss ★★
    l. am(pm)
 
 */
 
select to_char(sysdate, 'yyyy') from dual;          --2020(4자리)
select to_char(sysdate, 'yy') from dual;                --20(2자리)
select to_char(sysdate, 'month') from dual;         --5월(풀네임)
select to_char(sysdate, 'mon') from dual;              --5월(약어)
select to_char(sysdate, 'mm') from dual;                --05(2자리)
select to_char(sysdate, 'day') from dual;               --월요일(풀네임)
select to_char(sysdate, 'dy') from dual;                --월(약어)
select to_char(sysdate, 'ddd') from dual;               --146(올해의 며칠째)
select to_char(sysdate, 'dd') from dual;                --25(이번달 며칠째) 
select to_char(sysdate, 'd') from dual;                 --2(이번주 며칠째, 요일)
select to_char(sysdate, 'hh') from dual;                --04(12시)
select to_char(sysdate, 'hh24') from dual;              --16(24시)
select to_char(sysdate, 'mi') from dual;                    --10(분)
select to_char(sysdate, 'ss') from dual;                    --38(초)
select to_char(sysdate, 'am') from dual;                    --오후
select to_char(sysdate, 'pm') from dual;                    --오후
 
select 
    sysdate, 
    to_char(sysdate, 'yyyy-mm-dd') as 날짜,
    to_char(sysdate, 'hh24:mi:ss') as 시각,
    to_char(sysdate, 'day am hh:mi:ss') as 시각2   
from dual;

--컬럼리스트에서 사용 
select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') from dual; --★★★★★ 꼭 기억!

--조건절에서 사용
select name, ibsadate, to_char(ibsadate, 'day') 
from tblinsa
--where ibsadate BETWEEN '2010-01-01' and '2010-12-31';  --> 시분초를 지정해주지 않을 경우 00:00:00이라 생각하기 때문에 12월 31일의 데이터가 빠져있음.
--where to_char(ibsadate, 'yyyy') = '2010';
--where to_char(ibsadate, 'd') = 2; --> 월요일에 입사한 사람들만
where to_char(ibsadate, 'd') in (1, 7); --> 주말에 입사한 사람들만

--정렬에서 사용
select name, ibsadate, to_char(ibsadate, 'day')  
from tblinsa
order by to_char(ibsadate, 'd') asc;
 
select distinct to_char(ibsadate, 'day') from tblinsa;

--요일별 입사 사원수 
select 
    count(decode(to_char(ibsadate, 'dy'), '일', 1)) as 일,
    count(decode(to_char(ibsadate, 'dy'), '월', 1)) as 월,
    count(decode(to_char(ibsadate, 'dy'), '화', 1)) as 화,
    count(decode(to_char(ibsadate, 'dy'), '수', 1)) as 수,
    count(decode(to_char(ibsadate, 'dy'), '목', 1)) as 목,
    count(decode(to_char(ibsadate, 'dy'), '금', 1)) as 금,
    count(decode(to_char(ibsadate, 'dy'), '토', 1)) as 토
from tblinsa;


/*
3. to_number()
- number to_number(대상 컬럼)
- 잘 사용 안함
*/

select '123', to_number('123') from dual;
select 123 * 2, '123' * 2, to_number('123') * 2 from dual; --> 연산시 암시적 형변환이 발생함.


/*
4. to_date()
- date to_date(대상 컬럼, '형식문자열')
- 형식 문자열은 to_char()와 동일하게 사용

- 원래 오라클은 날짜 리터럴이 없다. 암시적 형변환이 일어남. 
*/

select sysdate, '2010-01-01' from dual; --> '2010-01-01'은 문자열임.

select sysdate, to_date('2010-01-01', 'yyyy-dd-mm') from dual; -->  형식문자는 앞의 문자열과 똑같은 형식으로 맞추어야 함.
select sysdate, to_date('20100101', 'yyyyddmm') from dual; -->  형식문자는 앞의 문자열과 똑같은 형식으로 맞추어야 함.

select * from tblinsa where ibsadate  > '2010-01-01'; --> 암시적 형변환 발생, to_date()가 호출됨.
select * from tblinsa where ibsadate  > to_date('2010-01-01', 'yyyy-mm-dd'); --> 올바른 사용법

select * from tblinsa where ibsadate  > '2010-01-01 12:00:00'; --> 오류남. 안됨.
select * from tblinsa where ibsadate  > to_date('2010-01-01 12:00:00', 'yyyy-mm-dd hh24:mi:ss'); --> 날짜+시분초를 date자료로 바꾸는 유일한 방법

select '14:23:45', to_date('14:23:45', 'hh24:mi:ss') from dual; --> 년월일 정보가 없으면 해당 월의 1일로 채워짐. 권장X


/*
null 함수
1. nvl() -> null value
- object nvl(대상 컬럼, object)
2. nvl2()
- object nvl2(대상 컬럼, object, object)
*/

select name, nvl(couple, '여자친구 없음'),  nvl2(couple, 'O', 'X') as 여자친구유무
from tblmen;


-- 6장 + 7-1절