
# Nhóm 14 - Spring boot
Nhóm tập chung xây dựng các api get, put cho thương mại điện tử






## Thành viên nhóm 


| Mã số sinh viên  | Tên thành viên  | 
|-------|-------|
| 20520669 | Nguyễn Duy Trọng Nhân | 
| 22520287 | Nguyễn Quang Dũng | 
| 21522098 | Phạm Huy Hoàng | 
| 20521780 | Trương Nguyên Phương |
| 19520801 | Nguyễn Trọng Nhân |

	

## Cách cài đặt

Cài đặt các dòng sau trong file application.properties:
```c
server.servlet.context-path=/api
spring.datasource.url=jdbc:mysql://localhost:3306/qlysinhvien
spring.datasource.username=root
spring.datasource.password=123456

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update


```

Sau đó bạn tạo database theo hương dẫn sau:

1.Bạn vào file database_seminar.sql có sẵn trong github khởi tạo chúng bằng phần mềm mysql.

2.Sau khi tạo xong bạn file database_seminar.sql khỏi project.

3.Bây giờ bấm start là chạy bình thường. 

4.Sau đó bạn truy cập đường dẫn http://localhost:8080/api/swagger-ui/index.html#/ để hiện kết quả

