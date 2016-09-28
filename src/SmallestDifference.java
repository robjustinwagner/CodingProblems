/*  Smallest Difference: Given two arrays, compute the pair of values (one value in each array) with the smallest (non-negative) difference. Return the difference.
*    EXAMPLE:
*      [1 3 15 11 2]     --> 5
*      [23 127 235 19 8] --> 5
*      output: 3 --> (11, 8)
*    NOTE:
*      - problem says nothing about size of arrays
*          could be equal sizes
*          could be different sizes
*          either one could be of size 0,1...
*          both could be of size 0,1...
*      - no indication of sorting of either array
*      -
*/

[2 5 14 325]
[0 20 1 21 7]

LEARNINGS:
- make generated example more reasonable in size
-


AGENDA:
- brute force solution
  O(N^2) time, O(1) space, calculate difference between *each* pair, and keep record of smallest (non-negative) difference. Return this variable.
- more optimal solutions
  > best conceivable runtime (time & space)
  > walk through your manual solutions
  > data structure / algo brainstorm (enumerate through)
- could "combine" arrays


SOLUTION:
- sort arrays --> O(kN + kM) via Radix sort, k is range, N/M is number elements
or O(NlogN + MlogM) sort?? --> TODO
[2 5 14 325]
[0 1 7 20 21]
- modified binary search for the closest element in array two for each element of array one,
  keeping track of min(closestMatch) --> N * O(logN) --> O(NlogN) total time and O(1) space
- BETTER SOLUTION: two pointers, beginning at index 0 of each array, pretend like you're "merging" them
    --> O(N+M) time
