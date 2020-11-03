/*

테이블의 관계

ERD, Entity Relational Diagram ★★★
- 엔티티 관계도
- 엔티티? -> 테이블!
- 테이블의 관계를 표시해놓은 도식(설계도)
*/

/*
조인, join

- 직원 테이블 + 담당 프로젝트 테이블 

*/

drop table tblStaff;

create table tblStaff
(
    seq number primary key,                     --직원번호(PK)
    name varchar2(30) not null,               --직원명
    salary number not null,                        --급여 
    address varchar2(300) not null,        --거주지
    project varchar2(300) null                  --담당 프로젝트명
);

insert into tblStaff(seq, name, salary, address, project) values (1, '홍길동', 300, '서울시', '홍콩 수출');
insert into tblStaff(seq, name, salary, address, project) values (2, '아무개', 250, '인천시', 'TV 광고');
insert into tblStaff(seq, name, salary, address, project) values (3, '하하하', 350, '대전시', '매출 분석');

-- 홍길동에게 프로젝트 2건 더 추가하기?
insert into tblStaff(seq, name, salary, address, project) values (4, '홍길동', 300, '서울시', '고객 관리');
insert into tblStaff(seq, name, salary, address, project) values (5, '홍길동', 300, '서울시', '자재 관리');
--> 중복된 데이터가 생기며 관리가 어려워짐. 테이블 설계가 잘못되었기 때문에..


--##[테이블 다시만들기]##--
create table tblStaff
(
    seq number primary key,                     --직원번호(PK)
    name varchar2(30) not null,               --직원명
    salary number not null,                        --급여 
    address varchar2(300) not null          --거주지
);

create table tblProject
(
    seq number primary key,                 --프로젝트 번호(PK)
    project varchar2(300) not null,      --프로젝트명
    staff number(30) null                       --직원명 -> 동명이인일 경우 찾지 못함. ==> PK인 직원 번호를 저장
);

insert into tblStaff(seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff(seq, name, salary, address) values (2, '아무개', 250, '인천시');
insert into tblStaff(seq, name, salary, address) values (3, '하하하', 350, '대전시');

insert into tblproject(seq, project, staff) values (1, '홍콩 수출', 1);
insert into tblproject(seq, project, staff) values (2, 'TV 광고', 2);
insert into tblproject(seq, project, staff) values (3, '매출 분석', 3);
insert into tblproject(seq, project, staff) values (4, ' 자재 관리', 1);
insert into tblproject(seq, project, staff) values (5, ' 대리점 분양', 2);


select * from tblstaff;
select * from tblproject;

select seq, project, (select name from tblstaff where seq = tblproject.staff) as staff from tblproject; --> 직원번호에 맞는 직원의 이름을 대신 불러옴. 

--상황A.--
--신입사원 입사, 신규 프로젝트 담당

--A1)신입사원 데이터 추가 -> 잘 됨!
insert into tblStaff(seq, name, salary, address) values (4, '호호호', 250, '서울시');

--A2)신규 프로젝트 할당 -> 잘 됨!
insert into tblproject(seq, project, staff) values (6, '고객 유치', 4);

--A3)새로운 신입사원 또 입사, 그러나 신입사원 데이터는 추가하지 않음..
-----> staff번호가 실존하는 번호인지 확인을 했어야 했는데 하지 않음, 그러나 작동은 됨.. -> 큰 문제가 됨!
-----> 상관관계 설정 후 에러: ORA-02291: integrity constraint (HR.SYS_C007139) violated - parent key not found
insert into tblproject(seq, project, staff) values (7, '해외 수출', 5);

commit;
rollback;

--상황B.--
--홍길동 퇴사

--B1) 홍길동 삭제 --> 담당자 없는 프로젝트가 생기게 됨. 
-----> 상관관계 설정 후 에러: ORA-02292: integrity constraint (HR.SYS_C007139) violated - child record found (딸린 자식 레코드가 있다.)
delete from tblstaff where name = '홍길동';

--B2) 홍길동의 모든 프로젝트를 위임하고 삭제를 했어야 함!
update tblproject set staff = 2 where staff = 1;    --업무 위임
delete from tblstaff where name = '홍길동';          --삭제

--==> 없는 직원번호를 프로젝트 테이블에 자꾸 넣어서 문제가 되었음. 프로그램이 이것을 관리해주도록 다시 테이블 생성하기!
--##[테이블 다시 생성]##--

drop table tblstaff;
drop table tblproject;

create table tblStaff --> 부모 테이블
(
    seq number primary key,                     --직원번호(PK)
    name varchar2(30) not null,               --직원명
    salary number not null,                        --급여 
    address varchar2(300) not null          --거주지
);

create table tblProject --> 자식 테이블(부모테이블의 PK를 FK와 엮어서 참조 관계를 만든다.)
(
    seq number primary key,                 --프로젝트 번호(PK)
    project varchar2(300) not null,      --프로젝트명
    staff number(30) not null references tblstaff(seq) --직원번호(FK), foreign key, 외래키
);

insert into tblStaff(seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff(seq, name, salary, address) values (2, '아무개', 250, '인천시');
insert into tblStaff(seq, name, salary, address) values (3, '하하하', 350, '대전시');
insert into tblproject(seq, project, staff) values (1, '홍콩 수출', 1);
insert into tblproject(seq, project, staff) values (2, 'TV 광고', 2);
insert into tblproject(seq, project, staff) values (3, '매출 분석', 3);
insert into tblproject(seq, project, staff) values (4, ' 자재 관리', 1);
insert into tblproject(seq, project, staff) values (5, ' 대리점 분양', 2);

--전의 상황A, B로 다시 가기!

/*

관계를 맺고있는 2개의 테이블을 조작할 때 발생하는 일
- 관계 규칙이 깨지면 데이터 무결성(유효성)이 깨진다. -> 데이터 가치 상실

1. 부모 테이블 조작시 주의사항
    a. 행 추가(insert) : 아무 영향 없음
    b. 행 수정(update) : 아무 영향 없음
    c. 행 삭제(delete) : 자식테이블에 자신을 참조하는 행이 존재하는지 반드시 사전 체크 -> FK
            --> 문제가 발생하면 '상태이상'이라고 함.

2. 자식 테이블 조작 시 주의사항
    a. 행 추가(insert) : 자신이 참조하는 대상이 실제로 존재하는지 반드시 사전 체크 -> FK
    b. 행 수정(update) : 자신이 참조하는 대상이 실제로 존재하는지 반드시 사전 체크 -> FK
    c. 행 삭제(delete) : 아무 영향 없음.
    
*/

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--EDR대로 테이블 만들기

create table tblcustomer
(
    seq number primary key,
    name varchar2(30) not null,
    tel varchar2(15) not null,
    address varchar2(100) not null
);

create table tblsales
(
    seq number primary key,
    item varchar2(50) not null,
    qty number not null,
    regdate date default sysdate not null,
    cseq number not null references tblcustomer(seq)
);


select * from tblcustomer;
select * from tblsales;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--EDR대로 테이블 만들기2

drop table tblGenre;
create table tblGenre
(
    seq number primary key,
    name varchar2(30) not null,
    price number not null,
    period number not null
);

drop sequence genreseq;
create sequence genreSeq;

drop table tblVideo;
create table tblVideo
(
    seq number primary key,
    name varchar2(100) not null,
    qty number not null,
    company varchar2(50) null,
    director varchar2(50) null,
    major varchar2(50) null,
    genre number not null references tblgenre(seq)
);

drop sequence videoseq;
create sequence videoSeq;

drop table tblMember;
create table tblMember
(
    seq number primary key,
    name varchar2(30) not null,
    grade number(1) not null,
    byear number(4) not null,
    tel varchar2(15) not null,
    address varchar2(300) null,
    money number not null
);

drop sequence memberseq;
create sequence memberSeq;

drop table tblRent;
create table tblRent
(
    seq number primary key,
    member number not null references tblMember(seq),
    video number not null references tblvideo(seq),
    rentdate date default sysdate not null,
    retdate date null,
    remark varchar2(500) null
);


drop sequence rentseq;
create sequence rentSeq;

select * from tblgenre;
select * from tblvideo;
select * from tblmember;
select * from tblrent;

-- 장르 데이터
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '액션',1500,2);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '에로',1000,1);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '어린이',1000,3);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '코미디',2000,2);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '멜로',2000,1);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '기타',1800,2);

-- 비디오 데이터
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '영구와 땡칠이',5,'영구필름','심영래','땡칠이',3);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '어쭈구리',5,'에로 프로덕션','김감독','박에로',2);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '털미네이터',3,'파라마운트','James','John',1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '육복성',3,'대만영화사','홍군보','생룡',4);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '뽀뽀할까요',6,'뽀뽀사','박감독','최지후',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '우정과 영혼',2,'파라마운트','James','Mike',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '주라기 유원지',1,NULL,NULL,NULL,1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '타이거 킹',4,'Walt','Kebin','Tiger',3);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '텔미 에브리 딩',10,'영구필름','강감독','심으나',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '동무',7,'부산필름','박감독','장동근',1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '공동경쟁구역',2,'뽀뽀사','박감독','이병흔',1);

-- 회원 데이터
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '김유신',1,1970,'123-4567','12-3번지 301호',10000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '강감찬',1,1978,'111-1111','777-2번지 101호',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '유관순',1,1978,'222-2222','86-9번지',20000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '이율곡',1,1982,'333-3333',NULL,15000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '신숙주',1,1988,'444-4444','조선 APT 1012호',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '안중근',1,1981,'555-5555','대한빌라 102호',1000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '윤봉길',1,1981,'666-6666','12-1번지',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '이순신',1,1981,'777-7777',NULL,1500);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '김부식',1,1981,'888-8888','73-6번지',-1000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '박지원',1,1981,'999-9999','조선 APT 902호',1200);

-- 대여 데이터
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 1,1,'2007-01-01',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 2,2,'2007-02-02','2001-02-03');
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 3,3,'2007-02-03',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 4,3,'2007-02-04','2001-02-08');
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 5,5,'2007-02-05',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 1,2,'2007-02-10',NULL);




/*

조인, join★★★★★★★★★
-(서로 관계를 맺은) 2개(1개)이상의 테이블의 내용을 가져와서 1개의 결과셋으로 만드는 작업

조인의 종류(ANSI 기반 용어)
1. 단순 조인, cross join
2. 내부 조인, inner join
3. 외부 조인, outer join
4. 셀프 조인, self join
5. 전체 외부 조인, full outer join

*/

--1. 단순조인, cross join
--마치 2중 for문처럼 데이터가 안에서 한번 더 돌듯이 출력됨. 
--그러나 유효하지 않은 데이터가 섞여 있음. 
--대량의 더미테이터를 만들 때 많이 쓰임. (유효성따위 필요 없는 테스트 데이터)
select * from tblCustomer;      --3명
select * from tblSales;              --9건

--3명 X 9건 = 27행
select * from tblcustomer cross join tblsales;      --ANSI SQL 표준
select * from tblcustomer, tblsales;                       --Oracle에서만 가능


--2. 내부 조인, inner join 
--가장 많이 씀. 
--단순 조인에서 유효한 레코드만 추출하는 조인
--서브쿼리와 비슷하나 차이점이 확실함.
--joint 할땐 *을 잘 안씀. 명시적으로 컬럼 작성하는 경우가 많다.
--딱히 순서는 없지만 보통 부모테이블을 먼저 적음.
--보편적으로 자식 테이블의 레코드 갯수만큼 결과가 나옴.

select * from tblcustomer inner join tblSales on tblcustomer.seq = cseq; -- 'on' : where 처럼 조건을 달아주는 구문
select * from tblcustomer c
    inner join tblSales s
        on c.seq = s.cseq
            order by c.seq;  --부모 테이블의 PK와 자식 테이블의 FK가 조건으로 옴.(거의 항상 대부분)

--select name from tblvideo v  --> ORA-00918: column ambiguously defined 에러, 항상 소속을 명확히 해줘야 함.
select v.name, g.price, g.period from tblvideo v
    inner join tblgenre g
        on v.genre = g.seq;
        
select s.name, s.salary, p.project from tblstaff s 
    inner join tblproject p
        on s.seq = p.staff
            order by s.name;

--테이블 여러개 조인하기
select m.name, v.name, r.rentdate, g.period from tblgenre g
    inner join tblvideo v
        on v.genre = g.seq
            inner join tblrent r
                on r.video = v.seq
                    inner join tblmember m
                        on r.member = m.seq;

        
--실행은 되는데 하면 안되는 행동--
--아무 관계 없는 테이블 두개를 join시키는 것, 설계 자체가 잘못된 것 
select * from tbltodo;
select * from tblsales;

select * from tbltodo t
    inner join tblsales s
        on t.seq = s.seq;
        
        
        
--3. 외부조인, outer join
--내부 조인 기반 + 부모 테이블의 나머지 레코드까지 다 가져옴
--자주 쓰임.


select * from tblcustomer;
select * from tblsales;

--새롭게 호호호가 가입함.
insert into tblcustomer values (4, '호호호', '010-1234-5678', '서울시');

--(구매 이력이 1건 이상인) 고객의 정보와 함께 구매 정보를 가져오시오. 
select * from tblcustomer c
    inner join tblsales s
        on c.seq = s.cseq
            order by c.seq asc; --> 호호호는 주문 내역이 없어서 누락됨.
            
--(구매 이력과 상관 없이) 고객의 정보와 함께 구매 정보를 가져오시오.             
select * from tblcustomer c 
    left outer join tblsales s -- outer 앞에 left 혹은 right 키워드를 적어야 함. (보통 부모 쪽을 가리킴.)
        on c.seq = s.cseq
            order by c.seq asc; --> 아까 보이지 않았던 호호호가 나옴.

--tblstaff + tblproject
--> inner join : 프로젝트를 1건이상 담당한 직원의 정보 + 프로젝트 정보
--> outer join : 프로젝트 담당 여부와 상관없는 모든 직원의 정보 + 프로젝트 정보

select * from tblmember;
select * from tblrent;
        
select * from tblmember m
    inner join tblrent r                   --> 대여를 한 내역이 있는 회원만 출력
        on m.seq = r.member;
     
select * from tblmember m
--    left outer join tblrent r           --> (letf : 부모쪽을 가리킴) 대여를 한번도 하지 않은 사람까지 출력
    right outer join tblrent r          --> (right : 자식쪽을 가리킴) inner join과 동일한 결과가 나타남. 
        on m.seq = r.member;
        
       
--4. 셀프 조인, self join
--잘 쓰지 않음. (쓸 경우가 잘 안생김)
--1개의 테이블을 사용해서 조인
--단순조인, 내부조인, 외부조인과는 성격이 다름. 
--단순조인 + 셀프조인, 내부조인 + 셀프조인, 외부조인 + 셀프조인 과 같은 형식으로 사용됨.

--셀프조인을 위해 테이블 생성
create table tblself
(
    seq number                             primary key, 
    name varchar2(30)               not null,
    department varchar2(50)    null,
    super number                         null references tblself(seq)
);

insert into tblself values (1, '홍사장', null, null);
insert into tblself values (2, '김부장', '영업부', 1);
insert into tblself values (3, '이과장', '영업부', 2);
insert into tblself values (4, '정대리', '영업부', 3);
insert into tblself values (5, '최사원', '영업부', 4);
insert into tblself values (6, '박부장', '개발부', 1 );
insert into tblself values (7, '하과장', '개발부', 6 );

select * from tblself;

select 
    s1.name as 직원명,
    s1.department as 부서명,
    s2.name as 상사이름
from tblself s1
--    inner join tblself s2             --> 홍사장은 나타나지 않음, (상사가 없기 때문에)
    left outer join tblself s2          --> 홍사장까지 나타남.
        on s1.super = s2.seq;


