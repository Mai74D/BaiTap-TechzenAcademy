package vn.techzen.academy_pnv_24.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    STUDENT_NOT_EXIST(40401,"The student are not exist!",HttpStatus.NOT_FOUND),
    TEACHER_NOT_EXIST(40401,"The teacher are not exist!",HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_FOUND(404, "Employee not found",HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(400, "Bad Request",HttpStatus.BAD_REQUEST),;
    Integer code;
    String message;
    HttpStatus status;
}
