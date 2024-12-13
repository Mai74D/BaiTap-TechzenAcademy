package vn.techzen.academy_pnv_24.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.academy_pnv_24.model.Calculator;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> calculate(@RequestBody Calculator request) {
        Map<String, Object> response = new HashMap<>();
        try {
            double result;
            switch (request.getOperation()) {
                case "add":
                    result = request.getNumber1() + request.getNumber2();
                    break;
                case "subtract":
                    result = request.getNumber1() - request.getNumber2();
                    break;
                case "multiply":
                    result = request.getNumber1() * request.getNumber2();
                    break;
                case "divide":
                    if (request.getNumber2() == 0) {
                        throw new IllegalArgumentException("Cannot divide by zero.");
                    }
                    result = request.getNumber1() / request.getNumber2();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation: " + request.getOperation());
            }
            response.put("result", result);
            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException ex) {
            response.put("error", ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // Optional: Global exception handler for IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
