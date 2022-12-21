package agibank;

import java.util.List;

public class FilterData {

    public static List<String> filterIdSale(List<String> list) {
        return list.stream().filter(line -> {
            List<String> idContent = List.of(line.split("ç"));
            return idContent.get(0).startsWith("003");
        }).toList().stream().map(line -> {
            List<String> idContent1 = List.of(line.split("ç"));
            return idContent1.get(1);
        }).toList();
    }

    public static List<String> filterSellerName(List<String> list) {
        return list.stream().filter(line -> {
            List<String> sellerContent = List.of(line.split("ç"));
            return sellerContent.get(0).startsWith("003");
        }).toList().stream().map(line -> {
            List<String> sellerContent1 = List.of(line.split("ç"));
            return sellerContent1.get(3);
        }).toList();
    }

    public static List<Double> filterSaleValue(List<String> list) {
        return list.stream().filter(line -> {
            List<String> saleContent = List.of(line.split("ç"));
            return saleContent.get(0).startsWith("003");
        }).toList().stream().map(line -> {
            List<String> saleContent1 = List.of(line.split("ç"));
            return saleContent1.get(2);
        }).toList().stream().map(line -> {
            List<String> saleContent2 = List.of(line.split("]"));
            return saleContent2.get(0);
        }).toList().stream().map(line -> {
            List<String> saleContent3 = List.of(line.split(","));
            double total = 0.0;
            for(String value : saleContent3) {
                double partial = Double.parseDouble(value.split("-")[1]) * Double.parseDouble(value.split("-")[2]);
                total += partial;
            }
            return total;
        }).toList();
    }
}
