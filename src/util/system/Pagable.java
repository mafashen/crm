package util.system;

/** 分页工具 */
public class Pagable {
	
	int		page;//当前页
	int		rows;//每页总数
	String	sort;
	String	order;
	int		totalPages;//总页数
	int 	total;//总记录数
	
	public Pagable( ) {
		page = 1;
		rows = 5;
	}
	
	public Pagable( int page , int rows ) {
		super();
		this.page = page;
		this.rows = rows;
	}
	
	public int getPage( ) {
		return page;
	}
	
	public void setPage( int page ) {
		this.page = page;
	}
	
	public int getRows( ) {
		return rows;
	}
	
	public void setRows( int rows ) {
		this.rows = rows;
	}
	
	public int getTotalPages( ) {
		return totalPages;
	}
	
	public void setTotalPages( int totalPages ) {
		this.totalPages = totalPages;
	}
	
	public String getSort( ) {
		return sort;
	}
	
	public void setSort( String sort ) {
		this.sort = sort;
	}
	
	public String getOrder( ) {
		return order;
	}
	
	public void setOrder( String order ) {
		this.order = order;
	}

	public int getTotal( ) {
		return total;
	}

	public void setTotal( int total ) {
		this.total = total;
		int pages = this.getTotal() % this.getRows() == 0 ? (this.getTotal() / this.getRows())
				: (this.getTotal() / this.getRows() + 1);
		System.out.println("总数 : "+ total +"总页数: " + pages + "  当前页:" + getPage() + " 每页显示:"+getRows());
		setTotalPages(pages);
	}
	
}
