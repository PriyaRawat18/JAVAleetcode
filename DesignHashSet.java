/*Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
 */
 




class MyHashSet {

    ArrayList<ArrayList<Integer>> set;
    int bucketSize ;
    int size;
    
    public MyHashSet() {
        bucketSize =  10;
        size = 0;
        set  =  new ArrayList<>();
        for(int i=0;i<bucketSize;i++){
            set.add(null);
        }                
    }
    
    private int getBucketIndex(int key){
        return key % bucketSize;
    }
    
    private double loadFactor(){
        return 1.0*size/bucketSize;
    }
    
    private void rehash(){ // rehash is  expensive       
        
        ArrayList<ArrayList<Integer>> temp =  set;
        set  =  new ArrayList<>();
        bucketSize*=1.5;
        for(int i=0;i<bucketSize;i++){
            set.add(null);
        }
        
        size = 0;
        
        
        for(int i=0;i<temp.size();i++ ){
            ArrayList<Integer> li =  temp.get(i);
            if(li!=null){
                for(int ele :li){
                    add(ele);
                }
            }
        }
    }
    public void add(int key) {
        double load  =  loadFactor();
        if(load > 0.7){
            rehash();
        }
        
        int index =  getBucketIndex(key);
        ArrayList<Integer> li =  set.get(index);
        if(li==null){
            li =  new ArrayList<>();
            set.set( index, li  );                        
        }
        for(int i=0;i<li.size();i++ ){
            if(li.get(i)==key ){
                return;
           }
        }
        
        size++;
        li.add(key);    
    }
    
    public void remove(int key) {
        int index =  getBucketIndex(key);
        ArrayList<Integer> li =  set.get(index);
        if(li==null) return;
        
        int idx = -1;
        for(int i=0;i<li.size();i++ ){
            if(li.get(i)==key ){
                idx =  i;
                break;
            }
        }
        if(idx==-1) return;
        
        
        int lastIndex =  li.size()-1;
        
        li.set(idx , li.get(lastIndex) ); // O(1) removal
        li.remove(lastIndex); 
        size--;
    }
    
    public boolean contains(int key) {
        
        int index =  getBucketIndex(key);                
        ArrayList<Integer> li =  set.get(index);                        
        if(li==null){            
            return false;
        }
        
        for(int i=0;i<li.size();i++ ){            
            if(li.get(i)==key ){
                return true;
            }
        }
        
         return false;        
    }
}
