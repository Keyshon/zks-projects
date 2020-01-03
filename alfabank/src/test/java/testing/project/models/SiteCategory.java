package testing.project.models;

public enum SiteCategory {

    Individuals(new Category("Частным лицам", "Альфа-Банк - кредитные и дебетовые карты, кредиты наличными, автокредитование, ипотека и другие банковские услуги физическим и юридическим лицам – Альфа-Банк", "/", 0)),
    SmallBusiness(new Category("Малый бизнес и&nbsp;ИП", "Удобный банк для малого бизнеса — «Альфа-Банк»", "/sme", 1)),
    Corporate(new Category("Средний и&nbsp;крупный бизнес", "Средний и крупный бизнес — «Альфа-Банк»", "/corporate", 2)),
    Financial(new Category("Финансовым организациям", "Финансовым организациям — «Альфа-Банк»", "/financial", 3)),
    AClub(new Category("А-Клуб", "А-Клуб – надежный партнер для семей с крупным частным капиталом", "/alfaprivate", 4)),
    Invest(new Category("Инвестбанк", "Инвестиционный банк — «Альфа-Банк»", "/investment", 5));

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
