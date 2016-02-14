import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
  private double [] res;
  private double mean;
  private double sigma;
  private double clo,chi;
   public PercolationStats(int N, int T)     // perform T independent experiments on an N-by-N grid
   {
       Percolation p;
       int  nSqr = N*N;
       res = new double[T];
       int a,b,j;
       for(int i =0;i<T ;i++)
       {
           
           p = new Percolation(N);
           j=0;
           while(!p.percolates())
           {
               
               a = StdRandom.uniform(N)+1;b= StdRandom.uniform(N)+1;
               //StdOut.printf(" a=%d ,b = %d",a,b); 
               
               if(p.isOpen(a,b))
                   continue;
               p.open(a,b); j++;
               if (p.percolates())
               {
                   //c=j;
                   break;
               }
           }
           //StdOut.printf(" j=%d",j); 
           res[i] = (1.0*j)/nSqr;
       }
       mean =  StdStats.mean(res);
       sigma =  StdStats.stddev(res);
       clo = mean-(1.96*sigma/Math.sqrt(T));
       chi = mean+(1.96*sigma/Math.sqrt(T));
   }
   public double mean()                      // sample mean of percolation threshold
   {
       return mean;
   }
   public double stddev()                    // sample standard deviation of percolation threshold
   {
       return sigma;
   }
   public double confidenceLo()              // low  endpoint of 95% confidence interval
   {
       return clo;
   }
   public double confidenceHi()              // high endpoint of 95% confidence interval
   {
       return chi;
   }

   public static void main(String[] args)    // test client (described below)
   {
       PercolationStats ps = new PercolationStats(2,1000);
       StdOut.printf("\n %f %f %f %f ",ps.mean(),ps.stddev(),ps.confidenceLo(), ps.confidenceHi());
   }
}