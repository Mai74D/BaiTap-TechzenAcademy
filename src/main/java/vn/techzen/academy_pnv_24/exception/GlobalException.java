package vn.techzen.academy_pnv_24.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.techzen.academy_pnv_24.dto.ApiResponse;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler (AppException.class)
    public ResponseEntity<?> appException(final AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.status(errorCode.getStatus()).body(
                ApiResponse.builder().code(errorCode.getCode()).message(errorCode.getMessage()).build()
        );
    }
}