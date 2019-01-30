package ben286.girl.enums;

/*
Created by Ben Wen on 2019/1/29.
*/

public enum ResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    UNDER_GRADUATE(100, "你还在上大学吧"),
    GRADUATE_STUDENT(101, "你还在上研究生吧");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
