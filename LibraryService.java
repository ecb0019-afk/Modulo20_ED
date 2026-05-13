package cleancode;

public class LibraryService {
    
    public void processOrder(Order order) {
        if (!isValid(order)) return;
        
        applyDiscounts(order);
        finalizePayment(order);
    }

    private boolean isValid(Order order) {
        if (order == null || order.getBooks().isEmpty() || order.getMember() == null) {
            System.out.println("Invalid order structure.");
            return false;
        }
        return true;
    }

    private void applyDiscounts(Order order) {
        double total = 0;
        for (Book book : order.getBooks()) {
            total += book.calculateCurrentValue();
        }
        
        double finalTotal = DiscountService.calculateFinal(total, order.getMember().getMemberType());
        order.setFinalTotal(finalTotal);
    }

    private void finalizePayment(Order order) {
        if (order.getMember().processPurchase(order.getFinalTotal())) {
            order.setStatus("COMPLETED");
        } else {
            order.setStatus("FAILED_INSUFFICIENT_FUNDS");
        }
    }
}
