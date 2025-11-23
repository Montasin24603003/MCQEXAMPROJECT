#include <iostream>
#include <algorithm>
using namespace std;

void cycleSort(int arr[], int n){
    for(int i = 0; i < n - 1; i++){
        int item = arr[i];
        int pos = i;

        for(int j = i + 1; j < n; j++)
            if(arr[j] < item) pos++;

        if(pos == i) continue;

        swap(item, arr[pos]);

        while(pos != i){
            pos = i;
            for(int j = i + 1; j < n; j++)
                if(arr[j] < item) pos++;

            swap(item, arr[pos]);
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

    cycleSort(arr, n);

    cout << "Cycle Sorted: ";
    for(int i = 0; i < n; i++) cout << arr[i] << " ";
}
