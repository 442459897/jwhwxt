/**
 * 
 */
package com.muran.util;

import java.util.List;

/**
 * @author wxz
 * 
 */
public class Data<T> {

	public Data() {
		// TODO Auto-generated constructor stub
	}

	private int pageIndex;
	private int pageSize;
	private int totalRecord;
	private int pageTotal;

	private List<T> data;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageTotal() {
		return (totalRecord - 1) / pageSize + 1;
	}
	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
