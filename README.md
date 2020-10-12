# Spring Boot Jdbc

## MariaDB Database
```
$mysql -u root -p
```

### Initial Database
```
CREATE DATABASE spring_jdbc_tutorial;
CREATE USER spring_jdbc_user@localhost IDENTIFIED BY 'spring_jdbc_password';
GRANT ALL PRIVILEGES ON spring_jdbc_tutorial.* TO spring_jdbc_user@localhost;

CREATE USER spring_jdbc_user@'%' IDENTIFIED BY 'spring_jdbc_password';
GRANT ALL PRIVILEGES ON spring_jdbc_tutorial.* TO spring_jdbc_user@'%';

SELECT user, host FROM mysql.user;
SHOW GRANTS FOR cms_test@localhost;
```

#### TABLES
```
MariaDB [cms_test]> show columns from users;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| username | varchar(255) | NO   | PRI | NULL    |       |
| email    | varchar(255) | YES  |     | NULL    |       |
| password | varchar(255) | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
```

````
SHOW CREATE TABLE role;
````
