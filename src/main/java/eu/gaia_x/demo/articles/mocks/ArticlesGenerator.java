package eu.gaia_x.demo.articles.mocks;

import eu.gaia_x.demo.articles.dto.ArticleCategory;
import eu.gaia_x.demo.articles.dto.ArticleDetails;
import eu.gaia_x.demo.utils.JsonUtil;
import eu.gaia_x.demo.utils.MockData;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
@Lazy
public class ArticlesGenerator {

    private final MockData mocks;
    private final Random random;

    public ArticlesGenerator() throws FileNotFoundException {
        mocks = JsonUtil.readJsonFromFile("mocks/discovery-mocks.json", MockData.class);
        random = new Random();
    }

    public List<ArticleDetails> create(int count) {
        List<ArticleDetails.Paragraph> paragraphs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            paragraphs.add(
                    new ArticleDetails.Paragraph("Headline", getRandomValueFromList(mocks.getDescription())));
        }
        List<ArticleDetails> lst = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ArticleDetails articleInfo = new ArticleDetails()
                    .setId(i)
                    .setPreviewImagePath(getRandomValueFromList(mocks.getPreviewImg()))
                    .setLogoPath(getRandomValueFromList(mocks.getLogo()))
                    .setTitle("Article Title #" + i)
                    .setUrl("shorturl.at/adxyO")
                    .setTeaserText(getRandomValueFromList(mocks.getDescription()).substring(0, 20))
                    .setTimestamp(LocalDate.now().minusDays(random.nextInt(100)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .setCategory(i % 2 == 0 ? ArticleCategory.ARTICLE : ArticleCategory.NEWS)
                    .setParagraphs(paragraphs);
            lst.add(articleInfo);
        }
        return lst;
    }

    private <T> T getRandomValueFromList(List<T> lst) {
        return lst.get(random.nextInt(lst.size()));
    }
}
