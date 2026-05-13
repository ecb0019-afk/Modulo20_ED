package before;

public class Member {
    private String name;
    private String memberType; // "student", "senior", "regular"
    private double internalBalance;
    private int loyaltyPoints;

    public Member(String name, String memberType, double internalBalance, int loyaltyPoints) {
        this.name = name;
        this.memberType = memberType;
        this.internalBalance = internalBalance;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMemberType() { return memberType; }
    public void setMemberType(String memberType) { this.memberType = memberType; }

    public double getInternalBalance() { return internalBalance; }
    public void setInternalBalance(double internalBalance) { this.internalBalance = internalBalance; }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }
}
