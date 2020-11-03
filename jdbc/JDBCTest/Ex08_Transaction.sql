
select * from tblBoard;
select * from tblComment;


--프로시저(오라클 내에서) 트랜잭션 제어 
create or replace procedure procAddComment(
    --댓글쓰기 매개변수들..
)
is
begin

    --1. 카운트 증가
    update tblBoard set commentCount =  commentCount + 1
        where seq = 1;
    --2. 댓글쓰기
    insert into tblComment(seq, subject, pseq) values (1, '댓글', 1);
    
    commit;

exception
    when others then
        rollback;

end;










