CREATE TABLE IF NOT EXISTS  USER(
   id bigint(20) NOT NULL AUTO_INCREMENT,
   username varchar(40),
   email varchar(128),
   primary key(id)
);