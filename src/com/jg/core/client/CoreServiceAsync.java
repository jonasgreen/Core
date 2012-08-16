package com.jg.core.client;

import com.google.gwt.user.client.rpc.*;
import com.jg.core.client.service.*;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface CoreServiceAsync {
  
    void execute( Action<?> defaultAction, AsyncCallback<Result> callback );


}
