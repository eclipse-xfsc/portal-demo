package eu.gaia_x.demo.articles.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Article details
 */
public class ArticleDetails {

    private long id;
    private String previewImagePath;
    private String logoPath;
    private String title;
    private String url;
    private String teaserText;
    private List<Paragraph> paragraphs;
    private String timestamp;
    private ArticleCategory category;

    public ArticleDetails(
            long id,
            String previewImagePath,
            String logoPath,
            String title,
            String url,
            String teaserText,
            List<Paragraph> paragraphs,
            String timestamp,
            ArticleCategory category) {
        this.id = id;
        this.previewImagePath = previewImagePath;
        this.logoPath = logoPath;
        this.title = title;
        this.url = url;
        this.teaserText = teaserText;
        this.paragraphs = paragraphs;
        this.timestamp = timestamp;
        this.category = category;
    }

    public ArticleDetails() {
        //
    }

    public long getId() {
        return id;
    }

    public ArticleDetails setId(long id) {
        this.id = id;
        return this;
    }

    public String getPreviewImagePath() {
        return previewImagePath;
    }

    public ArticleDetails setPreviewImagePath(String previewImagePath) {
        this.previewImagePath = previewImagePath;
        return this;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public ArticleDetails setLogoPath(String logoPath) {
        this.logoPath = logoPath;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticleDetails setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ArticleDetails setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTeaserText() {
        return teaserText;
    }

    public ArticleDetails setTeaserText(String teaserText) {
        this.teaserText = teaserText;
        return this;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public ArticleDetails setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public ArticleDetails setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ArticleCategory getCategory() {
        return category;
    }

    public ArticleDetails setCategory(ArticleCategory category) {
        this.category = category;
        return this;
    }

    public ArticleDetails addParagraph(Paragraph paragraph) {
        if (paragraphs == null) {
            paragraphs = new ArrayList<>();
        }
        paragraphs.add(paragraph);
        return this;
    }

    /**
     * Paragraphs for article
     */
    public static class Paragraph {
        private String headline;
        private String paragraphs;

        public Paragraph(String headline, String paragraphs) {
            this.headline = headline;
            this.paragraphs = paragraphs;
        }

        public String getHeadline() {
            return headline;
        }

        public Paragraph setHeadline(String headline) {
            this.headline = headline;
            return this;
        }

        public String getParagraphs() {
            return paragraphs;
        }

        public Paragraph setParagraphs(String paragraphs) {
            this.paragraphs = paragraphs;
            return this;
        }
    }
}
