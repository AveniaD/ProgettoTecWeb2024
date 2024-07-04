package com.uniparthenope.innervision.util;

import com.uniparthenope.innervision.entity.Acquisto;
import com.uniparthenope.innervision.entity.Articolo;

import java.util.*;

public class RecommendationUtil {

    public Map<Long, List<String>> generateRecommendations(List<Acquisto> acquisti) {

        Map<Long, Set<String>> userBrands = new HashMap<>();
        for (Acquisto acquisto : acquisti) {
            userBrands.computeIfAbsent(acquisto.getUtente().getIdUtente(),
                    k -> new HashSet<>()).add(acquisto.getMarchio().getDescMarchio());
        }

        Map<Long, List<String>> recommendations = new HashMap<>();

        for (Long idUtente : userBrands.keySet()) {
            List<String> recommendedBrands = recommendBrands(idUtente, userBrands);
            recommendations.put(idUtente, recommendedBrands);
        }

        return recommendations;
    }

    public List<String> recommendBrands(Long userId, Map<Long, Set<String>> userBrands) {
        Set<String> purchasedBrands = userBrands.get(userId);
        Map<String, Integer> brandCount = new HashMap<>();

        for (Map.Entry<Long, Set<String>> entry : userBrands.entrySet()) {
            if (!entry.getKey().equals(userId)) {
                for (String brand : entry.getValue()) {
                    if (!purchasedBrands.contains(brand)) {
                        brandCount.put(brand, brandCount.getOrDefault(brand, 0) + 1);
                    }
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedBrands = new ArrayList<>(brandCount.entrySet());
        sortedBrands.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<String> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedBrands) {
            recommendations.add(entry.getKey());
        }

        return recommendations.size() > 2 ? recommendations.subList(0, 2) : recommendations;
    }

    public Map<Long, List<Articolo>> generateRecommendationsWithArticles(List<Acquisto> acquisti, List<Articolo> articoli) {
        Map<Long, List<Articolo>> userRecommendedArticles = new HashMap<>();
        Map<Long, List<String>> userBrandRecommendations = generateRecommendations(acquisti);

        for (Long userId : userBrandRecommendations.keySet()) {
            List<String> recommendedBrands = userBrandRecommendations.get(userId);
            List<Articolo> recommendedArticles = new ArrayList<>();
            List<Articolo> otherArticles = new ArrayList<>();

            for (Articolo articolo : articoli) {
                if (recommendedBrands.contains(articolo.getMarchio().getDescMarchio())) {
                    recommendedArticles.add(articolo);
                } else {
                    otherArticles.add(articolo);
                }
            }

            recommendedArticles.addAll(otherArticles);
            userRecommendedArticles.put(userId, recommendedArticles);
        }

        return userRecommendedArticles;
    }
}
