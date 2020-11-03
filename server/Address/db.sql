drop table tblAddress;
drop sequence seqaddress;

create table tblAddress (
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    address varchar2(1000) not null,
    regdate date default sysdate not null

);

create sequence seqAddress;

insert into 
tblAddress(seq, name, age, address, regdate)
values (SEQADDRESS.nextval, '홍길동', 20, '서울시 강남구 역삼동', default);

select * from tblAddress;

commit;