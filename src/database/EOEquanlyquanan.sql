create database EOE
go

use EOE
go

--Phuc
create table nhanvien(
	MaNV int identity(1,1) primary key,
	Ho nvarchar(255),
	Ten nvarchar(255),
	GioiTinh nvarchar(255),
	ChucVu nvarchar(255)
)

create table phanquyen(
	Quyen nvarchar(255) primary key,
	QLSanPham int,
	QLNhanVien int,
	QLKhachHang int,
	ThongKe int
)

create table taikhoan(
	MaNV int primary key
		constraint FK_nhanvien_taikhoan Foreign key references nhanvien(MaNV)
										on update 
											cascade
										on delete
											cascade,
	Quyen nvarchar(255)
		constraint FK_phanquyen_taikhoan Foreign key references phanquyen(Quyen)
										on update 
											cascade
										on delete
											cascade,
	TenDangNhap nvarchar(255),
	MatKhau nvarchar(255),
	TrangThai int
)

--Manh
create table loai(
	MaLoai int Identity(1,1) not null primary key,
	TenLoai nvarchar(255),
)

create table sanpham(
	MaSP int Identity(1,1) not null primary key,
	TenSP nvarchar(255),
	MaLoai int,
		constraint FK_sanpham_MaLoai foreign key (MaLoai) references loai(MaLoai)
										on delete cascade
										on update cascade,
	SoLuong int,
	DonViTinh nvarchar(255),
	HinhAnh varchar(255),
	DonGia int
)

--Luc
CREATE TABLE khachhang(
  MaKH          int Identity(1,1) primary key,
  Ho			nvarchar(255),
  Ten			nvarchar(255),
  GioiTinh      nvarchar(3),
  TongChiTieu   int,
  TinhTrang		int,
)

CREATE TABLE hoadon(
  MaHD          int Identity(1,1) primary key,
  MaKH			int CONSTRAINT FK_hoadon_khachhang FOREIGN KEY REFERENCES khachhang
					ON DELETE
						CASCADE
					ON UPDATE
						CASCADE,
  MaNV			int CONSTRAINT FK_hoadon_nhanvien FOREIGN KEY REFERENCES nhanvien
					ON DELETE
						CASCADE
					ON UPDATE
						CASCADE,
  NgayLap		date,
  TongTien		int,
  GhiChu		nvarchar(255),
)

CREATE TABLE cthoadon(
  MaHD          int CONSTRAINT FK_cthoadon_hoadon FOREIGN KEY REFERENCES hoadon
				ON DELETE
					CASCADE
				ON UPDATE
					CASCADE,
  MaSP			int CONSTRAINT FK_cthoadon_MaSP FOREIGN KEY REFERENCES sanpham
				ON DELETE
					CASCADE
				ON UPDATE
					CASCADE,
  SoLuong		int,
  DonGia		int,
  ThanhTien		int,
  primary key (MaHD,MaSP),
)

GO

-- --------------------------------------------------------
--
-- Đang đổ dữ liệu cho bảng nhanvien
--
INSERT INTO nhanvien (Ho, Ten, GioiTinh, ChucVu) VALUES
(N'Admin', N'', N'', N'Admin'),
(N'Lê Anh', N'Quốc', N'Nam', N'Quản Lý'),
(N'Hồ Quang', N'Phúc', N'Nam', N'Quản Lý'),
(N'Trần Thị Kim', N'Ngân', N'Nữ', N'Quản Lý'),
(N'Trần Đức Mạnh', N'Mạnh', N'Nam', N'Quản Lý'),
(N'Huỳnh Tấn', N'Lực', N'Nam', N'Quản Lý'),
(N'Nguyễn Văn', N'Linh', N'Nữ', N'Nhân Viên'),
(N'Trần Văn', N'Hùng', N'Nam', N'Nhân Viên')

-- --------------------------------------------------------
--
-- Đang đổ dữ liệu cho bảng phanquyen
--
INSERT INTO phanquyen (Quyen, QLSanPham, QLNhanVien, QLKhachHang, ThongKe) VALUES
(N'Default', 0, 0, 0, 0),
(N'Nhân viên', 0, 0, 1, 0),
(N'Quản lý', 0, 1, 1, 1),
(N'Quản trị', 1, 1, 1, 1)

-- --------------------------------------------------------
--
-- Đang đổ dữ liệu cho bảng taikhoan
--
INSERT INTO taikhoan (MaNV, TenDangNhap, MatKhau, Quyen, TrangThai) VALUES
(1, N'admin', N'admin', N'Quản trị', 1),
(2, N'quoc', N'quoc', N'Quản lý', 1),
(3, N'phuc', N'phuc', N'Quản lý', 1),
(4, N'ngan', N'ngan', N'Quản lý', 1),
(5, N'manh', N'manh', N'Quản lý', 1),
(6, N'luc', N'luc', N'Quản lý', 1),
(7, N'nv01', N'nv01', N'Nhân viên', 1),
(8, N'nv02', N'nv02', N'Nhân viên', 1)

-- --------------------------------------------------------
--
-- Đang đổ dữ liệu cho bảng khachhang
--
INSERT INTO khachhang (Ho, Ten, GioiTinh, TongChiTieu, TinhTrang) VALUES
(N'Nguyễn Văn', N'Mong', N'Nam', 150000, 1),
(N'Trần Ngọc', N'Được', N'Nữ', 485000, 1),
(N'Lê Thị', N'Qua', N'Nữ', 40000, 1)

-- --------------------------------------------------------
--
-- Đang đổ dữ liệu cho bảng loai
--
INSERT INTO loai (TenLoai) VALUES
(N'Đồ ăn'),
(N'Nước uống')

-- --------------------------------------------------------
--
-- Đang đổ dữ liệu cho bảng sanpham
--
INSERT INTO sanpham (TenSP, MaLoai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES
(N'Mỳ quảng', 1, 31, N'Tô', 'doan0.png', 25000),
(N'Bún bò', 1, 39, N'Tô', 'doan1.png', 30000),
(N'Cơm chiên', 1, 34, N'Dĩa', 'doan2.png', 20000),
(N'Pepsi lon 330ml', 2, 150, N'Lon', 'douong0.png', 12000),
(N'7Up lon 330ml', 2, 150, N'Lon', 'douong1.png', 11000),
(N'Nước suối Aquafina', 2, 175, N'Chai', 'douong2.png', 10000)

-- -------------------------------------------------------- 
--
-- Đang đổ dữ liệu cho bảng hoadon
--
INSERT INTO hoadon (MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES
(1, 3, '2022-01-04', 150000, N'Đã thanh toán'),
(2, 2, '2022-02-21', 485000, N'Đã thanh toán'),
(3, 1, '2022-04-24', 40000, N'Đã thanh toán')

-- --------------------------------------------------------
--
-- Đang đổ dữ liệu cho bảng cthoadon
--
INSERT INTO cthoadon (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES
(1, 1, 4, 25000, 100000),
(1, 6, 5, 10000, 50000),
(2, 1, 5, 25000, 125000),
(2, 2, 5, 30000, 150000),
(2, 3, 5, 20000, 100000),
(2, 5, 10, 11000, 110000),
(3, 2, 2, 20000, 40000)