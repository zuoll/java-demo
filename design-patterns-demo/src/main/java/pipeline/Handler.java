package pipeline;

/**
 *与所有阶段的处理程序形成契约，接收输入，处理产生输出
 * @param <I> handler 的输入类型
 * @param <O> handler 的输出类型
 * @see java.util.stream.Stream
 */
public interface Handler<I,O> {
    O process(I input);
}


