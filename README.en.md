1. # 橙子 OCR

   #### Project Introduction

   OrangeOcr (Orange OCR) rely on cutting-edge deep learning and other artificial intelligence technologies to provide multi-channel, high-precision OCR character recognition technology services, printed text recognition accuracy rate can be as high as 90%, provide general OCR recognition, ID card recognition, Bank card recognition, invoice recognition, license plate recognition, and other common industrial OCR recognition services.

   Orange OCR software includes orange_ocr-viwer, orange_ocr-server, orange_ocr-admin, which are the front end, management background, and service monitoring.

   #### Software Architecture

   Microservices architecture (microservices architecture) is an upgrade of service-oriented architecture (abbreviated SOA).

    RESTful API mode: Services are provided through APIs.

   <img src = "project-image / 1.png" style = "zoom: 80%;" />


   #### Installation tutorial

   1. Make sure to install maven 3.6+

      `` `xml
      mvn -v
      `` `

   2. Project root directory packaging

      `` `xml
      mvn clean package
      `` `

   3. Start

      `` `xml
      nohup java -Xms800m -Xmx800m -XX: PermSize = 256m -XX: MaxPermSize = 512m -XX: MaxNewSize = 512m -jar xxxjar
      `` `

   #### Using technology

   `` `
   1: Spring Boot 2.2.6
   2: Spring-Data-Jpa
   3: Spring-Security
   4: spring-boot-starter-mail
   5: fastjson
   6: thymeleaf
   7: knife4j
   8: lombok
   9: hutool
   10: Mysql
   11: Spring-Admin
   `` `


   #### Instructions for use

   1. Can use Jpa directly

   2. You can also use SQL.sql

      `` `xml
      SQL file in the project change directory: orange_ocr.sql
      `` `

   #### Configuration instructions

   `` `
   Configure the monitoring address in the application.xml of the orange_ocr-admin project:

   # Example:
   orange_ocr-viwer: http: // localhost: 9090 /
   orange_ocr-server: http: // localhost: 9091 /
   orange_ocr-admin: http: // localhost: 9092 /
   `` `

   #### Project display

    ! [] (project-image / 2.png)

   ! [] (project-image / 7.png)

   ! [] (project-image / 12.png)
