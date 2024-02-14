# CASE - WHEN -> IF ELSE, SWITCH
# https://dev.mysql.com/doc/refman/8.0/en/case.html

-- 기본 문법
/*
CASE case_value
    WHEN when_value THEN statement_list
    [WHEN when_value THEN statement_list] ...
    [ELSE statement_list]
END CASE
*/
/*
CASE
    WHEN search_condition THEN statement_list
    [WHEN search_condition THEN statement_list] ...
    [ELSE statement_list]
END CASE
*/

SELECT (
	CASE 1
		WHEN 1 THEN '남성'
        WHEN 2 THEN '여성'
	END) AS '안내방송'
FROM dual;

SELECT (
	CASE 2
		WHEN 1 THEN '남성'
        ELSE '여성'
	END) AS '안내방송'
FROM dual;



SELECT name
      ,SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
      ,SUBSTR(address, (INSTR(address, ' ')) +1) AS '지역'
      ,CONCAT(name, '님 남탕으로 가세요.')
  FROM customer
 WHERE SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 1
 UNION
 SELECT name
      ,SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
	  ,SUBSTR(address, (INSTR(address, ' ')) +1) AS '지역'
      ,CONCAT(name, '님 여탕으로 가세요.')
  FROM customer
 WHERE SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 2;
 
 
 
 SELECT name AS '이름'
	  , SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
      , SUBSTR(address, (INSTR(address, ' ')) +1) AS '지역'
      , CASE 
		-- 성별 1 이면 남자
        WHEN SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 1
			THEN CONCAT(SUBSTR(address, (INSTR(address, ' ')) +1), '에서 오신 ', name, '님 남탕으로 가세요.') 
		-- 성별 2 이면 여자
        WHEN SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 2
			THEN CONCAT(SUBSTR(address, (INSTR(address, ' ')) +1), '에서 오신 ', name, '님 여탕으로 가세요.')
        END AS '안내방송'
   FROM customer;
 
 SELECT name AS '이름'
	  , SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
      , SUBSTR(address, (INSTR(address, ' ')) +1) AS '지역'
      , CASE 
		-- 성별 1 이면 남자
        WHEN SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 1
			THEN CONCAT(SUBSTR(address, (INSTR(address, ' ')) +1), '에서 오신 ', name, '님 남탕으로 가세요.') 
		-- 성별 2 이면 여자
        ELSE CONCAT(SUBSTR(address, (INSTR(address, ' ')) +1), '에서 오신 ', name, '님 여탕으로 가세요.')
        END AS '안내방송'
   FROM customer;
   
   SELECT * FROM book;
   
   SELECT bookname
		, price
        , CASE
		  WHEN price >= 10000 THEN '평균보다 비쌉니다'
          ELSE '평균보다 쌉니다'
          END AS '가격'
	FROM book;
		
# price <=8000 이하면 가성비 좋네
# price > 8000 비싸네

# 2번째 확장
# 3만원대, 골프서적은 -> 대한미디어의 골프서적이면 절대 안사~
# 2만원대 일때, 축구서적이면 -> 2만원대 축구서적으로 가성비 좋은편
# 2만원대, 야구, 골프 서적이면 -> 2만원 야구,Olympic 이건아니지.
# 1만원대, 야구, 축구 서적이면 -> 1만원 축구, 야구 서적 줍줍 !
# 1만원대, 나머지 -> 안사~!      
  
SELECT *
  FROM book
 ORDER BY price DESC;
  
SELECT bookname
	 , publisher
     , price
     , CASE
       WHEN price >= 10000 AND price < 20000
		THEN (
			CASE 
            -- WHEN bookname LIKE '%야구%' OR bookname LIKE '%축구%'
            WHEN bookname REGEXP '야구|축구'
            THEN '축구, 야구 서적 줍줍 !'
            ELSE '안사'
            END
        )
	    WHEN price >= 20000 AND price < 30000
 		 THEN (
			CASE
            -- WHEN bookname LIKE '%축구%'
			WHEN bookname REGEXP '축구'
            THEN '축구서적으로 가성비 좋은편'
			-- WHEN bookname LIKE '%야구%' OR bookname LIKE '%골프%'
            WHEN bookname REGEXP '야구|골프'
            THEN '야구,Olympic 이건아니지'
			END
        )
		WHEN price >= 30000
		 THEN (
			CASE
            WHEN bookname LIKE '%골프%' AND publisher = '대한미디어'
			 THEN '대한미디어의 골프서적이면 절대 안사~'
			END
         )
	   ELSE '안사'
       END AS '안내'
  FROM book
 ORDER BY price DESC;

SELECT bookname
	 , publisher
     , price
     , CASE 
       WHEN price >= 30000 AND publisher = '대한미디어' AND bookname LIKE '%골프%'
		THEN '대한미디어의 골프서적이면 절대 안사~'
	   WHEN price >= 20000 AND bookname LIKE '%축구%'
		THEN '축구서적으로 가성비 좋은편'
	   WHEN price >= 20000 AND (bookname LIKE '%야구%' OR bookname LIKE '%골프%')
		THEN '야구,Olympic 이건아니지'
	   WHEN price >= 10000 AND (bookname LIKE '%야구%' OR bookname LIKE '%축구%')
		THEN '축구, 야구 서적 줍줍 !'
       ELSE '안사'
       END AS '안내'
  FROM book
 ORDER BY price DESC;
 
## 사용자정의 함수
/*
CREATE FUNCTION function_name ([parameter1 datatype1, parameter2 datatype2, ...])
RETURNS return_datatype
[DETERMINISTIC]
BEGIN
-- 함수 로직 및 계산식 등을 작성합니다.
-- RETURN 문으로 결과값을 반환합니다.
END;
*/

SELECT bookname
	 , publisher
     , price
     , comment4Cost(price, bookname, publisher) AS '안내'
  FROM book
 ORDER BY price DESC;

CREATE FUNCTION comment4Cost (price INT, bookname varchar(40), publisher varchar(40))
	RETURNS VARCHAR(60)
	DETERMINISTIC
	RETURN CASE
			WHEN price >= 30000 AND publisher = '대한미디어' AND bookname LIKE '%골프%'
				THEN '대한미디어의 골프서적이면 절대 안사~'
			WHEN price >= 20000 AND bookname LIKE '%축구%'
				THEN '축구서적으로 가성비 좋은편'
			WHEN price >= 20000 AND (bookname LIKE '%야구%' OR bookname LIKE '%골프%')
				THEN '야구,Olympic 이건아니지'
			WHEN price >= 10000 AND (bookname LIKE '%야구%' OR bookname LIKE '%축구%')
				THEN '축구, 야구 서적 줍줍 !'
		  ELSE '안사'
		   END
;

SELECT name, AVG(IFNULL2(orders.saleprice, 0))
  FROM customer
  LEFT OUTER JOIN orders
    ON customer.custid = orders.custid
 GROUP BY name;
 
 
 CREATE FUNCTION IFNULL2 (price INT, tradeOff INT) 
	RETURNS INT
    DETERMINISTIC
    RETURN CASE price
			WHEN price IS NULL
				THEN tradeOff
			ELSE price
		     END
;

# 2번째 정의
/*
CREATE FUNCTION function_name ([parameter1 datatype1, parameter2 datatype2, ...])
RETURNS return_datatype
[DETERMINISTIC]
RETURN return_variable
*/

# [질의 4-12] 마당서점의 고객별 판매액을 보이시오(고객이름과 고객별 판매액을 출력).
# 스칼라쿼리 - 단일 행, SELECT() 문

SELECT (SELECT name FROM Customer WHERE custid = O.custid) AS '고객이름' 
	 , SUM(saleprice) AS '판매액'
  FROM Orders AS O
 GROUP BY custid;

SELECT name, SUM(orders.saleprice)
  FROM orders, customer
 WHERE orders.custid = customer.custid
 GROUP BY orders.custid;
 
 # [질의 4-12] Orders 테이블에 각 주문에 맞는 도서이름을 입력하시오
 
 SELECT O.* 
	  , (SELECT bookname FROM Book Where bookid = O.bookid) AS '도서이름'
   FROM Orders AS O;
 
 DESC book;
 
 ALTER TABLE orders ADD bookname varchar(40);
 DESC orders;
 SELECT * FROM orders;
 
 UPDATE orders AS A
	SET bookname = ( SELECT bookname
					   FROM Book
					  WHERE bookid = A.bookid);
					
SET SQL_SAFE_UPDATES = 1;                    
UPDATE orders A
   SET bookname = ( SELECT bookname FROM book WHERE bookid = A.bookid);

 # 인라인 뷰 - FROM 부질의
 -- FROM 절에서 사용되는 부속질의
 -- 테이블 이름 대신 인라인 뷰 부속질의를 사용하면 보통의 테이블과 같은 형태로 사용
 -- 부속질의 결과 반환되는 데이터는 다중 행, 다중 열이어도 상관없음
 -- 다만 가상의 테이블인 뷰 형태로 제공되어 상관 부속질의로 사용될 수 없음
 
# [질의 4-14] 고객번호가 2 이하인 고객의 판매액을 보이시오(고객이름과 고객별 판매액 출력).

SELECT * FROM customer;

SELECT customer.name AS '고객이름'
     , SUM(saleprice) AS '판매액'
  FROM Orders
     , (SELECT custid, name FROM customer WHERE custid <= 2) AS Customer
  WHERE orders.custid = customer.custid
  GROUP BY Orders.custid
  ;
  
SELECT * FROM orders;
# WHERE 문에 적는 중첩질의
# [질의 4-15] 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
SELECT orderid, saleprice
  FROM Orders
 WHERE saleprice <= ( SELECT AVG(saleprice)
						FROM orders);


# [질의 4-16] 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
SELECT orderid, custid, saleprice
  FROM Orders AS O1
 WHERE saleprice > ( SELECT AVG(saleprice)
					   FROM Orders AS O2
					  WHERE O1.custid = O2.custid);
                      
-- SELECT orderid, custid, saleprice
--   FROM Orders
--  WHERE saleprice > ( SELECT AVG(saleprice)
-- 					   FROM orders
-- 					  GROUP BY custid );
--                       
-- SELECT custid, saleprice FROM Orders;					
--                       
-- SELECT custid, AVG(saleprice)
--   FROM orders
--  GROUP BY custid;

# [질의 4-17] 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오.
SELECT SUM(saleprice) AS 'total'
  FROM orders 
 WHERE custid IN ( SELECT custid FROM customer WHERE address LIKE '%대한민국%');
 
 
 # (1)
 
 SELECT custid, (SELECT address
				   FROM Customer cs
				  WHERE cs.custid = od.custid) AS 'address',
						SUM(saleprice) AS 'total'
   FROM Orders od
  GROUP BY od.custid;
				)
