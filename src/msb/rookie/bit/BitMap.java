package msb.rookie.bit;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName BitMap
 * @Description TODO 用来表示某个数是否存在;
 * @Date 2023/1/12 11:26
 * Version 1.0
 **/
public class BitMap {

    private Long[] bits;

    public BitMap(int max) {
        //(max + 64) >> 6 == (max + 64) / 64
        bits = new Long[(max + 64) >> 6];
    }

    public void add(int num) {
        //(num & 63) == (num % 64) 取num所在位置
        //(...000000000...1) -- 1L向左移1位就是1,移k位就是k
        //[num >> 6] 取num在第几个Long类型的数上
        //bits[num >> 6] |= (1L << (num & 63)); 就是把所在位置变成1
        bits[num >> 6] |= (1L << (num & 63));
    }

    public void delete(int num) {
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }
    
    @Test
    public void test() {

    }
}
