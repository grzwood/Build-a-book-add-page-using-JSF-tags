package javax.faces.biz;

import java.util.Vector;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("bookWriterConverter")
public class BookWriterConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		System.out.println("bookWriterConverter.toOBj");
		Vector<String> writers = new Vector<String>();
		String[] writers_array = arg2.split(",");
		for(int i = 0; i < writers_array.length;i++)
		{
			writers.add(i, writers_array[i]); 
		}
		return writers;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		System.out.println("bookWriterConverter.toSring");
		String writers = "";
		Vector<String> writers_vector = (Vector<String>) arg2;
		for(int i = 0; i < writers_vector.size(); i++)
			writers = writers + writers_vector.get(i);
		return writers;
	}

}
