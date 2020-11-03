/*

계정
- DCL
- 계정 생성, 수정, 삭제
- 리소스 접근 권한 제어

- 사용자가 어느 정도까지 접근할 수 있는지 컨트롤하는 방법..? (개발자는 잘 안쓰긴 함..)

사용자 계정 생성하기
- 시스템 권한을 가지고 있는 계정만 가능하다.
    - 관리자만 가능(system/ 관리자 권한을 부여받은 일반 계정)
    - 계정 생성 권한을 가진 일반 계정


create user 계정명 identified by 암호;
alter user 계정명 identified by 암호; -- 비밀번호 수정시 
alter user 계정명 account unlock;
alter user 계정명 account lock;
drop user 계정명;

*/

create user test identified by java1234; --> system 계정으로 로그인해야함. 

--계정 생성 직후는 접속 권한이 없음. 접속 권한을 설정해 주어야 함. 

/*

계정에게 권한 제어
1. grant 권한 to 계정명
2. revoke 권한 to 계정명

책 403p, 407p
*/

grant create session to test; --> 로그인 권한: creat session

grant connect, resource to test; --> 권한의 집합인 roll을 날려 여러 권한을 한꺼번에 부여할 수 있다.


-- 프로젝트 진행
-- 1. 프로젝트 전용 계정 생성
create user project identified by java1234;

-- 2. 권한 부여
grant connect, resource to project;

-- 3. 권한 뺏기
revoke connect from project;




















































