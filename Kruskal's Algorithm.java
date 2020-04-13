/*********************************************************************************************************************
     **
     **  Kruskal's Algorithm
	 **  Union Find By Rank and Path Compression Algorithm is used

     **  Input in the form of List of edges
     **  Output is minimum spanning tree
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.util.*;
class Main
{
    static int n;
    static LinkedList<Edge>list=new LinkedList();
    static ArrayList<Edge>arr=new ArrayList();

	//For Rank and path compression
    static int parent[];
    static int rank[];

	//store weight of mst
    static int ans;
    
    static class Edge
    {
        int edge1;
        int edge2;
        int weight;
        Edge(int s,int d,int w)
        {
            edge1=s;
            edge2=d;
            weight=w;
        }    
    }

    public static int findParent(int edge)
    {
        if(parent[edge]==edge)
            return edge;
            
        //path Compression     
        parent[edge]=findParent(parent[edge]);
        
        return parent[edge];
    }
    
    public static void union(int edge1,int edge2)
    {
        int p1=findParent(edge1);
        int p2=findParent(edge2);
        
        //union by rank
        if(rank[p1]>rank[p2])
            parent[p2]=p1;
        else if(rank[p1]<rank[p2])    
            parent[p1]=p2;
        else
        {
            parent[p1]=p2;
            rank[p2]++;
        }
            
    }

    public static void mst()
    {
        rank=new int[n+1];
        Arrays.fill(rank,0);
        
        parent=new int[n+1];
        for(int i=0;i<=n;i++)
            parent[i]=i;
            
        //sort according to increasing weight of edges
        Collections.sort(list,new Comparator<Edge>(){
         
            public int compare(Edge e1,Edge e2)
            {
                return e1.weight-e2.weight;
            }    
        });
        
        for(Edge e:list)
        {
           int edge1=e.edge1;
           int edge2=e.edge2;
           
           int p1=findParent(edge1);
           int p2=findParent(edge2);
           
		   //detcting cycle in graph
           if(p1==p2)
            continue;
            
           ans+=e.weight;
           arr.add(new Edge(edge1,edge2,e.weight));

		   //disjoint method 
           union(edge1,edge2);
        }
        
    }
    
	public static void main(String[] args) 
	{

		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//String[]s=br.readLine().split(" ");
		n=6; //Integer.parseInt(s[0]);
		int m=9; //Integer.parseInt(s[1]);
		    
	    int s[][]={{1, 2, 3},{1, 4, 1},{2, 3, 1},{2, 4, 3},{3, 4, 1},{3, 5, 5},{3, 6, 4},{4, 5, 6},{5, 6, 2}} ;
	    
		for(int i=0;i<m;i++)
		{
		    //s=br.readLine().split(" ");
    		int a=s[i][0]; //Integer.parseInt(s[0]);
    		int b=s[i][1]; //Integer.parseInt(s[1]);
    		int c=s[i][2]; //Integer.parseInt(s[2]);
    		list.add(new Edge(a,b,c));
		}
		
		mst();
		
		System.out.println("Weight of Minimum spanning tree : "+ ans);
		System.out.println("\nPath between vertices with weight are : \n");
		
		for(Edge node:arr)
		{
		    System.out.println("Node "+node.edge1+" to "+node.edge2+" with weight : "+node.weight);
		}

	}

}
