#include<iostream>
#include<vector>
using namespace std;
struct Node{
    public:
    int data;
    Node* next;

    public:
    Node(int data,Node* next){
        this->data = data;
        this->next = next;
    }
};
Node* convertArr2LL(vector<int>&arr){
    Node* head=new Node(arr[0], nullptr); //head node
    Node* mover=head; //to traverse the linked list
    for(int i=1;i<arr.size();i++){ //from 1 to n-1
        Node* temp=new Node(arr[i], nullptr); 
        mover->next=temp;
        mover=temp;

    }
    return head;
}
int main(){
    vector<int>arr={1,2,3,4,5};
    Node* y=new Node(arr[0],nullptr);
    // cout<<y->data;

    Node* head=convertArr2LL(arr);
    //cout<<head->data<<" ";
    Node* temp=head;
    while(temp){
        cout<<temp->data<<" ";
        temp=temp->next;
    }
    return 0;
}