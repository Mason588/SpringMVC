select e.ename,j.jname
from emp e, job j
where e.eid = j.eid 
order by e.ename