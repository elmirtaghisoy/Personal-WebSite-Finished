package et.model;

public class PostType extends AbstarctClass{
    private String postTypeName;

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    @Override
    public String toString() {
        return "PostType{" +
                "postTypeName='" + postTypeName + '\'' +
                '}';
    }
}
