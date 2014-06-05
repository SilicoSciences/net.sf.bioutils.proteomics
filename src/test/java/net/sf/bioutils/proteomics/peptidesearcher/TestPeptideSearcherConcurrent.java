package net.sf.bioutils.proteomics.peptidesearcher;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.sf.kerner.utils.Cache;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPeptideSearcherConcurrent {

    private Cache<String, List<String>> c;

    @AfterClass
    public void afterClass() throws Exception {
        c = null;
    }

    @AfterMethod
    public void afterMethod() {

    }

    @BeforeClass
    public void beforeClass() throws Exception {
        c = new Cache<String, List<String>>(1000);
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @Test(threadPoolSize = 16, invocationCount = 100)
    public void reduceToProteotipic01() throws IOException {
        final PeptideSearcher s = new PeptideSearcher(c);
        s.setCacheFASTAFile(true);
        Result r;
        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt.fasta"), DatabaseID.ACCESSION);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt.fasta"), DatabaseID.GENE);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt.fasta"), DatabaseID.PROTEIN);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        // e.g. sp|P02769|ALBU_BOVIN Serum albumin OS=Bos taurus GN=ALB PE=1
        // SV=4 PROTEOTYPIC
        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt.fasta"), DatabaseID.PROTEIN_GENE);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        // Fond only once, so automatically proteotypic independent of
        // identifier
        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt.fasta"), DatabaseID.SPECIES);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);
    }

    @Test(threadPoolSize = 16, invocationCount = 100)
    public void reduceToProteotipic02() throws IOException {
        final PeptideSearcher s = new PeptideSearcher(c);
        s.setCacheFASTAFile(true);
        Result r;
        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt-TrEMBL.fasta"), DatabaseID.ACCESSION);
        assertEquals(Result.Type.DEGEN, r.type);

        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt-TrEMBL.fasta"), DatabaseID.GENE);
        assertEquals(Result.Type.DEGEN, r.type);

        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt-TrEMBL.fasta"), DatabaseID.PROTEIN);
        assertEquals(Result.Type.DEGEN, r.type);

        // e.g. sp|P02769|ALBU_BOVIN Serum albumin OS=Bos taurus GN=ALB PE=1
        // SV=4 PROTEOTYPIC
        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt-TrEMBL.fasta"),
                DatabaseID.PROTEIN_GENE);
        assertEquals(Result.Type.DEGEN, r.type);

        // Fond only once, so automatically proteotypic independent of
        // identifier
        r = s.reduceToProteotipic("LSQKFPK", new File(
                "src/test/resources/20140522_Bovine_SwissProt-TrEMBL.fasta"), DatabaseID.SPECIES);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);
    }

    @Test(threadPoolSize = 16, invocationCount = 100)
    public void reduceToProteotipic03() throws IOException {
        final PeptideSearcher s = new PeptideSearcher(c);
        s.setCacheFASTAFile(true);
        Result r;
        r = s.reduceToProteotipic("CQPSPDEARPLQALLDGR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.ACCESSION);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("CQPSPDEARPLQALLDGR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.GENE);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("CQPSPDEARPLQALLDGR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.PROTEIN);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("CQPSPDEARPLQALLDGR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.PROTEIN);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("CQPSPDEARPLQALLDGR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.PROTEIN_GENE);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("CQPSPDEARPLQALLDGR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.SPECIES);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        // //////////////

        r = s.reduceToProteotipic("SAGSVESPSVSSTHR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.ACCESSION);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("SAGSVESPSVSSTHR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.GENE);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("SAGSVESPSVSSTHR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.PROTEIN);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("SAGSVESPSVSSTHR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.PROTEIN);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("SAGSVESPSVSSTHR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.PROTEIN_GENE);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);

        r = s.reduceToProteotipic("SAGSVESPSVSSTHR", new File(
                "src/test/resources/human-mouse_DB.fasta"), DatabaseID.SPECIES);
        assertEquals(Result.Type.PROTEOTYPIC, r.type);
    }
}
