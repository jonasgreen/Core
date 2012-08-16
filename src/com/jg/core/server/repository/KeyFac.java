package com.jg.core.server.repository;

import com.jg.core.client.model.EntityId;
import com.jg.core.server.dao.*;
import com.google.appengine.api.datastore.*;
import com.jg.core.client.appcontrol.*;

import java.util.*;

/**
 *
 */
public class KeyFac {

    private KeyFac() {
        super();
    }


    public static Key convert(EntityId id) {
        if(id == null){
            throw new SystemException("EntityId is Null");
        }
        return KeyFactory.stringToKey(id.getEncodedKey());
    }

    private static void validate(Key key, Class kind) {
        if (!key.getKind().equals(kind.getSimpleName())) {
            throw new SystemException("Key validation error. Key:" + key + " kind: " + kind.getSimpleName());
        }
    }

    private static Key createKey(Class cl, long id) {
        return KeyFactory.createKey(cl.getSimpleName(), id);

    }

    private static Key createChild(Key parent, Class cl, long id) {
        return new KeyFactory.Builder(parent).addChild(cl.getSimpleName(), id).getKey();
    }

    private static Key createChild(Key parent, Class cl, String id) {
        return new KeyFactory.Builder(parent).addChild(cl.getSimpleName(), id).getKey();

    }

    public static Key stringToKey(String encodedKey) {
        return KeyFactory.stringToKey(encodedKey);
    }
}
