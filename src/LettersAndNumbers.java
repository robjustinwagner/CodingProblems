/*
  Letters and Numbers: Given an array filled with letters and numbers,
find the longest subarray with an equal number of letters and numbers

  - no indication that array is sorted
    > binary search not useful
  - ARE CHARS ASCII OR UNICODE? (128/256 or < 2^21ish char set)
    > any bounds on numbers? (e.g. if < 74, we can convert all chars to ints)
  - numbers can be negative, positive, zeros, all the same, all different, etc
  - hashtable?
  - radix sort?
  - could be no numbers, no letters, empty array

  - brute force: look at all even-length subarrays with memoization --> O(n^2)

  [ 1  1  0  e  f  5  s  1  2  3  3  3  s  34]
  [+1 +2 +3 +2 +1 +2 +1 +2 +3 +4 +5 +6 +5 +6]
  [0 e f 5 s 1]

  # num --> 8
  # char --> 4
  diff = 4

  USEFUL INFORMATION
  - total number of numbers O(N)
  - total number of letters O(N)
  - difference in total numbers of numbers and letters O(1)
  - LENGTH OF SUBARRAY MUST BE EVEN
  -

  SOLUTION:
  - iterate through array, alternating what we're looking for (letter
vs number), starting with index 0
  - keep simple count, incrementing when we see number (for example),
and decrementing when we see letter (for example)
  - after one pass, iterate back through array and find "longest"
distance between pair of [n, n-1] if starting with number, or [n-1, n] if starting with letter,
  return


*/


public Object[] longestSubArray(Object[] lettersAndNumbers){
  if(lettersAndNumbers.length <= 1) throw new InvalidInputException();

  Map<int, int> countHash = new HashMap<>(lettersAndNumbers.length);
  int index = 0;
  int count = 0;
  for(Object o in lettersAndNumbers){
    if (o instanceof Integer){
      count.put(++count, index);
    }
    else{
      count.put(--count, index);
    }
  }

  Tuple<int, int> longestSubArray = new Tuple<>(0,0);
  for(int i in count.keys){
    if(i = 0) next;
    if((count.get(i) - count.get(i-1) > (longestSubArray.getY() - longestSubArray.getX()))
      longestSubArray.setX(count.get(i-1));
      longestSubArray.setY(count.get(i));
  }

  return longestSubArray.getX() || longestSubArray.getY() ?
    null : Arrays.copyOfRange(longestSubArray, longestSubArray.getX(), longestSubArray.getY());
}
