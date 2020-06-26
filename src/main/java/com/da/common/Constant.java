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

    String MA_THE_ADMIN = "111";
    String MA_THE_TEACHER = "131";
    String MA_THE_STUDENT = "151";
    String MA_THE_CUSTOMER = "202";
}
