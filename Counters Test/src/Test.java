import java.util.Scanner;

/**
 * Created by tianyi on 2015/7/20.
 */
public class Test {
    public static void main(String[] args){
//        char a='-';
//        char b='1';
//        double d=a-b;
//        System.out.print(d);
//        String a="12301";
//        System.out.print(a.substring(0,1));
//        int dil=a.length();
//        double hnum=0;
//        for(int i=0;i<dil;i++){
//            double t=a.charAt(i)-'0';
//            hnum=hnum*10+t;
//        }
//        System.out.print(hnum);
        System.out.print("\t\t\t欢迎使用21世纪最现金的智能计算机\n" +
                "\t\t\t希望你能玩得愉快\n" +
                "\t\t\t当然，本产品最终会给出一个答案，\n" +
                "\t\t\t至于对错就只能看天了，那么\n" +
                "\t\t\t请允许我命名它为java云计算\n" +
                "\t\t\t目前仅提供+ - * / 以及对括号的支持\n" +
                "\t\t\twriter by saiting\n" +
                "\t\t\tversion :\t0.1\n\n" +
                "在这里输入你的表达式:\t");
        Scanner sc= new Scanner(System.in);
        System.out.print(sc.nextLine());
    }
}
