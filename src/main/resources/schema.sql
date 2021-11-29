create table if not exists change_log (
	id varchar(4) not null,
    name varchar(25) not null UNIQUE,
	PRIMARY KEY (id)
);

create table if not exists building (
    id varchar(4) not null,
    name varchar(25) not null UNIQUE,
    address varchar(100) not null,
    hotline varchar(15) not null UNIQUE,
    PRIMARY KEY (id)
);

create table if not exists floor (
    id varchar(4) not null,
    name varchar(25) not null UNIQUE,
    floor_area int(25) not null,
    unit_price bigint(25) not null,
    status ENUM ('available', 'unavailable'),
    building_id varchar(4) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (building_id) REFERENCES building(id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists company (
    id varchar(4) not null,
    name varchar(25) not null UNIQUE,
    tax_code varchar(25) not null,
    capital bigint(25) not null,
    field_operation varchar(25) not null,
    phone_number varchar(25) not null UNIQUE,
    PRIMARY KEY (id)
);

create table if not exists used_area (
    id varchar(4) not null,
    used_area int(25) not null,
    rental_term varchar(200) not null,
    floor_id varchar(4) not null,
    company_id varchar(4) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (floor_id) REFERENCES floor(id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists employee (
    id varchar(4) not null,
    name varchar(25) not null,
    dob date not null,
    card_id varchar(25) not null UNIQUE,
    phone_number varchar(25) not null UNIQUE,
    company_id varchar(4) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists salary (
    id varchar(4) not null,
    position ENUM ('Manager','Technicians','Labourer','Guard') not null,
    salary_grade int(10) not null,
    salary bigint(25) not null,
    PRIMARY KEY (id)
);

create table if not exists staff (
    id varchar(4) not null,
    name varchar(25) not null,
    dob date not null,
    address varchar(25) not null,
    phone_number varchar(25) not null UNIQUE,
    floor_id varchar(4) not null,
    salary_id varchar(4) not null,
    building_id varchar(4) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (building_id) REFERENCES building(id) ON DELETE CASCADE,
    FOREIGN KEY (salary_id) REFERENCES salary(id) ON DELETE CASCADE,
    FOREIGN KEY (floor_id) REFERENCES floor(id) ON DELETE CASCADE
);

create table if not exists worked_time (
    id varchar(4) not null,
    worked_days int(15),
    worked_date varchar(10) not null,
    staff_id varchar(4) not null,
    salary_id varchar(4) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (salary_id) REFERENCES salary(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (staff_id) REFERENCES staff(id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists service (
    id varchar(4) not null,
    name varchar(25) not null UNIQUE,
    type varchar(25),
    unit_price bigint(25) not null,
    building_id varchar(4) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (building_id) REFERENCES building(id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists used_service (
    id varchar(4) not null,
    service_id varchar(4) not null,
    company_id varchar(4) not null,
    month varchar(4) not null,
    year varchar(4) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (service_id) REFERENCES service(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE ON UPDATE CASCADE
);

