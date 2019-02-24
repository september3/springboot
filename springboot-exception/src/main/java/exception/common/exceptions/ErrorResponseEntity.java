package exception.common.exceptions;

import lombok.Data;

/**
 * Created by sunlele
 * Date 2019/2/24 17:24
 * Description
 */

@Data
public class ErrorResponseEntity {

    private int code ;

    private String message;

    public ErrorResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
