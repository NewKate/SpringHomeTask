package vtb.spring.model;

public class Opera {

    private String label;
    private String descriptoin;
    private Integer age;
    private String duration;
    private Integer intermission;
    private String type;

    public Opera(String label) {
        this.label = label;
    }

    public Opera(String label, Integer age, String type) {
        this.label = label;
        this.age = age;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescriptoin() {
        return descriptoin;
    }

    public void setDescriptoin(String descriptoin) {
        this.descriptoin = descriptoin;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getIntermission() {
        return intermission;
    }

    public void setIntermission(Integer intermission) {
        this.intermission = intermission;
    }
}
