package com.gaurav.raje.knapsackgift.algorithm;

import com.gaurav.raje.knapsackgift.algorithm.AbstractSolutionAlgorithm;
import com.gaurav.raje.knapsackgift.domain.GiftItem;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("!memory")
public class SimpleDynamicProgrammingAlgorithm extends AbstractSolutionAlgorithm {


    public List<GiftItem> findMax(int number, int index, int cost) {

        //Recursive base / Escape statement
        if (isItTimeToEndRecursionAndReturnEmptyList(number, index, cost)) {
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
            return withCurrentList;
        } else {
            return withoutCurrentList;
        }

    }
}
