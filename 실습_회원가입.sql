DROP TABLE Person;

CREATE TABLE  Person(
  seq	      INTEGER PRIMARY KEY AUTO_INCREMENT,
  userid	  VARCHAR(40) UNIQUE NOT NULL,
  password	  VARCHAR(64) NOT NULL,
  name        VARCHAR(40)  NOT NULL,
  level		  tinyint(1) NOT NULL,
  gender      CHAR(1)  NOT NULL,
  phone       VARCHAR(20)  NOT NULL
);

INSERT INTO Person (userid, password, name, level, gender, phone)
			VALUES ('admin', SHA2("0000", 256), "관리자", 0, "M", '000-1234-5678');
INSERT INTO Person (userid, password, name, level, gender, phone)
			VALUES ('user01', SHA2("1111", 256), "이가희", 1, "F", '000-1111-2222');
INSERT INTO Person (userid, password, name, level, gender, phone)
			VALUES ('user02', SHA2("2222", 256), "양명진", 1, "M", '000-3333-4444');
INSERT INTO Person (userid, password, name, level, gender, phone)
			VALUES ('user03', SHA2("3333", 256), "오승원", 1, "M", '000-5555-6666');

-- 0 row(s) affected, 1 warning(s): 1681 Integer display width is deprecated and will be removed in a future release.

SELECT * FROM Person;
DESC Person;

# 로그인(select)
-- SELECT * FROM Person WHERE userid = ? AND password = SHA2(?, 256) AND level = ?;
SELECT userid, level, name
  FROM Person
 WHERE userid = 'admin' AND password = SHA2("0000", 256) AND level = 0;
 
 SELECT userid, level, name FROM Person WHERE userid = "admin" AND password = SHA2("0000", 256) AND level = 0;

# 사원등록(insert)
-- INSERT INTO Person (userid, password, name, level, gender, phone) VALUES (?, SHA2(?, 256), ?, ?, ?, ?);

# 마이페이지(update) - 비밀번호, 전화번호만 수정 가능
-- UPDATE Person SET password = SHA2(?, 256), phone = ?  WHERE userid = ?;

UPDATE Person SET password = SHA2("1111", 256), phone = "010-0909-7777"  WHERE userid = "admin";

SELECT userid, level, name FROM Person WHERE userid = ? AND password = SHA2(?, 256) AND level = ?;
SELECT * FROM Person WHERE userid = ?;
UPDATE Person SET name = ?, password = SHA2(?, 256), phone = ?  WHERE userid = ?;
INSERT INTO Person (userid, password, name, level, gender, phone) VALUES (?, SHA2(?, 256), ?, ?, ?, ?);

UPDATE Person SET name = ?, password = SHA2(?, 256), gender = ?, phone = ?  WHERE userid = ?;


SELECT * FROM Person WHERE userid = "TestUser";

SELECT * FROM movie_list;