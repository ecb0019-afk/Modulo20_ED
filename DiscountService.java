package cleancode;

public enum DiscountService {
    STUDENT {
        @Override public double apply(double price) { return price * 0.90; }
    },
    SENIOR {
        @Override public double apply(double price) { return price * 0.85; }
    },
    NONE {
        @Override public double apply(double price) { return price; }
    };
    
    public abstract double apply(double price);

    public static double calculateFinal(double basePrice, String memberType) {
        try {
            return valueOf(memberType.toUpperCase()).apply(basePrice);
        } catch (Exception e) {
            return NONE.apply(basePrice);
        }
    }
}
