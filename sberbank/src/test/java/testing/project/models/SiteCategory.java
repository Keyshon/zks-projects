package testing.project.models;

public enum SiteCategory {

    Individuals(new Category("Частным клиентам", "«Сбербанк» - Частным клиентам", "/person", 0)),
    IndividualBusiness(new Category("Самозанятым", "Регистрация граждан в качестве самозанятых; Занимайтесь своим делом официально — «Сбербанк»", "/svoedelo", 1)),
    SmallBusiness(new Category("Малому бизнесу и ИП", "«Сбербанк» - Малый бизнес", "/s_m_business", 2)),
    About(new Category("О банке", "«Сбербанк» - О банке", "/about/today", 3));

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
