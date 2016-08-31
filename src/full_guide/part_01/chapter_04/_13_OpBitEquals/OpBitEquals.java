package full_guide.part_01.chapter_04._13_OpBitEquals;

/**
 * Created by mega on 23.08.2016.
 */
public class OpBitEquals {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        /*
        0000 0000 0000 0000 0000 0000 0000 0001  =1
        0000 0000 0000 0000 0000 0000 0000 0100  =4
        ---------------------------------------   | (или)
        0000 0000 0000 0000 0000 0000 0000 0101  =5
        */
        a |= 4;

         /*
        0000 0000 0000 0000 0000 0000 0000 0010  =2
        0000 0000 0000 0000 0000 0000 0000 0001  =1   (после >> 1)
        */
        b >>= 1;

         /*
        0000 0000 0000 0000 0000 0000 0000 0011  =3
        0000 0000 0000 0000 0000 0000 0000 0110  =6  (после << 1)
        */
        c <<= 1;

       /*
       0000 0000 0000 0000 0000 0000 0000 0101  =5
       0000 0000 0000 0000 0000 0000 0000 0110  =3
       ---------------------------------------  ^ (исключающее или XOR)
       0000 0000 0000 0000 0000 0000 0000 0011  =3
       */
        a ^= c;

        System.out.println("a = " + a); // 3
        System.out.println("b = " + b); // 1
        System.out.println("c = " + c); // 6
    }
}
