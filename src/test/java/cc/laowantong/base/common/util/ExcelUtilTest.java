package cc.laowantong.base.common.util;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年07月20日
 * @desc
 */
public class ExcelUtilTest {

    private String filepath = null;

    @Before
    public void setUp() throws Exception {

        filepath = "Test_1.xls";

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void readExcel() throws Exception {

        List<List<Map<Integer, List<String>>>> lists = ExcelUtil.readExcel(filepath);



    }

    @Test
    public void getWorkBook() throws Exception {



    }

    @Test
    public void getTitlesByList() throws Exception {

        List<List<Map<Integer, List<String>>>> lists = ExcelUtil.readExcel(filepath);
        List<List<String>> titlesByList = ExcelUtil.getTitlesByList(lists);
    }

    @Test
    public void printTitle() throws Exception {

        List<List<Map<Integer, List<String>>>> lists = ExcelUtil.readExcel(filepath);
        List<List<String>> titles = ExcelUtil.getTitlesByList(lists);
        ExcelUtil.printTitle(titles);
    }


    @Test
    public void printExcelData() throws Exception {

        List<List<Map<Integer, List<String>>>> lists = ExcelUtil.readExcel(filepath);
        ExcelUtil.printExcelData(lists);


    }


    @Test
    public void getExcelTitles() throws Exception {

        Workbook workbook = ExcelUtil.getWorkBook(filepath);
        List<List<String>> lists = ExcelUtil.getExcelTitles(workbook);
        ExcelUtil.printTitle(lists);
    }

    @Test
    public void excel2Object() throws Exception {

    }

}