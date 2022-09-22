package com.demo.authservice.utils;



public class Const {

    public static final String ACCOUNT_INFO_PREFIX = "ACC_INFOR_";
    public static final int ROLE_OTHER = 7;


    public static class UserStatus {
        public static final int ACTIVE = 1;
        public static final int DEACTIVE = 0;
    }

    public static class UserMethod {
        public static final int REGISTER = 1;
        public static final int SAVE = 2;
        public static final int FORGET_PASSWORD = 3;
        public static final int RE_SAVE = 4;
    }

    //    HttpStatus
    public enum DataRes {

        SUCCESS(0, "Thành công"),
        INVALID_DATA(1, "Dữ liệu truyền vào rỗng"),
        OBJECT_NOT_FOUND(2, "Không tồn tại đối tượng theo điều kiện"),
        INTERNAL_SERVER_ERROR(3, "Lỗi hệ thống {}"),
        DUPLICATE_DATA(4,"dữ liệu đã tồn tại");

        DataRes(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        private int code;
        private String message;

    }
}
