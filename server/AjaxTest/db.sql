
--설문조사 테이블  (원래 이렇게 만들지 않음)
create table tblResearch (
    seq number primary key, 
    question varchar2(300) not null,
    item1 varchar2(300) not null,
    item2 varchar2(300) not null,
    item3 varchar2(300) not null,
    item4 varchar2(300) not null,
    cnt1 number default 0 not null,
    cnt2 number default 0 not null,
    cnt3 number default 0 not null,
    cnt4 number default 0 not null
);

insert into tblResearch values (1,  '사용 가능한 프로그래밍 언어는?', 'JAVA', 'Python', 'Visual C++', 'C#', default, default, default, default);

commit;
select * from tblresearch;
update tblresearch set 
    cnt1 =5,   
    cnt2 = 5,
    cnt3 = 8,
    cnt4 = 7
        where seq = 1;

create table zipcode  (
   seq                  NUMBER(10)                        not null,
   zipcode              VARCHAR2(50),
   sido                 VARCHAR2(50),
   gugun                VARCHAR2(50),
   dong                 VARCHAR2(50),
   bunji                VARCHAR2(50),
   constraint PK_ZIPCODE primary key (seq)
);

select * from zipcode order by seq;

--고양이의 위치를 저장할 테이블
create table tblCat(

    seq number primary key,
    catid varchar2(30) not null,
    x number not null,
    y number not null
);

insert into tblCat values (1, 'cat1', 0, 0);
insert into tblCat values (2, 'cat2', 220, 110);
insert into tblCat values (3, 'cat3', 150, 200);

commit;

--ex08
select * from 
(select a.*, rownum as rnum from 
(select * from vwboard order by seq desc) a)
where rnum >= 1 and rnum <= 10;

select * from (select a.*, rownum as rnum from (select seq, subject, name, regdate from vwboard order by seq desc) a) where rnum >= 1 and rnum <= 10;


--ex09, 추천검색어
create table tblSearch (
    seq number primary key, 
    word varchar2(100) not null
);

insert into tblSearch values (1, '가위');
insert into tblSearch values (2, '가나');
insert into tblSearch values (3, '가리비');
insert into tblSearch values (4, '가나 초콜릿');
insert into tblSearch values (5, '가위손');
insert into tblSearch values (6, '가방');
insert into tblSearch values (7, '가방 손잡이');
insert into tblSearch values (8, '가방끈');
insert into tblSearch values (9, '나비');
insert into tblSearch values (10, '나비잠');

commit;


--ex12 차트
select jikwi, count(*) as cnt from tblinsa where buseo = '기획부' group by jikwi;


--일정 테이블 생성하기
create table tblPlan (
    seq number primary key,
    mseq number not null references tblMember(seq),
    regdate varchar2(10) not null,
    --regdate date not null, 시분초를 저장해야 하지 않으면 날짜는 문자열로 만드는 경우도 많음.
    content varchar2(300) not null
);

create sequence seqPlan;

select * from tblmember;
select * from tblPlan;


--쪽지 테이블 생성
create table tblMessage(
    seq number primary key,
    smseq number not null references tblMember(seq),
    rmseq number not null references tblMember(seq),
    content varchar2(1000) not null,
    regdate date default sysdate,
    state number(1) default 0       --0(안읽음, 확인안함), 1(안읽음, 확인은 했음), 2(읽음, 확인함)
);
create sequence seqMessage;

select * from tblMessage;
select * from tblMember;














