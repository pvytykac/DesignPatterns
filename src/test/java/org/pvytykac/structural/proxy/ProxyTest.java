package org.pvytykac.structural.proxy;

import static org.junit.Assert.*;

/**
 * @author pvytykac
 * @since 28.11.2014 17:43
 *        <p/>
 *        Copyright (c) 2014 Blackboard Inc. and its subsidiary companies. All rights reserved.
 */
public class ProxyTest {

    public void proxyTest(){
        try{
            Repository repository = new GitRepository("pvytykac", "DesignPatterns");
        }catch(Exception ex){
            ex.printStackTrace();
            fail();
        }
    }

}
