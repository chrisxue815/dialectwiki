package org.chris;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProvinceCity
{
  public static void main(String[] args)
  {
    generateHTML();
  }
  
  private static void generateHTML()
  {
    try
    {
      List<Province> provinces = getProvinces();
  
      PrintStream ps = new PrintStream("province-city.html");
      
      for (Province p : provinces)
      {
        ps.printf("<option value=\"%d\">%s</option>\n", p.getId(), p.getName());
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  private static void generateJavascript()
  {
    try
    {
      List<Province> provinces = getProvinces();

      PrintStream ps = new PrintStream("province-city.js");
      
      for (Province p : provinces)
      {
        ps.printf("city[%d] = new Array(\"%s\", \"", p.getId(), p.getName());
        
        List<City> cities = p.getCities();
        
        boolean first = true;
        
        for (City c : cities)
        {
          if (!first)
            ps.print('|');
          first = false;
          
          ps.printf("%d|%s", c.getId(), c.getName());
        }
        ps.println("\");");
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  private static void updateDatabase()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      
      String url = "jdbc:mysql://127.0.0.1:3306/dialectwiki";
      String user = "root";
      String password = "daseinmysq";
      
      Connection conn = DriverManager.getConnection(url, user, password);
      
      List<Province> provinces = getProvinces();
      
      for (Province p : provinces)
      {
        String insertProvince = "insert into dw_province values(?,?)";
        
        PreparedStatement stm = conn.prepareStatement(insertProvince);
        
        stm.setInt(1, p.getId());
        stm.setString(2, p.getName());
        
        stm.executeUpdate();
        
        List<City> cities = p.getCities();
        
        for (City c : cities)
        {
          String insertCity = "insert into dw_city values(?,?,?)";
          
          PreparedStatement stm2 = conn.prepareStatement(insertCity);
          
          stm2.setInt(1, c.getId());
          stm2.setString(2, c.getName());
          stm2.setInt(3, c.getProvince().getId());
          
          stm2.executeUpdate();
        }
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  private static List<Province> getProvinces()
  {
    List<Province> p = new ArrayList<Province>();
    
    try
    {
      DocumentBuilderFactory domFac = DocumentBuilderFactory.newInstance();
      DocumentBuilder domBuilder = domFac.newDocumentBuilder();
      InputStream is = new FileInputStream("province-city.xml");
      Document doc = domBuilder.parse(is);   
      
      Element root = doc.getDocumentElement();
      
      NodeList provinces = root.getChildNodes();
      
      int provinceCount = 1;
      int cityCount = 1;
      
      for (int i = 0; i < provinces.getLength(); i++)
      {
        Node provinceNode = provinces.item(i);
        
        if (provinceNode.getNodeType() == Node.ELEMENT_NODE)
        {
          int provinceId = provinceCount++;
          String provinceName = provinceNode.getAttributes().getNamedItem("name").getNodeValue();
          
          Province province = new Province(provinceId, provinceName);
          
          NodeList cities = provinces.item(i).getChildNodes();
          
          for (int j = 0; j < cities.getLength(); j++)
          {
            Node cityNode = cities.item(j);
            
            if (cityNode.getNodeType() == Node.ELEMENT_NODE)
            {
              int cityId = cityCount++;
              String cityName = cities.item(j).getAttributes().getNamedItem("name").getNodeValue();
              
              province.addCity(new City(cityId, cityName, province));
            }
          }
          
          p.add(province);
        }
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    
    return p;
  }
}