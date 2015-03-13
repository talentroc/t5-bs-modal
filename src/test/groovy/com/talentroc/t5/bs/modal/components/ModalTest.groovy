package com.talentroc.t5.bs.modal.components

import geb.junit4.GebReportingTest
import org.apache.tapestry5.test.Jetty7Runner
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

class ModalTest extends GebReportingTest {
    static Jetty7Runner runner;

    @BeforeClass
    static void startRunner() {
        runner = new Jetty7Runner("src/test/webapp", "/", 9090, 9091);

        runner.start()
    }

    @AfterClass
    static void stopRunner() {
        runner.stop()
    }

    @Test
    def void "coolos testos"() {
        go()

        // display modal 1
        def modal1Link = waitFor { $("#onpage-showmodal1") }
        modal1Link.click()
        waitFor { $("#talentrocModal.modal.in") }
        assert $("#modal1p").text() == "This is modal 1"

        // update to modal 2
        $("#onmodal1-gotoModal2").click()
        def modal2Strong = waitFor { $("#modal2strong") }
        assert modal2Strong.text() == "this is the modal 2"

        //close modal
        $("#onmodal2-closemodal").click()
        waitFor { $("#talentrocModal.modal").classes().every { it != "in" } }
    }
}
