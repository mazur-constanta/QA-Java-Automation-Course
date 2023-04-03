package org.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RuleTest {
    /** JUnit Rules:
     * ExpectedException
     * ErrorCollector
     * Verifier
     * DisableOnDebug
     * ExternalResource
     */

    @Rule
    public RuleChain chain = RuleChain.outerRule(new TestName())
            .around(new TemporaryFolder());

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Rule
    public TestName name = new TestName();

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testFileWriting() throws Exception {
        System.out.println(folder.getRoot());
        File createdFile = folder.newFile("logg.txt");
        File createdFolder = folder.newFolder("subfolder");
        Thread.sleep(100000);
        assertTrue(createdFolder.exists());
        assertTrue(createdFolder.exists());
    }

    @Test
    public void testGivenRunningTest_whenTimeout_theTestFails() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testWhenPrintingTestName_thenTestNameIsDisplayed() {
        System.out.println(name.getMethodName());
        assertEquals("testWhenPrintingTestName_thenTestNameIsDisplayed",
                name.getMethodName());
    }


}
