package com.talentroc.t5.bs.modal.test.pages;

import com.talentroc.t5.bs.modal.components.Modal;
import com.talentroc.t5.bs.modal.services.ModalSupport;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Index {
    @Inject
    private ModalSupport modalSupport;

    @InjectComponent
    private Modal modal1, modal2;

    void onShowModal1() {
        modal1.show();
    }

    void onGotoModal2() {
        modal2.update();
    }

    void onCloseModal() {
        modalSupport.hide();
    }
}
