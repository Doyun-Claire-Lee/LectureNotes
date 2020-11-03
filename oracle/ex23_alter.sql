/*

객체 생성: create
객체 삭제: drop
객체 수정: alter

데이터 생성: insert
데이터 삭제: delete
데이터 수정: update

테이블 수정하기, alter table
- 테이블 구조를 수정한다. > 컬럼의 정의를 수정한다.
- 되도록 테이블을 수정하는 상황을 발생시키면 안된다!!!(***)

*/
drop table tbledit;
create table tblEdit
(
    seq number primary key,
    data varchar2(20) not null
);

insert into tblEdit values (1, '마우스');
insert into tblEdit values (2, '키보드');
insert into tblEdit values (3, '모니터');

select * from tblEdit;
delete  from tbledit;


--1. 새로운 컬럼 추가하기

alter table tblEdit
    -- add (컬럼 정의);
    add (price number(5) null); --null 컬럼

alter table tblEdit
    add (description varchar2(100) not null); --not null 컬럼

alter table tblEdit
    add (description varchar2(100) default '임시' not null);


--2. 컬럼 삭제하기 

alter table tbledit
--    drop column 컬럼명
    drop column  description;

alter table tbledit
    drop column seq; --PK, FK등 의미있는 키는 삭제하면 큰일남!
    

--3. 컬럼 수정하기(자료형, 길이, 제약사항 등)

desc tbledit;

----1) 길이 조정하기
alter table tbledit
    --modify(컬럼 정의)
    modify (data varchar2(100));

alter table tbledit
    modify (data varchar2(5)); --기존 데이터보다 작은 크기로 변경하려 할 경우(오버플로우 발생) 에러나며 실행되지 않음.

----2) 자료형 바꾸기 --> 비권장
alter table tbledit 
    modify (seq varchar2(100)); --에러 발생, 실행되지 않음.
    
----3) 제약사항 바꾸기
alter table tbledit
    modify (data varchar2(100) null);
    
----4) 컬럼명 바꾸기 --> 비권장
alter table tbledit
    rename column data to name;
    
    
    
    
--테이블 구현 이후 제약사항 추가하기

drop table tbledit;
create table tblEdit
(
    seq      number,
    data    varchar2(20),
    color   varchar2(30)
);

--PK 추가하기
alter table tbledit
    add constraint tbledit_seq_pk primary key(seq);
--check 제약 추가
alter table tbledit
    add constraint tbledit_color_ck check(color in ('red', 'yellow', 'blue'));
--잘 되었는지 확인
insert into tbledit values (1, '마우스', 'red');
insert into tbledit values (1, '마우스', 'red');       --ORA-00001: unique constraint (HR.TBLEDIT_SEQ_PK) violated
insert into tbledit values (2, '마우스', 'black');    --ORA-02290: check constraint (HR.TBLEDIT_COLOR_CK) violated


--FK 추가를 위해 
drop table tbledit2;
create table tbledit2
(
    seq number primary key,
    data varchar2(20) not null,
--    pseq number not null references tbledit(seq) --> 나중에 선언?
    pseq number not null
);

--FK 추가
alter table tbledit2
    add constraint tbledit2_pseq_fk foreign key(pseq) references tbledit(seq);


--별도로 만든 제약만 삭제하기
alter table tbledit2
    drop constraint tbledit2_pseq_fk;  --> 만들었던 제약사항의 이름을 drop constraint에 넣어주면 됨.











