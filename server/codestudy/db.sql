-- 회원테이블

drop table tblMember cascade constraints;
create table tblMember(
    seq number primary key,            
    id varchar2(30) not null,
    name varchar2(30) not null,
    email  varchar2(100) not null,
    pw varchar2(30) not null,
    pic varchar2(50) not null,
    regdate date default sysdate
);

drop sequence seqMember;
create sequence seqMember; 

select * from tblMember;
delete from tblMember;
commit;

--자유게시판 테이블
drop table tblComment;
drop table tblboard;

create table tblBoard (
    seq number primary key,                         --글번호(PK)
    subject varchar2(1000) not null,
    content varchar2(2000) not null,
    regdate date default sysdate not null,
    readcount number default 0 not null,
   -- heart  number default 0 not null,
    mseq number not null references tblMember(seq),
    thread number not null,     --답변 구현용 컬럼
    depth number not null       --답변 구현용 컬럼
);
create sequence seqBoard;

--답변글 기능 구현을 위해 테이블 컬럼 추가
alter table tblBoard 
add (thread number not null);

alter table tblBoard 
add (depth number not null);

commit;

select * from tblboard order by thread desc, depth asc;



insert into tblBoard(seq, subject, content, regdate, readcount, heart, mseq) values (seqBoard.nextVal, '게시판 테스트입니다', '글내용입니다', default, default, default, 5);
commit;

select * from tblBoard;
delete from tblBoard;
delete from tblComment;
delete from tblheart;



select seq, subject,(select name from tblMember where seq = tblBoard.mseq) as name , regdate, readcount from tblBoard;

--게시판 글 목록 출력을 위한 view
create or replace view vwBoard
as
select 
    seq, 
    subject, 
    (select name from tblMember where seq = tblBoard.mseq) as name, 
    regdate, 
    readcount, (sysdate - regdate)*24  as gab, 
    content, (select count(*) from tblcomment where bseq = tblboard.seq) as commentcount, 
    (select count(*) from tblheart where bseq = tblboard.seq) as heart,
    thread,
    depth
from tblBoard;

select * from vwboard;

select a.* , (select name from tblMember where seq = a.mseq) as name, (select id from tblMember where seq = a.mseq) as id from tblBoard a where seq = 1;

create table tblHistory (
    seq number primary key,
    content varchar2(2000) not null
);

insert into tblhistory values (1, 'v0.1\n- 시작');

delete from tblhistory;

commit;

select *  from tblhistory;

delete from tblboard;
commit;


drop table tblcomment;

--댓글 테이블
create table tblComment(
    seq number primary key,
    commentContent varchar2(1000) not null,
    regdate date default sysdate,
    mseq number not null references tblMember(seq),
    bseq number not null references tblBoard(seq)
);
create sequence seqComment;
delete from tblComment;
select a.*, (select name from tblMember where seq = a.mseq) as name, (select id from tblMember where seq = a.mseq) as id from tblcomment a;




select * from tblcomment;


/*
두 테이블을 합치는 방법
1. join : 테이블간 관계가 있을 경우
2. union
3. 상관서브쿼리
*/


select count(*) as bcnt from tblBoard where mseq = 8
union all
select count(*) as ccnt from tblComment where mseq = 8;


select (select count(*)  from tblBoard where mseq = 8) as bcnt,  (select count(*) from tblComment where mseq = 8) as ccnt from dual;



drop table tblcomment;
drop table tblboard;


--추천 테이블
create table tblheart (
    seq number primary key,
    mseq number not null references tblMember(seq),
    bseq number not null references tblboard(seq)
);

create sequence seqheart;

select * from tblheart;

select a.* , (select name from tblMember where seq = a.mseq) as name, (select id from tblMember where seq = a.mseq) as id, (select count(*) from tblHeart where bseq = a.seq and mseq = 5) as heart from tblBoard a;






delete from tblheart;
delete from tblcomment;
delete from tblboard;
commit;

select * from tblMember;


----------------------------------------------------------------------------------------------------------------
/* 페이징!! */
----------------------------------------------------------------------------------------------------------------
select * from (select a.*, rownum as rnum from (select * from vwboard order by thread desc) a) where rnum >= 1 and rnum <= 20;


