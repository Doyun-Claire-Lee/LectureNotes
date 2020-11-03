/*

insert문
- DML
- 데이터를 테이블에 추가하는 명령어(행, 레코드)
- insert into 테이블명(컬럼리스트) values (값리스트); 

*/

drop table tblmemo;

create table tblMemo
(
    seq number primary key,
    name varchar2(30) default '익명' not null,
    memo varchar2(1000) not null,
    regdate date default sysdate null
);

drop sequence seqmemo;
create sequence seqMemo;

--1. 표준 : 원본 테이블에 정의된 컬럼 순서대로 컬럼리스트와 값리스트를 구성하는 방식
insert into tblmemo(seq, name, memo, regdate) values (seqmemo.nextval, '홍길동', '메모입니다', sysdate); 

--2. 컬럼리스트의 순서와 값리스트의 순서는 반드시 일치해야 한다.
insert into tblmemo(seq, memo, regdate, name) values (seqmemo.nextval, '홍길동', '메모입니다', sysdate); --에러남

--3. 원본 테이블에 정의된 컬럼 순서와 insert 컬럼 순서는 무관하다.
insert into tblmemo(seq, memo, regdate, name) values (seqmemo.nextval, '메모입니다', sysdate, '홍길동'); --잘 들어감.

--4. 값이 부족한 경우
insert into tblmemo(seq, name, memo, regdate) values (seqmemo.nextval, '홍길동', sysdate);  --에러남. ORA-00947: not enough values

--5. 컬럼이 부족한 경우
insert into tblmemo(seq, name, regdate) values (seqmemo.nextval, '홍길동', '메모입니다', sysdate);  --에러남. ORA-00913: too many values

--6. null 컬럼 조작(null이 허용된 컬럼 조작, regdate)
--6-a. null 컬럼에 값을 명시적으로 대입한 경우
insert into tblmemo(seq, name, memo, regdate) values (seqmemo.nextval, '홍길동', '메모입니다', sysdate); 
--6-b. null 컬럼에 null값을 명시적으로 대입하는 경우
insert into tblmemo(seq, name, memo, regdate) values (seqmemo.nextval, '홍길동', '메모입니다', null); 
--6-c. null 컬럼에 암시적으로 대입하는 경우(default값 대입, default 없으면 null값 대입됨.)
insert into tblmemo(seq, name, memo) values (seqmemo.nextval, '홍길동', '메모입니다'); 

--7. default 
--7-a. 암시적 호출
insert into tblmemo(seq, name, memo) values (seqmemo.nextval, '홍길동', '메모입니다'); 
insert into tblmemo(seq, memo) values (seqmemo.nextval,'메모입니다'); 
--7-b. 명시적 호출(default 상수) --> 가독성을 이유로 많이 씀. 
insert into tblmemo(seq, name, memo, regdate) values (seqmemo.nextval, default, '메모입니다', default); 

--8. 단축 표현법 -> 테이블 원본의 컬럼 순서를 따른다.
insert into tblmemo values (seqmemo.nextval, '홍길동', '메모입니다', sysdate); 
insert into tblmemo values (seqmemo.nextval, '메모입니다', sysdate, '홍길동'); -->순서 바꾸기 안됨.
insert into tblmemo values (seqmemo.nextval, '홍길동', '메모입니다'); --> 생략 안됨 
insert into tblmemo values (seqmemo.nextval, default, '메모입니다', default); 


select * from tblmemo;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------
--자주 쓰는건 아님

create table tblMemo2
(
    seq number primary key,
    name varchar2(30) default '익명' not null,
    memo varchar2(1000) not null,
    regdate date default sysdate null
);

select * from tblmemo2;

insert into tblmemo2 select * from tblmemo; --서브쿼리: 한꺼번에 insert, 테이블 복사


--create + insert 
--테이블의 제약은 복사되지 않음. --> 개발용으로만 사용하는 더미데이터, 테스트용 
create table tblmemo3
as 
select * from tblmemo; 

select * from tblmemo3;  --> 데이터를 insert 한 적이 없는데도 데이터가 있음.