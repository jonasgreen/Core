package com.jg.core.server.repository;


import com.jg.core.server.dao.*;
import com.jg.core.client.model.*;

import java.util.*;

/**
 *
 */
public abstract class Converter<J extends JDO, M extends Model, C extends Creater> {

    public abstract J convert(C creater);


    public abstract M convert(J jdo);


    public abstract void updateJDO(J jdo, M model);



    public List<M> convertJDOs(Collection<J> jdos) {
        if (jdos == null) {
            return null;
        }
        List<M> rs = new ArrayList<M>();
        for (J jdo : jdos) {
            rs.add(convert(jdo));
        }
        return rs;
    }

}
