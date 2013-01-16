/**
 * The content of this file is subject to the caAdapter Software License (the "License").  
 * A copy of the License is available at:
 * [caAdapter CVS home directory]\etc\license\caAdapter_license.txt. or at:
 * http://ncicb.nci.nih.gov/infrastructure/cacore_overview/caadapter/indexContent
 * /docs/caAdapter_License
 */


package gov.nih.nci.restgen.ui.properties;


/**
 * This class defines the controller to provide the UI selected item for its properties.
 *
 * @author Prakash Vinjamuri
 * @author Prakash Vinjamuri LAST UPDATE $Author:
 * @since     CMTS v1.0
 * @version    $Revision: 1.2 $
 * @date       $Date: 2013-01-11
 */
public interface PropertiesSwitchController
{
	DefaultPropertiesPage getPropertiesPage();

	void setPropertiesPage(DefaultPropertiesPage newProperitesView);

	/**
	 * This functions will return an array of PropertyDescriptor that would
	 * help Properties GUI to figure out what column information would be
	 * displayed in the View.
	 */
	PropertiesResult getPropertyDescriptors();

	Object getSelectedItem();
	public void setSelectedItem(Object newSelectedItem);
	
	String getTitleOfPropertiesPage();
}

/**
 * HISTORY      : $Log: not supported by cvs2svn $
 * HISTORY      : Revision 1.1  2008/12/29 22:18:18  linc
 * HISTORY      : function UI added.
 * HISTORY      :
 */