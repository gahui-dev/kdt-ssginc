# 1. 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
-- 1) 박지성이 구매한 도서의 출판사
-- 2) 그 출판사에서 도서를 구매한 고객의 이름

-- 1) 박지성이 구매한 도서의 출판사
SELECT *
  FROM Customer C
 INNER JOIN Orders O
    ON C.custid = O.custid
 INNER JOIN Book B
    ON B.bookid = O.bookid
 WHERE C.name = '박지성';

-- 2) (그 출판사에서) 도서를 구매한 고객의 이름
SELECT C.name
  FROM Customer AS C
 INNER JOIN Orders AS O
    ON C.custid = O.custid
 INNER JOIN Book AS B
    ON B.bookid = O.bookid
   AND C.name != '박지성'
 WHERE B.publisher IN (
		SELECT B.publisher
		  FROM Customer AS C
		 INNER JOIN Orders AS O
			ON C.custid = O.custid
		 INNER JOIN Book AS B
			ON B.bookid = O.bookid
		 WHERE C.name = '박지성'
	 );

SELECT DISTINCT C.*
  FROM customer AS C
 INNER JOIN orders AS O 
    ON C.custid = O.custid
 INNER JOIN book AS B 
    ON O.bookid = B.bookid
 INNER JOIN (SELECT DISTINCT B1.publisher
            FROM orders AS O1
              INNER JOIN book AS B1 
                 ON O1.bookid = B1.bookid
            INNER JOIN customer AS C1 
                 ON O1.custid = C1.custid
                -- AND C1.name = '박지성') AS pub
           WHERE C1.name = '박지성') AS pub
    ON B.publisher = pub.publisher
 WHERE C.name != '박지성';


SELECT name
  FROM Customer, Book, Orders
 WHERE Customer.custid = Orders.custid
   AND Orders.bookid = Book.bookid
   AND Customer.name NOT IN('박지성')
   AND Book.publisher IN (
	   SELECT publisher
         FROM Customer, Book, Orders
		WHERE Customer.custid = Orders.custid
          AND Orders.bookid = Book.bookid
          AND Customer.name = '박지성'
		);


# 2. 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
-- 1) 두 개 이상의 서로 다른 출판사
SELECT *
  FROM Customer C
 INNER JOIN Orders O
    ON C.custid = O.custid
 INNER JOIN Book B
    ON B.bookid = O.bookid
 ORDER BY C.custid;

SELECT C.name
  FROM Customer AS C
 INNER JOIN Orders AS O
    ON C.custid = O.custid
 INNER JOIN Book AS B
    ON B.bookid = O.bookid
 GROUP BY C.custid
HAVING COUNT(B.publisher) >= 2;
 
SELECT Customer.name
  FROM Customer, Book, Orders
 WHERE Customer.custid = Orders.custid
   AND Book.bookid = Orders.bookid
 GROUP BY Customer.name
HAVING COUNT(DISTINCT Publisher) >= 2;
 
# 3. 전체 고객의 30% 이상이 구매한 도서
-- 1) 전체 고객의 30% 이상
-- (SELECT COUNT(*) FROM Customer) * 0.3;

SELECT COUNT(*) FROM Customer;

SELECT Book.bookname
  FROM Book
 INNER JOIN Orders
    ON Book.bookid  = Orders.bookid
 GROUP BY Book.bookid
HAVING COUNT(*) >= (SELECT COUNT(*) FROM Customer) * 0.3;


# DML
SELECT * FROM Book;

SELECT *
FROM
    INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE
    TABLE_SCHEMA = 'madang'
	AND TABLE_NAME = 'Orders';

# 1. 새로운 도서('스포츠 세계', '대한 미디어', 10000원)이 마당서점에 입고되었음
INSERT INTO Book (bookname, publisher, price) VALUES ('스포츠 세계', '대한 미디어', 10000);

-- Error Code: 1364. Field 'bookid' doesn't have a default value
-- bookid가 없음 -> bookid AUTO_INCREAMENT 수정

ALTER TABLE Book MODIFY bookid INT AUTO_INCREMENT;

-- Error Code: 1833. Cannot change column 'bookid': used in a foreign key constraint 'orders_ibfk_2' of table 'madang.Orders'
-- madang.Orders 테이블의 외래키 제약조건 'orders_ibfk_2' 사용 -> 삭제

ALTER TABLE Orders DROP FOREIGN KEY orders_ibfk_2;

-- ALTER TABLE Orders ADD FOREIGN KEY (bookid) REFERENCES book(bookid) ON DELETE CASCADE;

# 2. '삼성당'에서 출판한 도서를 삭제해야 함
DELETE FROM Book WHERE publisher = '삼성당';

-- Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column. 
-- To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.
-- 안전 업데이트 모드를 사용 중 -> SQL_SAFE_UPDATES = 0

SET SQL_SAFE_UPDATES = 0;

# 3. '이상미디어'에서 출판한 도서를 삭제해야함. 삭제가 안될 경우 원인 찾기
DELETE FROM Book WHERE publisher = '이상미디어';

# 4. 출판사 '대한미디어'가 대한출판사'로 이름을 바꾸었음 
UPDATE Book SET publisher = '대한출판사' WHERE publisher = '대한미디어';