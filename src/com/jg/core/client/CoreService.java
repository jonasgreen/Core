package com.jg.core.client;



import com.google.gwt.user.client.rpc.*;
import com.jg.core.client.service.*;

/**
 * The theclient side stub for the RPC service.
 */
@RemoteServiceRelativePath("service")
public interface CoreService extends RemoteService {
    Result execute( Action<?> defaultAction) throws Exception;

}
