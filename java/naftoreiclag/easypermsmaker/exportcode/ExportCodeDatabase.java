package naftoreiclag.easypermsmaker.exportcode;

public class ExportCodeDatabase
{
	private static AbstractExportType[] registeredTypes;
	
	public static void registerTypes()
	{
		registeredTypes = new AbstractExportType[]
		{
			new BPermissions(),
		};
	}
	
	public static AbstractExportType[] getExportTypes()
	{
		return registeredTypes;
	}
}
