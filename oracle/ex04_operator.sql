/*

연산자, Operator

1. 산술 연산자
- +, -, *, /
- %(없음) -> 함수로 제공(mod())

2. 문자열 연산자
- concat
- +(X)  -> ||(O)

3. 비교 연산자 
- >, >=, <, <=
- =(==), <>(!=)
- 주로 조건을 판단할 때만 쓴다. 
- 컬럼 리스트에서 사용 불가, 조건절(where)에서 사용한다.

4. 논리 연사자
- and(&&), or(||), not(!)
- 컬럼 리스트에서 사용 불가, 조건절(where)에서 사용한다.

5. 대입 연산자
- =
- 복합 연산자(+=)는 없음. 
- insert, update 문에서 주로 사용, select절에서는 아예 쓸 일이 없음.

6. 3항 연산자
- 없음!(흐름이라는 것이 없기 때문에)
- 유사한 행동을 하는 함수는 있음.

7. 증감 연산자
- 없음!
- num++(X) -> num = num + 1

8. SQL연산자 (절)
- in, between, like, is, any, all 등...

*/

--scott
select * from emp;
desc emp;

select ename, sal, sal + 100, 100 , sal / 3 from emp;
select 100 from emp;

select ename || ' ' || job from emp;

select empno, sal, empno > sal from emp; --에러나서 안됨. boolean 자료형이 없기 때문에..
select empno, sal from emp where empno > sal;--조건을 걸 때 쓰인다.
