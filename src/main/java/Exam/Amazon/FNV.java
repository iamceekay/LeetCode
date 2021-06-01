package Exam.Amazon;

import java.math.BigInteger;
import java.util.Arrays;

//Fowler-Noll-Vo hash function
public class FNV {

        private static final BigInteger INIT32  = new BigInteger("811c9dc5",         16);
        private static final BigInteger INIT64  = new BigInteger("cbf29ce484222325", 16);
        private static final BigInteger PRIME32 = new BigInteger("01000193",         16);
        private static final BigInteger PRIME64 = new BigInteger("100000001b3",      16);
        private static final BigInteger MOD32   = new BigInteger("2").pow(32);
        private static final BigInteger MOD64   = new BigInteger("2").pow(64);

        public static BigInteger fnv1_32(byte[] data) {
            BigInteger hash = INIT32;

            for (byte b : data) {
                hash = hash.multiply(PRIME32).mod(MOD32);
                hash = hash.xor(BigInteger.valueOf((int) b & 0xff));
                // 0xff where 0xff means 24(0's ) and 8(1's) like 00000000 00000000 00000000 11111111
            }
            System.out.println(hash);
            return hash;
        }

    public static void main(String[] args) {
        fnv1_32(new byte[]{34,23,45,33});
    }
}
