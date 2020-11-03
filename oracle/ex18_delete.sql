/*

delete문
- DML
- (레코드) 데이터를 삭제하는 명령어
- delete [from] 테이블명 [where 절]

*/

rollback;

select * from tblcountry;

delete from tblcountry;  --> 테이블 비우기(초기화)
delete from tblcountry where continent = 'AS';