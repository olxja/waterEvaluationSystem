package com.utils;

import org.apache.poi.ss.usermodel.Cell;

import java.text.DecimalFormat;

/**
 * Created by lenovo on 2016/12/8.
 */
public class PoiUtil {
    /**
     * 对Excel的各个单元格的格式进行判断并转换
     */
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        DecimalFormat df = new DecimalFormat("#");
        if (cell == null) {
            return cellValue;
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                cellValue = cell.getRichStringCellValue().getString().trim();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                cellValue = df.format(cell.getNumericCellValue()).toString();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case Cell.CELL_TYPE_FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }
}
