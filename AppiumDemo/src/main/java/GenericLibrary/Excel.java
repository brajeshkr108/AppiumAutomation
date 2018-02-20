package GenericLibrary;

import java.io.FileInputStream;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	
	
	public static Object[][] getCellValue_inlist(String path_excel,String moduleName,String sheetname, String TestCase_Name)
    {
         
           FileInputStream fis;
           Workbook wb=null;
           int rowcnt=1;
           int colcnt=0;
           
                try{
                  fis= new FileInputStream(path_excel);
                  wb= WorkbookFactory.create(fis);
                }
                catch(Exception e){
                }
                  
                  int rowNum= wb.getSheet(sheetname).getLastRowNum();
                  
                
                  int colstartNumber=rowcnt;
                  int totalcolNum=wb.getSheet(sheetname).getRow(colstartNumber).getLastCellNum();
                  
                 
                  int TCrownum=0;
                  for(int i=1; i<=rowNum;i++)
                  {
                  if(wb.getSheet(sheetname).getRow(i).getCell(1).toString().equals(TestCase_Name))
                        {
                               TCrownum=i;
                               break;
                                      
                        }
                                      
                  }
             
                  int TCdatarow=TCrownum;
                
                  int totalcoldataNum=wb.getSheet(sheetname).getRow(TCdatarow).getLastCellNum();
               
                  
                  System.out.println("the TC total data rows-----------"+totalcoldataNum);
                  
                  Object[][] data= new Object[1][1];
                  int index=0;
                  Hashtable<String,String> ht= null;
                  
                 for(int rNum=1; rNum<2; rNum++){

                        ht=new Hashtable<String,String>();

                        for(int colnum=1; colnum<totalcoldataNum; colnum++){
                               
                               ht.put(wb.getSheet(sheetname).getRow(1).getCell(colnum).toString(),
                            		   wb.getSheet(sheetname).getRow(TCdatarow).getCell(colnum).toString());  
                               
                        }
                       
                        ht.put(moduleName,wb.getSheet(sheetname).getRow(0).getCell(1).toString());
                      
                        data[index][0]=ht;
                       
                        index++;
                        
                  }
               
           return data; 

                  
                  }
	
	
	
}
