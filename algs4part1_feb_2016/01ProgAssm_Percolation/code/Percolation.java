import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    
   private  int N,nSqr;
   private  boolean []sites ;
   private  WeightedQuickUnionUF uf;
   private  boolean percolated = false;
   public Percolation(int N)               // create N-by-N grid, with all sites blocked
   {
       
     if (N <= 0) throw new   java.lang.IllegalArgumentException("N is too small");
     this.N = N;
     nSqr = N*N;
     sites = new boolean[nSqr+2]; //:BugBug Should be +2 instead of +1
      for(int i =1;i<=N;i++)
       {
           for (int j =1 ;j<=N ;j++)
               sites[checkNReturn(i,j)] = false;
       }
     uf = new WeightedQuickUnionUF(nSqr+2); //:BugBug Should be +2 instead of +1
   }
   public void open(int i, int j)          // open site (row i, column j) if it is not open already
   {
       int d = checkNReturn(i,j);
       //int d2;
       if(sites[d] == false)
       {
           sites[d] = true;
           if(i>1)
           {
               if(isOpen(i-1,j))
               {
                   uf.union(checkNReturn(i-1,j),d);
               }
           }
           if(j>1)
           {
               if(isOpen(i,j-1))
               {
                   uf.union(checkNReturn(i,j-1),d);
               }
           }
           if (i<N)
           {
               if(isOpen(i+1,j))
               {
                   uf.union(checkNReturn(i+1,j),d);
               }
           }
               
           if(j<N)
           {
               if(isOpen(i,j+1))
               {
                   uf.union(checkNReturn(i,j+1),d);
               }
           }
           
           if(i==1)
               uf.union(0,d);
           
           if(i==N)
           {
               //uf.union(d,nSqr+1);
               /*
               if(isFull(i,j))
                      percolated = true;
                      */
           }
           
       }
   }
   public boolean isOpen(int i, int j)     // is site (row i, column j) open?
   {
     int d = checkNReturn(i,j);
       return sites[d];
   }
   public boolean isFull(int i, int j)     // is site (row i, column j) full?
   {
       int d = checkNReturn(i,j);
     return (uf.connected(0,d));
   }
   public boolean percolates()             // does the system percolate?
   {
     //return (uf.connected(0,nSqr+1));
      //return percolated;
       for(int j =1;j<=N ;j++)
       {
           if(isFull(N,j))
               return true;
       }
       return false;
   }
   
   private  int checkNReturn(int i, int j)
   {
       if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
       if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");
       
       return (i-1)*N+j;
   }

   public static void main(String[] args)  // test client (optional)
     {
       Percolation p = new Percolation(3);
       /*
       for(int i =1;i<=3;i++)
       {
           for (int j =1 ;j<=3 ;j++)
               StdOut.printf(" %d_%d : %d",i,j,p.checkNReturn(i,j));
           StdOut.printf("\n");
       }
       */
   }
}

