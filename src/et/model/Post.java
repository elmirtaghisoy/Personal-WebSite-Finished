package et.model;

import java.util.Date;
import java.util.List;

public class Post extends AbstarctClass {
    private String heading;
    private String context;
    private List<MFiles> files;
    private Categorie categorie;
    private PostType postType;
    private Date createdAt;

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<MFiles> getFiles() {
        return files;
    }

    public void setFiles(List<MFiles> files) {
        this.files = files;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "heading='" + heading + '\'' +
                ", context='" + context + '\'' +
                ", files=" + files +
                ", categorie=" + categorie +
                ", postType=" + postType +
                ", createdAt=" + createdAt +
                '}';
    }
}
