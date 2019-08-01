CREATE TABLE affiche
(
    aid      int AUTO_INCREMENT
        PRIMARY KEY,
    amessage varchar(500) NULL COMMENT '公告信息',
    adate    date         NULL COMMENT '公告日期'
);

CREATE TABLE careerinfo
(
    ciid     int AUTO_INCREMENT
        PRIMARY KEY,
    eid      int          NULL,
    stardate date         NULL,
    enddate  date         NULL,
    workfor  varchar(255) NULL COMMENT '所在单位',
    detail   varchar(255) NULL COMMENT '工作内容'
);

CREATE TABLE checkstate
(
    id     int AUTO_INCREMENT
        PRIMARY KEY,
    eid    varchar(8) NULL,
    cyear  int(4)     NULL,
    cmonth int(2)     NULL,
    atwork int        NULL,
    late   int        NULL,
    early  int        NULL
);

CREATE TABLE checkworker
(
    cid     int AUTO_INCREMENT
        PRIMARY KEY,
    eid     int  NULL,
    itime   time NULL,
    otime   time NULL,
    holiday int  NULL COMMENT '请假'
);

CREATE TABLE department
(
    did      int AUTO_INCREMENT
        PRIMARY KEY,
    dname    varchar(50)  NULL COMMENT '部门名称',
    dmanager varchar(255) NULL COMMENT '部门主管'
);

CREATE TABLE employee
(
    eid      int AUTO_INCREMENT COMMENT '员工id'
        PRIMARY KEY,
    ename    varchar(255) NOT NULL,
    sex      int(255)     NULL,
    workdate datetime     NULL COMMENT '入职时间',
    did      int          NULL COMMENT '部门id',
    pid      int          NULL COMMENT '部门职位',
    identity varchar(255) NULL,
    phone    varchar(255) NULL,
    address  varchar(255) NULL,
    birthday date         NULL
);

CREATE TABLE permission
(
    permission_id  int     NOT NULL,
    permissionEnum tinyint NOT NULL
);

CREATE TABLE position
(
    pid       int AUTO_INCREMENT
        PRIMARY KEY,
    pname     varchar(255) NULL,
    basemoney double       NULL COMMENT '基础工资',
    count     int          NULL COMMENT '岗位人数'
);

CREATE TABLE quit
(
    eid   int  NOT NULL
        PRIMARY KEY,
    qtype int  NULL COMMENT '离职类型',
    qdate date NULL COMMENT '离职时间'
);

CREATE TABLE role
(
    role_id int      NOT NULL,
    role    char(10) NOT NULL COMMENT '1-管理员, 2-职员, 3-部门经理, 4-HR'
);

CREATE TABLE role_permission
(
    role_id       int NOT NULL,
    permission_id int NOT NULL
);

CREATE TABLE salary
(
    sid   int AUTO_INCREMENT
        PRIMARY KEY,
    eid   int    NULL,
    base  double NULL,
    date  date   NULL,
    bonus double NULL COMMENT '奖金'
);

CREATE TABLE sys_user
(
    id       int AUTO_INCREMENT
        PRIMARY KEY,
    username char(20) NOT NULL,
    password char(20) NOT NULL,
    CONSTRAINT user_id_username_uindex
        UNIQUE (id, username)
);

CREATE TABLE transfer
(
    tid     int          NOT NULL
        PRIMARY KEY,
    eid     int          NOT NULL COMMENT '员工id',
    bdid    int          NULL COMMENT '之前部门id',
    adid    int          NULL COMMENT '调动后的部门',
    bpid    int          NULL COMMENT '调动前的部门职位',
    apid    int          NULL COMMENT '调动后部门的职位',
    tdate   date         NULL COMMENT '调动日期',
    ttype   int(255)     NULL COMMENT '调动类型（升职降职录入错误）',
    treason varchar(255) NULL COMMENT '原因'
);

CREATE TABLE user_role
(
    user_id int NOT NULL,
    role_id int NOT NULL
);

CREATE INDEX user_role_user_id_role_id_index
    ON user_role (user_id, role_id);

CREATE
    DEFINER = root@localhost PROCEDURE insert_emp(IN START int(10), IN max_num int(10))
BEGIN

    DECLARE i int DEFAULT 0;

#set autocommit =0 把autocommit设置成0  ；提高执行效率

    SET autocommit = 0;

    REPEAT
        ##重复
        SET i = i + 1;
        INSERT INTO rms.employee(name, date, address)
        VALUES (substring(MD5(RAND()), 1, 6),
                from_unixtime(unix_timestamp('2017-01-01')
                    + floor(rand() * unix_timestamp('2019-06-01') - unix_timestamp('2017-01-01') + 1)),
                substring(MD5(RAND()), 1, 8));
    UNTIL i = max_num ##直到  上面也是一个循环
        END REPEAT; ##满足条件后结束循环
    COMMIT; ##执行完成后一起提交
END;

