/*
table : move_list
column :
	m_id int auto_increment pk
    m_name varchar(200) not null
sample data:
	10개 정도 넣기
    
1. 백엔드 구성
2. 화면 설계
	- /movie, get: movie.jsp (select box), param (m_id)
    - /movie, post: movieResult.jsp (radio box)
3. 쿼리
*/

USE madang;

DROP TABLE movie_list;

CREATE TABLE movie_list (
  m_id      INTEGER PRIMARY KEY AUTO_INCREMENT,
  m_name    VARCHAR(30) NOT NULL
);

SELECT * FROM movie_list;

INSERT INTO movie_list (m_name) VALUES ("밀수");
INSERT INTO movie_list (m_name) VALUES ("그란 투리스모");
INSERT INTO movie_list (m_name) VALUES ("악마들");
INSERT INTO movie_list (m_name) VALUES ("발레리나");
INSERT INTO movie_list (m_name) VALUES ("폴라");
INSERT INTO movie_list (m_name) VALUES ("악녀");
INSERT INTO movie_list (m_name) VALUES ("스즈메의 문단속");
INSERT INTO movie_list (m_name) VALUES ("헌트");
INSERT INTO movie_list (m_name) VALUES ("데몰리션");
INSERT INTO movie_list (m_name) VALUES ("강남 좀비");



#MySQL 데이터베이스에서 현재 연결된 세션의 수를 확인하는 쿼리
SHOW STATUS LIKE 'Threads_connected'; 


SELECT COUNT(*) AS ConnectionCount
FROM information_scMEMBERhema.PROCESSLIST
WHERE DB = 'madang';


Select * FROm member;


# 1. 100개 정도 더미 데이터 만들기
-- 마녀 1 ~ 100
# 2. 페이징 처리 1 | 2 | 3 | 4 | 5 |
SELECT *
  FROM (SELECT *
		  FROM movie_list
		 ORDER BY m_id DESC
		 LIMIT 0, 10) AS A;

# 3. 어떻게 처리할지 고민

SELECT * FROM movie_list;
DESC movie_list;

SELECT concat("밀수", (SELECT max(m_id) FROM movie_list)) FROM movie_list;

SELECT max(m_name) FROM movie_list;

SHOW GLOBAL variables like 'log_bin_trust_function_creators';
SET GLOBAL log_bin_trust_function_creators = 1;
-- Error Code: 1227. Access denied; you need (at least one of) the SUPER or SYSTEM_VARIABLES_ADMIN privilege(s) for this operation

# 1. 더미 데이터 만들기
-- 함수 생성
DELIMITER $$

CREATE FUNCTION GetMaxValue() RETURNS INT
BEGIN
DECLARE max_value INT;
SELECT MAX(m_id) INTO max_value FROM movie_list;
RETURN max_value;
END $$

DELIMITER ;

-- 더미 데이터 만들기
INSERT INTO movie_list (m_name) VALUES (CONCAT('movie-', GetMaxValue()));

SELECT * FROM movie_list
 ORDER BY m_id DESC
 LIMIT 0, 10;
 
 SELECT * FROM movie_list
 ORDER BY m_id DESC
 LIMIT 10, 10;
 
  SELECT * FROM movie_list
 ORDER BY m_id DESC
 LIMIT 20, 10;
 
   SELECT * FROM movie_list
 ORDER BY m_id DESC
 LIMIT 30, 10;

SELECT *
  FROM (SELECT *
		  FROM movie_list
		 ORDER BY m_id DESC
		 LIMIT 0, 10) AS A;

# 페이지네이션 쿼리
SELECT (SELECT COUNT(*) FROM movie_list) AS totalDataCount, A.* 
  FROM (SELECT * FROM movie_list ORDER BY m_id DESC LIMIT 23, 10) A;
  
# 페이징 처리 service.findMovieByPaging(int pageNum), dao.selectMovieByPaging(int pageNum)
# MovieEntity -> totalDatacount, m_id, m_name
-- SELECT (SELECT COUNT(*) FROM movie_list) AS totalDataCount, A.* 
--   FROM (SELECT * FROM movie_list ORDER BY m_id DESC LIMIT (pageNum * amount - (amount - 1)) ,  amount) A

