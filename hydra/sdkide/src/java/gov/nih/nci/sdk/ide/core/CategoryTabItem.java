package gov.nih.nci.sdk.ide.core;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public abstract class CategoryTabItem extends ActiveUI {
	public CategoryTabItem(TabFolder parent, int style, Object data, String title) {
		super(parent, style, data);
	}
	
	protected Composite initUIComposite() {
		Composite parent = getParent();
		Composite control = new Composite(parent, SWT.NONE);
		TabItem theTabItem = new TabItem((TabFolder)parent, SWT.NONE);
		theTabItem.setControl(control);
		
		return control;
	}
	
	protected GridData getGridData() {
		GridData gd = UIHelper.getFieldGridData();
		return gd;
	}
	
	protected Layout getLayout() {
		GridLayout layout = new GridLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		layout.verticalSpacing = 10;
		layout.horizontalSpacing = 10;
		return layout;
	}
}
