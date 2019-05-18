# crud-xml

---

### 1.初始化
* SQL
```sql
CREATE DATABASE mybatis;

USE mybatis;

CREATE TABLE IF NOT EXISTS `trans`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `trans_id`    VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '交易单号,唯一',
    `body`        VARCHAR(128)        NOT NULL DEFAULT '' COMMENT '描述',
    `subject`     VARCHAR(128)        NOT NULL DEFAULT '' COMMENT '标题',
    `amount`      BIGINT(20)          NOT NULL DEFAULT 0 COMMENT '交易金额,单位:分',
    `create_time` DATETIME            NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='交易信息表';

INSERT INTO `trans`(`trans_id`, `body`, `subject`, `amount`)
VALUES ('10011000', '微信交易', '支付', 512),
       ('10011001', '支付宝交易', '支付', 1024),
       ('10011002', '易宝支付交易', '支付', 2048),
       ('10011003', '微信交易', '支付', 4096);
```

* 实体类:mybatis.domain.Trans
```java
public class Trans {

  private Long id;
  private String trans_id;
  private String body;
  private String subject;
  private Long amount;
  private Date create_time;

}
```