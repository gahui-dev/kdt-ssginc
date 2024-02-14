# (1)
SELECT *
  FROM Mybook;

# (2)
SELECT bookid, IFNULL(price, 0)
  FROM Mybook;

# (3)
SELECT *
  FROM Mybook 
 WHERE price IS NULL;

# (4)
SELECT *
  FROM Mybook
 WHERE price = ' ';
 
# (5)
SELECT bookid, price + 100
  FROM Mybook;
  
# (6)
SELECT SUM(price), AVG(price), COUNT(*)
  FROM Mybook
 WHERE bookid >= 4;

# (7)
SELECT COUNT(*), COUNT(price)
  FROM Mybook;
  
# (8)
SELECT SUM(price), AVG(price)
  FROM Mybook;
  
# (1)
SELECT *
  FROM book;
  
# (2)
SELECT *
	 , @RNUM := @RNUM + 1 AS ROWNUM
  FROM Book, (SELECT @RNUM := 0) R
 WHERE @RNUM < 5;
 
 
 -- SELECT *, (SELECT *, @ROWNUM := @ROWNUM + 1 AS RNUM)
 SELECT *
  FROM (
	SELECT *, (SELECT @ROWNUM := @ROWNUM + 1
				 FROM (SELECT @ROWNUM := 0 FROM dual) AS rownum
			) AS RNUM
	  FROM book
      ) A
  ;
 
  SET @RNUM := 0;
SELECT *, @RNUM
 := @RNUM + 1 AS ROWNUM
FROM book
WHERE @RNUM < 5
;

# (3) 변수에 관한 테이블의 우선순위가 떨어짐(ORDER BY 만나면)
SELECT *
     , @RNUM := @RNUM + 1 AS ROWNUM
  FROM Book, (SELECT @RNUM := 1 ) R
 WHERE @RNUM <= 5
 ORDER BY price;
 
 SELECT *
     , @RNUM := @RNUM + 1 AS ROWNUM
  FROM Book, (SELECT @RNUM := 1 ) R
 WHERE price <= 8000
 ORDER BY price DESC;

SELECT * 
  FROM (SELECT bookid
              ,bookname
              ,publisher
              ,price
              ,(@RNUM := @RNUM + 1) - 1 AS ROWNUM 
          FROM Book, (SELECT @RNUM := 1 ) AS R
         WHERE @RNUM <= 5) AS T
  ORDER BY price;
 
# (4)
SELECT *
	 , @RNUM := @RNUM + 1 AS ROWNUM
  FROM (SELECT * FROM Book ORDER BY price) B,
	   (SELECT @RNUM := 0) R
 WHERE @RNUM < 5;
        
        
# (5)
SELECT *
	 , @RNUM := @RNUM + 1 AS ROWNUM
  FROM (SELECT * FROM Book WHERE @RNUM <= 5) b,
	   (SELECT @RNUM := 0) R
 ORDER BY price;
	

# (6)
SELECT *
	 , @RNUM := @RNUM + 1 AS ROWNUM
  FROM (SELECT * FROM Book WHERE @RNUM <= 5 ORDER BY price) B,
	   (SELECT @RNUM := 0) R;
        

SELECT @ROWNUM := @ROWNUM + 1
  FROM (SELECT @ROWNUM := 0 FROM dual) A;


SELECT *, (SELECT *, @ROWNUM := @ROWNUM + 1 AS RNUM)
   
 