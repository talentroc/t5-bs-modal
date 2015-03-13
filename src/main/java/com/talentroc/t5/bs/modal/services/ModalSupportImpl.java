package com.talentroc.t5.bs.modal.services;

import com.talentroc.t5.bs.modal.utils.ModalShowHideJsCallback;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.services.PerThreadValue;
import org.apache.tapestry5.ioc.services.PerthreadManager;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.apache.tapestry5.services.ajax.JavaScriptCallback;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

public class ModalSupportImpl implements ModalSupport {
    private final static String ELEM_DIV = "div";
    private final static String ATTR_CLASS = "class";

    private final static String MODAL_ID = "talentrocModal";
    private final static String TITLE_ID = "talentrocModalTitle";
    private final static String BODY_ID = "talentrocModalBody";

    private final static ModalShowHideJsCallback SHOW_CALLBACK = new ModalShowHideJsCallback(MODAL_ID, true);
    private final static ModalShowHideJsCallback HIDE_CALLBACK = new ModalShowHideJsCallback(MODAL_ID, false);

    private final Request request;

    private final AjaxResponseRenderer ajaxResponseRenderer;

    private final PerThreadValue<Boolean> updated;

    public ModalSupportImpl(final Request request, final AjaxResponseRenderer ajaxResponseRenderer, PerthreadManager perthreadManager) {
        this.request = request;
        this.ajaxResponseRenderer = ajaxResponseRenderer;
        updated = perthreadManager.createValue();
    }

    @Override
    public void show(final String pageName, final String title, final Block body, final boolean large) {
        update(pageName, title, body, large);
        callCallback(SHOW_CALLBACK);
    }

    @Override
    public void update(final String pageName, final String title, final Block body, final boolean large) {
        if (!updated.get(Boolean.FALSE) && request.isXHR()) {
            updated.set(Boolean.TRUE);

            ajaxResponseRenderer.addRender(TITLE_ID, title);
            ajaxResponseRenderer.addRender(BODY_ID, body);

            callCallback(new JavaScriptCallback() {
                @Override
                public void run(final JavaScriptSupport javascriptSupport) {
                    javascriptSupport.require("talentroc/modal-support").invoke("large")
                            .with(new JSONObject("id", MODAL_ID, "large", large));
                }
            });
        } else {
            throw new UnsupportedOperationException("ModalSupport update can only once be used as part as an ajax " +
                    "request.");
        }
    }

    @Override
    public void hide() {
        callCallback(HIDE_CALLBACK);
    }

    private void callCallback(final JavaScriptCallback jsCallback) {
        if (request.isXHR()) {
            ajaxResponseRenderer.addCallback(jsCallback);
        } else {
            throw new UnsupportedOperationException("ModalSupport callback can only be used as part as an ajax " +
                    "request.");
        }
    }

    @Override
    public void render(final MarkupWriter writer) {
        renderModal(writer.getDocument().find("html/body"));
    }

    private void renderModal(final Element element) {
        final Element modal = element.element(ELEM_DIV, ATTR_CLASS, "modal fade", "id", MODAL_ID);
        final Element modalDialog = modal.element(ELEM_DIV, ATTR_CLASS, "modal-dialog");
        final Element modalContent = modalDialog.element(ELEM_DIV, ATTR_CLASS, "modal-content");
        final Element modalHeader = modalContent.element(ELEM_DIV, ATTR_CLASS, "modal-header");
        modalHeader.element("button", ATTR_CLASS, "close", "data-dismiss", "modal").raw("&times;");
        modalHeader.element("h4", ATTR_CLASS, "modal-title",
                "id", TITLE_ID, "data-container-type", "zone");
        modalContent.element(ELEM_DIV, ATTR_CLASS, "modal-body",
                "id", BODY_ID, "data-container-type", "zone");
    }
}
