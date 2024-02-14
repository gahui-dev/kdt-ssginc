show  databases;
select database();
show tables;

select current_user();  -- madang@%

DESC customer;
DESC orders;
DESC book;

/*
-- 고객 테이블
custid (v)
name
address
phone

-- 주문 테이블
orderid
custid (v) -- 고객에게 판매한 내용
bookid
saleprice
orderdate
*/

SELECT * FROM customer;
SELECT * FROM book;
SELECT * FROM orders;

SELECT *
	FROM customer, orders
    WHERE name= '박지성';

SELECT *
	FROM customer, orders
    WHERE customer.custid = orders.custid;


# 누가 어떤 책(id)를 언제 얼마에 구매했는가
SELECT B.orderid, B.custid, A.name, B.bookid, B.orderdate, B.saleprice
	FROM customer A, orders B
    WHERE A.custid = B.custid
    ORDER BY A.custid;
    
# 고객의 이름과 고객이 주문한 도서의 판매가격을 검색하시오
SELECT customer.name, orders.saleprice
	FROM customer, orders
	WHERE customer.custid = orders.custid;
    
# 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객별로 정렬
SELECT customer.name AS name
	  ,SUM(orders.saleprice) AS '총 판매액'
	FROM customer, orders
	WHERE customer.custid = orders.custid
	-- GROUP BY name
    GROUP BY customer.custid
    ORDER BY customer.name;

select * FROM book;
SELECT * FROM orders;

# 고객의 이름과 도서의 이름을 구하시오
SELECT customer.name
	  ,book.bookname
	FROM orders, customer, book
    WHERE orders.bookid = book.bookid
		AND orders.custid = customer.custid;
    -- ORDER BY customer.name, book.bookid;
    
# 가격이 20000원인 도서를 주문한 고객의 이름과 도서의 이름
-- count (10)
SELECT A.name
	  ,B.bookname
	FROM ( SELECT orders.*, customer.name
				FROM orders, customer
                WHERE orders.custid = customer.custid) A
		, book B
        WHERE A.bookid = B.bookid;

# 가격이 20000원인 도서를 주문한 고객의 이름과 도서의 이름
-- count (1)
SELECT B.name
	  ,A.bookname
	FROM ( SELECT A.*, B.bookname
				FROM orders A, book B
                WHERE A.bookid = B.bookid
					AND B.price = 20000) A
		, customer B
        WHERE A.custid = B.custid;
        
SELECT B.name
	  ,A.bookname
	FROM ( SELECT A.*, B.bookname
				FROM orders A, book B
                WHERE B.price = 20000
					AND A.bookid = B.bookid ) A
		, customer B;

SELECT customer.name, saleprice
	FROM customer
		LEFT OUTER JOIN orders
		ON customer.custid = orders.custid;
        
SELECT customer.name
	  ,SUM(saleprice) AS "총 금액"
      ,COUNT(saleprice) AS "구매건수"
	FROM customer
		LEFT OUTER JOIN orders
		ON customer.custid = orders.custid
	GROUP BY name;

-- 외부 조인
-- SELECT <속성들>
-- FROM 테이블1 {LEFT | RIGHT | FULL[OUTER]| JOIN
-- 		테이블2 ON 

# 가장 비싼 도서의 이름을 보이시오
-- bookname 골프 바이들

SELECT * FROM book;

SELECT MAX(price) AS price
		FROM book;

SELECT bookname
	FROM book A, (SELECT MAX(price) AS price
		FROM book) B
	WHERE A.price = B.price;
    
SELECT bookname
	FROM book A, (SELECT MAX(price) AS price
		FROM book) B
	WHERE A.price = B.price;
    
 SELECT bookname
	FROM book A
    WHERE A.price = (SELECT MAX(price) AS price
		FROM book);


SELECT * FROM orders;
SELECT * FROM customer;
SELECT * FROM book;
SELECT custid FROM orders GROUP BY custid;

# 도서를 구매한 적이 있는 고객의 이름
SELECT name
	FROM customer A
		,(SELECT custid FROM orders GROUP BY custid) B
    WHERE A.custid = B.custid;
    
# 대한미디어에서 출판한 도서를 구매한 고객의 이름
SELECT * FROM book WHERE publisher = '대한미디어';

SELECT name
	FROM customer
    WHERE custid IN(SELECT custid
						FROM orders
						WHERE bookid 
						IN(SELECT bookid
							FROM book
							WHERE publisher = '대한미디어'));
                            
# 출판사별로 출판사의 평균 도서 가격보다 비싼 도서
# 골프 바이블, 피겨 교본, 야구의 추억
SELECT * FROM book;

SELECT AVG(price)
	FROM book;

SELECT B.bookname
	FROM book B
    WHERE B.price >
		(SELECT AVG(A.price)
			FROM book A
			WHERE A.publisher = B.publisher);
            
SELECT *
  FROM book A
WHERE A.price > ( SELECT AVG(price)
				    FROM book
                    WHERE publisher = A.publisher
                 );

# 대한민국에서 거주하는 고객의 이름과 도서를 주문한 고객의 이름
SELECT B.bookname
	  ,(SELECT COUNT(price)
			FROM book C
			WHERE C.publisher = B.publisher) cnt
	  ,B.publisher
	FROM book B
    WHERE B.price >
		(SELECT AVG(A.price)
			FROM book A
			WHERE A.publisher = B.publisher);

-- 집합 연산
-- 합집합 UNION, 차집합 MINUS, 교집합 INTERSECT
-- mysql은 MINUS, INTERSECT을 지원하지 않음

# 대한민국에서 거주하는 고객의 이름과 도서를 주문한 고객의 이름
# (고객 이름) = (대한민국에서 거주하는 고객 이름) U (도서를 주문한 고객 이름)

# UNION ALL, UNION - 중복 제거

SELECT * FROM customer;

SELECT name
	FROM customer
    WHERE address LIKE "%대한민국%"
UNION
SELECT name
  FROM customer
 WHERE customer.custid IN(SELECT DISTINCT custid FROM orders);

# [질의 3-32]에서 MINUS 연산을 수행한
# “대한민국에서 거주하는 고객의 이름에서 도서를 주문한 고객의 이름 빼고 보이시오.”
# 질의를 NOT IN 연산자를 사용하면 다음과 같다.

-- SELECT name
-- 	FROM customer
--     WHERE address LIKE "%대한민국%"
-- MINUS
-- SELECT name
-- 	FROM customer
--     WHERE customer.custid IN(SELECT DISTINCT custid FROM orders);

# {김연아, 장미란, 박세리} - {박지성, 김연아, 장미란, 추신수}
SELECT name
	FROM customer
    WHERE address LIKE "%대한민국%"
    AND name NOT IN (
		 SELECT name
			FROM customer
			WHERE customer.custid IN(SELECT DISTINCT custid FROM orders)
		);
	
# [질의 3-32]에서 INTERSECT 연산을 수행한 “대한민국에서 거주하는 고객 중 도서를 주문한 고객의 이름 보이시오.”
# 질의를 IN 연산자를 사용하면 다음과 같다.
SELECT name
	FROM customer
    WHERE address LIKE "%대한민국%"
    AND name IN (
		 SELECT name
			FROM customer
			WHERE customer.custid IN(SELECT DISTINCT custid FROM orders)
		);

# 질의 3-33 주문이 있는 고객의 이름과 주소를 보이시오.
SELECT name, address
	FROM Customer cs
	WHERE EXISTS (SELECT *
					FROM Orders od
					WHERE cs.custid =od.custid);
                    

SELECT * FROM book;
SELECT * FROM orders;
SELECT * FROM customer;

# 5. 박지성이 구매한 도서의 출판사 수
SELECT COUNT(DISTINCT publisher)
	FROM book
    WHERE bookid IN (
		SELECT bookid
        FROM orders
        WHERE custid IN (
			SELECT custid
            FROM customer
            WHERE name = "박지성"));

SELECT COUNT(DISTINCT publisher)
  FROM book AS B
 INNER JOIN orders AS O
	ON B.bookid = O.bookid
 INNER JOIN customer AS C
	ON O.custid = C.custid
   AND C.name = '박지성';

# 6. 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
SELECT B.bookname, B.price, O.saleprice, B.price - O.saleprice AS '정가와 판매가격 차이'
	FROM book B
		JOIN orders O
        ON B.bookid = O.bookid
    WHERE B.bookid IN (
			SELECT custid
            FROM customer
            WHERE name = "박지성");

# 7. 박지성이 구매하지 않은 도서의 이름
SELECT *
	FROM customer
	WHERE name = "박지성";
    
SELECT DISTINCT bookname
	FROM book B
		JOIN orders O
        ON B.bookid = O.bookid
	WHERE O.bookid NOT IN(
    SELECT custid
            FROM customer
            WHERE name = "박지성");

# 8. 주문하지 않은 고객의 이름
SELECT name
	FROM customer
    WHERE custid NOT IN (SELECT custid FROM orders);

# 9. 주문 금액의 총액과 주문의 평균 금액
SELECT SUM(saleprice) AS '주문 금액의 총액'
	  ,AVG(saleprice) AS '주문의 평균 금액'
	FROM orders;

# 10. 고객의 이름과 고객별 구매액
SELECT name, SUM(saleprice)
	FROM customer AS C
		INNER JOIN orders AS O
        ON C.custid = O.custid
	GROUP BY C.custid;

# 11. 고객의 이름과 고객이 구매한 도서 목록
SELECT C.name, B.bookname
	FROM orders AS O
		INNER JOIN customer AS C
		ON O.custid = C.custid
		INNER JOIN book AS B
		ON O.bookid = B.bookid;
    
# (?) 12. 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
SELECT O.*, B.*, B.price - O.saleprice
	FROM orders AS O
    JOIN book AS B
    ON O.bookid = B.bookid
ORDER BY B.price - O.saleprice DESC
LIMIT 1;

SELECT price - saleprice, book.*
	FROM book
    JOIN orders 
    ON book.bookid = orders.bookid
WHERE price - saleprice = (
	SELECT MAX(price - saleprice)
    FROM book
		JOIN orders
        ON book.bookid = orders.bookid
);

# (?) 13. 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
SELECT C.NAME, AVG(O.saleprice) AS '자신의 구매액 평균', AVG(B.PRICE) AS '도서의 판매액 평균'
	FROM customer C, orders O, book B
        WHERE C.custid = O.custid
        GROUP BY C.name
        HAVING AVG(O.saleprice) < AVG(B.price);

-- 도서의 판매액 평균
SELECT AVG(saleprice) FROM orders;
        
        
