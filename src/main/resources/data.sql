
--  insert category
insert into category(id,name_uz, name_ru, name_eng) values (2 ,'name_uz', 'name_ru', 'name_eng');
-- insert admin
insert into profile(name,surname,password,email,role,created_date)
SELECT 'Toshmat','Toshatov','123','toshmat@mail.ru','ADMIN',now()
    WHERE
    NOT EXISTS (
        SELECT id FROM profile WHERE surname = 'Toshatov'
    );