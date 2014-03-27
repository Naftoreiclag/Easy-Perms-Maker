package naftoreiclag.easypermsmaker;

import naftoreiclag.easypermsmaker.exportcode.AbstractExport;
import naftoreiclag.easypermsmaker.exportcode.BPermissions;

public class ExportCodeDatabase
{
	private static AbstractExport[] registeredTypes;
	
	protected static void registerTypes()
	{
		registeredTypes = new AbstractExport[]
		{
			new BPermissions(),
		};
	}
	
	public static String[] getComboBoxSelectionStuff()
	{
		String[] returnVal = new String[registeredTypes.length];
		
		for(int index = 0; index < registeredTypes.length; ++ index)
		{
			returnVal[index] = registeredTypes[index].name;
		}
		
		return returnVal;
	}
	
	public static AbstractExport[] getExportTypes()
	{
		return registeredTypes;
	}
}
