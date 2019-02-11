package com.gaurav.raje.knapsackgift.algorithm;

import com.gaurav.raje.knapsackgift.SolutionAlgorithm;
import com.gaurav.raje.knapsackgift.domain.GiftItem;
import com.gaurav.raje.knapsackgift.registry.GiftItemRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSolutionAlgorithm implements SolutionAlgorithm {

    @Autowired
    protected GiftItemRegistry giftItemRegistry;

    @Override
    public List<GiftItem> findOptimalPair(int maxPrice) {
        return findOptimalN(maxPrice, 2);
    }

    @Override
    public List<GiftItem> findOptimalTriad(int maxPrice) {
        return findOptimalN(maxPrice, 3);
    }

    @Override
    public List<GiftItem> findOptimalN(int maxPrice, int numberOfItems) {


        List<GiftItem> giftItems = findMax(numberOfItems, 0, maxPrice);
        if (giftItems.size() < numberOfItems) {
            giftItems = new ArrayList<>();
            giftItems.add(GiftItem.NO_ITEM_FOUND);
        }
        return giftItems;
    }

    public abstract List<GiftItem> findMax(int number, int index, int cost);


    public static int findCost(List<GiftItem> list) {
        int cnt = 0;
        for (GiftItem i : list) {
            cnt += i.getCost();
        }
        return cnt;
    }

    /**
     * Self explanatory helper method
     *
     * @param number
     * @param index
     * @param cost
     * @return
     */
    protected boolean isItTimeToEndRecursionAndReturnEmptyList(int number, int index, int cost) {
        //If you need 0 items, return an empty list
        if (number == 0) {
            return true;
        }
        // If you have gone over all possible items in the registry without returning a single item
        // you can just return an empty list
        if (index >= giftItemRegistry.getSize()) {
            return true;
        }
        GiftItem current = giftItemRegistry.getItemAtIndex(index);
        // If the price of the item at current index is higher than the remaining value on the giftcard
        //return nothing since every item hence forth will be costlier
        if (current.getCost() > cost) {
            return true;
        }
        return false;

    }
}
