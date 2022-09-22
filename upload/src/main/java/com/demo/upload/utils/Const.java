package com.demo.upload.utils;

public class Const {
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
