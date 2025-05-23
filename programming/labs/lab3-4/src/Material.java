public enum Material {
    WOOD ("Дерево"),
    GLASS ("Стекло"),
    PLASTIC ("Пластик"),
    METAL ("Металл");

    private String title;

    private Material(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
