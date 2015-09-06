import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.TreeMap;

// the program needs:
// poi-3.12-20150511.jar
// (http://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-3.12-20150511.zip)
// poi-ooxml-3.12.jar
// (http://mvnrepository.com/artifact/org.apache.poi/poi-ooxml/3.12)
// poi-ooxml-schemas-3.12.jar
// (http://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-schemas/3.12-beta1)
// xmlbeans-2.6.0.jar
// (http://www.java2s.com/Code/Jar/x/Downloadxmlbeans260jar.htm)
// all too large to be submitted with the homework folder

public class _11Excel {

    private static String format = "%18s Total -> %8.2f";

    public static void main(String[] args) throws
                                           IOException {
        Locale.setDefault(Locale.ROOT);
        FileInputStream excel = null;
        try {
            excel = new FileInputStream("5. Incomes-Report.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excel);
            XSSFSheet sheet = workbook.getSheetAt(0);
            //XSSFSheet sheet = workbook.getSheet("Incomes");- if the sheet is named Incomes

            TreeMap<String, Double> officesIncomes = new TreeMap<String, Double>();
            double totalIncome = 0;
            int rowIndex = 1; // we skip row 0, where the headings are
            XSSFRow currentRow;

            while ((currentRow = sheet.getRow(rowIndex)) != null) {
                XSSFCell cellName = currentRow.getCell(0);
                String officeName = cellName.getStringCellValue();

                XSSFCell cellIncome = currentRow.getCell(5);
                double officeIncome = cellIncome.getNumericCellValue();

                totalIncome += officeIncome;

                if (officesIncomes.containsKey(officeName)) {
                    officeIncome += officesIncomes.get(officeName);
                }
                officesIncomes.put(officeName, officeIncome);
                rowIndex++;
            }

            printAllOfficesIncomes(officesIncomes);
            System.out.printf(format, "Grand", totalIncome);
        }
        finally {
            if (excel != null) {
                excel.close();
            }
        }
    }

    private static void printAllOfficesIncomes(TreeMap<String, Double> officesIncomes) {
        for (String office : officesIncomes.keySet()) {
            double income = officesIncomes.get(office);
            System.out.printf(format, office, income).println();
        }
    }
}
