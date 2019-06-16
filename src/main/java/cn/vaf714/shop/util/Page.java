package cn.vaf714.shop.util;

import java.util.List;

public class Page<T> {
	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", list=" + list
				+ ", pageSize=" + pageSize + ", totalItemNum=" + totalItemNum + ", totalPageNum=" + totalPageNum + "]";
	}

	private int pageNum;// 当前页码
	private int prevPage;// 上一页页码
	private int nextPage;// 下一页页码
	private List<T> list;// 本也需要显示的List
	private int pageSize = 10;// 每页显示多少条记录
	private long totalItemNum;// 总共有多少条记录
	private int totalPageNum;// 总页数

	/**
	 * 构造器，传入当前页数
	 * 
	 * @param pageNum
	 */
	public Page(int pageNum) {
		super();
		this.pageNum = pageNum;
	}

	public void setPageNum() {
		// 判断页码是否合法
		if (pageNum < 1) {
			pageNum = 1;
		}

		if (pageNum > getTotalPageNum() && pageNum != 1) {
			pageNum = getTotalPageNum();
		}
	}

	public void setPrevPage() {
		if (pageNum > 1) {
			this.prevPage = pageNum - 1;
		}else{
			this.prevPage = pageNum;
		}
	}

	public void setNextPage() {
		if (pageNum < totalPageNum) {
			this.nextPage = pageNum + 1;
		}else{
			this.nextPage = pageNum;
		}
	}
	
	public void setTotalItemNum(long totalItemNum) {
		this.totalItemNum = totalItemNum;//获取到总记录数
		setTotalPageNum();//计算总页码数
		setPageNum();//保证页码正确
		setNextPage();//下一页页码
		setPrevPage();//上一页页码
	}
	
	public void setTotalPageNum() {
		// 有余数则进一位
		totalPageNum = (int) ((totalItemNum % pageSize == 0) ? (totalItemNum / pageSize)
				: (totalItemNum / pageSize + 1));
	}

	public int getPageNum() {
		return pageNum;
	}

	
	public int getPrevPage() {
		return prevPage;
	}
	
	public int getNextPage() {
		return nextPage;
	}
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalItemNum() {
		return totalItemNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}
}
