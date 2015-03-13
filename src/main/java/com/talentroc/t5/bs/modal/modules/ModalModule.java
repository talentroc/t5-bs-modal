package com.talentroc.t5.bs.modal.modules;

import com.talentroc.t5.bs.modal.services.ModalSupportImpl;
import com.talentroc.t5.bs.modal.services.ModalSupportMarkupRenderer;
import com.talentroc.t5.bs.modal.services.ModalSupport;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.OrderConstraintBuilder;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.MarkupRendererFilter;

public final class ModalModule {

    public static void bind(ServiceBinder binder) {
        binder.bind(ModalSupport.class, ModalSupportImpl.class).eagerLoad();
    }

    public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration) {
        configuration.add(new LibraryMapping("talentroc", "com.talentroc.t5.bs.modal"));
    }

    public static void contributeMarkupRenderer(final OrderedConfiguration<MarkupRendererFilter> configuration) {
        configuration.addInstance("modal-support", ModalSupportMarkupRenderer.class,
                OrderConstraintBuilder.afterAll().build());
    }

    private ModalModule() {
    }
}
