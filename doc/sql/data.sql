INSERT INTO rms.affiche (aid, amessage, adate) VALUES (4, '123', '2019-07-31');
INSERT INTO rms.affiche (aid, amessage, adate) VALUES (5, '1111', '2019-07-31');
INSERT INTO rms.affiche (aid, amessage, adate) VALUES (6, '2222', '2019-07-31');
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (2, '6d3c01', 2018, 4, 1, 0, 1);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (3, '123', 1945, 2, 1, 1, 1);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (4, '10', 2017, 3, 2, 3, 2);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (5, '11', 2016, 3, 1, 1, 1);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (6, '12', 2019, 8, 1, 0, 0);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (7, '12', 2019, 8, 1, 0, 0);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (8, '12', 2019, 8, 1, 0, 0);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (9, '12', 2019, 8, 1, 0, 0);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (10, '12', 2019, 8, 0, 0, 0);
INSERT INTO rms.checkstate (id, eid, cyear, cmonth, atwork, late, early) VALUES (11, '12', 2019, 8, 0, 0, 0);
INSERT INTO rms.checkworker (cid, eid, itime, otime, holiday) VALUES (1, 123, '10:00:00', '20:00:00', 0);
INSERT INTO rms.checkworker (cid, eid, itime, otime, holiday) VALUES (3, 111, '09:10:00', '19:10:00', 0);
INSERT INTO rms.department (did, dname, dmanager) VALUES (1, '部门0', '主管1');
INSERT INTO rms.department (did, dname, dmanager) VALUES (3, '111', '111');
INSERT INTO rms.department (did, dname, dmanager) VALUES (4, '部门1', '主管1');
INSERT INTO rms.department (did, dname, dmanager) VALUES (5, '部门2', '主管2');
INSERT INTO rms.department (did, dname, dmanager) VALUES (7, '1231', '主管111');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (2, '张三', 1, '2019-07-31 16:27:21', 1, 1, '1', '123', '广州', '1997-06-18');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (3, '李四', 1, '2019-07-31 16:27:21', 1, 1, '1', '123', '肇庆', '1996-06-20');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (4, '王五', 1, '2019-07-31 16:27:21', 1, 1, '1', '123', '上海', '1976-01-14');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (5, '赵六', 1, '2019-07-31 16:27:21', 1, 1, '1', '123', '北京', '1987-06-18');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (6, '测试', 1, '2019-07-03 00:00:00', 1, 1, '123', '123', '123', '1990-06-12');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (8, '测试1', 1, '2019-08-05 00:00:00', 1, 1, '123', '1321', '123', '1988-03-15');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (9, '测试2', 2, '2016-08-01 09:49:07', 1, 1, '123', '123', '123', '1999-08-11');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (10, '测试3', 2, '1989-08-01 09:53:48', 1, 1, '123', '123', '123', '1989-08-16');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (11, '测试4', 2, '2017-08-01 09:54:43', 1, 1, '123', '123', '123', '1988-07-12');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (12, '测试5', 2, '2017-08-01 09:54:43', 1, 1, '123', '123', '123', '1995-07-13');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (14, '测试6', 2, '2017-08-01 09:54:43', 1, 1, '123', '123', '123', '1995-07-14');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (15, '测试6', 2, '2017-08-01 09:54:43', 1, 1, '123', '123', '123', '1983-07-14');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (16, '测试7', 2, '2017-08-01 09:54:43', 1, 1, '123', '123', '123', '1983-07-14');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (17, '测试2', 2, '2016-08-01 09:49:07', 1, 1, '123', '123', '123', '1999-08-11');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (18, '测试2', 2, '2016-08-01 09:49:07', 1, 1, '123', '123', '123', '1999-08-11');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (19, '测试2', 2, '2016-08-01 09:49:07', 1, 1, '123', '123', '123', '1999-08-11');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (20, '测试2', 2, '2016-08-01 09:49:07', 1, 1, '123', '123', '123', '1999-08-11');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (21, '测试', 1, '2019-07-03 00:00:00', 1, 1, '123', '123', '123', '1990-06-12');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (22, '测试', 1, '2019-07-03 00:00:00', 1, 1, '123', '123', '123', '1990-06-12');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (23, '测试', 1, '2019-07-03 00:00:00', 1, 1, '123', '123', '123', '1990-06-12');
INSERT INTO rms.employee (eid, ename, sex, workdate, did, pid, identity, phone, address, birthday) VALUES (24, '测试', 1, '2019-07-03 00:00:00', 1, 1, '123', '123', '123', '1990-06-12');
INSERT INTO rms.position (pid, pname, basemoney, count) VALUES (1, '123', 123, 13);
INSERT INTO rms.position (pid, pname, basemoney, count) VALUES (2, '业务部', 3000, 200);
INSERT INTO rms.position (pid, pname, basemoney, count) VALUES (3, '财务部', 6000, 50);
INSERT INTO rms.position (pid, pname, basemoney, count) VALUES (4, '统筹部', 4000, 15);
INSERT INTO rms.position (pid, pname, basemoney, count) VALUES (5, '销售部', 9000, 45);
INSERT INTO rms.position (pid, pname, basemoney, count) VALUES (6, '编辑部1', 5901, 16);
INSERT INTO rms.position (pid, pname, basemoney, count) VALUES (8, '职位1', 3000, 100);
INSERT INTO rms.role (role_id, role) VALUES (1, 'admin');
INSERT INTO rms.role (role_id, role) VALUES (2, 'employee');
INSERT INTO rms.role (role_id, role) VALUES (3, 'dept');
INSERT INTO rms.role_permission (role_id, permission_id) VALUES (1, 1);
INSERT INTO rms.role_permission (role_id, permission_id) VALUES (2, 2);
INSERT INTO rms.role_permission (role_id, permission_id) VALUES (3, 3);
INSERT INTO rms.salary (sid, eid, base, date, bonus) VALUES (1, 1, 1, '2019-07-05', 122);
INSERT INTO rms.salary (sid, eid, base, date, bonus) VALUES (111, 3, 2000, '2019-08-14', 2000);
INSERT INTO rms.salary (sid, eid, base, date, bonus) VALUES (222, 3, 3000, '2019-08-02', 1111);
INSERT INTO rms.sys_user (id, username, password) VALUES (1, '张三', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (2, '李四', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (3, '王五', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (4, 'admin', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (7, 'test', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (13, 'test1', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (14, 'test2', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (27, 'test1', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (28, 'emp', '123');
INSERT INTO rms.sys_user (id, username, password) VALUES (29, 'dept', '123');
INSERT INTO rms.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO rms.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO rms.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO rms.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO rms.user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO rms.user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO rms.user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO rms.user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO rms.user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO rms.user_role (user_id, role_id) VALUES (27, 2);
INSERT INTO rms.user_role (user_id, role_id) VALUES (28, 2);
INSERT INTO rms.user_role (user_id, role_id) VALUES (29, 3);