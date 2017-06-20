import java.util.*;
class Occurrences
{
	public void occur()
	{
		int i,j,flag=0;
		for(i=0;;i++)
		{
			flag=0;
			if(var[i]=="~")
				break;
			if(var[i]=="")
				continue;
			for(j=i+1;;j++)
			{
				if(var[j]=="~")
					break;
				if(var[j]=="")
					continue;
				if(var[i]==var[j])
				{
					var[j]=="";
					flag=1;
				}
			}
			if(flag==1)
				var[i]="";
		}
		for(i=0;;i++)
		{
			flag=0;
			if(func[i]=="~")
				break;
			if(func[i]=="")
				continue;
			for(j=i+1;;j++)
			{
				if(func[j]=="~")
					break;
				if(func[j]=="")
					continue;
				if(func[i]==func[j])
				{
					func[j]=="";
					flag=1;
				}
			}
			if(flag==1)
				func[i]="";
		}
		System.out.println("Unused Variables -");
		for(i=0;;i++)
		{
			if(var[i]=="~")
				break;
			if(var[i]==="")
				continue;
			System.out.println(var[i]);
		}
		System.out.println("Unused Functions -")
		for(i=0;;i++)
		{
			if(func[i]=="~")
				break;
			if(func[i]==="")
				continue;
			System.out.println(func[i]);
		}
	}
	public static void main(String args[])
	{
		Occurrences o=new Occurrences();
		o.occur();
	}
}