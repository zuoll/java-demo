package pipeline;

import java.util.Arrays;

public class AppTest {
    public static void main(String[] args) {
        Pipeline<String, char[]> stringPipeline =
                new Pipeline<>(new RemoveAlphaHandler())//currentHandler = RemoveAlphaHandler
                        .addHandler(new RemoveDigestHandler())
                        .addHandler(new ConvertCharArrayHandler());

        String str = "#H!E(L&L0O%THE3R#34E!";

        char[] ret = stringPipeline.execute(str);

        System.out.println(Arrays.toString(ret));
    }
}
