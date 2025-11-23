#include <iostream>
#include <cstdlib>
using namespace std;

int main(){
    int n;
    cout<<"Enter size: ";
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++) cin>>arr[i];

    for(int x=0; x<5000; x++){
        for(int i=0;i<n-1;i++){
            if(arr[i] > arr[i+1]) swap(arr[i], arr[i+1]);
            if(rand()%10 == 0) swap(arr[rand()%n], arr[rand()%n]);
        }
    }
    cout<<"Cube Sorted: ";
    for(int i=0;i<n;i++) cout<<arr[i]<<" ";
}
