package com.jg.core.client;

import com.jg.core.client.language.Language;
import com.jg.core.client.model.Model;
import com.jg.core.client.service.*;

/**
 *
 */
public abstract class CoreServerService {

    private static ServerWrapper server = new ServerWrapper();

    public <M extends Model> void delete(DeleteAction<M> da, CallBack<VoidResult> cb){
        executeWithRetry(da, cb);
    }

    public void executeWithRetry(Action<?> a, CallBack cb) {
        a.setLanguage(Language.language.getValue());
        //cb.setRetry(a);
        server.execute(a, cb);
    }

    public void resend(Action a, CallBack<Result> cb) {
        server.execute(a, cb);
    }


}
