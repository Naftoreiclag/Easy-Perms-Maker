package naftoreiclag.easypermsmaker.exportcode;

public abstract class AbstractExport
{
	public final String name;
	
	public AbstractExport(String pluginVerison)
	{
		this.name = pluginVerison;
	}
	
	public abstract void export();
}
