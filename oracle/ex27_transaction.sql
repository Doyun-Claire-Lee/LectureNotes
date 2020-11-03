/*

트랜잭션, Transaction
- 오라클에서 발생하는 1개 이상의 명령어들을 하나의 논리 집합으로 묶어놓은 단위(폴더같은 느낌?) -> 제어하기!
- 트랜잭션에 포함되는 명령어(DML만 포함) -> insert, update, delete만! (테이블 조작하는 명령어들만)

트랜잭션 명령어
- DCL(TCL)
- 하나의 트랜잭션으로 묶여 있는 DML을 감시하다가, 일부 DML이 문제를 발생시키면 이전에 성공한 DML을 일괄 취소 처리하고, 문제 발생이 없으면 일괄 승인 처리한다.
1. commit
2. rollback
3. savepoint

- 오라클에 로그인을 하는 순간 하나의 트랜잭션이 시작됨.
- rollback을 하는 순간 그동안에 진행되었던 insert delete update를 없는 것으로 처리하고 해당 시점까지 진행되던 트랜잭션을 소비하고 새로운 트랜잭션이 시작됨.

새로운 트랜잭션이 시작되는 경우
1. 클라이언트 접속 직후(로그인 직후)
2. commit 실행 직후
3. rollback 실행 직후

현재 트랜잭션이 종료되는 경우
1. commit 실행 직후 -> 현재 트랜잭션의 결과를 DB에 반영함.
2. rollback 실행 직후 -> 현재 트랜잭션의 결과를 DB에 반영하지 않음.
3. 클라이언트 접속 종료(로그오프)
    a. 정상적인 접속 종료 -> commit or rollback 선택창
    b. 비정상적인 접속 종료 -> 자동적으로 rollback됨
4. DDL 실행 직후
    - create, alter, drop (구조에 대한 변화가 생기기 때문에..)
    - 자동적으로 commit 이 됨(Auto commit)


*/


drop table tblTrans;
create table tblTrans
as
select name, city, buseo, jikwi from tblinsa where buseo = '영업부'; --> 진짜 복사본을 만든 것, (뷰 아님)

--이제부터는 시간 순서가 있는 작업임. 

select * from tbltrans; --16명

delete from tbltrans where name = '김종서'; --김종서 삭제

select * from tbltrans; --15명

--김종서가 아닌 다른 사람을 지웠어야 하는데 실수로 김종서를 지운 상황 --> inset update delete는 DB에 바로 반영되지 않고 임시로 저장되어있음.

rollback; --되돌리기
--트랜잭션 새로 시작 

select * from tbltrans; --16명

delete from tbltrans where name = '김정훈';
update tbltrans set city = '서울' where name = '김종서';

select * from tbltrans; --15명, 김종서 부산 -> 서울로 변경

--위의 두 작업이 하면 안되는 작업이었던 것으로 판명된 상황..

rollback; --되돌리기
--트랜잭션 새로 시작

select * from tbltrans; --다시 복구가 되었음. 

delete from tbltrans where name = '유관순';
update tbltrans set city = '서울' where name = '김종서';

select * from tbltrans; --적용 잘 되었음.

--모두 정상적인 업무로 판명남. 저장해야 하는 상황

commit; --> 되돌릴 수 없으니 주의해서 실행하기!!!!!!
--트랜잭션 새로 시작

select * from tbltrans; 

rollback; --> commit 전 상황으로는 절대 돌아갈 수 없음.. 
--트랜잭션 새로 시작

update tbltrans set city = '경기' where name = '손인수'; --> 고순정의 업무 인수인계 (고순정 퇴사전처리)
delete from tbltrans where name = '고순정'; --영업부 대리, 경기도, 퇴사예정
--고순정이 퇴사 안한다고 함!! 손인수를 다시 부산으로 변경해야 함..
update tbltrans set city = '부산' where name = '손인수';  --> 만약 퇴사 전처리가 여러개였다면.. 수기로 작업하는 것 보다 rollback을 사용하는 것이 훨씬 효율적임.

rollback; 
--트랜잭션 새로 시작

select * from tbltrans;

commit;
--트랜잭션 새로 시작

delete from tbltrans where city <> '서울';

select * from tbltrans;

create table tbltrans2
(
    seq number primary key
);  --> DDL 실행, 자동적으로 commit 되었음..

select * from tbltrans;
rollback;

select * from tbltrans; --> 여전히 서울사람만 남아있음.

delete from tbltrans where name = '김종서';

savepoint a;

delete from tbltrans where name = '김인수';

savepoint b;

delete from tbltrans where name = '산마루';

rollback  --> 트랜잭션 시작점으로 돌아가면 중간에 있던 savepoint들은 소멸됨.
rollback to a;  --> savepoint로의 이동은 트랜잭션이 그대로 살아있음.
rollback to b;

select * from tbltrans;

