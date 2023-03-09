# layered_architecture
creating basic mariaDB manipulation java program using layeed architecture

entity package is used to create student class with id, name, department and date of joining variables with getter and setter functions.

DAO package has the DB connector class, studentDAO interface and its implementation where CRUD operations are performed.

service package has service interface and its implementation to use to DAO package.

main packge has user runnable user class which class service package to perform crud operations on the database in realtime.
