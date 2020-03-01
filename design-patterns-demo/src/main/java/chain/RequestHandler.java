package chain;

public abstract class RequestHandler {

    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;

        System.out.println("RequestHandler,"+next);
    }


    public void handleRequest(Request request) {
        if (next != null) {
            next.handleRequest(request);
        }
    }

    public void printHandling(Request request) {
        System.out.println(String.format("%s is handing req %s, current hand status is %s ",
                this, request.getRequestDescription(), request.isHandled() ));
    }

    @Override
    public abstract String toString();

}
