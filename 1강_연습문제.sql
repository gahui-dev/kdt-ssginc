show databases;
use madang;
show tables;
desc customer;
select * from customer;

select phone from customer where name = "김연아";

-- select (projection) fron 테이블명 where (selection)

use madang;
show tables;
DESC book;

SELECT bookname, publisher
	FROM book
    WHERE price >= 10000;
    
SELECT bookname, price 
	FROM book;
    
show tables;
desc book;

SELECT bookid, bookname, publisher, price
	FROM book;
    
SELECT publisher FROM book;
SELECT DISTINCT publisher FROM book;

SELECT *
	FROM book
    WHERE price < 20000;
    
SELECT *
	FROM book
    WHERE price >= 10000 AND price <= 20000;
    
SELECT *
	FROM book
    WHERE price BETWEEN 10000 AND 20000;
    
SELECT *
	FROM book
    WHERE publisher = "굿스포츠" OR publisher = "대한미디어";
    
SELECT *
	FROM book
    WHERE NOT (publisher = "굿스포츠" OR publisher = "대한미디어");
    
SELECT *
	FROM book
    WHERE publisher IN ("굿스포츠", "대한미디어");

SELECT *
	FROM book
    WHERE publisher NOT IN ("굿스포츠", "대한미디어");
    
SELECT bookname, publisher
	FROM book
    WHERE bookname LIKE '축구의 역사';
    
SELECT bookname, publisher
	FROM book
    WHERE bookname LIKE '%축구%';

    
SELECT * FROM book;
-- 문제 출처 : 이가희
-- 문제 : book 테이블에서 출판사 이름에 '미디어'가 포함되고 가격이 '10000원' 이상인 book을 검색하세요

SELECT *
	FROM book
    WHERE publisher LIKE '%미디어%' AND price >= 10000;

-- 출제자 : 김정림
-- 문제 : 도서가격이 7,000원, 13,000원, 20,000원인 도서이름과 출판사를 검색하시오.
SELECT bookname, publisher
	FROM book
    WHERE price IN (7000, 13000, 20000);

-- 문제 출처 : 오승원
-- 문제 : 주소지가 대한민국인 고객을 검색하시오.
show tables;
SELECT *
	FROM customer
    WHERE address LIKE '대한민국%';

-- 이선교 출제
-- '대한미디어' 출판사에서 출간한 책 이름, 가격들을 가격이 낮은 순으로 출력하시오.
SELECT bookname, price
	FROM book
    WHERE publisher = '대한미디어'
    ORDER BY price ASC;

-- 문제 출처 : 김은영
-- 문제 : 가격이 2만원 이상이며 축구라는 단어가 들어간 도서를 검색하시오
SELECT *
	FROM book
    WHERE price >= 20000 AND bookname LIKE '%축구%';

-- 문제 출처 : 양명진
-- 문제 20000원 미만의 축구를 제외한 단어가 들어가는 책이름과 가격을 검색하시오
SELECT bookname, price
	FROM book
    WHERE price < 20000 AND bookname NOT LIKE '%축구%';

-- 문제출처 : 김효범
-- 'Olympic Champions'의 가격을 검색하시오
SELECT price
	FROM book
    WHERE bookname = 'Olympic Champions';

-- 문제 출처 : 권동혁
-- 문제 : 도서들 중 도서의 글자수가 4글자인 도서
SELECT *
	FROM book
	WHERE CHAR_LENGTH(bookname) = 4;
    
SELECT *
	FROM book
    WHERE bookname LIKE '_구%';
    
SELECT *
	FROM book
    WHERE price >= 20000;
    
-- ASC(기본)	오름차순(ascending)
-- DESC 	내림차순(descending)

SELECT *
	FROM book
    ORDER BY bookname ASC;
    
SELECT *
	FROM book
    ORDER BY price ASC, bookname ASC;

-- 도서를 가격의 내림차순으로 검색
-- 가격이 같다면 출판사의 오름차순으로 검색
SELECT *
	FROM book
    ORDER BY price DESC, publisher ASC;
    
-- 고객이 주문한 도서의 총 판매액 구하기
SELECT SUM(price) AS 'SUM(saleprice)'
	FROM book;
    
SHOW TABLES;
DESC customer;
DESC orders;

SELECT * FROM orders;

SELECT SUM(saleprice) AS '총매출'
	FROM orders;
    
SELECT DISTINCT bookid
	FROM orders;

-- 고객이 주문한 도서의 총 판매액, 평균값, 최저가, 최고가 구하기
SELECT SUM(saleprice) AS 'TOTAL',
	   AVG(saleprice) AS 'Average',
       MIN(saleprice) AS 'Minimum',
       MAX(saleprice) AS 'Maximum'
	FROM orders;
    
-- 마당서점의 도서 판매 건수 구하기
SELECT * FROM orders;

SELECT COUNT(*)
	FROM orders;

SELECT COUNT(orderid) AS '판매건수'
	FROM orders;

SELECT 0, 1 FROM orders;    

SELECT * FROM orders; 

-- 총 도서수량과 총 판매액

SELECT custid,
	   COUNT(*) AS '도서수량',
       SUM(saleprice) AS '총액'
	FROM orders
    GROUP BY custid;
    
SELECT bookid,
	   COUNT(*) AS '판매수량',
       SUM(saleprice) AS '총액'
	FROM orders
    GROUP BY bookid
    HAVING bookid IN(8, 10);
    
-- 가격이 8,0000원 이상인 도서를 구매한 고객에 대하여
-- 고객별 주문 도서의 총 수량을 구하기
-- 단, 두 권 이상 구매한 고객만 구하기

SELECT * FROM orders; 

SELECT custid,
	   COUNT(*) AS '도서수량'
	FROM orders
    WHERE saleprice >= 8000
    GROUP BY custid
	HAVING COUNT(*) >= 2;
    -- HAVING 도서수량 >= 2;
    
-- 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

SHOW TABLES;
DESC book;
SELECT * FROM book;
-- (1) 도서번호가 1인 도서의 이름
SELECT bookname
	FROM book
    WHERE bookid = 1;

-- (2) 가격이 20,000원 이상인 도서의 이름
SELECT bookname
	FROM book
    WHERE price >= 20000;

-- (3) 박지성의 총 구매액(박지성의 고객번호는 1번으로 놓고 작성)
DESC orders;
SELECT * FROM orders;
SELECT SUM(saleprice)
	FROM orders
    WHERE custid = 1;

-- (4) 박지성이 구매한 도서의 수(박지성의 고객번호는 1번으로 놓고 작성)
SELECT COUNT(*)
	FROM orders
    WHERE custid = 1;

-- 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
-- (1) 마당서점 도서의 총 개수
SELECT COUNT(*)
	FROM book;

-- (2) 마당서점에 도서를 출고하는 출판사의 총 개수
SELECT * FROM book;
SELECT COUNT(DISTINCT publisher)
	FROM book;
    
-- (3) 모든 고객의 이름, 주소
SELECT * FROM customer;
SELECT name, address
	FROM customer;
	
-- (4) 2014년 7월 4일~7월 7일 사이에 주문 받은 도서의 주문번호
SELECT * FROM orders;
SELECT *
	FROM orders
    WHERE orderdate BETWEEN "2014-07-04" AND "2014-07-07";

-- (5) 2014년 7월 4일~7월 7일 사이에 주문 받은 도서를 제외한 도서의 주문번호
SELECT *
	FROM orders
    WHERE orderdate NOT BETWEEN "2014-07-04" AND "2014-07-07";

-- (6) 성이 ‘김’ 씨인 고객의 이름과 주소
SELECT * FROM customer;

SELECT name, address
	FROM customer
    WHERE name LIKE '김%';

-- (7) 성이 ‘김’ 씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
SELECT name, address
	FROM customer
    WHERE name LIKE '김%아';