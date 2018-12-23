package com.krokky.DES;

public class DES {
    protected final static long MASK_6_BITS = 0xFC0000000000L;
    protected final static long MASK_32_BITS = 0xFFFFFFFFL;
    protected final static int MASK_28_BITS = 0x0FFFFFFF;
    protected final static int NUM_OF_ROUNDS = 16;

    //初始置换
    private final static byte[] IP =
            {
                    58, 50, 42, 34, 26, 18, 10, 2,
                    60, 52, 44, 36, 28, 20, 12, 4,
                    62, 54, 46, 38, 30, 22, 14, 6,
                    64, 56, 48, 40, 32, 24, 16, 8,
                    57, 49, 41, 33, 25, 17, 9, 1,
                    59, 51, 43, 35, 27, 19, 11, 3,
                    61, 53, 45, 37, 29, 21, 13, 5,
                    63, 55, 47, 39, 31, 23, 15, 7
            };

    //逆初始置换
    private final static byte[] FP =
            {
                    40, 8, 48, 16, 56, 24, 64, 32,
                    39, 7, 47, 15, 55, 23, 63, 31,
                    38, 6, 46, 14, 54, 22, 62, 30,
                    37, 5, 45, 13, 53, 21, 61, 29,
                    36, 4, 44, 12, 52, 20, 60, 28,
                    35, 3, 43, 11, 51, 19, 59, 27,
                    34, 2, 42, 10, 50, 18, 58, 26,
                    33, 1, 41, 9, 49, 17, 57, 25
            };

    private final RoundKeyGenerator keygen;
    private final FeistelFunction feistel;

    public DES() {
        keygen = new RoundKeyGenerator();
        feistel = new FeistelFunction();
    }


    public long encrypt(long block, long key) {
        return cipher(block, key, true);
    }


    public long decrypt(long block, long key) {
        return cipher(block, key, false);
    }

    /**
     * 进行DES算法的主要部分（加密或解密）
     * 对64位的block进行操作，并从64位的key生成循环秘钥
     * @param block
     * @param key
     * @param encrypt
     * @return
     */
    private long cipher(long block, long key, boolean encrypt) {
        long[] roundKeys = keygen.generateRoundKeys(key);
        block = initialPermutation(block);
        // 获得两个半块
        int leftHalf = (int) (block >> 32);
        int rightHalf = (int) block;

        int FOutput;

        // 进行16轮DES
        for (int i = 0; i < DES.NUM_OF_ROUNDS; i++) {
            if (encrypt) {
                FOutput = feistel.F(rightHalf, roundKeys[i]);
            } else {
                FOutput = feistel.F(rightHalf, roundKeys[(DES.NUM_OF_ROUNDS - 1) - i]);
            }

            // 将f函数的输出与左半部分异或
            leftHalf ^= FOutput;

            //使用异或交换
            leftHalf ^= rightHalf;
            rightHalf ^= leftHalf;
            leftHalf ^= rightHalf;
        }

        //将两个半块恢复
        long joinedHalves = ((rightHalf & MASK_32_BITS) << 32 | (leftHalf & MASK_32_BITS));

        return finalPermutation(joinedHalves);
    }

    /**
     * 初始置换
     * @param input
     * @return
     */
    private long initialPermutation(long input) {
        return DES.genericPermutation(input, IP, 64);
    }

    /**
     * 使用FP表进行置换
     * @param input
     * @return
     */
    private long finalPermutation(long input) {
        return DES.genericPermutation(input, FP, 64);
    }

    /**
     * 通用置换函数
     * @param input
     * @param indexTable
     * @param inputLength
     * @return
     */
    protected static long genericPermutation(long input, byte[] indexTable, int inputLength) {
        long output = 0;
        int index;

        for (byte anIndexTable : indexTable) {
            index = inputLength - anIndexTable;
            output = (output << 1) | ((input >> index) & 1);
        }

        return output;
    }
}