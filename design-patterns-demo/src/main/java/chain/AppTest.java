package chain;

public class AppTest {

    public static void main(String[] args) {
        OrcKing orcKing = new OrcKing();
        //发布三个请求， 交给国王预定义的层级链去处理
        orcKing.makeRequest(new Request(Request.RequestType.TORTURE_PRISONER, "torture_prisoner"));
        orcKing.makeRequest(new Request(Request.RequestType.COLLECT_TAX, "collect tax"));
        orcKing.makeRequest(new Request(Request.RequestType.DEFEND_CASTLE, "defend castle"));

    }
}
