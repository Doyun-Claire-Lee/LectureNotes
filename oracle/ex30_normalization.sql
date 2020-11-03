/*

정규화, Normalization
- 자료의 손실이나 불필요한 정보를 없애고, 데이터의 일관성을 유지하며 데이터 종속을 최소화하기 위해서 자료 구조(ERD)를 수정하는 작업
- 기존의 데이터베이스 구조를(좀 더 나은 구조로) 개선하는 방법
- 기존에 만든 테이블(비정형, 비정규화 상태) -> 정규화 -> 정규화된 구조로 변경
- 제 1 정규화 -> 제 2 정규화 -> 제 3 정규화 등...
- 제 1 ~ 3정규화 + 역정규화


관계형 데이터베이스 시스템이 지향하는 데이터베이스의 상태
1. 최대한 null상태의 셀을 가지지 않는다. (쓸모없는 용량, 비대화 방지)
2. 중복값을 저장하지 않는다. -> 동일한 성격의 데이터를 2개 이상의 테이블에 저장하지 않는다.
3. 하나의 셀 안에는 단일값만 저장(원자값, Scalar - 분리될 수 없는 값)


정규화의 목적
1. null과 중복값 제거
2. 자료삽입, 자료갱신, 자료삭제에 따른 이상 현상을 제거(데이터 무결성 보장)
    
    a. 삽입 이상(Insertion Anomaly)
        - 특정 테이블에 데이터를 삽입할 때 원하지 않는 데이터까지 값을 넣어야 하는 상황이 발생할 때
    b. 갱신 이상(Update Anomaly)
        - 동일한 데이터가 2개 이상의 테이블에 존재할 때, 그 중 1개만 수정하고 나머지 하나는 수정을 못 한 상황
        - 두 데이터간의 이상 오류가 발생함 -> 2개 데이터 중 어떤 데이터가 올바른 데이터인지 구분하지 못하는 이상 발생
    c. 삭제 이상(Delte Anomaly)
        - 특정 테이블에서 데이터를 삭제할 때 원하지 않는 데이터까지 같이 삭제해야 하는 상황


함수 종속(Functional Dependency)
- 1개의 테이블 내의 컬럼끼리의 관계 표현
- 정규화는 '부분 함수 종속이나 이행 함수 종속을 모두 없애고, 모든 컬럼의 관계를 완전 함수 종속으로 만드는 작업'

1. 완전 함수 종속, Full Functional Dependency
2. 부분 함수 종속, Partial Functional Dependency
3. 이행 함수 종속, Transitive Functional Dependency


정규화
- 1NF ~ 3NF(Normal Form)
- 보편적으로 하나의 단계를 거칠 때 마다 하나의 테이블이 두개로 나뉘어짐. (반드시 쪼개지는 것은 아님
- 모든 정규화 단계는 기본 키가 아닌 컬럼들을 기본키에 대해 완전 함수 종속으로 만드는 작업

제 1정규화, 1NF
- 모든 컬럼(속성)은 원자값을 가진다.
- 여러개의 분리 가능한 값을 하나의 컬럼 안에 넣지 말 것

제 2정규화, 2NF
- 기본키가 아닌 모든 컬럼들은 기본키에 완전 함수 종속이어야 한다.
- 부분 함수 종속 발견 시 제거하는 작업
- 일부 컬럼이 복합키 모두에게 종속된 것이 아니라, 복합키 일부에만 종속되는 현상
- 복합키를 가지는 테이블에서만 발견됨.

제 3정규화, 3NF
- 기본키가 아닌 다른 컬럼에게 종속되는 컬럼이 존재하면 안된다.
- 이행 함수 종속 발견 시 제거하는 작업

역정규화(반정규화)
- 정규화된 결과를 다시 원래대로 되돌리는 작업
- 보편적으로 2개의 테이블이 하나로 합쳐지는 상황이 발생함.
- 수업 중 사용 X


정규화 체크사항
1. 원자값 확보
2. null 다량 발생
3. 중복값(2개 이상 테이블) 
4. 모든 키가 완전 함수 종속
5. N:N 관계를 1:N N:1 관계로 변경

*/


create table tblScore
(
    no varchar2(4),                         --학번
    subject varchar2(100),           --과목
    score varchar2(100),               --성적
    name varchar2(30)                  --학생명
);

insert into tblScore values ('1001', 'JAVA', 'A+', '홍길동');
insert into tblScore values ('1002', 'JAVA, 오라클, JDBC', 'A+, A+, B+', '아무개'); --> 하나의 셀에는 원자값만 넣어야 함. 
--1001	JAVA	A+	홍길동
--1002	JAVA, 오라클, JDBC	A+, A+, B+	아무개


select * from tblScore;

create table tblA
(
    seq number,
    name varchar2(30),
    hobby varchar2(50)
);

insert into tblA values (1, '홍길동', '독서');
insert into tblA values (2, '아무개', '운동');
insert into tblA values (3, '하하하', '낮잠, 맛집, 서핑');


create table tblB
(
    seq number,
    name varchar2(30),
    hobby1 varchar2(50),
    hobby2 varchar2(50),
    hobby3 varchar2(50)
);

insert into tblB values (1, '홍길동', '독서', '맛집', '운동');
insert into tblB values (2, '아무개', '운동', null, null); --> null 공간에 대한 비용도 책정이 됨. 
insert into tblB values (3, '하하하', '낮잠', null, null);

select * from tblB;


create table tblC
(
    seq number primary key,
    name varchar2(30)
);

create table tblHobby
(
    seq number primary key,
    hobby varchar2(50),
    pseq number not null references tblC(seq)
);

insert into tblC values (1, '홍길동');
insert into tblHobby values (1, '독서', 1);
insert into tblC values (2, '아무개');
insert into tblHobby values (2, '운동', 2);
insert into tblHobby values (3, '낮잠', 2);
insert into tblHobby values (4, '맛집', 2);

select * from tblC c
    inner join tblHobby h
        on c.seq = h.pseq;

select h.*, (select name from tblC where seq = h.pseq) from tblHobby h; --> inner join보다 비용이 저렴..







































