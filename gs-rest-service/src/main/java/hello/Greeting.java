package hello;

public class Greeting {

    private final long id;
    private final String content;
    private final String age;
    private final String weight;

    public Greeting(long id, String content, String age, String weight) {
        this.id = id;
        this.content = content;
        this.age = age;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }
}
