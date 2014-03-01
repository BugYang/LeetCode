---
layout: post
title: Crack the LeetCode - Gray Code
---

{{ page.title }}
================

<p class="meta">01 March 2014 - Shanghai </p>

**Problem**:  
The gray code is a binary numeral system where two successive values differ in only one bit. Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0. Note, for a given n, a gray code sequence is not uniquely defined.

**Example**:    
INPUT: 2  
OUTPUT: [0,1,3,2]

**Solution 0**:  
This problem is a little bit challenging. But if you can't figure out a nice solution, you can still solve it using the most basic method. Notice you just have to 'sort' 0~2^n!

*Time Complexity*:O(2^n)  
*Space Complexity*:O(2^n)  

{% highlight java %}  
public boolean oneBitDiff(int a, int b) {
    int c = a^b, cnt = 0;
    while (c > 0) {
        cnt += c & 1;
        c = c >> 1;
    }
    return cnt == 1;
}

public ArrayList<Integer> grayCode(int n) {
    int pow = 1;
    for (int i = 0; i < n; i++) {
        pow *= 2;
    }

    int[] seq = new int[pow];
    for (int i = 0; i < pow; i++) {
        seq[i] = i;
    }

    for (int i = 0; i < pow-1; i++) {
        if (oneBitDiff(seq[i], seq[i+1])) {
            continue;
        }
        for (int j = i+2; j < pow; j++) {
            if (oneBitDiff(seq[i], seq[j])) {
                int t = seq[i+1];
                seq[i+1] = seq[j];
                seq[j] = t;
                break;
            }
        }
    }

    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i : seq) {
        result.add(i);
    }
    return result;
}
{% endhighlight %}

**Solution 1**:  
This problem is a little bit challenging. But if you can't figure out a nice solution, you can still solve it using the most basic method. Notice you just have to 'sort' 0~2^n!

*Time Complexity*:O(2^n)  
*Space Complexity*:O(2^n)  

{% highlight java %}  
public boolean oneBitDiff(int a, int b) {
    int c = a^b, cnt = 0;
    while (c > 0) {
        cnt += c & 1;
        c = c >> 1;
    }
    return cnt == 1;
}

public ArrayList<Integer> grayCode(int n) {
    int pow = 1;
    for (int i = 0; i < n; i++) {
        pow *= 2;
    }

    int[] seq = new int[pow];
    for (int i = 0; i < pow; i++) {
        seq[i] = i;
    }

    for (int i = 0; i < pow-1; i++) {
        if (oneBitDiff(seq[i], seq[i+1])) {
            continue;
        }
        for (int j = i+2; j < pow; j++) {
            if (oneBitDiff(seq[i], seq[j])) {
                int t = seq[i+1];
                seq[i+1] = seq[j];
                seq[j] = t;
                break;
            }
        }
    }

    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i : seq) {
        result.add(i);
    }
    return result;
}
{% endhighlight %}
