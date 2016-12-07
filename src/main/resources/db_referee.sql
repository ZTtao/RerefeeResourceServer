create table user(
	user_id int not null auto_increment,
	password varchar(255),
	nick_name varchar(20),
	real_name varchar(20),
	gender varchar(2),
	height float,
	weight float,
	email varchar(20),
	phone varchar(20),
	address varchar(50),
	note varchar(255),
	register_time datetime,
	is_delete boolean,
	other varchar(255),
	primary key(user_id)
	)engine=INNODB;
create table player(
	player_id int not null auto_increment,
	user_id int not null,
	start_play_time date,
	team varchar(20),
	experience varchar(50),
	honor varchar(50),
	register_time datetime,
	note varchar(255),
	is_delete boolean,
	other varchar(255),
	primary key(player_id),
	foreign key (user_id) references user(user_id)
	)engine=INNODB;
create table referee(
	referee_id int not null auto_increment,
	user_id int not null,
	start_judge_time date,
	experience varchar(50),
	honor varchar(50),
	certificate varchar(50),
	register_time datetime,
	note varchar(255),
	is_delete boolean,
	other varchar(255),
	primary key(referee_id),
	foreign key (user_id) references user(user_id)
	)engine=INNODB;
create table post(
	post_id int not null auto_increment,
	user_id int not null,
	title varchar(50),
	content varchar(255),
	create_time datetime,
	note varchar(255),
	is_delete boolean,
	other varchar(255),
	primary key (post_id),
	foreign key(user_id) references user(user_id)
	)engine=INNODB;
create table comment(
	comment_id int not null auto_increment,
	post_id int not null,
	user_id int not null,
	content varchar(255),
	create_time datetime,
	is_delete boolean,
	primary key(comment_id),
	foreign key(post_id) references post(post_id),
	foreign key(user_id) references user(user_id)
	)engine=INNODB;
create table chat_history(
	his_id int not null auto_increment,
	from_user_id int not null,
	to_user_id int not null,
	msg_type varchar(10),
	content varchar(255),
	create_time datetime,
	is_delete boolean,
	primary key (his_id),
	foreign key (from_user_id) references user(user_id),
	foreign key (to_user_id) references user(user_id)
	)engine=INNODB;
create table offline_message(
	msg_id int not null auto_increment,
	from_user_id int not null,
	to_user_id int not null,
	msg_type varchar(10),
	content varchar(255),
	create_time datetime,
	is_receive boolean,
	is_delete boolean,
	primary key (msg_id),
	foreign key (from_user_id) references user(user_id),
	foreign key (to_user_id) references user(user_id)
	)engine=INNODB;
create table referee_reservation(
	ref_res_id int not null auto_increment,
	player_id int not null,
	game_time datetime,
	address varchar(255),
	game_state varchar(50),
	referee_count varchar(10),
	referee_require varchar(50),
	reward varchar(50),
	note varchar(255),
	is_receive boolean,
	is_delete boolean,
	primary key (ref_res_id),
	foreign key (player_id) references player(player_id)
	)engine=INNODB;
create table referee_reply(
	ref_rep_id int not null auto_increment,
	referee_id int not null,
	ref_res_id int not null,
	status varchar(10),
	note varchar(255),
	is_delete boolean,
	create_time datetime,
	primary key (ref_rep_id),
	foreign key (referee_id) references referee(referee_id),
	foreign key (ref_res_id) references referee_reservation(ref_res_id)
	)engine=INNODB;
create table game_reservation(
	game_res_id int not null auto_increment,
	player_id int not null,
	game_time datetime,
	address varchar(255),
	team varchar(50),
	level varchar(255),
	note varchar(255),
	is_receive boolean,
	is_delete boolean,
	create_time datetime,
	primary key (game_res_id),
	foreign key (player_id) references player(player_id)
	)engine=INNODB;
create table game_reply(
	game_rep_id int not null auto_increment,
	player_id int not null,
	game_res_id int not null,
	status varchar(10),
	note varchar(255),
	is_delete boolean,
	create_time datetime,
	primary key (game_rep_id),
	foreign key (player_id) references player(player_id),
	foreign key (game_res_id) references game_reservation(game_res_id)
	)engine=INNODB;
create table collection(
	coll_id int not null auto_increment,
	user_id int not null,
	post_id int not null,
	coll_time datetime,
	note varchar(255),
	is_delete boolean,
	create_time datetime,
	primary key (coll_id),
	foreign key (user_id) references user(user_id),
	foreign key (post_id) references post(post_id)
	)engine=INNODB;