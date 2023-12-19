#include <stdio.h>
#include <string.h>
#include <limits.h>
#define M(a,b) ((a<b)?(a):(b))
 
#define LL long long
#define ULL unsigned long long
#ifndef ONLINE_JUDGE
        #define siz 10
#else
        #define siz 1001
#endif
 
main()
{
int fall, i, j, k, x, y, N, K, d[siz][siz], X[4][siz];
for(scanf("%d",&fall);fall--;printf("%d\n",M(X[0][N-1]+d[N][N-1],X[1][N-1]+d[N-1][N])))
        {
        for(memset(d,!scanf("%d %d",&N,&K),sizeof(d));K--;scanf("%d %d",&x,&y),d[x+1][y+1]++);
        for(j=1; j<=N; d[N+1][j++]=0);
        for(x=k=(N+!(y=1));y<=N;--k>0?x--:y++)
        for(i=x,j=y;i<=N&&j<=N;d[i][j]=d[i][j-1]+d[i+1][j]-d[i+1][j-1]+d[i][j],++i,++j);
        for(i=1;i+1<=N;X[2][i]=X[2][i-1]+d[i][i+1],X[3][i]=X[3][i-1]+d[i+1][i],i++);
        for(X[0][1]=d[1][j=2],X[1][1]=d[2][1];j<N;X[1][j++]=x){
        for(i=!!(x=INT_MAX);i<j;x=M(x,X[1][i]+d[i][j+1]+X[3][j-1]-X[3][i]),i++);
        for(X[0][j]=x,i=!!(x=INT_MAX);i<j;x=M(x,X[0][i]+d[j+1][i]+X[2][j-1]-X[2][i]),i++);}
        }
return 0;
} 