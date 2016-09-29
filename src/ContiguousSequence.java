Contiguous Sequence: Given array of integers (positive and negative),
  find contiguous sequence with largest sum. Return sum.

NOTES:
- no indication of length (could be 0, 1, many..)
- can contain duplicates, all same numbers, all different numbers
- all positive, all negative
- cant sort / use binary search in any way

EXAMPLE:
input: [2 -8 3 -2 4 -10]
output: 5 --> [3 -2 4]

[0 1 -7 12 5 -3 1 -7 6 3 3 -1]

SOLUTION:
- start from index 0, traverse array left to right, keeping sum of subsequence.
- if we see a negative number:
  > if it causes the sequence to become negative, end this sequence (before the negative number)
  > else, record sum of sequence prior to negative number (compare with max)
    AND start a new sequence (recursively branch) which *continues* the current sequence through the negative number
- negative numbers will never start or end sequences

potential sequences --> [2] [3] [3 -2 4] --> Math.max(2,3,5) --> 5
                    --> [0 1] [12 5] [12 5 -3 1] [12 5 -3 1 -7 6 3 3] --> Math.max(1, 17, 17+-3-1=15, 15+-7+6+3+3=20) --> 20
