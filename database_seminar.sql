use qlysinhvien;
show tables;
select * from TAIKHOAN
create database qlysinhvien
drop database qlysinhvien
show columns from TAIKHOAN ;
show columns from Diemrenluyen;
show columns from sinhvien;
CREATE TABLE GiaoVien (
    MaGiaoVIen INT PRIMARY KEY,
    Hoten NVARCHAR(50) NOT NULL,
    NgaySinh DATE,
    GioiTinh NVARCHAR(20),
    Phone VARCHAR(20),
    Diachi NVARCHAR(50),
    TaiKhoan VARCHAR(50) NOT NULL,
    MatKhau VARCHAR(50) NOT NULL
);

CREATE TABLE Khoa (
    MaKhoa VARCHAR(20) PRIMARY KEY,
    TenKhoa NVARCHAR(50) NOT NULL
);
CREATE TABLE Lop (
    MaLop VARCHAR(20) PRIMARY KEY,
    TenLop NVARCHAR(50) NOT NULL,
    MaKhoa VARCHAR(20) NOT NULL,
    MaGiaoVien INT NOT NULL,
    FOREIGN KEY (MaKhoa) REFERENCES Khoa(MaKhoa),
    FOREIGN KEY (MaGiaoVien) REFERENCES GiaoVien(MaGiaoVien)
);
CREATE TABLE SinhVien (
    MaSinhVien VARCHAR(20) PRIMARY KEY,
    Hoten NVARCHAR(50) NOT NULL,
    NgaySinh DATE NOT NULL,
    GioiTinh NVARCHAR(20) NOT NULL,
    Phone VARCHAR(20) NOT NULL,
    DiaChi NVARCHAR(50) NOT NULL,
    MaLop VARCHAR(20) NOT NULL,
    FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
);
CREATE TABLE TaiKhoan (
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    quyen NVARCHAR(20)
);

CREATE TABLE DiemRenLuyen (
    MaSV VARCHAR(20) PRIMARY KEY,
    Diem INT NOT NULL,
    XepLoai VARCHAR(20) NOT NULL,
    Ki INT NOT NULL,
    NamHoc VARCHAR(20) NOT NULL,
 
    FOREIGN KEY (MaSinhVien) REFERENCES Sinhvien(MaSinhVien)
);

INSERT INTO TAIKHOAN VALUES
('user1', 'pass123', 'admin'),
('user2', 'pass456', 'user'),
('user3', 'pass789', 'user'),
('user4', 'passabc', 'user'), 
('user5', 'passdef', 'user');

INSERT INTO GiaoVien (MaGiaoVien, Hoten, NgaySinh, GioiTinh, Phone, Diachi, TaiKhoan, MatKhau) 
VALUES 
(1, 'Nguyen Van A', '1980-05-10', 'Nam', '0123456789', '123 ABC Street', 'teacher1', 'pass123'),
(2, 'Tran Thi B', '1975-08-20', 'Nu', '0987654321', '456 XYZ Street', 'teacher2', 'pass456');

INSERT INTO Khoa (MaKhoa, TenKhoa) 
VALUES 
('K01', 'Khoa Cong Nghe'),
('K02', 'Khoa Kinh Te');

INSERT INTO Lop (MaLop, TenLop, MaKhoa, MaGiaoVien) 
VALUES 
('L01', 'Lop 1', 'K01', 1),
('L02', 'Lop 2', 'K01', 2);

INSERT INTO SinhVien (MaSinhVien, Hoten, NgaySinh, GioiTinh, Phone, DiaChi, MaLop) 
VALUES 
('SV001', 'Nguyen Van An', '2000-03-15', 'Nam', '0123456789', '789 XYZ Street', 'L01'),
('SV002', 'Tran Thi Lan', '2001-06-20', 'Nu', '0987654321', '456 ABC Street', 'L01'),
('SV003', 'Hoang Minh Duc', '2002-09-25', 'Nam', '0123456789', '123 DEF Street', 'L02');

INSERT INTO TaiKhoan (username, password, Quyen) 
VALUES 
('teacher1', 'pass123', 'GiaoVien'),
('teacher2', 'pass456', 'GiaoVien'),
('student1', 'pass789', 'SinhVien'),
('student2', 'passabc', 'SinhVien');

INSERT INTO DiemRenLuyen (MaSV, Diem, XepLoai, Ki, NamHoc ) 
VALUES 
('SV001', 80, 'Tot', 1, '2023-24' ),
('SV002', 70, 'TrungBinh', 1, '2023-24'),
('SV003', 90, 'Tot', 1, '2023-24' );