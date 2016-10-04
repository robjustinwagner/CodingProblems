Sum Swap: Given two arrays of integers, find a pair of values (one
value from each array) that you can swap to give the two arrays the
same sum.


MY_EXAMPLE:

input: [2 0 -1 1 1 -4 6](5) [-7 12 2](7)

output: [1, 2]


EXAMPLE:

input: [4 1 2 1 1 2](11) [3 6 3 3](15)

output: [1, 3]


- not necessarily sorted

- may not have solution

- if solution(s) exist(s): both already equal, both not equal

- negatives, zeros, positives, duplicates

 - identical integers in both arrays (e.g. both contain 2)

- could be extended to support several swaps


-difference in sums even, odd

 > even --> search for swap numbers with difference (differenceInSums/2)

 > odd --> one swap number must be zero, other == differenceInSums

-sort O((n+k)*d) --> O(n+10)*1) --> O(N) radix sort / counting sort
