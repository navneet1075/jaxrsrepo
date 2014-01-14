jaxrsrepo
=========

java restful  web services repository

This is a simple java based restful web service which communicates with the mysql database to fetch the records and then 

the records are converted into json format and returned back to the client.

json helps in formatting the recordset into human readable format . 

for building this , you need jersey libraries which can be found at jersey.java.net. from there download a zip archive of 

jersey1.7. copy the jars after extracting the zip into the web-inf/lib directory of your web project in eclipse.

This project uses jdbc connection pooling . instead of this , you can use normal jdbc connection which is not efficient 

but can be used for testing puprpose. 

This project uses Glassfish 4.0 Enterprise server from oracle on windows environment .

Summary of the classes and their usages :

package com.manh.restdemo 

DemoService.java : Shows the Basic operation of GET that can be done on the webservice.

package com.manh.dao

JaxRSDao.java:  class used to establish database connection .

package com.manh.util:

ToJSON.java :Utility class for conveting the database resultset into JSON format.

package com.manh.restdemo.inventory

JaxRSInventory.java : class which takes requests for database operations and gives the JSON object back to the client .

