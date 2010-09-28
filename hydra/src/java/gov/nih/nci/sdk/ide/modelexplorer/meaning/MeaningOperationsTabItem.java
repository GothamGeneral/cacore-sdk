package gov.nih.nci.sdk.ide.modelexplorer.meaning;

import gov.nih.nci.sdk.ide.core.CategoryTabItem;
import gov.nih.nci.sdk.ide.core.UIHelper;
import gov.nih.nci.sdk.ide.modelexplorer.Constants;
import gov.nih.nci.sdk.ide.modelexplorer.ModelSelectionEvent;
import gov.nih.nci.sdk.ide.modelexplorer.SDKModelExplorerUtil;
import gov.nih.nci.sdk.ide.modelexplorer.SDKUIManager;
import gov.nih.nci.sdk.util.SDKUtil;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Text;

public class MeaningOperationsTabItem extends CategoryTabItem {
	private Text nameText;
	private Text descriptionText;
	private List conceptList;
	private Text typeText;
	private List parameterList;

	public MeaningOperationsTabItem(TabFolder parent, int style, Object data) {
		super(parent, style, data, Constants.TAB_Operations);
		SDKUIManager.getInstance().registerAsListener(Constants.MEANING_OPERATION_SELECTION_EVENT, this);
	}
	
	private static EList<EOperation> getEOperations(ModelSelectionEvent event) {
		if (event == null) return null;
		EClass eClass = SDKUIManager.getInstance().getEClass(event.getFullModelName());	
		return (eClass != null)?eClass.getEOperations():null;
	}

	@Override
	public void paint() {
		String domainName = SDKModelExplorerUtil.getDomainName((ModelSelectionEvent)this.getData());
		domainName = (UIHelper.isEmpty(domainName)) ? ((ModelSelectionEvent)this.getData()).getModelName() : domainName;

		final EList<EOperation> eOperationList = getEOperations((ModelSelectionEvent)this.getData());
		
		Composite composite = super.getUIComposite();

		Group detailsGroup = new Group(composite, SWT.SHADOW_OUT);
		detailsGroup.setText(domainName + " Operation Info");
		detailsGroup.setLayout(UIHelper.getTwoColumnLayout());
		detailsGroup.setLayoutData(UIHelper.getCoverAllGridData());
		UIHelper.setWhiteBackground(detailsGroup);
		
		Label nameLabel = new Label(detailsGroup, SWT.NONE);
		nameLabel.setText("Name");
		UIHelper.setWhiteBackground(nameLabel);
		nameText = new Text(detailsGroup, SWT.BORDER | SWT.READ_ONLY);
		nameText.setLayoutData(UIHelper.getCoverAllGridData());
		UIHelper.setWhiteBackground(nameText);

		Label descLabel = new Label(detailsGroup, SWT.NONE);
		descLabel.setText("Description");
		UIHelper.setWhiteBackground(descLabel);
		descriptionText = new Text(detailsGroup, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
		descriptionText.setLayoutData(UIHelper.getCoverAllGridData());
		UIHelper.setWhiteBackground(descriptionText);
		
		Label conceptsLabel = new Label(detailsGroup, SWT.NONE);
		conceptsLabel.setText("Concept");
		UIHelper.setWhiteBackground(conceptsLabel);
		conceptList = new List(detailsGroup, SWT.NONE);
		conceptList.setLayoutData(UIHelper.getCoverAllGridData());
		UIHelper.setWhiteBackground(conceptList);

		Label typeLabel = new Label(detailsGroup, SWT.NONE);
		typeLabel.setText("Return Type");
		UIHelper.setWhiteBackground(typeLabel);
		typeText = new Text(detailsGroup, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
		typeText.setLayoutData(UIHelper.getCoverAllGridData());
		UIHelper.setWhiteBackground(typeText);
		
		Label paramsLabel = new Label(detailsGroup, SWT.NONE);
		paramsLabel.setText("Parameters");
		UIHelper.setWhiteBackground(paramsLabel);
		parameterList = new List(detailsGroup, SWT.NONE);
		parameterList.setLayoutData(UIHelper.getCoverAllGridData());
		UIHelper.setWhiteBackground(parameterList);
		
		

		Group listGroup = new Group(composite, SWT.SHADOW_OUT);
		listGroup.setText("has operations ...");
		listGroup.setLayout(UIHelper.getOneColumnLayout());
		listGroup.setLayoutData(UIHelper.getCoverAllGridData());
		UIHelper.setWhiteBackground(listGroup);
		
		final List list = new List(listGroup, SWT.NONE);
		list.addListener (SWT.Selection, new Listener() {
			public void handleEvent (Event event) {
				int[] selection = list.getSelectionIndices();
				EOperation selected = eOperationList.get(selection[0]);
				MeaningOperationSelectionEvent eve = new MeaningOperationSelectionEvent(selected);
				SDKUIManager.getInstance().publishEvent(Constants.MEANING_OPERATION_SELECTION_EVENT, eve);
			}
		});
		
		if (eOperationList != null && eOperationList.isEmpty() == false) {
			for (EOperation eOperation : eOperationList) {
				list.add(eOperation.getName());
			}
			
			EOperation selected = eOperationList.get(0);
			MeaningOperationSelectionEvent event = new MeaningOperationSelectionEvent(selected);
			SDKUIManager.getInstance().publishEvent(Constants.MEANING_OPERATION_SELECTION_EVENT, event);
		}
		else {
			list.add("No Operations.");
		}
		
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
	
	@Override
	public void handleEvent(Event event) {
		if (event == null) return;
		
		if (event instanceof MeaningOperationSelectionEvent) {
			_paint((MeaningOperationSelectionEvent)event);
		}
	}
	
	private void _paint(MeaningOperationSelectionEvent event) {	
		EOperation selected = event.getEOperation();
		if (selected != null) {
			nameText.setText(selected.getName());

			String attributeDescription = SDKUtil.getTagValue(selected, "oper.mea.desc");
			attributeDescription = (UIHelper.isEmpty(attributeDescription)) ? "No operation description found" : attributeDescription;
			descriptionText.setText(attributeDescription);
			
			conceptList.removeAll();
			java.util.List<String> concepts = getConcepts(event);
			if (concepts == null || concepts.isEmpty() == true) {
				conceptList.add("This operation has no concepts");
			}
			else {
				for (String concept: concepts) {
					conceptList.add(concept);
				}
			}
			
			String type = (selected.getEType() != null) ? selected.getEType().getName() : "";
			typeText.setText(type);
			
			java.util.List<EParameter> eParameterList = selected.getEParameters();
			for (EParameter eParameter: eParameterList) {
				String parameterType = (eParameter.getEType() != null) ? eParameter.getEType().getName() : "";
				String item = eParameter.getName() + ":" + parameterType;
				System.out.println("Adding " + item);
				parameterList.add(item);
			}
			
			if (eParameterList.isEmpty() == true) {
				parameterList.add("This operation has no parameters");
			}
		}

		super.getUIComposite().redraw();
	}
	
	private static java.util.List<String> getConcepts(MeaningOperationSelectionEvent event) {
		java.util.List<String> concepts = new ArrayList<String>();
		if (event == null) return concepts;
		EOperation selected = event.getEOperation();
		String value = SDKUtil.getTagValue(selected, "oper.mea.concept");
		value = (value == null)?"":value;
		value = "http://nci.nih.gov/" + selected.getName();
		concepts.add(value);
		return concepts;
	}
	
	class MeaningOperationSelectionEvent extends Event {
		private EOperation eOperation;
		private Date timestamp;
		
		public MeaningOperationSelectionEvent(EOperation eOperation) {
			this.eOperation = eOperation;
			this.timestamp = new Date();
			super.data = eOperation;
			super.type = Constants.MEANING_OPERATION_SELECTION_EVENT;
		}

		public EOperation getEOperation() {
			return eOperation;
		}
		
		public Date getTimestamp() {
			return timestamp;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("timestamp=").append(timestamp).append(", ");
			sb.append("eOperation=").append(eOperation);
			return sb.toString();
		}
	}
}