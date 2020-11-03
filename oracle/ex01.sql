-- 스크립트 파일(*.sql)

--단일라인 주석
/*
다중라인 주석
*/


/*
오라클 계정(빌트인)
1. system(sys) 
    - 최고 관리자 계정
2. hr
    - 학습용 계정 -> 수업할 계정 
3. scott
     - 학습용 계정 -> 책이 scott기반으로 되어있음.


잠긴 계정 활성화하기
    - 권한이 있는 유저(관리자)가 한다.
    
alter user 유저명 account unlock;   -> 계정 잠금 해제
alter user 유저명 account lock;        -> 계정 잠금

암호 변경하기
    - 권한이 있는 유저(관리자)가 한다.

alter user 유저명 identified by 암호


*/

alter user hr account unlock;
alter user hr identified by java1234;

select * from tabs;

alter user scott account unlock ;
alter user scott identified by java1234;

alter user scott account unlock identified by java1234;


/*

데이터베이스, Database
오라클, Oracle
    - 회사명, 제품명
    - 데이터베이스(Database) -> 데이터베이스 관리시스템(Database Management System > DBMS) -> 관계형 데이터베이스 관리시스템(Relation Database Management System > RDBMS)
    
데이터베이스
    - 데이터의 집합
    
관계형 데이터베이스 관리시스템의 종류(RDBMS)
    1. Oracle - Oracle사, 기업용
    2. MS-SQL - Microsoft, 기업용
    3. MySQL - Oracle사(인수), 개인용+기업용
    4. MariaDB - MySQL 기반, 무료, 개인용+기업용
    5. PostgreSQL - 무료, 개인용+기업용
    6. DB2 - IBM, 메인프레임(대형 프로젝트)
    7. Access - MS, 개인용+소규모 기업
    8. 티베로(DBMS) - 티맥스(TMax), 제우스(웹서버..)
    9. SQLite - 경량, 모바일 작업 시 사용 잦음
    
데이터베이스 클라이언트 툴
    1. SQL Developer - Oracle, 무료 (실무에서는 잘 안씀..)
    2. Toad
    3. SQLGate
    4. DataGrip - JetBrain
    5. SQL*Plus - 오라클 설치 시 기본으로 설치되는 Client 툴, CLI기반(Command Line Interface, 콘솔창), 엄청 불편
    
오라클 에디션&버전 - 책 38p

데이터 모델 - 책 21p, 관계지향형 빼고 모두 도태되었음.

다른 컴퓨터의 오라클에 접속하기
1. 접속받을 컴퓨터의 오라클 서버의 방화벽 열기(1521)
    - 방화벽 - 고급설정 - 인바운드 규칙 - 새 규칙 - ..
    - 접속 생성
  
  
SQL, Structured "Query" Language
    - SQL == Query
    - 질의를 목적으로 만들어진 언어
    - 자바에 비해 자연어에 가깝다.

    1. DMBS와 SQL은 서로 독립적임.
    - 표준 SQL(ANSI-SQL)
    - 표준 SQL은 모든 DBMS에서 공통으로 사용한다. 
    - SQL-86 > SQL-89 > .... SQL-99 > SQL2011
    2. 대화식 언어이다
    - 질문 > 답변 > 질문 > 답변 x 반복

오라클 = ANSI-92/99기반  + PL/SQL

[ANSI SQL의 종류]

    1. DDL
        - Data Definition Language
        - 데이터 정의어
        - 구조를 만드는 명령어
        - 테이블, 뷰, 사용자, 인덱스 등의 객체를 생성/수정/삭제하는 명령어
        - create: 생성
        - drop: 삭제
        - alter: 수정
        - 데이터베이스 관리자, 담당자/ 프로그래머(일부)가 주로 사용
        
    2. DML
        - Data Manipulation Language
        - 데이터 조작어
        - 데이터베이스의 데이터를 추가/수정/삭제/조회 명령어
        - CRUD(Create, Read, Update, Delete)
        - select: 읽기(************)
        - insert: 추가
        - update: 수정
        - delete: 삭제    
        - 데이터베이스 관리자, 담당자, 프로그래머(********)가 사용
        
    3. DCL
         - Data Control Language
         - 데이터 제어어
        - 계정 관리, 보안 관리, 트랜잭션 처리 등 제어 역할
        - commit
        - rollback
        - grant
        - revoke
        - 데이터베이스 관리자, 담당자
        - 개발자(일부) : 빈도 낮음
        
    4. DQL 
        - Data Query Language
        - DML중에서 select 만을 이렇게 부른다.
        
    5. TCL
        - Transaction Control Language
        - DCL중에서 commit, rollback 만을 이렇게 부른다.
        
오라클 서버 기본 인코딩
    - ~ 8i : EUC-KR
    - 9i ~ 현재 : UTF-8

*/

--SQL은 대소문자를 구분하지 않는 언어이다.
SELECT * FROM tabs; --권장사항

        
-- 무언가를 생성할 때 식별자를 만들어 주어야 함.
-- 규칙: 최대 30바이트 이하(이상 넘어갈 시 에러남.)

create table tblTest( --테스트 테이블 생성
        num number
);

drop table tblTest; --테이블 삭제
    
create table tblTestaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa( --"identifier is too long"에러 발생 
        num number
);


