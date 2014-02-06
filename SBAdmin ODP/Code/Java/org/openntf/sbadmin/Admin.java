package org.openntf.sbadmin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.ViewEntry;
import org.openntf.domino.ViewNavigator;
import org.openntf.domino.impl.Session;
import org.openntf.domino.utils.XSPUtil;

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
			Session session = (Session) XSPUtil.getCurrentSession();
			Database db = session.getCurrentDatabase();
			ViewNavigator col = db.getView("pages").createViewNav();
			ViewEntry ent = col.getFirst();
			ViewEntry tmp;
			Document doc = null;
			while (ent != null) {
				tmp = col.getNext(ent);
				doc = ent.getDocument();
				isDropdown = doc.getResponses().getCount() > 0;
				this.navigation.add(new Page(doc.getItemValueString("pageLabel"), doc.getItemValueString("pageIcon"), doc.getItemValueString("pageTarget"), isDropdown, doc.isResponse(), doc
						.getUniversalID()));

				ent = tmp;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<Page> getNavigation() {
		return this.navigation;

	}

}
