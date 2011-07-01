/*
Navicat MySQL Data Transfer

Source Server         : localhost_root
Source Server Version : 50144
Source Host           : localhost:3306
Source Database       : dialectwiki

Target Server Type    : MYSQL
Target Server Version : 50144
File Encoding         : 65001

Date: 2011-07-01 20:29:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `authorities`
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`username`,`authority`),
  KEY `fk_authorites_users1` (`username`),
  CONSTRAINT `fk_authorites_users1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES ('hitchimp', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for `dw_city`
-- ----------------------------
DROP TABLE IF EXISTS `dw_city`;
CREATE TABLE `dw_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) DEFAULT NULL,
  `province_id` int(11) NOT NULL,
  PRIMARY KEY (`city_id`),
  KEY `fk_dw_city_dw_province1` (`province_id`),
  CONSTRAINT `fk_dw_city_dw_province1` FOREIGN KEY (`province_id`) REFERENCES `dw_province` (`province_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=480 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dw_city
-- ----------------------------
INSERT INTO `dw_city` VALUES ('1', '东城区', '1');
INSERT INTO `dw_city` VALUES ('2', '西城区', '1');
INSERT INTO `dw_city` VALUES ('3', '崇文区', '1');
INSERT INTO `dw_city` VALUES ('4', '宣武区', '1');
INSERT INTO `dw_city` VALUES ('5', '朝阳区', '1');
INSERT INTO `dw_city` VALUES ('6', '丰台区', '1');
INSERT INTO `dw_city` VALUES ('7', '石景山区', '1');
INSERT INTO `dw_city` VALUES ('8', '海淀区', '1');
INSERT INTO `dw_city` VALUES ('9', '门头沟区', '1');
INSERT INTO `dw_city` VALUES ('10', '房山区', '1');
INSERT INTO `dw_city` VALUES ('11', '通州区', '1');
INSERT INTO `dw_city` VALUES ('12', '顺义区', '1');
INSERT INTO `dw_city` VALUES ('13', '昌平区', '1');
INSERT INTO `dw_city` VALUES ('14', '大兴区', '1');
INSERT INTO `dw_city` VALUES ('15', '怀柔区', '1');
INSERT INTO `dw_city` VALUES ('16', '平谷区', '1');
INSERT INTO `dw_city` VALUES ('17', '密云县', '1');
INSERT INTO `dw_city` VALUES ('18', '延庆县', '1');
INSERT INTO `dw_city` VALUES ('19', '黄浦区', '2');
INSERT INTO `dw_city` VALUES ('20', '卢湾区', '2');
INSERT INTO `dw_city` VALUES ('21', '徐汇区', '2');
INSERT INTO `dw_city` VALUES ('22', '长宁区', '2');
INSERT INTO `dw_city` VALUES ('23', '静安区', '2');
INSERT INTO `dw_city` VALUES ('24', '普陀区', '2');
INSERT INTO `dw_city` VALUES ('25', '闸北区', '2');
INSERT INTO `dw_city` VALUES ('26', '虹口区', '2');
INSERT INTO `dw_city` VALUES ('27', '杨浦区', '2');
INSERT INTO `dw_city` VALUES ('28', '闵行区', '2');
INSERT INTO `dw_city` VALUES ('29', '宝山区', '2');
INSERT INTO `dw_city` VALUES ('30', '嘉定区', '2');
INSERT INTO `dw_city` VALUES ('31', '浦东新区', '2');
INSERT INTO `dw_city` VALUES ('32', '金山区', '2');
INSERT INTO `dw_city` VALUES ('33', '松江区', '2');
INSERT INTO `dw_city` VALUES ('34', '青浦区', '2');
INSERT INTO `dw_city` VALUES ('35', '南汇区', '2');
INSERT INTO `dw_city` VALUES ('36', '奉贤区', '2');
INSERT INTO `dw_city` VALUES ('37', '崇明县', '2');
INSERT INTO `dw_city` VALUES ('38', '和平区', '3');
INSERT INTO `dw_city` VALUES ('39', '河东区', '3');
INSERT INTO `dw_city` VALUES ('40', '河西区', '3');
INSERT INTO `dw_city` VALUES ('41', '南开区', '3');
INSERT INTO `dw_city` VALUES ('42', '河北区', '3');
INSERT INTO `dw_city` VALUES ('43', '红桥区', '3');
INSERT INTO `dw_city` VALUES ('44', '塘沽区', '3');
INSERT INTO `dw_city` VALUES ('45', '汉沽区', '3');
INSERT INTO `dw_city` VALUES ('46', '大港区', '3');
INSERT INTO `dw_city` VALUES ('47', '东丽区', '3');
INSERT INTO `dw_city` VALUES ('48', '西青区', '3');
INSERT INTO `dw_city` VALUES ('49', '津南区', '3');
INSERT INTO `dw_city` VALUES ('50', '北辰区', '3');
INSERT INTO `dw_city` VALUES ('51', '武清区', '3');
INSERT INTO `dw_city` VALUES ('52', '宝坻区', '3');
INSERT INTO `dw_city` VALUES ('53', '宁河县', '3');
INSERT INTO `dw_city` VALUES ('54', '静海县', '3');
INSERT INTO `dw_city` VALUES ('55', '蓟县', '3');
INSERT INTO `dw_city` VALUES ('56', '万州区', '4');
INSERT INTO `dw_city` VALUES ('57', '涪陵区', '4');
INSERT INTO `dw_city` VALUES ('58', '渝中区', '4');
INSERT INTO `dw_city` VALUES ('59', '大渡口区', '4');
INSERT INTO `dw_city` VALUES ('60', '江北区', '4');
INSERT INTO `dw_city` VALUES ('61', '沙坪坝区', '4');
INSERT INTO `dw_city` VALUES ('62', '九龙坡区', '4');
INSERT INTO `dw_city` VALUES ('63', '南岸区', '4');
INSERT INTO `dw_city` VALUES ('64', '北碚区', '4');
INSERT INTO `dw_city` VALUES ('65', '万盛区', '4');
INSERT INTO `dw_city` VALUES ('66', '双桥区', '4');
INSERT INTO `dw_city` VALUES ('67', '渝北区', '4');
INSERT INTO `dw_city` VALUES ('68', '巴南区', '4');
INSERT INTO `dw_city` VALUES ('69', '黔江区', '4');
INSERT INTO `dw_city` VALUES ('70', '长寿区', '4');
INSERT INTO `dw_city` VALUES ('71', '江津区', '4');
INSERT INTO `dw_city` VALUES ('72', '合川区', '4');
INSERT INTO `dw_city` VALUES ('73', '永川区', '4');
INSERT INTO `dw_city` VALUES ('74', '南川区', '4');
INSERT INTO `dw_city` VALUES ('75', '綦江县', '4');
INSERT INTO `dw_city` VALUES ('76', '潼南县', '4');
INSERT INTO `dw_city` VALUES ('77', '铜梁县', '4');
INSERT INTO `dw_city` VALUES ('78', '大足县', '4');
INSERT INTO `dw_city` VALUES ('79', '荣昌县', '4');
INSERT INTO `dw_city` VALUES ('80', '璧山县', '4');
INSERT INTO `dw_city` VALUES ('81', '梁平县', '4');
INSERT INTO `dw_city` VALUES ('82', '城口县', '4');
INSERT INTO `dw_city` VALUES ('83', '丰都县', '4');
INSERT INTO `dw_city` VALUES ('84', '垫江县', '4');
INSERT INTO `dw_city` VALUES ('85', '武隆县', '4');
INSERT INTO `dw_city` VALUES ('86', '忠县', '4');
INSERT INTO `dw_city` VALUES ('87', '开县', '4');
INSERT INTO `dw_city` VALUES ('88', '云阳县', '4');
INSERT INTO `dw_city` VALUES ('89', '奉节县', '4');
INSERT INTO `dw_city` VALUES ('90', '巫山县', '4');
INSERT INTO `dw_city` VALUES ('91', '巫溪县', '4');
INSERT INTO `dw_city` VALUES ('92', '石柱土家族自治县', '4');
INSERT INTO `dw_city` VALUES ('93', '秀山土家族苗族自治县', '4');
INSERT INTO `dw_city` VALUES ('94', '酉阳土家族苗族自治县', '4');
INSERT INTO `dw_city` VALUES ('95', '彭水苗族土家族自治县', '4');
INSERT INTO `dw_city` VALUES ('96', '哈尔滨市', '5');
INSERT INTO `dw_city` VALUES ('97', '齐齐哈尔市', '5');
INSERT INTO `dw_city` VALUES ('98', '鸡西市', '5');
INSERT INTO `dw_city` VALUES ('99', '鹤岗市', '5');
INSERT INTO `dw_city` VALUES ('100', '双鸭山市', '5');
INSERT INTO `dw_city` VALUES ('101', '大庆市', '5');
INSERT INTO `dw_city` VALUES ('102', '伊春市', '5');
INSERT INTO `dw_city` VALUES ('103', '佳木斯市', '5');
INSERT INTO `dw_city` VALUES ('104', '七台河市', '5');
INSERT INTO `dw_city` VALUES ('105', '牡丹江市', '5');
INSERT INTO `dw_city` VALUES ('106', '黑河市', '5');
INSERT INTO `dw_city` VALUES ('107', '绥化市', '5');
INSERT INTO `dw_city` VALUES ('108', '大兴安岭地区', '5');
INSERT INTO `dw_city` VALUES ('109', '长春市', '6');
INSERT INTO `dw_city` VALUES ('110', '吉林市', '6');
INSERT INTO `dw_city` VALUES ('111', '四平市', '6');
INSERT INTO `dw_city` VALUES ('112', '辽源市', '6');
INSERT INTO `dw_city` VALUES ('113', '通化市', '6');
INSERT INTO `dw_city` VALUES ('114', '白山市', '6');
INSERT INTO `dw_city` VALUES ('115', '松原市', '6');
INSERT INTO `dw_city` VALUES ('116', '白城市', '6');
INSERT INTO `dw_city` VALUES ('117', '延边朝鲜族自治州', '6');
INSERT INTO `dw_city` VALUES ('118', '沈阳市', '7');
INSERT INTO `dw_city` VALUES ('119', '大连市', '7');
INSERT INTO `dw_city` VALUES ('120', '鞍山市', '7');
INSERT INTO `dw_city` VALUES ('121', '抚顺市', '7');
INSERT INTO `dw_city` VALUES ('122', '本溪市', '7');
INSERT INTO `dw_city` VALUES ('123', '丹东市', '7');
INSERT INTO `dw_city` VALUES ('124', '锦州市', '7');
INSERT INTO `dw_city` VALUES ('125', '营口市', '7');
INSERT INTO `dw_city` VALUES ('126', '阜新市', '7');
INSERT INTO `dw_city` VALUES ('127', '辽阳市', '7');
INSERT INTO `dw_city` VALUES ('128', '盘锦市', '7');
INSERT INTO `dw_city` VALUES ('129', '铁岭市', '7');
INSERT INTO `dw_city` VALUES ('130', '朝阳市', '7');
INSERT INTO `dw_city` VALUES ('131', '葫芦岛市', '7');
INSERT INTO `dw_city` VALUES ('132', '济南市', '8');
INSERT INTO `dw_city` VALUES ('133', '青岛市', '8');
INSERT INTO `dw_city` VALUES ('134', '淄博市', '8');
INSERT INTO `dw_city` VALUES ('135', '枣庄市', '8');
INSERT INTO `dw_city` VALUES ('136', '东营市', '8');
INSERT INTO `dw_city` VALUES ('137', '烟台市', '8');
INSERT INTO `dw_city` VALUES ('138', '潍坊市', '8');
INSERT INTO `dw_city` VALUES ('139', '济宁市', '8');
INSERT INTO `dw_city` VALUES ('140', '泰安市', '8');
INSERT INTO `dw_city` VALUES ('141', '威海市', '8');
INSERT INTO `dw_city` VALUES ('142', '日照市', '8');
INSERT INTO `dw_city` VALUES ('143', '莱芜市', '8');
INSERT INTO `dw_city` VALUES ('144', '临沂市', '8');
INSERT INTO `dw_city` VALUES ('145', '德州市', '8');
INSERT INTO `dw_city` VALUES ('146', '聊城市', '8');
INSERT INTO `dw_city` VALUES ('147', '滨州市', '8');
INSERT INTO `dw_city` VALUES ('148', '菏泽市', '8');
INSERT INTO `dw_city` VALUES ('149', '太原市', '9');
INSERT INTO `dw_city` VALUES ('150', '大同市', '9');
INSERT INTO `dw_city` VALUES ('151', '阳泉市', '9');
INSERT INTO `dw_city` VALUES ('152', '长治市', '9');
INSERT INTO `dw_city` VALUES ('153', '晋城市', '9');
INSERT INTO `dw_city` VALUES ('154', '朔州市', '9');
INSERT INTO `dw_city` VALUES ('155', '晋中市', '9');
INSERT INTO `dw_city` VALUES ('156', '运城市', '9');
INSERT INTO `dw_city` VALUES ('157', '忻州市', '9');
INSERT INTO `dw_city` VALUES ('158', '临汾市', '9');
INSERT INTO `dw_city` VALUES ('159', '吕梁市', '9');
INSERT INTO `dw_city` VALUES ('160', '西安市', '10');
INSERT INTO `dw_city` VALUES ('161', '铜川市', '10');
INSERT INTO `dw_city` VALUES ('162', '宝鸡市', '10');
INSERT INTO `dw_city` VALUES ('163', '咸阳市', '10');
INSERT INTO `dw_city` VALUES ('164', '渭南市', '10');
INSERT INTO `dw_city` VALUES ('165', '延安市', '10');
INSERT INTO `dw_city` VALUES ('166', '汉中市', '10');
INSERT INTO `dw_city` VALUES ('167', '榆林市', '10');
INSERT INTO `dw_city` VALUES ('168', '安康市', '10');
INSERT INTO `dw_city` VALUES ('169', '商洛市', '10');
INSERT INTO `dw_city` VALUES ('170', '石家庄市', '11');
INSERT INTO `dw_city` VALUES ('171', '唐山市', '11');
INSERT INTO `dw_city` VALUES ('172', '秦皇岛市', '11');
INSERT INTO `dw_city` VALUES ('173', '邯郸市', '11');
INSERT INTO `dw_city` VALUES ('174', '邢台市', '11');
INSERT INTO `dw_city` VALUES ('175', '保定市', '11');
INSERT INTO `dw_city` VALUES ('176', '张家口市', '11');
INSERT INTO `dw_city` VALUES ('177', '承德市', '11');
INSERT INTO `dw_city` VALUES ('178', '沧州市', '11');
INSERT INTO `dw_city` VALUES ('179', '廊坊市', '11');
INSERT INTO `dw_city` VALUES ('180', '衡水市', '11');
INSERT INTO `dw_city` VALUES ('181', '郑州市', '12');
INSERT INTO `dw_city` VALUES ('182', '开封市', '12');
INSERT INTO `dw_city` VALUES ('183', '洛阳市', '12');
INSERT INTO `dw_city` VALUES ('184', '平顶山市', '12');
INSERT INTO `dw_city` VALUES ('185', '安阳市', '12');
INSERT INTO `dw_city` VALUES ('186', '鹤壁市', '12');
INSERT INTO `dw_city` VALUES ('187', '新乡市', '12');
INSERT INTO `dw_city` VALUES ('188', '焦作市', '12');
INSERT INTO `dw_city` VALUES ('189', '济源市', '12');
INSERT INTO `dw_city` VALUES ('190', '濮阳市', '12');
INSERT INTO `dw_city` VALUES ('191', '许昌市', '12');
INSERT INTO `dw_city` VALUES ('192', '漯河市', '12');
INSERT INTO `dw_city` VALUES ('193', '三门峡市', '12');
INSERT INTO `dw_city` VALUES ('194', '南阳市', '12');
INSERT INTO `dw_city` VALUES ('195', '商丘市', '12');
INSERT INTO `dw_city` VALUES ('196', '信阳市', '12');
INSERT INTO `dw_city` VALUES ('197', '周口市', '12');
INSERT INTO `dw_city` VALUES ('198', '驻马店市', '12');
INSERT INTO `dw_city` VALUES ('199', '武汉市', '13');
INSERT INTO `dw_city` VALUES ('200', '黄石市', '13');
INSERT INTO `dw_city` VALUES ('201', '十堰市', '13');
INSERT INTO `dw_city` VALUES ('202', '宜昌市', '13');
INSERT INTO `dw_city` VALUES ('203', '襄樊市', '13');
INSERT INTO `dw_city` VALUES ('204', '鄂州市', '13');
INSERT INTO `dw_city` VALUES ('205', '荆门市', '13');
INSERT INTO `dw_city` VALUES ('206', '孝感市', '13');
INSERT INTO `dw_city` VALUES ('207', '荆州市', '13');
INSERT INTO `dw_city` VALUES ('208', '黄冈市', '13');
INSERT INTO `dw_city` VALUES ('209', '咸宁市', '13');
INSERT INTO `dw_city` VALUES ('210', '随州市', '13');
INSERT INTO `dw_city` VALUES ('211', '恩施土家族苗族自治州', '13');
INSERT INTO `dw_city` VALUES ('212', '仙桃市', '13');
INSERT INTO `dw_city` VALUES ('213', '潜江市', '13');
INSERT INTO `dw_city` VALUES ('214', '天门市', '13');
INSERT INTO `dw_city` VALUES ('215', '神农架林区', '13');
INSERT INTO `dw_city` VALUES ('216', '长沙市', '14');
INSERT INTO `dw_city` VALUES ('217', '株洲市', '14');
INSERT INTO `dw_city` VALUES ('218', '湘潭市', '14');
INSERT INTO `dw_city` VALUES ('219', '衡阳市', '14');
INSERT INTO `dw_city` VALUES ('220', '邵阳市', '14');
INSERT INTO `dw_city` VALUES ('221', '岳阳市', '14');
INSERT INTO `dw_city` VALUES ('222', '常德市', '14');
INSERT INTO `dw_city` VALUES ('223', '张家界市', '14');
INSERT INTO `dw_city` VALUES ('224', '益阳市', '14');
INSERT INTO `dw_city` VALUES ('225', '郴州市', '14');
INSERT INTO `dw_city` VALUES ('226', '永州市', '14');
INSERT INTO `dw_city` VALUES ('227', '怀化市', '14');
INSERT INTO `dw_city` VALUES ('228', '娄底市', '14');
INSERT INTO `dw_city` VALUES ('229', '湘西土家族苗族自治州', '14');
INSERT INTO `dw_city` VALUES ('230', '海口市', '15');
INSERT INTO `dw_city` VALUES ('231', '三亚市', '15');
INSERT INTO `dw_city` VALUES ('232', '五指山市', '15');
INSERT INTO `dw_city` VALUES ('233', '琼海市', '15');
INSERT INTO `dw_city` VALUES ('234', '儋州市', '15');
INSERT INTO `dw_city` VALUES ('235', '文昌市', '15');
INSERT INTO `dw_city` VALUES ('236', '万宁市', '15');
INSERT INTO `dw_city` VALUES ('237', '东方市', '15');
INSERT INTO `dw_city` VALUES ('238', '定安县', '15');
INSERT INTO `dw_city` VALUES ('239', '屯昌县', '15');
INSERT INTO `dw_city` VALUES ('240', '澄迈县', '15');
INSERT INTO `dw_city` VALUES ('241', '临高县', '15');
INSERT INTO `dw_city` VALUES ('242', '白沙黎族自治县', '15');
INSERT INTO `dw_city` VALUES ('243', '昌江黎族自治县', '15');
INSERT INTO `dw_city` VALUES ('244', '乐东黎族自治县', '15');
INSERT INTO `dw_city` VALUES ('245', '陵水黎族自治县', '15');
INSERT INTO `dw_city` VALUES ('246', '保亭黎族苗族自治县', '15');
INSERT INTO `dw_city` VALUES ('247', '琼中黎族苗族自治县', '15');
INSERT INTO `dw_city` VALUES ('248', '南京市', '16');
INSERT INTO `dw_city` VALUES ('249', '无锡市', '16');
INSERT INTO `dw_city` VALUES ('250', '徐州市', '16');
INSERT INTO `dw_city` VALUES ('251', '常州市', '16');
INSERT INTO `dw_city` VALUES ('252', '苏州市', '16');
INSERT INTO `dw_city` VALUES ('253', '南通市', '16');
INSERT INTO `dw_city` VALUES ('254', '连云港市', '16');
INSERT INTO `dw_city` VALUES ('255', '淮安市', '16');
INSERT INTO `dw_city` VALUES ('256', '盐城市', '16');
INSERT INTO `dw_city` VALUES ('257', '扬州市', '16');
INSERT INTO `dw_city` VALUES ('258', '镇江市', '16');
INSERT INTO `dw_city` VALUES ('259', '泰州市', '16');
INSERT INTO `dw_city` VALUES ('260', '宿迁市', '16');
INSERT INTO `dw_city` VALUES ('261', '南昌市', '17');
INSERT INTO `dw_city` VALUES ('262', '景德镇市', '17');
INSERT INTO `dw_city` VALUES ('263', '萍乡市', '17');
INSERT INTO `dw_city` VALUES ('264', '九江市', '17');
INSERT INTO `dw_city` VALUES ('265', '新余市', '17');
INSERT INTO `dw_city` VALUES ('266', '鹰潭市', '17');
INSERT INTO `dw_city` VALUES ('267', '赣州市', '17');
INSERT INTO `dw_city` VALUES ('268', '吉安市', '17');
INSERT INTO `dw_city` VALUES ('269', '宜春市', '17');
INSERT INTO `dw_city` VALUES ('270', '抚州市', '17');
INSERT INTO `dw_city` VALUES ('271', '上饶市', '17');
INSERT INTO `dw_city` VALUES ('272', '广州市', '18');
INSERT INTO `dw_city` VALUES ('273', '韶关市', '18');
INSERT INTO `dw_city` VALUES ('274', '深圳市', '18');
INSERT INTO `dw_city` VALUES ('275', '珠海市', '18');
INSERT INTO `dw_city` VALUES ('276', '汕头市', '18');
INSERT INTO `dw_city` VALUES ('277', '佛山市', '18');
INSERT INTO `dw_city` VALUES ('278', '江门市', '18');
INSERT INTO `dw_city` VALUES ('279', '湛江市', '18');
INSERT INTO `dw_city` VALUES ('280', '茂名市', '18');
INSERT INTO `dw_city` VALUES ('281', '肇庆市', '18');
INSERT INTO `dw_city` VALUES ('282', '惠州市', '18');
INSERT INTO `dw_city` VALUES ('283', '梅州市', '18');
INSERT INTO `dw_city` VALUES ('284', '汕尾市', '18');
INSERT INTO `dw_city` VALUES ('285', '河源市', '18');
INSERT INTO `dw_city` VALUES ('286', '阳江市', '18');
INSERT INTO `dw_city` VALUES ('287', '清远市', '18');
INSERT INTO `dw_city` VALUES ('288', '东莞市', '18');
INSERT INTO `dw_city` VALUES ('289', '中山市', '18');
INSERT INTO `dw_city` VALUES ('290', '潮州市', '18');
INSERT INTO `dw_city` VALUES ('291', '揭阳市', '18');
INSERT INTO `dw_city` VALUES ('292', '云浮市', '18');
INSERT INTO `dw_city` VALUES ('293', '南宁市', '19');
INSERT INTO `dw_city` VALUES ('294', '柳州市', '19');
INSERT INTO `dw_city` VALUES ('295', '桂林市', '19');
INSERT INTO `dw_city` VALUES ('296', '梧州市', '19');
INSERT INTO `dw_city` VALUES ('297', '北海市', '19');
INSERT INTO `dw_city` VALUES ('298', '防城港市', '19');
INSERT INTO `dw_city` VALUES ('299', '钦州市', '19');
INSERT INTO `dw_city` VALUES ('300', '贵港市', '19');
INSERT INTO `dw_city` VALUES ('301', '玉林市', '19');
INSERT INTO `dw_city` VALUES ('302', '百色市', '19');
INSERT INTO `dw_city` VALUES ('303', '贺州市', '19');
INSERT INTO `dw_city` VALUES ('304', '河池市', '19');
INSERT INTO `dw_city` VALUES ('305', '来宾市', '19');
INSERT INTO `dw_city` VALUES ('306', '崇左市', '19');
INSERT INTO `dw_city` VALUES ('307', '昆明市', '20');
INSERT INTO `dw_city` VALUES ('308', '曲靖市', '20');
INSERT INTO `dw_city` VALUES ('309', '玉溪市', '20');
INSERT INTO `dw_city` VALUES ('310', '保山市', '20');
INSERT INTO `dw_city` VALUES ('311', '昭通市', '20');
INSERT INTO `dw_city` VALUES ('312', '丽江市', '20');
INSERT INTO `dw_city` VALUES ('313', '思茅市', '20');
INSERT INTO `dw_city` VALUES ('314', '临沧市', '20');
INSERT INTO `dw_city` VALUES ('315', '楚雄彝族自治州', '20');
INSERT INTO `dw_city` VALUES ('316', '红河哈尼族彝族自治州', '20');
INSERT INTO `dw_city` VALUES ('317', '文山壮族苗族自治州', '20');
INSERT INTO `dw_city` VALUES ('318', '西双版纳傣族自治州', '20');
INSERT INTO `dw_city` VALUES ('319', '大理白族自治州', '20');
INSERT INTO `dw_city` VALUES ('320', '德宏傣族景颇族自治州', '20');
INSERT INTO `dw_city` VALUES ('321', '怒江傈僳族自治州', '20');
INSERT INTO `dw_city` VALUES ('322', '迪庆藏族自治州', '20');
INSERT INTO `dw_city` VALUES ('323', '贵阳市', '21');
INSERT INTO `dw_city` VALUES ('324', '六盘水市', '21');
INSERT INTO `dw_city` VALUES ('325', '遵义市', '21');
INSERT INTO `dw_city` VALUES ('326', '安顺市', '21');
INSERT INTO `dw_city` VALUES ('327', '铜仁地区', '21');
INSERT INTO `dw_city` VALUES ('328', '黔西南布依族苗族自治州', '21');
INSERT INTO `dw_city` VALUES ('329', '毕节地区', '21');
INSERT INTO `dw_city` VALUES ('330', '黔东南苗族侗族自治州', '21');
INSERT INTO `dw_city` VALUES ('331', '黔南布依族苗族自治州', '21');
INSERT INTO `dw_city` VALUES ('332', '成都市', '22');
INSERT INTO `dw_city` VALUES ('333', '自贡市', '22');
INSERT INTO `dw_city` VALUES ('334', '攀枝花市', '22');
INSERT INTO `dw_city` VALUES ('335', '泸州市', '22');
INSERT INTO `dw_city` VALUES ('336', '德阳市', '22');
INSERT INTO `dw_city` VALUES ('337', '绵阳市', '22');
INSERT INTO `dw_city` VALUES ('338', '广元市', '22');
INSERT INTO `dw_city` VALUES ('339', '遂宁市', '22');
INSERT INTO `dw_city` VALUES ('340', '内江市', '22');
INSERT INTO `dw_city` VALUES ('341', '乐山市', '22');
INSERT INTO `dw_city` VALUES ('342', '南充市', '22');
INSERT INTO `dw_city` VALUES ('343', '眉山市', '22');
INSERT INTO `dw_city` VALUES ('344', '宜宾市', '22');
INSERT INTO `dw_city` VALUES ('345', '广安市', '22');
INSERT INTO `dw_city` VALUES ('346', '达州市', '22');
INSERT INTO `dw_city` VALUES ('347', '雅安市', '22');
INSERT INTO `dw_city` VALUES ('348', '巴中市', '22');
INSERT INTO `dw_city` VALUES ('349', '资阳市', '22');
INSERT INTO `dw_city` VALUES ('350', '阿坝藏族羌族自治州', '22');
INSERT INTO `dw_city` VALUES ('351', '甘孜藏族自治州', '22');
INSERT INTO `dw_city` VALUES ('352', '凉山彝族自治州', '22');
INSERT INTO `dw_city` VALUES ('353', '呼和浩特市', '23');
INSERT INTO `dw_city` VALUES ('354', '包头市', '23');
INSERT INTO `dw_city` VALUES ('355', '乌海市', '23');
INSERT INTO `dw_city` VALUES ('356', '赤峰市', '23');
INSERT INTO `dw_city` VALUES ('357', '通辽市', '23');
INSERT INTO `dw_city` VALUES ('358', '鄂尔多斯市', '23');
INSERT INTO `dw_city` VALUES ('359', '呼伦贝尔市', '23');
INSERT INTO `dw_city` VALUES ('360', '巴彦淖尔市', '23');
INSERT INTO `dw_city` VALUES ('361', '乌兰察布市', '23');
INSERT INTO `dw_city` VALUES ('362', '兴安盟', '23');
INSERT INTO `dw_city` VALUES ('363', '锡林郭勒盟', '23');
INSERT INTO `dw_city` VALUES ('364', '阿拉善盟', '23');
INSERT INTO `dw_city` VALUES ('365', '银川市', '24');
INSERT INTO `dw_city` VALUES ('366', '石嘴山市', '24');
INSERT INTO `dw_city` VALUES ('367', '吴忠市', '24');
INSERT INTO `dw_city` VALUES ('368', '固原市', '24');
INSERT INTO `dw_city` VALUES ('369', '中卫市', '24');
INSERT INTO `dw_city` VALUES ('370', '兰州市', '25');
INSERT INTO `dw_city` VALUES ('371', '嘉峪关市', '25');
INSERT INTO `dw_city` VALUES ('372', '金昌市', '25');
INSERT INTO `dw_city` VALUES ('373', '白银市', '25');
INSERT INTO `dw_city` VALUES ('374', '天水市', '25');
INSERT INTO `dw_city` VALUES ('375', '武威市', '25');
INSERT INTO `dw_city` VALUES ('376', '张掖市', '25');
INSERT INTO `dw_city` VALUES ('377', '平凉市', '25');
INSERT INTO `dw_city` VALUES ('378', '酒泉市', '25');
INSERT INTO `dw_city` VALUES ('379', '庆阳市', '25');
INSERT INTO `dw_city` VALUES ('380', '定西市', '25');
INSERT INTO `dw_city` VALUES ('381', '陇南市', '25');
INSERT INTO `dw_city` VALUES ('382', '临夏回族自治州', '25');
INSERT INTO `dw_city` VALUES ('383', '甘南藏族自治州', '25');
INSERT INTO `dw_city` VALUES ('384', '西宁市', '26');
INSERT INTO `dw_city` VALUES ('385', '海东地区', '26');
INSERT INTO `dw_city` VALUES ('386', '海北藏族自治州', '26');
INSERT INTO `dw_city` VALUES ('387', '黄南藏族自治州', '26');
INSERT INTO `dw_city` VALUES ('388', '海南藏族自治州', '26');
INSERT INTO `dw_city` VALUES ('389', '果洛藏族自治州', '26');
INSERT INTO `dw_city` VALUES ('390', '玉树藏族自治州', '26');
INSERT INTO `dw_city` VALUES ('391', '海西蒙古族藏族自治州', '26');
INSERT INTO `dw_city` VALUES ('392', '拉萨市', '27');
INSERT INTO `dw_city` VALUES ('393', '昌都地区', '27');
INSERT INTO `dw_city` VALUES ('394', '山南地区', '27');
INSERT INTO `dw_city` VALUES ('395', '日喀则地区', '27');
INSERT INTO `dw_city` VALUES ('396', '那曲地区', '27');
INSERT INTO `dw_city` VALUES ('397', '阿里地区', '27');
INSERT INTO `dw_city` VALUES ('398', '林芝地区', '27');
INSERT INTO `dw_city` VALUES ('399', '乌鲁木齐市', '28');
INSERT INTO `dw_city` VALUES ('400', '克拉玛依市', '28');
INSERT INTO `dw_city` VALUES ('401', '吐鲁番地区', '28');
INSERT INTO `dw_city` VALUES ('402', '哈密地区', '28');
INSERT INTO `dw_city` VALUES ('403', '昌吉回族自治州', '28');
INSERT INTO `dw_city` VALUES ('404', '博尔塔拉蒙古自治州', '28');
INSERT INTO `dw_city` VALUES ('405', '巴音郭楞蒙古自治州', '28');
INSERT INTO `dw_city` VALUES ('406', '阿克苏地区', '28');
INSERT INTO `dw_city` VALUES ('407', '克孜勒苏柯尔克孜自治州', '28');
INSERT INTO `dw_city` VALUES ('408', '喀什地区', '28');
INSERT INTO `dw_city` VALUES ('409', '和田地区', '28');
INSERT INTO `dw_city` VALUES ('410', '伊犁哈萨克自治州', '28');
INSERT INTO `dw_city` VALUES ('411', '塔城地区', '28');
INSERT INTO `dw_city` VALUES ('412', '阿勒泰地区', '28');
INSERT INTO `dw_city` VALUES ('413', '石河子市', '28');
INSERT INTO `dw_city` VALUES ('414', '阿拉尔市', '28');
INSERT INTO `dw_city` VALUES ('415', '图木舒克市', '28');
INSERT INTO `dw_city` VALUES ('416', '五家渠市', '28');
INSERT INTO `dw_city` VALUES ('417', '合肥市', '29');
INSERT INTO `dw_city` VALUES ('418', '芜湖市', '29');
INSERT INTO `dw_city` VALUES ('419', '蚌埠市', '29');
INSERT INTO `dw_city` VALUES ('420', '淮南市', '29');
INSERT INTO `dw_city` VALUES ('421', '马鞍山市', '29');
INSERT INTO `dw_city` VALUES ('422', '淮北市', '29');
INSERT INTO `dw_city` VALUES ('423', '铜陵市', '29');
INSERT INTO `dw_city` VALUES ('424', '安庆市', '29');
INSERT INTO `dw_city` VALUES ('425', '黄山市', '29');
INSERT INTO `dw_city` VALUES ('426', '滁州市', '29');
INSERT INTO `dw_city` VALUES ('427', '阜阳市', '29');
INSERT INTO `dw_city` VALUES ('428', '宿州市', '29');
INSERT INTO `dw_city` VALUES ('429', '巢湖市', '29');
INSERT INTO `dw_city` VALUES ('430', '六安市', '29');
INSERT INTO `dw_city` VALUES ('431', '亳州市', '29');
INSERT INTO `dw_city` VALUES ('432', '池州市', '29');
INSERT INTO `dw_city` VALUES ('433', '宣城市', '29');
INSERT INTO `dw_city` VALUES ('434', '杭州市', '30');
INSERT INTO `dw_city` VALUES ('435', '宁波市', '30');
INSERT INTO `dw_city` VALUES ('436', '温州市', '30');
INSERT INTO `dw_city` VALUES ('437', '嘉兴市', '30');
INSERT INTO `dw_city` VALUES ('438', '湖州市', '30');
INSERT INTO `dw_city` VALUES ('439', '绍兴市', '30');
INSERT INTO `dw_city` VALUES ('440', '金华市', '30');
INSERT INTO `dw_city` VALUES ('441', '衢州市', '30');
INSERT INTO `dw_city` VALUES ('442', '舟山市', '30');
INSERT INTO `dw_city` VALUES ('443', '台州市', '30');
INSERT INTO `dw_city` VALUES ('444', '丽水市', '30');
INSERT INTO `dw_city` VALUES ('445', '福州市', '31');
INSERT INTO `dw_city` VALUES ('446', '厦门市', '31');
INSERT INTO `dw_city` VALUES ('447', '莆田市', '31');
INSERT INTO `dw_city` VALUES ('448', '三明市', '31');
INSERT INTO `dw_city` VALUES ('449', '泉州市', '31');
INSERT INTO `dw_city` VALUES ('450', '漳州市', '31');
INSERT INTO `dw_city` VALUES ('451', '南平市', '31');
INSERT INTO `dw_city` VALUES ('452', '龙岩市', '31');
INSERT INTO `dw_city` VALUES ('453', '宁德市', '31');
INSERT INTO `dw_city` VALUES ('454', '台北市', '32');
INSERT INTO `dw_city` VALUES ('455', '高雄市', '32');
INSERT INTO `dw_city` VALUES ('456', '基隆市', '32');
INSERT INTO `dw_city` VALUES ('457', '台中市', '32');
INSERT INTO `dw_city` VALUES ('458', '台南市', '32');
INSERT INTO `dw_city` VALUES ('459', '新竹市', '32');
INSERT INTO `dw_city` VALUES ('460', '嘉义市', '32');
INSERT INTO `dw_city` VALUES ('461', '中西区', '33');
INSERT INTO `dw_city` VALUES ('462', '湾仔区', '33');
INSERT INTO `dw_city` VALUES ('463', '东区', '33');
INSERT INTO `dw_city` VALUES ('464', '南区', '33');
INSERT INTO `dw_city` VALUES ('465', '油尖旺区', '33');
INSERT INTO `dw_city` VALUES ('466', '深水埗区', '33');
INSERT INTO `dw_city` VALUES ('467', '九龙城区', '33');
INSERT INTO `dw_city` VALUES ('468', '黄大仙区', '33');
INSERT INTO `dw_city` VALUES ('469', '观塘区', '33');
INSERT INTO `dw_city` VALUES ('470', '荃湾区', '33');
INSERT INTO `dw_city` VALUES ('471', '葵青区', '33');
INSERT INTO `dw_city` VALUES ('472', '沙田区', '33');
INSERT INTO `dw_city` VALUES ('473', '西贡区', '33');
INSERT INTO `dw_city` VALUES ('474', '大埔区', '33');
INSERT INTO `dw_city` VALUES ('475', '北区', '33');
INSERT INTO `dw_city` VALUES ('476', '元朗区', '33');
INSERT INTO `dw_city` VALUES ('477', '屯门区', '33');
INSERT INTO `dw_city` VALUES ('478', '离岛区', '33');
INSERT INTO `dw_city` VALUES ('479', '澳门', '34');

-- ----------------------------
-- Table structure for `dw_pronunciation`
-- ----------------------------
DROP TABLE IF EXISTS `dw_pronunciation`;
CREATE TABLE `dw_pronunciation` (
  `pron_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `word_id` int(11) NOT NULL,
  `pr_url` varchar(45) DEFAULT NULL,
  `upload_date` date DEFAULT NULL,
  `good_vote_num` int(11) NOT NULL DEFAULT '0',
  `bad_vote_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pron_id`),
  KEY `fk_dw_pronunciation_dw_city1` (`city_id`),
  KEY `fk_dw_pronunciation_users1` (`user_id`),
  KEY `fk_dw_pronunciation_dw_word1` (`word_id`),
  CONSTRAINT `fk_dw_pronunciation_dw_city1` FOREIGN KEY (`city_id`) REFERENCES `dw_city` (`city_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dw_pronunciation_dw_word1` FOREIGN KEY (`word_id`) REFERENCES `dw_word` (`word_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dw_pronunciation_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dw_pronunciation
-- ----------------------------

-- ----------------------------
-- Table structure for `dw_province`
-- ----------------------------
DROP TABLE IF EXISTS `dw_province`;
CREATE TABLE `dw_province` (
  `province_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dw_province
-- ----------------------------
INSERT INTO `dw_province` VALUES ('1', '北京市');
INSERT INTO `dw_province` VALUES ('2', '上海市');
INSERT INTO `dw_province` VALUES ('3', '天津市');
INSERT INTO `dw_province` VALUES ('4', '重庆市');
INSERT INTO `dw_province` VALUES ('5', '黑龙江省');
INSERT INTO `dw_province` VALUES ('6', '吉林省');
INSERT INTO `dw_province` VALUES ('7', '辽宁省');
INSERT INTO `dw_province` VALUES ('8', '山东省');
INSERT INTO `dw_province` VALUES ('9', '山西省');
INSERT INTO `dw_province` VALUES ('10', '陕西省');
INSERT INTO `dw_province` VALUES ('11', '河北省');
INSERT INTO `dw_province` VALUES ('12', '河南省');
INSERT INTO `dw_province` VALUES ('13', '湖北省');
INSERT INTO `dw_province` VALUES ('14', '湖南省');
INSERT INTO `dw_province` VALUES ('15', '海南省');
INSERT INTO `dw_province` VALUES ('16', '江苏省');
INSERT INTO `dw_province` VALUES ('17', '江西省');
INSERT INTO `dw_province` VALUES ('18', '广东省');
INSERT INTO `dw_province` VALUES ('19', '广西省');
INSERT INTO `dw_province` VALUES ('20', '云南省');
INSERT INTO `dw_province` VALUES ('21', '贵州省');
INSERT INTO `dw_province` VALUES ('22', '四川省');
INSERT INTO `dw_province` VALUES ('23', '内蒙古自治区');
INSERT INTO `dw_province` VALUES ('24', '宁夏回族自治区');
INSERT INTO `dw_province` VALUES ('25', '甘肃省');
INSERT INTO `dw_province` VALUES ('26', '青海省');
INSERT INTO `dw_province` VALUES ('27', '西藏自治区');
INSERT INTO `dw_province` VALUES ('28', '新疆自治区');
INSERT INTO `dw_province` VALUES ('29', '安徽省');
INSERT INTO `dw_province` VALUES ('30', '浙江省');
INSERT INTO `dw_province` VALUES ('31', '福建省');
INSERT INTO `dw_province` VALUES ('32', '台湾省');
INSERT INTO `dw_province` VALUES ('33', '香港');
INSERT INTO `dw_province` VALUES ('34', '澳门');

-- ----------------------------
-- Table structure for `dw_vote`
-- ----------------------------
DROP TABLE IF EXISTS `dw_vote`;
CREATE TABLE `dw_vote` (
  `user_id` int(11) NOT NULL,
  `pron_id` int(11) NOT NULL,
  `mark` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`pron_id`),
  KEY `fk_dw_vote_dw_pronunciation1` (`pron_id`),
  KEY `fk_dw_vote_users1` (`user_id`),
  CONSTRAINT `fk_dw_vote_dw_pronunciation1` FOREIGN KEY (`pron_id`) REFERENCES `dw_pronunciation` (`pron_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dw_vote_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dw_vote
-- ----------------------------

-- ----------------------------
-- Table structure for `dw_word`
-- ----------------------------
DROP TABLE IF EXISTS `dw_word`;
CREATE TABLE `dw_word` (
  `word_id` int(11) NOT NULL AUTO_INCREMENT,
  `word_name` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`word_id`),
  UNIQUE KEY `word_name_UNIQUE` (`word_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dw_word
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` tinyblob,
  `enabled` tinyint(1) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `sex` enum('m','f') DEFAULT NULL,
  `question` varchar(45) DEFAULT NULL,
  `answer` tinyblob,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('9', 'hitchimp', 0x3037393136326561353939373161346166353737626532383438643236646438, '1', 'chrisxue815@gmail.com', 'm', 'Who am I?', 0x6630336562666138393633663036363762356433386533316631373736333661);
