# spring-start-kotlin
Kotlin Spring Cassandra

## Docker Cassandra
sudo docker pull cassandra:3.11.3

sudo docker run --name cassandra -d -p 9042:9042 cassandra:3.11.3

sudo docker logs -f cassandra

sudo docker exec -it cassandra cqlsh


## Cassandra Create Schema and table
CREATE KEYSPACE IF NOT EXISTS hr  WITH replication = { 'class': 'SimpleStrategy',  'replication_factor' : 3 };

CREATE SCHEMA hr WITH replication = { 'class': 'SimpleStrategy',  'replication_factor' : 1 };

CREATE TABLE employee(id int PRIMARY KEY, name text, age int, department text, salary double);

INSERT INTO employee(id, name, age, department, salary) values (1, 'Alberto', 25, 'Engineering', 500.00);

describe tables;
