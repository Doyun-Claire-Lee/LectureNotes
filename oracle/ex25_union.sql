/*

조인, join
- 테이블을 합치는 기술
- 횡(가로)로 합치기

유니온, union
- 테이블을 합치는 기술
- 종(세로) 합치기 
- union, union all, intersect, minus

union 주의점
1. 컬럼 갯수
2. 컬럼 타입

*/

select * from tblmen;
select * from tblwomen;

--inner join -> 커플인 남녀 정보만
select * from tblmen m
    inner join tblwomen w
        on m.couple = w.name;

--outer join, 커플 + 남자 모두 
select * from tblmen m
    left outer join  tblwomen w
        on m.couple = w.name;
        
--outer join, 커플 + 여자 모두
select * from tblmen m
    right outer join tblwomen w
        on m.couple = w.name;
        
--outer join, 커플 + 여자 + 남자 모두
select * from tblmen m
    full outer join tblwomen w
        on m.couple = w.name;
        
--union---------------
select * from tblmen
union
select * from tblwomen;

select name, age, height from tblmen
union
--select * from tblwomen;        --> 에러남. 위의 테이블과 컬럼의 개수가 맞지 않기 때문
--select name, age, couple from tblwomen  --> 에러남. 데이터 타입도 맞추어야 함.
select name, age, height from tblwomen;


--하면 안되는 행동
select age from tblmen
union
select population from tblcountry; --> 두 테이블의 데이터의 성격이 맞지 않음. 실행은 되지만 하지 말기

select * from tblinsa;
select * from tbladdressbook;

select name, tel from tblinsa
union
select name, tel from tbladdressbook;


create table tblunionA
(name varchar2(30) not null);

create table  tblunionB
(name varchar2(30) not null);
        
 insert into tblunionA values ('사과');       
 insert into tblunionA values ('바나나');
 insert into tblunionA values ('파인애플');
 insert into tblunionA values ('망고');
 insert into tblunionA values ('귤');
        
 insert into tblunionB values ('자두');
 insert into tblunionB values ('복숭아');
 insert into tblunionB values ('포도');
 insert into tblunionB values ('딸기');
 insert into tblunionB values ('파인애플');
        
--합집합, 중복값을 없애버림.(파인애플)
select * from tblunionA
union
select * from tblunionB;

--중복값을 그대로 보관
select * from tblunionA
union all
select * from tblunionB;

--교집합, 중복값만 출력해줌
select * from tblunionA
intersect
select * from tblunionB;

--차집합, A집합에서 B를 빼줌(순서 중요)
select * from tblunionA
minus
select * from tblunionB;
        
        
