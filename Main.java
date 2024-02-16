
import java.io.*;
import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
public class Main {
    

    public static void main(String[] args){
        
        try{
            Scanner s1 = new Scanner(System.in);
           File file = new File("C:\\Program Files\\0_xlsx");
           FileInputStream fO = new FileInputStream(file); 
           XSSFWorkbook wb = new XSSFWorkbook(fO);
           XSSFSheet sheet = wb.getSheetAt(0);
           int modes = wb.egtPhysicalNumberOfRows();
           int ch = selectMODES(); //display and choose mode
           ArrayList<String> urls = getModeLinks(ch, sheet); //Search spec row and get the links from x2 >> xF
           launchURLS(urls); //take urls and launch (MODE1)

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static int selectMODES(){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Select Mode");
        displayMODES();
        int choice = s1.nextInt();
        return choice;

    }
    public static void displayMODES(){
        System.out.println("1 : Math");
        System.out.println("2 : GPH");
        System.out.println("3 : English");
        System.out.println("4 : CSE");
        System.out.println("5 : Futbol");
        System.out.println("6 : Schedule");
        System.out.println("7 : Work");
        System.out.println("8 : An");
    }

    public static ArrayList<String> getModeLinks(int z, XSSFSheet sheet){
        ArrayList<String> n = new ArrayList<>();
        XSSFRow row = sheet.getRow(z);
        int length = row.getLastCellNum();
        for(int i=1;i<=length;i++){
        XSSFCell cell = row.getCell(i); //link 
        n.add(cell);
        }

    }

    public static void launchURLS(ArrayList<String> arr){
         try{
            Desktop desktop = Desktop.getDesktop();
            
            for(String url:arr){
                URI uri = new URI(url);
                desktop.browse(uri);
            }
        }catch(Exception e){
            e.printStackTrace();;
        }
    }




}


