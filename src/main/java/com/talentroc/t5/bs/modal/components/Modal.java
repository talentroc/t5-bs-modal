package com.talentroc.t5.bs.modal.components;

import com.talentroc.t5.bs.modal.services.ModalSupport;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Modal {
    @Inject
    private ComponentResources resources;

    @Inject
    private ModalSupport modalSupport;

    @Property
    @Parameter(required = true, allowNull = false)
    private String title;

    @Property
    @Parameter(value = "false", defaultPrefix = BindingConstants.LITERAL)
    private boolean large;

    // Prevent rendering
    Boolean setupRender() {
        return Boolean.FALSE;
    }

    public void show() {
        modalSupport.show(resources.getPageName(), title, resources.getBody(), large);
    }

    public void update() {
        modalSupport.update(resources.getPageName(), title, resources.getBody(), large);
    }

    public void hide() {
        modalSupport.hide();
    }
}
