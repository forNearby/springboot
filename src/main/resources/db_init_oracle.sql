--DEFAULT和NOT NULL同时存在是可以在insert into不设置该字段,只有NOT NULL则必须设置
CREATE TABLE t_sys_user(
   id number(20) NOT NULL,
   user_name varchar2(64) NOT NULL,
   password varchar2(64) NOT NULL,
   nick_name varchar2(64) DEFAULT NULL,
   status varchar2(1) DEFAULT '0',
   email varchar2(64) DEFAULT NULL,
   phonenumber varchar2(32) DEFAULT NULL,
   sex varchar2(1) DEFAULT NULL,
   avatar varchar2(128) DEFAULT NULL,
   user_type varchar2(1) DEFAULT '1' NOT NULL,
   create_by number(20) DEFAULT NULL,
   create_time date DEFAULT sysdate NOT NULL,
   update_by number(20) DEFAULT NULL,
   update_time date DEFAULT sysdate NOT NULL, --该字段在更新时需要从代码手动写入最新更新时间
   del_flag varchar2(1) DEFAULT '0',
   PRIMARY KEY(id)
);
COMMENT ON TABLE t_sys_user IS '系统用户表';
COMMENT ON COLUMN t_sys_user.id IS '主键id';
COMMENT ON COLUMN t_sys_user.user_name IS '用户名';
COMMENT ON COLUMN t_sys_user.password IS '密码';
COMMENT ON COLUMN t_sys_user.nick_name IS '昵称';
COMMENT ON COLUMN t_sys_user.status IS '账号状态（0正常 1停用）';
COMMENT ON COLUMN t_sys_user.email IS '邮箱';
COMMENT ON COLUMN t_sys_user.phonenumber IS '手机号';
COMMENT ON COLUMN t_sys_user.sex IS '用户性别（0男，1女，2未知）';
COMMENT ON COLUMN t_sys_user.avatar IS '头像';
COMMENT ON COLUMN t_sys_user.user_type IS '用户类型（0管理员，1普通用户）';
COMMENT ON COLUMN t_sys_user.create_by IS '创建人的用户id';
COMMENT ON COLUMN t_sys_user.create_time IS '创建时间';
COMMENT ON COLUMN t_sys_user.update_by IS '更新人';
COMMENT ON COLUMN t_sys_user.update_time IS '更新时间';
COMMENT ON COLUMN t_sys_user.del_flag IS '删除标志（0代表未删除，1代表已删除）';
--INSERT INTO t_sys_user(id, user_name, password,nick_name,status,email,phonenumber,sex,avatar,user_type,create_by,create_time,update_by,update_time,del_flag)
--VALUES (1, 'zhangsan', 'zhangsan','二狗','0','','','1','','1',123,sysdate,123,to_date('10-05-2019 14:51:40', 'dd-mm-yyyy hh24:mi:ss'),'0');
INSERT INTO t_sys_user(id, user_name, password) VALUES (2, 'lisi', '$2a$10$Qwui/z9S77ccNAjPvBV4X.7ofy4ss85Pq3pSyhTCcO4Gyti13LJsu');
INSERT INTO t_sys_user(id, user_name, password) VALUES (1, 'admin', '$2a$10$0pQ/aammUrZOebmvmcCzeeWglat9MccWHoJ2ZriyUktlfTqepL9XC');


CREATE TABLE t_sys_role (
    id number(20) NOT NULL,
    name varchar2(128) DEFAULT NULL,
    role_key varchar2(100) DEFAULT NULL,
    status varchar2(1) DEFAULT '0',
    del_flag number(1) DEFAULT '0',
    create_by number(20) DEFAULT NULL,
    create_time date DEFAULT sysdate NOT NULL,
    update_by number(20) DEFAULT NULL,
    update_time date DEFAULT sysdate NOT NULL,
    remark varchar(500) DEFAULT NULL,
    PRIMARY KEY (id)
);
COMMENT ON TABLE t_sys_role IS '系统角色表';
COMMENT ON COLUMN t_sys_role.id IS '主键id';
COMMENT ON COLUMN t_sys_role.name IS '角色名';
COMMENT ON COLUMN t_sys_role.role_key IS '角色权限字符串';
INSERT INTO t_sys_role(id, name, role_key) VALUES(1,'管理员','admin');
INSERT INTO t_sys_role(id, name, role_key) VALUES(2,'老板','boss');

CREATE TABLE t_sys_menu (
    id number(20) NOT NULL,
    menu_name varchar2(64) DEFAULT 'NULL' NOT NULL,
    path varchar2(200) DEFAULT NULL,
    component varchar2(255) DEFAULT NULL,
    visible varchar2(1) DEFAULT '0',
    status varchar2(1) DEFAULT '0',
    perms varchar2(100) DEFAULT NULL,
    icon varchar2(100) DEFAULT '#',
    create_by number(20) DEFAULT NULL,
    create_time date DEFAULT sysdate NOT NULL,
    update_by number(20) DEFAULT NULL,
    update_time date DEFAULT sysdate NOT NULL,
    remark varchar(500) DEFAULT NULL,
    PRIMARY KEY (id)
);
COMMENT ON TABLE t_sys_menu IS '系统菜单表';
COMMENT ON COLUMN t_sys_menu.id IS '主键id';
COMMENT ON COLUMN t_sys_menu.menu_name IS '菜单名';
COMMENT ON COLUMN t_sys_menu.path IS '路由地址';
COMMENT ON COLUMN t_sys_menu.component IS '组件路径';
COMMENT ON COLUMN t_sys_menu.visible IS '菜单状态（0显示 1隐藏）';
COMMENT ON COLUMN t_sys_menu.status IS '菜单状态（0正常 1停用）';
COMMENT ON COLUMN t_sys_menu.perms IS '权限标识';
COMMENT ON COLUMN t_sys_menu.icon IS '菜单图标';
INSERT INTO t_sys_menu(id, menu_name, path, component, perms) VALUES(1,'部门列表','dept','sys/dept/index','sys:dept:list');
INSERT INTO t_sys_menu(id, menu_name, path, component, perms) VALUES(2,'测试列表','test','sys/test/index','sys:test:list');
--用户角色关联表
CREATE TABLE t_sys_user_role (
     user_id number (20) NOT NULL, --用户id
     role_id number (20) DEFAULT '0' NOT NULL,  --角色id
     PRIMARY KEY (user_id,role_id)
);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES(1,1);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES(2,2);
--角色菜单关联表
CREATE TABLE t_sys_role_menu (
     role_id number(20) NOT NULL,  --角色id
     menu_id number(20) DEFAULT '0' NOT NULL ,  --菜单id
     PRIMARY KEY (role_id,menu_id)
);
INSERT INTO t_sys_role_menu(role_id, menu_id) VALUES(1,1);
INSERT INTO t_sys_role_menu(role_id, menu_id) VALUES(1,2);
INSERT INTO t_sys_role_menu(role_id, menu_id) VALUES(2,2);



