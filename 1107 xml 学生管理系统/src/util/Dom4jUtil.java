package util;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtil {
	private String path;

	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	
	public Document read() throws Exception {
		SAXReader reader = new SAXReader();
		Document document=reader.read(this.path);
		return document;
	}
	
	public void write(Document document) throws Exception{
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter writer=new XMLWriter(new FileOutputStream(this.path),format);
		writer.write(document);
		writer.close();
	}
	
}
