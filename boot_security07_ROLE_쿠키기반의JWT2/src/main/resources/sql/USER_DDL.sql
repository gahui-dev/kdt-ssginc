

drop table if exists user;
CREATE TABLE user
(
	 id  integer PRIMARY KEY auto_increment,
	 name varchar(20) NOT NULL,
	 username varchar(20) NOT NULL,
	 email varchar(20) NOT NULL,
	 password varchar(500) NOT NULL,
	 address varchar(50) NOT NULL,
	 phone varchar(20) NOT NULL,
	 website varchar(20) NOT NULL,
	 company varchar(20) NOT NULL,
	 role varchar(20) NOT NULL
);

  
  
