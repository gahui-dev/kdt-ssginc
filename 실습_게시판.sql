show tables;
DROP TABLE BOARD;


CREATE TABLE BOARD(
   seq int AUTO_INCREMENT PRIMARY KEY
    ,title varchar(200) NOT NULL
    ,writer varchar(50) NOT NULL
    ,regdate timestamp NOT NULL DEFAULT NOW()
    ,up_date timestamp
    ,contents text
);
desc board;
#데이터 삽입
INSERT INTO board(title,writer,regdate,contents)
   VALUES('바람과 함께 사라지다','김지윤',sysdate(),"정말 재밌어요!!")
    ,('센과 치히로의 행방불명','지브리',sysdate(),"힐링임ㅋㅋㅋㅋㅋ")
    ,('마녀','김성준',sysdate(),"너무 무섭다..");

# 게시판 전체 목록 조회
select * from board;
commit;



# 게시글 수정
# updateOne(BoardDTO), modifyOne(BoardMsg), String message="게시글이 정상적으로 수정되었습니다."
UPDATE board
   SET up_date = current_date()
      ,title = "제목 수정!!"
        ,contents="내용 수정?!?!"
   WHERE seq=1;
select * from board 
   ORDER BY seq desc;
rollback;
commit;


# 게시물 등록
# /board/register, Post
# registerOne(BoardDTO), insertOne(BoardDTO)
INSERT INTO board(title,writer,regdate,contents)
   VALUE('마녀2','유하나',current_timestamp(),"두번보세요~~!!");


#게시물 삭제
# /board/remove, DELETE
# removeOne(BoardMsg), deleteOne(BoardDTO)
DELETE FROM board
   WHERE seq IN (11);

# 게시물 선택삭제
# /board/remove-list, DELETE
# removeSelectList(List<Integer> list), String
# deleteSelectList(list), int
# 
DELETE FROM board
   WHERE seq IN (11,12,13);