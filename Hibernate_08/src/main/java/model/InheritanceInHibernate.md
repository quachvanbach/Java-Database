# Trong Hibernate, có ba dạng kế thừa chính mà bạn có thể sử dụng:

## Kế thừa đơn giản (Single Table Inheritance):
Trong kế thừa đơn giản, các đối tượng con được lưu trữ trong một bảng duy nhất, cùng với các cột của lớp cha và các cột riêng của lớp con. Một cột "discriminator" được sử dụng để đánh dấu loại đối tượng. Khi truy vấn, Hibernate sử dụng cột "discriminator" để phân biệt đối tượng con.

## Kế thừa bảng lớp (Table per Class Inheritance):
Trong kế thừa bảng lớp, mỗi lớp con được lưu trữ trong một bảng riêng biệt, chứa cả các cột của lớp cha và lớp con. Không có bảng riêng cho lớp cha. Dữ liệu lớp cha được nhân bản trong các bảng con. Khi truy vấn, Hibernate phải thực hiện join giữa các bảng để lấy thông tin của đối tượng.

## Kế thừa bảng tham chiếu (Table per Concrete Class Inheritance):
Trong kế thừa bảng tham chiếu, mỗi lớp con được lưu trữ trong một bảng riêng biệt, chứa cả các cột của lớp cha và lớp con. Không có bảng riêng cho lớp cha. Khi truy vấn, Hibernate không thực hiện join giữa các bảng, mà chỉ lấy thông tin từ bảng chứa đối tượng con mà ta đang truy vấn.
