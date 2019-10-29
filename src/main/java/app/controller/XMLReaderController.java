package app.controller;
import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.XMLReader;
import app.repository.XMLReaderRepository;


@RestController
@RequestMapping("/data")
public class XMLReaderController {

  @Autowired
  private XMLReaderRepository xmlReaderRepository;
  
  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createXmlData(@RequestBody Map<String, Object> xmlDataMap){
	  XMLReader xmlReader = new XMLReader(xmlDataMap.get("data").toString());
    
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "XML created successfully");
    response.put("book", xmlReaderRepository.save(xmlReader));
    return response;
  }
  
  @RequestMapping(method = RequestMethod.GET, value="/{xmlId}")
  public XMLReader getxmlDataDetails(@PathVariable("xmlId") String xmlId){
    return xmlReaderRepository.findOne(xmlId);
  }
  
  
  @RequestMapping(method = RequestMethod.GET)
  public Map<String, Object> getAllXML(){
    List<XMLReader> xmlData = xmlReaderRepository.findAll();
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("XMLReader Size", xmlData.size());
    response.put("xmlData", xmlData);
    return response;
  }
}
