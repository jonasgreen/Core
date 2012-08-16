package com.jg.core.client.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public abstract class Model<E extends EntityId> implements Serializable{
    private static final long serialVersionUID = 8465595286369175756L;

    private E id;
    private Date createdDate;
    private Date lastChangeDate;

    public Model(){
    }

    public E getId() {
        return id;
    }


    public void setId(E id) {
        this.id = id;
    }

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

    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if(!(o instanceof Model)){
            return false;
        }

        Model model = (Model) o;

        if (id != null ? !id.equals(model.id) : model.id != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    
}
