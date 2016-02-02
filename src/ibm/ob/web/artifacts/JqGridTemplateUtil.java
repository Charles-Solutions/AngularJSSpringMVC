package ibm.ob.web.artifacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.beans.support.SortDefinition;

/**
 * @author Alejandro Clavijo 
 * 
 */
public class JqGridTemplateUtil {

	
	public static <T> JqGridData<T> createJqGridData(List<T> values, JqGridParams params) {
		if (params.searchValues.size() > 0) {
			values = search(values, params.searchValues);
		}

		if(params.sidx != null && !params.sidx.equals(""))
		    sortColumn(values, params.sidx, params.sord);

		JqGridData<T> data = paginate(values, params.page, params.rows);

		return data;
	}

	private static <T> List<T> search(List<T> values, Map<String, Object> searchValues) {

		List<T> result = new ArrayList<T>();

		Set<String> searchFields = searchValues.keySet();

		for (T rowModel : values) {

			Map<String, Object> rowData = RowDataObjectProvider.getDataMap(rowModel);

			boolean accept = true;
			for (String columnName : searchFields) {

				String searchValue = searchValues.get(columnName).toString().toLowerCase();

				if (rowData.get(columnName) != null && !rowData.get(columnName).toString().toLowerCase().contains(searchValue)) {
					accept = false;
					break;
				}
				
				if(rowData.get(columnName) == null){
					accept = false;
					break;
				}			
			}

			if (accept)
				result.add(rowModel);
		}

		return result;
	}

	private static <T> void sortColumn(List<T> values, final String columnName,
			final String order) {

		SortDefinition sortDefinition = new MutableSortDefinition(columnName,
				true, order.equals("asc") ? true : false);

		PropertyComparator.sort(values, sortDefinition);

	}

	private static <T> JqGridData<T> paginate(List<T> values, int page, int rows) {
		int totalRegistros = values.size();

		if (rows > totalRegistros)
			rows = totalRegistros;

		int total = (int) Math.ceil((double) totalRegistros / (double) rows);
		int start = rows * (page - 1);
		int end = 0;

		int rest = rows > 0 ? totalRegistros % rows : 0;

		if (page == total && rest > 0)
			end = (start + rest);

		else
			end = start + rows;

		values = values.subList(start, end);

		JqGridData<T> data = new JqGridData<T>(values, total, page,
				totalRegistros);

		return data;
	}

}
