
--트랜잭션
create table tblTran (
    seq number primary key,
    name varchar2(30) not null,
    point number default 100 not null
);
create sequence seqTran;

drop table tblBoard cascade constraints;
create table tblBoard (
    seq number primary key,
    subject varchar2(1000) not null,
    tseq number not null references tbltran(seq)
);
create sequence seqBoard;
drop sequence seqBoard;

insert into tblTran values (seqTran.nextVal, '홍길동', default);
commit;

select * from tblTran;
select * from tblBoard;