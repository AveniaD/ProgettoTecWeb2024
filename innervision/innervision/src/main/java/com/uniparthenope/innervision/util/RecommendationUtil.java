package com.uniparthenope.innervision.util;

import com.uniparthenope.innervision.entity.Acquisto;

import java.util.*;

public class RecommendationUtil {

    public Map<Integer, List<String>> generateRecommendations(List<Acquisto> acquisti) {
        // Preprocess the data
        Map<Integer, Set<String>> userBrands = new HashMap<>();
        for (Acquisto acquisto : acquisti) {
            userBrands.computeIfAbsent(acquisto.getIdUtente(), k -> new HashSet<>()).add(acquisto.getMarchio());
        }

        Map<Integer, List<String>> recommendations = new HashMap<>();

        // Generate recommendations for each user
        for (Integer idUtente : userBrands.keySet()) {
            List<String> recommendedBrands = recommendBrands(idUtente, userBrands);
            recommendations.put(idUtente, recommendedBrands);
        }

        return recommendations;
    }

    public List<String> recommendBrands(Integer userId, Map<Integer, Set<String>> userBrands) {
        Set<String> purchasedBrands = userBrands.get(userId);
        Map<String, Integer> brandCount = new HashMap<>();

        for (Map.Entry<Integer, Set<String>> entry : userBrands.entrySet()) {
            if (!entry.getKey().equals(userId)) {
                for (String brand : entry.getValue()) {
                    if (!purchasedBrands.contains(brand)) {
                        brandCount.put(brand, brandCount.getOrDefault(brand, 0) + 1);
                    }
                }
            }
        }

        // Sort the brands by count in descending order and return the top recommendations
        List<Map.Entry<String, Integer>> sortedBrands = new ArrayList<>(brandCount.entrySet());
        sortedBrands.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<String> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedBrands) {
            recommendations.add(entry.getKey());
        }

        return recommendations.size() > 2 ? recommendations.subList(0, 2) : recommendations;
    }
}
