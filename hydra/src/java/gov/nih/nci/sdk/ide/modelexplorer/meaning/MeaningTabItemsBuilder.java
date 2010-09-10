package gov.nih.nci.sdk.ide.modelexplorer.meaning;

import gov.nih.nci.sdk.ide.core.CategoryTabItem;
import gov.nih.nci.sdk.ide.core.TabItemsBuilder;
import gov.nih.nci.sdk.ide.core.TabItemsBuilderImpl;
import gov.nih.nci.sdk.ide.core.UIHelper;
import gov.nih.nci.sdk.ide.modelexplorer.Constants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.TabFolder;

public class MeaningTabItemsBuilder extends TabItemsBuilderImpl implements TabItemsBuilder {
	public List<CategoryTabItem> buildTabs(TabFolder parent, int style, Object data) {
		UIHelper.cleanTabs(parent);
		
		List<CategoryTabItem> tabs = new ArrayList<CategoryTabItem>(Constants.meaningTabs.length);
		tabs.add(new MeaningDomainTabItm(parent, style, data));
		tabs.add(new MeaningPropertiesTabItm(parent, style, data));
		tabs.add(new MeaningOperationsTabItm(parent, style, data));
		tabs.add(new MeaningRelationshipTabItm(parent, style, data));
		
		super.activate(tabs);
		
		return tabs;
	}
}