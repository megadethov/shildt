package ua.mega.lecture1_2;

/**
 * Created by Yefremov Yuriy
 */

// Что напечатает данная программа?
//    - 1000
//    - 1010
//    - 1100
//    - 1111

public class question2_1 {
    public static void main(String[] args) {
        int x = 0, y = 0, z = 0, t = 0;
        // Для коротких проверок ||, вторые условия не будут проверяться, тк первые true, и соотв. не будет инкремента для - y, t
        if ((x++ == 0 || y++ == 0) | (z++ == 0 || t++ == 0)) {
            /*NOP*/
        }
        System.out.println(x + " " + y + " " + z + " " + t);
    }
}















// 1010
