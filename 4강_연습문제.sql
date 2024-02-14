# Mathematical Functions
# https://dev.mysql.com/doc/refman/8.0/en/mathematical-functions.html
SELECT ABS(-15) 				 	-- 15 (절댓값)
      ,CEIL(15.7)				 	-- 16 (올림)
      ,FLOOR(15.7) 				 	-- 15 (내림)
	  ,ROUND(15.7) 				 	-- 16 (반올림)
      ,LOG(10, 100) 			 	-- 2  (로그)
      ,POWER(3, 2) 				 	-- 9  (제곱)
      ,MOD(11, 4) 				 	-- 3  (나머지)
      ,COS(3.14159) 			 	-- 0.9999999999964793 (코사인)
      ,SIGN(-15) 				 	-- -1 (음수: -1, 양수: 1)
      -- Truncate to specified number of decimal places(지정된 소수 자릿수까지 자르기)
      ,TRUNCATE(15.7, 1) 			-- 소수점 이하 자릿수 X까지 잘린 숫자를 반환
;
  
SELECT TRUNCATE(1.223, 1), TRUNCATE(1.999,1), TRUNCATE(1.999,0), TRUNCATE(-1.999,1), TRUNCATE(122,-2), TRUNCATE(10.28*100,0);

# String Functions and Operators
# https://dev.mysql.com/doc/refman/8.0/en/string-functions.html

SELECT CONCAT('HAPPY', 'Birthday')	 	-- HAPPY Birthday (문자열 연결)
      ,REPLACE('JACK', 'J', 'BL')    	-- BLACK (지정한 문자를 원하는 문자로 변경)
      ,SUBSTR('ABCDEFG', 3, 4)       	-- CDEF (지정된 자리에서부터 지정된 길이만큼 잘라서 반환)
	  ,TRIM(BOTH 0 FROM '00AA00')    	-- AA (기본, 대상 문자열의 양쪽에서 지정된 문자 삭제)
      ,TRIM(LEADING 0 FROM '00AA00') 	-- AA00 (왼쪽 삭제)
      ,TRIM(TRAILING 0 FROM '00AA00')	-- 00AA (오른쪽 삭제)
      ,UPPER('HAPPY Birthday')		 	-- HAPPY BIRTHDAY (대문자 변환)
      ,LOWER('HAPPY Birthday')		 	-- happy birthday (소문자 변환)
      ,LPAD('Page 1', '15', '*.')    	-- *.*.*.*.*Page 1 (대상 문자열의 왼쪽부터 지정한 자리수까지 지정한 문자로 채움)
      ,RPAD('Page 1', '15', '*.')    	-- Page 1*.*.*.*.* (대상 문자열의 오른쪽부터 지정한 자리수까지 지정한 문자로 채움)
      ,CHAR(65 USING utf8)			 	-- A(정수에 대한 문자 반환)
      ,ASCII('A')					 	-- 65 (아스키 코드 값)
      ,LENGTH('Birthday')				-- 8
;

# Date and Time Functions
# https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html

SELECT ADDDATE('2023-10-12', INTERVAL 10 DAY)		-- 2023-10-22
      ,LAST_DAY(SYSDATE())							-- 2023-10-21
      ,NOW()										-- 2023-10-12 16:12:42 (현재 날짜와 시간 반환)
      ,DATE_FORMAT(SYSDATE(), '%Y')					-- 2023
      ,STR_TO_DATE('12 05 2023', '%d %m %Y')		-- 2023-05-12
;

SELECT DATE(SYSDATE());

# Cast Functions and Operators
# https://dev.mysql.com/doc/refman/8.0/en/cast-functions.html

# 값을 특정 유형으로 캐스팅
-- CAST(expr AS type) - 명시된 type 으로 변환
-- CONVERT()

SELECT CAST('12.3' AS DECIMAL(3, 1))				-- 12.3
	  ,CONVERT('abc' USING utf8mb4)
;

# Flow COntrol Functions
# https://dev.mysql.com/doc/refman/8.0/en/flow-control-functions.html

-- IF(expr1, expr2, expr3)
-- If expr1 is TRUE (expr1 <> 0 and expr1 IS NOT NULL), IF() returns expr2. Otherwise, it returns expr3.

-- IFNULL(expr1,expr2)
-- If expr1 is not NULL, IFNULL() returns expr1; otherwise it returns expr2.

-- NULLIF(expr1,expr2)
-- Returns NULL if expr1 = expr2 is true, otherwise returns expr1. This is the same as CASE WHEN expr1 = expr2 THEN NULL ELSE expr1 END.

SELECT IF(1 = 1, 'aa', 'bb')						-- aa
	  ,IF(1 > 2, 2, 3)
	  ,IFNULL(123, 345)								-- 123
      ,IFNULL(NULL, 123)							-- 123