--JDBC용 스트립트 파일
--d:\class\JDBCTest


create table tblAddress(
    seq number primary key,
    name varchar2(30) not null,
    age number(3) not null,
    tel varchar2(15) null,
    address varchar2(300) not null,
    regdate date default sysdate not null
);

create sequence seqAddress;

insert into tblAddress (seq, name, age, tel, address, regdate)  values (seqAddress.nextVal, '홍길동', 20, '010-1234-5678', '서울시 강남구 역삼동', default);

commit;

select * from tbladdress;

select * from tblAAA;


-----------------------------------------------------------------------------------------------------------------------------

select name, gender, age, address from tblAddressBook where address like '%역삼%';


select name, gender, age, address from tblAddressBook where lower(address) like '%' || lower('역삼') || '%'; --대소문자 구분없이 검색하고 싶을 경우


select name, gender, age, address from tblAddressBook where replace(lower(address), ' ','') like '%' || replace(lower('역삼'), ' ','') || '%'; --대소문자 구문없이, 공백 상관없이 검색하고 싶을 경우

-----------------------------------------------------------------------------------------------------------------------------

select * from tblinsa where buseo = '기획부' order by 
    case
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end,
    name;
    
-------------------------------------------------------------------------------------------------------------------------------

select * from tblAddress;
