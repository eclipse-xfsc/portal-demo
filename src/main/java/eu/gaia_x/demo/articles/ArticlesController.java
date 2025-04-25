package eu.gaia_x.demo.articles;

import eu.gaia_x.demo.articles.dto.ArticleCategory;
import eu.gaia_x.demo.articles.dto.ArticleDetails;
import eu.gaia_x.demo.articles.mocks.ArticlesGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping(value = {"/demo/api/articles"})
public class ArticlesController {

    @Autowired
    private ArticlesGenerator articleService;

    @GetMapping()
    public List<ArticleDetails> getArticleDetails() {
        return articleService.create(5);
    }

    @GetMapping("/{id}")
    public ArticleDetails getArticleDetailsById(@PathVariable long id) {
        return articleService.create(1).get(0).setId(id);
    }

    @GetMapping("/filter")
    public List<ArticleDetails> filterArticlesByCategory(@RequestParam("category") String category) {
        if (!ArticleCategory.contains(category)) {
            return Collections.emptyList();
        }
        return articleService.create(10)
                .stream().filter(x -> x.getCategory() == ArticleCategory.valueOf(category.toUpperCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<ArticleDetails> searchArticlesByKeyWords(@RequestParam("key_words") String keyWords) {
        return articleService.create(5);
    }

    @PostMapping()
    public ResponseEntity<?> createArticle(@RequestBody ArticleDetails articleDetails) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeArticle(@PathVariable("id") String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted");
    }
}
