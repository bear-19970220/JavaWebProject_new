-- 用户表（管理员）
CREATE TABLE `t_user` (
  `username` VARCHAR ( 50 ) DEFAULT NULL,
  `password` VARCHAR ( 50 ) DEFAULT NULL
) ENGINE = INNODB DEFAULT CHARSET = utf8;

INSERT INTO `t_user`(`username`, `password`) VALUES ('root', '123');
INSERT INTO `t_user`(`username`, `password`) VALUES ('bear', '456');
INSERT INTO `t_user`(`username`, `password`) VALUES ('极光之域', '123456');
INSERT INTO `t_user`(`username`, `password`) VALUES ('墨尘溪', '111');

-- ----------------------------------------------------------------------------

-- 客户表
CREATE TABLE `t_customer` (
  `cid` bigint(50) DEFAULT NULL,
  `cname` varchar(50) DEFAULT NULL,
  `csex` char(3) DEFAULT NULL,
  `cphone` varchar(20) DEFAULT NULL,
  `caddress` varchar(100) DEFAULT NULL,
  `cbirth` date DEFAULT NULL,
  `cjointime` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (1, '张三', '男', '13556919290', '广东', '1997-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (2, '李四', '女', '17610674500', '福建', '1998-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (3, '王五', '男', '13556956800', '云南', '1970-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (4, '444', '男', '44444444444', '北京', '1997-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (5, '555', '女', '55555555555', '上海', '1997-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (6, '666', '女', '66666666666', '浙江', '1997-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (7, '777', '女', '77777777777', '广西', '1997-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (8, '888', '男', '88888888888', '西藏', '1997-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (9, '999', '女', '99999999999', '新疆', '1997-01-01', '2019-11-20');
INSERT INTO `t_customer`(`cid`, `cname`, `csex`, `cphone`, `caddress`, `cbirth`, `cjointime`) VALUES (10, 'XXX', '男', '10101010101', '内蒙古', '1997-01-01', '2019-11-20');
