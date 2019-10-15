create database if not exists hotel_management;

INSERT INTO role (role_id, role_name)
SELECT * FROM (SELECT 1, 'ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT role_name FROM role WHERE role_name = 'ADMIN'
) LIMIT 1;

INSERT INTO role (role_id, role_name)
SELECT * FROM (SELECT 2, 'USER') AS tmp
WHERE NOT EXISTS (
    SELECT role_name FROM role WHERE role_name = 'USER'
) LIMIT 1;