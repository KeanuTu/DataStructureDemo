package Arrays;

import java.util.Random;

public class OrderArray {
    private int[] intArray;
    private int length; //数组元素个数

    //构造函数，传入数组最大长度
    public OrderArray(int max) {
        intArray = new int[max];
    }

    /**
     * 二分法查找
     * @param target
     * @return
     */
    public int find(int target){
        int lowerBound = 0; //最小元素的小标
        int upperBound = length -1; //最大元素的下标
        int curIn;             //当前元素下标
        if(upperBound<0){
            return -1;          //数组为空，直接返回-1
        }
        while (true){
            curIn = (lowerBound+upperBound)/2;
            if (target == intArray[curIn]){
                return curIn;
            }else if (curIn == lowerBound){
                //在当前下标与最小下标重合,代表搜索段只包含1个或2个
                //如果高位元素不等于目标元素，证明数组中没有该元素，搜索结束
                if(target != intArray[upperBound]){
                    return -1;
                }
            }else{//搜索段中元素至少三个，且当前元素不等于目标元素
                if (intArray[curIn]<target){
                    //如果当前元素小于目标元素，则将下一个搜索段的最小下标位置为当前元素的下标
                    lowerBound = curIn;
                }else {
                    //如果当前元素大于目标元素，则将下一个搜索段的最大下标位置为当前元素的下标
                    upperBound = curIn;
                }
            }
        }
    }

    //插入
    public void insert(int elem){
        int location = 0;

        //判断应插入位置的下标
        for (;location<length;location++){
            if (intArray[location]>elem){
                break;
            }
        }
        //System.out.println("插入位置"+location);
        //将插入下标之后的所有元素后移一位
        for (int i = length; i > location; i--) {
            intArray[i] = intArray[i-1];
        }

        //插入元素
        intArray[location] =elem;

        length++;
    }

    /**
     * 删除某个指定元素
     * @param target（要删除的元素）
     * @return 删除成功与否
     */
    public boolean delete(int target){
        int index = -1;
        if((index = find(target))!= -1){
            for (int i = index; i < length-1; i++) {
                //删除元素之后的所有元素前移一位
                intArray[i] = intArray[i+1];
            }
            length--;
            return true;
        }else {
            return false;
        }
    }

    /**
     * 列出所有元素
     */
    public void display(){
        for(int i=0;i<length;i++){
            System.out.print(intArray[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OrderArray oArr = new OrderArray(8);
        /*int num;
        for (int i = 0; i < 5; i++) {
            num = new Random().nextInt(10)+1;
            oArr.insert(num);
        }*/
        oArr.insert(3);
        oArr.insert(9);
        oArr.insert(5);
        oArr.insert(1);
        oArr.display();

        System.out.println("查找指定元素3的下标");
        System.out.println(String.valueOf(oArr.find(3)));
        System.out.println("删除指定元素");
        oArr.delete(3);
        oArr.display();
    }
}
