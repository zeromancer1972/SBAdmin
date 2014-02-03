package org.openntf.sbadmin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lotus.domino.Document;
import lotus.domino.ViewEntry;
import lotus.domino.ViewNavigator;

import com.ibm.xsp.extlib.util.ExtLibUtil;

public class Admin implements Serializable {

	private static final long serialVersionUID = -2237759144681903315L;
	private List<Page> navigation;

	public Admin() {
		initNavigationFromDocuments();
	}

	private void initNavigationFromDocuments() {
		this.navigation = new ArrayList<Page>();
		boolean isDropdown = false;
		try {
			ViewNavigator col = ExtLibUtil.getCurrentDatabase().getView("pages").createViewNav();
			ViewEntry ent = col.getFirst();
			ViewEntry tmp;
			Document doc = null;
			while (ent != null) {
				tmp = col.getNext(ent);
				doc = ent.getDocument();
				isDropdown = doc.getResponses().getCount() > 0;
				this.navigation.add(new Page(doc.getItemValueString("pageLabel"), doc.getItemValueString("pageIcon"), doc.getItemValueString("pageTarget"), isDropdown, doc.isResponse(), doc
						.getUniversalID()));
				ent.recycle();
				ent = tmp;
			}
			col.recycle();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Page> getNavigation() {
		return this.navigation;

	}

}
