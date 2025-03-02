package fin.org.trst.db.enums;

import lombok.Getter;

@Getter
public enum AccountType {

    BASE("Base account", 1000.0),
    PREMIUM("Premium account", 5000.0);

    private final String description;
    private final double maxLimit;

    AccountType(String description, double maxLimit) {
        this.description = description;
        this.maxLimit = maxLimit;
    }

}