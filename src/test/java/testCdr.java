import org.testng.annotations.Test;

public class testCdr {


    @Test
    public void DummyTest() {
        System.out.println("Test sampple");
    }


    @Test
    public void foreLoop() {

        for (int i = 0; i <= 10; i++) {

            System.out.println(i);

        }
    }
@Test
    public void whileLooop() {
        int j=0;
        while (j<10) {
         j++;
 System.out.println(j);
        }

    }

    @Test
    public void Fib(){
        int number=0; int number2=1 ; int Length=10;
        int i=0;
       // System.out.println(number);
        while( i<=Length){

            System.out.println(number);
            int sum = number+number2;
            number =number2;
            number2=sum;
            i++;


        }
        }


@Test
    public void Array(){

        int[] Numbers={1,2,3,4};
        System.out.println(Numbers.length);

        for(int i= Numbers.length; i < Numbers.length;i--) {

            System.out.println(Numbers[i]);

            //int flip[i] = Numbers[i];
        }
        }



}





