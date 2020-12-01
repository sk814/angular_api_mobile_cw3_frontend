package uk.ac.le.cs.CO3102;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.xerces.parsers.SAXParser;

class SAXDemoGrade extends DefaultHandler
{
	
	static float grades[][] = new float[100][4];
	int gi = -1;
	int nstudent = 0;
	public void startElement(String uri, String localName, String rawName,
	                         Attributes attributes)
	{
	   if(localName.equals("cw1")){
			gi = 0;
		}else if(localName.equals("project")){
			gi = 1;
		}else if(localName.equals("final")){
			gi = 2;
		} else if(localName.equals("student"))
			nstudent++;
	}	

   public static void main(String[] args){ try{
	   SAXDemoGrade SAXHandler = new SAXDemoGrade();
 		SAXParser parser = new SAXParser();
 		parser.setContentHandler(SAXHandler);
 		parser.setErrorHandler(SAXHandler);
 		parser.parse("student.xml");
	     }
		catch(Exception e){e.printStackTrace(System.err);}
   }   
   
   public void endElement(String uri, String localName, String rawName){
      gi = -1;
   }
   
   public void characters(char characters[], int start, int length)
   {
      String chData = (new String(characters, start, length)).trim();
      if(chData.indexOf("\n") < 0 && chData.length() > 0) {
         if(gi >= 0){
            grades[nstudent-1][gi] = Integer.parseInt(chData);
          //  System.out.println("["+(nstudent-1)+"]["+gi+"]="+ grades[nstudent-1][gi]);
         }
      }
   }

   public void endDocument()
   {
      float Ave = 0;
      int i = 0, j = 0;
      System.out.println("Grades");
      for(i = 0; i < nstudent ; i++){
         float total = 0;
         for(j = 0; j < 3; j++){
            total += grades[i][j];
         }		
         grades[i][3] = total/3;
         Ave += grades[i][3];
         System.out.println("Student " + i + "=" + grades[i][3]);
      }
      Ave /= nstudent;
      System.out.println("Class Average = " + Ave);
   }


   
}



