class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<>();
        double x = Math.sqrt(c);
        int inverse = 0;
        
        if (c % x == 0)
            return true;
        
        int y = (int)x;
        
        for (int i = 0; i <= y; i++) {
            set.add(i * i);
        }
        
        for (int i = 0; i <= y; i++) {
            inverse = c - (i * i);
            if (!set.add(inverse))
                return true;
        }
        return false;
    }
}

/*
Approach 3: Using Sqrt Function
Algorithm

Instead of finding if c - a^2c−a 
2
  is a perfect square using sum of odd numbers, as done in the last approach, we can make use of the inbuilt sqrtsqrt function and check if \sqrt{c - a^2} 
c−a 
2
 
​
  turns out to be an integer. If it happens for any value of aa in the range [0, \sqrt{c}][0, 
c
​
 ], we can return a True value immediately.


public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
}

Time complexity : O\big(\sqrt{c}\log c\big)O( 
c
​
 logc). We iterate over \sqrt{c} 
c
​
  values for choosing aa. For every aa chosen, finding square root of c - a^2c−a 
2
  takes O\big(\log c\big)O(logc) time in the worst case.

Space complexity : O(1)O(1). Constant extra space is used.


Approach 4: Binary Search
Algorithm

Another method to check if c - a^2c−a 
2
  is a perfect square, is by making use of Binary Search. The method remains same as that of a typical Binary Search to find a number. The only difference lies in that we need to find an integer, midmid in the range [0, c - a^2][0,c−a 
2
 ], such that this number is the square root of c - a^2c−a 
2
 . Or in other words, we need to find an integer, midmid, in the range [0, c - a^2][0,c−a 
2
 ], such that mid \times mid = c - a^2mid×mid=c−a 
2
 .

The following animation illustrates the search process for a particular value of c - a^2 = 36c−a 
2
 =36.

 public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }
}

Time complexity : O\big(\sqrt{c}\log c\big)O( 
c
​
 logc). Binary search taking O\big(\log c\big)O(logc) in the worst case is done for \sqrt{c} 
c
​
  values of aa.

Space complexity : O(\log c)O(logc). Binary Search will take O(\log c)O(logc) space.

Approach 5: Fermat Theorem
Algorithm

This approach is based on the following statement, which is based on Fermat's Theorem:

Any positive number nn is expressible as a sum of two squares if and only if the prime factorization of nn, every prime of the form (4k+3)(4k+3) occurs an even number of times.

By making use of the above theorem, we can directly find out if the given number cc can be expressed as a sum of two squares.

To do so we simply find all the prime factors of the given number cc, which could range from [2,\sqrt{c}][2, 
c
​
 ] along with the count of those factors, by repeated division. If at any step, we find out that the number of occurences of any prime factor of the form (4k+3)(4k+3) occurs an odd number of times, we can return a False value.

In case, cc itself is a prime number, it won't be divisible by any of the primes in the [2,\sqrt{c}][2, 
c
​
 ]. Thus, we need to check if cc can be expressed in the form of 4k+34k+3. If so, we need to return a False value, indicating that this prime occurs an odd number(1) of times.

Otherwise, we can return a True value.

The proof of this theorem includes the knowledge of advanced mathematics and is beyond the scope of this article. However, interested reader can refer to this documentation.


public class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}

*/