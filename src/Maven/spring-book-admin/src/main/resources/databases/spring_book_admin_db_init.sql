# added by crane zhou on 2021.08.02
# created database and user (privileges)

USE mysql;
DESC user;

SHOW VARIABLES LIKE 'have_ssl';
SHOW GLOBAL VARIABLES LIKE 'tls_version';

CREATE DATABASE spring_book_admin_db_dev DEFAULT CHARSET UTF8MB4 COLLATE UTF8MB4_UNICODE_CI;

CREATE USER 'sba_sql_dbuser01'@'localhost' IDENTIFIED BY 'Password_1';
CREATE USER 'sba_sql_dbuser01'@'%' IDENTIFIED BY 'Password_1';
GRANT ALL PRIVILEGES ON spring_book_admin_db_dev.* TO 'sba_sql_dbuser01'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON spring_book_admin_db_dev.* TO 'sba_sql_dbuser01'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

# CREATE DATABASE spring_book_admin_db_test DEFAULT CHARSET UTF8MB4 COLLATE UTF8MB4_UNICODE_CI;
# CREATE DATABASE spring_book_admin_db_prod DEFAULT CHARSET UTF8MB4 COLLATE UTF8MB4_UNICODE_CI;

# added by crane zhou on 2021.09.16
# https://mariadb.com/kb/en/securing-connections-for-client-and-server/
SELECT Host, User, ssl_type FROM user;
# https://mariadb.com/kb/en/certificate-creation-with-openssl/

ALTER USER 'sba_sql_dbuser01'@'%'
   REQUIRE SSL;
ALTER USER 'sba_sql_dbuser01'@'localhost'
   REQUIRE SSL;

ALTER USER 'sba_sql_dbuser01'@'%'
   REQUIRE CIPHER 'ECDH-RSA-AES256-SHA384';
ALTER USER 'sba_sql_dbuser01'@'localhost'
   REQUIRE CIPHER 'ECDH-RSA-AES256-SHA384';

ALTER USER 'sba_sql_dbuser01'@'%'
   REQUIRE NONE;
ALTER USER 'sba_sql_dbuser01'@'localhost'
   REQUIRE NONE;


SHOW VARIABLES LIKE 'have_ssl';
GRANT ALL PRIVILEGES ON spring_book_admin_db_dev.* TO 'sba_sql_dbuser01'@'localhost' REQUIRE SSL WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON spring_book_admin_db_dev.* TO 'sba_sql_dbuser01'@'%' REQUIRE SSL WITH GRANT OPTION;
FLUSH PRIVILEGES;
SHOW GLOBAL VARIABLES LIKE 'tls_version';

# added by crane zhou on 2021.09.27

# https://mariadb.com/kb/en/mysqldump/
# https://mariadb.com/products/skysql/docs/clients/mariadb-clients/mariadb-dump/

# only db structure, without data
# mysqldump -d spring_book_admin_db_dev -u sba_sql_dbuser01 -p > spring_book_admin_db_dev_dump_table.sql
# only data, no db structure
# mysqldump -t spring_book_admin_db_dev -u sba_sql_dbuser01 -p > spring_book_admin_db_dev_dump_data.sql
# db structure and data
# mysqldump spring_book_admin_db_dev -u sba_sql_dbuser01 -p > spring_book_admin_db_dev_dump_all.sql
#

# added by crane zhou on 2021.11.03
ALTER TABLE spring_book_admin_db_dev.tbl_auth_roles MODIFY role_code varchar(32) AFTER role_name COMMENT "角色代码"
