-- 交易 TX(Transaction) 所需要的資料表
-- book(書籍資料)、stock(庫存資料)、wallet(客戶雲端錢包)
-- 建立 book(書籍資料)
create table if not exists book(
   bid integer not null auto_increment,
   bname varchar(20) not null,
   price integer,
   ct timestamp default current_timestamp,
   primary key (bid)
);


create table if not exists stock(
   sid integer not null auto_increment,
   bid integer not null,  -- book(書籍資料) 的 id
   amounty integer,
   primary key (sid),
   foreign key(bid) references book(bid) -- 外鍵關聯
);

-- 建立wallet(客戶雲端錢包)
create table if not exists wallet(
   wid integer not null auto_increment,
   wname varchar(20) not null,  -- book(書籍資料) 的 id
   money integer default 0,
   primary key (wid) -- 主鍵
  );