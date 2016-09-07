#建立数据库
create database blog;

#切换到该数据库
use blog;

#用户表
create table admin(
	id int primary key auto_increment,
	nickname varchar(20),
	email varchar(30) not null unique,
	passwd varchar(20) not null
);

#插入默认的邮箱和密码
insert into admin values(null,'whatever','123456789@qq.com','123456');

#博文表
create table article(
	id int primary key auto_increment,
	author_id int not null,
	title varchar(50) not null,
	#文章的预览内容
	peek varchar(100) not null,
	time DATETIME not null,
	read_num int not null,
	comment_num int not null,
	#deleted存'y'表示已经被删除,存'n'表示没有被删除
	deleted varchar(2) not null check(deleted in ('y','n')),
	foreign key(author_id) references admin(id)
);

#评论表

create table comment(
	id int primary key auto_increment,
	user_name varchar(20) not null,
	user_email varchar(30) not null,
	time DATETIME not null,
	content varchar(200) not null,
	#type存'a'表示对博文的回复，存'c'表示对评论的回复
	type varchar(2) not null check(type in ('a','c')),
	article_id int,
	#编程时规定:对评论的回复不能被回复
	comment_id int,
	foreign key(article_id) references article(id),
	foreign key(comment_id) references comment(id)
);

#分类表
create table category(
	id int primary key auto_increment,
	name varchar(20) not null
);

insert into category values(null,"未分配");

#博文分类关联表
create table article_category(
	article_id int not null,
	category_id int not null,
	primary key(article_id,category_id),
	foreign key(article_id) references article(id),
	foreign key(category_id) references category(id)
);

#博客配置表
create table configure(
	id int primary key,
	head varchar(30),
	describ varchar(50),
	edit_type int,
	display_num int,
	email_inform int
);

insert into configure values(1,'博客','描述',1,3,1);