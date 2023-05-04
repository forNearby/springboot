CREATE SCHEMA `file_manager` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

USE `file_manager`;

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
    `id` bigint(20) NOT NULL COMMENT '主键',
    `user_name` varchar(64) NOT NULL COMMENT '用户名',
    `password` varchar(64) NOT NULL  COMMENT '密码',
    `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
    `status` char(1) DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
    `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
    `phonenumber` varchar(32) DEFAULT NULL COMMENT '手机号',
    `sex` char(1) DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
    `avatar` text DEFAULT NULL COMMENT '头像',
    `user_type` char(1) NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
    `create_by` bigint(20) DEFAULT NULL COMMENT '创建人的用户id',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `del_flag` int(11) DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) COMMENT='用户表';
INSERT INTO t_sys_user(id, user_name, password) VALUES (2, 'lisi', '$2a$10$Qwui/z9S77ccNAjPvBV4X.7ofy4ss85Pq3pSyhTCcO4Gyti13LJsu');
INSERT INTO t_sys_user(id, user_name, password) VALUES (1, 'admin', '$2a$10$0pQ/aammUrZOebmvmcCzeeWglat9MccWHoJ2ZriyUktlfTqepL9XC');

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
    `id` bigint(20) NOT NULL,
    `name` varchar(128) DEFAULT NULL,
    `role_key` varchar(100) DEFAULT NULL COMMENT '角色权限字符串',
    `status` char(1) DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
    `del_flag` int(1) DEFAULT '0' COMMENT 'del_flag',
    `create_by` bigint(200) DEFAULT NULL,
    `create_time` datetime DEFAULT NULL,
    `update_by` bigint(200) DEFAULT NULL,
    `update_time` datetime DEFAULT NULL,
    `remark` varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
)COMMENT='角色表';
INSERT INTO t_sys_role(id, name, role_key) VALUES(1,'管理员','admin');
INSERT INTO t_sys_role(id, name, role_key) VALUES(2,'老板','boss');

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
    `id` bigint(20) NOT NULL,
    `menu_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
    `path` varchar(200) DEFAULT NULL COMMENT '路由地址',
    `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
    `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
    `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
    `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
    `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
    `create_by` bigint(20) DEFAULT NULL,
    `create_time` datetime DEFAULT NULL,
    `update_by` bigint(20) DEFAULT NULL,
    `update_time` datetime DEFAULT NULL,
    `remark` varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) COMMENT='菜单表';
INSERT INTO t_sys_menu(id, menu_name, path, component, perms) VALUES(1,'部门列表','dept','sys/dept/index','sys:dept:list');
INSERT INTO t_sys_menu(id, menu_name, path, component, perms) VALUES(2,'测试列表','test','sys/test/index','sys:test:list');

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
     `user_id` bigint(200) NOT NULL COMMENT '用户id',
     `role_id` bigint(200) NOT NULL DEFAULT '0' COMMENT '角色id',
     PRIMARY KEY (`user_id`,`role_id`)
) COMMENT='用户角色关联表';
INSERT INTO t_sys_user_role(user_id, role_id) VALUES(1,1);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES(2,2);

DROP TABLE IF EXISTS `t_sys_role_menu`;

CREATE TABLE `t_sys_role_menu` (
     `role_id` bigint(200) NOT NULL COMMENT '角色ID',
     `menu_id` bigint(200) NOT NULL DEFAULT '0' COMMENT '菜单id',
     PRIMARY KEY (`role_id`,`menu_id`)
) COMMENT='角色菜单关联表';
INSERT INTO t_sys_role_menu(role_id, menu_id) VALUES(1,1);
INSERT INTO t_sys_role_menu(role_id, menu_id) VALUES(1,2);
INSERT INTO t_sys_role_menu(role_id, menu_id) VALUES(2,2);

CREATE TABLE `t_fm_file_manager` (
    `id` bigint(200) primary key AUTO_INCREMENT NOT NULL  COMMENT '文件ID',
    `file_name` varchar(64) NOT NULL COMMENT '文件名',
    `file_type_id` bigint(200) NOT NULL COMMENT '文件类型id',
    `file_type_name` varchar(64) NOT NULL COMMENT '文件类型名',
    `p_id` bigint(200) COMMENT '文件父ID',
    `create_by` bigint(200) DEFAULT NULL,
    `create_time` datetime(3) DEFAULT NULL,
    `update_by` bigint(200) DEFAULT NULL,
    `update_time` datetime(3) DEFAULT NULL,
    `remark` varchar(500) DEFAULT NULL COMMENT '备注'
) COMMENT='文件管理表';
INSERT INTO t_fm_file_manager(file_name, file_type_id, file_type_name) VALUES('根目录', 0, '文件夹');


