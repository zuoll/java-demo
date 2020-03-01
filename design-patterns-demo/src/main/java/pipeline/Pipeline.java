package pipeline;

/**
 * @param <I> 第一个处理的输入
 * @param <O> 最后一个处理的输出
 */
public class Pipeline<I, O> {

    private final Handler<I, O> currentHandler;

    public Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }


    /**
     * 从内往外看，当前的handler处理之后的结果给作为新的handler的输入数据处理
     * @param newHandler
     * @param <K> 一个中间的handler
     * @return
     */
    public <K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
        //传递一个代码块，匿名的类不类
        return  new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    public O execute(I input){
        return this.currentHandler.process(input);
    }


}
