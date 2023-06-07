public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverseManually("Hello"));
    }

    public static String reverseManually(String str){
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i>=0; i--)
            sb.append(str.charAt(i));

        return sb.toString();
        }

}

