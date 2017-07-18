package cc.laowantong.util;


import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年07月18日
 * @desc 将 ExcelReaderUtil和 ExportUtil合并为 ExcelUtil
 */
public class ExcelUtil {

    /**
     * @param filepath //文件路径
     * @param filename //文件名
     * @param startrow //开始行号
     * @param startcol //开始列号
     * @param sheetnum //sheet
     * @return list
     */
    public static List<Object> readExcel(String filepath, String filename, int startrow, int startcol, int sheetnum) {
        File target = new File(filepath, filename);
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(target);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (fi == null) {
            return null;
        }
        return readExcel(fi,startrow,startcol,sheetnum);

    }
    public static List<Object> readExcel(InputStream fi, int startrow, int startcol, int sheetnum) {
        List<Object> varList = new ArrayList<Object>();
        try {
//            File target = new File(filepath, filename);
//            FileInputStream fi = new FileInputStream(target);
            HSSFWorkbook wb = new HSSFWorkbook(fi);
            HSSFSheet sheet = wb.getSheetAt(sheetnum);
            //sheet 从0开始
            int rowNum = sheet.getLastRowNum() + 1;
            //取得最后一行的行号
            String timeStr = "";
            int cellNum = sheet.getRow(startrow).getLastCellNum();      //每行的最后一个单元格位置
            for (int i = startrow; i < rowNum; i++) {
                //行循环开始

                Map<Object,Object> map = new HashedMap();
                HSSFRow row = sheet.getRow(i);
                //行
                //int cellNum = row.getLastCellNum();
                //每行的最后一个单元格位置
                for (int j = startcol; j < cellNum; j++) {
                    //列循环开始
                    HSSFCell cell = row.getCell(j);
                    String cellValue = null;
                    if (null != cell) {
                        switch (cell.getCellType()) {
                            // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
                            case 0:
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                    timeStr = DateUtil.dateToStr(cell.getDateCellValue(),"YYYY-MM-DD");
                                    cellValue = timeStr.substring(0,timeStr.indexOf(" ") == -1 ? 10 : timeStr.indexOf(" "));
                                } else {
                                    double cellValue_ = cell.getNumericCellValue();
                                    if(Double.parseDouble(String.valueOf((int)cellValue_)) == cellValue_)
                                        cellValue = String.valueOf((int) cellValue_);
                                    else
                                        cellValue = String.valueOf(cellValue_);
                                }
                                break;

                            case 1:
                                cellValue = cell.getStringCellValue();
                                break;

                            case 2:
                                cellValue = cell.getNumericCellValue() + "";
                                break;

                            case 3:
                                cellValue = "";
                                break;

                            case 4:
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;

                            case 5:
                                cellValue = String.valueOf(cell.getErrorCellValue());
                                break;
                        }
                    } else {
                        cellValue = "";
                    }
                    map.put(j, cellValue);
                }
                varList.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return varList;
    }

    public static void export(HttpServletResponse response, String fileName, String[] titles, String[] keys, List<Map<String,Object>> datas) {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(fileName);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        setResponseHeader(response, fileName);
        HSSFPalette customPalette = wb.getCustomPalette();
        HSSFCellStyle columnTopStyle = getColumnTopStyle(wb);//获取列头样式对象
        HSSFCell cell = null;
        for (int i = 0; i < titles.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(style);

            customPalette.setColorAtIndex(HSSFColor.ORANGE.index, (byte) 163, (byte) 145, (byte) 125);

            columnTopStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            columnTopStyle.setFillForegroundColor(HSSFColor.ORANGE.index);

            cell.setCellStyle(columnTopStyle);                     //设置列头单元格样式
        }

        // 第五步，写入实体数据
        //遍历data
        if (datas != null){
            for (int i =0; i < datas.size(); i++) {
                // 第四步，创建单元格，并设置值
                HSSFRow createRow = sheet.createRow(i+1);
                Map<String, Object> data = datas.get(i);
                int j = 0;
                while (j<keys.length) {
                    if (data.containsKey(keys[j])) {
                        createRow.createCell(j).setCellValue(data.get(keys[j])+"");
                        j++;
                    }else{
                        j++;
                    }
                }
            }
        }

        // 第六步，将文件存到指定位置
        try {
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response
                    .setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * 列头单元格样式
     */
    public static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)11);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
     * 列数据信息单元格样式
     */
    public static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    public static HSSFCell setCellValue(HSSFRow row, HSSFCellStyle style, int columnIndex, String value) {
        HSSFCell cell = null;
        if (value!= null && NumberUtils.isDigits(value)) {
            cell = row.createCell(columnIndex, HSSFCell.CELL_TYPE_NUMERIC);   //设置单元格的数据类型
//            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
            cell.setCellValue(NumberUtils.toInt(value));
        } else if (value != null && GCWStringUtil.isDecimal(value)) {
            cell = row.createCell(columnIndex, HSSFCell.CELL_TYPE_NUMERIC);   //设置单元格的数据类型
//            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
            cell.setCellValue(Double.valueOf(value));
        }else {
            cell = row.createCell(columnIndex, HSSFCell.CELL_TYPE_STRING);   //设置单元格的数据类型
            if (StringUtils.isNotBlank(value)) {
                cell.setCellValue(value);                       //设置单元格的值
            } else {
                cell.setCellValue("");
            }
        }

        cell.setCellStyle(style);

        return cell;
    }
}
