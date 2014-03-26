package naftoreiclag.easypermsmaker.exportcode;

public abstract class AbstractExportType
{
	public final String name;
	
	public AbstractExportType(String pluginVerison)
	{
		this.name = pluginVerison;
	}
	
	public abstract void export();
}
