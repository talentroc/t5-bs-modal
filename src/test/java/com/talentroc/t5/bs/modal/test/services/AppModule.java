package com.talentroc.t5.bs.modal.test.services;

import com.talentroc.t5.bs.modal.modules.ModalModule;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.ImportModule;

@ImportModule({ModalModule.class})
public final class AppModule {
    public static void contributeApplicationDefaults(
            final MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");
        configuration.add(SymbolConstants.HMAC_PASSPHRASE, "test");
        configuration.add(SymbolConstants.PRODUCTION_MODE, false);
    }

    private AppModule() {
    }
}
