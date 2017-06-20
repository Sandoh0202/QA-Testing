import java.io.*;
import java.util.*;
class SubSystem1
{
	String func[]=new String[100];
	String var[]=new String[100];
	String tokens[]=new String[500];
	int c=0;
	public SubSystem1()
	{
		for(int i=0;i<500;i++)
			tokens[i]="";
	}
	public void tokenize(String str)
	{
		str+=' ';String temp="";
		int l=str.length(),i;
		for(i=0;i<l;i++)
		{
			if(str.charAt(i)!=' ')
				temp+=str.charAt(i);
			else
			{
				tokens[c++]=temp;
				temp="";
			}
		}
		//display(tokens);
	}
	public void recognise()
	{
		int f=0,i,v=0;
		for(i=0;;i++)
		{
			if(tokens[i]=="~")
				break;
			else
			{
				if(check(tokens[i])==true)
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
		//display(func);
		//display(var);
		occur();
	}
	public boolean check(String str)
	{
		if(str.length()==1)
		{
			char ch=str.charAt(0);
			if(ch==','||ch=='|'||ch==';'||ch=='('||ch==')'||ch=='{'||ch=='}'||ch=='['||ch==']'||ch=='\''||ch=='\"'||ch=='?')
				return true;
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='%')
				return true;
			else if(ch=='^'||ch=='~'||ch=='.')
				return true;
			else if(ch=='>'||ch=='<')
				return true;
			else if(ch=='=')
				return true;
			else
				return false;
		}
		else
		{
			if(str.equals("++")==true||str.equals("--")==true||str.equals("+=")==true||str.equals("-=")==true||str.equals("*=")==true||str.equals("/=")==true||str.equals("%=")==true)
				return true;
			else if(str.equals(">=")==true||str.equals("<=")==true||str.equals("==")==true||str.equals("!=")==true)
				return true;
			else if(str.equals("&&")==true||str.equals("||")==true)
				return true;
			else if(keyCheck(str)==true)
				return true;
			else
				return false;
		}
	}
	public boolean keyCheck(String str)
	{
		String keywords[]={"int","double","public","static","void","String","Scanner","BufferedReader","InputStreamReader","File","for","if","else","break","import","class","throws","while","new"};
		String others[]={"length","charAt","main","args","IOException","next","FileInputStream","println","System","readLine","java","io","util","null","in","out"};
		int i;
		for(i=0;i<keywords.length;i++)
		{
			if(str.equals(keywords[i])==true)
				return true;
		}
		for(i=0;i<others.length;i++)
		{
			if(str.equals(others[i])==true)
				return true;
		}
		return false;
	}
	/*public boolean keyword(String str)
	{
		int i;
		String keywords[]={"int","double","public","static","void","String","Scanner","BufferedReader","InputStreamReader","File","for","if","else","break","import","class","throws"};
		String others[]={"length","charAt","main","args","IOException"};
		for(i=0;i<16;i++)
		{
			if(str.equals(keywords[i])==true)
				return true;
		}
		for(i=0;i<4;i++)
		{
			if(str.equals(others[i])==true)
				return true;
		}
		return false;
	}*/
	public void reader()throws IOException
	{
		Scanner in=new Scanner(System.in);
		System.out.print("File Name: ");
		File f=new File(in.next());
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String str=br.readLine();
		while(str!=null)
		{
			str=str.trim();
			if(str.length()>5 && str.substring(0,5).equals("class")==false)		//Excluding class statement.
				tokenize(str);		//Send wherever you want to.
			str=br.readLine();
		}
		tokens[c]="~";
		recognise();
	}
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
				if(var[i].equals(var[j])==true)
				{
					var[j]="";
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
				if(func[i].equals(func[j])==true)
				{
					func[j]="";
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
			if(var[i]=="")
				continue;
			System.out.println(var[i]);
		}
		System.out.println("Unused Functions -");
		for(i=0;;i++)
		{
			if(func[i]=="~")
				break;
			if(func[i]=="")
				continue;
			System.out.println(func[i]);
		}
	}
	public void display(String arr[])
	{
		int i;
		for(i=0;;i++)
		{
			if(arr[i]==null)
				break;
			System.out.print(arr[i]+"  ");
		}
	}
	public static void main(String args[])throws IOException
	{
		SubSystem1 o=new SubSystem1();
		o.reader();
	}
}