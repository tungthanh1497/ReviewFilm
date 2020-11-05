# ReviewFilm
Bài 1: Tạo ứng dụng MovieDB đơn giản sử dụng mô hình MVP hoặc MVVM kết hợp với RxJava/RxAndroid + Retrofit. Ứng dụng gồm các chức năng sau:
-        Ứng dụng sẽ có 4 tab (bottom tab), mỗi tab lần lượt hiển thị danh sách các phim theo các tiêu chí: Upcoming, Top Rated, Popular, Now Playing (các tab tương ứng sẽ lần lượt gọi các api: Get Upcoming, Get Top Rated, Get Popular, Get Now Playing)
-        Khi click vào 1 phim sẽ mở ra màn detail của phim đó màn này sẽ gồm các thông tin cơ của phim được lấy từ api: Get Deatail, ngoài ra sẽ hiển thị thêm video trailer phim lấy từ api “Get Video”, các phim liên quan lấy từ api “Get Similar Movies”, các phim khuyến khích xem lấy từ api “Get Recommendations”. (Lưu ý: tại màn Detail này nếu vận dụng thêm các operator như merge hoăc zip của RxJava để tránh phải gọi nhiều api sẽ được bonus điểm)
-        Trên cùng tạm gọi là thanh toolbar sẽ có chức tìm kiếm sử dụng api: “Search Keyword” 
Link docs api movie DB: https://developers.themoviedb.org/ . Moi người có thể tham khảo UI bên cạnh để dễ hình dung UI.
