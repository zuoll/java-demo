package chain;

/**
 *军人惩治犯人
 */
public class OrcSoldier extends RequestHandler {
    public OrcSoldier(RequestHandler next) {
        super(next);
    }

    @Override
    public String toString() {
        return "OrcSoldier";
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(Request.RequestType.TORTURE_PRISONER)) {
            printHandling(request);

            request.markHandle();
        }
        else {
            super.handleRequest(request);
        }
    }
}
