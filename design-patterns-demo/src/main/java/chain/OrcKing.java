package chain;

/**
 * 国王下达命令
 */
public class OrcKing {

    private RequestHandler chain;

    public OrcKing() {
        buildChain();
    }

    private void buildChain() {
        chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }

    public void makeRequest(Request request){
        chain.handleRequest(request);
    }
}
