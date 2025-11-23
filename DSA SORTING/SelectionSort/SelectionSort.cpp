#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cout << "Enter size: ";
    cin >> n;

    int arr[n];
    cout << "Enter elements: ";
    for(int i = 0; i < n; i++) {
            cin >> arr[i];
    }
     for(int i = 0; i < n-1; i++) {
        int minIndex = i;
        for(int j = i+1; j < n; j++) {
            if(arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr[i], arr[minIndex]);
    }
    cout << "Selection Sorted: ";
    for(int i = 0; i < n; i++){
            cout << arr[i] << " ";
    }
    return 0 ;
    }
