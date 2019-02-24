package exception.common.exceptions;

import lombok.Data;

/**
 * Created by sunlele
 * Date 2019/2/24 16:58
 * Description  自定义异常
 */

@Data
public class CustomException extends RuntimeException{

    /**
     *
     */
    private int code;

    private String message;

    public CustomException() {
        super();
    }

    public CustomException(int code, String message) {
        super(message);
        this.message = message;
    }


}
