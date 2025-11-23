#include <iostream>
using namespace std;

struct Node {
    int v;
    Node *l, *r;
    Node(int v):v(v),l(NULL),r(NULL){}
};
int main(){
    int n;
    cout<<"Enter size: ";
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++) cin>>arr[i];

    Node* root = new Node(arr[0]);

    for(int i=1;i<n;i++){
        Node* cur = root;
        while(true){
            if(arr[i] < cur->v){
                if(cur->l) cur = cur->l;
                else {cur->l = new Node(arr[i]); break;}
            } else {
                if(cur->r) cur = cur->r;
                else {cur->r = new Node(arr[i]); break;}
            }
        }
    }
    Node* st[1000];
    int top = 0;
    Node* cur = root;

    cout<<"Tree Sorted: ";
    while(cur || top){
        while(cur){
            st[top++] = cur;
            cur = cur->l;
        }
        cur = st[--top];
        cout<<cur->v<<" ";
        cur = cur->r;
    }
}
