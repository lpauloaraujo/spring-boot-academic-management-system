## ⚙️ Configuration

⚠️ Important:
Make sure you have a MySQL database created with the name scientia_university before running the application.

To run the application, you must create an `application.properties` file inside the directory: src/main/resources

and add the following configuration:

```properties
spring.application.name=backend25

spring.datasource.url=jdbc:mysql://localhost:3306/scientia_university?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

