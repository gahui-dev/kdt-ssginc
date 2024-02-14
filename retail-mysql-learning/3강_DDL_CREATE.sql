# 3강 DDL - Data Definition Langauage (데이터 정의어)

# 데이터 정의어 - CREATE / ALTER / DROP

# 데이터 타입 종류
-- INTEGER / INT - 4바이트 정수형
-- NUMERIC(m,d) / DECIAMAL(m,d) - 전체자리수 m, 소주점 이하 자리수 d를 가진 숫자형
-- CHAR(n) - 문자형 고정길이
-- VARCHAR(n) - 문자형 가변길이
-- DATE - 날짜형, 연도, 월, 날, 시간 저장

# CREATE 기본 문법
-- 테이블 구성, 속성과 속성에 관한 제약 정의, 기본키 및 외래키를 정의
-- PRIMARY KEY : 기본키를 정할 때 사용 
-- FOREIGN KEY : 외래키를 지정할 때 사용
-- ON UPDATE와 ON DELETE : 외래키 속성의 수정과 튜플 삭제 시 동작을 나타냄

/*
CREATE TABLE 테이블이름
    ({ 속성이름 데이터타입
		[NOT NULL | UNIQUE | DEFAULT 기본값 | CHECK 체크조건]
	}
		[PRIMARY KEY 속성이름(들)]
		{[FOREIGN KEY 속성이름 REFERENCES 테이블이름(속성이름)]
		[ON DELETE [CASCADE┃SET NULL]
	})
*/

# FOREIGN KEY
-- 외래키 제약조건을 명할 때는 반드시 참조되는 테이블(부모 릴레이션)이 존재해야 하며 참조되는 테이블의 기본키
-- 외래키 지정 시 ON DELETE 또는 ON UPDATE 옵션은 참조되는 테이블의 튜플이 삭제되나 수정될 때 취할 수 있는 동작을 지정
-- NO ACTION 은 어떠한 동작도 취하지 않음

# 테이블 생성(1)
CREATE TABLE NewBook(
	bookid INTEGER
   ,bookname VARCHAR(20)
   ,publisher VARCHAR(20)
   ,price INTEGER
   ,PRIMARY KEY (bookid)
);

# 테이블 생성(2)
CREATE TABLE NewBook(
	bookid INTEGER PRIMARY KEY 
   ,bookname VARCHAR(20) DEFAULT "안녕"
   ,publisher VARCHAR(20) UNIQUE
   ,price INTEGER CHECK(price > 1000)
);

# 테이블 생성(3)
# PRIMARY KEY 제약조건 걸기
CREATE TABLE NewBook(
	bookid INTEGER
   ,bookname VARCHAR(20)
   ,publisher VARCHAR(20)
   ,price INTEGER
   ,CONSTRAINT newbook_bookid_pk PRIMARY KEY (bookid)
);

# 테이블 생성(4)
CREATE TABLE NewBook(
	bookid INTEGER PRIMARY KEY 
   ,bookname VARCHAR(20) DEFAULT "안녕"
   ,publisher VARCHAR(20)
   ,price INTEGER
   ,CONSTRAINT newbook_price_ck CHECK(price > 1000)
);

# CONSTRAINTS(제약조건)
SELECT *
	FROM
		INFORMATION_SCHEMA.TABLE_CONSTRAINTS
	WHERE
		TABLE_SCHEMA = 'madang'
		AND TABLE_NAME = 'NewOrders';
        
DESC INFORMATION_SCHEMA.TABLE_CONSTRAINTS;

SHOW TABLES;
DROP TABLE NewBook;
DESC NewBook;

-- Error Code: 3819. Check constraint 'newbook_chk_1' is violated.	0.0013 sec
INSERT INTO NewBook ( bookid, price ) VALUES( 2, 3000 );
    
ROLLBACK;

# [3-35] 문제
CREATE TABLE NewCustomer(
	custid INTEGER PRIMARY KEY
   ,name VARCHAR(40)
   ,address VARCHAR(40)
   ,phone VARCHAR(30)
);

# [3-36] 문제
CREATE TABLE NewOrders(
	orderid INTEGER
   ,custid INTEGER NOT NULL
   ,bookid INTEGER NOT NULL
   ,saleprice INTEGER
   ,orderdate DATE
   ,PRIMARY KEY (orderid)
   ,FOREIGN KEY (custid) REFERENCES NewCustomer(custid)
    ON DELETE CASCADE
);

INSERT INTO NewCustomer (custid, phone) VALUES (1, '123452134124124');
INSERT INTO NewCustomer (custid, phone) VALUES (2, '000000000');

INSERT INTO NewOrders (orderid, custid, bookid) VALUES (1, 1, 1);
INSERT INTO NewOrders (orderid, custid, bookid) VALUES (2, 1, 2);
INSERT INTO NewOrders (orderid, custid, bookid) VALUES (3, 2, 0);

DELETE FROM NewCustomer WHERE custid = 1;
DELETE FROM NewCustomer WHERE custid = 2;

DESC NewCustomer;
DESC NewOrders;

SELECT * FROM NewCustomer;
SELECT * FROM NewOrders;

DROP TABLE NewCustomer;
DROP TABLE NewORders; 