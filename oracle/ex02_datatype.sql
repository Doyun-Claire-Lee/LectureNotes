/* 

ANSI-SQL 자료형
    - 오라클 자료형
    
    1. 숫자형
        a. number (********)
            - 정수 + 실수
            - (유효자리)38자리 이하의 숫자를 표현하는 자료형
            - 5~22 byte
            - number(precision, scale)
                1) precision: 소수 이하를 포함한 전체 자릿수(1~38)
                2) scale: 소수점 이하의 자릿수를 별도로 표현(0~127)
            - ex) number유효자리 38자리 유지한 모든 숫자(정수_실수)
            - ex) number(3) : 3자리까지 표현 가능한 정수(-999~999)
            - ex) number(4,2) : 4자리까지 표현 가능한 숫자 + 소수 이하는 2자리까지 표현(-99.99 ~ 99.99) (4자리 안에 2자리가 포함된 값)  
                                
    2. 문자형
        - 문자형 + 문자열
        - 자바의 String과 유사
        
        a. char
            - 고정 자릿수 문자열 : 1바이트만 저장해도 처음 설정한 n바이트가 필요함.
            - char(n) : n자릿수 문자열, n(바이트)
            - 최소 크기 : 1바이트
            - 최대 크기 : 2000바이트
            - ex) char(3) : 최대 3바이트까지 문자열 저장 가능 //  영어 3자, 한글1자
            - ex) char(10) : 최대 10바이트까지 문자열 저장 가능// 영어 10자, 한글 3자
            - ex) char(2000) : 최대 2000바이트까지 문자열 저장 가능// 영어 2000자, 한글 666자
            
        b. nchar
            - n: National -> 유니코드를 지원 -> UTF-16 으로 동작 -> 모든 문자를 2바이트로 저장
            - nchar(n): n자리 문자열, n(글자 수)
            - 최소 크기: 1글자(2바이트)
            - 최대 크기: 2000글자(4000바이트)
            - 일반적으로 잘 안쓰임.
            
        c. varchar2(*******)
            - 가변 자릿수 문자열 : 최대 n바이트 까지 가능하지만 더 적은 용량을 사용하면 적은 용량이 쓰임. 
            - varchar2(n) : n자리 문자열, n(바이트)
            - 최소 크기: 1바이트
            - 최대 크기: 4000바이트 
            
        d. nvarchar2
            - n: National -> 유니코드를 지원 -> UTF-16 으로 동작 -> 모든 문자를 2바이트로 저장
            - nvarchar2(n): n자리 문자열, n(글자 수)
            - 최소 크기: 1글자(2바이트)
            - 최대 크기: 1000글자(2000바이트)
            
        e. 비교
            - char vs varchar2 : 저장 길이
            - char vs nchar : 문자 하나당 길이

    3. 날짜/시간형
            - 자바 Calendar, Date
            
            a. date(*******)
                - 년월일시분초
                - 7바이트
                - 기원전 4712년 1월 1일 ~ 9999년 12월 31일
            
            b. timestamp
                -년월일시분초 + 밀리초 + 나노초
                
            c. interval
                - 시간 데이터, 틱값
                - number 에 대치되어 잘 안쓰임.
    
    4. 이진 데이터 자료형
        - 비 텍스트 데이터
        - 이미지, 영상, 음악 등.....
        - 실제 실무에서는 DB에 이진데이터를 저장하지 않음. 파일은 하드에 직접 저장하고 DB에는 파일 이름만 저장함.
        - ex)'터미네이터.mp4'
        a. blob
            - 최대 128TB

*/

drop table tblType;


create table tblType
(       -- 테이블 생성: 컬럼 구성 -> "컬럼명 자료형" 
        --num number
        --num number(4,2)
        --txt char(30),
        --txt2 varchar2(30)
        txt nchar(3)
);

-- 데이터 추가하기
insert into tblType (num) values (100);
insert into tblType (num) values (3.14);
insert into tblType (num) values (12345678901234567890123456789012345678);
insert into tblType (num) values (1234567890123456789012345678901234567890123456);
insert into tblType (num) values (999);
insert into tblType (num) values (1000);    --num(3)일때 에러남
insert into tblType (num) values (-999);
insert into tblType (num) values (99.99);
insert into tblType (num) values (-99.99);

insert into tblType (txt) values (100); --암시적 형변환 발생 
insert into tblType (txt) values ('100');   -- 오라클은 문자 리터럴을 ' '로 표현함.
insert into tblType (txt) values ('abc');
insert into tblType (txt) values ('abcd');
insert into tblType (txt) values ('가');
insert into tblType (txt) values ('가나');

insert into tblType(txt, txt2) values ('abc', 'abc');

insert into tblType (txt) values ('가'); --nchar(3)
insert into tblType (txt) values ('가나');
insert into tblType (txt) values ('가나다');
insert into tblType (txt) values ('가나다라');

-- 데이터 가져오기
select * from tblType;

drop table tblType2;
create table tblType2
(
        name varchar2(10), --이름 저장
        age number(3),          --나이 
        birthday date                --날짜
);

insert into tblType2(name, age, birthday) values ('홍길동', 20, '1995-01-20');

select * from tblType2; --95/01/20, 나중에 문법을 통해 형식을 맞추어 가져올 수 있음.

