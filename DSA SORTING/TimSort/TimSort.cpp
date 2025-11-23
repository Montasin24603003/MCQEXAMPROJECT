#include <iostream>
using namespace std;

int main(){
    int n;
    cout<<"Enter size: ";
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++) cin>>arr[i];
    int RUN = 32;
    for(int s=0; s<n; s+=RUN){
        for(int i=s+1; i<min(s+RUN,n); i++){
            int j=i;
            while(j>s && arr[j] < arr[j-1]){
                swap(arr[j], arr[j-1]);
                j--;
            }
        }
    }
    for(int size=RUN; size<n; size*=2){
        for(int l=0; l<n; l+=2*size){
            int m = min(l+size, n);
            int r = min(l+2*size, n);

            int tmp[10000], k=0, i=l, j=m;

            while(i<m && j<r)
                tmp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
            while(i<m) tmp[k++] = arr[i++];
            while(j<r) tmp[k++] = arr[j++];

            for(int x=0; x<k; x++) arr[l+x] = tmp[x];
        }
    }
    cout<<"Tim Sorted: ";
    for(int i=0;i<n;i++) cout<<arr[i]<<" ";
}
