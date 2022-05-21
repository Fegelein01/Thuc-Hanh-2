Em sửa từ bài mẫu Taco
Đầu tiên em coi Ingredient như là product cần lấy với id, name, price, type mặc định hết thành Music
DesignTacoController, ở đây chức năng vẫn được giữ nguyên và hiển thị ra tất cả các sản phẩm lấy từ cơ
sở dữ liệu
design.html, em thay đổi, hiển lấy ra các giá trị và hiển thị ra bảng, bên cạnh thêm link delete và edit
Cuối cùng thêm nút Add product
Add Product sẽ gọi sang add Ingredient, em để thêm dòng Price double, Mặc định type là Music
Delete sẽ gọi sang IngredientController, Trong IngredientController, em thêm GetMapping tương ứng để nhận link này
Trong đây sẽ có hàm tìm theo id trong csdl, truyền sang trang xác nhận xóa
Trang xác nhận xóa như là trang hiển thị thêm thành công nhưng em sửa lại và thêm 2 nút là Yes và No
Yes sẽ gọi đến link delete/yes/ kèm theo tham số là id, trong đó có hàm delete(Ingredient) được thêm vào trong Repository
No sẽ gọi đến link delete/no/ trong đó sẽ gọi về trang home 
Edit thì tương tự, nó gọi đến IngredientController ở đây sẽ chuyển sang 1 form yêu cầu nhập thông tin, Id thì không đổi được
Sau đó sẽ dùng post và đẩy về IngredientController
ở đây repository ( đã bổ sung hàm edit dùng câu lệnh update và cập nhật)
Cơ sở dữ liệu như bài mẫu, được thêm cột price double và sửa lại JDBC cho phù hợp
