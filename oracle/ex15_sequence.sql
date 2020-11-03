/*

시퀀스, sequence
- 데이터베이스 객체 중 하나
- 식별자 생성 도구

시퀀스 객체 생성하기
- create sequence 시퀀스명;

시퀀스 객체 삭제하기
- drop sequence 시퀀스명;

시퀀스 객체 사용하기
1. 시퀀스명.nextVal
2. 시퀀스명.currVal

*/


select * from tbltodo;
select max(seq) from tbltodo; --마지막 일련번호 가져오기 -> 수동으로 하기엔 귀찮고 불편함.  -> 자동으로 관리해주는 도구 : 시퀀스

--시퀀스 생성
create sequence seqNum;

--1, 2, 3, 4, 5... 일련번호
select SEQNUM.nextval from dual; --이 번호는 물리적으로 계속 지속됨. (하드 디스크에 저장됨)

--A001, A002, A003... 쇼핑몰 상품번호 등
select 'A'|| trim(to_char(seqNum.nextVal, '000')) from dual;


drop table tblmemo;

create table tblMemo
(
    seq number primary key,
    name varchar2(30),
    memo varchar2(1000),
    regdate date default sysdate
);

create sequence seqMemo;

insert into tblmemo(sesq, name, memo) values (seqmemo.nextval, '홍길동', '메모입니다'); --> 10번 실행

select * from tblmemo;
select seqmemo.currval from dual; --> 10 -> peek()
select seqmemo.nextval from dual; --> 11(확인할 때마다 1씩 증가) -> pop()

--재접속 후 nextval을 호출하지 않으면 currval를 쓸 수 없음. 
--> 번호가 건너뛰어짐.. 없는 번호를 채우려고 집착하지 말기! 어쩔 수 없이 발생하는 것, seq는 중복값 방지를 위한 것이지 일련번호가 아님. 


--개발 후 서비스 오픈 과정에서 번호를 초기화 하고 싶을 때(= 시퀀스 객체 리셋)
-- A. 지우고 다시만들기
drop sequence seqmemo;
create sequence seqmemo start with 11; --> 이미 메모가 10번까지 있기 때문에 11부터 시작하는 객체를 생성해줌.

create sequence seqmemo
    increment by 1
    start with 1
--    maxvalue 10
--    minvalue  1
--    cycle
--    cache 20;

/*
시퀀스 객체 생성하기(정석)

create sequence 시퀀스명;

creaate sequence 시퀀스명;
    increment by N  --> N만큼 증감(양수, 음수)
    start with N        --> N부터 시작(seed값)
    maxvalue N        --> 최대값  
    minvalue N         --> 최소값(증감치가 음수일때)
    cycle                    --> Max값을 넘어가면 Min값부터 다시 시작(루프), 잘 안씀
    cache N;              --> 하드디스크에 접근할 번호의 단위, 기본적으로 건드리진 않음. 

*/

--B. 





















