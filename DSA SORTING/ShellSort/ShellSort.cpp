#include <iostream>
using namespace std;

void shellSort(int arr[], int n){
    for(int gap = n/2; gap > 0; gap /= 2){
        for(int i = gap; i < n; i++){
            int temp = arr[i];
            int j = i;

            while(j >= gap && arr[j-gap] > temp){
                arr[j] = arr[j-gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }
}

int main(){
    int n;
    cout << "Enter size: ";
    cin >> n;

    int arr[n];
    cout << "Enter elements: ";
    for(int i = 0; i < n; i++) cin >> arr[i];

    shellSort(arr, n);

    cout << "Shell Sorted: ";
    for(int i = 0; i < n; i++) cout << arr[i] << " ";
}
