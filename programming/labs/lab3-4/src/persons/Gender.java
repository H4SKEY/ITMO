package persons;

public enum Gender {
    MALE ("Мужской"),
    FEMALE ("Женский");

    private String title;

    private Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
