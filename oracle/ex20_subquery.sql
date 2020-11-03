/*

Main Query, 메인 쿼리
- 하나의 select(insert, update, delete)로만 되어있는 쿼리


Sub Query, 서브 쿼리
- 여러개의 select를 사용하는 쿼리
- 하나의 쿼리(select, insert, update, delete) 안에 또다른 *select*가 들어있는 쿼리
- 삽입 위치: select절, from절, where절, order by절, group by절 등...
- 의존도 높음*******중요********


*/


--인구수가 가장 많은 나라의 인구수? -> 그 나라의 이름? 
select name, population from tblcountry;

select max(population) from tblcountry; --> 120660을 반환
select name from tblcountry where population = 120660; --> 인구수는 계속 변경되는 데이터이기 때문에 쿼리를 계속 변경해야 하는 문제점이 생김.
select name from tblcountry where population = (select max(population) from tblcountry); --> 인구수를 반환했던 쿼리를 where절 안에 삽입, 괄호로 묶어주어야 함.

--체중이 가장 많이 나가는 사람의 이름?
select max(weight) from tblcomedian;
select last || first from tblcomedian where weight = (select max(weight) from tblcomedian);

--급여를 가장 적게 받는 사람의 이름?
select name from tblinsa where basicpay = (select min(basicpay) from tblinsa);

--평규 급여보다 더 많이 받는 직원 명단?
select name from tblinsa where basicpay > (select avg(basicpay) from tblinsa);

--홍길동과 같은 부서에서 근무하는 직원 명단?
select name from tblinsa where buseo = (select buseo from tblinsa where name = '홍길동');

--여러 테이블이 합쳐진 서브쿼리

--키가 166, 몸무게 55 남자의 여자친구 나이
select * from tblmen;
select * from tblwomen;

select age from tblwomen where couple = (select name from tblmen where height = 166 and weight = 55);


/*

서브쿼리의 용도

1. 조건절에서 비교값으로 사용
    a. 반환값이 1행 1열 -> 레코드가 하나만 나오는 쿼리 = 스칼라 쿼리 -> 연산자를 사용해 비교한다. (상수와 같은 처리)
    b. 반환값이 N행 1열 -> in 연산자를 사용해서 비교한다.
    c. 반환값이 1행 N열 -> 스칼라 쿼리 -> 연산자를 사용해 비교한다. (괄호로 비교할 대상을 묶어줌)
    d. 반환값이 N행 N열 -> b + c 조합
    
*/

select * from tblinsa where basicpay = (select max(basicpay) from tblinsa);

--급여가 250만원 이상 받는 직원의 부서를 알아내 같은 부서 직원들의 명단 반환, (N행 1열)
select * from tblinsa where buseo = (select buseo from tblinsa where basicpay >= 2500000); --> 에러남. ORA-01427: single-row subquery returns more than one row
select * from tblinsa where buseo in (select buseo from tblinsa where basicpay >= 2500000);

--'홍길동'과 같은 지역 + 같은 직위인 사람(1행 N열)
select * from tblinsa where city = (select city from tblinsa where name = '홍길동') and jikwi = (select jikwi from tblinsa where name = '홍길동'); --> 이렇게 안함! 같은 상수(홍길동)이 두번 반복되기 때문에 위험하기도 함.
select * from tblinsa where (city, jikwi) = (select city, jikwi from tblinsa where name = '홍길동'); --> 괄호로 묶어 짝맞춰줌.

--급여 260 이상 직원의 부서와 지역을 알아내 동일한 직원 명단(N행 N열)
--질문을 만들기도 힘들어서 잘 안쓰임.
select * from tblinsa where (buseo, city) = (select buseo, city from tblinsa where basicpay >= 2600000); --> 에러남. 
select * from tblinsa where (buseo, city) in (select buseo, city from tblinsa where basicpay >= 2600000);

/*

2. 컬럼리스트에서 사용
    a. 반드시 1행 1열의 결과만 사용 가능하다. 상수 1개의 역할을 하기 때문
    b. 컬럼리스트에서 사용되는 서브쿼리 종류
            1) 정적 쿼리 : 바깥쪽 테이블의 모든 행에 대해 동일한 값을 갖는 경우
            2) 상관 서브 쿼리 ★★★ : 바깥쪽 테이블의 결과를 서브 쿼리와 연동했을 때
            
*/

--정적 쿼리
select name, buseo, jikwi, basicpay, (select round(avg(basicpay)) from tblinsa)from tblinsa;

select 
    name, buseo, jikwi, basicpay, 
    (select city from tblinsa where num = 1001)
from tblinsa;

--상관 서브 쿼리★★★★★★★★★★★★
--데이터를 각 부서별 평균 급여와 함께 출력하라
select 
    name, buseo, jikwi, basicpay, 
    (select round(avg(basicpay)) from tblinsa where buseo = a.buseo)
from tblinsa a; --> table에 alias를 생성해줌. (table alias는 as를 안붙임)

--남자테이블의 정보와 여자친구의 나이를 함께 출력
select name, age, couple, (select age from tblwomen where name = tblmen.couple) as age from tblmen;


/*

3. from 절에서 사용
    - 서브쿼리의 결과셋을 독립적인 하나의 테이블이라 생각하고 from절에서 사용
    - 이 때의 서브쿼리를 인라인 뷰(Inline view)라고 함.
    - alias 주의! -> 서브쿼리 안에서 alias를 붙이면 그 이후부터는 계속 alias로 호출해야 함. 

*/

--모든 select의 결과는 테이블이기 때문에 그 결과에서 또 select를 할 수 있음. (임시 테이블 용도로 사용?)
select * from (select num, name, jikwi, city from tblinsa where buseo = '기획부');

select * from (select num as 번호, name, jikwi, city from tblinsa where buseo = '기획부') where num = 1001; --> 에러남. num을 '번호'로 변경했기 때문에!(개명)
select * from (select num as 번호, name, jikwi, city from tblinsa where buseo = '기획부') where 번호 = 1001;

/*
4. order by, group by, having절 등에서 사용...
*/



























































