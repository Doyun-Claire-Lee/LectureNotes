/*

update문
- DML
- 원하는 행의 원하는 컬럼값을 수정하는 명령어
- update 테이블명 set 컬럼명 = 수정할값 [, 컬럼명 = 수정할값] x N [where 절]

*/

--transaction
commit;
rollback;

select * from tblcountry;
update tblcountry set capital = '세종';  --> 전체 레코드가 다 변경됨.. 조심하기!!!!!!!!!
update tblcountry set capital = '세종' where name = '대한민국';  --> 업데이트할 레코드만 변경 (PK 조건)

--해수면이 낮아져 모든 국가의 면적이 10% 증가했다
update tblcountry set area = area * 1.1;



select * from tblinsa;

update tblinsa 
    set city = '제주', 
            tel = '010-1234-5678', 
            buseo = '홍보부', 
            jikwi = '과장', 
            basicpay = basicpay * 1.2 
    where num = 1001;
    
update tblinsa set buseo = null where num = 1001; --> 셀 하나를 지우는 행동(null값 대입)


--★★★ 하면 안되는 행동! ★★★
select * from tblinsa;

update tblinsa set num = 2000 where num = 1001; --> Primary key는 변경하면 안됨!!! 개념없는 사람 될 수 있음..
