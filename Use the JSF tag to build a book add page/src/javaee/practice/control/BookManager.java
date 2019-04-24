package javaee.practice.control;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlSelectOneListbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;


@Named
@SessionScoped
public class BookManager implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,Integer> books;
	
	
	public BookManager(){
		this.books = new HashMap<String,Integer>();
	}
	
	

	public void changeType(ValueChangeEvent e)
	{
		//System.out.println("ValueChangeEvent:������ͼ��Locale����");
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		UIViewRoot root = ctx.getViewRoot();
		HtmlSelectOneListbox subtypeListBox =  (HtmlSelectOneListbox)root.findComponent("addbook:booksubtype");
		List<UIComponent> list =  subtypeListBox.getChildren();
		
		books.clear();
		
		int count = list.size();
		for(int i = 0; i < count; i++)
			list.remove(0);
		
		String newValue = (String) e.getNewValue();
		int selected = Integer.parseInt(newValue);
		switch (selected) {
		case 0:
			UISelectItem item0 = new UISelectItem();
			item0.setItemValue(0);
			item0.setItemLabel("�������");
			subtypeListBox.getChildren().add(0, item0);
			UISelectItem item1 = new UISelectItem();
			item1.setItemValue(1);
			item1.setItemLabel("�㷨����");
			subtypeListBox.getChildren().add(1, item1);
			
			books.put("�������", 0);
			books.put("�㷨����", 1);
		
			
			break;

		default:
			UISelectItem item2 = new UISelectItem();
			item2.setItemValue(0);
			item2.setItemLabel("����11");
			books.put("����11", 0);
			int cc = subtypeListBox.getChildren().size();
			subtypeListBox.getChildren().add(0, item2);			
			break;
		}
		
		ctx.renderResponse();
		//System.out.println("���ã�renderResponse()");
		
		
	}


	public void changeType1(ValueChangeEvent e)
	{
		books.clear();
		
		String newValue = (String) e.getNewValue();
		int selected = Integer.parseInt(newValue);
		switch (selected) {
		case 0:
			books.put("�������", 0);
			books.put("�㷨����", 1);
			break;
		default:
			books.put("����11", 0);
			break;
		}
	}


	public Map<String, Integer> getBooks() {
		return books;
	}



	public void setBooks(Map<String, Integer> books) {
		this.books = books;
	}

}
