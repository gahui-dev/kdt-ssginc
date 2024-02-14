# 외래키 제약조건을 명할 때는 반드시 참조되는 테이블(부모 릴레이션)이 존재해야 하며 참조되는 테이블의 기본키여야 함
# 외래키 지정 시 ON DELETE 또는 ON UPDATE 옵션은 참조되는 테이블의 튜플이 삭제되나 수정될 때 취할 수 있는 동작을 지정함
# NO ACTION 은 어떠한 동작도 취하지 않음

# 데이터 타입 종류
-- INTEGER / INT - 4바이트 정수형
-- NUMERIC(m,d) / DECIAMAL(m,d) - 전체자리수 m, 소주점 이하 자리수 d를 가진 숫자형
-- CHAR(n) - 문자형 고정길이
-- VARCHAR(n) - 문자형 가변길이
-- DATE - 날짜형, 연도, 월, 날, 시간 저장

# ALTER 문은 생성된 테이블의 속성과 속성에 관한 제약을 변경(기본키, 외래키 변경)
# ADD, DROP은 속성을 추가하거나 제거할 때 사용
# MODIFY는 속성의 기본값을 설정하거나 삭제할 때 사용
# ADD <제약이름>, DROP <제약이름>은 제약사항을 추가하거나 삭제할 때 사용

-- ALTER 기본 문법
/*
	ALTER TABLE 테이블이름
	[ADD 속성이름 데이터타입]
	[DROP COLUMN 속성이름]
	[MODIFY 속성이름 데이터타입]
	[MODIFY 속성이름 [NULL┃NOT NULL]]
	[ADD PRIMARY KEY(속성이름)]
	[[ADD┃DROP] 제약이름]
*/

# [3-37] NewBook 테이블에 VARCHAR(13)의 자료형을 가진 isbn 속성을 추가하시오.