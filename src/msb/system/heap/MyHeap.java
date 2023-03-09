package msb.system.heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author zkx
 * @ClassName MyHeap
 * @Description TODO 基于比较的堆
 * @Date 2023/2/9 16:35
 * Version 1.0
 **/
public class MyHeap<T> {
    private ArrayList<T> heap;
    private int heapSize;
    private Comparator<T> comparator;

    //构造方法:没有返回值!直接public+方法名
    public MyHeap(Comparator<T> c) {
        heap = new ArrayList();
        heapSize = 0;
        comparator = c;
    }

    public void push(T t) {
        heap.add(t);
        heapInsert(heapSize);
        heapSize++;
    }

    //堆的核心方法1:heapInsert(int index),从下往上调整堆
    public void heapInsert(int index) {
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //堆的核心方法2:heapify(int index),从上往下调整堆
    public void heapify(int index) {
        int leftSon;
        int rightSon;
        int prior;
        while(index * 2 + 1 < heapSize) {
            leftSon = index * 2 + 1;
            rightSon = leftSon + 1;
            prior = rightSon < heapSize && comparator.compare(heap.get(rightSon), heap.get(leftSon)) < 0 ? rightSon : leftSon;
            prior = comparator.compare(heap.get(index), heap.get(prior)) < 0 ? index : prior;
            if(prior == index) {
                break;
            }
            swap(index,prior);
            index = prior;
        }
    }

    public void swap(int i, int j) {
        T t1 = heap.get(i);
        T t2 = heap.get(j);
        heap.set(i, t2);
        heap.set(j, t1);
    }


    @Test
    public void test() {
        new MyHeap<Integer>((o1, o2) -> {
            return o1-o2;
        });

        new MyHeap<>(Integer::compare);
    }
}
