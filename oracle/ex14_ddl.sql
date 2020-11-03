/*

DDL
- 데이터 정의어
- 데이터베이스 객체를 생성, 수정, 삭제한다.
- 데이터베이스 객체 : 테이블, 뷰, 트리거, 인덱스, 프로시저, 제약사항 등..
- create, alter, drop

- 오브젝트 생성이기 때문에 한번 만들면 반영구적으로 쓰임.


테이블 생성하기

create table 테이블명
(
    컬럼 정의, 
    컬럼 정의, ...
    컬럼명 자료형(길이) null 제약사항 
);


제약사항, Constraint ★★★★★★★★★★
- 해당 컬럼에 들어갈 데이터(값)에 대한 조건 명시(규제), 일종의 유효성검사 + 추가 사항들...

1. not null
    - 해당 컬럼이 반드시 값을 가져야 한다.
    - 해당 컬럼에 값이 없으면 에러 발생
    - 필수값
    
2. primary key
    - PK
    - 기본키 = 기본(대표) + 키(컬럼)
    - 행과 행을 구분하는 역할 
    - 값이 유일해야 한다.(unique)
    - 값을 반드시 가져야 한다. (not null)
    - primary key = unique + not null
    - *** 반드시 모든 테이블은 기본키를 가져야 한다.
    - 기본키 형태
        a. 단일 기본키(기본키) : 1개의 역할이 PK역할
        b. 복합 기본키(복합키) : 2개 이상의 컬럼이 모여서 PK역할

3. foreign key
    - 나중에...

4. unique
    - primary key - not null = unique
    - 중복값은 허용하지 않는다.
    - null은 허용한다.
    - 행을 구분하는 식별자로 사용이 불가능하다.
    - 잘 안씀..
    
5. check
    - 사용자 정의 조건을 제약으로 추가할 수 있다.
    - where절에서 사용하던 조건들을 사용 가능
    - 다양하게 많이 씀.
    
6. default
    - 기본값 설정
    - 해당 컬럼값을 대입하지 않으면(null), null대신 미리 준비해놓은 값을 대입한다.
    
*/

-------------------------------------------------------------------------------------------------------------------------------------

--메모 테이블 생성하기(일단 제약 없이)
create table tblMemo
(
    --컬럼명 자료형(길이) 제약사항
    seq number,                     --메모번호
    name varchar2(30),        --작성자
    memo varchar2(1000),   --메모 내용
    regdate date                    --작성 날짜
);

--데이터 추가하기
--자료형 틀리지 말기, 길이제한 오버플로우 주의, 날짜형 데이터 형식문자 주의 
insert into tblMemo (seq, name, memo, regdate) values (1, '홍길동', '메모입니다', sysdate);
insert into tblMemo (seq, name, memo, regdate) values ('둘', '홍길동', '메모입니다', sysdate); --ORA-01722: invalid number 에러 
insert into tblMemo (seq, name, memo, regdate) values ('2', '홍길동', '메모입니다', sysdate);  --'2': 암시적 형변환(to_number() 자동 호출됨), 그러나 맞는 자료형을 삽입하기
insert into tblMemo (seq, name, memo, regdate) values (3, '홍길동홍길동홍길동홍길동', '메모입니다.', sysdate); --30바이트 넘어서 에러
insert into tblMemo (seq, name, memo, regdate) values (4, '홍길동', '메모입니다', '2020-05-30'); --날짜가 들어가지만 시분초는 00:00:00으로 지정됨.
insert into tblMemo (seq, name, memo, regdate) values (5, '홍길동', '메모입니다', to_date('2020-05-30 14:30:00', 'yyyy-mm-dd hh24:mi:ss'));


--데이터 가져오기
select seq, name, memo, to_char(regdate, 'hh24:mi:ss') from tblMemo;

--테이블 삭제하기
drop table tblMemo;

-------------------------------------------------------------------------------------------------------------------------------------

--테이블 다시 만들기(null 제약)
create table tblMemo
(
    --null 제약사항(적지 않으면 기본으로 null)
    seq number not null,                       --메모번호
    name varchar2(30) null,                --작성자
    memo varchar2(1000) not null,   --메모 내용
    regdate date null                             --작성 날짜
);

insert into tblMemo (seq, name, memo, regdate) values (1, '홍길동', '메모입니다', sysdate);
insert into tblMemo (seq, name, memo, regdate) values (2, '홍길동', null, sysdate); --ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."MEMO")
insert into tblMemo (seq, name, memo, regdate) values (2, null, '메모입니다', sysdate); --

select seq, name, memo, to_char(regdate, 'hh24:mi:ss') from tblMemo;


--테이블 삭제하기
drop table tblMemo;

-------------------------------------------------------------------------------------------------------------------------------------

select * from tblCountry; --Name이 기본키
select * from tblinsa; --사원번호, 주민등록번호가 기본키가 될 수 있음.

--테이블 다시 만들기(기본키)
create table tblMemo
(
    --Primary Key 설정 
    seq number primary key,               --메모번호(PK)
    name varchar2(30) null,                --작성자
    memo varchar2(1000) not null,   --메모 내용
    regdate date null                             --작성 날짜
);

insert into tblMemo (seq, name, memo, regdate) values (1, '홍길동', '메모입니다', sysdate); 
insert into tblMemo (seq, name, memo, regdate) values (1, '홍길동', '메모입니다', sysdate); --ORA-00001: unique constraint (HR.SYS_C007088) violated
insert into tblMemo (seq, name, memo, regdate) values (2, '홍길동', '메모입니다', sysdate);
insert into tblMemo (seq, name, memo, regdate) values (null, '홍길동', '메모입니다', sysdate); --ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."SEQ")


select seq, name, memo, to_char(regdate, 'hh24:mi:ss') from tblMemo;

--테이블 삭제하기
drop table tblMemo;

-------------------------------------------------------------------------------------------------------------------------------------

--테이블 다시 만들기(Unique)
create table tblMemo
(
    --null 제약사항(적지 않으면 기본으로 null)
    seq number primary key,               --메모번호(PK)
    name varchar2(30) unique,          --작성자(unique + null)
    memo varchar2(1000) not null,   --메모 내용
    regdate date null                             --작성 날짜
);

insert into tblMemo (seq, name, memo, regdate) values (1, '홍길동', '메모입니다', sysdate);
insert into tblMemo (seq, name, memo, regdate) values (2, '홍길동', '메모입니다', sysdate); --'홍길동'은 중복되면 안됨.
insert into tblMemo (seq, name, memo, regdate) values (2, null, '메모입니다', sysdate);
insert into tblMemo (seq, name, memo, regdate) values (3, null, '메모입니다', sysdate); -- null은 중복값으로 보지 않음.

select seq, name, memo, to_char(regdate, 'hh24:mi:ss') from tblMemo;

--테이블 삭제하기
drop table tblMemo;

-------------------------------------------------------------------------------------------------------------------------------------

--테이블 다시 만들기(check 제약)
create table tblMemo
(
    seq number primary key,               --메모번호(PK)
    name varchar2(30),                        --작성자
    memo varchar2(1000) not null,   --메모 내용
    regdate date null,                             --작성 날짜
    color varchar2(30) check(color in ('red', 'green', 'black')) not null,             --메모 색상('red', 'green'. 'black')
    prio number not null check(prio between 1 and 100)
);

insert into tblMemo (seq, name, memo, regdate, color, prio) values (1, '홍길동', '메모입니다', sysdate, 'red', 100);
insert into tblMemo (seq, name, memo, regdate, color, prio) values (2, '홍길동', '메모입니다', sysdate, 'yellow', 100); --ORA-02290: check constraint (HR.SYS_C007102) violated
insert into tblMemo (seq, name, memo, regdate, color, prio) values (3, '홍길동', '메모입니다', sysdate, 'red', 200);


select seq, name, memo, to_char(regdate, 'hh24:mi:ss') from tblMemo;

--테이블 삭제하기
drop table tblMemo;

-------------------------------------------------------------------------------------------------------------------------------------
--◆ Default ◆--

--테이블 다시 만들기(check 제약)
create table tblMemo
(
    seq number primary key,                 --메모번호(PK)
    name varchar2(30) default '익명',  --작성자 (default)
    memo varchar2(1000) not null,      --메모 내용
    regdate date null,                               --작성 날짜
    color varchar2(30) check(color in ('red', 'green', 'black')) not null,             --메모 색상('red', 'green'. 'black')
    prio number default 50
);

insert into tblMemo (seq, name, memo, regdate, color, prio) values (1, '홍길동', '메모입니다', sysdate, 'red', 100);
insert into tblMemo (seq, name, memo, regdate, color, prio) values (2, null, '메모입니다', sysdate, 'red', null); --명시적 null 삽입 : default가 동작하지 않음.
insert into tblMemo (seq, memo, regdate, color) values (3, '메모입니다', sysdate, 'red'); --암시적 null 삽입 : default가 동작함.

select * from tblMemo;

--테이블 삭제하기
drop table tblMemo;

-------------------------------------------------------------------------------------------------------------------------------------

create table tblMemo
(
    --제약사항 한번에
    seq number constraint tblmemo_seq_pk primary key, --메모번호
    name varchar2(30),        --작성자
    memo varchar2(1000) constraint tblmemo_memo_ck check(length(memo) between 10 and 333),   --메모 내용
    regdate date                    --작성 날짜
);

create table tblMemo
(
    seq number,
    name varchar2(30) not null,       
    memo varchar2(1000) not null, 
    regdate date      
    
    --제약사항 따로 추가
    constraint tblmemo_seq_pk primary key(seq),
    constraint tblmemo_memo_ch check(length(memo) > 5),
    constraint tblmemo_name_uq unique(name)
);


--데이터 추가하기
insert into tblMemo (seq, name, memo, regdate) values (1, '홍길동', '메모입니다메모입니다', sysdate);
insert into tblMemo (seq, name, memo, regdate) values (2, '홍길동', '메모입니다', sysdate); --ORA-02290: check constraint (HR.TBLMEMO_MEMO_CK) violated
insert into tblMemo (seq, name, memo, regdate) values (1, '홍길동', '메모입니다메모입니다', sysdate); --ORA-00001: unique constraint (HR.TBLMEMO_SEQ_PK) violated

--데이터 가져오기
select seq, name, memo, to_char(regdate, 'hh24:mi:ss') from tblMemo;

--테이블 삭제하기
drop table tblMemo;


/*

제약 사항을 만드는 방법
1. 컬럼 수준에서 만드는 방법
    - 위의 방법
    - 컬럼 1개를 선언할 때 제약사항도 같이 선언하는 방법
    - ex) seq number primary key
    - 컬럼명 자료형(길이) [constraint 제약명] 제약조건
    
2. 테이블 수준에서 만드는 방법
    - 컬럼 정의와 제약 사항 정의를 분리(가독성 때문에)

*/
