delete from Ingredient_Ref;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id , name , type) values ('FLTO' , 'Flour Tortilla' , 'WRAP');
insert into Ingredient (id , name , type) values ('COTO' , 'Corn Tortilla' , 'WRAP');
insert into Ingredient (id , name , type) values ('BEEF' , 'Beef chops' , 'PROTEIN');
insert into Ingredient (id , name , type) values ('PORK' , 'Pork chops' , 'PROTEIN');
insert into Ingredient (id , name , type) values ('TOMT' , 'Diced Tomatoes' , 'VEGGIES');
insert into Ingredient (id , name , type) values ('CUCM' , 'Cucumbers' , 'VEGGIES');
insert into Ingredient (id , name , type) values ('KTCH' , 'Ketchup' , 'SAUCE');
insert into Ingredient (id , name , type) values ('SOUR' , 'Sour Cream' , 'SAUCE');