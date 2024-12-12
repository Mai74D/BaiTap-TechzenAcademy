package vn.techzen.academy_pnv_24.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_24.model.Dictionary;
import vn.techzen.academy_pnv_24.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/dictionary")
public class DictionaryController {

    List<Dictionary> dictionary = new ArrayList<>(
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
    public ResponseEntity<List<Dictionary>> getAllDictionary() {
        return ResponseEntity.ok(dictionary);
    }

//    @GetMapping("/{word}")
//    public ResponseEntity<String> searchDictionary(@RequestParam String english_word) {
//        for (Dictionary Dictionary : dictionary) {
//            if (Dictionary.getEnglish_word().) {
//                return ResponseEntity.ok(Dictionary.getTranslation());
//            }
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
}
