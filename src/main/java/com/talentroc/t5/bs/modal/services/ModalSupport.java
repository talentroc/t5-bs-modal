package com.talentroc.t5.bs.modal.services;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.MarkupWriter;

public interface ModalSupport {
    /**
     * Shows and {@link #update(String, String, org.apache.tapestry5.Block, boolean) update} the modal.
     *
     * @param pageName
     *         name of the page containing the modal
     * @param title
     *         title of the modal
     * @param body
     *         body of the modal
     * @param large
     *         whether the modal should be large or not
     */
    void show(String pageName, String title, Block body, boolean large);

    /**
     * Updates the modal content
     *
     * @param pageName
     *         name of the page containing the modal
     * @param title
     *         title of the modal
     * @param body
     *         body of the modal
     * @param large
     *         whether the modal should be large or not
     */
    void update(String pageName, String title, Block body, boolean large);

    /**
     * Hides the modal
     */
    void hide();

    /**
     * Renders the modal to a markup writer
     *
     * @param writer
     *         writer to write the modal to.
     */
    void render(MarkupWriter writer);
}
