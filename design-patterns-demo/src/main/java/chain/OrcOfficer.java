package chain;

/**
 * 官员收税
 */
public class OrcOfficer extends RequestHandler {
    public OrcOfficer(RequestHandler next) {
        super(next);
    }

    @Override
    public String toString() {
        return "OrcOfficer";
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(Request.RequestType.COLLECT_TAX)) {
            printHandling(request);

            request.markHandle();
        }
        else {
            super.handleRequest(request);
        }
    }
}
