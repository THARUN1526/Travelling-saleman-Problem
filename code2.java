class main{
	static java.io.BufferedReader scan = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
	//static java.io.BufferedReader scan;
	static java.io.BufferedWriter write = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
	   
	static public int nextInteger() throws java.io.IOException
	   {
	       int b=0,temp = scan.read();
	       while(temp != -1 && (temp < 48 || temp > 57))   temp = scan.read(); 
	       while(temp > 47 && temp < 58)
	       {
	           temp -= 48;
	           b *= 10;
	           b += temp;
	           temp = scan.read();
	       }
	       return b;
	   }
	
		static int min(int a,int b){
			return a<b ? a : b;
		}
	
	
	    public static void main (String[] args) throws java.lang.Exception
	    {  
	  //  scan = new java.io.BufferedReader(new java.io.FileReader("C:\\blueJ-salesman.txt")); 
	   // long start = java.lang.System.nanoTime();
	    int t,n,k;
	    int[][] d = new int[1010][1010];
	    int[] d2 = new int[1010];
	    int[] d1 = new int[1010];
	    int[] sum1 = new int[1010];
	    int[] sum2 = new int[1010];
	    
	    int x,y,b,c;
		int i,j;//,k
		t = nextInteger();
		while(t-->0){
			//d = new int[1010][1010];
			//pobieranie ilosci miast i bramek
			n=nextInteger();
			k=nextInteger();
			//zerowanie bramek
			for(int ii =0,jj=0; ii < n+10; ii++,jj=0){
				while(jj<n+10){
					d[ii][jj] = 0;
					jj++;
				}				
			}
			//for(int[] dd: d)
				//java.util.Arrays.fill(dd,0);
			//wczytywanie bramek
			while(k-->0)
			{
				x=nextInteger();
				y=nextInteger();
				d[x+1][y+1]++;
			}
			
			for(x=n,k=n,y=1; y<=n;)
			{
				i=x;
				j=y;
				while(i<=n){
					if(j<=n) d[i][j]+=d[i][j-1]+d[i+1][j]-d[i+1][j-1];
					++i;
					++j;
				}
				//for(i=x,j=y;i<=n&&j<=n;++i,++j)
				//	d[i][j]=d[i][j-1]+d[i+1][j]-d[i+1][j-1]+d[i][j];
				
				if(--k>0)
					x--;
				else
					y++;
				
			}
			
			/*for(i=1;i+1<=n;i++)
			{
				sum1[i]=sum1[i-1]+d[i][i+1];
				sum2[i]=sum2[i-1]+d[i+1][i];
			}*/
			
			i = 1;
			while(++i<n){
				sum1[i-1]=sum1[i-2]+d[i-1][i];
				sum2[i-1]=sum2[i-2]+d[i][i-1];
			}
			
			d1[1]=d[1][2];
			d2[1]=d[2][1];
			for(j=2;j<n;j++)
			{
				d2[j]=2000000000;d1[j] = 2000000000;
				for(i=1;i<j;i++){
					b = d2[i]+d[i][j+1]+sum2[j-1]-sum2[i];
					c = d1[i]+d[j+1][i]+sum1[j-1]-sum1[i];
					d1[j] = d1[j]<b?d1[j]:b;
					d2[j] = d2[j]<c?d2[j]:c;
				}
			}
			b = d1[n-1]+d[n][n-1];
			c = d2[n-1]+d[n-1][n];
			write.write("" + (b<c?b:c) );
			if(t>0) write.write("\n");
		}
		
	    
		//write.write("\nWczytywanie trwało: " + ((java.lang.System.nanoTime() - start)/1000000));
		write.flush();
	    }
}



