#include<stdio.h>
#define MOD 1000000007
int findParent(int i,int parent[]) {
    if(parent[parent[i]]!=parent[i])
        parent[i]=findParent(parent[i],parent);
    return parent[i];
}
void unionNodes(int a,int b,int parent[],int size[]) {
    int parent_a=findParent(a,parent),parent_b=findParent(b,parent);
    if(parent_a==parent_b)
        return;
    if(size[parent_a]>=size[parent_b]) {
         size[parent_a]+=size[parent_b];
         parent[parent_b]=parent_a;
    }
    else {
         size[parent_b]+=size[parent_a];
         parent[parent_a]=parent_b;
    }
    return;
}

int main() {

    int N,M,i,a,b;
    scanf(" %d %d",&amp;N,&amp;M);
    int parent[100001]={0},size[100001]={0};
    for(i = 1; i <= N; i++) {
        parent[i]=i;
        size[i]=1;
    }

    for(i = 1; i <= M; i++) {
        scanf(" %d %d",&amp;a,&amp;b);
        unionNodes(a,b,parent,size);
    }

    for(i = 1; i <= N; i++)
        printf("Node %d belongs to connected component %d\n",i,findParent(i,parent));
    long long ways=1;
    int nos=0;
    for(i = 1; i <= N; i++) {
        if(findParent(i,parent)==i) {
            printf("%d leader %d size\n",i,size[i]);
            nos++;
        }

    }
    printf("Total connected components : %d",nos);

    return 0;
}
