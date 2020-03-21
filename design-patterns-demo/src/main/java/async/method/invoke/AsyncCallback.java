package async.method.invoke;

import java.util.Optional;

public interface AsyncCallback <T>{

    void onComplete(T value, Optional<Exception> exceptionOptional);
}
