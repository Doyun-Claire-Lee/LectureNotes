--교재 72p ~ 126p

/*

distinct
- 컬럼리스트에서 사용
- 중복값 제거
- disticct 컬럼명

*/

--이 테이블에는 어떤 부서들이 있는지?
select distinct buseo from tblinsa;
select distinct city from tblinsa;
select distinct continent from tblcountry;

select  DISTINCT * from tblinsa; --한 라인을 한 덩어리로 봄! 
select city,  name from tblinsa;
select distinct city,  name from tblinsa;  --> distict (city, name) 과 같이 한 덩어리로 봄
select distinct city, buseo from tblinsa;

/*

case 
- 컬럼리스트에서 사용 + 조건절에서 사용
- 자바의 if or switch 역할
- case ~ when 조건 then 반환값 end
- 조건을 만족 못하면 null을 반환(*****************)

*/

select 
    last || first as name,
    case 
        when gender = 'm' then '남자' 
        when gender = 'f' then'여자'
    end as genderName,
    gender
from tblcomedian;

select 
    name,
    case 
        when continent = 'AS' then '아시아'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        --when continent = 'SA' then '아메리카'
        --when continent = 'AU' then '호주'
        --else '기타' --> null이 될 데이터를 '기타'로 반환
        --else continent --> 처리 불가능한건 원본으로 반환함(**) 자주 쓰임
        --else capital --> 다른 컬럼을 가져와서 쓰는 것, 하지 말기!
        --else area --> 다른 자료형 :  물리적, 논리적 오류
    end as continent
from tblcountry;

--가공 데이터의 중복값 제거 가능
select 
    distinct
    case 
        when continent = 'AS' then '아시아'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        when continent = 'SA' then '아메리카'
        when continent = 'AU' then '호주'
    end  as continenet 
from tblcountry;

select 
    last || first as name,
    weight,
    case
        when weight > 100 then '과체중'
        when weight > 50 then '정상체중'
        when weight > 0 then '저체중'
    end as state
from tblcomedian;
    
select * from tbltodo;
select 
   -- title, 
   case
        when completedate is null then '[*]' || title
        when completedate is not null then title
    end as title,
    case
        when completedate is null then '해야할 일'
        when completedate is not null then '완료한 일'
    end as state
from tbltodo;

select 
    name,
    buseo,
    jikwi,
    case 
        when ibsadate > '2016-10-23' then '주니어'
        when ibsadate <= '2016-10-23' and ibsadate > '2012-10-23' then '시니어'
        when ibsadate <= '2012-10-23' then '익스퍼트'
    end as lv
from tblinsa;

select 
    name, 
    case
        when couple is null then '싱글'
        when couple is not null then '커플'
    end as state
from tblMen;