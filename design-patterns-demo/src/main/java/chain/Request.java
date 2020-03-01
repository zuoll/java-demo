package chain;

import java.util.Objects;

public class Request {

    public enum RequestType{
        DEFEND_CASTLE,//保卫城堡
        TORTURE_PRISONER,//惩治犯人
        COLLECT_TAX,//收税
        ;
    }


    private RequestType requestType;
    private String requestDescription;
    private boolean handled;//是否已经处理

    public Request(RequestType requestType, String reqDesc){
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(reqDesc);
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public boolean isHandled() {
        return handled;
    }

    public void markHandle(){
        this.handled = true;
        System.out.println("已经处理了");
    }
}
