package vn.techzen.academy_pnv_24.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.techzen.academy_pnv_24.dto.ApiResponse;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExeptionHandle {
    @ExceptionHandler(AppExeption.class)
    public ResponseEntity<?> handleAppExeption(AppExeption e) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity.status(errorCode.getStatus()).body(
                ApiResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build()
        );
    }
}
