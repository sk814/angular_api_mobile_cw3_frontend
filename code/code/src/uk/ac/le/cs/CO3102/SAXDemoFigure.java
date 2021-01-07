package uk.ac.le.cs.CO3102;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.xerces.parsers.SAXParser;


public class SAXDemoFigure extends DefaultHandler{
    public void startElement(String uri, String localName, String rawName,
                             Attributes attributes)
    {
        if(localName.equals("circle"))
        {
           String sr = attributes.getValue("r");
           float radius = Float.valueOf(sr).floatValue();
           float area = (float)Math.PI*radius*radius;
           System.out.println("Circle : Radius = " + radius + " Area = " + area);
        }
        else if(localName.equals("rectangle"))
        {
           String sh = attributes.getValue("h");
           String sw = attributes.getValue("w");
           float width = Float.valueOf(sw).floatValue();
           float height = Float.valueOf(sh).floatValue();
           float area = width * height;
           System.out.println("Rectangle : Width = " + width +
                              " Height = " + height + " Area = " + area);
        }
        else if(localName.equals("ellipse"))
        {
           String sw = attributes.getValue("w");
           String sh = attributes.getValue("h");
           float width = Float.valueOf(sw).floatValue();
           float height = Float.valueOf(sh).floatValue();
           float area = (float)Math.PI*(width/2)*(height/2);
           System.out.println("Ellipse : Width = " + width + 
                              " Height = " + height + 
                              " Area = " + area);
        }


    }
    
    
    public static void main(String[] args)
    {
       try{
    	   SAXDemoFigure SAXHandler = new SAXDemoFigure();
          SAXParser parser = new SAXParser();
          parser.setContentHandler(SAXHandler);
          parser.setErrorHandler(SAXHandler);
          parser.parse("figures.xml");
       }
       catch(Exception e){
          e.printStackTrace(System.err);
       }
    }


    
}

