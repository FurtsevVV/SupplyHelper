create table supply (
id int not null auto_increment,
material varchar(250) not null,
quantity double,
price double,
sum double not null,
statussup varchar(30) not null,
date_of_supply date not null,
commentary text,
producer_id int not null,
base_of_supply_id int not null,
primary key (id),
foreign key (producer_id) references producer (id),
foreign key (base_of_supply_id) references baseofsupply (id)
)
