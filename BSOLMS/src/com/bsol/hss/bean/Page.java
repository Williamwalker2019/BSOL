package com.bsol.hss.bean;

import java.util.List;

public class Page {
	private int pagenum;//��ǰҳ��
	private int pagesize;//ҳ���С
	private List list;//ҳ������
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
