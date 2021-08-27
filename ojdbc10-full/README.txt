======================================================
Oracle Free Use Terms and Conditions (FUTC) License 
======================================================
https://www.oracle.com/downloads/licenses/oracle-free-license.html
===================================================================

ojdbc10-full.tar.gz - JDBC Thin Driver and Companion JARS
========================================================
This TAR archive (ojdbc10-full.tar.gz) contains the 19.11 release of the Oracle JDBC Thin driver(ojdbc10.jar), the Universal Connection Pool (ucp.jar) and other companion JARs grouped by category. 

(1) ojdbc10.jar (4,443,768 bytes) -
(SHA1 Checksum: 70765534f2f0493aa443b99a18f00e8a28c40a4e)
Oracle JDBC Driver compatible with JDK10 and JDK11;
(2) ucp.jar (1,689,079 bytes) - (SHA1 Checksum: 656de9c8eafea8fb91bf13839c2687af0fcad35f)
Universal Connection Pool classes for use with JDK8, JDK9, and JDK11 -- for performance, scalability, high availability, sharded and multitenant databases.
(3) ojdbc.policy (11,515 bytes) - Sample security policy file for Oracle Database JDBC drivers

======================
Security Related JARs
======================
Java applications require some additional jars to use Oracle Wallets. 
You need to use all the three jars while using Oracle Wallets. 

(4) oraclepki.jar (305,665 bytes) - (SHA1 Checksum: 8d404aa3e9c209672bd4540d6deea4355f6f52fc)
Additional jar required to access Oracle Wallets from Java
(5) osdt_cert.jar (210,336 bytes) - (SHA1 Checksum: 2f8ff26882fd582242dab1456b7e2afaf84d8dd8)
Additional jar required to access Oracle Wallets from Java
(6) osdt_core.jar (312,198 bytes) - (SHA1 Checksum: d4215824ceb0704b95d683c299d4e74dfe43da32)
Additional jar required to access Oracle Wallets from Java

=============================
JARs for NLS and XDK support 
=============================
(7) orai18n.jar (1,663,954 bytes) - (SHA1 Checksum: da8461bfa65240f04c8cf783e7048152ea15057f) 
Classes for NLS support
(8) xdb.jar (265,580 bytes) - (SHA1 Checksum: 16e9196277ebeff6ef3b8aea9019362156ede618)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(9) xmlparserv2.jar (1,935,495 bytes) - (SHA1 Checksum: 2bb7a26c3d7c471707c9af90e945266c1b13c4c9)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
====================================================
JARs for Real Application Clusters(RAC), ADG, or DG 
====================================================
(10) ons.jar (156,244 bytes) - (SHA1 Checksum: 64cdb5f30b2e7629d0c4deb5fb4fd6ff12fcb01b)
for use by the pure Java client-side Oracle Notification Services (ONS) daemon
(11) simplefan.jar (32,169 bytes) - (SHA1 Checksum: d6f7041755926c1e67b3e973b62ecf8896099369)
Java APIs for subscribing to RAC events via ONS; simplefan policy and javadoc

=================
USAGE GUIDELINES
=================
Refer to the JDBC Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjdbc/index.html) and Universal Connection Pool Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjucp/index.html)for more details. 
