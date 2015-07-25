package com.company;
//It's a test for git branch.
//so that's a kind of tolerance
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] test=new String[6];
        test[1] = "1+2*3";         //7
        test[2] = "(2+2)+2";       //6
        test[3] = "(2*3)+2";       //8
        test[4] = "(90/2+6)/3";    //17
        while(true){
        Scanner input= new Scanner(System.in);
        System.out.print("\n\n\n\n\t\t\t欢迎使用21世纪最现金的智能计算机\n" +
                "\t\t\t希望你能玩得愉快\n" +
                "\t\t\t当然，本产品最终会给出一个答案，\n" +
                "\t\t\t然而对错只能看天了，那么，请允许我命名它为java云计算\n" +
                "\t\t\t目前仅提供+ - * / 以及对括号的支持\n" +
                "\t\t\twriter by saiting\n" +
                "\t\t\tversion :\t0.1\n\n" +
                "在这里输入你的表达式:\t");

        String exp = input.nextLine();
        System.out.print("\n\nthe answer is .\n" +
                ".\n" +
                ".\n"+String.valueOf(Methods.counting(exp)));

        input.nextLine();//
            //it's a remote control test
        }
    }

}
class Methods {   //main codes

    public static double counting(String input) {
        //initial some parameters
        int INlength = input.length();
        Stack hand = new Stack();
        hand.push(new MyStackContainers('+', 0, 0));
        int strindex=0;
        //true scenario
        while(strindex<INlength){
            switch (input.charAt(strindex)){
                case '+':
                    Meetadd(hand);strindex++;break;
                case '-':
                    Meetmine(hand);strindex++;break;
                case '*':
                    Meetmulti(hand);strindex++;break;
                case '/':
                    Meetdiv(hand);strindex++;break;
                case '(':
                    MeetForebracket(hand);strindex++;break;
                case ')':
                    MeetBackbracket(hand);strindex++;break;
                default:
                    if(
                            (input.charAt(strindex)-'0')>=0
                                &&
                            (input.charAt(strindex)-'0')<10
                            )
                        {
                            int start=strindex;
                            int end=start;
                            do {


                            end++;strindex++;

//                            strindex--;  //Align the index.
                                }while(
                                    (strindex<INlength)
                                            &&
                                    (input.charAt(strindex) - '0') >=0
                                            &&
                                    (input.charAt(strindex)-'0')<10);
                            DowithNumber(input.substring(start,end),hand);
                        }
                    else{
                        //do some exception schema
                    }

            }
        }
        while(hand.size()>=2){
            MyStackContainers up = (MyStackContainers)hand.pop();
            MyStackContainers down = (MyStackContainers)hand.pop();
            double tempres = ArithmeticwithStack.DoOperation(down.number,down.op,up.number);
            hand.push(new MyStackContainers(down.op,tempres,down.hasbracket));
        }
        return ((MyStackContainers)hand.pop()).number;
    }


    public static void Meetadd(Stack hand){
        if(!hand.empty()) {
            MyStackContainers top = (MyStackContainers) hand.pop();
            MyStackContainers fin;
            MyStackContainers p;
            MyStackContainers peek = (MyStackContainers) hand.peek();
            while (!hand.empty() && ((MyStackContainers)hand.peek()).hasbracket == 0) {
                p = (MyStackContainers) hand.pop();
                double tempres = ArithmeticwithStack.DoOperation(p.number, p.op, top.number);
                top = new MyStackContainers('+',  //和遇到的op 一致
                        tempres,                //得到的数字
                        p.hasbracket            //和p一致
                );
//                peek = (MyStackContainers) hand.peek();
            }
            fin = top ;
            hand.push(fin);
        }
        else{
            //do some exception methods
        }
    }
    public static void Meetmine(Stack hand){
        if(!hand.empty()) {
            MyStackContainers top = (MyStackContainers) hand.pop();
            top.op='-';
            MyStackContainers fin;
            MyStackContainers p=top;
            MyStackContainers peek = (MyStackContainers) hand.peek();
            while (!hand.empty() && ((MyStackContainers)hand.peek()).hasbracket == 0) {
                p = (MyStackContainers) hand.pop();
                double tempres = ArithmeticwithStack.DoOperation(p.number, p.op, top.number);
                top = new MyStackContainers('-',  //和遇到的op 一致
                        tempres,                //得到的数字
                        p.hasbracket            //和p一致
                );
//                peek = (MyStackContainers) hand.peek();
            }
            fin = top ;
            hand.push(fin);
        }
        else{
            //do some exception methods
        }
    }
    public static void Meetmulti(Stack hand){
        if(!hand.empty()) {
            MyStackContainers top = (MyStackContainers) hand.pop();
            top.op='*';
            MyStackContainers fin;
            MyStackContainers p=top;
            MyStackContainers peek = (MyStackContainers) hand.peek();
            while (!hand.empty() && ((MyStackContainers)hand.peek()).hasbracket == 0
//            &&(((MyStackContainers)hand.peek()).op!='-'
//                    &&((MyStackContainers)hand.peek()).op!='+')
            )
            {
                if( (((MyStackContainers)hand.peek()).op=='-'
                        ||((MyStackContainers)hand.peek()).op=='+')){
//                    p = (MyStackContainers) hand.pop();
                    top.op='*';break;
                }else {
                    p = (MyStackContainers) hand.pop();
                    double tempres = ArithmeticwithStack.DoOperation(p.number, p.op, top.number);
                    top = new MyStackContainers('*',  //和遇到的op 一致
                            tempres,                //得到的数字
                            p.hasbracket            //和p一致
                    );
                }
//                peek = (MyStackContainers) hand.peek();
            }
            fin = top ;
            hand.push(fin);
        }
        else{
            //do some exception methods
        }
    }


    public static void Meetdiv(Stack hand) {
        if (!hand.empty()) {
            MyStackContainers top = (MyStackContainers) hand.pop();
            top.op='/';
            MyStackContainers fin;
            MyStackContainers p = top;
            MyStackContainers peek = (MyStackContainers) hand.peek();
            while (!hand.empty() && ((MyStackContainers) hand.peek()).hasbracket == 0
//            &&(((MyStackContainers)hand.peek()).op!='-'
//                    &&((MyStackContainers)hand.peek()).op!='+')
                    ) {
                if ((((MyStackContainers) hand.peek()).op == '-'
                        || ((MyStackContainers) hand.peek()).op == '+')) {
//                    p = (MyStackContainers) hand.pop();
                    top.op = '/';break;
                } else {
                    p = (MyStackContainers) hand.pop();
                    double tempres = ArithmeticwithStack.DoOperation(p.number, p.op, top.number);
                    top = new MyStackContainers('/',
                            tempres,
                            p.hasbracket
                    );
//                peek = (MyStackContainers) hand.peek();
                }
            }
                fin = top;
                hand.push(fin);

        } else {
            //do some exception methods
        }
    }
    public static void MeetForebracket(Stack hand){

        //add peek's bracket number
        if(!hand.empty()) {
            MyStackContainers hook = (MyStackContainers)hand.pop();
            hook.hasbracket++;
            hand.push(hook);
        }
        else{
            //do some exception methods
        }
    }
    public static void MeetBackbracket(Stack hand){
        if(!hand.empty()) {
            MyStackContainers top = (MyStackContainers) hand.pop();
            MyStackContainers fin;
            MyStackContainers p=top;
            MyStackContainers peek = (MyStackContainers) hand.peek();
            while (!hand.empty() && ((MyStackContainers)hand.peek()).hasbracket == 0) {
                p = (MyStackContainers) hand.pop();
                double tempres = ArithmeticwithStack.DoOperation(p.number, p.op, top.number);
                top = new MyStackContainers('+',  //初始化op
                        tempres,                //得到的数字
                        p.hasbracket            //和p一致
                );
//                peek = (MyStackContainers) hand.peek();
            }
            MyStackContainers temp=((MyStackContainers) hand.pop());
            temp.hasbracket--;
            hand.push(temp);
            fin = top ;
            hand.push(fin);
        }
        else{
            //do some exception methods
        }
    }
    public static void DowithNumber(String digits,Stack hand){
        int dil=digits.length();
        double hnum=0;
        for(int i=0;i<dil;i++){
            double t=digits.charAt(i)-'0';
            hnum=hnum*10+t;
        }
        hand.push(new MyStackContainers('+',hnum,0));
    }



}

class ArithmeticwithStack{
    public static double DoOperation(double num1,char op,double num2 ){
        switch (op){
            case '+':return num1+num2;
            case '-':return num1-num2;
            case '*':return num1*num2;
            case '/':return num1/num2;
            default:{
                return 0.0;
                //and do some exception methods
            }
        }
    }
}

class MyStackContainers{
    char op;
    double number;
    int hasbracket;
    MyStackContainers(char op,double number,int hasbracket){
        this.op=op;
        this.number=number;
        this.hasbracket=hasbracket;
    }
    MyStackContainers(){}
    public String toString(){
        return "OK:" + '\n'
                +String.valueOf(op)+'\n'
                +String.valueOf(number)+'\n'
                +String.valueOf(hasbracket)+'\n';
    }
}
