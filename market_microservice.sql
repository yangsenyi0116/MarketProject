/*
 Navicat Premium Data Transfer

 Source Server         : localhost80
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : market_microservice

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 20/12/2019 09:08:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for arch_customer_login_log
-- ----------------------------
DROP TABLE IF EXISTS `arch_customer_login_log`;
CREATE TABLE `arch_customer_login_log`  (
  `login_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '登陆日志ID',
  `customer_id` int(10) UNSIGNED NOT NULL COMMENT '登陆用户ID',
  `login_time` timestamp(0) NOT NULL COMMENT '用户登陆时间',
  `login_ip` int(10) UNSIGNED NOT NULL COMMENT '登陆IP',
  `login_type` tinyint(4) NOT NULL COMMENT '登陆类型：0未成功，1成功',
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户登陆日志归档表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for brand_info
-- ----------------------------
DROP TABLE IF EXISTS `brand_info`;
CREATE TABLE `brand_info`  (
  `brand_id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '品牌ID',
  `brand_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌名称',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `brand_web` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌网络',
  `brand_logo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌logo URL',
  `brand_desc` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌描述',
  `brand_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '品牌状态,0禁用,1启用',
  `brand_order` tinyint(4) NOT NULL DEFAULT 0 COMMENT '排序',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品牌信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_addr
-- ----------------------------
DROP TABLE IF EXISTS `customer_addr`;
CREATE TABLE `customer_addr`  (
  `customer_addr_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `customer_id` char(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'customer_login表的自增ID',
  `zip` int(6) NOT NULL COMMENT '邮编',
  `province` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份',
  `city` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市',
  `district` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '具体的地址门牌号',
  `is_default` tinyint(4) NOT NULL COMMENT '是否默认',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`customer_addr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_balance_log
-- ----------------------------
DROP TABLE IF EXISTS `customer_balance_log`;
CREATE TABLE `customer_balance_log`  (
  `balance_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '余额日志ID',
  `customer_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `source` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '记录来源：1订单，2退货单',
  `source_sn` int(10) UNSIGNED NOT NULL COMMENT '相关单据ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `amount` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '变动金额',
  PRIMARY KEY (`balance_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户余额变动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_inf
-- ----------------------------
DROP TABLE IF EXISTS `customer_inf`;
CREATE TABLE `customer_inf`  (
  `customer_inf_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
  `customer_id` char(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户UUID',
  `customer_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `identity_card_type` tinyint(255) NOT NULL COMMENT '证件类型：1、身份证，2、军官证、3、护照',
  `identity_card_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码',
  `mobile_phone` int(255) NULL DEFAULT NULL COMMENT '手机号',
  `customer_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `user_point` int(255) NOT NULL DEFAULT 0 COMMENT '用户积分',
  `customer_level` tinyint(255) NOT NULL DEFAULT 1 COMMENT '会员级别',
  `user_money` decimal(8, 2) NULL DEFAULT 0.00 COMMENT '用户余额',
  `register_time` timestamp(0) NULL DEFAULT NULL COMMENT '注册时间',
  `modified_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`customer_inf_id`) USING BTREE,
  UNIQUE INDEX `mobile_phone`(`mobile_phone`) USING BTREE,
  UNIQUE INDEX `customer_email`(`customer_email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_inf
-- ----------------------------
INSERT INTO `customer_inf` VALUES (1, 'aac2093e-8f0f-466d-9e8c-332f5c9ac055', 'test', 1, '431021199910150012', 123123123, 'test@test.com', '男', 0, 1, 0.00, NULL, '2019-12-16 11:37:01');

-- ----------------------------
-- Table structure for customer_level_inf
-- ----------------------------
DROP TABLE IF EXISTS `customer_level_inf`;
CREATE TABLE `customer_level_inf`  (
  `customer_level` tinyint(255) NOT NULL AUTO_INCREMENT COMMENT '会员级别ID',
  `level_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员级别名称',
  `min_point` int(255) UNSIGNED NOT NULL DEFAULT 0 COMMENT '该级别最低积分',
  `max_point` int(255) UNSIGNED NOT NULL COMMENT '该级别最高积分',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`customer_level`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户级别信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_login
-- ----------------------------
DROP TABLE IF EXISTS `customer_login`;
CREATE TABLE `customer_login`  (
  `customer_id` char(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户UUID',
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登录名',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'md5加密的面',
  `user_stats` tinyint(4) NOT NULL DEFAULT 1 COMMENT '用户状态 1启用 0禁用',
  `modified_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户登录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_login
-- ----------------------------
INSERT INTO `customer_login` VALUES ('1', 'aaa', '123123213', 1, '2019-12-11 09:10:16');
INSERT INTO `customer_login` VALUES ('6dedff7e-012f-4273-9d9a-4ec2c2a45086', 'aae', '123456', 1, '2019-12-16 17:09:19');
INSERT INTO `customer_login` VALUES ('aac2093e-8f0f-466d-9e8c-332f5c9ac055', 'aad', '123456', 1, '2019-12-16 10:30:24');
INSERT INTO `customer_login` VALUES ('bb945421-2458-479c-ac77-6ea785ea08b6', 'aac', 'e10adc3949ba59abbe56e057f20f883e', 1, '2019-12-12 10:13:39');
INSERT INTO `customer_login` VALUES ('de4ef011-f51a-42f6-be0a-fe3296df982f', 'aab', 'e10adc3949ba59abbe56e057f20f883e', 1, '2019-12-12 10:08:51');

-- ----------------------------
-- Table structure for customer_login_log
-- ----------------------------
DROP TABLE IF EXISTS `customer_login_log`;
CREATE TABLE `customer_login_log`  (
  `login_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '登陆日志ID',
  `customer_id` int(10) UNSIGNED NOT NULL COMMENT '登陆用户ID',
  `login_time` timestamp(0) NOT NULL COMMENT '用户登陆时间',
  `login_ip` int(10) UNSIGNED NOT NULL COMMENT '登陆IP',
  `login_type` tinyint(4) NOT NULL COMMENT '登陆类型：0未成功，1成功',
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户登陆日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_point_log
-- ----------------------------
DROP TABLE IF EXISTS `customer_point_log`;
CREATE TABLE `customer_point_log`  (
  `point_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '积分日志ID',
  `customer_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `source` tinyint(3) UNSIGNED NOT NULL COMMENT '积分来源：0订单，1登陆，2活动',
  `refer_number` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '积分来源相关编号',
  `change_point` smallint(6) NOT NULL DEFAULT 0 COMMENT '变更积分数',
  `create_time` timestamp(0) NOT NULL COMMENT '积分日志生成时间',
  PRIMARY KEY (`point_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户积分日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_cart
-- ----------------------------
DROP TABLE IF EXISTS `order_cart`;
CREATE TABLE `order_cart`  (
  `cart_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `customer_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `product_id` int(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `product_amount` int(11) NOT NULL COMMENT '加入购物车商品数量',
  `price` decimal(8, 2) NOT NULL COMMENT '商品价格',
  `add_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入购物车时间',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `order_detail_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单详情表ID',
  `order_id` int(10) UNSIGNED NOT NULL COMMENT '订单表ID',
  `product_id` int(10) UNSIGNED NOT NULL COMMENT '订单商品ID',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_cnt` int(11) NOT NULL DEFAULT 1 COMMENT '购买商品数量',
  `product_price` decimal(8, 2) NOT NULL COMMENT '购买商品单价',
  `average_cost` decimal(8, 2) NOT NULL COMMENT '平均成本价格',
  `weight` float NULL DEFAULT NULL COMMENT '商品重量',
  `fee_money` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '优惠分摊金额',
  `w_id` int(10) UNSIGNED NOT NULL COMMENT '仓库ID',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`order_detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_sn` bigint(20) UNSIGNED NOT NULL COMMENT '订单编号 yyyymmddnnnnnnnn',
  `customer_id` int(10) UNSIGNED NOT NULL COMMENT '下单人ID',
  `shipping_user` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人姓名',
  `province` smallint(6) NOT NULL COMMENT '省',
  `city` smallint(6) NOT NULL COMMENT '市',
  `district` smallint(6) NOT NULL COMMENT '区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `payment_method` tinyint(4) NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
  `order_money` decimal(8, 2) NOT NULL COMMENT '订单金额',
  `district_money` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '优惠金额',
  `shipping_money` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '运费金额',
  `payment_money` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '支付金额',
  `shipping_comp_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递公司名称',
  `shipping_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递单号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `shipping_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `receive_time` datetime(0) NULL DEFAULT NULL COMMENT '收货时间',
  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
  `order_point` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单积分',
  `invoice_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票抬头',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `category_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类编码',
  `parent_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父分类ID',
  `category_level` tinyint(4) NOT NULL DEFAULT 1 COMMENT '分类层级',
  `category_status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '分类状态',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, 'test', '12312312', 0, 1, 1, '2019-12-17 22:05:45');
INSERT INTO `product_category` VALUES (2, 'test2', '1231232', 1, 2, 1, '2019-12-17 22:06:03');

-- ----------------------------
-- Table structure for product_comment
-- ----------------------------
DROP TABLE IF EXISTS `product_comment`;
CREATE TABLE `product_comment`  (
  `comment_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `product_id` int(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `order_id` bigint(20) UNSIGNED NOT NULL COMMENT '订单ID',
  `customer_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论标题',
  `content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `audit_status` tinyint(4) NOT NULL COMMENT '审核状态：0未审核，1已审核',
  `audit_time` timestamp(0) NOT NULL COMMENT '评论时间',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `product_core` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编码',
  `product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `bar_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '国条码',
  `brand_id` int(10) UNSIGNED NOT NULL COMMENT '品牌表的ID',
  `one_category_id` smallint(5) UNSIGNED NOT NULL COMMENT '一级分类ID',
  `two_category_id` smallint(5) UNSIGNED NOT NULL COMMENT '二级分类ID',
  `three_category_id` smallint(5) UNSIGNED NOT NULL COMMENT '三级分类ID',
  `supplier_id` int(10) UNSIGNED NOT NULL COMMENT '商品的供应商ID',
  `price` decimal(8, 2) NOT NULL COMMENT '商品销售价格',
  `average_cost` decimal(18, 2) NOT NULL COMMENT '商品加权平均成本',
  `publish_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '上下架状态：0下架1上架',
  `audit_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '审核状态：0未审核，1已审核',
  `weight` float NULL DEFAULT NULL COMMENT '商品重量',
  `length` float NULL DEFAULT NULL COMMENT '商品长度',
  `height` float NULL DEFAULT NULL COMMENT '商品高度',
  `width` float NULL DEFAULT NULL COMMENT '商品宽度',
  `color_type` enum('红','黄','蓝','黑') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `production_date` datetime(0) NOT NULL COMMENT '生产日期',
  `shelf_life` int(11) NOT NULL COMMENT '商品有效期',
  `descript` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品描述',
  `indate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品录入时间',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_pic_info
-- ----------------------------
DROP TABLE IF EXISTS `product_pic_info`;
CREATE TABLE `product_pic_info`  (
  `product_pic_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品图片ID',
  `product_id` int(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `pic_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片描述',
  `pic_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片URL',
  `is_master` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否主图：0.非主图1.主图',
  `pic_order` tinyint(4) NOT NULL DEFAULT 0 COMMENT '图片排序',
  `pic_status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '图片是否有效：0无效 1有效',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`product_pic_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品图片信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shipping_info
-- ----------------------------
DROP TABLE IF EXISTS `shipping_info`;
CREATE TABLE `shipping_info`  (
  `ship_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ship_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物流公司名称',
  `ship_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物流公司联系人',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物流公司联系电话',
  `price` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '配送价格',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`ship_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流公司信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for supplier_info
-- ----------------------------
DROP TABLE IF EXISTS `supplier_info`;
CREATE TABLE `supplier_info`  (
  `supplier_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `supplier_code` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商编码',
  `supplier_name` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
  `supplier_type` tinyint(4) NOT NULL COMMENT '供应商类型：1.自营，2.平台',
  `link_man` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商联系人',
  `phone_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `bank_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商开户银行名称',
  `bank_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行账号',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商地址',
  `supplier_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0禁止，1启用',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1);

-- ----------------------------
-- Table structure for warehouse_info
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_info`;
CREATE TABLE `warehouse_info`  (
  `w_id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  `warehouse_sn` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库编码',
  `warehoust_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库名称',
  `warehouse_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库电话',
  `contact` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库联系人',
  `province` smallint(6) NOT NULL COMMENT '省',
  `city` smallint(6) NOT NULL COMMENT '市',
  `distrct` smallint(6) NOT NULL COMMENT '区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库地址',
  `warehouse_status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '仓库状态：0禁用，1启用',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`w_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehouse_product
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_product`;
CREATE TABLE `warehouse_product`  (
  `wp_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `product_id` int(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `w_id` smallint(5) UNSIGNED NOT NULL COMMENT '仓库ID',
  `current_cnt` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前商品数量',
  `lock_cnt` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前占用数据',
  `in_transit_cnt` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '在途数据',
  `average_cost` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '移动加权成本',
  `modified_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`wp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品库存表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
