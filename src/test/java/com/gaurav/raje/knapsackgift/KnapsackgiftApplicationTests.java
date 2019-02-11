package com.gaurav.raje.knapsackgift;

import com.gaurav.raje.knapsackgift.domain.GiftItem;
import com.gaurav.raje.knapsackgift.registry.GiftItemRegistry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


public abstract class KnapsackgiftApplicationTests {
	@Autowired
	SolutionAlgorithm algorithm;

	@Test
	public void contextLoads() {
		List<GiftItem> itemList = algorithm.findOptimalPair(2300);
		Assert.assertEquals(itemList.get(0).getCost(),1400);
		Assert.assertEquals(itemList.get(1).getCost(),700);
	}

}

