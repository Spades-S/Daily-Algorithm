### 380 Insert Delete GetRandom O(1)

#### Problem
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

#### Example
```
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
```

#### Solution
【分析】对于插入和删除可以利用HashMap来达到O(1)时间复杂度要求，如果只用HashMap是无法在常数时间复杂度内拿到随即元素值的。我们知道数组是可以在常数时间复杂度内获取随即元素值，但是这里数组长度是未知的，需要使用ArrayList。同时使用HashMap和ArrayList，在实现Insert时，没什么特别，各自调用自己Insert方法即可。在实现Remove时，需要注意，HashMap的remove操作是能够保证常数时间复杂度的，ArrayList只有当要删除的是最后一位的时候才能够保证是常数时间复杂度，如果待删除的元素在ArrayList中不是最后一位怎么办，将其交换到最后一位。在交换时，我们需要知道待删除元素本来的位置在哪儿，所以需要通过HashMap去存储元素在ArrayList中的索引位置。
比如：
``` 
HashMap:    <1， 0>   <2, 1>  <3, 2>  <4, 3>   value-indexInArrayList
ArrayList:  1         2       3       4
toDelete:   2
待删除元素是2， 通过HashMap可以知道元素2在ArrayList中的索引是1，并不是3，此时我们需要将其交换到最后一位，ArrayList.set(1, ArrayList.get(3))，经过这一操作后，ArrayList和HashMap变为：
HashMap:    <1， 0>   <2, 1>  <3, 2>  <4, 3>
ArrayList:  1         4       3       4(待删除)
由于ArrayList中最后一位是将要删除的，故而可以不更新其值。在做完ArrayList更新之后，我们还需要将HashMap中<4, 3>元素修改为<4, 1>，因为此时元素4在ArrayList中的位置是1。在做完上述操作后，将HashMap key为2的元素删除，将ArrayList最后一位删除。整个删除操作完成，时间复杂度为常数。
```

``` java
class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int mapIndex = map.get(val);
        int lastIndex = list.size() - 1;
        if(lastIndex != mapIndex){
            list.set(mapIndex,list.get(lastIndex)); 
            map.put(list.get(lastIndex), mapIndex);
        }
        map.remove(val);
        list.remove(lastIndex);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
        
    }
}
```

