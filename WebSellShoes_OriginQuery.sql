CREATE DATABASE SellShoes

On Primary (
	Name = SellShoes_data, 
	FileName = 'D:\SPRING2023\PRJ301\project\SellShoes_data.mdf',
	Size = 10MB,
	MaxSize = unlimited,
	FileGrowth = 2MB
)

Log On (
	Name = SellShoes_log,
	FileName = 'D:\SPRING2023\PRJ301\project\SellShoes_log.ldf',
	Size = 10MB,
	MaxSize = unlimited,
	FileGrowth = 2MB
)

USE SellShoes

CREATE TABLE [User] (
	userId INT IDENTITY(1,1) CONSTRAINT PK_User PRIMARY KEY,
	userName NVARCHAR(50),
	userGender BIT,
	userDob DATE,
	userEmail VARCHAR(80),
	userPhoneNumber VARCHAR(10),
	userAddress NVARCHAR(300),
	userAccount NVARCHAR(50),
	userPassword NVARCHAR(50),
	isAdmin BIT
)

CREATE TABLE Brand (
	brandId INT IDENTITY(1,1) CONSTRAINT PK_Brand PRIMARY KEY,
	brandDetail NVARCHAR(3000),
	brandName NVARCHAR(20),
	image VARCHAR(200)
)

CREATE TABLE Shoes (
	shoesId INT IDENTITY(1,1) CONSTRAINT PK_Shoes PRIMARY KEY,
	shoesCode VARCHAR(100),
	shoesOrigin NVARCHAR(30),
	shoesDetail NVARCHAR(500),
	shoesName NVARCHAR(100),
	shoesColor VARCHAR(15),
	shoesPrice MONEY,
	shoesDecription NVARCHAR(200),
	shoesImage VARCHAR(200),
	shoesSize FLOAT,
	shoesStockQuantity INT,
	shoesGender BIT,
	shoesDiscount FLOAT,
	brandId INT CONSTRAINT FK_Shoes_brandId REFERENCES Brand(brandId),
	userId INT CONSTRAINT FK_Shoes_userId REFERENCES [User](userId)
)

CREATE TABLE ImportHistory (
	shoesId INT CONSTRAINT FK_ImportHistory_shoesId REFERENCES Shoes(shoesId) NOT NULL,
	[dateAdd] DATE NOT NULL,
	quantity INT
)
ALTER TABLE ImportHistory
	ADD CONSTRAINT FK_ImportHistory_shoesId_dateAdd PRIMARY KEY (shoesId, [dateAdd])

CREATE TABLE Shop (
	ShopName NVARCHAR(50) CONSTRAINT PK_Shop PRIMARY KEY,
	ShopPhoneNumber varchar(10),
	ShopEmail VARCHAR(80),
	ShopAddress NVARCHAR(300),
	ShopImage VARCHAR(500),
	ShopDescription NVARCHAR(3000),
)








------------------------------------------------------------------
INSERT INTO [User](userName, userGender, userDob, userEmail, userPhoneNumber, userAddress, userAccount, userPassword, isAdmin)
	VALUES (N'Lê An Thái', 1, '2002-11-16', 'leanthai02@gmail.com', '0966132094', N'Thanh Chương, Nghệ An', 'leanthai', '123', 1),
		   (N'Nguyễn Minh Kha', 0, '2002-12-23', 'khakami@gmail.com', '1122334455', N'Phúc Thọ, Hà Nội', 'khakami', '456', 0),
		   (N'Nguyễn Minh Hưng', 1, '2002-02-23', 'hungngu@gmail.com', '6666666666', N'Thạch Thất, Hà Nội', 'hungngu', 'iii', 0),
		   (N'Trần Văn Tùng', 0, '2002-09-23', 'tungngu@gmail.com', '0000000000', N'Nga Sơn,Thanh Hóa', 'tungngu', 'ppp', 0),
		   (N'Nguyễn Minh Dũng', 1, '2002-04-08', 'dungtroc@gmail.com', '7777777777', N'Thanh Hóa', 'dungtroc', 'ddd', 0),
		   (N'Nguyễn Trọng Tài', 0, '2002-09-08', 'tai@gmail.com', '6767676767', N'Hưng Yên', 'taideptrai', 'tai', 0),
		   (N'Trần Khôi Nguyên', 1, '2002-03-08', 'nguyen@gmail.com', '2020202020', N'Hà Nội', 'nguyenaaa', 'aaan', 0)

-------------------------------------------------------------------

INSERT INTO Shoes(shoesCode, shoesOrigin, shoesDetail, shoesName, shoesColor, shoesPrice, shoesDecription, shoesImage, shoesSize, shoesStockQuantity, shoesGender, shoesDiscount, brandName, userId)
	VALUES ('Adidas_White_Male_45.5_Ultra4dfwd','Germany', 
	N'Giày Sneaker Adidas Nam Ultra4DFWD', N'Ultra4dfwd', 
	'white', 
	3500000, 
	N'ĐÔI GIÀY CHẠY BỘ NÂNG ĐỠ VÀ TÂN TIẾN, CÓ SỬ DỤNG SỢI PARLEY OCEAN PLASTIC.', 
	'image-1671442414757.webp', 
	45.5, 
	10, 
	'1', 
	'0.1', 
	'Adidas', 
	1)
	('Adidas_White_Male_45.5_Ultra4dfwd','America', 
	N'Giày Sneaker Nike Renew Run "White Red" Cw5231-100', N'Nike Renew Run "White Red"', 
	'white, red', 
	5000000, 
	N'ĐÔI GIÀY CHẠY BỘ NÂNG ĐỠ VÀ TÂN TIẾN, CÓ SỬ DỤNG SỢI PARLEY OCEAN PLASTIC.', 
	'b82e66f1-a144-4f8f-9ad1-3654543e1518.jpg', 
	39, 
	100, 
	'0', 
	'0', 
	'Nike', 
	1)
		   
---------------------------------------------------------------------------------
INSERT INTO Brand(brandDetail, brandName, image)
	VALUES (N'Nike được biết đến là một trong những tập đoàn lớn, cung cấp rất nhiều món phụ kiện, thời trang, giày dép,... phục vụ cho tập luyện, thi đấu thể thao. Thế nhưng, với những người mới làm quen với thương hiệu giày thể thao Nike thì không biết đây là thương hiệu đến từ nước nào? Nike có tên đầy đủ là Nike, Inc. Vào năm 1964, thì Bill Bowerman và Phil Knight đã cùng nhau đồng sáng lập nên thương hiệu này. Trụ sở chính của Nike được đặt tại Oregon - Mỹ. Cho đến thời điểm hiện tại, thì tại Việt Nam chưa có nhà máy sản xuất nào của Nike được đặt ở đây. Nhưng, nếu như bạn có nhu cầu mua giày Nike chính hãng, thì cũng có rất nhiều địa chỉ có cung cấp, bán giày Nike nam, nữ chính hãng để bạn an tâm lựa chọn.', 'Nike', '5657945.jpg'),
		   (N'thiết kế của adidas dành cho và đồng hành cùng các vận động viên thuộc mọi thể loại. Người sáng tạo, những người thích thay đổi trò chơi. Thách thức quy ước. Phá vỡ các quy tắc và xác định những quy tắc mới. Sau đó phá vỡ chúng một lần nữa. Chúng tôi cung cấp cho các đội và cá nhân quần áo thể thao trước trận đấu. Để luôn tập trung. Chúng tôi thiết kế trang phục thể thao giúp bạn về đích. Để giành chiến thắng trong trận đấu. Chúng tôi hỗ trợ phụ nữ với áo ngực và quần tất được sản xuất có mục đích. Hỗ trợ từ thấp đến cao. Thoải mái tối đa. Chúng tôi thiết kế, đổi mới và lặp đi lặp lại. Thử nghiệm các công nghệ mới trong hành động. Trên sân cỏ, đường đua, sân bóng, hồ bơi. Quần áo tập thể dục cổ điển truyền cảm hứng cho những trang phục dạo phố mới. Giống như NMD, Ozweego và bộ đồ thể thao Firebird của chúng tôi. Các mô hình thể thao cổ điển được đưa trở lại cuộc sống. Giống như Stan Smith. Và Siêu sao. Bây giờ được nhìn thấy trên đường phố và các sân khấu.', 'Adidas', '315352.jpg'),
		   (N'Vào tháng 5 năm 2015, Vans ra mắt Propeller: A Vans Skateboarding Video, bộ phim ngắn về ván trượt đầu tiên của Vans. Dịp trọng đại này đã đánh dấu giá trị của Vans Pro Skate trên nền thương nghiệp thời trang quốc tế. PROPELLER trở thành một trong những bộ phim trượt băng có thời lượng xem xong nhanh nhất trên iTunes. Vào mùa hè năm 2015, Vans phát hành bộ sưu tập "Young at Heart" của Disney và Vault by Vans x Takashi Murakami. Sự hợp tác này đã cho ra đời các sản phẩm yêu thích dành cho những người hâm mộ trên toàn thế giới. Nhóm tích hợp trực tuyến của Vans đã nhận được giải thưởng “VF Pinnacle 2015". Danh hiệu có uy tín được cấp hàng năm cho một nhóm trong VF trên toàn cầu đã nâng cao các mệnh lệnh chiến lược của công ty thông qua hợp tác và phát triển với phương pháp One VF. Năm 2015 đánh dấu kỷ niệm 10 năm bằng bộ sưu tập Syndicate, lễ hội dành cho Vans Pro Skate tôn vinh những đóng góp đa dạng về ý tưởng thiết kế, thái độ tận tâm đã làm nên di sản bất hủ cho nền văn hóa độc đáo về ván trượt.', 'Vans', '889590.jpg'),
		   (N'Run The Streets. Do You. Research and shop all the latest gear from the world of Fashion, Sport, and everywhere in between.', 'Puma', 'puma-logo-cover.png')
---------------------------------------------------------------------------------
INSERT INTO Shop(ShopName, ShopPhoneNumber, ShopEmail, ShopAddress, ShopImage, ShopDescription)
	VALUES (N'Tôi bán giày', '0966132094', 'leanthai02@gmail.com', N'57 Hàng Bún, Ba Đình, Hà Nội', 'shop.jpg', N'- Chúng tôi thu thập, lưu trữ và xử lý thông tin của bạn cho quá trình mua hàng và cho những thông báo sau này liên quan đến đơn hàng, và để cung cấp dịch vụ, bao gồm một số thông tin cá nhân: danh hiệu, tên, giới tính, ngày sinh, email, địa chỉ, địa chỉ giao hàng, số điện thoại, fax, chi tiết thanh toán, chi tiết thanh toán bằng thẻ hoặc chi tiết tài khoản ngân hàng.- Chúng tôi sẽ dùng thông tin quý khách đã cung cấp để xử lý đơn đặt hàng, cung cấp các dịch vụ và thông tin yêu cầu thông qua website và theo yêu cầu của bạn.- Hơn nữa, chúng tôi sẽ sử dụng các thông tin đó để quản lý tài khoản của bạn; xác minh và thực hiện giao dịch trực tuyến, nhận diện khách vào web, nghiên cứu nhân khẩu học, gửi thông tin bao gồm thông tin sản phẩm và dịch vụ. Nếu quý khách không muốn nhận bất cứ thông tin tiếp thị của chúng tôi thì có thể từ chối bất cứ lúc nào.- Chúng tôi có thể chuyển tên và địa chỉ cho bên thứ ba để họ giao hàng cho bạn (ví dụ cho bên chuyển phát nhanh hoặc nhà cung cấp).- Chi tiết đơn đặt hàng của bạn được chúng tôi lưu giữ nhưng vì lí do bảo mật nên chúng tôi không công khai trực tiếp được. Tuy nhiên, quý khách có thể tiếp cận thông tin bằng cách đăng nhập tài khoản trên web. Tại đây, quý khách sẽ thấy chi tiết đơn đặt hàng của mình, những sản phẩm đã nhận và những sản phẩm đã gửi và chi tiết email, ngân hàng và bản tin mà bạn đặt theo dõi dài hạn.- Quý khách cam kết bảo mật dữ liệu cá nhân và không được phép tiết lộ cho bên thứ ba. Chúng tôi không chịu bất kỳ trách nhiệm nào cho việc dùng sai mật khẩu nếu đây không phải lỗi của chúng tôi.- Chúng tôi có thể dùng thông tin cá nhân của bạn để nghiên cứu thị trường. mọi thông tin chi tiết sẽ được ẩn và chỉ được dùng để thống kê. Quý khách có thể từ chối không tham gia bất cứ lúc nào.')

---------------------------------------------------------------------------------
