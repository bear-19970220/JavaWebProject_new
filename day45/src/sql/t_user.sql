CREATE TABLE `t_user` (
  `uid` int(50) NOT NULL,
  `uname` varchar(50) DEFAULT NULL,
  `sex` char(5) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_user`(`uid`, `uname`, `sex`, `age`, `birth`, `email`) VALUES (1, '张三', '男', 20, '1996-03-30 07:20:02', 'zhangsan@163.com');
INSERT INTO `t_user`(`uid`, `uname`, `sex`, `age`, `birth`, `email`) VALUES (2, '李四', '男', 21, '2001-06-19 19:24:47', 'lisi@qq.com');
INSERT INTO `t_user`(`uid`, `uname`, `sex`, `age`, `birth`, `email`) VALUES (3, '王五', '男', 22, '2019-11-27 16:55:11', 'wangwu@126.com');
INSERT INTO `t_user`(`uid`, `uname`, `sex`, `age`, `birth`, `email`) VALUES (4, '赵六', '男', 23, '2016-10-29 15:01:38', 'zhaoliu@sina.com');
INSERT INTO `t_user`(`uid`, `uname`, `sex`, `age`, `birth`, `email`) VALUES (5, '田七', '男', 24, '1998-11-15 02:40:17', 'tianqi@gmail.com');
