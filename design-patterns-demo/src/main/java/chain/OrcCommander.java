package chain;

/**
 * 将军保卫城堡
 */
public class OrcCommander extends RequestHandler {

    public OrcCommander(RequestHandler next) {
        super(next);
    }

    @Override
    public String toString() {
        return "OrcCommander";
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(Request.RequestType.DEFEND_CASTLE)) {
            //打印处理了
            printHandling(request);

            //标记处理过了
            request.markHandle();
        }
        else {
            super.handleRequest(request);
        }
    }
}
