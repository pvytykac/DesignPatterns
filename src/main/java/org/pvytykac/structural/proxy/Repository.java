package org.pvytykac.structural.proxy;

import java.net.URL;
import java.util.Date;
import java.util.Iterator;

/**
 * @author pvytykac
 * @since 28.11.2014 17:22
 *        <p/>
 *        Copyright (c) 2014 Blackboard Inc. and its subsidiary companies. All rights reserved.
 */
public interface Repository {

    public Long getId();

    public String getName();

    public Boolean getPrivate();

    public URL getUrl();

    public String getDescription();

    public Date getUpdated();

    public Iterator<String> getBranches();

}
