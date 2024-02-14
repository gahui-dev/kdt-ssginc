DESC NewCustomer;

CREATE TABLE NewCustomer(
    custid INT AUTO_INCREMENT PRIMARY KEY
	-- custid DECIMAL(65, 2) AUTO_INCREMENT PRIMARY KEY
   ,name VARCHAR(40)
   ,address VARCHAR(40)
   ,phone VARCHAR(30)
);

DROP TABLE NewCustomer;

SELECT * FROM NewCustomer;
INSERT INTO NewCustomer ( name ) VALUES ('가희');

SELECT * FROM book;

DESC book;
DESC Orders;

SELECT *
FROM
    INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE
    TABLE_SCHEMA = 'madang'
	AND TABLE_NAME = 'Customer';

-- Error Code: 1833. Cannot change column 'bookid': used in a foreign key constraint 'orders_ibfk_2' of table 'madang.Orders'
ALTER TABLE book MODIFY bookid INT AUTO_INCREMENT;

ALTER TABLE orders DROP FOREIGN KEY orders_ibfk_2;
ALTER TABLE book MODIFY bookid INT AUTO_INCREMENT;

# 질의 3-44 Book 테이블에 새로운 도서 ‘스포츠 의학’을 삽입하시오. 스포츠 의학은 한솔의학서적에서 출간했으며 가격은 90,000원이다.
INSERT INTO book( bookname, publisher, price ) VALUES ( '스포츠 의학' , '한솔의학서적', 90000 );

# 질의 3-45 Book 테이블에 새로운 도서 ‘스포츠 의학’을 삽입하시오. 스포츠 의학은 한솔의학서적에서 출간했으며 가격은 미정이다.
INSERT INTO book( bookname, publisher ) VALUES ( '스포츠 의학' , '한솔의학서적' );

ALTER TABLE orders ADD FOREIGN KEY (bookid) REFERENCES book(bookid);

DESC imported_book;
SELECT * FROM imported_book;

INSERT INTO book SELECT * FROM imported_book;
INSERT INTO book(bookid, bookname, publisher, price) VALUES (14, 'Soccer Skills', 'Human Kinetics', 15000);
INSERT INTO book(bookname, publisher, price) SELECT bookname, publisher, price FROM imported_book ;

SELECT * FROM book;

# UPDATE 기본 문법
/*
UPDATE [LOW_PRIORITY] [IGNORE] table_references
   SET assignment_list
[WHERE where_condition]
*/

SELECT * FROM Customer;

UPDATE Customer
   SET address = '대한민국 부산'
 WHERE custid = 5;
 
 UPDATE Customer
    SET phone = '000-9000-0000'
  WHERE custid = 5;
   
# TCL(Transaction Control Language) - COMMIT / ROLLBACK;
-- Connection이 여러개 있을 때,
-- 특정 connection에서 commit처리한 결과는 그 외 connection에서 commit을 하여야만 반영한 것을 볼 수 있음
-- SAVEPOINT 

# 자동 커밋 (autocommit) 해제
-- MySQLWorkbench -> Settings -> SQL Editor -> SQL Exceution -> New Connections use auto commit mode 해제
-- Query -> autocommit traction 해제

ROLLBACK;
COMMIT;

SELECT * FROM book;

UPDATE book
   SET publisher = (SELECT publisher FROM imported_book WHERE bookid = 21)
 WHERE bookid = 11;

UPDATE book
   SET publisher = '테스트'
 WHERE bookid = 24;

# 수동 트랜잭션
START TRANSACTION;

UPDATE book
   SET publisher = '테스트333'
 WHERE bookid = 24;
   
COMMIT;

# 질의 3-49 Book 테이블에서 도서번호가 11인 도서를 삭제하시오.
DELETE FROM book WHERE bookid = 11;

# 질의 3-50 모든 고객을 삭제하시오.

DELETE FROM book;
DESC book;

-- Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column. 
-- To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.
SET SQL_SAFE_UPDATES = 1;

-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`madang`.`orders`, CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`))
ALTER TABLE Orders DROP FOREIGN KEY orders_ibfk_2;
ALTER TABLE Orders ADD FOREIGN KEY (bookid) REFERENCES book(bookid) ON DELETE CASCADE;

DELETE FROM book;
SELECT * FROM book;