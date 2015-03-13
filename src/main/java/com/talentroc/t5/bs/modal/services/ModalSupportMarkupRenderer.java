package com.talentroc.t5.bs.modal.services;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.services.MarkupRenderer;
import org.apache.tapestry5.services.MarkupRendererFilter;

public class ModalSupportMarkupRenderer implements MarkupRendererFilter {

    private final ModalSupport modalSupport;

    public ModalSupportMarkupRenderer(final ModalSupport modalSupport) {
        this.modalSupport = modalSupport;
    }

    @Override
    public void renderMarkup(final MarkupWriter writer, final MarkupRenderer renderer) {
        renderer.renderMarkup(writer);

        modalSupport.render(writer);
    }
}
