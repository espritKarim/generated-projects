/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/Context.e.vm.java
 */
package com.jaxio.web.domain.more;

import com.jaxio.domain.more.MoreTypesDemo;
import com.jaxio.web.conversation.ConversationContext;

/**
 * The context for {@link Account} edit/select views.
 */
public class MoreTypesDemoContext extends ConversationContext<MoreTypesDemo> {
    private static final long serialVersionUID = 1L;
    public final static String editUri = "/domain/more/moreTypesDemoEdit.faces";
    public final static String selectUri = "/domain/more/moreTypesDemoSelect.faces";

    public MoreTypesDemoContext() {
    }

    public MoreTypesDemoContext(MoreTypesDemo moreTypesDemo) {
        setVar("moreTypesDemo", moreTypesDemo);
    }

    /**
     * Developer friendly method to get the entity. Use it from Java code for better clarity.
     */
    public MoreTypesDemo getMoreTypesDemo() {
        return getEntity();
    }

    @Override
    public MoreTypesDemo getEntity() {
        return getVar("moreTypesDemo", MoreTypesDemo.class);
    }
}