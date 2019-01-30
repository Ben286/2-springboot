package ben286.girl.exception;

/*
Created by Ben Wen on 2019/1/29.
*/

import ben286.girl.enums.ResultEnum;

public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
