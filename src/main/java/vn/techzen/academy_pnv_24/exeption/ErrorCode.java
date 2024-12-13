package vn.techzen.academy_pnv_24.exeption;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    STUDENT_NOT_EXIST(40401,"The student are not exist!",HttpStatus.NOT_FOUND);
//    TEACHER_NOT_EXIST(40401,"The teacher are not exist!",null);
    Integer code;
    String message;
    HttpStatus status;
}
