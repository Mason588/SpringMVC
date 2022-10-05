create table if not exists job(
	jid int not null auto_increment, -- 主鍵(自動產生序號:1,2,3 過號不返回)
	jname varchar(50) not null unique, -- 工作名稱
	eid int, -- 員工 id
	age int, -- 員工年齡
	primary key(jid),
	foreign key(eid) references emp(eid) -- 外鍵約束
)