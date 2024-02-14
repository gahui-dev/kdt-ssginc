# NULL 값 처리

SELECT * FROM Customer;
SELECT * FROM Orders;

SELECT Customer.custid, name, avg(saleprice) AS AvgPrice
  FROM Customer
  LEFT OUTER JOIN Orders
    ON Customer.custid = Orders.custid
 GROUP BY custid;

SELECT AVG(A.avgprice) -- null 제외시킴
, SUM(A.avgprice)/COUNT(A.avgprice) -- null 제외시킴
, (SELECT AVG(avgprice) FROM(
select 0 avgprice
from customer
LEFT OUTER JOIN orders
ON customer.custid = orders.custid
GROUP BY customer.custid, name
HAVING AVG(saleprice) IS NULL
UNION
select AVG(saleprice) avgprice
from customer
LEFT OUTER JOIN orders
ON customer.custid = orders.custid
GROUP BY customer.custid, name
HAVING AVG(saleprice) IS NOT NULL
) B -- null 카운팅 하려면?
) AVGNULL카운팅
, SUM(A.avgprice)/COUNT(*) -- null도 카운팅
FROM (
select customer.custid, name, AVG(saleprice) avgprice
from customer
LEFT OUTER JOIN orders
ON customer.custid = orders.custid
GROUP BY customer.custid, name
) A
;

SELECT AVG(A.avgprice) -- null 제외시킴
, SUM(A.avgprice)/COUNT(A.avgprice) -- null 제외시킴
, AVG(IFNULL(A.price, 0))
, SUM(A.avgprice)/COUNT(*) -- null도 카운팅
FROM (
select customer.custid, name, AVG(saleprice) avgprice
from customer
LEFT OUTER JOIN orders
ON customer.custid = orders.custid
GROUP BY customer.custid, name
) A
;

SELECT *
  FROM mybook;

SELECT bookid, price + 100
  FROM mybook;
  
SELECT SUM(price), AVG(price), COUNT(*), COUNT(price)
  FROM Mybook;
  
SELECT *
  FROM Mybook
WHERE price is NULL;

SELECT *
  FROM Mybook
 WHERE price = '';
 
# IFNULL(속성, 대처값)
-- 속성 값이 NULL 이면 '대처값'으로 대치

SELECT name, IFNULL(phone, '연락처없음')
  FROM Customer;


# MySQL 
  
SET @seq:=0;

SELECT (@seq := @seq+1) '순번', custid, name,phone
  FROM Customer
WHERE @seq < 2;

SELECT @seq := @seq + 1
	 , custid
     , name
 FROM Customer
WHERE @seq < 3;
