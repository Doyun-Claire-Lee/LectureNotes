/*

PL/SQL
- Procedural Langauge Extensions to SQL
- ANSI-SQL에 절차적 기능을 추가한 것
- 변수, 제어문, 조건문 등.. 


ANSI-SQL
- 비 절차성 언어(순서가 없고 연속적이지 않음) -> 문장 단위 구조


SQL 처리 순서
1. ANSI SQL
    - 클라이언트 구문 작성(Select) -> 실행(Ctrl + Enter) -> 명령어가 오라클에게 전달 -> 수신 -> 구문 분석(파싱) -> 컴파일 -> 실행 -> 결과 처리
    - 위의 구문(Select)을 다시 실행하면? -> 위의 과정을 처음부터 끝까지 동일하게 반복

2. PL/SQL
    - 클라이언트 구문 작성(Select) -> 실행(Ctrl + Enter) -> 명령어가 오라클에게 전달 -> 수신 -> 구문 분석(파싱) -> 컴파일 -> 실행 -> 결과 처리
    - 반복 실행시 : 구문 분석(파싱) -> 컴파일 과정 생략됨, (저장, Stored) 프로시저


프로시저, Procedure
- 메소드, 함수, 서브루틴 등과 같은 말
- 순서가 있는 코드의 집합
1. 익명 프로시저 : 1회용 코드, PL/SQL은 프로시저가 아니면 실행을 못하므로 익명 프로시저도 자주 사용됨.
2. 실명 프로시저 : 반복 코드


PL/SQL 프로시저 블럭 구조
1. 4개의 키워드로 구성
    - declare
    - begin
    - end 
    - exception

2. declare
    - 선언부
    - 프로시저에서 사용할 변수, 객체등을 선언하는 영역
    - 생략 가능

3. begin
    - 실행부(begin ~ end)
    - 구현되는 코드를 가지는 영역(메소드 body역할)
    - 생략 불가
    - 연산, 제어 + ANSI-SQL 등으로 구성
    
4. exception
    - 예외 처리부
    - catch 역할
    - 예외 처리 코드를 작성
    - 생략 가능
    
5. end
    - begin 블럭의 종료 역할
    - 생략 불가능
    
6. PL/SQL의 블럭은 중첩도 됨.

begin 
    ...
    begin
        ...
    end;
end;
    

변수의 자료형
- 오라클의 자료형과 동일(확장)

변수 선언하기
- 변수명 자료형(컬럼 선언하듯이)[not null] [default 값]
- 변수는 질의의 결과나 인자를 저장하는 용도로 씀.

대입 연산자
- 오라클과 동일
- 변수명 := 값

*/

set serveroutput on;  --> 오라클 로그인할때마다 해줘야 함. output 문을 출력하기 위함.

declare
    num number;
    name varchar2(30);
    today date;
begin
    num := 10;
    name := '홍길동';
    today := sysdate;
    dbms_output.put_line(num);
    dbms_output.put_line(name);
    dbms_output.put_line(today);
    dbms_output.put_line(to_char(today, 'yyyy-mm-dd'));
end;


declare
    num  number default 100;
    num2 number not null default 200;
begin
        dbms_output.put_line(num);
        dbms_output.put_line(num2); --> 반드시 초기화 시켜주어야 함.
end;


/*

변수 : 테이블의 select 결과를 담는 용도로 많이 쓰임.
- 질의의 결과가 단일값이어야 한다. 
    a. 결과셋이 1개의 레코드와 1개의 컬럼으로 구성(원자값) -> PK를 조건으로 하는 경우가 대다수
    b. 집계 함수의 결과값

select into
1. 1행 1열
2. 1행 N열 

프로시저 내에서는 select문을 그냥 사용하지 못하고, 반드시 select 의 결과를 PL/SQL 변수에 옮겨 담아야 한다.

*/

declare
    vbuseo varchar2(15);    
    vname varchar2(15);
begin
    vname := '홍길동';
    select buseo into vbuseo from tblinsa where name = vname;
    dbms_output.put_line(vbuseo);
end;

--1행 1열
declare
    vcount number;
begin
    select count(*) into vcount from tblinsa where buseo = '기획부';
    dbms_output.put_line('기획부 직원수: ' || vcount || '명');
end;

--1행 n열
declare
    vname varchar2(20);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
begin 
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblinsa where num = '1001';
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
end;


/*

참조형
- 원본의 자료형을 몰라도 된다.
- 유지 보수성이 좋다.


1. %type
    - 사용하는 테이블의 특정 컬럼의 자료형을 그대로 참조해서 적용
    - 복사되는 정보
        a. 자료형
        b. 길이
        c. not null 제약
        
2. %rowtype
    - 행을 참조(여라개의 컬럼을 한번에 참조)
    - %type의 집합형
*/

declare
    vname tblinsa.name%type;
begin
    select name into vname from tblinsa where num = '1001';
    dbms_output.put_line(vname);
end;

declare
    vname tblinsa.name%type;
    vbuseo tblinsa.buseo%type;
    vjikwi tblinsa.jikwi%type;
begin 
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblinsa where num = '1001';
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
end;



--직원 중 일부에게 보너스 지급, 그 내역을 저장
select * from tblinsa;

create table tblBonus 
(
    seq number primary key,
    name varchar2(15) not null,
    bonus number not null
);

--보너스 지급대상
select * from tblinsa where city = '서울' and jikwi = '부장' and months_between(sysdate, ibsadate) / 12 >= 14;

declare 
    vname tblinsa.name%type;
    vbonus tblinsa.sudang%type;
begin
    select name, sudang*3 into vname, vbonus from tblinsa where city = '서울' and jikwi = '부장' and months_between(sysdate, ibsadate) / 12 >= 14;
    dbms_output.put_line(vname);
    dbms_output.put_line(vbonus);
    insert into tblbonus values (1, vname, vbonus);
end;

select * from tblbonus;

--한줄 통째로 복사하기
declare
    vrow tblinsa%rowtype;
begin
    select * into vrow from tblinsa where num = '1001';
--    dbms_output.put_line(vrow); --> 객체는 출력을 못하기 때문에 에러남.
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.jikwi);
    dbms_output.put_line(vrow.basicpay);
end;



/*

ANSI-SQL + PL/SQL
- 오라클은 키워드(구문)에서 대소문자를 구분하지 않는다.
- 데이터의 대소문자는 구분한다.
- 오라클은 컴파일 시 모든 키워드를 대문자로 변환하여 저장 
- 데이터베이스 객체를 저장시에도 객체명이 대문자로 변환되어 저장됨(********)
    a. 사용자쿼리는 구문만 대문자, 데이터는 유지
    b. 시스템쿼리, DB 객체 생성 -> 모든 구문 대문자 변환

*/

select * from tblinsa;
SELECT * FROM TBLINSA;


--시스템 테이블(오라클이 관리하는 정보를 저장하는 테이블)을 조작할 경우
select * from tabs where table_name = 'tblinsa'; --> 현재 계정이 이 테이블을 가지고 있는지 확인하는 구문
select * from tabs where table_name = 'TBLINSA'; --> 이렇게 검색해야 함! (대문자로)







--제어문
--조건문

set serveroutput on;
declare
    vnum number := 10;
begin
    if vnum > 0 then 
        dbms_output.put_line('양수');
    end if;
end;


declare
    vnum number := -1;
begin
    if vnum > 0 then 
        dbms_output.put_line('양수');
    else 
        dbms_output.put_line('음수');
    end if;
end;



declare
    vnum number := 0;
begin
    if vnum > 0 then 
        dbms_output.put_line('양수');
    elsif vnum < 0 then                             --  else if에 e를 안씀!!
        dbms_output.put_line('음수');
    else
        dbms_output.put_line('영');    
    end if;
end;


declare
    vgender char(1); --성별
begin
    select substr(ssn, 8, 1) into vgender 
        from tblinsa where num = '1003';
    if vgender = '1' then 
        --남자 직원 업무 추가
        dbms_output.put_line('남자 업무 추가');
    else 
        --여자 업무 추가
        dbms_output.put_line('여자 업무 추가');
    end if;
end;


commit;
rollback;


declare
    --참조변수, %type , %rowtype
    vrow tblinsa%rowtype;
    vnum tblinsa.num%type;
begin
    vnum := 1001;
    select * into vrow from tblinsa where num = vnum;
    
    if vrow.basicpay > 2000000 and substr(vrow.ssn, 1, 2) = '88' then 
        dbms_output.put_line('처리O');
        update tblinsa set sudang = 1000000 where num = vnum;
    else
        dbms_output.put_line('처리X');
        delete from tblinsa where num = vnum;
    end if;
end;

select * from tblinsa;



--case문
--자바의 switch case문 유사
--ANSI-SQL의 case와는 다른 구문


declare 
    vname tblcountry.name%type;
    vcontinent tblcountry.continent%type;
    vpopulation tblcountry.population%type;
    vresult varchar2(30);
begin 
    select name, continent, population into vname, vcontinent, vpopulation 
        from tblcountry where name = '대한민국';
        
        --case end, case when 
        case vcontinent 
            when 'AS' then vresult := '아시아';
            when 'EU' then vresult := '유럽';
            else vresult := '기타';
        end case;        
        dbms_output.put_line(vresult);

        --범위 비교
     case 
        when vpopulation > 10000 then vresult := '너무 많음';
        when vpopulation > 5000 then vresult := '조금 많음';
        when vpopulation > 1000 then vresult := '모자람';
    end case;
    dbms_output.put_line(vresult);
end;


/*

반복문

1. loop
    - 조건 반복
2. for loop
    - 지정 횟수 반복 (자바 for)
3. while loop  
    - 조건 반복 (자바 while)

*/


begin
    loop
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
    end loop;
end; --무한루프, 오버플로우가 발생하여 강제 종료됨.


declare
    vnum number := 1;    
begin
    loop
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
        vnum := vnum + 1;
--        exit;  --break문
        exit when vnum > 10; --탈출조건
    end loop;
end; --무한루프, 오버플로우가 발생하여 강제 종료됨.



create table tblloop
(
    seq number primary key,
    data varchar2(30) not null
);

create sequence loopSeq;

--데이터 1000건 넣기
--데이터1, 데이터2, 데이터3...

declare
    vnum number := 1;
begin
    loop
        insert into tblloop values (loopSeq.nextVal, '데이터' || vnum);
        vnum := vnum + 1;
        exit when vnum > 1000;
    end loop;
    
end;

select * from tblloop order by seq desc;



/*

2. for loop
- 지정횟수 반복

*/


begin
    --i : 루프변수, 1:초기값, 10: 최대값, ..:증가
    for i in 1..10 loop
        dbms_output.put_line(i);
    end loop;
end;

--구구단을 테이블로 만들기
create table tblggd
(
    seq number primary key,
    dan number not null,
    num number not null,
    result number not null
);

create sequence ggdSeq;


begin
    for dan in 2..9 loop
        for num in 1..9 loop
            insert into tblggd values (ggdseq.nextVal, dan, num, dan*num);
        end loop;
    end loop;
end;

select * from tblggd;


/*

3. while loop
- 조건부 loop

*/

declare
    vnum number := 1; --루프 조건 변수
begin
    while vnum <= 10 loop
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
    end loop;
end;



/*

select 실행하여 데이터를 가져오면 반드시 PL/SQL 변수에 저장해야 했음.
1. select into절 사용하기
    - 결과셋의 레코드가 한개일 때만 사용이 가능하다.
2. cursor 사용하기
    - 결과셋의 레코드가 0개 이상일 때 사용이 가능하다.
    - iterator와 비슷
    - select 결과셋의 참조 객체라 생각하면 됨.


*/

declare 
    vname tblinsa.name%type;
begin
    select name into vname 
        from tblinsa where num = '1001';
    dbms_output.put_line(vname);
end;


--다중행, 단일컬럼 가져오기(직원명 60개)
declare
    vname tblinsa.name%type;
    
    --커서 선언 (결과셋 참조 객체)
    cursor vcursor 
    is 
    select name from tblinsa order by name;

begin
    --커서 열기
    open vcursor;
    
    loop
        --데이터 접근(레코드 접근) + 커서 사용
        fetch vcursor into vname; --현재 커서가 가리키는 레코드의 컬럼값 가져오기 + 변수에 복사
        exit when vcursor%notfound; --읽은게 있으면 true, 없으면 false 반환
        dbms_output.put_line(vname);         
    end loop;
    
    --커서 닫기
    close vcursor;
end;


--다중행, 다중컬럼 가져오기
--기획부 직원들을 tblbonus 테이블에 insert
select * from tblinsa where buseo = '기획부';
select * from tblbonus;

declare 
    cursor vcursor 
    is select name, sudang from tblinsa where buseo = '기획부';
    vname tblinsa.name%type;
    vsudang tblinsa.sudang%type;
    vseq number;
begin
    open vcursor;
        loop
            fetch vcursor into vname, vsudang;
            exit when vcursor%notfound;
            select max(seq) + 1 into vseq from tblbonus; 
            insert into tblbonus values(vseq, vname, vsudang * 3);
        end loop;
    close vcursor;
end;

--여러개의 컬럼을 가져올 경우
declare 
    cursor vcursor is select * from tblinsa where buseo = '기획부';
    vrow tblinsa%rowtype;
    vseq number;
begin
    open vcursor;
        loop
            fetch vcursor into vrow;
            exit when vcursor%notfound;
            select max(seq) + 1 into vseq from tblbonus; 
            insert into tblbonus values(vseq, vrow.name, vrow.sudang * 3);
        end loop;
    close vcursor;
end;

select * from tblbonus;


/*
커서 탐색
1. 커서 + loop
2. 커서 + for loop
    - 커서 탐색을 단순화 시켜놓은 방법
*/

-- for loop 을 이용한 단순화된 커서 탐색 
declare
    cursor vcursor
    is select * from tblinsa;
    vrow tblinsa%rowtype;
begin
    open vcursor;
        loop
            fetch vcursor into vrow;
            exit when vcursor%notfound;
            dbms_output.put_line(vrow.name || ' : ' || vrow.buseo);
        end loop;
    close vcursor;
end;

declare
    cursor vcursor is select * from tblinsa;
    vrow tblinsa%rowtype;
begin
    for vrow in vcursor loop
        dbms_output.put_line(vrow.name || ' : ' || vrow.buseo);
    end loop;
end;

--단순 쿼리 용도 O, 복잡한 쿼리에는 X
begin 
    for vrow in (select * from tblinsa) loop
        dbms_output.put_line(vrow.name);
    end loop;
end;



--예외 처리부
--실행부에서 발생하는 예외를 처리하는 블럭

declare
    vdata number;
begin
    dbms_output.put_line('시작');
    select name into vdata from tblinsa where num = 1001;  --문자를 숫자 변수에 대입하여 에러남.
    dbms_output.put_line('끝');
    
exception --예외처리부
    when others then --try catch의 exception절
        dbms_output.put_line('예외 처리'); --others: 모든 예외를 잡는 역할
end;


--에러발생시간 및 에러내용을 기록하는 테이블
create table tblLog
(
    seq number primary key,
    code varchar2(7) not null check (code in ('AAA0001', 'AAA0002', 'AAA0003')),
    message varchar2(1000) not null,
    regdate date default sysdate not null
);

create sequence logSeq;


declare
    vcnt number := 0;
    vname varchar2(30);
begin
--    select count(*) into vcnt from tblcountry;
--    select name into vname from tblinsa where num = 1000;    --없는값 가져오기 에러
    
    dbms_output.put_line(100/vcnt); --0으로 나누기 에러
--    dbms_output.put_line(vname);

exception
    when zero_divide then 
        insert into tblLog values (logSeq.nextVal, 'AAA0002', 'tblCountry에 데이터가 없습니다.', default);   
    when no_data_found then 
        insert into tblLog values (logSeq.nextVal, 'AAA0003', 'tblInsa에서 가져온 데이터가 없습니다.', default);   
    when others then 
        insert into tblLog values (logSeq.nextVal, 'AAA0001', '에러 발생', default);
end;


select * from tblLog;


--여기까지는 익명 프로시저
-------------------------------------------------------------------------------------------------------------------------------------------
--실명 프로시저(저장 프로시저)

/*

저장 프로그램 종류
1. 저장 프로시저, Stored Procedure
    
    - 익명 프로시저 생성 방법
        [declare
            변수 선언;
            커서 선언;]
        begin
            구현부;
        [exception
            예외처리;]
        end;

    - 저장 프로시저 생성 방법
        create [or replace] procedure 프로시저명  --> 객체 생성!!!!
        is(as)
            [변수 선언;
            커서 선언;]
        begin
            구현부;
        [exception
            예외처리;]
        end [프로시저명];


2. 저장 함수Stored Function

*/

set serveroutput on;

--익명
declare 
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line('num: ' || vnum);
end;

--저장
create or replace procedure procTest
is
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line('num: ' || vnum);
end procTest;


/* 

저장 프로시저 호출 방법

1. PL/SQL 블록에서 호출하기
2. 스크립트 환경에서 호출하기(ANSI-SQL 환경)

*/

select * from tblinsa; --스트립트환경에서 사용하는 중

begin
    select * into 변수 from tblinsa; --PL/SQL환경에서 사용하는 중
end;


--1. PL/SQL에서 프로시저 호출(정석)
begin
    procTest;
    procTest;
    procTest;
    procTest;
    procTest;
    procTest;
end;


--2. 스크립트에서 호출(비권장)
execute procTest;
exec procTest;
call procTest();



--프로시저가 매개변수와 반환값을 가질 수 있는지?

--1. 매개변수가 있는 프로시저
create or replace procedure procTest(pnum number)
is
    --선언부에서 선언한 변수는 해당 프로시저 전체에서 사용이 가능한 전역변수가 됨.(begin~end)
    vsum number := 0;
begin
    vsum := pnum + 100;
    dbms_output.put_line(vsum);
end procTest;

--호출하기
begin
    procTest(100);
end;

--매개변수 개수 늘리기
create or replace procedure procTest(
    width number,
    height number
)
is 
    vresult number := 0;
begin
    vresult := width * height;
    dbms_output.put_line(vresult);
end procTest;

begin
    procTest(100, 200); --매개변수 갠수를 맞추지 않으면 에러남.
end;

--오라클 에서만 가능
create or replace procedure procTest(
    width number,
    height number default 10
)
is 
    vresult number := 0;
begin
    vresult := width * height;
    dbms_output.put_line(vresult);
end procTest;

begin
    procTest(100); --height를 default 값으로 10으로 설정했기 때문에 매개변수의 개수를 맞추지 않아도 에러안남. 마치 Java의 오버로딩과 비슷
end;



/*

매개변수 모드★★★★★★★★★★★
- 매개변수의 값을 전달하는 방법

1. in 모드 : 아무것도 안써도 기본 모드
2. out 모드
3, in out 모드 (잘안씀)

*/

create or replace procedure procTest(
    vnum1 in number,
    vnum2 in number,
    vresult out number, --반환값(주소값, 참조값이 넘어감.)  
    vresult2 out number --리턴은 하나의 값만 반환할 수 있는데 out parameter는 여러개의 값을 넘길 수 있음.
)
is
begin
    vresult := vnum1 + vnum2;
    vresult2 := vnum1 * vnum2;
end procTest;

declare
    vresult number;
    vresult2 number;
begin
--    dbms_output.put_line(procTest(10, 20)); --이런건 안됨..
    procTest(10, 20, vresult, vresult2); --매개변수 세 개 짜리 프로시저이기 때문에 결과를 넘겨받을 변수를 생성하여 매개변수로 넘겨주어야 함.
    dbms_output.put_line(vresult || ', ' || vresult2);
end;



--직원번호를 전달하면 이름, 나이, 부서, 직위 반환 프로시저
create or replace procedure procGetInsa(
    pnum in number,
    pname out varchar2, --매개변수는 길이를 표현할 수 없다.
    page out number,
    pbuseo out varchar2,
    pjikwi out varchar2
)
is
begin
    select 
        name, floor(months_between(sysdate, to_date(case
        when substr(ssn, 8, 1) in ('1', '2') then '19' || substr(ssn, 1, 6)
        when substr(ssn, 8, 1) in ('3', '4') then '20' || substr(ssn, 1, 6)
    end, 'yyyymmdd')) / 12), buseo, jikwi into pname, page, pbuseo, pjikwi
    from tblInsa
        where num = pnum;
end procGetInsa;

select
    -- 19951010 or 20011010
    floor(months_between(sysdate, to_date(case
        when substr(ssn, 8, 1) in ('1', '2') then '19' || substr(ssn, 1, 6)
        when substr(ssn, 8, 1) in ('3', '4') then '20' || substr(ssn, 1, 6)
    end, 'yyyymmdd')) / 12)
from tblInsa;


declare
    vnum tblInsa.num%type;
    vname tblInsa.name%type;
    vage number;
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
begin
    vnum := 1050;
    procGetInsa(vnum, vname, vage, vbuseo, vjikwi);
    dbms_output.put_line(vname);
    dbms_output.put_line(vage);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
end;




--직원 추가 프로시저

-- insert 프로시저
create or replace procedure procAddInsa(
    pname varchar2,
    pssn varchar2,
    pyear varchar2,
    pmonth varchar2,
    pdate varchar2,
    pcity varchar2,
    ptel varchar2,
    pbuseo varchar2,
    pjikwi varchar2,
    pbasicpay number,
    psudang number,
    presult out number -- 1(성공) or 0(실패), 에러가 발생했는지 확인시켜주는 변수
)
is
begin
    insert into tblinsa (num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang) 
    values ((select max(num) from tblinsa)+1, pname, pssn, to_date(pyear || pmonth || pdate,'yyyymmdd'), pcity,  ptel, pbuseo, pjikwi, pbasicpay, psudang);
       
    presult := 1;
exception
    when others then
        presult := 0;
end;

declare
    vresult number;
begin
    procAddInsa('아무개','901110-1010101', '2003','05','20','서울','010-1234-5678','영업부','대리',2000000,100000, vresult);
    if vresult = 1 then
        dbms_output.put_line('추가 성공');
    else
        dbms_output.put_line('추가 실패');
    end if;
end;

select * from tblinsa;











select * from tblstaff;
select * from tblproject;


--퇴사 프로시저
--1. 퇴사직원의 업무 위임
--2. 퇴사 처리

create or replace procedure procDeleteStaff(
    pseq number, --퇴사할 직원번호(PK)
    pstaff number, --위임받을 직원의 직원번호,
    presult out number --성공여부 저장 변수
)
is
    --변수?
    vcnt number;
begin

    --1. 해당 직원의 담당 프로젝트가 있는지?
    select count(*) into vcnt from tblProject where staff = pseq;
    
    --2. 담당업무 여부에 따라 나누기
    if vcnt > 0 then
 
        --3. 위임 후 퇴사
        update tblProject set 
            staff = pstaff
                where staff = pseq;
    
    else
        --3. 바로 퇴사
        null; --나중을 위해서 else절을 그대로 둘 경우 null이라 적어둔다. (빈 블럭 표시)
    
    end if;
    
    delete from tblstaff where seq = pseq;
    presult := 1;
    commit;
    
exception
    when others then 
        presult := 0;
        rollback;   --예외가 발생하여 실패하면 되돌리기 위해
end;

set serveroutput on;

declare
    vresult number;
begin
    procDeleteStaff(3, 4, vresult);
    
    if vresult = 1 then 
        dbms_output.put_line('퇴사 성공');
    else
        dbms_output.put_line('퇴사 실패');
    end if;
end;





/*

함수, function
- 실행 후 결과값을 1개만 반환하는 프로그램(공식적으로 리턴문이 있음, 프로시저의 out parameter는 반환값이 아님..)
- 함수에서도 out매개변수를 사용할 수 있지만 사용하면 안됨, 함수의 성질을 잃어버림. -> return 사용!!

*/


--두 수의 합을 반환하는 함수 생성
create or replace function fnSum(
    pnum1 number,
    pnum2 number
) return number
is
begin
    return pnum1 + pnum2;
end;


--함수 호출
declare
    vresult number;
begin 
    vresult := fnSum(100, 200);
    dbms_output.put_line(vresult);
end;


/*함수와 프로시저의 차이점*/

-- 함수는 ANSI-SQL처럼 사용이 가능함.
select basicpay, sudang, fnSum(basicpay, sudang) from tblinsa;

--ex) 주민번호에서 성별 가져오는 function 생성하기
create or replace function fnGender(
    pssn varchar2
) return varchar2
is
begin
    return 
            case
                when substr(pssn, 8, 1) in ('1', '3') then '남자'
                when substr(pssn, 8, 1) in ('2', '4') then '여자'
            end; 
end;

--  사용하기
select name, fnGender(ssn) as gender from tblinsa;




/*

트리거, Trigger
- 프로시저
- 특정 사건이 발생하면 자동으로 실행되는 프로시저(예약을 걸어놓은 것처럼 작동)
- 특정 테이블을 목표로 하여 insert, update, delete가 발생하는지 감시
- 트리거가 많아지면 시스템 속도가 느려짐. (트리거는 24시간 계속 살아있기 때문에..)


-트리거 구문
create or replace trigger 트리거명
    *트리거 옵션
    before | after
    insert | update | delete on 테이블명
    for each row
declare
    선언부;
begin
    실행부
end;


*/



--직원 퇴사에 대해 트리거 걸기
--특정 요일(목)에는 tlbStaff의 데이터 조작을 못하도록 금지하기

create or replace trigger trgStaff
    before
    delete on tblStaff
begin
--    dbms_output.put_line('트리거가 실행되었습니다.');
    if to_char(sysdate, 'dy') = '목' then
        --현재 진행하려던 업무를 없었던 일로 처리하기 -> 강제로 에러 발생시키기
        raise_application_error(-20001, '목요일에는 퇴사가 불가능합니다.'); --에러 번호 : -20000~ -29999
    end if;
end;

update tblProject set staff = 4 where staff = 2;

delete from tblStaff where seq = 2;

select * from tblstaff;
select * from tblProject;

rollback;


--로그 기록하기
--staff테이블에 변화가 발생하면 기록 남기기

create table tblLogStaff(
    seq number primary key, 
    message varchar2(1000) not null,
    regdate date default sysdate not null
);

create sequence seqlogStaff;

create or replace trgLogStaff
    after
    insert or update or delete on tblStaff
    
declare
    vmessage varchar(1000);
    
begin
    if inserting then
        vmessage := '새 직원이 추가되었습니다.';
    elsif updating then
        vmessage := '직원 정보가 수정되었습니다.';
    elsif deleting then 
        vmessage := '직원이 삭제되었습니다.';
    end if;
    
    insert into tblLogStaff values (seqLogStaff.nextVal, vmessage, default);
    
end;


/**트리거**

1. for each row 표현 O : 행 단위 트리거 -> 트리거 실행이 반복 -> 감시하는 작업이 발생한 레코드의 수만큼 트리거 실행
    : 적용되는 레코드의 정보가 중요한 경우, 변경이 발생된 데이터를 참조 가능
2. for each row 표현 X : 문장 단위 트리거 -> 트리거 실행이 1회 -> 감시하는 작업이 발생한 레코드의 수에 상관없이 트리거는 1번 실행
    : 적용되는 레코드의 정보는 중요하지 않음. 사건만 중요한 경우

for each row를 사용하는 경우
- 상관 관계(:old, :new)를 사용한다

1. insert
    - 트리거 내에서 방금 추가된 레코드의 컬럼값들을 참조할 수 있다.
    - :new = 방금 추가된 행
    - :new.컬럼명 = 방금 추가된 행의 컬럼
    - after 트리거에서 사용
    
2. update
    - 트리거 내에서 방금 추가된 레코드의 전후 컬럼값들을 참조할 수 있다.
    - :new = 방금 수정된 결과행
    - :old = 수정 전 행

3. delete
    - 트리거 내에서 방금 삭제된 레코드를 참조할 수 있다.
    - :old = 방금 삭제된 행
    - before 트리거에서 사용

*/

create or replace trigger trgComedian
    after   
    update on tblComedian
    for each row
begin
    --for each row가 있어야 :old, :new 키워드를 쓸 수 있다.
    dbms_output.put_line(:old.last || :old.first ||'의 정보가 수정되었습니다.');
    dbms_output.put_line('이전 몸무게 : ' || :old.weight);
    dbms_output.put_line('현재 몸무게 : ' || :new.weight);
end;

update tblComedian 
    set weight = weight * 1.1
        where first = '재석' and last = '유';

update tblComedian 
    set weight = weight * 1.1
        where gender = 'm';

rollback;


/* before가 아니면 안되는 경우*/

select * from tblStaff;
select * from tblProject;
insert into tblStaff values (5, '홍길동', 300, '서울시');
update tblProject set staff = 5 where seq in (1, 3, 6);

--5번홍길동 퇴사시키기
delete from tblStaff where seq = 5; --> 프로젝트를 위임하고 가야함. 현재는 실행 안됨.

--인수인계 트리거
create or replace trigger trgDeleteStaff
    before
    delete on tblStaff
    for each row
declare
begin
    update tblProject set
        staff = 4
            where staff = :old.seq;
end;

/* 게시판 댓글쓰기?*/
drop table tblBoard;

create table tblBoard(
    seq number primary key,
    subject varchar2(1000) not null,
    commentCount number default 0 not null
);

create table tblComment(
    seq number primary key,
    subject varchar2(1000) not null,
    pseq number not null references tblBoard(seq)
);

--글쓰기

insert into tblBoard values (1, '게시판입니다.', default);
insert into tblBoard values (2, '안녕하세요. 홍길동입니다.', default);
insert into tblBoard values (3, '오라클 수업중입니다.', default);

--댓글쓰기
insert into tblComment values (1, '1번글 댓글입니다.', 1);
update tblBoard set commentCount = commentCount + 1 where seq = 1;


--위의 작업을 프로시저로 작성 (권장)
create or replace procedure procAddComment(
    pseq number,
    psubject varchar2,
    ppseq number
)
is
begin
    insert into tblComment values (pseq,psubject,ppseq);
    update tblBoard set commentCount = commentCount + 1 where seq = ppseq;
end;

begin
    procAddComment(2, '2번에 다는 댓글입니다', 2);
end;

--위의 작업을 트리거로 작성 (비용이 더 비쌈)
create or replace trigger trgAddComment
    after
    insert on tblComment
    for each row
begin
    update tblBoard set commentCount = commentCount + 1
        where seq = :new.pseq;
end;

insert into tblComment values (3, '1번글 댓글2입니다.', 1);

select * from tblBoard;
select * from tblComment;

/*
자식테이블이 있는 부모테이블을 삭제하는 방법

1. 강제로 삭제(FK제약 강제 삭제)
    - drop table 테이블명 cascade constraints purge;
    - 나중에 복구하기가 힘듬.. 추천X

2. 관계가 있는 테이블들 목록 조회
SELECT fk.owner, fk.constraint_name , fk.table_name
    FROM all_constraints fk, all_constraints pk
        WHERE fk.R_CONSTRAINT_NAME = pk.CONSTRAINT_NAME
            AND fk.CONSTRAINT_TYPE = 'R'
                AND pk.TABLE_NAME = 'TBLBOARD' --대문자
                    ORDER BY fk.TABLE_NAME;
                    
3. 관계있는 테이블들 목록 조회(ERD) -역공학
*/


/* 커서(결과셋)을 반환하는 프로시저 만들기 */

select * from tblInsa where buseo = '?';

create or replace procedure procBuseo(
    pbuseo varchar2
)
is
    cursor vcursor is select * from tblInsa where buseo = pbuseo;
    vrow tblInsa%rowtype;
begin
    open vcursor;
    loop
        fetch vcursor into vrow; --레코드 1개 가져와서 변수에 복사
        exit when vcursor%notfound;
        dbms_output.put_line(vrow.name); --프로시저 안에 출력문을 넣으면 개발자만 확인할 수 있고 자바에서 연동이 안됨.
    end loop;    
    close vcursor;
end;

begin
    procBuseo('영업부');
end;


create or replace procedure procBuseo(
    pbuseo varchar2,
    presult out sys_refcursor --반환값으로 커서를 사용할 때 사용하는 자료형
)
is
begin
    open presult
        for select * from tblInsa where buseo = pbuseo;
end;

-- 커서를 반환할 프로시저를 호출하기

declare
    vresult sys_refcursor; --커서
    vrow tblInsa%rowtype;
begin
    procBuseo('영업부', vresult);
    loop
        fetch vresult into vrow;
        exit when vresult%notfound;
        --오라클에서는 그냥 출력문으로 확인할 수 있음.. java로 2차원 배열 형식으로 해당 테이블의 자료를 가져갈 수 있다.
        dbms_output.put_line(vrow.name);
    end loop;
end;














