package pipeline;

import java.util.function.IntPredicate;

/**
 * 去除字符串中的数字
 */
public class RemoveDigestHandler implements Handler<String, String> {
    @Override
    public String process(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        input.chars()
                .filter(((IntPredicate) Character::isDigit).negate()).mapToObj(x -> (char) x)
                .forEachOrdered(stringBuilder::append);
        System.out.println("====>RemoveDigestHandler");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "aa123bbb456";
        RemoveDigestHandler r = new RemoveDigestHandler();
        String ret = r.process(str);
        System.out.println(ret);
    }
}
