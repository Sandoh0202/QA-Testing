import java.io.*;
class TokenRecogniser
{
	String func[]=new String[100];
	String var[]=new String[100];
	public void recognise(String tokens[])
	{
		int f=0,i,v=0;
		for(i=0;;i++)
		{
			if(tokens[i]=='~')
				break;
			else
			{
				if(keyword(tokens[i])==true)
					tokens[i]="";
				else
				{
					if(tokens[++i].equals("(")==true)
						func[f++]=tokens[i-1];
					else
						var[v++]=tokens[--i];
				}
			}
		}
		func[f]=var[v]="~";
	}
	public static void main(String args[])
	{
		TokenRecogniser o=new TokenRecogniser();
		o.recognise();
	}
}