# Kruskal-s-Algorithm
Used to find minimum spanning tree

There are total 2 greedy approach to detect minimum spanning tree

        1. Prim's Algorithm
        2. kruskal's Algorithm
        
We already seen Prim's Algorithm now let's see about Kruskal's Algorithm

4 main steps in Kruskal's Algorithm

    1. Sort edges according to increasing order of its weight
    2. Detect presence of cycle (use Union Find by Rank)
    3. if cycle absent then add weight to answer
    4. repeat step 2 and 3 till all edges are not done
    
Time Complexity

                = 0(ElogE)+0(ElogV)
                = 0(ElogE+2ElogE)  (in worst case E=V^2)
                = 0(3ElogE)
                = 0(ElogE)

