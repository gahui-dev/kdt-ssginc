show databases;
use mysql;
show tables;
select * from user;

desc user;

select host, user, password_expired from user;

desc servers;
select host, db, userName, password, port from servers;

-- 계정 접속
-- database 1 --> table1, ... n


-- 1. mysql 설치 / 접속 / 각종 명령어 및 구성
-- 2. 환경변수 설정
-- 3. 명령어프롬프트
-- $mysql - u root -p;
-- 4. 사용자 만들기 ( % : 외부접속, localhost 내부접속)
--    CREATE USER madang@localhost IDENTIFIED WITH mysql_native_password BY 'madang';
-- 	  CREATE DATABASE madang;
--    GRANT ALL PRIVILEGES ON madang.* to madang@localhost WITH GRANT OPTION;