DROP TABLE IF EXISTS  `product`;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `name` varchar(30) DEFAULT NULL COMMENT '产品名称',
  `price` double DEFAULT NULL COMMENT '产品价格',
  `desc` varchar(50) DEFAULT NULL COMMENT '产品描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;