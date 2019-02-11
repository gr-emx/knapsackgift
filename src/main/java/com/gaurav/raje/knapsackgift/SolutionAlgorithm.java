package com.gaurav.raje.knapsackgift;

import com.gaurav.raje.knapsackgift.domain.GiftItem;

import java.math.BigDecimal;
import java.util.List;

public interface SolutionAlgorithm {
    List<GiftItem> findOptimalPair(int maxPrice);
    List<GiftItem> findOptimalTriad(int maxPrice);
    List<GiftItem> findOptimalN(int maxPrice, int numberOfItems);
}
