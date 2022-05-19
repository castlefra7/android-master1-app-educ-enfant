package itu.master1.projetandroid.menu.model;

public class Content {
    private String title;
    private String description;
    private String[] images;
    private String[] videos;

    public static final Content[] contents = {
            new Content("science de la vie", "La science nous permet de voir"),
            new Content("histoire", "l'histoire est formidable"),
            new Content("mathématiques", "la mathématique est une science exacte"),
            new Content("Géographie", "la terre est ronde"),
            new Content("science de la vie", "La science nous permet de voir"),
            new Content("histoire", "l'histoire est formidable"),
            new Content("mathématiques", "la mathématique est une science exacte"),
            new Content("Géographie", "la terre est ronde"),
            new Content("science de la vie", "La science nous permet de voir"),
            new Content("histoire", "l'histoire est formidable"),
            new Content("mathématiques", "la mathématique est une science exacte"),
            new Content("Géographie", "la terre est ronde"),
            new Content("science de la vie", "La science nous permet de voir"),
            new Content("histoire", "l'histoire est formidable"),
            new Content("mathématiques", "la mathématique est une science exacte"),
            new Content("Géographie", "la terre est ronde"),
    };

    private Content(String _title, String _description) {
        this.title = _title;
        this.description = _description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }
}
