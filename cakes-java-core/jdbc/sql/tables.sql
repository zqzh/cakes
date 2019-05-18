CREATE DATABASE jdbc;

USE jdbc;

CREATE TABLE IF NOT EXISTS `user`
(
    `id`   BIGINT(20)  NOT NULL DEFAULT 0 COMMENT 'id标识',
    `name` VARCHAR(32) NOT NULL DEFAULT '' COMMENT 'mark 标识'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='user';

insert into user(id, name)
values (1, 'jim'),
       (2, 'jack');