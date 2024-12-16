package vn.techzen.academy_pnv_24.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_24.entity.Dictionary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private final List<Dictionary> dictionary = new ArrayList<>(
            Arrays.asList(
                    new Dictionary(1, "food", "Đồ ăn"),
                    new Dictionary(2, "cat", "Con mèo"),
                    new Dictionary(3, "fish", "Con cá"),
                    new Dictionary(4, "mother", "Mẹ"),
                    new Dictionary(5, "father", "Bố"),
                    new Dictionary(6, "friend", "Bạn"),
                    new Dictionary(7, "daughter", "Con gái")
            )
    );
    @GetMapping
    public ResponseEntity<?> getDictionary(@RequestParam String word) {
        // Lọc từ trong danh sách dictionary
        Optional<Dictionary> result = dictionary.stream()
                .filter(e -> e.getEnglish_word().equalsIgnoreCase(word.trim().toLowerCase()))
                .findFirst();

        // Kiểm tra nếu từ được tìm thấy
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Word not found in dictionary");
        }
    }
}
