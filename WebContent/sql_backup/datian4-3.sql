/*
Navicat MySQL Data Transfer

Source Server         : 大田
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : datian

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2016-04-03 20:19:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relDate` datetime DEFAULT NULL,
  `frequency` int(11) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `kind` int(11) DEFAULT NULL COMMENT '1为发货地址2为收货地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('Add32998832', '李四', '河北省唐山市', '010-33223444', '2015-05-30 00:00:00', '0', 'CL23767471', null);
INSERT INTO `address` VALUES ('Add42880504', '王五', '北京市朝阳区', '010-22334542', '2015-05-30 00:00:00', '0', 'CL81096930', null);
INSERT INTO `address` VALUES ('Add60594474', '功朋', '贵州市人民政府', '13324499999', '2016-02-16 16:54:55', '0', 'CL23767471', '2');
INSERT INTO `address` VALUES ('Add84554533', '林如', '重庆沙坪坝', '13323388888', '2016-02-16 16:54:55', '0', 'CL23767471', '1');
INSERT INTO `address` VALUES ('Add9525010', '郝晨栋', '陕西省西安市', '17728335463', '2015-05-31 00:00:00', '0', 'CL81096930', null);
INSERT INTO `address` VALUES ('Add95250105', '苏磊', '内蒙古包头市', '18623537354', '2015-05-31 00:00:00', '0', 'CL78387917', null);
INSERT INTO `address` VALUES ('Add95250106', '胡霞', '北京市海淀区', '17756745643', '2015-05-31 00:00:00', '0', 'CL78387917', null);
INSERT INTO `address` VALUES ('Add9525015', '张三', '北京市海淀区北京交通大学', '13413244244', '2015-04-13 00:00:00', '0', 'CL23767471', null);

-- ----------------------------
-- Table structure for airline
-- ----------------------------
DROP TABLE IF EXISTS `airline`;
CREATE TABLE `airline` (
  `id` varchar(255) NOT NULL,
  `startCity` varchar(255) DEFAULT NULL,
  `endCity` varchar(255) DEFAULT NULL,
  `onwayTime` varchar(255) DEFAULT NULL,
  `extraService` varchar(255) DEFAULT NULL,
  `price1` float(10,2) DEFAULT NULL,
  `price2` float(10,2) DEFAULT NULL,
  `price3` float(10,2) DEFAULT NULL,
  `price4` float(10,2) DEFAULT NULL,
  `price5` float(10,2) DEFAULT NULL,
  `airCycle` varchar(255) DEFAULT NULL,
  `pickFee` float(10,2) DEFAULT NULL,
  `deliveryFee` float(10,2) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of airline
-- ----------------------------
INSERT INTO `airline` VALUES ('AI13507638', '深圳', '海口', '48小时', '435', '1321.00', '345.00', '123.00', '5675.00', '324.00', '周一二', '23424.00', '4535.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '6575', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI1759857', '北京', '三亚', '12小时', '', '7.00', '6.00', '5.00', '4.00', '3.00', '周三四', '2.00', '1.00', 'D://uploadFile//airline//CL29101095_[ZXPT]史蒂夫·乔布斯：机器人生.Steve.Jobs.The.Man.In.The.Machine.BD1080P.X264.AAC.English.CHS-ENG.Mp4Ba.torrent', '123', 'CL29101095', '2016-01-17');
INSERT INTO `airline` VALUES ('AI19604390', '北京', '昆明', '12小时', '', '1.00', '2.00', '3.00', '4.00', '5.00', '周一二', '6.00', '7.00', 'D://uploadFile//airline//CL29101095_杨昌庆.JPG', '', 'CL29101095', '2016-04-03');
INSERT INTO `airline` VALUES ('AI22201158', '鞍山', '海口', '24小时', '', '2.00', '4.00', '6.00', '1.00', '9.00', '周五六', '23.00', '45.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '324', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI44592328', '深圳', '南京', '24小时', '', '4.00', '1.00', '2.00', '3.00', '5.00', '周一二三四', '6.00', '7.00', 'D://uploadFile//airline//CL29101095_C罗.jpg', '123', 'CL29101095', '2016-01-30');
INSERT INTO `airline` VALUES ('AI48181548', '南昌', '张家界', '48小时', '', '12.00', '54.00', '76.00', '89.00', '23.00', '周一二三四五六', '1.00', '3.00', 'D://uploadFile//airline//CL29101095_C罗.jpg', '321', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI5061596', '海口', '佳木斯', '48小时', '', '324.00', '456.00', '657.00', '324.00', '43.00', '周一', '76.00', '87.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '123', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI53234519', '广州', '深圳', '24小时', '', '546.00', '234.00', '123.00', '768.00', '798.00', '周二', '342.00', '342.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '2342', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI5830512', '深圳', '海口', '24小时', '', '123.00', '343.00', '546.00', '67567.00', '123.00', '周三', '5654.00', '45.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '46456', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI60849968', '成都', '海口', '48小时', '', '8.00', '9.00', '7.00', '6.00', '5.00', '每天', '4.00', '3.00', 'D://uploadFile//airline//CL29101095_C罗.jpg', '321', 'CL29101095', '2016-01-30');
INSERT INTO `airline` VALUES ('AI63577420', '北京', '长沙', '24小时', '', '200.00', '220.00', '300.00', '500.00', '600.00', '周一二', '900.00', '400.00', 'D://uploadFile//airline//CL29101095_杨昌庆.JPG', '', 'CL29101095', '2016-02-17');
INSERT INTO `airline` VALUES ('AI67024950', '重庆', '昆明', '24小时', '', '1.00', '2.00', '3.00', '4.00', '5.00', '周一六日', '6.00', '7.00', 'D://uploadFile//airline//CL29101095_C罗.jpg', '123', 'CL29101095', '2016-01-30');
INSERT INTO `airline` VALUES ('AI73543267', '北京', '海口', '24小时', '', '567.00', '768.00', '123.00', '123.00', '546.00', '周四', '12.00', '345.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '435', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI76447818', '成都', '杭州', '24小时', '435', '32.00', '54.00', '65.00', '78.00', '123.00', '周五', '212.00', '43.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '657', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI79287941', '长沙', '三亚', '48小时', '', '9.00', '8.00', '7.00', '6.00', '5.00', '周一二三四', '4.00', '3.00', 'D://uploadFile//airline//CL29101095_C罗.jpg', '123', 'CL29101095', '2016-01-30');
INSERT INTO `airline` VALUES ('AI7965381', '重庆', '贵阳', '24小时', '', '65.00', '876.00', '234.00', '123.00', '54.00', '周六', '546.00', '23.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '42342', 'CL29101095', '2016-01-19');
INSERT INTO `airline` VALUES ('AI89526724', '广州', '长沙', '12小时', '', '1.00', '4.00', '6.00', '8.00', '9.00', '周日', '12.00', '34.00', 'D://uploadFile//airline//CL29101095_需求.JPG', '123', 'CL29101095', '2016-01-19');

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention` (
  `id` varchar(255) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `typeId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attention
-- ----------------------------
INSERT INTO `attention` VALUES ('\r\nCL7798491', '1', '2014-12-01', '\r\nCL77984982', '有效', null);
INSERT INTO `attention` VALUES ('\r\nCL7798494', '2', '2014-12-28', '\r\nCL77984982', '有更新', null);

-- ----------------------------
-- Table structure for businessclient
-- ----------------------------
DROP TABLE IF EXISTS `businessclient`;
CREATE TABLE `businessclient` (
  `id` varchar(255) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `clientName` varchar(255) DEFAULT NULL,
  `clientBusiness` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of businessclient
-- ----------------------------
INSERT INTO `businessclient` VALUES ('BU00000001', 'H201406001', '北京北大方正电子有限公司', '电子', '2015-05-10', '郑国', '13832348888', '/usr/local/iver99/testfile.txt', '无', 'CL23767471');
INSERT INTO `businessclient` VALUES ('BU00000002', 'H201406002', '深圳市德力发科技有限公司', '汽车', '2015-05-10', '陈郁', '13902382563', '/usr/local/iver99/testfile.txt', '无', 'CL23767471');
INSERT INTO `businessclient` VALUES ('BU00000003', 'H201406003', '天津怡坤车业', '汽车', '2015-05-10', '李国强', '13902385859', '/usr/local/iver99/testfile.txt', '无', 'CL23767471');
INSERT INTO `businessclient` VALUES ('BU00000004', 'H201406004', '杭州八安电子科技有限公司', '电子', '2015-05-10', '丁晓莉', '13902382416', '/usr/local/iver99/testfile.txt', '无', 'CL23767471');
INSERT INTO `businessclient` VALUES ('BU00000005', 'H201406005', '上海上久泵业制造有限公司', '汽车', '2015-05-10', '孙明明', '13902382134', '/usr/local/iver99/testfile.txt', '无', 'CL81096930');
INSERT INTO `businessclient` VALUES ('BU00000006', 'H201406006', '东莞市喜来华纶针织有限公司', '医药', '2015-05-10', '李露', '13902389639', '/usr/local/iver99/testfile.txt', '无', 'CL81096930');
INSERT INTO `businessclient` VALUES ('BU00000007', 'H201406007', '无锡强达毛毡制品有限公司', '医药', '2015-05-10', '徐立', '13902389429', '/usr/local/iver99/testfile.txt', '无', 'CL81096930');
INSERT INTO `businessclient` VALUES ('BU00000008', 'H201406008', '上海龙煌服饰有限公司', '医药', '2015-05-10', '魏义方', '13902381684', '/usr/local/iver99/testfile.txt', '无', 'CL81096930');
INSERT INTO `businessclient` VALUES ('BU00000009', 'H201406009', '科勒电器(中国)有限公司', '电子', '2015-05-10', '马国明', '13902387276', '/usr/local/iver99/testfile.txt', '无', 'CL81096930');
INSERT INTO `businessclient` VALUES ('BU00000010', 'H201406010', '中山市嘉威特电器有限公司', '电子', '2015-05-10', '王海峰', '13902387436', '/usr/local/iver99/testfile.txt', '无', 'CL78387917');
INSERT INTO `businessclient` VALUES ('BU00000011', 'H201406011', '深圳市彩世界电器有限公司', '电子', '2015-05-10', '张格', '13902388218', '/usr/local/iver99/testfile.txt', '无', 'CL78387917');
INSERT INTO `businessclient` VALUES ('BU00000012', 'H201406012', '日照市爱普电器有限公司', '电子', '2015-05-10', '胡英', '13902389194', '/usr/local/iver99/testfile.txt', '无', 'CL78387917');
INSERT INTO `businessclient` VALUES ('BU00000013', 'H201406013', '广州奇俊电子科技有限公司', '汽车', '2015-05-10', '陈卫', '13902386945', '/usr/local/iver99/testfile.txt', '无', 'CL78387917');
INSERT INTO `businessclient` VALUES ('BU00000014', 'H201406014', '佛山威视宝电子科技公司', '电子', '2015-05-10', '高文胜', '13902389691', '/usr/local/iver99/testfile.txt', '无', 'CL78387917');
INSERT INTO `businessclient` VALUES ('BU00000015', 'H201406015', '沈阳超越电气设备有限公司', '电子', '2015-05-10', '郝小洋', '13902384954', '/usr/local/iver99/testfile.txt', '无', 'CL78387917');

-- ----------------------------
-- Table structure for carinfo
-- ----------------------------
DROP TABLE IF EXISTS `carinfo`;
CREATE TABLE `carinfo` (
  `id` varchar(255) NOT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `carTeam` varchar(255) DEFAULT NULL,
  `carUse` varchar(255) DEFAULT NULL,
  `carBase` varchar(255) DEFAULT NULL,
  `carLength` float(12,2) DEFAULT NULL,
  `carWidth` float(12,2) DEFAULT NULL,
  `carHeight` float(12,2) DEFAULT NULL,
  `carWeight` float(12,2) DEFAULT NULL,
  `carState` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carType` varchar(255) DEFAULT NULL,
  `GPSID` varchar(255) DEFAULT NULL,
  `purchaseTime` date DEFAULT NULL,
  `carBrand` varchar(255) DEFAULT NULL,
  `storage` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `opRange` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carinfo
-- ----------------------------
INSERT INTO `carinfo` VALUES ('CAR00000001', '冀EKK301', '北京车队', '普通运输', '普通', '4.00', '2.00', '1.00', '3.00', '停歇', '2015-05-06', '单桥', '无', '2016-03-21', '解放', '冷藏', 'CL29101095', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000002', '冀EKK302', '北京车队', '普通运输', '普通', '4.00', '2.00', '1.00', '3.00', '在途', '2016-02-02', '单桥', '无', '2016-03-14', '解放', '否', 'CL29101095', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000003', '冀EKK303', '北京车队', '普通运输', '普通', '4.00', '2.00', '1.00', '3.00', '在途', '2016-02-01', '单桥', '无', '2016-03-20', '东风', '否', 'CL29101095', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000004', '冀EKK304', '北京车队', '普通运输', '普通', '4.00', '2.00', '1.00', '3.00', '停歇', '2016-01-31', '单桥', '无', '2016-03-01', '东风', '否', 'CL29101095', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000015', '豫EL1915', '北京车队', '普通运输', '箱式', '4.50', '2.00', '1.00', '8.00', '在途', '2015-05-06', '其他', '无', '2015-05-20', '解放', '否', 'CL29101095', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000016', '浙A61623', '北京车队', '普通运输', '平板', '4.50', '2.00', '1.00', '8.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '解放', '否', 'CL29101095', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000017', '鲁RED183', '北京车队', '普通运输', '高栏', '5.00', '2.00', '1.50', '20.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '解放', '否', 'CL29101095', '武汉');
INSERT INTO `carinfo` VALUES ('CAR00000018', '沪B79235', '北京车队', '普通运输', '普通', '10.00', '2.00', '1.50', '12.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '解放', '否', 'CL29101095', '上海');
INSERT INTO `carinfo` VALUES ('CAR00000035', '沪AT3483', '天津车队', '普通运输', '箱式', '6.20', '2.00', '1.50', '10.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '福田', '否', 'CL73207711', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000036', '沪B06048', '天津车队', '普通运输', '箱式', '10.00', '2.00', '1.50', '16.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL73207711', '武汉');
INSERT INTO `carinfo` VALUES ('CAR00000037', '苏B55329', '天津车队', '普通运输', '平板', '6.20', '2.00', '1.50', '16.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '福田', '否', 'CL73207711', '上海');
INSERT INTO `carinfo` VALUES ('CAR00000038', '苏B55392', '天津车队', '普通运输', '平板', '12.00', '2.00', '1.50', '16.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL73207711', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000039', '皖KC2202', '天津车队', '普通运输', '高栏', '6.20', '2.00', '1.50', '10.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '福田', '否', 'CL73207711', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000040', '皖S37893', '上海车队', '普通运输', '高栏', '12.00', '2.00', '1.50', '10.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '福田', '否', 'CL73207711', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000041', '翼B94984', '上海车队', '普通运输', '平板', '10.00', '2.00', '1.50', '10.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '福田', '否', 'CL73207711', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000042', '浙H02987', '上海车队', '普通运输', '普通', '10.00', '2.00', '1.50', '8.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL73207711', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000043', '沪B89948', '上海车队', '普通运输', '箱式', '12.00', '3.00', '2.00', '8.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL73207711', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000044', '沪BL7183', '上海车队', '普通运输', '高栏', '6.80', '3.00', '2.00', '10.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL73207711', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000045', '沪D15262', '上海车队', '普通运输', '平板', '14.00', '3.00', '2.00', '10.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL73207711', '武汉');
INSERT INTO `carinfo` VALUES ('CAR00000046', '吉AB2211', '北京车队', '普通运输', '高栏', '6.80', '3.00', '2.00', '15.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL73207711', '上海');
INSERT INTO `carinfo` VALUES ('CAR00000047', '京AH7112', '北京车队', '普通运输', '高栏', '14.00', '3.00', '2.00', '12.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL73207711', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000075', '川B71460', '上海车队', '普通运输', '高栏', '14.00', '3.00', '2.00', '30.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '东风', '否', 'CL41403136', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000076', '鲁B46330', '上海车队', '普通运输', '箱式', '9.00', '3.00', '2.00', '10.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL41403136', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000077', '鲁BD8998', '上海车队', '普通运输', '高栏', '9.00', '3.00', '2.00', '10.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL41403136', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000078', '鲁R07772', '上海车队', '普通运输', '高栏', '9.00', '3.00', '2.00', '10.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '东风', '否', 'CL41403136', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000079', '鲁U93290', '天津车队', '普通运输', '箱式', '9.00', '3.00', '2.00', '10.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL41403136', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000080', '鲁U95829', '天津车队', '普通运输', '箱式', '9.00', '3.00', '2.00', '10.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL41403136', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000081', '蒙D17802', '天津车队', '普通运输', '高栏', '9.00', '3.00', '2.00', '18.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '东风', '否', 'CL41403136', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000082', '苏JN1997', '天津车队', '普通运输', '高栏', '9.00', '3.00', '2.00', '10.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '福田', '否', 'CL41403136', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000083', '赣G32403', '天津车队', '普通运输', '箱式', '9.60', '3.00', '2.00', '12.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '东风', '否', 'CL41403136', '上海');
INSERT INTO `carinfo` VALUES ('CAR00000084', '鲁LA2578', '天津车队', '普通运输', '平板', '9.60', '3.00', '2.00', '15.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '东风', '否', 'CL41403136', '武汉');
INSERT INTO `carinfo` VALUES ('CAR00000098', '鲁M95795', '天津车队', '普通运输', '高栏', '13.00', '2.50', '4.00', '30.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '东风', '否', 'CL41403136', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000099', '赣F86360', '天津车队', '普通运输', '箱式', '14.00', '4.00', '5.00', '20.00', '停歇', '2015-05-06', '其他', '无', '2015-05-20', '东风', '否', 'CL41403136', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000100', '军V12009', '北京车队', '普通运输', '高栏', '16.50', '4.00', '5.00', '40.00', '停歇', '2015-05-06', '单桥', '无', '2015-05-20', '东风', '否', 'CL41403136', '西安');
INSERT INTO `carinfo` VALUES ('CAR33817494', '豫7834', '河北车队', '普通运输', '厢式', '12.00', '3.60', '8.60', '34.00', '停歇', '2016-03-31', '单桥', '12324235435', '2016-03-14', '东风', '冷藏', 'CL29101095', '河南 郑州');
INSERT INTO `carinfo` VALUES ('CAR72767431', '豫23456', '河北车队', '特殊', '普通', '12.00', '4.50', '5.60', '14.00', '停歇', '2016-03-31', '单桥', '123456789', '2016-03-25', '解放', '非冷藏', 'CL29101095', '河北');
INSERT INTO `carinfo` VALUES ('CAR76079068', '豫4234235', '河北车队', '特殊', '厢式', '32.00', '345.00', '345.00', '345.00', '停歇', '2016-03-31', '前四后四', '234', '2016-03-20', '解放', '非冷藏', 'CL29101095', '53453');

-- ----------------------------
-- Table structure for carrierinfo
-- ----------------------------
DROP TABLE IF EXISTS `carrierinfo`;
CREATE TABLE `carrierinfo` (
  `id` varchar(255) NOT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `companyAccount` varchar(255) DEFAULT NULL,
  `companyContact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `resourceRate` varchar(255) DEFAULT NULL,
  `creditRate` int(11) DEFAULT NULL,
  `depositCondition` int(11) DEFAULT NULL,
  `invoiceKind` varchar(255) DEFAULT NULL,
  `companyAddr` varchar(255) DEFAULT NULL,
  `companyScale` varchar(255) DEFAULT NULL,
  `serviceIndustry` varchar(255) DEFAULT NULL,
  `companyType` varchar(255) DEFAULT NULL,
  `relDate` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `line` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `warehouse` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carrierinfo
-- ----------------------------
INSERT INTO `carrierinfo` VALUES ('CL23326715', 'xiaotian', null, '1213', '15510001873', null, null, null, null, '12345', '1-50人', null, '国有企业', '2015-12-26 17:52:16', null, null, null, null, '未验证');
INSERT INTO `carrierinfo` VALUES ('CL28817560', null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '未验证');
INSERT INTO `carrierinfo` VALUES ('CL29101095', '北京索契物流有限公司', 'account3', '李四', '16525456565', '自有', '2', '1', '增值税', '北京市海淀区', '100-500人', '电子', '外资企业', '2015-01-31 00:00:00', '', '0', '1', '0', '已验证');
INSERT INTO `carrierinfo` VALUES ('CL41403136', '济南德顺物流有限公司', 'account5', '王楠', '13321525658', '自有', '2', '1', '增值税', '山东省济南市', '50-100人', '汽车', '私营企业', '2014-10-31 00:00:00', '', '1', '0', '0', '未验证');
INSERT INTO `carrierinfo` VALUES ('CL73207711', '天津友达通有限公司', 'account4', '张敏', '15452545454', '外围', '1', '1', '增值税', '天津市河西区', '50-100人', '汽车', '私营企业', '2015-03-03 00:00:00', '', '1', '1', '0', '已验证');
INSERT INTO `carrierinfo` VALUES ('CL95951576', 'datian', null, '123123', '15510001873', null, null, null, null, '432543253', '500人以上', null, '国有企业', '2015-12-26 16:52:37', null, null, null, null, '未验证');

-- ----------------------------
-- Table structure for carteam
-- ----------------------------
DROP TABLE IF EXISTS `carteam`;
CREATE TABLE `carteam` (
  `id` varchar(255) NOT NULL,
  `teamName` varchar(255) DEFAULT NULL,
  `carCount` varchar(255) DEFAULT NULL,
  `chief` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `explaination` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carteam
-- ----------------------------
INSERT INTO `carteam` VALUES ('CT00000002', '上海车队', '5', '金荣汉', '13999261880', '2015-04-22', '无', 'CL73207711 ');
INSERT INTO `carteam` VALUES ('CT00000003', '天津车队', '5', '张明远', '15201112342', '2015-04-21', '无', 'CL41403136');
INSERT INTO `carteam` VALUES ('CT53043564', '北京车队', '8', '杨昌庆', '15051881383', '2016-03-31', '有一个试试', 'CL29101095');
INSERT INTO `carteam` VALUES ('CT71804384', '河北车队', '3', '高畅', '15510001873', '2016-03-03', '高畅的车队的车队', 'CL29101095');
INSERT INTO `carteam` VALUES ('CT97344135', '河南车队', '0', '杨昌庆', '15051881383', '2016-03-03', '我的车队', 'CL29101095');

-- ----------------------------
-- Table structure for cityline
-- ----------------------------
DROP TABLE IF EXISTS `cityline`;
CREATE TABLE `cityline` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cityName` varchar(255) DEFAULT NULL,
  `refPrice` float(10,2) DEFAULT NULL,
  `standPrice1` float(10,2) DEFAULT NULL,
  `standPrice2` float(10,2) DEFAULT NULL,
  `pickFee` float(10,2) DEFAULT NULL,
  `deliveryFee` float(10,2) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `VIPService` varchar(255) DEFAULT NULL,
  `detailPrice` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `VIPDetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cityline
-- ----------------------------
INSERT INTO `cityline` VALUES ('CI00000001', '北京城市配送', '北京', '2.10', '1.00', '2.00', '3.00', '4.00', '2015-05-04', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000009', '青岛城市配送', '青岛', '2.10', '4.00', '3.00', '2.00', '1.00', '2015-03-24', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000010', '大连城市配送', '大连', '2.20', '3.00', '2.00', '1.00', '4.00', '2015-05-04', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000011', '武汉城市配送', '武汉', '1.80', '4.00', '5.00', '6.00', '7.00', '2015-05-04', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000012', '石家庄城市配送', '石家庄', '1.80', '2.00', '4.00', '7.00', '9.00', '2015-05-05', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000013', '成都城市配送', '成都', '1.80', '2.00', '5.00', '6.00', '6.00', '2015-05-06', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000014', '太原城市配送', '太原', '1.80', '43.00', '4.00', '4.00', '4.00', '2015-05-07', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000015', null, '兰州', null, '5.00', '6.00', '7.00', '2.00', '2015-05-08', 'CL29101095', '有', 'D://uploadFile//cityline//CL29101095_我的.JPG', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸');
INSERT INTO `cityline` VALUES ('CI00000016', '厦门城市配送', '厦门', '1.80', '9.00', '3.00', '1.00', '3.00', '2015-03-24', 'CL29101095', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000017', '杭州城市配送', '杭州', '1.90', '4.00', '5.00', '6.00', '1.00', '2015-03-25', 'CL73207711', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000029', '索契青岛城市配送', '索契', '1.60', '5.00', '6.00', '7.00', '8.00', '2015-03-24', 'CL73207711', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000030', '索契大连城市配送', '索契大连', '1.60', '3.00', '6.00', '8.00', '2.00', '2015-05-04', 'CL73207711', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000031', '友达北京城市配送', '友达北京', '1.50', '5.00', '7.00', '8.00', '2.00', '2015-05-04', 'CL73207711', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000032', '友达通重庆城市配送', '友达通重庆', '1.50', '4.00', '5.00', '6.00', '6.00', '2015-05-04', 'CL73207711', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000033', '友达通深圳城市配送', '友达通深圳', '1.50', '3.00', '5.00', '2.00', '1.00', '2015-03-24', 'CL73207711', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000034', '友达通上海城市配送', '友达通上海', '1.50', '5.00', '6.00', '7.00', '7.00', '2015-03-24', 'CL73207711', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000035', '友达通苏州城市配送', '友达通苏州', '1.50', '1.00', '4.00', '4.00', '98.00', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000036', '友达通广州城市配送', '友达通广州', '1.60', '4.00', '3.00', '78.00', '98.00', '2015-03-24', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000037', '友达通南京城市配送', '友达通南京', '1.60', '3.00', '5.00', '8.00', '54.00', '2015-03-24', 'CL41403136', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000038', '友达通天津城市配送', '友达通天津', '1.60', '4.00', '6.00', '34.00', '323.00', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000039', '友达通青岛城市配送', '友达通青岛', '1.60', '5.00', '4.00', '787.00', '12.00', '2015-03-24', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000040', '友达通大连城市配送', '友达通大连', '1.60', '6.00', '6.00', '8.00', '5.00', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000041', '天凯顺武汉城市配送', '天凯顺武汉', '2.00', '2.00', '6.00', '88.00', '2.00', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000042', '天凯顺石家庄城市配送', '天凯顺石家庄', '2.00', '7.00', '56.00', '8787.00', '1.00', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI52999060', null, '南昌', null, '123.00', '456.00', '789.00', '987.00', '2016-04-03', 'CL29101095', '无', 'D://uploadFile//cityline//CL29101095_杨昌庆.JPG', '123', '');
INSERT INTO `cityline` VALUES ('CI54170702', null, '重庆', null, '1.00', '2.00', '3.00', '4.00', '2016-03-10', 'CL29101095', '无', 'D://uploadFile//cityline//CL29101095_2-21.PNG', '我是新加的', '');

-- ----------------------------
-- Table structure for clientinfo
-- ----------------------------
DROP TABLE IF EXISTS `clientinfo`;
CREATE TABLE `clientinfo` (
  `id` varchar(255) NOT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `IDCard` varchar(255) DEFAULT NULL,
  `IDPicture` varchar(255) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientinfo
-- ----------------------------
INSERT INTO `clientinfo` VALUES ('C-0002', '郝晨栋', '男', '123123', null, '', '/usr/local/iver99/testfile.txt', '2015-05-31', null, null);
INSERT INTO `clientinfo` VALUES ('CL1042656', null, null, '15510001873', null, null, null, '2015-12-26', null, null);
INSERT INTO `clientinfo` VALUES ('CL23767471', '郝晨栋', '男', '18888237738', '1233@163.com', '130203199001011234', '/usr/local/iver99/testfile.txt', '2015-05-31', null, null);
INSERT INTO `clientinfo` VALUES ('CL36962557', null, null, '15510001873', null, null, null, '2015-11-29', null, null);
INSERT INTO `clientinfo` VALUES ('CL46347201', null, null, '', null, null, null, '2015-12-26', null, null);
INSERT INTO `clientinfo` VALUES ('CL51580516', '123', '男', '15510001873', null, '411381199104234518', 'D://uploadFile//client//CL51580516_C罗.jpg', '2015-12-26', null, null);
INSERT INTO `clientinfo` VALUES ('CL53447782', null, null, '', null, null, null, '2015-12-30', null, null);
INSERT INTO `clientinfo` VALUES ('CL68255710', null, null, '', null, null, null, '2015-12-26', null, null);
INSERT INTO `clientinfo` VALUES ('CL78387917', '苏磊', '男', '13293049303', 'sulei@163.com', '130203199001011236', '/usr/local/iver99/testfile.txt', '2015-06-06', null, null);
INSERT INTO `clientinfo` VALUES ('CL81096930', '雷文雅', '女', '1832938483', 'leiwenya@163.com', '130203199001011235', '/usr/local/iver99/testfile.txt', '2015-06-06', null, null);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(255) NOT NULL,
  `orderId` varchar(255) DEFAULT NULL,
  `orderNum` varchar(255) DEFAULT NULL,
  `serviceAttitude` varchar(11) DEFAULT NULL,
  `transportEfficiency` varchar(11) DEFAULT NULL,
  `cargoSafety` varchar(11) DEFAULT NULL,
  `totalMoney` varchar(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carId` varchar(11) DEFAULT NULL,
  `linetransportId` varchar(11) DEFAULT NULL,
  `citylineId` varchar(11) DEFAULT NULL,
  `warehouseId` varchar(11) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('AS2211219', 'OR84043492', 'y95698591', '好', '一般', '很好', '好', '这是一条测试评论', '2015-06-20', null, null, null, null, 'CL23767471', 'CL29101095');
INSERT INTO `comment` VALUES ('AS31954621', 'OR73987978', null, '好', '很好', '好', null, '很好', '2016-03-31', null, null, null, null, 'CL23767471', 'CL29101095');
INSERT INTO `comment` VALUES ('AS46647679', 'OR84042943', 'y24357612', '一般', '很好', '很好', '很好', 'test', '2015-12-26', null, null, null, null, 'CL23767471', 'CL29101095');
INSERT INTO `comment` VALUES ('AS553450', 'OR18822550', null, '很好', '很好', '很好', null, '12345678', '2016-03-08', null, null, null, null, 'CL23767471', 'CL29101095');
INSERT INTO `comment` VALUES ('AS61374799', 'OR77562450', 'y25369539', '好', '很好', '一般', '好', '这是一条测试评论', '2015-06-20', null, null, null, null, 'CL23767471', 'CL29101095');
INSERT INTO `comment` VALUES ('AS69878114', 'OR28338057', null, '很好', '很好', '很好', null, '123', '2016-02-02', null, null, null, null, 'CL23767471', 'CL29101095');
INSERT INTO `comment` VALUES ('AS74550610', 'OR735105', null, '很好', '很好', '好', null, '', '2016-02-17', null, null, null, null, 'CL23767471', 'CL29101095');

-- ----------------------------
-- Table structure for companycertificate
-- ----------------------------
DROP TABLE IF EXISTS `companycertificate`;
CREATE TABLE `companycertificate` (
  `id` varchar(255) NOT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `divisionCode` varchar(255) DEFAULT NULL,
  `legalName` varchar(255) DEFAULT NULL,
  `legalIDCard` varchar(255) DEFAULT NULL,
  `companyAddr` varchar(255) DEFAULT NULL,
  `companyType` varchar(255) DEFAULT NULL,
  `companyScale` varchar(255) DEFAULT NULL,
  `invoiceKind` varchar(255) DEFAULT NULL,
  `serviceIndustry` varchar(255) DEFAULT NULL,
  `businessKind` varchar(255) DEFAULT NULL,
  `companyContact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `basicSituation` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of companycertificate
-- ----------------------------
INSERT INTO `companycertificate` VALUES ('CL23326715', 'xiaotian', '54321', null, null, '12345', '国有企业', '1-50人', null, null, '整车', '1213', null, '15510001873', null, 'D://uploadFile//companyCertificate//CL23326715_新建文本文档.txt');
INSERT INTO `companycertificate` VALUES ('CL28817560', null, null, null, null, null, null, null, null, null, null, null, null, '', null, null);
INSERT INTO `companycertificate` VALUES ('CL29101095  ', '北京东方之星货运公司', 'DM32293222', '翟博渊', '12343234323232', '北京市海淀区交大东路', '国有企业', '1-50人', '增值税发票', '医药', '干线运输线路,城市配送网络', '翟博渊', null, '13298766695', '准备上市', 'D://uploadFile//companyCertificate//CL29101095_datian上线6-3.sql');
INSERT INTO `companycertificate` VALUES ('CL41403136', '上海德邦物流公司', 'DM32293222', '翟博渊', '12343234323232', '北京市海淀区交大东路', '合资企业', '50-200人', '非增值税发票', '电子', '干线运输线路,城市配送网络,仓储', '翟博渊', null, '13298766695', '准备扩大公司规模', 'D://uploadFile//companyCertificate//CL41403136_datian上线6-2.sql');
INSERT INTO `companycertificate` VALUES ('CL73207711', '上海德邦物流公司', 'DM23232311', '翟博眼', '123213234234', '上海市', '国有企业', '50-200人', '非增值税发票', '电子', '干线运输线路,城市配送网络', '翟博渊', null, '19237234234', '准备上市', 'D://uploadFile//companyCertificate//CL73207711_datian测试版.sql');

-- ----------------------------
-- Table structure for complaintform
-- ----------------------------
DROP TABLE IF EXISTS `complaintform`;
CREATE TABLE `complaintform` (
  `id` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `orderNum` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complaintform
-- ----------------------------
INSERT INTO `complaintform` VALUES ('CI20800839', '服务', 'test', '还行', '2016-02-29', '已受理', 'y85690762', '/usr/local/uploadFile/complaint//CL23767471_C罗.jpg', '好的，投诉很好', 'CL23767471', 'CL23767471');
INSERT INTO `complaintform` VALUES ('CI21800839', '服务', 'test2', 'yes', '2016-03-03', '已受理', 'y85671234', '123', '很伟大', 'CL29101095', 'CL29101095');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `carrierAccount` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '合同创建时间',
  `time` int(11) DEFAULT NULL,
  `caculateType` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `monthlyStatementDays` varchar(255) DEFAULT NULL COMMENT '月结情况下的时间长度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('CO00000001', '运输合同', '北京市畅通达有限公司', '2015-01-25', '2015-02-25', null, null, '月结', '张明远', '15201112342', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL29101095', '已终止', ' 特殊原因', '30天');
INSERT INTO `contract` VALUES ('CO00000002', '运输合同', '北京圆通有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '李义达', '15929983120', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL29101095', '已过期', '', '30天');
INSERT INTO `contract` VALUES ('CO00000003', '运输合同', '北京索契物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '陈明', '13187340989', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000004', '运输合同', '天津友达通有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '王国权', '15151288481', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL29101095', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000005', '运输合同', '济南德顺物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '王亮', '18936991920', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL41403136', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000006', '运输合同', '扬州万泰物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '金荣汉', '13999261880', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL29101095', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000007', '运输合同', '广州市远泰物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '章翠秀', '13951590393', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL29101095', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000008', '运输合同', '通捷恒远物流', '2015-02-01', '2016-01-31', null, null, '月结', '孙兆峰', '13064818806', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000009', '运输合同', '天津天凯顺物流公司', '2015-02-01', '2016-01-31', null, null, '月结', '张瑜', '15630837858', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000010', '运输合同', '天津昌茂物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '朱彦冬', '13505220530', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000011', '运输合同', '北京市畅通达有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '梁文汉', '13902382915', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000012', '运输合同', '北京圆通有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '徐刚', '13902385181', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000013', '运输合同', '北京索契物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '李子佼', '13902389834', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000014', '运输合同', '天津友达通有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '王强', '13902384771', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL41403136', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000015', '运输合同', '济南德顺物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '丁一鸣', '13902384702', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000016', '运输合同', '扬州万泰物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '张元平', '13902385294', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000017', '运输合同', '广州市远泰物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '王一帆', '13902385631', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL29101095', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000018', '运输合同', '通捷恒远物流', '2015-02-01', '2016-01-31', null, null, '月结', '傅彬', '13902383675', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000019', '运输合同', '天津天凯顺物流公司', '2015-02-01', '2016-01-31', null, null, '月结', '李艳', '13902380989', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000020', '运输合同', '天津昌茂物流有限公司', '2015-02-01', '2016-01-31', null, null, '月结', '刘欣瑜', '13902382601', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '30天');

-- ----------------------------
-- Table structure for driverinfo
-- ----------------------------
DROP TABLE IF EXISTS `driverinfo`;
CREATE TABLE `driverinfo` (
  `id` varchar(255) NOT NULL,
  `driverName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `licenceRate` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `IDCard` varchar(255) DEFAULT NULL,
  `licenceNum` varchar(255) DEFAULT NULL,
  `licenceTime` date DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `carId` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `idscans` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT '空闲',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driverinfo
-- ----------------------------
INSERT INTO `driverinfo` VALUES ('DR00000023', '汪家根', '男', '41', 'A', '13010310005', '2015-05-16', '120101197702093290', '510400514547', '2007-08-03', 'CL29101095', 'CAR00000023', '', '/usr/local/iver99/testfile.txt', '13010310005', '已分配');
INSERT INTO `driverinfo` VALUES ('DR00000024', '胡锦峰', '男', '27', 'A', '13829970912', '2015-05-16', '420101198204018197', '510400514547', '2011-05-06', 'CL29101095', 'CAR00000024', '', '/usr/local/iver99/testfile.txt', null, '已分配');
INSERT INTO `driverinfo` VALUES ('DR00000025', '冯西德', '男', '38', 'A', '13010310010', '2015-05-16', '120101197702098411', '230101082684', '2007-02-28', 'CL29101095', 'CAR00000025', '', '/usr/local/iver99/testfile.txt', null, '已分配');
INSERT INTO `driverinfo` VALUES ('DR00000026', '王成龙', '男', '26', 'A', '13829659039', '2015-05-16', '42010119820401513X', '220100796814', '2006-03-12', 'CL29101095', 'CAR00000026', '', '/usr/local/iver99/testfile.txt', null, '已分配');
INSERT INTO `driverinfo` VALUES ('DR00000027', '邓中元', '男', '39', 'A', '13829813809', '2015-05-16', '420101198204018218', '110008685523', '2011-09-23', 'CL29101095', 'CAR00000027', '', '/usr/local/iver99/testfile.txt', null, '已分配');
INSERT INTO `driverinfo` VALUES ('DR00000028', '恽赛虹', '男', '33', 'A', '13980400024', '2015-05-16', '410106198312035752', '231100633466', '2008-05-06', 'CL29101095', 'CAR00000028', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000029', '李英铭', '男', '38', 'A', '13016429091', '2015-05-16', '110101197405012130', '110008685523', '2008-04-01', 'CL29101095', 'CAR00000029', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000030', '陈新峰', '男', '47', 'A', '13829973945', '2015-05-16', '340101197708045477', '220100796814', '2006-03-12', 'CL29101095', 'CAR00000030', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000031', '曾俊波', '男', '39', 'A', '13016284720', '2015-05-16', '120101197702092538', '230101082684', '2007-02-28', 'CL29101095', 'CAR00000031', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000032', '郭锦宁', '男', '29', 'A', '13829094612', '2015-05-16', '420101198204012131', '231100633466', '2010-12-18', 'CL29101095', 'CAR00000032', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000033', '王海', '男', '28', 'A', '13010310000', '2015-05-16', '120101197702095691', '110008685523', '2011-09-23', 'CL29101095', 'CAR00000033', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000034', '夏歌', '男', '31', 'A', '13862380001', '2015-05-16', '210101198010155573', '220100796814', '2006-03-12', 'CL73207711', 'CAR00000034', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000035', '张敏坚', '男', '26', 'A', '13829058690', '2015-05-16', '420101198204016693', '230101082684', '2010-10-09', 'CL73207711', 'CAR00000035', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000036', '吴烜', '男', '30', 'A', '13512299008', '2015-05-16', '110101197405018890', '230101082684', '2007-02-28', 'CL73207711', 'CAR00000036', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000037', '王振基', '男', '45', 'A', '13010310001', '2015-05-16', '120101197702092992', '231100633466', '2008-05-06', 'CL73207711', 'CAR00000037', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000038', '崔敬柱', '男', '28', 'A', '13016369950', '2015-05-16', '11010119740501315X', '230101082684', '2010-10-09', 'CL73207711', 'CAR00000038', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000039', '王现涛', '男', '36', 'A', '13016015981', '2015-05-16', '110101197405012974', '231100633466', '2010-12-18', 'CL73207711', 'CAR00000039', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000040', '累林', '男', '32', 'A', '13829452089', '2015-05-16', '210101198010157472', '231100633466', '2008-05-06', 'CL73207711', 'CAR00000040', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000041', '石向东', '男', '31', 'A', '13829840784', '2015-05-16', '210101198010153594', '510400514547', '2007-08-03', 'CL73207711', 'CAR00000041', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000053', '王靖', '女', '32', 'A', '13980400042', '2015-05-16', '410106198312035517', '220100796814', '2004-09-15', 'CL73207711', 'CAR00000053', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000054', '刘俸岐', '男', '30', 'A', '13829578076', '2015-05-16', '340101197708042110', '110008685523', '2011-09-23', 'CL73207711', 'CAR00000054', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000055', '程树林', '男', '38', 'A', '13829676258', '2015-05-16', '340101197708047333', '230101082684', '2007-02-28', 'CL73207711', 'CAR00000055', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000064', '王军', '男', '38', 'A', '13016113492', '2015-05-16', '11010119740501171X', '231100633466', '2008-05-06', 'CL73207711', 'CAR00000064', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000065', '周智鹏', '男', '31', 'A', '13829854993', '2015-05-16', '420101198204014815', '510400514547', '2007-08-03', 'CL73207711', 'CAR00000065', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000066', '孙璐', '男', '39', 'A', '13829902823', '2015-05-16', '420101198204015973', '220100796814', '2006-03-12', 'CL73207711', 'CAR00000066', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000067', '詹志兵', '男', '32', 'A', '13829824963', '2015-05-16', '41010619831203133X', '230101082684', '2010-10-09', 'CL73207711', 'CAR00000067', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000068', '杨园禾', '男', '26', 'A', '13829634842', '2015-05-16', '340101197708041898', '220100796814', '2006-03-12', 'CL41403136', 'CAR00000068', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000069', '廖水金', '男', '47', 'A', '13817550007', '2015-05-16', '120101197702095819', '231100633466', '2008-05-06', 'CL41403136', 'CAR00000069', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000070', '陈凯', '男', '39', 'A', '13829475321', '2015-05-16', '340101197708041230', '230101082684', '2010-10-09', 'CL41403136', 'CAR00000070', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000071', '刘飞', '男', '36', 'A', '13817550017', '2015-05-16', '21010119801015743X', '110008685523', '2008-04-01', 'CL41403136', 'CAR00000071', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000072', '冯少斌', '男', '32', 'A', '13016851918', '2015-05-16', '110101197405018559', '110008685523', '2008-04-01', 'CL41403136', 'CAR00000072', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000073', '庄连杰', '男', '32', 'A', '13010310017', '2015-05-16', '120101197702099377', '510400514547', '2011-05-06', 'CL41403136', 'CAR00000073', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000074', '孙灿', '男', '27', 'A', '13662500001', '2015-05-16', '210101198010152073', '231100633466', '2010-12-18', 'CL41403136', 'CAR00000074', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000075', '王长海', '男', '47', 'A', '13829571887', '2015-05-16', '42010119820401919X', '230101082684', '2010-10-09', 'CL41403136', 'CAR00000075', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000076', '李志江', '男', '29', 'A', '13829135183', '2015-05-16', '340101197708045290', '110008685523', '2008-04-01', 'CL41403136', 'CAR00000076', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000077', '杨茂东', '男', '32', 'A', '13817550010', '2015-05-16', '120101197702092079', '510400514547', '2007-08-03', 'CL41403136', 'CAR00000077', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000078', '李春晟', '男', '32', 'A', '13509180007', '2015-05-16', '210101198010159814', '230101082684', '2007-02-28', 'CL41403136', 'CAR00000078', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000079', '胡长志', '男', '31', 'A', '13509180005', '2015-05-16', '210101198010159291', '220100796814', '2004-09-15', 'CL41403136', 'CAR00000079', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR00000100', '楚晓', '男', '29', 'A', '13662500005', '2015-05-16', '210101198010151150', '510400514547', '2011-05-06', 'CL41403136', 'CAR00000100', '', '/usr/local/iver99/testfile.txt', null, '空闲');
INSERT INTO `driverinfo` VALUES ('DR84502567', '赵平', '男', null, 'A', '13920263841', '2016-02-17', '122', '111', '2016-02-11', 'CL29101095', null, null, 'D://uploadFile//driver//CL29101095_任务.PNG', null, '空闲');

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus` (
  `id` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `focusType` varchar(255) DEFAULT NULL,
  `focusId` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of focus
-- ----------------------------
INSERT INTO `focus` VALUES ('F98965525', 'CL23767471', 'fulltruckload', 'TR16858286', '有效');
INSERT INTO `focus` VALUES ('F4988784', 'CL23767471', 'lesstruckload', 'TR3242733', '有效');
INSERT INTO `focus` VALUES ('F80692079', 'CL23767471', 'cityline', 'CI00000015', '有效');
INSERT INTO `focus` VALUES ('F46154314', 'CL23767471', 'airline', 'AI1759857', '有效');
INSERT INTO `focus` VALUES ('F6106062', 'CL23767471', 'airline', 'AI48181548', '有效');
INSERT INTO `focus` VALUES ('F35703822', 'CL29101095', 'fulltruckload', 'TR8682032', '有效');
INSERT INTO `focus` VALUES ('F87737106', 'CL23767471', 'fulltruckload', 'TR89734702', '有效');
INSERT INTO `focus` VALUES ('F77849443', 'CL23767471', 'linetransport', 'TR41285958', '有效');
INSERT INTO `focus` VALUES ('F29062839', 'CL23767471', 'fulltruckload', 'TR42400981', '有效');
INSERT INTO `focus` VALUES ('F67383833', 'CL29101095', 'linetransport', 'TR13397509', '有效');
INSERT INTO `focus` VALUES ('F4695764', 'CL23767471', 'goods', 'GO25177997', '有效');
INSERT INTO `focus` VALUES ('F79042696', 'CL23767471', 'linetransport', 'TR13397509', '有效');
INSERT INTO `focus` VALUES ('F33333405', 'CL23767471', 'fulltruckload', 'TR13397509', '有效');

-- ----------------------------
-- Table structure for goodsform
-- ----------------------------
DROP TABLE IF EXISTS `goodsform`;
CREATE TABLE `goodsform` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `transportType` varchar(255) DEFAULT NULL,
  `weight` float(10,0) DEFAULT NULL,
  `startPlace` varchar(255) DEFAULT NULL,
  `endPlace` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `limitDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `transportReq` varchar(255) DEFAULT NULL,
  `damageReq` varchar(255) DEFAULT NULL,
  `VIPService` varchar(255) DEFAULT NULL,
  `VIPServiceDetail` varchar(255) DEFAULT NULL,
  `oriented` varchar(255) DEFAULT NULL,
  `feedbackQuantity` int(11) DEFAULT '0',
  `invoice` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `goodsDes` varchar(255) DEFAULT NULL,
  `feeReq` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsform
-- ----------------------------
INSERT INTO `goodsform` VALUES ('GO00000017', '日照到徐州货源', '医药', '整车', '12', '莒县', '沛县', '2015-04-15', '2015-04-24', '2015-04-15', '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '1', '不需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL23767471', '', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000018', '赤峰到乌兰浩特货源', '医药', '整车', '40', '天山', '扎兰屯', '2015-04-15', '2015-04-24', '2015-04-15', '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL23767471', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿', null, null);
INSERT INTO `goodsform` VALUES ('GO00000033', '松原到青岛货源', '医药', '零担', '1', '扶余', '青岛', '2015-04-15', '2015-04-24', '2015-04-15', '可拼车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿', null, null);
INSERT INTO `goodsform` VALUES ('GO00000034', '宝应到兰州货源', '电子仪器', '整车', '38', '宝应', '兰州', '2015-04-15', '2015-04-24', '2015-04-15', '车长13米，高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000035', '张家港到赤峰货源', '电子仪器', '整车', '29', '张家港', '赤峰', '2015-01-26', '2015-01-29', '2015-01-26', '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL81096930', 'CL29101095', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000037', '邯郸到唐山货源', '服装', '整车', '80', '邯郸', '唐山', '2015-01-26', '2015-01-29', '2015-01-26', '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿', null, null);
INSERT INTO `goodsform` VALUES ('GO00000038', '胶州到莱芜货源', '服装', '整车', '40', '胶州', '莱芜', '2015-01-26', '2015-01-29', '2015-01-26', '平板车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL78387917', '', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000039', '静宁到敦煌货源', '服装', '整车', '11', '静宁', '敦煌', '2015-01-26', '2015-01-29', '2015-01-26', '6.6米高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL78387917', 'CL29101095', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000040', '成都到宜宾货源', '服装', '整车', '10', '成都', '宜宾', '2015-01-26', '2015-01-29', '2015-01-26', '6.8米高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL78387917', 'CL73207711', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿', null, null);
INSERT INTO `goodsform` VALUES ('GO25177997', '钟表', null, null, null, null, null, '2016-02-17', '2016-03-31', '2016-02-17', '一定要有妥善的包装保护措施', null, null, null, null, '0', null, '/usr/local/uploadFile/goods//CL23767471_wrist_watch_by_kaizoro-d5nrugm.png', '待确认', 'CL23767471', null, '最好在本月底前反馈', '体积较大，重量都很轻，大概1000件左右', '5000元以内');
INSERT INTO `goodsform` VALUES ('GO58685609', 'test', null, null, null, null, null, '2016-01-27', '2016-01-31', '2016-01-27', '456', null, null, null, null, '0', null, 'D://uploadFile//goods//CL23767471_C罗.jpg', '待确认', 'CL23767471', null, '123', '123', '789');

-- ----------------------------
-- Table structure for linetransport
-- ----------------------------
DROP TABLE IF EXISTS `linetransport`;
CREATE TABLE `linetransport` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `lineName` varchar(255) DEFAULT NULL,
  `startPlace` varchar(255) DEFAULT NULL,
  `endPlace` varchar(255) DEFAULT NULL,
  `onWayTime` int(11) DEFAULT NULL,
  `refPrice` float(10,0) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `detailPrice` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linetransport
-- ----------------------------
INSERT INTO `linetransport` VALUES ('LI00000003', '上海到广州', '上海', '广州', '24', '1', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000004', '苏州到北京', '苏州', '北京', '36', '3', '2015-05-30', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000005', '天津到大连', '天津', '大连', '12', '2', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000007', '广州到重庆', '广州', '重庆', '36', '3', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000008', '青岛到北京', '青岛', '北京', '12', '2', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000009', '青岛到苏州', '青岛', '苏州', '24', '1', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000010', '青岛到深圳', '青岛', '深圳', '36', '3', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000011', '北京到深圳', '北京', '深圳', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000012', '重庆到南京', '重庆', '南京', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000022', '成都到太原', '成都', '太原', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000023', '兰州到厦门', '兰州', '厦门', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000024', '杭州到哈尔滨', '杭州', '哈尔滨', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000025', '长春到常州', '长春', '常州', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000026', '武汉到厦门', '武汉', '厦门', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000034', '杭州到哈尔滨', '杭州', '哈尔滨', '12', '3', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000035', '长春到常州', '长春', '常州', '12', '3', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000036', '武汉到厦门', '武汉', '厦门', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000037', '杭州到常州', '杭州', '常州', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000038', '成都到哈尔滨', '成都', '哈尔滨', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000039', '长春到太原', '长春', '太原', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000040', '成都到常州', '成都', '常州', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000041', '北京到深圳', '北京', '深圳', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000042', '重庆到南京', '重庆', '南京', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `relDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('M18176716', 'CL29101095', '123', '2016-01-19 15:19:15');

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
  `declaredPrice` float(10,2) DEFAULT NULL,
  `expectedPrice` float(10,2) DEFAULT '0.00',
  `actualPrice` float(10,2) DEFAULT '0.00',
  `insurance` float(10,2) DEFAULT '0.00',
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
  `settlementStateCompany` varchar(255) DEFAULT NULL,
  `commentId` varchar(255) DEFAULT NULL,
  `startDelivery` datetime DEFAULT NULL COMMENT '开始送货即司机取货时间',
  `isOntime` int(11) DEFAULT '0' COMMENT '是否准时送达',
  `flag` int(11) DEFAULT '1' COMMENT '用于统计分析',
  `onwayTime` int(11) DEFAULT '0' COMMENT '运输时限',
  `satisfaction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------
INSERT INTO `orderform` VALUES ('OR73987978', 'y73506141', null, null, '1111,2222,3333', null, null, '北京索契物流有限公司', '丹东→三亚', '整车', '2016-03-21 23:01:38', '2016-04-03 19:22:58', '河南郑州', '杨昌庆', '15051881383', '北京海淀', '高畅', '15510001873', '3-21整车', '3-21', '23', '45', '678.00', '234.00', '123.80', '123.00', 'D://eclipse_project//.metadata//.plugins//org.eclipse.wst.server.core//tmp0//wtpwebapps//DaTian//file//signBill//1111.jpg', null, '冀EKK301,冀EKK302,冀EKK303', '汪家根,胡锦峰,冯西德', null, 'CL23767471', 'CL29101095', null, null, null, 'TR13397509', null, '123456', '已完成', '未生成', '已生成', 'AS31954621', '2016-03-21 23:05:09', '0', '1', '72', '86%');

-- ----------------------------
-- Table structure for response
-- ----------------------------
DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
  `id` varchar(255) NOT NULL,
  `committer` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `goodsId` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `relDate` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of response
-- ----------------------------
INSERT INTO `response` VALUES ('RE85096416', '李四', '16525456565', 'GO00000017', 'CL23767471', 'CL29101095', 'D://uploadFile//response//CL29101095_ezmorph-1.0.4.jar', '2015-06-19 00:00:00', '无', '已确认');

-- ----------------------------
-- Table structure for settlement
-- ----------------------------
DROP TABLE IF EXISTS `settlement`;
CREATE TABLE `settlement` (
  `id` varchar(255) NOT NULL,
  `orderNum` varchar(255) DEFAULT NULL,
  `orderId` varchar(255) DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of settlement
-- ----------------------------
INSERT INTO `settlement` VALUES ('SE10833518', 'y95698591', 'OR84043492', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE16087923', 'y95698591', 'OR84043492', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE2144741', 'y95698591', 'OR84043492', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE23744554', 'y92651189', 'OR735105', 'CL23767471', 'user1', '2016-02-17 14:41:49');
INSERT INTO `settlement` VALUES ('SE25670174', 'y73506141', 'OR73987978', 'CL23767471', 'user1', '2016-04-03 20:15:51');
INSERT INTO `settlement` VALUES ('SE25860703', 'y85690762', 'OR28338057', 'CL23767471', 'user1', '2016-02-17 14:41:49');
INSERT INTO `settlement` VALUES ('SE26388929', 'y85690762', 'OR28338057', 'CL23767471', 'user1', '2016-02-17 14:41:52');
INSERT INTO `settlement` VALUES ('SE29798162', 'y92651189', 'OR735105', 'CL23767471', 'user1', '2016-02-17 14:41:49');
INSERT INTO `settlement` VALUES ('SE30822884', 'y73506141', 'OR73987978', 'CL29101095', 'company1', '2016-04-03 20:14:12');
INSERT INTO `settlement` VALUES ('SE31519429', 'y92847718', 'OR93014308', 'CL23767471', 'user1', '2016-02-17 14:41:49');
INSERT INTO `settlement` VALUES ('SE32838832', 'y73506141', 'OR73987978', 'CL29101095', 'company1', '2016-04-03 20:08:55');
INSERT INTO `settlement` VALUES ('SE33321502', 'y25369539', 'OR77562450', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE43682321', 'y95698591', 'OR84043492', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE4413195', 'y92651189', 'OR735105', 'CL23767471', 'user1', '2016-02-17 14:41:52');
INSERT INTO `settlement` VALUES ('SE54268081', 'y92847718', 'OR93014308', 'CL23767471', 'user1', '2016-02-17 14:41:49');
INSERT INTO `settlement` VALUES ('SE54955906', 'y73506141', 'OR73987978', 'CL23767471', 'user1', '2016-04-03 20:02:28');
INSERT INTO `settlement` VALUES ('SE55881404', 'y25369539', 'OR77562450', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE57552229', 'y73506141', 'OR73987978', 'CL23767471', 'user1', '2016-03-27 16:45:24');
INSERT INTO `settlement` VALUES ('SE63685062', 'y85690762', 'OR28338057', 'CL23767471', 'user1', '2016-02-17 14:41:49');
INSERT INTO `settlement` VALUES ('SE65973738', 'y95698591', 'OR84043492', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE76333896', 'y92847718', 'OR93014308', 'CL23767471', 'user1', '2016-02-17 14:41:52');
INSERT INTO `settlement` VALUES ('SE83625876', 'y25369539', 'OR77562450', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE84730561', 'y73506141', 'OR73987978', 'CL23767471', 'user1', '2016-04-03 20:15:14');
INSERT INTO `settlement` VALUES ('SE86910869', 'y73506141', 'OR73987978', 'CL29101095', 'company1', '2016-04-03 20:17:14');
INSERT INTO `settlement` VALUES ('SE90433410', 'y25369539', 'OR77562450', 'CL23767471', 'user1', '2015-06-20 00:00:00');
INSERT INTO `settlement` VALUES ('SE91823357', 'y25369539', null, 'CL29101095', 'company1', '2015-06-25 00:00:00');
INSERT INTO `settlement` VALUES ('SE97511950', 'y95698591', null, 'CL29101095', 'company1', '2015-06-25 00:00:00');

-- ----------------------------
-- Table structure for sms_log
-- ----------------------------
DROP TABLE IF EXISTS `sms_log`;
CREATE TABLE `sms_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `terminal` varchar(255) DEFAULT NULL COMMENT 'pc端或者安卓端',
  `type` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `smsContent` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0表示有效，-1表示无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_log
-- ----------------------------
INSERT INTO `sms_log` VALUES ('17', 'PC', 'INFO', '15110666688', '您好', null, '2016-01-27 21:21:09', '0');
INSERT INTO `sms_log` VALUES ('18', 'ANDROID', 'WARNING', '15000000000短信日志', '【安卓】发送短信失败,返回值为:-9020,请查看短信接口说明文档查看原因!', null, '2016-01-28 16:21:53', '-1');
INSERT INTO `sms_log` VALUES ('19', 'ANDROID', 'WARNING', '15000000000??-?????��???', '【安卓】发送短信失败,返回值为:-9020,请查看短信接口说明文档查看原因!', null, '2016-01-28 16:21:54', '-1');
INSERT INTO `sms_log` VALUES ('20', 'ANDROID', 'WARNING', '15000000000短信日志', '【安卓】发送短信失败,返回值为:-9020,请查看短信接口说明文档查看原因!', null, '2016-01-28 16:21:55', '-1');
INSERT INTO `sms_log` VALUES ('21', 'ANDROID', 'VCODE', '18813033633', '3146', null, '2016-01-29 14:57:28', '0');
INSERT INTO `sms_log` VALUES ('22', 'ANDROID', 'VCODE', '18813033633', '6385', null, '2016-01-29 15:08:25', '0');
INSERT INTO `sms_log` VALUES ('23', 'ANDROID', 'VCODE', '18813033633', '9970', null, '2016-01-30 12:13:33', '0');
INSERT INTO `sms_log` VALUES ('24', 'ANDROID', 'VCODE', '18813033633', '3', null, '2016-01-30 12:27:16', '0');
INSERT INTO `sms_log` VALUES ('25', 'ANDROID', 'VCODE', '18813033633', '2474', null, '2016-01-30 12:44:24', '0');
INSERT INTO `sms_log` VALUES ('26', 'ANDROID', 'VCODE', '18813033633', '7112', null, '2016-01-30 12:46:12', '0');
INSERT INTO `sms_log` VALUES ('27', 'ANDROID', 'VCODE', '18813033633', '7406', null, '2016-01-30 12:48:35', '0');
INSERT INTO `sms_log` VALUES ('28', 'ANDROID', 'VCODE', '18813033633', '1170', null, '2016-01-30 12:58:03', '0');
INSERT INTO `sms_log` VALUES ('29', 'ANDROID', 'VCODE', '18813033633', '9621', null, '2016-01-30 13:09:13', '0');
INSERT INTO `sms_log` VALUES ('30', 'ANDROID', 'VCODE', '18813033633', '7870', null, '2016-01-30 13:24:38', '0');
INSERT INTO `sms_log` VALUES ('31', 'ANDROID', 'VCODE', '13920263841', '6029', null, '2016-02-22 22:43:21', '0');
INSERT INTO `sms_log` VALUES ('32', 'ANDROID', 'VCODE', '18813033633', '7124', null, '2016-02-23 19:59:29', '0');
INSERT INTO `sms_log` VALUES ('33', 'ANDROID', 'VCODE', '18813033633', '9826', null, '2016-02-23 20:02:04', '0');
INSERT INTO `sms_log` VALUES ('34', 'ANDROID', 'VCODE', '18813033633', '5780', null, '2016-02-23 20:07:19', '0');
INSERT INTO `sms_log` VALUES ('35', 'ANDROID', 'VCODE', '18813033633', '1152', null, '2016-02-23 20:20:38', '0');
INSERT INTO `sms_log` VALUES ('36', 'ANDROID', 'VCODE', '18813033633', '2095', null, '2016-02-23 20:21:35', '0');
INSERT INTO `sms_log` VALUES ('37', 'ANDROID', 'VCODE', '18813033633', '1879', null, '2016-02-23 20:23:27', '0');
INSERT INTO `sms_log` VALUES ('38', 'ANDROID', 'VCODE', '18813033633', '3037', null, '2016-02-26 13:15:50', '0');
INSERT INTO `sms_log` VALUES ('39', 'ANDROID', 'VCODE', '18813033633', '2076', null, '2016-02-26 13:15:50', '0');
INSERT INTO `sms_log` VALUES ('40', 'ANDROID', 'VCODE', '18813033633', '8225', null, '2016-02-29 10:46:31', '0');
INSERT INTO `sms_log` VALUES ('41', 'ANDROID', 'VCODE', '18813033633', '3473', null, '2016-02-29 10:46:33', '0');
INSERT INTO `sms_log` VALUES ('42', 'ANDROID', 'VCODE', '18813033633', '6971', null, '2016-02-29 11:13:25', '0');
INSERT INTO `sms_log` VALUES ('43', 'ANDROID', 'VCODE', '18813033633', '8570', null, '2016-02-29 11:14:11', '0');
INSERT INTO `sms_log` VALUES ('44', 'ANDROID', 'VCODE', '18813033633', '7835', null, '2016-02-29 11:14:33', '0');
INSERT INTO `sms_log` VALUES ('45', 'ANDROID', 'VCODE', '18813033633', '7591', null, '2016-02-29 11:17:05', '0');
INSERT INTO `sms_log` VALUES ('46', 'ANDROID', 'VCODE', '18813033633', '1818', null, '2016-02-29 11:21:25', '0');
INSERT INTO `sms_log` VALUES ('47', 'ANDROID', 'VCODE', '18813033633', '8153', null, '2016-02-29 11:24:27', '0');
INSERT INTO `sms_log` VALUES ('48', 'ANDROID', 'VCODE', '18813033633', '1108', null, '2016-02-29 12:16:06', '0');
INSERT INTO `sms_log` VALUES ('49', 'ANDROID', 'VCODE', '18813033633', '6277', null, '2016-02-29 12:16:31', '0');
INSERT INTO `sms_log` VALUES ('50', 'ANDROID', 'VCODE', '18813033633', '4974', null, '2016-02-29 12:17:00', '0');
INSERT INTO `sms_log` VALUES ('51', 'ANDROID', 'VCODE', '18813033633', '1579', null, '2016-02-29 12:17:39', '0');
INSERT INTO `sms_log` VALUES ('52', 'ANDROID', 'VCODE', '18813033633', '6142', null, '2016-02-29 12:19:34', '0');
INSERT INTO `sms_log` VALUES ('53', 'ANDROID', 'VCODE', '18813033633', '1889', null, '2016-02-29 12:20:51', '0');
INSERT INTO `sms_log` VALUES ('54', 'ANDROID', 'VCODE', '18813033633', '8636', null, '2016-02-29 12:26:52', '0');
INSERT INTO `sms_log` VALUES ('55', 'ANDROID', 'VCODE', '18813033633', '4958', null, '2016-02-29 12:41:10', '0');
INSERT INTO `sms_log` VALUES ('56', 'ANDROID', 'VCODE', '18813033633', '1478', null, '2016-02-29 12:41:34', '0');
INSERT INTO `sms_log` VALUES ('57', 'ANDROID', 'VCODE', '18813033633', '1591', null, '2016-02-29 12:42:08', '0');
INSERT INTO `sms_log` VALUES ('58', 'ANDROID', 'VCODE', '18813033633', '1910', null, '2016-02-29 12:42:57', '0');
INSERT INTO `sms_log` VALUES ('59', 'ANDROID', 'VCODE', '18813033633', '1960', null, '2016-02-29 12:44:39', '0');
INSERT INTO `sms_log` VALUES ('60', 'ANDROID', 'VCODE', '18813033633', '6814', null, '2016-02-29 12:46:25', '0');
INSERT INTO `sms_log` VALUES ('61', 'ANDROID', 'VCODE', '18813033633', '8239', null, '2016-02-29 12:47:27', '0');
INSERT INTO `sms_log` VALUES ('62', 'ANDROID', 'VCODE', '18813033633', '7065', null, '2016-02-29 15:01:12', '0');
INSERT INTO `sms_log` VALUES ('63', 'ANDROID', 'VCODE', '18813033633', '6713', null, '2016-02-29 19:08:47', '0');
INSERT INTO `sms_log` VALUES ('64', 'ANDROID', 'VCODE', '18813033633', '2764', null, '2016-02-29 19:20:33', '0');
INSERT INTO `sms_log` VALUES ('65', 'ANDROID', 'VCODE', '18813033633', '2126', null, '2016-02-29 19:24:49', '0');
INSERT INTO `sms_log` VALUES ('66', 'ANDROID', 'VCODE', '18813033633', '5744', null, '2016-02-29 19:32:16', '0');
INSERT INTO `sms_log` VALUES ('67', 'ANDROID', 'VCODE', '18813033633', '7831', null, '2016-02-29 19:33:17', '0');
INSERT INTO `sms_log` VALUES ('68', 'ANDROID', 'VCODE', '18813033633', '4504', null, '2016-02-29 19:34:30', '0');
INSERT INTO `sms_log` VALUES ('69', 'ANDROID', 'VCODE', '18813033633', '8269', null, '2016-02-29 19:41:55', '0');
INSERT INTO `sms_log` VALUES ('70', 'ANDROID', 'VCODE', '18813033633', '8882', null, '2016-02-29 19:43:50', '0');
INSERT INTO `sms_log` VALUES ('71', 'ANDROID', 'VCODE', '18813033633', '1067', null, '2016-03-01 22:51:06', '0');
INSERT INTO `sms_log` VALUES ('72', 'ANDROID', 'VCODE', '18813033633', '4371', null, '2016-03-01 23:53:52', '0');
INSERT INTO `sms_log` VALUES ('73', 'ANDROID', 'VCODE', '18813033633', '1797', null, '2016-03-02 00:05:37', '0');
INSERT INTO `sms_log` VALUES ('74', 'ANDROID', 'VCODE', '18813033633', '7129', null, '2016-03-02 16:40:20', '0');
INSERT INTO `sms_log` VALUES ('75', 'ANDROID', 'VCODE', '18813033633', '9560', null, '2016-03-02 16:41:21', '0');
INSERT INTO `sms_log` VALUES ('76', 'ANDROID', 'VCODE', '18813033633', '8047', null, '2016-03-02 16:44:54', '0');
INSERT INTO `sms_log` VALUES ('77', 'ANDROID', 'VCODE', '18813033633', '1059', null, '2016-03-02 16:47:00', '0');
INSERT INTO `sms_log` VALUES ('78', 'ANDROID', 'VCODE', '18813033633', '5879', null, '2016-03-02 16:50:35', '0');
INSERT INTO `sms_log` VALUES ('79', 'ANDROID', 'VCODE', '18813033633', '1032', null, '2016-03-02 16:59:01', '0');
INSERT INTO `sms_log` VALUES ('80', 'ANDROID', 'VCODE', '18813033633', '2514', null, '2016-03-03 22:38:23', '0');
INSERT INTO `sms_log` VALUES ('81', 'ANDROID', 'VCODE', '18813033633', '9035', null, '2016-03-03 22:41:47', '0');
INSERT INTO `sms_log` VALUES ('82', 'ANDROID', 'VCODE', '18813033633', '3764', null, '2016-03-03 22:57:02', '0');
INSERT INTO `sms_log` VALUES ('83', 'ANDROID', 'VCODE', '18813033633', '1017', null, '2016-03-03 22:59:44', '0');
INSERT INTO `sms_log` VALUES ('84', 'ANDROID', 'VCODE', '18813033633', '7464', null, '2016-03-03 23:45:57', '0');
INSERT INTO `sms_log` VALUES ('85', 'ANDROID', 'VCODE', '18813033633', '1625', null, '2016-03-03 23:45:57', '0');
INSERT INTO `sms_log` VALUES ('86', 'PC', 'INFO', '', null, null, '2016-03-04 00:42:54', '0');
INSERT INTO `sms_log` VALUES ('87', 'PC', 'INFO', '', null, null, '2016-03-04 00:43:03', '0');
INSERT INTO `sms_log` VALUES ('88', 'PC', 'INFO', '', null, null, '2016-03-04 00:43:14', '0');
INSERT INTO `sms_log` VALUES ('89', 'PC', 'INFO', '', null, null, '2016-03-04 00:43:34', '0');
INSERT INTO `sms_log` VALUES ('90', 'PC', 'INFO', '', null, null, '2016-03-04 00:44:07', '0');
INSERT INTO `sms_log` VALUES ('91', 'PC', 'INFO', '', null, null, '2016-03-04 00:53:27', '0');
INSERT INTO `sms_log` VALUES ('92', 'ANDROID', 'VCODE', '', '5919', null, '2016-03-04 01:01:12', '0');
INSERT INTO `sms_log` VALUES ('93', 'ANDROID', 'VCODE', '', '4517', null, '2016-03-04 01:01:33', '0');
INSERT INTO `sms_log` VALUES ('94', 'ANDROID', 'VCODE', '', '7164', null, '2016-03-04 01:22:41', '0');
INSERT INTO `sms_log` VALUES ('95', 'ANDROID', 'VCODE', '', '3438', null, '2016-03-04 01:22:46', '0');
INSERT INTO `sms_log` VALUES ('96', 'ANDROID', 'VCODE', '', '2937', null, '2016-03-04 01:24:02', '0');
INSERT INTO `sms_log` VALUES ('97', 'ANDROID', 'VCODE', '', '3688', null, '2016-03-04 01:24:46', '0');
INSERT INTO `sms_log` VALUES ('98', 'ANDROID', 'VCODE', '', '5875', null, '2016-03-04 13:33:22', '0');
INSERT INTO `sms_log` VALUES ('99', 'ANDROID', 'VCODE', '', '7255', null, '2016-03-04 13:38:46', '0');
INSERT INTO `sms_log` VALUES ('100', 'ANDROID', 'VCODE', '', '1671', null, '2016-03-04 13:50:12', '0');
INSERT INTO `sms_log` VALUES ('101', 'ANDROID', 'VCODE', '', '6373', null, '2016-03-04 13:56:02', '0');
INSERT INTO `sms_log` VALUES ('102', 'ANDROID', 'VCODE', '', '1474', null, '2016-03-04 13:57:22', '0');
INSERT INTO `sms_log` VALUES ('103', 'ANDROID', 'VCODE', '', '6198', null, '2016-03-04 14:23:17', '0');
INSERT INTO `sms_log` VALUES ('104', 'ANDROID', 'VCODE', '', '4738', null, '2016-03-04 14:36:14', '0');
INSERT INTO `sms_log` VALUES ('105', 'ANDROID', 'VCODE', '', '2986', null, '2016-03-04 15:02:41', '0');
INSERT INTO `sms_log` VALUES ('106', 'ANDROID', 'VCODE', '', '2613', null, '2016-03-05 13:11:34', '0');
INSERT INTO `sms_log` VALUES ('107', 'ANDROID', 'VCODE', '18813033633', '2482', null, '2016-03-05 13:12:13', '0');
INSERT INTO `sms_log` VALUES ('108', 'ANDROID', 'VCODE', '', '6828', null, '2016-03-05 13:22:45', '0');
INSERT INTO `sms_log` VALUES ('109', 'ANDROID', 'VCODE', '', '1446', null, '2016-03-05 13:24:30', '0');
INSERT INTO `sms_log` VALUES ('110', 'ANDROID', 'VCODE', '', '8953', null, '2016-03-05 13:25:29', '0');
INSERT INTO `sms_log` VALUES ('111', 'ANDROID', 'VCODE', '18813033633', '5641', null, '2016-03-05 16:11:32', '0');
INSERT INTO `sms_log` VALUES ('112', 'ANDROID', 'VCODE', '18813033633', '9291', null, '2016-03-05 16:21:41', '0');
INSERT INTO `sms_log` VALUES ('113', 'ANDROID', 'VCODE', '', '2423', null, '2016-03-05 16:46:42', '0');
INSERT INTO `sms_log` VALUES ('114', 'ANDROID', 'VCODE', '', '5804', null, '2016-03-05 16:47:00', '0');
INSERT INTO `sms_log` VALUES ('115', 'ANDROID', 'VCODE', '13693206686', '7924', null, '2016-03-05 17:09:25', '0');
INSERT INTO `sms_log` VALUES ('116', 'ANDROID', 'VCODE', '13693206686', '9897', null, '2016-03-05 17:10:01', '0');
INSERT INTO `sms_log` VALUES ('117', 'ANDROID', 'VCODE', '', '1399', null, '2016-03-05 17:16:11', '0');
INSERT INTO `sms_log` VALUES ('118', 'ANDROID', 'VCODE', '13693206686', '6339', null, '2016-03-05 17:17:45', '0');
INSERT INTO `sms_log` VALUES ('119', 'ANDROID', 'VCODE', '', '7769', null, '2016-03-05 17:57:40', '0');
INSERT INTO `sms_log` VALUES ('120', 'ANDROID', 'VCODE', '18813033633', '5348', null, '2016-03-05 23:33:57', '0');
INSERT INTO `sms_log` VALUES ('121', 'ANDROID', 'VCODE', '18813033633', '9885', null, '2016-03-05 23:50:13', '0');
INSERT INTO `sms_log` VALUES ('122', 'ANDROID', 'VCODE', '18813033633', '2768', null, '2016-03-06 00:12:49', '0');
INSERT INTO `sms_log` VALUES ('123', 'ANDROID', 'VCODE', '18813033633', '9597', null, '2016-03-06 00:26:17', '0');
INSERT INTO `sms_log` VALUES ('124', 'ANDROID', 'VCODE', '18813033633', '9953', null, '2016-03-06 00:29:23', '0');
INSERT INTO `sms_log` VALUES ('125', 'ANDROID', 'VCODE', '18813033633', '7992', null, '2016-03-06 00:30:09', '0');
INSERT INTO `sms_log` VALUES ('126', 'ANDROID', 'VCODE', '18813033633', '1518', null, '2016-03-06 00:30:47', '0');
INSERT INTO `sms_log` VALUES ('127', 'ANDROID', 'VCODE', '18813033633', '1424', null, '2016-03-06 00:37:50', '0');
INSERT INTO `sms_log` VALUES ('128', 'ANDROID', 'VCODE', '18813033633', '7591', null, '2016-03-06 00:49:53', '0');
INSERT INTO `sms_log` VALUES ('129', 'ANDROID', 'VCODE', '18813033633', '1889', null, '2016-03-06 01:00:45', '0');
INSERT INTO `sms_log` VALUES ('130', 'ANDROID', 'VCODE', '18813033633', '1073', null, '2016-03-06 01:02:05', '0');
INSERT INTO `sms_log` VALUES ('131', 'ANDROID', 'VCODE', '18813033633', '7568', null, '2016-03-06 01:14:33', '0');
INSERT INTO `sms_log` VALUES ('132', 'ANDROID', 'VCODE', '18813033633', '9192', null, '2016-03-06 01:15:34', '0');
INSERT INTO `sms_log` VALUES ('133', 'ANDROID', 'VCODE', '18813033633', '1637', null, '2016-03-06 01:17:44', '0');
INSERT INTO `sms_log` VALUES ('134', 'ANDROID', 'VCODE', '18813033633', '4262', null, '2016-03-06 01:18:11', '0');
INSERT INTO `sms_log` VALUES ('135', 'ANDROID', 'VCODE', '18813033633', '2431', null, '2016-03-06 01:20:12', '0');
INSERT INTO `sms_log` VALUES ('136', 'ANDROID', 'VCODE', '18813033633', '6129', null, '2016-03-06 17:00:08', '0');
INSERT INTO `sms_log` VALUES ('137', 'ANDROID', 'VCODE', '18813033633', '1501', null, '2016-03-06 22:47:48', '0');

-- ----------------------------
-- Table structure for subaccount
-- ----------------------------
DROP TABLE IF EXISTS `subaccount`;
CREATE TABLE `subaccount` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `resourceManagement` varchar(255) DEFAULT NULL,
  `transactionManagement` varchar(255) DEFAULT NULL,
  `schemaManagement` varchar(255) DEFAULT NULL,
  `statisticsManagement` varchar(255) DEFAULT NULL,
  `hostAccountName` varchar(255) DEFAULT NULL,
  `hostAccountId` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subaccount
-- ----------------------------

-- ----------------------------
-- Table structure for track
-- ----------------------------
DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
  `id` varchar(255) NOT NULL,
  `orderId` varchar(255) DEFAULT NULL,
  `orderNum` varchar(255) DEFAULT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `waybillNum` varchar(255) DEFAULT NULL,
  `locLongitude` double(12,8) DEFAULT NULL,
  `locLatitude` double(12,8) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `event` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of track
-- ----------------------------
INSERT INTO `track` VALUES ('T93767575', 'OR73987978', 'y73506141', '冀EKK301', '1111', '234.70000000', '123.60000000', '2016-03-21 23:06:03', '河南郑州', '运输中');

-- ----------------------------
-- Table structure for truck
-- ----------------------------
DROP TABLE IF EXISTS `truck`;
CREATE TABLE `truck` (
  `id` varchar(255) NOT NULL,
  `startCity` varchar(255) DEFAULT NULL,
  `endCity` varchar(255) DEFAULT NULL,
  `onwayTime` int(11) DEFAULT NULL,
  `carType` varchar(255) DEFAULT NULL,
  `carLength` float(10,2) DEFAULT NULL,
  `stanPrice1` float(10,2) DEFAULT NULL,
  `stanPrice2` float(10,2) DEFAULT NULL,
  `pickFee` float(10,2) DEFAULT NULL,
  `deliveryFee` float(10,2) DEFAULT NULL,
  `offerReturn` varchar(255) DEFAULT NULL,
  `extraService` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `resourceType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of truck
-- ----------------------------
INSERT INTO `truck` VALUES ('TR12312341', '保定', '北京', '33', '高栏', '4.20', '35.00', '34.00', '100.00', '100.00', '无', null, '2016-01-14', 'CL29101095', 'eqwe', null, '零担');
INSERT INTO `truck` VALUES ('TR1234567', '北京', '苏州', '48', '高栏', '4.20', '4.00', '3.00', '890.00', '355.00', '无', '', '2016-01-15', 'CL29101095', 'ads', 'D://uploadFile//fulltruckload//CL29101095_btn_arrow7b.png', '零担');
INSERT INTO `truck` VALUES ('TR13397509', '丹东', '三亚', '72', '厢式', '6.20', '1500.00', '1200.00', '200.00', '300.00', '有', '', '2016-02-16', 'CL29101095', '无', '/usr/local/uploadFile/fulltruckload//CL29101095_shipping.png', '整车');
INSERT INTO `truck` VALUES ('TR16858286', '北京', '南昌', '12', '厢式', '7.60', '67.00', '2.00', '43.00', '56.00', '有', '123', '2016-01-16', 'CL29101095', 'remarks', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '零担');
INSERT INTO `truck` VALUES ('TR23123451', '北京', '邯郸', '10', '厢式', '9.50', '15.00', '15.00', '155.00', '155.00', '有', null, '2016-01-28', 'CL29101095', 'qweqwe', null, '零担');
INSERT INTO `truck` VALUES ('TR234582', '北京', '广州', '24', '高栏', '12.50', '3.00', '4.00', '892.00', '366.00', '无', '', '2016-01-04', 'CL29101095', 'asd', 'D://uploadFile//lesstruckload//CL29101095_bg_index2.png', '零担');
INSERT INTO `truck` VALUES ('TR25085294', '郑州', '南京', '123', '厢式', '17.50', '12.00', '343.00', '56.00', '76.00', '有', '', '2016-01-19', 'CL29101095', '123', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '整车');
INSERT INTO `truck` VALUES ('TR26633826', '海口', '贵阳', '23', '厢式', '6.20', '1.00', '3.00', '4.00', '5.00', '有', '', '2016-01-19', 'CL29101095', '789', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '整车');
INSERT INTO `truck` VALUES ('TR32066423', '北京', '长沙', '36', '厢式', '4.20', '20.00', '11.00', '0.00', '0.00', '有', '', '2016-03-21', 'CL29101095', 'good', '/usr/local/uploadFile/lesstruckload//CL29101095_Calculator.png', '零担');
INSERT INTO `truck` VALUES ('TR3242733', '北京', '广州', '72', '高栏', '6.20', '5.00', '2.00', '890.00', '123.00', '无', '', '2016-01-14', 'CL29101095', 'asd', 'D://uploadFile//lesstruckload//CL29101095_btn_cs_bg.png', '零担');
INSERT INTO `truck` VALUES ('TR34235511', '长沙', '三亚', '34', '平板', '7.60', '1.00', '3.00', '9.00', '32.00', '有', '', '2016-01-19', 'CL29101095', '123', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '整车');
INSERT INTO `truck` VALUES ('TR41285958', '长春', '福州', '56', '厢式', '4.20', '7.00', '3.00', '2.00', '8.00', '有', '', '2016-01-19', 'CL29101095', '56', '/usr/local/uploadFile/fulltruckload//CL29101095_项目任~1.PNG', '整车');
INSERT INTO `truck` VALUES ('TR4377624', '贵阳', '南京', '12', '厢式', '6.20', '12.00', '34.00', '56.00', '78.00', '无', '', '2016-03-30', 'CL29101095', '123', 'D://uploadFile//fulltruckload//CL29101095_我的.JPG', '整车');
INSERT INTO `truck` VALUES ('TR48417268', '攀枝花', '福州', '14', '厢式', '7.60', '8.00', '4.00', '9.00', '1.00', '有', '', '2016-01-19', 'CL29101095', '456', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '整车');
INSERT INTO `truck` VALUES ('TR54662695', '深圳', '南昌', '36', '平板', '12.50', '2800.00', '2000.00', '300.00', '150.00', '有', '', '2016-02-17', 'CL29101095', '我要改一改', 'D://uploadFile//lesstruckload//CL29101095_Hydrangeas.jpg', '零担');
INSERT INTO `truck` VALUES ('TR54758808', '重庆', '海口', '28', '高栏', '4.20', '3200.00', '3800.00', '500.00', '500.00', '有', '', '2016-03-22', 'CL29101095', '', '/usr/local/uploadFile/fulltruckload//', '整车');
INSERT INTO `truck` VALUES ('TR55212333', '三亚', '海口', '12', '平板', '6.20', '4.00', '7.00', '2.00', '9.00', '无', '123', '2016-01-19', 'CL29101095', '65', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '整车');
INSERT INTO `truck` VALUES ('TR56456464', '石家庄', '北京', '16', '高栏', '7.60', '5.00', '5.00', '30.00', '30.00', '有', null, '2016-01-12', 'CL29101095', '1231asda', null, '零担');
INSERT INTO `truck` VALUES ('TR56461234', '北京', '上海', '13', '高栏', '4.20', '2.00', '1.00', '3.00', '3.00', '无', '456', '2016-01-19', 'CL29101095', 'asdasd', null, '零担');
INSERT INTO `truck` VALUES ('TR56561789', '邯郸', '北京', '15', '高栏', '12.50', '5.00', '5.00', '100.00', '100.00', '有', null, '2015-12-31', 'CL29101095', '123451', null, '零担');
INSERT INTO `truck` VALUES ('TR68413733', '北京', '广州', '12', '高栏', '4.20', '1.00', '2.00', '3.00', '4.00', '无', '', '2016-01-17', 'CL29101095', 'remarks', 'D://uploadFile//fulltruckload//CL29101095_bg_index1.png', '零担');
INSERT INTO `truck` VALUES ('TR73868041', '北京', '昆明', '72', '厢式', '6.20', '12.00', '34.00', '56.00', '78.00', '有', '', '2016-02-26', 'CL29101095', '我想改一改', '/usr/local/uploadFile/fulltruckload//CL29101095_2-21.PNG', '整车');
INSERT INTO `truck` VALUES ('TR81486752', '三亚', '北京', '48', '高栏', '6.20', '23.00', '56.00', '78.00', '98.00', '有', '', '2016-03-10', 'CL29101095', '新加的记录', '/usr/local/uploadFile/fulltruckload//CL29101095_2-21.PNG', '整车');
INSERT INTO `truck` VALUES ('TR8682032', '福州', '长沙', '56', '平板', '17.50', '1.00', '7.00', '3.00', '6.00', '有', '', '2016-01-19', 'CL29101095', '12', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '整车');
INSERT INTO `truck` VALUES ('TR87249502', '北京', '广州', '11', '高栏', '12.50', '10.00', '10.00', '100.00', '100.00', '无', '123', '2016-01-19', 'CL29101095', '133213123', 'D://uploadFile//lesstruckload//CL29101095_btn_cancel2.png', '整车');
INSERT INTO `truck` VALUES ('TR89734702', '广州', '长沙', '34', '高栏', '6.20', '1.00', '8.00', '5.00', '9.00', '有', '123', '2016-01-19', 'CL29101095', 'test', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '整车');
INSERT INTO `truck` VALUES ('TR92247790', '南昌', '南京', '45', '平板', '17.50', '9.00', '8.00', '7.00', '6.00', '有', '', '2016-01-19', 'CL29101095', '45', 'D://uploadFile//fulltruckload//CL29101095_需求.JPG', '整车');
INSERT INTO `truck` VALUES ('TR95373775', '北京', '贵阳', '24', null, null, '23.00', '56.00', '78.00', '90.00', '有', '', '2016-03-21', 'CL29101095', '3-21晚上测试', '/usr/local/uploadFile/lesstruckload//CL29101095_捕获.PNG', '零担');
INSERT INTO `truck` VALUES ('TR98671234', '苏州', '北京', '34', '平板', '4.20', '8.00', '2.00', '9.00', '4.00', '有', '23432', '2016-01-19', 'CL29101095', '3244', null, '零担');
INSERT INTO `truck` VALUES ('TR99480620', '北京', '长沙', '36', '厢式', '12.50', '1680.00', '1800.00', '180.00', '100.00', '有', '免费包装', '2016-03-21', 'CL29101095', '', '/usr/local/uploadFile/fulltruckload//CL29101095_wrist_watch_by_kaizoro-d5nrugm.png', '整车');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `privilege` varchar(255) DEFAULT NULL,
  `userKind` int(11) DEFAULT NULL COMMENT '1代表管理员，2代表普通用户，3代表企业用户，',
  `validateTime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `emailStatus` varchar(255) DEFAULT NULL,
  `phoneStatus` varchar(255) DEFAULT NULL,
  `securityQuestionStatus` varchar(255) DEFAULT NULL,
  `securityQuestionOne` varchar(255) DEFAULT NULL,
  `securityAnswerOne` varchar(255) DEFAULT NULL,
  `securityQuestionTwo` varchar(255) DEFAULT NULL,
  `securityAnswerTwo` varchar(255) DEFAULT NULL,
  `securityQuestionThree` varchar(255) DEFAULT NULL,
  `securityAnswerThree` varchar(255) DEFAULT NULL,
  `headIcon` varchar(255) DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('C-0002', 'admin', '21232F297A57A5A743894A0E4A801FC3', '', '1233@163.com', null, '1', null, '已审核', '已绑定', '已绑定', '已设置', '您的生日？', '1', '您最尊敬的人？', '2', '您的第一任班主任？', '3', '未设置', null);
INSERT INTO `userinfo` VALUES ('CL1042656', 'user', 'EE11CBB19052E40B07AAC0CA060C23EE', '15510001873', null, null, '2', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL23767471', 'user1', '24C9E15E52AFC47C225B757E7BEE1F9D', '18301930384', '1233@163.com', null, '2', null, '已审核', '已绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL29101095', 'company1', 'DF655F976F7C9D3263815BD981225CD9', '18393882934', null, null, '3', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL36962557', 'adminadmin', '21232F297A57A5A743894A0E4A801FC3', '15510001873', null, null, '2', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL41403136', 'company3', 'E828AE3339B8D80B3902C1564578804E', '17833948392', null, null, '3', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL53447782', 'solitudeycq', '263E4AE060EC0F48E64479B1F278AFD1', '', null, null, '2', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL73207711', 'company2', 'D196A28097115067FEFD73D25B0C0BE8', '18893849584', null, null, '3', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL78387917', 'user3', '92877AF70A45FD6A2ED7FE81E1236B78', '13293049303', null, null, '2', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL81096930', 'user2', '7E58D63B60197CEB55A1C487989A3720', '1832938483', null, null, '2', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `kind` varchar(255) DEFAULT NULL,
  `houseArea` float(10,2) DEFAULT NULL,
  `remainArea` float(10,2) DEFAULT NULL,
  `yardArea` float(10,2) DEFAULT NULL,
  `height` float(10,2) DEFAULT NULL,
  `fireRate` varchar(255) DEFAULT NULL,
  `storageForm` varchar(255) DEFAULT NULL,
  `fireSecurity` varchar(255) DEFAULT NULL,
  `environment` varchar(255) DEFAULT NULL,
  `serviceContent` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `detailPrice` varchar(255) DEFAULT NULL,
  `standPrice` float(10,2) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('RE00000001', '1号库', '北京', '北京市海淀区', '保税', '自有', '20000.80', '1000.00', '6000.00', '6.00', '乙', '露天', '烟感', 'Internet宽带接入', '机械出入库搬运', '张三', '13900003366', '/usr/local/iver99/testfile.txt', '23.00', '无', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000003', '3号库', '北京', '北京市朝阳区', '保税', '自有', '10000.00', '123.00', '6000.00', '4.00', '甲', '冷藏', '24小时摄像监控', '仓库信息管理系统', '分拣', '孙亮', '13900003368', '/usr/local/iver99/testfile.txt', '12.00', '', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000004', '4号库', '天津', '天津市西青区', '保税', '自有', '30000.00', '123.00', '8000.00', '8.00', '乙', '露天', '烟感, 24小时摄像监控', '仓库信息管理系统', '机械出入库搬运', '王楠', '13925456563', '/usr/local/iver99/testfile.txt', '123.00', '', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000005', '555号库', '广州', '广州市天河区', '保税', '自有', '20000.00', '2343.00', null, null, '丙', '冷藏,恒温,露天', null, null, '分拣,包装,打托盘', '李四', '13845478789', 'D://uploadFile//warehouse//CL29101095_任务.PNG', '5435.00', '我把555号库更新了', 'CL29101095', '2016-03-08');
INSERT INTO `warehouse` VALUES ('RE00000006', '林安库', '广州', '广州市林安区', '保税', '自有', '50000.00', null, '5000.00', '5.00', '甲', '冷藏', '烟感, 24小时摄像监控', 'Internet宽带接入', '分拣, 包装', '陈泽', '15621545698', '/usr/local/iver99/testfile.txt', null, '', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000007', '浦西库', '上海', '上海市浦西区', '非保税', '自有', '40000.00', null, '6000.00', '6.00', '甲', '恒温', '烟感, 24小时摄像监控', '信息系统', '机械出入库搬运', '王铎', '16565323656', '/usr/local/iver99/testfile.txt', null, '', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000008', '西青库', '天津', '天津市西青区', '保税', '自有', '60000.00', null, '8000.00', '8.00', '丙', '普通', '烟感, 24小时摄像监控', '仓库信息管理系统', '分拣, 包装', '李萍', '15545236569', '/usr/local/iver99/testfile.txt', null, '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000009', '海淀库', '北京', '北京市海淀区', '非保税', '自有', '20000.00', null, '4000.00', '4.00', '乙', '冷藏', '烟感, 24小时摄像监控', '信息系统', '分拣, 包装', '陈楠', '19656523256', '/usr/local/iver99/testfile.txt', null, '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000010', '河西库', '天津', '天津市河西区', '非保税', '自有', '10000.00', null, '5000.00', '4.00', '甲', '冷藏', '烟感, 24小时摄像监控', '信息系统', '机械出入库搬运', '王伟', '12656532323', '/usr/local/iver99/testfile.txt', null, '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000011', '501库', '天津', '天津市西青区', '保税', '自有', '30000.00', null, '6000.00', '5.00', '甲', '冷藏', '烟感, 24小时摄像监控', '仓库信息管理系统', '分拣, 包装', '李毅', '15645423569', '/usr/local/iver99/testfile.txt', null, '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000012', '502库', '上海', '上海市浦东区', '保税', '自有', '30000.00', null, '8000.00', '6.00', '甲', '露天', '烟感, 24小时摄像监控', 'Internet宽带接入', '机械出入库搬运', '陈伟', '17565498653', '/usr/local/iver99/testfile.txt', null, '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000013', '503库', '青岛', '青岛市', '非保税', '租赁', '10000.00', null, '4000.00', '3.00', '丙', '冷藏', '24小时摄像监控', 'Internet宽带接入', '分拣', '孙楠', '16632569874', '/usr/local/iver99/testfile.txt', null, '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000014', '504库', '广州', '广州市林安区', '非保税', '租赁', '20000.00', null, '5000.00', '4.00', '乙', '冷藏', '烟感, 24小时摄像监控', '信息系统', '分拣, 包装', '孙成', '14523265654', '/usr/local/iver99/testfile.txt', null, '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000015', '505库', '南京', '南京市', '保税', '自有', '50000.00', null, '6000.00', '8.00', '甲', '露天', '烟感, 24小时摄像监控', '仓库信息管理系统', '机械出入库搬运', '李平', '12545456365', '/usr/local/iver99/testfile.txt', null, '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000016', '西青A库', '天津', '天津市西青区', '保税', '自有', '20000.00', null, '5000.00', '6.00', '甲', '冷藏', '烟感, 24小时摄像监控', '仓库信息管理系统', '分拣, 包装', '陈增', '12354565569', '/usr/local/iver99/testfile.txt', null, '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000017', '河西A库', '天津', '天津市河西区', '非保税', '租赁', '10000.00', null, '3000.00', '3.00', '丙', '冷藏', '24小时摄像监控', 'Internet宽带接入', '分拣', '陈平', '15845423265', '/usr/local/iver99/testfile.txt', null, '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000018', '朝阳A库', '北京', '北京市朝阳区', '非保税', '自有', '30000.00', null, '5000.00', '4.00', '乙', '恒温', '烟感, 24小时摄像监控', '信息系统', '分拣, 包装', '王五', '15698654541', '/usr/local/iver99/testfile.txt', null, '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000019', '机场A库', '北京', '北京市朝阳区', '保税', '自有', '50000.00', null, '6000.00', '8.00', '甲', '普通', '烟感, 24小时摄像监控', '仓库信息管理系统', '机械出入库搬运', '李德', '16898956565', '/usr/local/iver99/testfile.txt', null, '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000020', '西青B库', '天津', '天津市西青区', '非保税', '自有', '30000.00', null, '6000.00', '6.00', '甲', '冷藏', '烟感, 24小时摄像监控', '仓库信息管理系统', '分拣, 包装', '陈怡', '14545254566', '/usr/local/iver99/testfile.txt', null, '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE45590365', '杨昌庆的仓库', '北京', '北京市海淀区', '保税', '自有', '1280.00', '90.00', null, null, '甲', '普通,恒温,露天', null, null, '机械出入库搬运,分拣,打托盘,地面存储', '杨昌庆', '15051881383', 'D://uploadFile//warehouse//CL29101095_2-21.PNG', '12.00', '我的第一个仓库', 'CL29101095', '2016-03-03');
INSERT INTO `warehouse` VALUES ('RE54319128', '1234', '北京', '北京海淀', '保税', '自有', '123.00', '34.00', null, null, '甲', '危险品', null, null, '地面存储', '杨昌庆', '15051881383', 'D://uploadFile//warehouse//CL29101095_杨昌庆.JPG', '12.00', '1234', 'CL29101095', '2016-04-03');

-- ----------------------------
-- Table structure for waybill
-- ----------------------------
DROP TABLE IF EXISTS `waybill`;
CREATE TABLE `waybill` (
  `id` varchar(255) NOT NULL,
  `orderId` varchar(255) DEFAULT NULL,
  `orderNum` varchar(255) DEFAULT NULL,
  `waybillNum` varchar(255) DEFAULT NULL,
  `resourceName` varchar(255) DEFAULT NULL,
  `deliveryAddr` varchar(255) DEFAULT NULL,
  `deliveryName` varchar(255) DEFAULT NULL,
  `deliveryPhone` varchar(255) DEFAULT NULL,
  `recieverAddr` varchar(255) DEFAULT NULL,
  `recieverName` varchar(255) DEFAULT NULL,
  `recieverPhone` varchar(255) DEFAULT NULL,
  `goodsName` varchar(255) DEFAULT NULL,
  `goodsWeight` float(10,3) DEFAULT NULL,
  `goodsVolume` float(10,3) DEFAULT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `confirm` varchar(255) DEFAULT 'false',
  `waybillSubTime` datetime DEFAULT NULL,
  `waybillFinishTime` datetime DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `waybillState` varchar(255) DEFAULT NULL COMMENT '未确认，已确认，已完成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of waybill
-- ----------------------------
INSERT INTO `waybill` VALUES ('WB15330918', 'OR73987978', 'y73506141', '1111', '丹东→三亚', '河南郑州', '杨昌庆', '15051881383', '北京海淀', '高畅', '15510001873', '3-21', '23.000', '45.000', '冀EKK301', '汪家根', 'true', '2016-03-21 23:02:15', '2016-03-21 23:07:36', 'D://eclipse_project//.metadata//.plugins//org.eclipse.wst.server.core//tmp0//wtpwebapps//DaTian//file//signBill//1111.jpg', '123.80', '已签收');
INSERT INTO `waybill` VALUES ('WB23255685', 'OR73987978', 'y73506141', '2222', '丹东→三亚', '河南郑州', '杨昌庆', '15051881383', '北京海淀', '高畅', '15510001873', '3-21', '23.000', '45.000', '冀EKK302', '胡锦峰', 'false', '2016-03-21 23:02:15', null, null, null, '未确认');
INSERT INTO `waybill` VALUES ('WB72915004', 'OR73987978', 'y73506141', '3333', '丹东→三亚', '河南郑州', '杨昌庆', '15051881383', '北京海淀', '高畅', '15510001873', '3-21', '23.000', '45.000', '冀EKK303', '冯西德', 'false', '2016-03-21 23:02:15', null, null, null, '未确认');

-- ----------------------------
-- View structure for car_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `car_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `car_carrier_view` AS select `carinfo`.`carLength` AS `carLength`,`carinfo`.`carNum` AS `carNum`,`carinfo`.`carTeam` AS `carTeam`,`carinfo`.`carUse` AS `carUse`,`carinfo`.`carLocation` AS `carLocation`,`carinfo`.`relDate` AS `relDate`,`carinfo`.`carType` AS `carType`,`carinfo`.`linetransportId` AS `linetransportId`,`carinfo`.`locLongitude` AS `locLongitude`,`carinfo`.`locLatitude` AS `locLatitude`,`carinfo`.`locationType` AS `locationType`,`carinfo`.`carBrand` AS `carBrand`,`carinfo`.`storage` AS `storage`,`carinfo`.`carrierId` AS `carrierId`,`carinfo`.`carWeight` AS `carWeight`,`carinfo`.`carState` AS `carState`,`carinfo`.`driverId` AS `driverId`,`carinfo`.`purchaseTime` AS `purchaseTime`,`carinfo`.`id` AS `id`,`carrierinfo`.`companyName` AS `companyName`,`carinfo`.`carBase` AS `carBase`,`carinfo`.`carWidth` AS `carWidth`,`carinfo`.`carHeight` AS `carHeight`,`carinfo`.`terminalId` AS `terminalId`,`carinfo`.`stopPlace` AS `stopPlace`,`carinfo`.`startPlace` AS `startPlace`,`carinfo`.`endPlace` AS `endPlace` from (`carinfo` join `carrierinfo`) where (`carinfo`.`carrierId` = `carrierinfo`.`id`) ; ;

-- ----------------------------
-- View structure for city_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `city_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `city_carrier_view` AS SELECT
carrierinfo.companyName AS companyName,
cityline.id AS id,
cityline.cityName AS cityName,
cityline.refPrice AS refPrice,
cityline.relDate AS relDate,
cityline.carrierId AS carrierId,
cityline.VIPService AS VIPService,
cityline.detailPrice AS detailPrice,
cityline.remarks AS remarks,
carrierinfo.creditRate AS creditRate,
cityline.`name` AS `name`,
cityline.standPrice1,
cityline.standPrice2,
cityline.pickFee,
cityline.deliveryFee
from (`carrierinfo` join `cityline`)
where (`carrierinfo`.`id` = `cityline`.`carrierId`) ;

-- ----------------------------
-- View structure for complaint_client_view
-- ----------------------------
DROP VIEW IF EXISTS `complaint_client_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `complaint_client_view` AS select `complaintform`.`id` AS `id`,`complaintform`.`type` AS `type`,`complaintform`.`theme` AS `theme`,`complaintform`.`content` AS `content`,`complaintform`.`relDate` AS `relDate`,`complaintform`.`state` AS `state`,`complaintform`.`relatedMaterial` AS `relatedMaterial`,`complaintform`.`feedback` AS `feedback`,`complaintform`.`clientId` AS `clientId`,`complaintform`.`carrierId` AS `carrierId`,`clientinfo`.`realName` AS `realName`,`complaintform`.`orderNum` AS `orderNum` from (`complaintform` join `clientinfo`) where (`complaintform`.`clientId` = `clientinfo`.`id`) ; ;

-- ----------------------------
-- View structure for focus_car_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_car_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_car_view` AS select `focus`.`id` AS `id`,`focus`.`clientId` AS `clientId`,`focus`.`focusType` AS `focusType`,`focus`.`focusId` AS `focusId`,`focus`.`status` AS `status`,`carinfo`.`carNum` AS `carNum`,`carinfo`.`carrierId` AS `carrierId`,`carrierinfo`.`companyName` AS `companyName`,`carinfo`.`relDate` AS `relDate`,`carinfo`.`linetransportId` AS `linetransportId` from ((`focus` join `carinfo`) join `carrierinfo`) where ((`focus`.`focusId` = `carinfo`.`id`) and (`carinfo`.`carrierId` = `carrierinfo`.`id`)) ; ;

-- ----------------------------
-- View structure for focus_cityline_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_cityline_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_cityline_view` AS select `focus`.`id` AS `id`,`focus`.`clientId` AS `clientId`,`focus`.`focusType` AS `focusType`,`focus`.`focusId` AS `focusId`,`focus`.`status` AS `status`,`cityline`.`name` AS `name`,`carrierinfo`.`companyName` AS `companyName`,`cityline`.`carrierId` AS `carrierId`,`cityline`.`relDate` AS `relDate` from ((`focus` join `cityline`) join `carrierinfo`) where ((`focus`.`focusId` = `cityline`.`id`) and (`cityline`.`carrierId` = `carrierinfo`.`id`)) ; ;

-- ----------------------------
-- View structure for focus_company_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_company_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_company_view` AS select `focus`.`id` AS `id`,`focus`.`clientId` AS `clientId`,`focus`.`focusType` AS `focusType`,`focus`.`focusId` AS `focusId`,`focus`.`status` AS `status`,`carrierinfo`.`companyName` AS `companyName`,`carrierinfo`.`relDate` AS `relDate`,`carrierinfo`.`id` AS `carrierId` from (`focus` join `carrierinfo`) where (`focus`.`focusId` = `carrierinfo`.`id`) ; ;

-- ----------------------------
-- View structure for focus_goods_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_goods_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_goods_view` AS select `focus`.`id` AS `id`,`focus`.`clientId` AS `clientId`,`focus`.`focusType` AS `focusType`,`focus`.`focusId` AS `focusId`,`focus`.`status` AS `status`,`goodsform`.`name` AS `name`,`goodsform`.`relDate` AS `relDate` from (`focus` join `goodsform`) where (`focus`.`focusId` = `goodsform`.`id`) ; ;

-- ----------------------------
-- View structure for focus_linetransport_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_linetransport_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_linetransport_view` AS select `focus`.`id` AS `id`,`focus`.`clientId` AS `clientId`,`focus`.`focusType` AS `focusType`,`focus`.`focusId` AS `focusId`,`focus`.`status` AS `status`,`linetransport`.`startPlace` AS `startPlace`,`linetransport`.`endPlace` AS `endPlace`,`carrierinfo`.`companyName` AS `companyName`,`linetransport`.`carrierId` AS `carrierId`,`linetransport`.`relDate` AS `relDate` from ((`focus` join `linetransport`) join `carrierinfo`) where ((`focus`.`focusId` = `linetransport`.`id`) and (`linetransport`.`carrierId` = `carrierinfo`.`id`)) ; ;

-- ----------------------------
-- View structure for focus_warehouse_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_warehouse_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_warehouse_view` AS select `warehouse`.`name` AS `name`,`carrierinfo`.`companyName` AS `companyName`,`warehouse`.`carrierId` AS `carrierId`,`focus`.`id` AS `id`,`focus`.`clientId` AS `clientId`,`focus`.`focusType` AS `focusType`,`focus`.`focusId` AS `focusId`,`focus`.`status` AS `status`,`warehouse`.`relDate` AS `relDate` from ((`focus` join `warehouse`) join `carrierinfo`) where ((`focus`.`focusId` = `warehouse`.`id`) and (`warehouse`.`carrierId` = `carrierinfo`.`id`)) ; ;

-- ----------------------------
-- View structure for goods_client_view
-- ----------------------------
DROP VIEW IF EXISTS `goods_client_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `goods_client_view` AS select `goodsform`.`id` AS `id`,`goodsform`.`name` AS `name`,`goodsform`.`transportType` AS `transportType`,`goodsform`.`weight` AS `weight`,`goodsform`.`startPlace` AS `startPlace`,`goodsform`.`endPlace` AS `endPlace`,`goodsform`.`relDate` AS `relDate`,`goodsform`.`limitDate` AS `limitDate`,`goodsform`.`transportReq` AS `transportReq`,`goodsform`.`damageReq` AS `damageReq`,`goodsform`.`VIPService` AS `VIPService`,`goodsform`.`oriented` AS `oriented`,`goodsform`.`invoice` AS `invoice`,`goodsform`.`relatedMaterial` AS `relatedMaterial`,`goodsform`.`state` AS `state`,`goodsform`.`clientId` AS `clientId`,`goodsform`.`remarks` AS `remarks`,`clientinfo`.`realName` AS `realName`,`goodsform`.`type` AS `type`,`clientinfo`.`phone` AS `phone`,`clientinfo`.`carrierId` AS `carrierId`,`goodsform`.`VIPServiceDetail` AS `VIPServiceDetail`,`goodsform`.`feeReq` AS `feeReq`,`goodsform`.`goodsDes` AS `goodsDes`,`goodsform`.`updateDate` AS `updateDate` from (`clientinfo` join `goodsform`) where (`clientinfo`.`id` = `goodsform`.`clientId`) ; ;

-- ----------------------------
-- View structure for goods_response_view
-- ----------------------------
DROP VIEW IF EXISTS `goods_response_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `goods_response_view` AS select `response`.`committer` AS `committer`,`response`.`phone` AS `phone`,`response`.`goodsId` AS `goodsId`,`response`.`clientId` AS `clientId`,`response`.`carrierId` AS `carrierId`,`response`.`remarks` AS `remarks`,`goodsform`.`id` AS `id`,`response`.`id` AS `responseId`,`goodsform`.`state` AS `state`,`goodsform`.`name` AS `name`,`response`.`relatedMaterial` AS `relatedMaterial`,`response`.`relDate` AS `relDate` from (`goodsform` join `response`) where (`goodsform`.`id` = `response`.`goodsId`) ; ;

-- ----------------------------
-- View structure for line_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `line_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `line_carrier_view` AS select `carrierinfo`.`companyName` AS `companyName`,`linetransport`.`startPlace` AS `startPlace`,`linetransport`.`endPlace` AS `endPlace`,`linetransport`.`carrierId` AS `carrierId`,`linetransport`.`id` AS `id`,`linetransport`.`onWayTime` AS `onWayTime`,`linetransport`.`refPrice` AS `refPrice`,`linetransport`.`relDate` AS `relDate`,`linetransport`.`detailPrice` AS `detailPrice`,`linetransport`.`remarks` AS `remarks`,`linetransport`.`type` AS `type`,`linetransport`.`lineName` AS `lineName` from (`carrierinfo` join `linetransport`) where (`carrierinfo`.`id` = `linetransport`.`carrierId`) ; ;

-- ----------------------------
-- View structure for order_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `order_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `order_carrier_view` AS select `carrierinfo`.`companyName` AS `carrierName`,`carrierinfo`.`companyAccount` AS `carrierAccount`,`orderform`.`id` AS `id`,`orderform`.`goodsName` AS `goodsName`,`orderform`.`carrierId` AS `carrierId`,`orderform`.`expectedPrice` AS `expectedPrice`,`orderform`.`actualPrice` AS `actualPrice`,`orderform`.`submitTime` AS `submitTime`,`orderform`.`state` AS `state`,`orderform`.`deliveryAddr` AS `deliveryAddr`,`orderform`.`deliveryName` AS `deliveryName`,`orderform`.`deliveryPhone` AS `deliveryPhone`,`orderform`.`recieverAddr` AS `recieverAddr`,`orderform`.`recieverName` AS `recieverName`,`orderform`.`recieverPhone` AS `recieverPhone`,`orderform`.`warehouseId` AS `warehouseId`,`orderform`.`citylineId` AS `citylineId`,`orderform`.`linetransportId` AS `linetransportId`,`orderform`.`remarks` AS `remarks`,`orderform`.`insurance` AS `insurance`,`orderform`.`clientId` AS `clientId`,`orderform`.`goodsWeight` AS `goodsWeight`,`orderform`.`goodsVolume` AS `goodsVolume`,`orderform`.`contractId` AS `contractId`,`orderform`.`acceptPicture` AS `acceptPicture`,`orderform`.`resourceType` AS `resourceType`,`orderform`.`carNum` AS `carNum`,`orderform`.`driver` AS `driver`,`orderform`.`commentId` AS `commentId`,`orderform`.`explainReason` AS `explainReason`,`orderform`.`orderNum` AS `orderNum`,`orderform`.`clientName` AS `clientName`,`orderform`.`hasCarrierContract` AS `hasCarrierContract`,`orderform`.`declaredPrice` AS `declaredPrice`,`orderform`.`cancelReason` AS `cancelReason`,`orderform`.`isLinkToClientWayBill` AS `isLinkToClientWayBill`,`orderform`.`clientWayBillNum` AS `clientWayBillNum`,`orderform`.`resourceName` AS `resourceName` from (`orderform` join `carrierinfo`) where (`orderform`.`carrierId` = `carrierinfo`.`id`) ;

-- ----------------------------
-- View structure for settlement_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `settlement_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `settlement_carrier_view` AS SELECT
orderform.orderNum AS orderNum,
orderform.clientName AS clientName,
orderform.contractId AS contractId,
orderform.submitTime AS submitTime,
orderform.settlementState AS settlementState,
orderform.actualPrice AS actualPrice,
orderform.expectedPrice AS expectedPrice,
orderform.carrierId AS carrierId,
carrierinfo.id AS carrierId2,
carrierinfo.companyName AS companyName,
orderform.id AS id,
orderform.clientId AS clientId,
orderform.state AS state,
orderform.settlementStateCompany
from (`orderform` join `carrierinfo`)
where (`orderform`.`carrierId` = `carrierinfo`.`id`) ;

-- ----------------------------
-- View structure for warehouse_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `warehouse_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `warehouse_carrier_view` AS SELECT
warehouse.id AS id,
warehouse.`name` AS `name`,
warehouse.city AS city,
warehouse.address AS address,
warehouse.type AS type,
warehouse.kind AS kind,
warehouse.houseArea AS houseArea,
warehouse.yardArea AS yardArea,
warehouse.height AS height,
warehouse.fireRate AS fireRate,
warehouse.storageForm AS storageForm,
warehouse.fireSecurity AS fireSecurity,
warehouse.environment AS environment,
warehouse.serviceContent AS serviceContent,
warehouse.contact AS contact,
warehouse.phone AS phone,
warehouse.detailPrice AS detailPrice,
warehouse.remarks AS remarks,
warehouse.carrierId AS carrierId,
warehouse.relDate AS relDate,
carrierinfo.companyName AS companyName,
warehouse.remainArea,
warehouse.standPrice
from (`warehouse` join `carrierinfo`)
where (`warehouse`.`carrierId` = `carrierinfo`.`id`) ;