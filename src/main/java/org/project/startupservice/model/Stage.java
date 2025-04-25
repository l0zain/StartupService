package org.project.startupservice.model;

public enum Stage {
    IDEA_VALIDATION("Проверка идеи"),
    PROTOTYPE_CREATION("Создание прототипа"),
    TEAM_FORMATION("Формирование команды"),
    MVP_TESTING("Тестирование MVP"),
    BUSINESS_MODEL_DEVELOPMENT("Разработка бизнес-модели"),
    PRODUCT_SCALING("Масштабирование продукта"),
    SALES_SYSTEM_BUILDING("Построение системы продаж"),
    TEAM_EXPANSION("Расширение команды"),
    FUNDRAISING("Привлечение инвестиций"),
    MARKET_EXPANSION("Расширение рынка");

    private final String description;

    Stage(String description) {
        this.description = description;
    }
}
