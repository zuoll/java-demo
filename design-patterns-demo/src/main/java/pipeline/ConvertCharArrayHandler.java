package pipeline;

/**
 * 转换字符串为字符数组的处理
 */
public class ConvertCharArrayHandler implements Handler<String,char[]>{
    @Override
    public char[] process(String input) {
        char[] chars = input.toCharArray();
        System.out.println("====>ConvertCharArrayHandler");
        return chars;
    }
}
