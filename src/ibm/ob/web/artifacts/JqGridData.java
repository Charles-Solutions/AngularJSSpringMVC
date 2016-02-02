package ibm.ob.web.artifacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class JqGridData<Obj>  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int total;
	
	private int page;
	
	private int records;
	
	public static boolean repeatItems = false;
	
	private List<Obj> rows =new ArrayList<Obj>();
	
	
	public JqGridData() {
		// TODO Auto-generated constructor stub
	}	
	
	
	public JqGridData(List<Obj> rows, int total, int page, int records) {
		super();
		this.total = total;
		this.page = page;
		this.records = records;
		setRows(rows);
	
	}	

	public void addElement(Obj row){
		
		if(row != null){
			
			this.rows.add(row);
		}		
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public List<Obj> getRows() {
		return rows;
	}

	public void setRows(List<Obj> rows) {
		this.rows = rows;
	}
	

}
