package com.jg.core.server.dao;

import com.google.appengine.api.datastore.*;
import com.jg.core.client.util.*;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.*;

/**
 *
 */
public abstract class JDO implements ToString{


    @Persistent
    private Date createdDate;

    @Persistent
    private Date lastChangeDate;


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
    public abstract Key getKey();

    public abstract void setKey(Key key);

    public void toString(StringBuffer sb, int tab){
        WriterIt.appendTab(sb, tab);
        sb.append(this.toString());
    }


}
