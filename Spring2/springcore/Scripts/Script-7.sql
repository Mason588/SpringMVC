-- 向左關聯
select f.fid, f.fname, f.creattime,
s.sid, s.fid, s.symbol, s.share
from fund f left join fundstock s 
on f.fid = s.fid 
where s.fid is null

-- 向左關聯差集
select f.fid, f.fname, f.creattime,
s.sid, s.fid, s.symbol, s.share
from fund f left join fundstock s 
on f.fid = s.fid 
where s.fid is null

-- 向右差集
select f.fid, f.fname, f.creattime,
s.sid, s.fid, s.symbol, s.share
from fund f right join fundstock s 
on f.fid = s.fid 
where s.fid is null

-- 聯集
select f.fid, f.fname from fund f
union all
select s.sid, s.symbol from fundstock s
union all 
select b.bid, b.bname from book b