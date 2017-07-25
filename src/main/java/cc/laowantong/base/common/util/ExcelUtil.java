package cc.laowantong.base.common.util;

import cc.laowantong.base.model.pojo.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年07月20日
 * @desc
 */
public class ExcelUtil {


    public static List<List<Map<Integer, List<String>>>> readExcel(String filepath) {
        return readExcel(getWorkBook(filepath));
    }

    public static void printExcelData(List<List<Map<Integer, List<String>>>> excelData) {

        if (excelData != null) {
            for (List<Map<Integer, List<String>>> sheet : excelData) {
                for (Map<Integer, List<String>> rowMap : sheet) {
                    for (Map.Entry<Integer, List<String>> entry : rowMap.entrySet()) {

                        Integer key = entry.getKey();
                        String message = key == 0 ? "title" : "body";
                        if (key <= 1)
                            System.out.println(message + " :");

                        List<String> value = entry.getValue();
                        for (String s : value) {
                            System.out.print(s + "   ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public static void printTitle(List<List<String>> lists) {
        for (List<String> sheetTitle : lists) {
            System.out.println("title : ");
            for (String title : sheetTitle) {
                System.out.print(title + "   ");
            }
            System.out.println();
        }
    }


    public static List<List<String>> getTitlesByList(List<List<Map<Integer, List<String>>>> excelData) {

        List<List<String>> list = new ArrayList<List<String>>();

        if (excelData != null) {
            for (List<Map<Integer, List<String>>> sheet : excelData) {
                for (Map<Integer, List<String>> rowMap : sheet) {
                    for (Map.Entry<Integer, List<String>> entry : rowMap.entrySet()) {
                        if (entry.getKey() == 0) {
                            List<String> value = entry.getValue();
                            list.add(value);
                        }
                    }
                }
            }
        }
        return list;
    }





    // 拿到 Excel中每个 sheet中的列名
    public static List<List<String>> getExcelTitles(Workbook workbook) {

        List<List<String>> lists = new ArrayList<List<String>>();

        int sheetsNum = workbook.getNumberOfSheets();
        for (int i = 0; i < sheetsNum; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            Row firstRow = sheet.getRow(sheet.getFirstRowNum());

            short firstCellNum = firstRow.getFirstCellNum();
            short lastCellNum = firstRow.getLastCellNum();

            List<String> titles = new ArrayList<String>();

            for (int j = firstCellNum; j < lastCellNum; j++) {
                String cellValue = getCell(firstRow.getCell(j));
                titles.add(cellValue);
            }
            lists.add(titles);
        }
        return lists;
    }

    // 将从 Excel中取出的数据填充到对象中, 并返回对象集合
    public static <T> T excel2Object(List<List<Map<Integer, List<String>>>> excelData, Class<T> clazz) {

        // 从 excelData中拿到 title
        List<List<String>> titles = ExcelUtil.getTitlesByList(excelData);

        try {
            Class<?> aClass = Class.forName(clazz + "");
            Object obj = aClass.newInstance();

            if (obj instanceof Student) {
                Student stu = (Student) obj;


            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        }

        return null;
    }


    // 根据文件名获取 Excel解析器
    public static Workbook getWorkBook(String filepath) {

        if (filepath == null || "".equals(filepath))
            return null;

        InputStream is = ExcelUtil.class.getClassLoader().getResourceAsStream(filepath);
        if (is == null)
            return null;

        String ext = filepath.substring(filepath.lastIndexOf('.'));
        Workbook workbook = null;
        try {
            //构造 Excel文件解析器
            if (".xls".equals(ext)) {
                return new HSSFWorkbook(is);
            } else if (".xlsx".equals(ext)) {
                return new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static List<List<Map<Integer, List<String>>>> readExcel(Workbook workbook) {

        List<List<Map<Integer, List<String>>>> excelData = new ArrayList<List<Map<Integer, List<String>>>>();
        List<Map<Integer, List<String>>> sheetData = new ArrayList<Map<Integer, List<String>>>();

        // rowData是一个存放每个 sheet中的行数据的集合
        // map集合的 key, key为0时, 该行为title, k > 0时,该行为body
        Map<Integer, List<String>> rowMap = null;
        List<String> rowData = null;

        if (workbook == null)
            return null;

        // 获取 Excel sheet个数
        int sheetsNum = workbook.getNumberOfSheets();
        for (int i = 0; i < sheetsNum; i++) {
            // 获取指定索引处的 sheet
            Sheet sheet = workbook.getSheetAt(i);
            // 获取 Excel行数
            int rowsNum = sheet.getPhysicalNumberOfRows();

            // 获取起始行号和结束行号
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();

            // 该 index用作 map的 key
            int index = 0;
            for (int j = firstRowNum; j <= lastRowNum; j++) {
                // 获取行数据
                Row row = sheet.getRow(j);

                // 获取行中单元格的起始索引和结束索引
                int firstCellNum = row.getFirstCellNum();
                // lastCellNum会比 excel实际列数多 1
                int lastCellNum = row.getLastCellNum();

                rowMap = new LinkedHashMap<Integer, List<String>>();
                rowData = new ArrayList<String>();

                for (int k = firstCellNum; k < lastCellNum; k++) {
                    Cell cell = row.getCell(k);
                    // 获取单元格数据
                    String value = getCell(cell);
                    rowData.add(value);
                }
                rowMap.put(index++, rowData);
                sheetData.add(rowMap);
            }
            excelData.add(sheetData);
        }
        return excelData;
    }


    // 获取单元格的值
    public static String getCell(Cell cell) {

        String cellvalue = "";
        DataFormatter formatter = new DataFormatter();

        if (cell != null) {
            // 判断单元格数据的值
            switch (cell.getCellType()) {
                // 数值格式
                case Cell.CELL_TYPE_NUMERIC:
                    // 进一步判断, 单元格格式是日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellvalue = formatter.formatCellValue(cell);
                    } else {
                        // 数值
                        double value = cell.getNumericCellValue();
                        int intValue = (int) value;
                        cellvalue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
                    }
                    break;

                case Cell.CELL_TYPE_STRING:
                    cellvalue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    cellvalue = String.valueOf(cell.getBooleanCellValue());
                    break;
                // 判断单元格格式是公式格式, 需要做一种特殊处理来得到相应的值
                case Cell.CELL_TYPE_FORMULA:
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_BLANK:
                    cellvalue = "";
                    break;
                case Cell.CELL_TYPE_ERROR:
                    cellvalue = "";
                    break;
                default:
                    cellvalue = cell.toString().trim();
                    break;
            }
        }
        return cellvalue.trim();
    }


}
