package pipeline;

import java.util.function.IntPredicate;

/**
 * 去除字符串中的字母
 */
public class RemoveAlphaHandler implements Handler<String,String> {

    @Override
    public String process(String input) {
        StringBuilder sb = new StringBuilder();
        input.chars().filter(((IntPredicate) Character::isAlphabetic).negate())
                .mapToObj(x->(char)x).forEachOrdered(sb::append);
        System.out.println("====>RemoveAlphaHandler");
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aa123bb345";
        RemoveDigestHandler r = new RemoveDigestHandler();
        String ret = r.process(str);
        System.out.println(ret);
    }
}
