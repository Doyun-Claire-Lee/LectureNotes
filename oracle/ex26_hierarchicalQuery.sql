/*

계층형 쿼리, Hierachical Query

- 오라클 전용
- 레코드간의 관계가 서로 상하 수직 구조일 경우 적당한 구조의 결과셋을 만들어 준다.
- 부모와 자식 역할을 하는 레코드로 구성된 테이블에서 사용한다.
- 카테고리, 답변형 게시판, 조직 구성원 테이블, BOM 등
- 자기참조 구성을 갖는 테이블에서 많이 쓰임.

- start with절 connect by절
- 계층형 쿼리에서만 사용 가능한 의사 컬럼(level, prior)이 있음.

ex) 컴퓨터
        - 모니터
            - 보호필름
        - 본체
            - 메인보드
            - 그래픽카드
            - 랜카드
            - CPU
            - 메모리
        - 프린터
            - 카트리지
            - 용지

*/
drop table tblcomputer;
create table tblcomputer
(
    seq number primary key,                                                    --식별자(PK)
    name varchar2(50) not null,                                              --요소명 
    qty number not null,                                                            --수량 
    pseq number null references tblcomputer(seq)            --부모 요소(FK)
);

insert into tblcomputer values (1, '컴퓨터', 1, null);

insert into tblcomputer values (2, '본체', 1, 1);
insert into tblcomputer values (3, '모니터', 1, 1);
insert into tblcomputer values (4, '프린터', 1, 1);

insert into tblcomputer values (5, '메인보드', 1, 2);
insert into tblcomputer values (6, '그래픽카드', 1, 2);
insert into tblcomputer values (7, '랜카드', 1 ,2);
insert into tblcomputer values (8, 'CPU', 1, 2);
insert into tblcomputer values (9, '메모리', 2, 2);

insert into tblcomputer values (10, '보호필름', 1, 3);

insert into tblcomputer values (11, '카트리지', 1, 4);
insert into tblcomputer values (12, '용지', 1, 4);

select * from tblcomputer;

select c1.name, c2.name from tblcomputer c1   --자식부품
    left outer join tblcomputer c2     --부모부품
        on c1.pseq = c2.seq;
--==> 관계는 표현되지만 직관적으로 알기는 어려움.. 

select * from tblcomputer
    start with seq = 1
        connect by prior seq = pseq;
--==> 순서가 계층 구조대로 변경되었음. 

select  
    name, level
from tblcomputer
    start with seq = 1
        connect by prior seq = pseq;


select  
    lpad(' ', (level-1)*5) || name, prior name --> prior name = 부모 레코드의 이름을 가져옴
from tblcomputer
--    start with seq = 1                              --> 누구로 부터 시작을 할 것인가? (컴퓨터부터 = 1, 본체부터 = 2 ...), 그러나 항상 루트가 1부터 시작하리라는 보장이 없음 
--    start with seq = (select seq from tblcomputer where name = '컴퓨터') --> 컴퓨터부터 시작하라는 뜻
    start with pseq is null                         --> 부모 번호가 없는 것(루트)를 찾아라.    
        connect by prior seq = pseq;        --> prior : 부모 테이블의 레코드를 뜻함..?on c1.pseq = c2.seq와 같은 표현


--조직도
select 
    lpad(' ', (level-1)*5) || name as 직원명, 
    prior name as 상사명
from tblself
    start with super is null
        connect by super = prior seq;
        

select 
    lpad(' ', (level-1)*5) || name as 부품명,
    prior name as 부모부품명,
    level as 레벨,
    connect_by_root name as 루트부품명,
    connect_by_isleaf as 리프노드,                   --> 더이상 파생되지 않고 끝나는 노드, 자식이 없는 노드(0: 자식있음, 1: 자식없음)
    sys_connect_by_path(name, '→') as  연결경로
from tblcomputer
    start with pseq is null
        connect by prior seq = pseq
--            order by name asc; --> 순서가 흐트러짐. 쓰지말기
            order siblings by name asc; --> 같은 그룹안에서만 정렬 













