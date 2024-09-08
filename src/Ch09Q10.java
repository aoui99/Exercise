public class Ch09Q10 {

    public static void main(String[] args) {
        try {
            int[] nums = new int[10];

            Apple a;
            int []nus={1,2};
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }


}
class Apple{
    private int weight;

    public int getWeight() {
        return weight;
    }
}
