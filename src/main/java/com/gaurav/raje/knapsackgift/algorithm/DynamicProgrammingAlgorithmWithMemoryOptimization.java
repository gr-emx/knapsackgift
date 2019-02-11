package com.gaurav.raje.knapsackgift.algorithm;

import com.gaurav.raje.knapsackgift.algorithm.AbstractSolutionAlgorithm;
import com.gaurav.raje.knapsackgift.domain.GiftItem;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("memory")
public class DynamicProgrammingAlgorithmWithMemoryOptimization extends AbstractSolutionAlgorithm {

    protected Map<NumberIndexCostCombination,List<GiftItem>> cache = new LinkedHashMap<>();

    /**
     * @param number
     * @param index
     * @param cost
     * @return
     */
    @Override
    public List<GiftItem> findMax(int number, int index, int cost) {
        NumberIndexCostCombination currentCombination = new NumberIndexCostCombination(number,index,cost);
        if(cache.get(currentCombination)!= null){
            return cache.get(currentCombination);
        }
        //Recursive base / Escape statement
        if (isItTimeToEndRecursionAndReturnEmptyList(number, index, cost)) {
            cache.put(currentCombination, new ArrayList<>());
            return new ArrayList<>();
        }

        //else
        GiftItem current = giftItemRegistry.getItemAtIndex(index);

        List<GiftItem> withCurrentList = findMax(number - 1, index + 1, cost - current.getCost());
        int withCurrent = current.getCost() + findCost(withCurrentList);
        withCurrentList.add(current);
        List<GiftItem> withoutCurrentList = findMax(number, index + 1, cost);
        int withoutCurrent = findCost(withoutCurrentList);

        if (withCurrent > withoutCurrent) {
            cache.put(currentCombination,withCurrentList);
            return withCurrentList;
        } else {
            cache.put(currentCombination,withoutCurrentList);
            return withoutCurrentList;
        }
    }

    /**
     * Triad of Number Index Cost :-)
     */
    protected class NumberIndexCostCombination {
        int number;
        int cost;
        int index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NumberIndexCostCombination)) return false;
            NumberIndexCostCombination that = (NumberIndexCostCombination) o;
            return number == that.number &&
                    cost == that.cost &&
                    index == that.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, cost, index);
        }

        public NumberIndexCostCombination(int number, int cost, int index) {
            this.number = number;
            this.cost = cost;
            this.index = index;
        }
    }
}
