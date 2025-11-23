#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter size: ";
    cin >> n;

    int arr[n];
    cout << "Enter elements: ";
    for(int i = 0; i < n; i++) cin >> arr[i];

    int mx = arr[0];
    for(int i = 1; i < n; i++)
        if(arr[i] > mx) mx = arr[i];

    int count[mx + 1] = {0};

    for(int i = 0; i < n; i++) count[arr[i]]++;

    cout << "Counting Sorted: ";
    for(int i = 0; i <= mx; i++) {
        while(count[i]--) cout << i << " ";
    }

    return 0;
}
