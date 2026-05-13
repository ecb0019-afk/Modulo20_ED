package cleancode;

import java.util.List;

public class ReportService {

    public String generateReport(String title, List<Book> books, ReportFormatter formatter) {
        StringBuilder sb = new StringBuilder();
        sb.append("========================\n");
        sb.append("     ").append(title).append("      \n");
        sb.append("========================\n");
        sb.append("Date: ").append(java.time.LocalDate.now()).append("\n\n");
        
        for (Book b : books) {
            sb.append(formatter.format(b)).append("\n");
        }
        
        sb.append("\n========================\n");
        sb.append("End of Report\n");
        return sb.toString();
    }

    public interface ReportFormatter {
        String format(Book book);
    }
}
