/*

뷰, view
- DB object중 하나 (테이블, 시퀀스, 제약사항, 뷰)
- 가상테이블, 테이블의 복사본, 뷰테이블
- 실제 테이블처럼 취급하는 객체

뷰의 용도
- 가독성 향상
- 자주 사용하는 select를 저장해놓는 객체(***********) --> 원본 테이블의 데이터를 수정해도 view에 반영됨.
- 마치 서브쿼리와 같은 형태


- 팀 작업시 view가 없으면,, 원래 쿼리를 텍스트로 전달해주는 방법밖에 없음.
- 만약 쿼리를 수정해야 하면 그 쿼리를 다시 전달해주어야 함.
- view를 만들면 DB자체에 객체로 저장이 되기 때문에 따로 전달해 줄 필요가 없다.
- view는 수정이 간편함..

View를 만들어야 하는 경우
- 1. 덩치가 큰 쿼리
- 2. 반복되는 쿼리

View의 종류
- 1. 단순 뷰
    - 하나의 기본 테이블을 사용해 만든 뷰
    - CRUD 가능..(모든 컬럼을 가져왔다면..) 그러나 Read(Select)만 하기
- 2. 복합 뷰
    - 두 개 이상의 기본 테이블을 사용해 만든 뷰
    - 조인, 서브쿼리 
    - Read만 가능(Select)

*/

create view vwinsa
as 
select * from tblinsa;

select * from vwinsa;

--tblinsa 에서 남자직원만 가져오는 쿼리를 가져올 상황이 잦은 경우..
create view temp
as
select num, name, ssn, tel, jikwi from tblinsa
    where substr(ssn, 8, 1) = 1 and buseo = '기획부';

select * from temp;

drop view vwvideo;

--create view vwvideo
create or replace view video --기존의 view를 수정하는 명령어(간편)
as
select 
    m.name as 회원명,
    v.name as 비디오제목,
    g.period as 대여기간,
    r.rentdate as 대여날짜,
    case
        when r.retdate is null then '반납X'
        when r.retdate is not null then '반납O'
    end as 반납상태
from tblgenre g
    inner join tblvideo v
        on g.seq = v. genre
            inner join tblrent r
                on v.seq = r.video
                    inner join tblmember m
                        on m.seq = r.member;



--서울에 사는 직원들만 보여주는 view
create or replace view vwseoul
as
select * from tblinsa where city = '서울';    --view : 원본을 복사

select  * from vwseoul; --(홍길동 포함)

--서울에 살던 홍길동이 이사감..
update tblinsa set city = '부산' where name = '홍길동';      --원본 수정

select * from tblinsa;
select  * from vwseoul; --(홍길동 사라짐!), 쿼리 자체를 view에 저장하고 있기 때문에 원본을 수정해도 view 결과가 달라짐.

rollback;



--View를 사용할 때 주의점(정말 테이블처럼 취급되는지?)
--1. select 대상 : 실행 잘 됨.   --> view는 읽기 전용으로만 사용한다. (********)

--2. insert 대상 : 실행 잘 됨.    --> 절대 사용 금지!!
--3. update 대상 : 실행 잘 됨.  --> 절대 사용 금지!!
--4. delete 대상 : 실행 잘 됨    --> 절대 사용 금지!!
--==> 2, 3, 4는 안되는 경우도 많음. (전체 칼럼을 가져오는 경우가 아닐 때) 

select * from vwseoul;
insert into vwseoul values (1061, '아무개', '951010-1234567', sysdate, '서울', '010-1234-1234', '기획부', '사원', 2500000, 200000);
update vwseoul set buseo = '영업부' where num = 1061;
delete vwseoul where num = 1061;









































