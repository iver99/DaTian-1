/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50545
Source Host           : localhost:3306
Source Database       : datian

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2016-01-26 13:26:12
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `goodsform` VALUES ('GO00000017', '日照到徐州货源', '医药', '整车', '12', '莒县', '沛县', '2015-04-15', '2015-04-24', null, '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '1', '不需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL23767471', '', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000018', '赤峰到乌兰浩特货源', '医药', '整车', '40', '天山', '扎兰屯', '2015-04-15', '2015-04-24', null, '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL23767471', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿', null, null);
INSERT INTO `goodsform` VALUES ('GO00000033', '松原到青岛货源', '医药', '零担', '1', '扶余', '青岛', '2015-04-15', '2015-04-24', null, '可拼车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿', null, null);
INSERT INTO `goodsform` VALUES ('GO00000034', '宝应到兰州货源', '电子仪器', '整车', '38', '宝应', '兰州', '2015-04-15', '2015-04-24', null, '车长13米，高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000035', '张家港到赤峰货源', '电子仪器', '整车', '29', '张家港', '赤峰', '2015-01-26', '2015-01-29', null, '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL81096930', 'CL29101095', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000037', '邯郸到唐山货源', '服装', '整车', '80', '邯郸', '唐山', '2015-01-26', '2015-01-29', null, '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿', null, null);
INSERT INTO `goodsform` VALUES ('GO00000038', '胶州到莱芜货源', '服装', '整车', '40', '胶州', '莱芜', '2015-01-26', '2015-01-29', null, '平板车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL78387917', '', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000039', '静宁到敦煌货源', '服装', '整车', '11', '静宁', '敦煌', '2015-01-26', '2015-01-29', null, '6.6米高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL78387917', 'CL29101095', '本批货物为贵重物品，请轻拿轻放', null, null);
INSERT INTO `goodsform` VALUES ('GO00000040', '成都到宜宾货源', '服装', '整车', '10', '成都', '宜宾', '2015-01-26', '2015-01-29', null, '6.8米高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL78387917', 'CL73207711', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿', null, null);
