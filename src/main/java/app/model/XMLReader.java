package app.model;

import org.springframework.data.annotation.Id;

public class XMLReader {

  @Id
  private String id;
  private String data;
  
  public XMLReader(){}
  
  public XMLReader(String data){
    this.data = data;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getData() {
    return data;
  }
  public void setData(String data) {
    this.data = data;
  }
    
}
