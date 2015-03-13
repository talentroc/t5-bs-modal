package com.talentroc.t5.bs.modal.utils;

import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.ajax.JavaScriptCallback;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

public class ModalShowHideJsCallback implements JavaScriptCallback {

    private final String id;

    private final String function;

    public ModalShowHideJsCallback(final String id, final boolean show) {
        this.id = id;
        if (show) {
            function = "show";
        } else {
            function = "hide";
        }
    }

    @Override
    public void run(final JavaScriptSupport javascriptSupport) {
        javascriptSupport.require("talentroc/modal-support").invoke("call")
                .with(new JSONObject("id", id, "params", function));
    }
}
