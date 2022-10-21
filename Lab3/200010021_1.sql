-- mysql -u root -p --

-- create user 'lab3'@'localhost' identified by 'Abhi2002**'
-- grant all privileges on lab3.* to 'lab3'@'localhost';


-- mysql -u lab3 -p --

-- create database lab3;

USE lab3;

drop table shipment;
drop table supplier;
drop table part;

CREATE TABLE part
            (
                part_no integer,
                part_name varchar(20),
                color     varchar(10),
                weight    numeric(10,3),

                primary key (part_no)
            ) ;

CREATE TABLE supplier
            (
                supplier_no integer,
                sup_name    varchar(20),
                city 		varchar(20),
                bank        varchar(20),

                primary key (supplier_no)
            );

CREATE TABLE shipment
            (
                shipment_no integer,
                part_no integer,
                supplier_no integer,
                _date       DATE,
                quantity  integer,
                price     decimal(10,2),

                primary key(shipment_no),

                foreign key (part_no) references part(part_no) on delete set null,

                foreign key (supplier_no) references supplier(supplier_no) on delete set null
            );

INSERT INTO part
VALUES
(1, "wheel", "Red", 10.500);

INSERT INTO supplier
VALUES
(1, "GK", "Blue", "SBI");

INSERT INTO shipment
VALUES
(1, 1, 1, STR_TO_DATE('2020-10-11', '%Y-%m-%d'), 10, 1999.99);


SELECT sup_name from 
 
supplier join shipment using(supplier_no)
join part using (part_no)
 
WHERE color = 'Red';


SELECT sup_name, sum(price * quantity) from

supplier join shipment using(supplier_no)

group by (sup_name);


SELECT sup_name from

supplier join shipment using(supplier_no)


group by (sup_name)
having 

count(DISTINCT part_no) = (SELECT count(part_no) from part);
