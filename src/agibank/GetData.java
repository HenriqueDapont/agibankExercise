package agibank;

import java.util.*;

public class GetData {

    public static String countClients(List<String> list) {
        long count = list.stream().filter(line -> {
            List<String> content = List.of(line.split("ç"));
            return content.get(0).equals("001");
        }).count();

        return "Total de clientes: " + count;
    }

    public static String countSellers(List<String> list) {
        long count = list.stream().filter(line -> {
            List<String> content = List.of(line.split("ç"));
            return content.get(0).equals("002");
        }).count();

        return "Total de vendedores: " + count;
    }

    public static String findMoreExpensiveSale(List<String> list) {
        List<String> idList = FilterData.filterIdSale(list);
        List<Double> saleValueList = FilterData.filterSaleValue(list);

        Map<Double, String> mapList = new HashMap<>();
        for(int i = 0; i < idList.size(); i++) {
           mapList.put(saleValueList.get(i), idList.get(i));
        }

        return "ID da venda mais cara: " + mapList.getOrDefault(Collections.max(saleValueList), idList.toString());
    }

    public static String findWorstSeller(List<String> list) {
        List<Double> saleValueList = FilterData.filterSaleValue(list);
        List<String> sellerNameList = FilterData.filterSellerName(list);

        Map<Double, String> mapList = new HashMap<>();
        for(int i = 0; i < saleValueList.size(); i++) {
            mapList.put(saleValueList.get(i), sellerNameList.get(i));
        }
        return "Pior vendedor: " + mapList.getOrDefault(Collections.min(saleValueList), sellerNameList.toString());
    }
}
