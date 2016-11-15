package my.it.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class TestPOI2Excel {

	@Test
	public void testWrite03Excel() throws IOException {
		//读取工作簿  HSSFWorkbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		//读取工作表  HSSFSheet
		HSSFSheet sheet = workbook.createSheet("hello excel");//表名
		//读取行          HSSFRow
		HSSFRow row = sheet.createRow(2);  //参数的行
		//读取单元格   HSSFCell
		HSSFCell cell = row.createCell(2);//第3列
		
		//写入值
		cell.setCellValue("hello,excel");
		
		//输出到硬盘
		FileOutputStream outputStream = new FileOutputStream("d:\\myit\\测试.xls");
		workbook.write(outputStream);
		
		workbook.close();
		outputStream.close();
	}
	
	@Test
	public void testRead03Excel() throws IOException{
		FileInputStream inputStream = new FileInputStream("d:\\myit\\测试.xls");
		//读取工作簿  HSSFWorkbook
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		//读取工作表  HSSFSheet
		HSSFSheet sheet = workbook.getSheetAt(0);//读取第一个工作表
		//读取行          HSSFRow
		HSSFRow row = sheet.getRow(2);  //参数的行
		//读取单元格   HSSFCell
		HSSFCell cell = row.getCell(2);//第3列
			
		//输出
		System.out.println("第3行第3列的内容:"+cell.getStringCellValue());
		
		workbook.close();
		inputStream.close();
	}
	
	//************07版本
	
	@Test
	public void testWrite07Excel() throws IOException {
		//读取工作簿  XSSFWorkbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		//读取工作表  XSSFSheet
		XSSFSheet sheet = workbook.createSheet("hello excel");//表名
		//读取行          XSSFRow
		XSSFRow row = sheet.createRow(2);  //参数的行
		//读取单元格   XSSFCell
		XSSFCell cell = row.createCell(2);//第3列
		
		//写入值
		cell.setCellValue("hello,excel");
		
		//输出到硬盘
		FileOutputStream outputStream = new FileOutputStream("d:\\myit\\测试.xlsx");
		workbook.write(outputStream);
		
		workbook.close();
		outputStream.close();
	}
	
	
	@Test
	public void testRead07Excel() throws IOException{
		FileInputStream inputStream = new FileInputStream("d:\\myit\\测试.xlsx");
		//读取工作簿  XSSFWorkbook
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		//读取工作表  XSSFSheet
		XSSFSheet sheet = workbook.getSheetAt(0);//读取第一个工作表
		//读取行          XSSFRow
		XSSFRow row = sheet.getRow(2);  //参数的行
		//读取单元格   XSSFCell
		XSSFCell cell = row.getCell(2);//第3列
			
		//输出
		System.out.println("第3行第3列的内容:"+cell.getStringCellValue());
		
		workbook.close();
		inputStream.close();
	}
	
	//公共的方法
	@Test
	public void testRead03And07Excel() throws IOException{
		String fileName = "D:\\myit\\测试.xlsx";
		//判断是否为excel文档
		FileInputStream inputStream = new FileInputStream(fileName);
		if(fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){
			boolean is03Excel = fileName.matches("^.+\\.(?i)(xls)$");
			//读取工作簿  XSSFWorkbook
			Workbook workbook = is03Excel ? new HSSFWorkbook(inputStream):new XSSFWorkbook(inputStream);
			//读取工作表  XSSFSheet
			Sheet sheet = workbook.getSheetAt(0);//读取第一个工作表
			//读取行          XSSFRow
			Row row = sheet.getRow(2);  //参数的行
			//读取单元格   XSSFCell
			Cell cell = row.getCell(2);//第3列
				
			//输出
			System.out.println("第3行第3列的内容:"+cell.getStringCellValue());
			
			workbook.close();
			inputStream.close();
		}
	}
	
	@Test
	public void  testExcelStyle() throws IOException {
		//读取工作簿  HSSFWorkbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		
		
		//合并单元格对象  合并第3行的第3列到第5列
		CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 2, 2, 4);
		//*************创建单元格样式
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		
		//*************创建字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗字体
		font.setFontHeightInPoints((short) 16);  //字体大小
		//加载字体
		style.setFont(font);
		
		
		//单元格背景
		//***********设置背景填充模式
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFillBackgroundColor(HSSFColor.YELLOW.index);
		//设置填充前景色
		style.setFillForegroundColor(HSSFColor.RED.index);
		
		
		//读取工作表  HSSFSheet
		HSSFSheet sheet = workbook.createSheet("hello excel");//表名
		//*************加载合并单元格
		sheet.addMergedRegion(cellRangeAddress);
		//读取行          HSSFRow
		HSSFRow row = sheet.createRow(2);  //参数的行
		//读取单元格   HSSFCell
		HSSFCell cell = row.createCell(2);//第3列
		//写入值
		
		
		//加载样式
		cell.setCellStyle(style);
		cell.setCellValue("Hello,World");
		
		//输出到硬盘
		FileOutputStream outputStream = new FileOutputStream("d:\\myit\\测试.xls");
		workbook.write(outputStream);
		
		workbook.close();
		outputStream.close();
	}
	
	
	
	
	
	
	

}
