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
		//System.out.println("ValueChangeEvent:设置视图的Locale属性");
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
			item0.setItemLabel("软件工程");
			subtypeListBox.getChildren().add(0, item0);
			UISelectItem item1 = new UISelectItem();
			item1.setItemValue(1);
			item1.setItemLabel("算法分析");
			subtypeListBox.getChildren().add(1, item1);
			
			books.put("软件工程", 0);
			books.put("算法分析", 1);
		
			
			break;

		default:
			UISelectItem item2 = new UISelectItem();
			item2.setItemValue(0);
			item2.setItemLabel("其它11");
			books.put("其它11", 0);
			int cc = subtypeListBox.getChildren().size();
			subtypeListBox.getChildren().add(0, item2);			
			break;
		}
		
		ctx.renderResponse();
		//System.out.println("调用：renderResponse()");
		
		
	}


	public void changeType1(ValueChangeEvent e)
	{
		books.clear();
		
		String newValue = (String) e.getNewValue();
		int selected = Integer.parseInt(newValue);
		switch (selected) {
		case 0:
			books.put("软件工程", 0);
			books.put("算法分析", 1);
			break;
		default:
			books.put("其它11", 0);
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
