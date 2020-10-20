package com.yffd.jecap.admin.base.support.tree;

import java.util.List;

public interface Treeable<T> {
	
	Object getIdValue();

	Object getPidValue();
	
	List<T> getChildren();
	
	void setChildren(List<T> children);
	
}

