public class ReverseInt {
    public static void reverse_int(int input){
    long reversed = 0;
    while(input!=0){
        reversed = reversed * 10 + input % 10;
        input /= 10;
        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE)
            throw new RuntimeException("out of the limit");
        }
        System.out.println(reversed);
    }
}
