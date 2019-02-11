<H1>Introduction</H1>
<H3>Analysis</H3>
The given problem can be effectively reduced in constant time to the Knapsack Problem. 
The solution(s) that I have in this application are derived from 
the solutions to the knapsack problem. 
While, the Knapsack Problem can be an NP-Hard problem, I am using the Pseudo Polynomial time solution in this algorithm 
to compute the gift card balances at the complexity of <strong>O(nW^2)</strong> where n is the number of items we need to get while w is the number of prices.  
Since the length of the n(2 or 3) is bound in this case, 
the complexity is polynomial time. <b>The solution ends up being polynomial time
simply due to the constraint of the problem</b>
<p></p>
There  are various ways to solve this. I am doing it in 3 different ways 

1) Simple Dynamic Programming based Algorithm
2) Dynamic Programming Based Algorithm with memory optimization 
3) Linear time Greedy Approximation Algorithm (I personally would use this :-) )
The greedy algorithm has been described in this paper 
https://www.jstor.org/stable/167356?seq=1#page_scan_tab_contents (paywall)

All three of the above algorithms are as described in this paper 
https://www.researchgate.net/publication/327326005_Comparison_and_Analysis_of_Algorithms_for_the_01_Knapsack_Problem (paywall)

<h3> How to run</h3>
mvn clean package will package the files
the src/main/resources/application.properties file will guide you to add properties and configs

Arguments can either be added to that file in the format
1) arg0 = filename
2) arg1 = max price

or as mentioned in the program, can be added as environment variables

<h3>Types </h3>
As mentioned in the program, the file may be huge and in order to make it scalable
you can run it in 2 ways. If you use the profile "memory" the file algorithm optimizes for using an array (method 2 in the above analysis)

In a similar way, if you use the profile "fileBased", the data is strictly stored 
in a file system. No memory storage. This is useful for huge files which may not fit in memory.

<h3>How to run </h3>
First compile and run the tests by running
`mvn clean package`
Then run the packaged jar `java -jar ./target/knapsackgift-0.0.1-SNAPSHOT.jar src/test/resources/test.txt 2300`
 


 
