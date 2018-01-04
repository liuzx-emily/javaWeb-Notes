/*
Navicat MySQL Data Transfer

Source Server         : liuzx
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : liuzx

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2018-01-04 17:25:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(50) DEFAULT NULL,
  `loc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', '教研部', '北京');
INSERT INTO `dept` VALUES ('20', '学工部', '上海');
INSERT INTO `dept` VALUES ('30', '销售部', '广州');
INSERT INTO `dept` VALUES ('40', '财务部', '武汉');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(11) NOT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `COMM` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `fk_emp` (`mgr`),
  CONSTRAINT `fk_emp` FOREIGN KEY (`mgr`) REFERENCES `emp` (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1001', '甘宁', '文员', '1013', '2000-12-17', '8000.00', null, '20');
INSERT INTO `emp` VALUES ('1002', '黛绮丝', '销售员', '1006', '2001-02-20', '16000.00', '3000.00', '30');
INSERT INTO `emp` VALUES ('1003', '殷天正', '销售员', '1006', '2001-02-22', '12500.00', '5000.00', '30');
INSERT INTO `emp` VALUES ('1004', '刘备', '经理', '1009', '2001-04-02', '29750.00', null, '20');
INSERT INTO `emp` VALUES ('1005', '谢逊', '销售员', '1006', '2001-09-28', '12500.00', '14000.00', '30');
INSERT INTO `emp` VALUES ('1006', '关羽', '经理', '1009', '2001-05-01', '28500.00', null, '30');
INSERT INTO `emp` VALUES ('1007', '张飞', '经理', '1009', '2001-09-01', '24500.00', null, '10');
INSERT INTO `emp` VALUES ('1008', '诸葛亮', '分析师', '1004', '2007-04-19', '30000.00', null, '20');
INSERT INTO `emp` VALUES ('1009', '曾阿牛', '董事长', null, '2001-11-17', '50000.00', null, '10');
INSERT INTO `emp` VALUES ('1010', '韦一笑', '销售员', '1006', '2001-09-08', '15000.00', '0.00', '30');
INSERT INTO `emp` VALUES ('1011', '周泰', '文员', '1008', '2007-05-23', '11000.00', null, '20');
INSERT INTO `emp` VALUES ('1012', '程普', '文员', '1006', '2001-12-03', '9500.00', null, '30');
INSERT INTO `emp` VALUES ('1013', '庞统', '分析师', '1004', '2001-12-03', '30000.00', null, '20');
INSERT INTO `emp` VALUES ('1014', '黄盖', '文员', '1007', '2002-01-23', '13000.00', null, '10');

-- ----------------------------
-- Table structure for salgrade
-- ----------------------------
DROP TABLE IF EXISTS `salgrade`;
CREATE TABLE `salgrade` (
  `grade` int(11) NOT NULL,
  `losal` int(11) DEFAULT NULL,
  `hisal` int(11) DEFAULT NULL,
  PRIMARY KEY (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salgrade
-- ----------------------------
INSERT INTO `salgrade` VALUES ('1', '7000', '12000');
INSERT INTO `salgrade` VALUES ('2', '12010', '14000');
INSERT INTO `salgrade` VALUES ('3', '14010', '20000');
INSERT INTO `salgrade` VALUES ('4', '20010', '30000');
INSERT INTO `salgrade` VALUES ('5', '30010', '99990');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(50) DEFAULT NULL COMMENT '全名',
  `full_name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小美2', '23', '33D67A1C82624E9691BF9A494B0CCCFD');
INSERT INTO `student` VALUES ('31', '钱', '33', '7B923D51786240D3883977657831D67C');
INSERT INTO `student` VALUES ('15', '孙', '18', '92C13AE9AC22454BB7B1CACBFC4460A2');
INSERT INTO `student` VALUES ('16', '李', '32', '99D246594BC5452DB3B7B069B0628E93');
INSERT INTO `student` VALUES ('3', '赵', '22', '9C2A8BDC5C194604951F458826E213DA');
INSERT INTO `student` VALUES ('21', '吴', '21', 'D65763B6CB1A4B869E86ACED49512D84');
INSERT INTO `student` VALUES ('21', '周', '22', 'DB702777B7CA4A44BA560D4DC1E69B4D');
INSERT INTO `student` VALUES ('2', '小美', '23', 'E8B95437283B4C998D7533B88D2D4B89');

-- ----------------------------
-- Table structure for tb
-- ----------------------------
DROP TABLE IF EXISTS `tb`;
CREATE TABLE `tb` (
  `year` varchar(255) DEFAULT NULL,
  `zz` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb
-- ----------------------------
INSERT INTO `tb` VALUES ('2010', '100');
INSERT INTO `tb` VALUES ('2011', '150');
INSERT INTO `tb` VALUES ('2012', '250');
INSERT INTO `tb` VALUES ('2013', '800');
INSERT INTO `tb` VALUES ('2014', '1000');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('liuzx', '123');
