
--코드 게시판 (스크랩 + 코드 조각 관리)
--싱글 유저
--코드 첨부(1개만)


--카테고리테이블
drop table tblcategory;
create table tblCategory(
    seq number primary key, 
    name varchar2(100) not null,
    type varchar2(100) not null
);

--게시판 테이블
drop table tblCode;
Create table tblCode(
    seq number primary key, 
    subject varchar2(500) not null,
    content varchar2(2000) not null,
    filename varchar2(300) not null,
    regdate date default sysdate not null,
    cseq number not null references tblCategory(seq)
);

create sequence seqCategory;
create sequence seqCode;

insert into tblCategory values (seqCategory.nextVal, 'JAVA', 'java');
insert into tblCategory values (seqCategory.nextVal, 'SQL', 'sql');
insert into tblCategory values (seqCategory.nextVal, 'HTML', 'html');
insert into tblCategory values (seqCategory.nextVal, 'CSS', 'css');
insert into tblCategory values (seqCategory.nextVal, 'JavaScript', 'javascript');


commit; 


select * from tblCategory order by seq asc;
select * from tblCode;































