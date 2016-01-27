/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50545
Source Host           : localhost:3306
Source Database       : datian

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2016-01-23 10:19:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orderform
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `id` varchar(255) NOT NULL,
  `orderNum` varchar(255) DEFAULT NULL,
  `clientName` varchar(255) DEFAULT NULL,
  `isLinkToClientWayBill` varchar(255) DEFAULT NULL,
  `clientWayBillNum` varchar(255) DEFAULT NULL,
  `hasCarrierContract` varchar(255) DEFAULT NULL,
  `contractId` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `resourceName` varchar(255) DEFAULT NULL,
  `resourceType` varchar(255) DEFAULT NULL,
  `submitTime` datetime DEFAULT NULL,
  `finishTime` datetime DEFAULT NULL COMMENT '订单完成时间',
  `deliveryAddr` varchar(255) DEFAULT NULL,
  `deliveryName` varchar(255) DEFAULT NULL,
  `deliveryPhone` varchar(255) DEFAULT NULL,
  `recieverAddr` varchar(255) DEFAULT NULL,
  `recieverName` varchar(255) DEFAULT NULL,
  `recieverPhone` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `goodsName` varchar(255) DEFAULT NULL,
  `goodsWeight` float(10,0) DEFAULT NULL,
  `goodsVolume` float(10,0) DEFAULT NULL,
  `declaredPrice` float(10,0) DEFAULT NULL,
  `expectedPrice` float(10,0) DEFAULT '0',
  `actualPrice` float(10,0) DEFAULT '0',
  `insurance` float(10,0) DEFAULT '0',
  `acceptPicture` varchar(255) DEFAULT NULL,
  `explainReason` varchar(255) DEFAULT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `confirm` varchar(255) DEFAULT 'false' COMMENT '用于标示司机是否确认',
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `citylineId` varchar(255) DEFAULT NULL,
  `linetransportId` varchar(255) DEFAULT NULL,
  `lesstruckloadId` varchar(255) DEFAULT NULL,
  `fulltruckloadId` varchar(255) DEFAULT NULL,
  `warehouseId` varchar(255) DEFAULT NULL,
  `cancelReason` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL COMMENT '订单状态',
  `settlementState` varchar(255) DEFAULT NULL,
  `commentId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------
INSERT INTO `orderform` VALUES ('OR77562450', 'y25369539', '天津友达通有限公司', '有,Test0001', null, '有', 'CO00000004', '北京索契物流有限公司', '苏州→北京', '线路', '2015-06-20 19:39:31', '2015-12-24 16:06:47', 's', '王王强', '18839293032', 's', '李大倩', '13810087678', 'test', 'test3', '200', '2000', '1200', '1000', '124', '1000', 'D://uploadFile//signBill//CL29101095_commons-beanutils-1.7.0.jar', 'test', '冀EKK301', '汪家根', 'true', 'CL23767471', 'CL29101095', null, null, null, null, null, null, '待收货', '已生成', 'AS61374799');
INSERT INTO `orderform` VALUES ('OR84042943', 'y24357612', '天津友达通有限公司', null, null, '有', 'C0005', '北京索契物流有限公司', '上海→广州', '线路', '2015-06-22 00:26:47', null, 's', '李四', '18001002291', 's', '雪花', '13810087678', 'test', '这是核弹', '200', '12', '3000', '3000', '8900', '1000', 'D://uploadFile//signBill//CL29101095_commons-logging-1.1.jar', 'Android端的人帅，漂亮！', '冀EKK301', '汪家根', 'true', 'CL23767471', 'CL29101095', null, null, null, null, null, null, '已完成', '已生成', 'AS46647679');
INSERT INTO `orderform` VALUES ('OR84043492', 'y95698591', '天津友达通有限公司', null, null, '有', 'C0002', '北京索契物流有限公司', '上海→广州', '线路', '2015-06-20 11:42:40', null, 's', '张三', '18001002290', 's', '李刚  ', '13810087678', 'seee', '这是大型仪器', '200', '12', '2000', '3000', '123', '1000', 'CL29101095_Steam.exe', 'test', '冀EKK301', '汪家根', 'false', 'CL23767471', 'CL29101095', null, null, null, null, null, null, '已受理', '已生成', 'AS2211219');
