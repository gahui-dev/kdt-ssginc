# SQL 함수
-- DBMS가 제공하는 내장 함수(built-in function)
-- 사용자가 필요에 따라 직접 만드는 사용자 정의함수(user-defined function)

# MySQL 내장 함수
-- 단일행 함수(숫자, 문자(문자/숫자 반환), 날짜시간, 변환, 정보, NULL 관련 함수)
-- 집계 함수(AVG, COUNT, MAX, MIN, STD, STDDEV, SUM)
-- 윈도우 함수

# 숫자 함수
/* 
ABS(숫자) - 절댓값
CEIL(숫자) - 숫자보다 크거나 같은 최소 정수
FLOOR(숫자) - 숫자보다 작거나 같은 최소 정수
ROUND(숫자, m) - 숫자의 반올림, m은 반올림 기준 자릿수
LOG(n, 숫자) - 숫자의 자연로그 값 반환
POWER(숫자, n) - 숫자의 n 제곱 값 계산
SQRT(숫자) - 숫자의 제곱근 값 계산(숫자 양수)
SIGN(숫자) - 숫자 음수: -1 / 양수 : 1
TRUNCATE
*/

SELECT 10 FROM dual;
SELECT 10 + 3 FROM dual;
SELECT 10 + 3 AS total FROM dual;

# [질의 4-1] -78과 +78의 절댓값을 구하시오.
SELECT ABS(-78), ABS(+78) FROM dual;

# [질의 4-2] 4.875를 소수 첫째 자리까지 반올림한 값을 구하시오.
SELECT ROUND(4.875, 1) FROM dual;

# [질의 4-3] 고객별 평균 주문 금액을 백 원 단위로 반올림한 값을 구하시오.
SELECT custid AS 고객번호
	  ,ROUND(AVG(saleprice), -2) AS 평균금액
  FROM orders
 GROUP BY custid;

SELECT CEIL(4.1), FLOOR(4.1), POWER(2, 3), FLOOR(RAND() * 10) FROM dual;

# 문자 함수(문자 반환/숫자 반환), 날짜 시간 함수, 변환 함수, 정보 함수, NULL 관련함수)
# 문자값 반환 함수 (s: 문자열 / c: 문자 / n: 정수 / k: 정수)
/*
CONCAT(s1, s2) - 두 문자열 연결
UPPER(s) - 대상 문자열을 모두 대문자로 변환
LOWER(s) - 대상 문자열을 모두 소문자로 변환
LPAD(s, n, c) - 대상 문자열을 왼쪽부터 지정한 자리수까지 지정한 문자로 채움
RPAD(s, n, c) - 대상 문자열의 오른쪽부터 지정한 자리수까지 지정한 문자로 채움
REPLACE(s1, s2, s3) - 대상 문자열의 지정한 문자를 원하는 문자로 변경
SUBSTR(s, n, k) - 대상 문자열의 지정한 자리에서부터 지정된 길만큼 잘라서 반환
TRIM(c FROM s) - 대상 문자열의 양쪽에서 지정된 문자 삭제(문자열만 넣으면 기본값으로 공백 제거)
*/

# 숫자값 반환 함수
/*
ASCII(c) - 대상 알파벳 문자의 아스키 코드 값 반환
LENGTH(s) - 대상 문자열의 Byte 반환
CHAR_LENGTH(s) - 문자열의 문자 수 반환
*/

SELECT CONCAT(CONCAT('마당', ' '), '서점') FROM dual;
SELECT CONCAT('마당', ' ', '서점') FROM dual;
SELECT LOWER('AbCdEfG'), UPPER('AbCdEfG') FROM dual;
SELECT LPAD('Page 1', 10, '*'), RPAD('페이지 1', 10, '*')  FROM dual;
SELECT REPLACE('안녕 자바', '자바', 'JAVA');
SELECT SUBSTR('010-1234-5678', 5, 4) FROM dual;
SELECT TRIM('      010-1234-5678 ')
      ,CHAR_LENGTH(TRIM('      010-1234-5678 '))
      ,CHAR_LENGTH(LTRIM('      010-1234-5678 '))
      ,CHAR_LENGTH(RTRIM('      010-1234-5678 '))
  FROM dual;
SELECT ASCII('A'), ASCII('a') FROM dual;
SELECT LENGTH('안'), LENGTH('A') FROM dual;

SELECT bookid,  REPLACE(bookname, '축구', '농구'), publisher, price FROM book;

# 4-4 도서제목에 야구가 포함된 도서를 농구로 변경한 후 도서 목록을 보이시오.
SELECT REPLACE(bookname, '야구', '농구')
  FROM book
 WHERE bookname LIKE '%야구%';
 
# 질의 4-5 굿스포츠에서 출판한 도서의 제목과 제목의 글자 수를 확인하시오.
# (한글은 2바이트 혹은 UNICODE 경우는 3바이트를 차지함)
SELECT bookname AS '도서 제목'
	  ,LENGTH(bookname) AS '글자 수'
  FROM book
 WHERE publisher = '굿스포츠';

# 컬럼(14)
-- 성별 남, 여
-- 1. jumin 컬럼(14 바이트) 000000-0000000 -> customer, unique, not null
-- 2. 여성 -> 2, 남성 -> (000000-1000000)

DESC customer;
SELECT * FROM Customer;

ALTER TABLE customer ADD jumin VARCHAR(14) UNIQUE;
ALTER TABLE customer MODIFY jumin VARCHAR(14) NOT NULL;

ALTER TABLE customer MODIFY jumin VARCHAR(14) DEFAULT '000000-0000000';

ALTER TABLE customer DROP jumin;
ALTER TABLE customer ADD jumin VARCHAR(14) UNIQUE NOT NULL;

UPDATE customer SET jumin = '800000-1000000' WHERE custid = 1;
UPDATE customer SET jumin = '810000-2000000' WHERE custid = 2;
UPDATE customer SET jumin = '820000-2000000' WHERE custid = 3;
UPDATE customer SET jumin = '830000-1000000' WHERE custid = 4;
UPDATE customer SET jumin = '840000-2000000' WHERE custid = 5;

# 질의 4-6 마당서점의 고객 중에서 같은 성(남녀 성별)을 가진 사람이 몇 명이나 되는지 성별 인원수를 구하시오.
# 성별 인원수 구하기

# 남성 -> name님 남탕으로 가세요 / 여성 -> name님, 여탕으로 가세요
SELECT name
	  -- ,SUBSTR(jumin, 8, 1) AS "성별"
      ,SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
      ,CONCAT(name, '님 남탕으로 가세요.')
  FROM customer
 WHERE SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 1
 UNION
 SELECT name
	  -- ,SUBSTR(jumin, 8, 1) AS "성별"
      ,SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
      ,CONCAT(name, '님 여탕으로 가세요.')
  FROM customer
 WHERE SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 2;


# 남성 -> 멘체스터에서 오신 name님 남탕으로 가세요 / 여성 -> 강원도에서 오신 name님, 여탕으로 가세요
--  UNION 
SELECT name AS '이름'
      ,SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
      ,SUBSTR(address, (INSTR(address, ' ')) +1) AS '지역'
      ,CONCAT(SUBSTR(address, (INSTR(address, ' ')) +1), '에서 오신 ', name, '님 남탕으로 가세요.') AS '안내방송'
  FROM customer
 WHERE SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 1
 UNION
 SELECT name AS '이름'
      ,SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
      ,SUBSTR(address, (INSTR(address, ' ')) +1) AS '지역'
      ,CONCAT(SUBSTR(address, (INSTR(address, ' ')) +1), '에서 오신 ', name, '님 여탕으로 가세요.') AS '안내방송'
  FROM customer
 WHERE SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 2;


 -- 조건문
 SELECT name AS '이름'
       ,SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) AS '성별'
       ,SUBSTR(address, (INSTR(address, ' ')) +1) AS '지역'
       ,CASE 
			WHEN SUBSTR(jumin, (INSTR(jumin, '-')) + 1, 1) = 1
				THEN CONCAT(SUBSTR(address, (INSTR(address, ' ')) +1), '에서 오신 ', name, '님 남탕으로 가세요.') 
		ELSE CONCAT(SUBSTR(address, (INSTR(address, ' ')) +1), '에서 오신 ', name, '님 여탕으로 가세요.') END AS '안내방송'
   FROM customer;
 
 
# 날짜, 시간 함수
/*
SYSDATE() = DATE - 오늘 날짜를 반환하는 함수
DATE(date) = DATE - DATE형의 날짜 부분을 반환

DATE_FORMAT(date, format) = STRING - 날짜형 데이터를 문자형으로 반환
STR_TO_DATE(string,format) = DATE - 문자열 데이터를 날짜형으로 반환

ADDDATE(date, interval) = DATE - DATE형의 날짜에서 INTERVAL 지정한 시간만큼 더함
DATEDIFF(date1, date2) = INTEGER - DATE형의 date1 - date2 날짜 차이를 반환
*/

SELECT SYSDATE() FROM dual;

SELECT SYSDATE() AS '현재시간'
      ,STR_TO_DATE('2023-10-11 23:59:59', '%Y-%m-%d %H:%i:%s')
      ,DATE(SYSDATE()) AS '날짜'
      ,DATE_FORMAT(SYSDATE(), '%y') AS '년도'
      ,DATE_FORMAT(SYSDATE(), '%m') AS '월'
      ,DATE_FORMAT(SYSDATE(), '%d') AS '일'
      ,DATE_FORMAT(SYSDATE(), '%H') AS '시'
      ,DATE_FORMAT(SYSDATE(), '%i') AS '분'
      ,DATE_FORMAT(SYSDATE(), '%s') AS '초'
  FROM dual;
 
-- ADDDATE(date, interval)
SELECT DATE(SYSDATE()) AS '현재날짜'
      ,ADDDATE(DATE(SYSDATE()), 2) AS '2일 후'
      ,ADDDATE(DATE(SYSDATE()), INTERVAL 10 day) AS '10일 후'
      ,ADDDATE(DATE(SYSDATE()), INTERVAL 10 MONTH) AS '10달 후'
      ,ADDDATE(DATE(SYSDATE()), INTERVAL 10 YEAR) AS '10년 후'
  FROM dual;
  
-- DATEDIFF(date1, date2)
SELECT DATEDIFF(DATE(SYSDATE()), STR_TO_DATE('20200101', '%y%m%d'))
      ,DATEDIFF(DATE(SYSDATE()), STR_TO_DATE('201010', '%y%m%d'))
  FROM dual;


# [질의 4-7] 마당서점은 주문일로부터 10일 후 매출을 확정한다. 각 주문의 확정일자를 구하시오
SELECT * FROM Orders;

SELECT orderid AS '주문 아이디' 
	  ,orderdate AS '주문일자'
	  ,ADDDATE(orderdate, 10) AS '확정일자'
      -- ,ADDDATE(orderdate, INTERVAL 10 day) AS '확정일자'
  FROM Orders;

DESC Orders;
SELECT CONCAT(DATE_FORMAT(SYSDATE(), '%y'), "년도")
  FROM dual;
  
# 2014-07-13 오늘날짜로 가정하고 확정일 0 -> 오늘 확정일, 확정일 - 지나갔네, 확정일 + 확정일까지 3일
-- 오늘 날짜 : 2014-07-13 가정
-- 확정일 = 0 : 오늘 확정일,
-- 확정일 < 0 : 확정일이 지나감
-- 확정일 > 0 : 일 남앗네

SELECT orderid AS "주문번호"
	  ,orderdate AS "주문일자"
	  ,ADDDATE(orderdate, 10) AS "확정일자"
	  ,DATE('2014-07-13') AS "오늘"
	  ,DATEDIFF(ADDDATE(orderdate, 10), DATE('2014-07-13')) AS "디데이"
      ,CONCAT('확정일까지 ' ,ABS(DATEDIFF(ADDDATE(orderdate, 10), DATE('2014-07-13'))) , '일 지났습니다') AS "안내"
  FROM orders
 WHERE DATEDIFF(ADDDATE(orderdate, 10),  DATE('2014-07-13')) < 0
 UNION
SELECT orderid AS "주문번호"
	  ,orderdate AS "주문일자"
	  ,ADDDATE(orderdate, 10) AS "확정일자"
	  ,DATE('2014-07-13') AS "오늘"
	  ,DATEDIFF(ADDDATE(orderdate, 10), DATE('2014-07-13')) AS "디데이"
	  ,CONCAT('확정일까지 ' ,DATEDIFF(ADDDATE(orderdate, 10), DATE('2014-07-13')) , '일 남았습니다') AS "안내"
  FROM orders
 WHERE DATEDIFF(ADDDATE(orderdate, 10),  DATE('2014-07-13')) > 0
 UNION
SELECT orderid AS "주문번호"
      ,orderdate AS "주문일자"
	  ,ADDDATE(orderdate, 10) AS "확정일자"
	  ,DATE('2014-07-13') AS "오늘"
	  ,DATEDIFF(ADDDATE(orderdate, 10), DATE('2014-07-13')) AS "디데이"
	  ,"확정일입니다" AS "안내"
  FROM orders
 WHERE DATEDIFF(ADDDATE(orderdate, 10),  DATE('2014-07-13')) = 0;
  

SELECT *
  FROM ( SELECT A.custid
			  ,A.orderdate
			  ,'지나감' AS "판단"
			  ,A.확정일
		  FROM ( SELECT custid
					   ,orderdate
					   ,adddate(orderdate, 10) "확정일"
					   ,datediff(str_to_date('2014-7-14', '%Y-%m-%d')
					   ,adddate(orderdate, 10)) AS diff
				   FROM orders ) A
				  WHERE A.diff < 0
				  UNION
				 SELECT A.custid
					   ,A.orderdate
					   ,'오늘확정'
					   ,A.확정일
				   FROM ( SELECT custid
								,orderdate
								,adddate(orderdate, 10) "확정일"
								,datediff(str_to_date('2014-7-14', '%Y-%m-%d')
								,adddate(orderdate, 10)) AS diff
							FROM orders ) A
						   WHERE A.diff = 0
						   UNION
						  SELECT A.custid
								,A.orderdate
								,concat(A.diff
								, ' 일 남음')
								,A.확정일
							FROM ( SELECT custid
										 ,orderdate
										 ,adddate(orderdate, 10) "확정일"
										 ,datediff(str_to_date('2014-7-14', '%Y-%m-%d')
										 ,adddate(orderdate, 10)) AS diff
									 FROM orders ) A
									WHERE A.diff > 0) A
		   ORDER BY A.확정일;
  
# [질의 4-8] 마당서점이 2014년 7월 7일에 주문받은 도서의 주문번호, 주문일, 고객번호, 도서번호를 모두 보이시오. 단, 주문일은 '%Y-%m-%d' 형태로 표시한다.
SELECT orderid AS '주문번호'
      ,DATE_FORMAT(orderdate, '%Y-%m-%d') AS '주문일'
	  ,custid AS '고객번호'
      ,bookid AS '도서번호'
  FROM Orders
 WHERE orderdate = '2014-07-07';
  
# [질의 4-9] DBMS 서버에 설정된 현재 날짜와 시간, 요일을 확인하시오. 
-- WEEKDAY()   - 0: 월요일, 1: 화요일, ~ 5: 토요일, 6: 일요일
-- DAYOFWEEK() - 1: 일요일, 2: 월요일, ~ 6: 금요일, 7: 토요일

SELECT WEEKDAY(SYSDATE());
SELECT DAYOFWEEK(SYSDATE());

SELECT DATE_FORMAT(SYSDATE(), '%Y-%m-%d %H:%i:%s') AS '현재 날짜와 시간'
      ,DATE_FORMAT(SYSDATE(), '%Y') AS '년도'
      ,DATE_FORMAT(SYSDATE(), '%m') AS '월'
      ,DATE_FORMAT(SYSDATE(), '%d') AS '일'
      ,DATE_FORMAT(SYSDATE(), '%w') AS '요일 순서(%w)'
      ,DATE_FORMAT(SYSDATE(), '%W') AS '요일 (%W)'
      ,DATE_FORMAT(SYSDATE(), '%a') AS '요일 약자(%a)'
      ,DATE_FORMAT(SYSDATE(), '%H') AS '시'
      ,DATE_FORMAT(SYSDATE(), '%i') AS '분'
      ,DATE_FORMAT(SYSDATE(), '%s') AS '초'
 FROM dual;