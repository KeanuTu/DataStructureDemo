package Arrays;

/**
 * 数组是一段连续的内存，即使在物理内存中不是连续的，在逻辑上是连续的
 */
public class Array {
    private String[] strArray;
    private int length = 0; //数组元素个数

    //构造方法，传入数组最大长度.
    //数组的大小是固定的
    public Array(int max){
        strArray = new String[max];
    }

    //检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
    public int contains(String target){
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (strArray[i].equals(target)){
                index = i;
                break;
            }
        }
        return index;
    }

    //插入
    public void insert(String elem){
        strArray[length] = elem;
        length++;
    }

    //删除某个指定的元素值，删除成功则返回true，否则返回false
    public boolean delete(String target){
        int index = -1;
        //查找一下是否有
        if ((index = contains(target))!= -1){
            for (int i = index; i <length-1; i++) {
                //删除元素后所有元素前移一位
                strArray[i] = strArray[i+1];
            }
            length--;
            return true;
        }else{
            return false;
        }
    }

    public boolean update(int index, String target){
        if(index < length && index >= 0){
            strArray[index] = target;
            return true;
        }
        return false;
    }

    //列出所有元素
    public void display(){
        for (int i = 0; i < length; i++) {
            System.out.print(strArray[i]+"\t");
        }
    }

    public static void main(String[] args) {
        Array arr = new Array(5);
        for (int i = 0; i < 5; i++) {
            arr.insert(String.valueOf(i));
        }
        arr.display();

        System.out.println("\n删除指定位置数据");
        arr.delete("3");
        arr.display();

        System.out.println("\n更改指定位置数据");
        //因为array数组可以通过下标的方式更换
        arr.update(0,"00");
        arr.display();
    }
}
