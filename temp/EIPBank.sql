--DB 积己
CREATE USER c##eipbank IDENTIFIED BY eipbank
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to c##eipbank;

--霸矫魄 积己
CREATE SEQUENCE seq_board MINVALUE 1 MAXVALUE 10000000;

CREATE TABLE tbl_board (
    bno number(10,0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate, 
    updatedate date default sysdate
);

alter table tbl_board add(replycnt number(10, 0) default 0);
alter table tbl_board add constraint pk_board
primary key(bno);

--瘩臂 积己
create table tbl_reply (
    rno number(10,0),
    bno number(10,0) not null,
    reply varchar2(1000) not null,
    replyer varchar2(50) not null,
    replyDate date default sysdate,
    updateDate date default sysdate
);

create sequence seq_reply MAXVALUE 10000000;
alter table tbl_reply add constraint pk_reply primary key (rno);
alter table tbl_reply add constraint fk_reply_board
foreign key (bno) references tbl_board (bno) on delete cascade;

--颇老
create table tbl_attach_board (
    uuid varchar2(100) not null,
    uploadPath varchar2(200) not null,
    fileName varchar2(100) not null,
    filetype char(1) default 'I',
    bno number(10,0)
);

alter table tbl_attach_board add constraint pk_attach_board primary key (uuid);
alter table tbl_attach_board add constraint fk_board_attach foreign key (bno)
references tbl_board(bno) on delete cascade;;

create table tbl_attach_question (
    uuid varchar2(100) not null,
    uploadPath varchar2(200) not null,
    fileName varchar2(100) not null,
    filetype char(1) default 'I',
    bno number(10,0)
);

alter table tbl_attach_question add constraint pk_attach_question primary key (uuid);
alter table tbl_attach_question add constraint fk_question_attach foreign key (bno)
references tbl_question(qno) on delete cascade;

--雀盔 积己
CREATE TABLE tbl_member (
	userid varchar(32),
	userpw varchar(64) not null,
	userName varchar(32) unique not null,
	admin varchar(1) default '0',
    replyDate date default sysdate,
    updateDate date default sysdate
);

alter table tbl_member add constraint pk_member primary key (userid);

--巩力 积己
CREATE TABLE tbl_question (
    qno number(10, 0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    correct varchar2(50) not null,
    writer varchar2(50) not null,
    regdate date default sysdate, 
    updatedate date default sysdate,
	commentary varchar2(1000) not null,
	total number(10, 0) default 0,
	successer number(10, 0) default 0,
	questionTag varchar2(500)
);

create sequence seq_question MAXVALUE 10000000;
alter table tbl_question add constraint pk_question primary key (qno);