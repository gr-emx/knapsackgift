package com.gaurav.raje.knapsackgift;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("spring.profiles.active=memory")
@TestPropertySource("classpath:test.properties")
public class TestMemoryOptimized extends KnapsackgiftApplicationTests {
}
