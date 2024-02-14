# ALTER 기본 문법
-- ALTER 문은 생성된 테이블의 속성과 속성에 관한 제약을 변경(기본키, 외래키 변경)
-- ADD, DROP은 속성을 추가하거나 제거할 때 사용
-- MODIFY는 속성의 기본값을 설정하거나 삭제할 때 사용
-- ADD <제약이름>, DROP <제약이름>은 제약사항을 추가하거나 삭제할 때 사용

/*
	ALTER TABLE 테이블이름
		[ADD 속성이름 데이터타입]
		[DROP COLUMN 속성이름]
		[MODIFY 속성이름 데이터타입]
		[MODIFY 속성이름 [NULL┃NOT NULL]]
		[ADD PRIMARY KEY(속성이름)]
		[[ADD┃DROP] 제약이름]
*/

SELECT *
	FROM
		INFORMATION_SCHEMA.TABLE_CONSTRAINTS
	WHERE
		TABLE_SCHEMA = 'madang';
		-- AND TABLE_NAME = 'NewOrders';

DESC NewBook;

SELECT * FROM NewBook;
ALTER TABLE NewBook DROP COLUMN isbn;
ALTER TABLE NewBook DROP PRIMARY KEY;
ALTER TABLE NewBook DROP newbook_price_ck;

# 제약조건 추가, 삭제
ALTER TABLE NewBook MODIFY price int CONSTRAINT newbook_price_ck CHECK(price > 1000);
ALTER TABLE NewBook DROP CHECK newbook_price_ck;

# [3-37] NewBook 테이블에 VARCHAR(13)의 자료형을 가진 isbn 속성을 추가
ALTER TABLE NewBook ADD isbn VARCHAR(13);

# [3-38] NewBook 테이블의 isbn 속성의 데이터 타입을 INTEGER형으로 변경
ALTER TABLE NewBook MODIFY isbn VARCHAR(13);
    
ALTER TABLE NewBook MODIFY isbn VARCHAR(13) NOT NULL;
ALTER TABLE NewBook MODIFY bookname VARCHAR(20) NOT NULL;
ALTER TABLE NewBook MODIFY bookid INTEGER NULL;

ALTER TABLE NewBook ADD PRIMARY KEY(bookid);

# DROP 기본 문법
-- DROP 문은 테이블을 삭제하는 명령
-- DROP 문은 테이블의 구조와 데이터를 모두 삭제하므로 사용에 주의(데이터만 삭제하려면 DELETE 문 사용)

/*
DROP TABLE 테이블이름
*/

DESC NewOrders;

-- Error Code: 3730. Cannot drop table 'newcustomer' referenced by a foreign key constraint 'neworders_ibfk_1' on table 'NewOrders'.
-- 해결 1. 자식 테이블부터 삭제
-- 해결 2. ALTER 명령어로 자식 테이블 제약조건 삭제
DROP TABLE NewCustomer;

ALTER TABLE NewOrders DROP FOREIGN KEY neworders_ibfk_1;