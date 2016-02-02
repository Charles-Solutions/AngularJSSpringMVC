package ibm.ob.web.artifacts;

import java.util.Map;

public class JqGridParams {

	public int page; 
	
	public int rows;	
	
	public String sidx; 
	
	public String sord; 
	
    public Map<String, Object> searchValues;

	
	public JqGridParams(int page, int rows, String sidx, String sord, Map<String, Object> searchValues) {
		super();
		this.page = page;
		this.rows = rows;
		this.sidx = sidx;
		this.sord = sord;
		this.searchValues = searchValues;
	}	
}
