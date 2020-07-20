package com.da.common;

public interface Constant {
    String GROUP_ROLE = "ROLE";

    String MESSAGE = "message";
    String USER_NOT_ACTIVE = "user_not_active";
    String USER_LOCKED = "user_locked";
    String USER_NOT_FOUND = "user_not_found";
    String USER_MISSING_ROLE = "user_missing_role";
    String USER_TOKEN_INVALID = "user_token_invalid";


    String DIR_LINK_FILE = "http://localhost:1234/api/document/media/image/";
    String FILE_NAME_PATTERN = "{0}_{1}.{2}";


    Integer LIKE = 1;
    Integer DISLIKE = 2;
    Integer COMMENT = 3;
    Integer REPCOMMENT = 4;
    Integer ACCEPTBV = 5;
    Integer DECIDEBV = 6;
    Integer LIKE_COMMENT = 7;
    Integer DISLIKE_COMMENT = 8;
    Integer LIKE_RECM = 9;
    Integer DISLIKE_REPCM= 10;
    Integer POINTS= 11;

    String MA_THE_ADMIN = "111";
    String MA_THE_TEACHER = "131";
    String MA_THE_STUDENT = "151";
    String MA_THE_CUSTOMER = "202";

    String CHECKIN = "CHECKIN";

    String ACCEPT = "BÀI VIÊT CỦA BẠN ĐÃ ĐƯỢC DUYỆT!";

    String DECIDE = "BÀI VIÊT CỦA BẠN ĐÃ BỊ TỪ CHỐI!!";


    String LIKECM = "ĐÃ THÍCH BÌNH LUẬN CỦA ";

    String DISLIKECM ="ĐẪ KHÔNG THÍCH BÌNH LUẬN CỦA";

    String POINT_SS = "CẬP NHẬT ĐIỂM";
}
