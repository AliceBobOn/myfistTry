/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : ssm00616tpglwz

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-12-17 23:14:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `allusers`
-- ----------------------------
DROP TABLE IF EXISTS `allusers`;
CREATE TABLE `allusers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(80) NOT NULL COMMENT '用户名',
  `pwd` varchar(80) NOT NULL COMMENT '密码',
  `cx` varchar(80) NOT NULL COMMENT '权限',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of allusers
-- ----------------------------
INSERT INTO `allusers` VALUES ('1', 'admin', 'admin', '超级管理员', '2019-12-15 16:30:25');
INSERT INTO `allusers` VALUES ('2', 'gr', 'gr', '普通管理员', '2019-12-15 16:30:25');

-- ----------------------------
-- Table structure for `dx`
-- ----------------------------
DROP TABLE IF EXISTS `dx`;
CREATE TABLE `dx` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `leibie` varchar(80) NOT NULL,
  `content` longtext NOT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dx
-- ----------------------------
INSERT INTO `dx` VALUES ('1', '系统公告', '<p>3123231231</p>', '2019-12-15 18:44:03');
INSERT INTO `dx` VALUES ('2', '系统简介', '<p>66666666666666</p>', '2019-12-15 18:44:04');

-- ----------------------------
-- Table structure for `liuyanban`
-- ----------------------------
DROP TABLE IF EXISTS `liuyanban`;
CREATE TABLE `liuyanban` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `lianxidianhua` varchar(50) NOT NULL COMMENT '联系电话',
  `liuyanneirong` text NOT NULL COMMENT '留言内容',
  `huifuneirong` text NOT NULL COMMENT '回复内容',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of liuyanban
-- ----------------------------
INSERT INTO `liuyanban` VALUES ('1', '皮特', '13888888988', '132321312323', '', '2019-12-15 18:45:05');
INSERT INTO `liuyanban` VALUES ('2', '皮特', '13888888988', '12010010', '12312321', '2019-12-16 11:10:34');

-- ----------------------------
-- Table structure for `lunbotu`
-- ----------------------------
DROP TABLE IF EXISTS `lunbotu`;
CREATE TABLE `lunbotu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '标题',
  `image` varchar(255) NOT NULL COMMENT '图片',
  `url` varchar(255) NOT NULL COMMENT '连接地址',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lunbotu
-- ----------------------------
INSERT INTO `lunbotu` VALUES ('1', '32432', 'upload/20191215/72111576405721765.jpg', '#', '2019-12-15 18:28:43');
INSERT INTO `lunbotu` VALUES ('2', '454', 'upload/20191215/69461576405735889.jpg', '#', '2019-12-15 18:28:57');

-- ----------------------------
-- Table structure for `pinglun`
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `wenzhangID` int(10) unsigned NOT NULL,
  `pinglunneirong` text NOT NULL,
  `pinglunren` varchar(80) NOT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `biao` varchar(255) NOT NULL,
  `pingfen` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pinglun
-- ----------------------------
INSERT INTO `pinglun` VALUES ('1', '1', '6666', '002', '2019-12-16 11:11:59', 'tuxiangxinxi', '5');

-- ----------------------------
-- Table structure for `shoucangjilu`
-- ----------------------------
DROP TABLE IF EXISTS `shoucangjilu`;
CREATE TABLE `shoucangjilu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `xwid` int(10) unsigned NOT NULL,
  `biao` varchar(255) NOT NULL,
  `biaoti` varchar(255) NOT NULL,
  `url` varchar(512) NOT NULL,
  `ziduan` varchar(255) NOT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoucangjilu
-- ----------------------------
INSERT INTO `shoucangjilu` VALUES ('1', '002', '1', 'tuxiangxinxi', '藏巴拉湖特写', 'http://localhost:8080/tuxiangxinxidetail.do?id=1', 'mingcheng', '2019-12-16 11:12:02');

-- ----------------------------
-- Table structure for `tuxiangfenlei`
-- ----------------------------
DROP TABLE IF EXISTS `tuxiangfenlei`;
CREATE TABLE `tuxiangfenlei` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fenleimingcheng` varchar(255) NOT NULL COMMENT '分类名称',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuxiangfenlei
-- ----------------------------
INSERT INTO `tuxiangfenlei` VALUES ('1', '地理风景', '2019-12-15 17:19:43');
INSERT INTO `tuxiangfenlei` VALUES ('2', '美食鉴赏', '2019-12-15 17:19:54');
INSERT INTO `tuxiangfenlei` VALUES ('3', '科技展示', '2019-12-15 17:19:59');
INSERT INTO `tuxiangfenlei` VALUES ('4', '测试分类', '2019-12-16 11:15:21');

-- ----------------------------
-- Table structure for `tuxiangxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `tuxiangxinxi`;
CREATE TABLE `tuxiangxinxi` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tuxiangbianhao` varchar(50) NOT NULL COMMENT '图像编号',
  `fenlei` varchar(255) NOT NULL COMMENT '分类',
  `tupian` varchar(255) NOT NULL COMMENT '图片',
  `mingcheng` varchar(255) NOT NULL COMMENT '名称',
  `shiping` varchar(255) NOT NULL COMMENT '视屏',
  `zuozhe` varchar(50) NOT NULL COMMENT '作者',
  `dianjishuai` int(11) NOT NULL COMMENT '点击率',
  `neirongjianjie` longtext NOT NULL COMMENT '内容简介',
  `issh` varchar(10) NOT NULL DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuxiangxinxi
-- ----------------------------
INSERT INTO `tuxiangxinxi` VALUES ('1', '12151720282066', '1', 'upload/20191215/68731576402374482.png', '藏巴拉湖特写', 'upload/20191215/91601576402471001.mp4', 'admin', '1004', '<p>“山一程，水一程，身向天山行。风一更，雪一更，夜深千帐灯。剑沉沉，爱深深，英雄儿女行。来一回，去一回，岁月不留情。”天山侠客，仗剑天涯。飞越天山山脉时，这首歌的旋律一直在我的心中回想，之所以安排了这样的一次旅行，可能还是源自心中的那份英雄情结吧！<img id=\"64933\" src=\"./upload/1576403208979.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/></p><h3 style=\"padding: 0px;font-size: 16px;color: rgb(51, 51, 51);font-family: 宋体;white-space: normal\">鸟瞰新疆大地</h3><p><img id=\"64946\" src=\"./upload/1576403209176.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>你的美丽曾让多少摄影师为你感动到流泪，为你追随中国最后一抹晚霞；你的仁慈曾让多少维族少女在葡萄架下曼妙地起舞，为你赐予的美味和瓜果的飘香。你有着梦幻尼雅，沙埋楼兰，你也曾目睹过西汉公主的容颜。你曾让多少的热血将士，征战沙场，只为你红颜；你曾让多少的文人墨客，倾尽笔墨，只为你愁肠……大美新疆！<img id=\"64945\" src=\"./upload/1576403209314.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>每每金秋时节，总是有大批的摄友、驴友会涌入新疆，去摄猎那片曾出现在无数大片里的那抹金黄。而去年六月，不爱走寻常路的我就特别安排了一次沿着天山山脉横穿伊犁州、巴州的旅行，途中路过了许多湖泊、草原、峡谷、冰川……一路惊喜无限。<img id=\"64934\" src=\"./upload/1576403209347.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>乘机从成都出发前往乌鲁木齐，在空中鸟瞰新疆大地，感叹造物主的神奇画笔，多样的地形均汇集在这里，难以想象在2000多年前，西汉商人是如何穿越这片大漠戈壁、茫茫群山，走出了一条通往中亚细亚，连接东方与西方文明的古丝绸之路。<br/><br/>天山是中亚东部地区的一条大山脉，横贯中国新疆的中部，西端伸入哈萨克斯坦。远望天山，那长年积雪的群峰高插云霄，那富于色彩的连绵山峦雄浑豪迈；近看天山，它不仅给人一种稀有美丽的感觉，而且更给人一种无限温柔的感情。</p><p><br/></p>', '是', '2019-12-15 17:46:49');
INSERT INTO `tuxiangxinxi` VALUES ('2', '12151813546272', '1', 'upload/20191215/95041576404930181.png', '藏区阿坝州风景', 'upload/20191215/43821576404953971.mp4', 'admin', '1000', '<p>“山一程，水一程，身向天山行。风一更，雪一更，夜深千帐灯。剑沉沉，爱深深，英雄儿女行。来一回，去一回，岁月不留情。”天山侠客，仗剑天涯。飞越天山山脉时，这首歌的旋律一直在我的心中回想，之所以安排了这样的一次旅行，可能还是源自心中的那份英雄情结吧！<img id=\"64933\" src=\"./upload/1576404966435.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/></p><h3 style=\"padding: 0px;font-size: 16px;color: rgb(51, 51, 51);font-family: 宋体;white-space: normal\">鸟瞰新疆大地</h3><p><img id=\"64946\" src=\"./upload/1576404966639.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>你的美丽曾让多少摄影师为你感动到流泪，为你追随中国最后一抹晚霞；你的仁慈曾让多少维族少女在葡萄架下曼妙地起舞，为你赐予的美味和瓜果的飘香。你有着梦幻尼雅，沙埋楼兰，你也曾目睹过西汉公主的容颜。你曾让多少的热血将士，征战沙场，只为你红颜；你曾让多少的文人墨客，倾尽笔墨，只为你愁肠……大美新疆！<img id=\"64945\" src=\"./upload/1576404966766.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>每每金秋时节，总是有大批的摄友、驴友会涌入新疆，去摄猎那片曾出现在无数大片里的那抹金黄。而去年六月，不爱走寻常路的我就特别安排了一次沿着天山山脉横穿伊犁州、巴州的旅行，途中路过了许多湖泊、草原、峡谷、冰川……一路惊喜无限。<img id=\"64934\" src=\"./upload/1576404966904.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>乘机从成都出发前往乌鲁木齐，在空中鸟瞰新疆大地，感叹造物主的神奇画笔，多样的地形均汇集在这里，难以想象在2000多年前，西汉商人是如何穿越这片大漠戈壁、茫茫群山，走出了一条通往中亚细亚，连接东方与西方文明的古丝绸之路。<br/><br/>天山是中亚东部地区的一条大山脉，横贯中国新疆的中部，西端伸入哈萨克斯坦。远望天山，那长年积雪的群峰高插云霄，那富于色彩的连绵山峦雄浑豪迈；近看天山，它不仅给人一种稀有美丽的感觉，而且更给人一种无限温柔的感情。</p><p><br/></p>', '是', '2019-12-15 18:16:07');
INSERT INTO `tuxiangxinxi` VALUES ('3', '12151816077288', '1', 'upload/20191215/50241576405010075.png', '农民盆地地理图', 'upload/20191215/70461576405028499.mp4', 'admin', '1000', '<p>“山一程，水一程，身向天山行。风一更，雪一更，夜深千帐灯。剑沉沉，爱深深，英雄儿女行。来一回，去一回，岁月不留情。”天山侠客，仗剑天涯。飞越天山山脉时，这首歌的旋律一直在我的心中回想，之所以安排了这样的一次旅行，可能还是源自心中的那份英雄情结吧！<img id=\"64933\" src=\"./upload/1576405037834.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/></p><h3 style=\"padding: 0px;font-size: 16px;color: rgb(51, 51, 51);font-family: 宋体;white-space: normal\">鸟瞰新疆大地</h3><p><img id=\"64946\" src=\"./upload/1576405037877.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>你的美丽曾让多少摄影师为你感动到流泪，为你追随中国最后一抹晚霞；你的仁慈曾让多少维族少女在葡萄架下曼妙地起舞，为你赐予的美味和瓜果的飘香。你有着梦幻尼雅，沙埋楼兰，你也曾目睹过西汉公主的容颜。你曾让多少的热血将士，征战沙场，只为你红颜；你曾让多少的文人墨客，倾尽笔墨，只为你愁肠……大美新疆！<img id=\"64945\" src=\"./upload/1576405037900.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>每每金秋时节，总是有大批的摄友、驴友会涌入新疆，去摄猎那片曾出现在无数大片里的那抹金黄。而去年六月，不爱走寻常路的我就特别安排了一次沿着天山山脉横穿伊犁州、巴州的旅行，途中路过了许多湖泊、草原、峡谷、冰川……一路惊喜无限。<img id=\"64934\" src=\"./upload/1576405037911.jpg@!rw9\" style=\"overflow: hidden;max-width: 670px\"/>乘机从成都出发前往乌鲁木齐，在空中鸟瞰新疆大地，感叹造物主的神奇画笔，多样的地形均汇集在这里，难以想象在2000多年前，西汉商人是如何穿越这片大漠戈壁、茫茫群山，走出了一条通往中亚细亚，连接东方与西方文明的古丝绸之路。<br/><br/>天山是中亚东部地区的一条大山脉，横贯中国新疆的中部，西端伸入哈萨克斯坦。远望天山，那长年积雪的群峰高插云霄，那富于色彩的连绵山峦雄浑豪迈；近看天山，它不仅给人一种稀有美丽的感觉，而且更给人一种无限温柔的感情。</p><p><br/></p>', '是', '2019-12-15 18:17:17');
INSERT INTO `tuxiangxinxi` VALUES ('4', '12151817231145', '2', 'upload/20191215/79121576405110494.png', '新加坡当地特色美食', 'upload/20191215/96261576405296128.mp4', 'admin', '1000', '<p><img src=\"upload/20191215/98271576405268527.png\"/></p>', '是', '2019-12-15 18:21:43');
INSERT INTO `tuxiangxinxi` VALUES ('5', '12151821441783', '2', 'upload/20191215/91301576405347369.png', '墨西哥卷饼', 'upload/20191215/56361576405362450.mp4', 'admin', '1002', '<p><img src=\"upload/20191215/34851576405376508.png\"/></p>', '是', '2019-12-15 18:22:59');
INSERT INTO `tuxiangxinxi` VALUES ('6', '12151823004887', '2', 'upload/20191215/58431576405471502.png', '俄罗斯糕点', 'upload/20191215/69771576405484289.mp4', 'admin', '1001', '', '是', '2019-12-15 18:24:50');
INSERT INTO `tuxiangxinxi` VALUES ('7', '12151824591972', '3', 'upload/20191215/55251576405532179.png', '未来科幻战车展示', 'upload/20191215/98461576405552828.mp4', 'admin', '1001', '', '是', '2019-12-15 18:26:08');
INSERT INTO `tuxiangxinxi` VALUES ('8', '12151826101487', '3', 'upload/20191215/71271576405639385.png', '高科技健身房', 'upload/20191215/82691576405651003.mp4', 'admin', '1002', '', '是', '2019-12-15 18:27:35');

-- ----------------------------
-- Table structure for `zhuceyonghu`
-- ----------------------------
DROP TABLE IF EXISTS `zhuceyonghu`;
CREATE TABLE `zhuceyonghu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) NOT NULL COMMENT '用户名',
  `mima` varchar(50) NOT NULL COMMENT '密码',
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `xingbie` varchar(255) NOT NULL COMMENT '性别',
  `dianhua` varchar(50) NOT NULL COMMENT '电话',
  `youxiang` varchar(50) NOT NULL COMMENT '邮箱',
  `touxiang` varchar(255) NOT NULL COMMENT '头像',
  `dizhi` varchar(255) NOT NULL COMMENT '地址',
  `beizhu` text NOT NULL COMMENT '备注',
  `issh` varchar(10) NOT NULL DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhuceyonghu
-- ----------------------------
INSERT INTO `zhuceyonghu` VALUES ('1', '001', '001', '小明', '男', '', '', '', '', '', '否', '2019-12-16 11:01:31');
INSERT INTO `zhuceyonghu` VALUES ('2', '002', '002', '雷海婷', '女', '16666666661', '123456@qq.com', 'upload/20191216/66871576465780228.png', 'XXX市测试', '', '是', '2019-12-16 11:09:44');
