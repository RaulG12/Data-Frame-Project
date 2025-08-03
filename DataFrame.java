import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.util.ArrayList;



  public class DataFrame extends Main{

  //public String fileName;
  //public String fileNameCSV=fileName+".csv";
    //public String file;
    
    public String fileName; 
  public ArrayList<String> columnHeaders = new ArrayList<String>();
  public ArrayList<String> dataTypes = new ArrayList<String>();

public  ArrayList<String> data = new ArrayList<String>();
 public  ArrayList<String> data2 = new ArrayList<String>();
  public String [] row;
  public String [] row2;
  Scanner in = new Scanner(System.in);

   
int rowCounter = 0;


   public void promptForFile() {
     System.out.println("Enter filename");
     fileName=in.nextLine();
   }

   public String loadData () {
   
     int counter=0;
         //  FileWriter reader = new FileWriter();

               String test = "";
               String fileNameCSV1= fileName + ".csv";
               File fileNameCSV2= new File (fileNameCSV1);

           //    System.out.println("CSV TEST: " + fileNameCSV);
             //  placeHolder = "tmp";
               try {


                 BufferedReader reader = new BufferedReader(new FileReader(fileNameCSV2));
                 while( (test = reader.readLine()) != null){
           row = test.split(",");
           if (counter==0) {
                     for(int i=0; i<row.length; i++) {
                       columnHeaders.add(row[i]);
        
                     }
                   } 
          if (counter==1) {
             for(int i=0; i<row.length; i++) {
               dataTypes.add(row[i]);
             }
           } 
          if (counter>1){
            for(int i=0;i<row.length;i++){
            data.add(row[i]);
          }
          }
          counter++;
    }


        reader.close();

      }catch (FileNotFoundException e){
        e.printStackTrace();

      } catch(IOException e){
      e.printStackTrace();
      }

      return "";

    }

   public String loadData2 () {
     int counter=0;
     String fileNameCSV1= fileName + ".csv";
     File fileNameCSV2= new File (fileNameCSV1);
     BufferedReader reader = null;
      String line = "";
    try {
         reader = new BufferedReader(new FileReader(fileNameCSV2));
         while((line = reader.readLine()) != null) {
           row2 = line.split(",");
           for(int i=0; i<row2.length; i++) {
                       data2.add(row2[i]);
             rowCounter++;

                     }

         }

        }
        catch(Exception e) {
         e.printStackTrace();
        }
        finally {
         try {
          reader.close();
         } catch (IOException e) {
         
          e.printStackTrace();
         }
        }
    return "";
   }


   public String getFileName() {
     return fileName;
   }

   public ArrayList<String> getColumnHeaders() {
    //System.out.println(columnHeaders);
     return columnHeaders;
   }

   public ArrayList<String> getDataTypes() {
      //System.out.println(dataTypes);
       return dataTypes;
     }
   public void getData2() {
      System.out.println(data2);
     }

   public String averageColumn () {
     System.out.println("Enter columm: ");
     String column= in.nextLine();
     String output="";
     int indexToStart=0;
     double sum=0;
     double counter=1;
     double average=0;
     double val=0;
     for (int i=0; i<columnHeaders.size(); i++) {
       if (columnHeaders.get(i).equals(column)) {
         //System.out.println("Matched column is at "+i);
         indexToStart=i;
        // System.out.println("Data type is "+dataTypes.get(i));
         if(dataTypes.get(i).equals("int")||dataTypes.get(i).equals("double")) {
          // System.out.println("test "+data2.get(24+indexToStart));
           for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
             //System.out.println("test "+data2.get(j));
             val= Double.parseDouble(data2.get(j));
             //System.out.println("val is"+val);
             sum=sum+Double.parseDouble(data2.get(j));
             counter++;
           }
           average=sum/counter;
          // System.out.println(average);
           output=columnHeaders.get(i)+" Average: "+String.valueOf(average);
           return output;
         } else {
           output=columnHeaders.get(i)+" Average: "+"NaN";

         }
       }

     }

     return output;
   }
    public String findMax () {
       System.out.println("Enter column");
       String column= in.nextLine();
       double maxSoFar=0;
       String output="";
       int counter=0;
       int indexToStart=0;
       for (int i=0; i<columnHeaders.size(); i++) {
         if (columnHeaders.get(i).equals(column)) {
           indexToStart=i;
           if (dataTypes.get(i).equals("int")||dataTypes.get(i).equals("double")) {

             for (int j=indexToStart+(2*columnHeaders.size()); j<data2.size(); j=j+columnHeaders.size()) {
               if (data2.get(j)!="") {
               if (Double.parseDouble(data2.get(j))>maxSoFar) {
                 maxSoFar=Double.parseDouble(data2.get(j));
                 output=columnHeaders.get(i)+" max "+String.valueOf(maxSoFar);
               }
               }
             }
           } else {
             output=columnHeaders.get(i)+" max "+"NaN";
            return output;
           }
         }
       }
       return output;
     }


           public String findMin(){
             System.out.println("Enter column name: ");
             double min = 9999999.0;
             int indexToStart =0;
             String toReturn = " ";
             String column = in.nextLine();

             for(int i =0; i<columnHeaders.size();i++){
                 if(columnHeaders.get(i).equals(column)){
                   indexToStart = i;
                    if(dataTypes.get(i).equals("int")||dataTypes.get(i).equals("double")) {

                      for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                        if (data2.get(j)!="") {
                         if (Double.parseDouble(data2.get(j)) <min) {
                            min=Double.parseDouble(data2.get(j));
                           toReturn = columnHeaders.get(i) + " Min: " + String.valueOf(min);
                          }
                        }
                       }
                     } else{
                      toReturn = columnHeaders.get(i)+" Min : "+"NaN";
                     }
                 }
             }
             return toReturn;
           }

    
           public String freqTable(){
             System.out.println("Enter column name: ");
           String column = in.nextLine(); 

           String start =""; //minimum value in range
           Double temp4 = 0.0;
              double maxSoFar=0;
           double temp1 =0.0;
           double temp2=0.0;
           double temp3= 0.0;
           String end= ""; //maximum value in range
           int counter = 0;
             int freq1 = 0;
             int freq2 = 0;
             int freq3 = 0;
             int freq4 = 0;
             int freq5 = 0;
             String toReturn = "";
             String frequency = "";
            double min = 999999;
           //  start = findMin(column);
           //  end = findMax(column);
             
             for(int i =0; i<columnHeaders.size();i++){
               if(columnHeaders.get(i).equals(column)){
                 int indexToStart = i;
                  if(dataTypes.get(i).equals("int")||dataTypes.get(i).equals("double")) {
                    for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                       counter++; 
                       if (data2.get(j)!="") {
                      if(Double.parseDouble(data2.get(j))<min){
                        
                        min = Double.parseDouble(data2.get(j));
                        start = String.valueOf(min);
                      } else if(Double.parseDouble(data2.get(j))>maxSoFar){
                        maxSoFar=Double.parseDouble(data2.get(j));
                        end = String.valueOf(maxSoFar);
                      }
                    }
                    }      
                    int total = 0;
                    double range = ((maxSoFar-min)/5.0) + (min);
                    System.out.println("RANGE: " + range);
                 
              
                   for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                           temp4=range;
                     if (data2.get(j)!="") {
                     if(Double.parseDouble(data2.get(j))<range){
                     //System.out.println("BIG J TEST: " + j);
                     freq1++;
                     }
                     }
                     }
                    //could simplily this if there is time
                    //
                    //
                    for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                      
                      temp1=range*2 - (min) ;
                      if (data2.get(j)!="") {
                      if(Double.parseDouble(data2.get(j))>=(range) && Double.parseDouble(data2.get(j))<(range*2)-(min)){
                      freq2++;
                    }
                      }
                      }
                
                    for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                       temp2=range*3 - (min*2) ;
                      if (data2.get(j)!="") {
                      if(Double.parseDouble(data2.get(j))>=((range*2)-(min)) && Double.parseDouble(data2.get(j))<((range*3 )-(min*2))){
                      freq3++;
                     }
                    }
                    }
                    for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                       temp3=range*4 - (min*3);
                      if (data2.get(j)!="") {
                      if(Double.parseDouble(data2.get(j))>=((range*3)-(min*2)) && Double.parseDouble(data2.get(j))<((range*4)-(min*3))) {
                      freq4++;
                      }
                     }
                    }
                    for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                      if (data2.get(j)!="") {
                      if(Double.parseDouble(data2.get(j))>=((range*4)-(min*3)) && Double.parseDouble(data2.get(j)) <=((range*5)-(min*4))){
                     freq5++;
                      }
                     }
                    }
                  }
               }
             }
             toReturn =  "[" + start + ", " + temp4 + ") " + "[" + temp4 + ", " + temp1 + ") " + "[" + temp1 + ", " + temp2 + ") " + "[" + temp2 + ", " + temp3  + ") " + "[" + temp3 + ", " + end  + ") ";
             frequency = freq1 + " " + freq2 + " " + freq3 + " " + freq4 + " " + freq5 + " ";
           

           System.out.println("counter test: " + counter);

             return toReturn + "\n" + frequency ;
           }

    //public int getCounter(){

   //   return rowCounter;
   // }

     public String subsetColumn() {
       System.out.println("Enter column name operator (== < > !=) value!");
       String subsetInput=in.nextLine();
       String [] subsetInputArray=subsetInput.split(" ");
       int indexToStart =0;
       String output="";

       for (int i=0; i<columnHeaders.size(); i++) {
         if (columnHeaders.get(i).equals(subsetInputArray[0])) {
           indexToStart=i;
           if(dataTypes.get(i).equals("int")||dataTypes.get(i).equals("double")) {
            if (subsetInputArray[1].equals("<")) {
              for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                if (Double.parseDouble(data2.get(j))>Double.parseDouble(subsetInputArray[2])) {
                  data2.set(j, "");
                  output="";
                }
              }
            }
             if (subsetInputArray[1].equals(">")) {
               for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                if (Double.parseDouble(data2.get(j))<Double.parseDouble(subsetInputArray[2])) {
                  data2.set(j, "");
                  output="";
                }
              }
             }

             if (subsetInputArray[1].equals("!=")) {
               for(int j=indexToStart+(2*columnHeaders.size()); j<data2.size();j=j+columnHeaders.size()) {
                if (Double.parseDouble(data2.get(j))==Double.parseDouble(subsetInputArray[2])) {
                  data2.set(j, "");
                  output="";
                }
              }
             }
           }
         }
       }
      return "";
     }

 
  
}


















