package naftoreiclag.easypermsmaker;

import java.util.ArrayList;
import java.util.List;

public class PermData
{
	private static PermData instance;
	
	public static PermData getData()
	{
		if(instance == null)
		{
			instance = new PermData();
		}
		
		return instance;
	}
	
	protected List<PermClass> classes = new ArrayList<PermClass>();
}
