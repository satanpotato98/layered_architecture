datbase used: MariaDB

Table: stduent

MariaDB [student]> desc student
    -> ;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int(11)     | YES  |     | NULL    |       |
| name  | varchar(20) | YES  |     | NULL    |       |
| dept  | varchar(10) | YES  |     | NULL    |       |
| doj   | date        | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
4 rows in set (0.002 sec)


///////////////////////NO PRIMARY KEY/////////////////////////////////


user class inside main package performs crud operations on the the table shown above.
the operations are impletemneted in studentdao class in dao package.
the entity used is student as described above;