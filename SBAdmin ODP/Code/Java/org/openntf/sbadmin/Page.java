package org.openntf.sbadmin;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = 3837279371280755344L;
	private String label;
	private String icon;
	private String target;
	private boolean dropdown;
	private boolean dropdownitem;
	private String unid;

	public Page(String label, String icon, String target, boolean isDropdown, boolean isDropdownItem, String unid) {
		this.label = label;
		this.icon = icon;
		this.target = target.equals("") ? "#" : target;
		this.dropdown = isDropdown;
		this.dropdownitem = isDropdownItem;
		this.unid = unid;
	}

	public String getLabel() {
		return label;
	}

	public String getIcon() {
		return icon;
	}

	public String getTarget() {
		return target;
	}

	public boolean isDropdown() {
		return dropdown;
	}

	public boolean isDropdownitem() {
		return dropdownitem;
	}

	public String getUnid() {
		return unid;
	}

}
