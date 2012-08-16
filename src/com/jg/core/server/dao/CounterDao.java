package com.jg.core.server.dao;

import com.jg.core.client.model.EntityId;
import com.jg.core.server.Logger;
import com.google.appengine.api.datastore.*;
import com.jg.core.client.appcontrol.*;
import com.jg.core.server.repository.Repository;

import javax.jdo.*;
import java.util.*;

/**
 *
 */
public class CounterDao {

    private Class<CounterJDO> jdoClass = CounterJDO.class;

    public CounterDao() {
    }

    public long next(EntityId id) {
        Key key = getKey(id, id.getDataStoreName());
        return next(key, id.getDataStoreName());
    }

    public long next(Repository counter) {
        String simpleName = counter.getClass().getSimpleName();
        Key key = KeyFactory.createKey(jdoClass.getSimpleName(), simpleName);
        return next(key, simpleName);
    }

    private long next(Key key, String name) {
        PersistenceManager pm = PMF.getPersistenceManager();
        try {
            if (!pm.currentTransaction().isActive()) {
                throw new SystemException("incrementing counter has to be in a transaction. CounterType=" + name);
            }
            long newCount = 1;
            try {
                CounterJDO jdo = pm.getObjectById(jdoClass, key);
                newCount = jdo.getCount() + 1;
                jdo.setCount(newCount);
                pm.makePersistent(jdo);
            }
            catch (javax.jdo.JDOObjectNotFoundException e) {
                CounterJDO newJdo = new CounterJDO();
                newJdo.setKey(key);
                newJdo.setCount(newCount);
                newJdo.setCreatedDate(new Date());
                newJdo.setName(name);
                pm.makePersistent(newJdo);
            }

            return newCount;
        }
        catch (Throwable t) {
            throw log("next", key, t);
        }
        finally {
            PMF.close(pm);
        }
    }


    private long read(Key key) {
        PersistenceManager pm = PMF.getPersistenceManager();
        try {
            try {
                CounterJDO jdo = pm.getObjectById(jdoClass, key);
                return jdo.getCount();
            }
            catch (javax.jdo.JDOObjectNotFoundException e) {
                return 0;
            }
        }
        catch (Throwable t) {
            throw log("read", key, t);
        }
        finally {
            PMF.close(pm);
        }
    }

    private Key getKey(EntityId key) {
        return KeyFactory.stringToKey(key.getEncodedKey());
    }


    private Key getKey(EntityId id, String name) {
        return new KeyFactory.Builder(getKey(id)).addChild(jdoClass.getSimpleName(), name).getKey();
    }

    private SystemException log(String type, Object obj, Throwable t) {
        String s = "DAO: " + type + ". " + t.getClass().getName() + (obj != null ? " Object=" + obj.toString() : "");
        Logger.log(s, t);
        return new SystemException(s);
    }


}
