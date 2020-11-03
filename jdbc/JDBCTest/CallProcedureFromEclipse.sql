
--CallableStatement에 사용할 프로시저
--m1()


create or replace procedure procM1(
    pname varchar2,
    page number,
    ptel varchar2,
    paddress varchar2
)
is
begin
    insert into tblAddress values (seqAddress.nextVal, pname, page, ptel, paddress, default);
end;

select * from tblAddress;



--m2()
--반환값(단일레코드 or 다중레코드)

create or replace procedure procM2(
    pnum number,
    pname out varchar2,
    pbuseo out varchar2,
    pjikwi out varchar2
)
is 
begin
    select name, buseo, jikwi into pname, pbuseo, pjikwi from tblInsa where num = pnum;
end;
    
    
    
--m3()
create or replace procedure procM3(
    pname varchar2,
    wname out varchar2,
    wage out number
)
is
begin

    select name, age into wname, wage from tblwomen where couple = (select name from tblmen where name = pname);

end;
    
select * from tblwomen;
select name, age from tblwomen where couple = (select name from tblmen where name = '유재석');



--m4()
create or replace procedure procM4(
    pbuseo varchar2,
    presult out SYS_REFCURSOR
)
is
begin

    open presult for
        select * from tblinsa where buseo = pbuseo;

end;




--m5()
create or replace procedure procM5(
    presult out SYS_REFCURSOR
)
is
begin

    open presult for 
        select * from tblAddress;
        
end;