package edu.mum.medium.dynamicprogramming;

/**
 * Created by hungduong on 10/19/16.
 */

/*
* 0 -> n need A[n] array with n elements
* General fomula to calcul the number bits of A[i]
* if n is even: F{A[i]} = F{A[i>>1]}
* if n is older: F{A[i]} = F{A[i>>1]} + 1
*/
public class CountingBits {
    //Code better (3s)
    public int[] countBits(int num) {
        int[] f = new int[num + 1];

        for(int i = 0; i <= num; i++) {
            if((i & 1) == 0) {
                f[i] = f[i >> 1];
            } else {
                f[i] = f[i >> 1] + 1;
            }
        }

        return f;
    }

    //Code good (4s)
    public int[] countBitsBetter(int num) {
        int[] f = new int[num + 1];

        for(int i = 0; i <= num; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }

        return f;
    }
}
