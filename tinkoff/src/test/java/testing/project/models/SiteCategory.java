package testing.project.models;

public enum SiteCategory {
    Individuals(new Category("Банк", "Тинькофф — Кредитные и дебетовые карты, кредиты для бизнеса и физических лиц", "/", 0)),
    Business(new Category("Бизнес", "Банк для малого и среднего бизнеса", "/business", 1)),
    Invest(new Category("Инвестиции", "Тинькофф Инвестиции — простой способ быть инвестором", "/invest", 2)),
    Insurance(new Category("Страхование", "Страхование онлайн", "/insurance", 3)),
    Mobile(new Category("Мобайл", "Попробуйте бесплатно", "/mobile-operator", 4)),
    Flights(new Category("Путешествия", "Путешествуйте легко и выгодно", "/travel/flights", 5)),
    Entertainment(new Category("Развлечения", "Кино в городе Москва: покупка билетов онлайн", "/entertainment/movies", 6));

    private SiteCategory(Category intr) { this.obj = intr; }
    private Category obj;

    public String getName() { return obj.name; }
    public String getPageTitle() { return obj.pageTitle; }
    public String getRelativeUrl() { return obj.relativeUrl; }
    public int getOrder() { return obj.order; }
}

class Category { // to store multiple values
    public String name;
    public String pageTitle;
    public String relativeUrl;
    public int order;
    Category(String name, String pageTitle, String relativeUrl, int order) {
        this.name = name;
        this.pageTitle = pageTitle;
        this.relativeUrl = relativeUrl;
        this.order = order;
    }
}
