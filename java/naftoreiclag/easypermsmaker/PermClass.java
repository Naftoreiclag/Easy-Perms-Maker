package naftoreiclag.easypermsmaker;

import java.util.ArrayList;
import java.util.List;

public class PermClass
{
	protected String id;
	protected List<PermClass> inheritsFrom = new ArrayList<PermClass>();
	
	protected int x;
	protected int y;
	
	protected PermClass(String id)
	{
		this.id = id;
	}
}
