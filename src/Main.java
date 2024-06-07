import java.util.Scanner;

//"a"+"b", "a"-"b","a"*b, "a"/b
//передавать выражения в двойных кавычках
//результат сложения , строка из переданых строк
//деление , результат строка короче в указанное кол раз
//умножение , результат строка повторяется указанное кол раз
//вычитание , результат удаление из первой вторую, елси не содержит то выводим первую
//Принимаем числа от 1 до 10 включительно. строки не более 10 символов. В результате после 40 символа три троеточие.
//Только целые числа
//первый аргумент строка или выбрасываем исключение.
//При неподходящем числе или операции - выбрасываем исключение


public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String expression=scanner.nextLine();
        char action;
        String[] variable;
        if(expression.contains("+")) {
            variable = expression.split("\\+");
            action = '+';
        } else if(expression.contains("-")){
            variable=expression.split("-");
            action ='-';
        } else if(expression.contains("*")){
            variable=expression.split("\\*");
            action ='*';}
        else if(expression.contains("/")){
            variable=expression.split("/");
            action='/';
        }else{
            throw new Exception("Некорректный знак действия");
        }
        if(action=='+'||action=='-'||action=='*'||action=='/'){
            if (!(variable[0].contains("\""))) throw new Exception("Первым аргументом ставим только строку");
        }
        if(action=='+'||action=='-'){
            if (!variable[1].contains("\"")) throw new Exception("Прибавлять, вычитать можно только на строчку");
        }
        if(action=='*'||action=='/'){
            if(variable[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        if (variable[0].length()>12||variable[1].length()>12){ throw new Exception("Строка не более 10 символов");

        }
        for(int i=0;i<variable.length;i++){
            variable[i]=variable[i].replace("\"","");
        }

        if(action=='+'){
            OutputInQuotes(variable[0]+variable[1]);
        }else if(action=='*'){
            int namber = Integer.parseInt(variable[1]);
            if(namber>10) throw new Exception("принимаем числа от 1 до 10 включительно");
            String result = "";
            for(int i=0;i<namber;i++){
                result+=variable[0];
            }
            if(result.length()>40){
            result=result.substring(0,40);
                OutputInQuotesForLongString(result);
            }else
                OutputInQuotes(result);
        }else if (action=='-'){
            int index = variable[0].indexOf(variable[1]);
            if(index==-1){
                OutputInQuotes(variable[0]);
            }else {
                String result = variable[0].substring(0,index);
                result+=variable[0].substring(index+variable[1].length());
                OutputInQuotes(result);
            }
        }else {
            int newLen = variable[0].length()/Integer.parseInt(variable[1]);
            if(newLen>10) throw new Exception("Принимаем числа от 1 до 10 включительно");
            String result = variable[0].substring(0,newLen);
            OutputInQuotes(result);
        }
    }
    static void OutputInQuotes(String text){
        System.out.println("\""+text+"\"");
    }
    static void OutputInQuotesForLongString(String text){
        System.out.println("\""+text+"..."+"\"");
    }
}