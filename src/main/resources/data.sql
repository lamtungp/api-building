insert into building (id, name, address, hotline)
select * from (select 'b001', 'PTIT Building', 'Ha Dong, Ha Noi', '0123456789') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;

insert into floor (id, name, floor_area, unit_price, status, building_id)
select * from (select 'f001', '1st Floor', 200, 5000000, 'available', 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into floor (id, name, floor_area, unit_price, status, building_id)
select * from (select 'f002', '2nd Floor', 200, 6000000, 'available', 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into floor (id, name, floor_area, unit_price, status, building_id)
select * from (select 'f003', '3rd Floor', 200, 7000000, 'available', 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into floor (id, name, floor_area, unit_price, status, building_id)
select * from (select 'f004', '4th Floor', 200, 8000000, 'available', 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into floor (id, name, floor_area, unit_price, status, building_id)
select * from (select 'f005', '5th Floor', 200, 9000000, 'available', 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into floor (id, name, floor_area, unit_price, status, building_id)
select * from (select 'f006', '6th Floor', 200, 10000000, 'available', 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into floor (id, name, floor_area, unit_price, status, building_id)
select * from (select 'f007', '7th Floor', 200, 11000000, 'available', 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;

insert into service (id, name, type, unit_price, building_id)
select * from (select 's001', 'Security service', 'service', 500000, 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into service (id, name, type, unit_price, building_id)
select * from (select 's002', 'Cleaning service', 'service', 500000, 'b001') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;


insert into salary (id, position, salary_grade, salary)
select * from (select 'sa01', 'Manager', 1, 50000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa02', 'Manager', 2, 35000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa03', 'Manager', 3, 25000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa04', 'Technicians', 1, 45000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa05', 'Technicians', 2, 30000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa06', 'Technicians', 3, 20000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa07', 'Labourer', 1, 9000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa08', 'Labourer', 2, 6000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa09', 'Labourer', 3, 3000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa10', 'Guard', 1, 12000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa11', 'Guard', 2, 9000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;
insert into salary (id, position, salary_grade, salary)
select * from (select 'sa12', 'Guard', 3, 7000000) as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;

insert into change_log (id, name)
select * from (select 'cl01', 'change_log') as tmp
where not exists (
    select * from change_log where name='change_log'
) limit 1;

