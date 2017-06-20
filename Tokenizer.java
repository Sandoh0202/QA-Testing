import java.io.*;
class Tokenizer
{
	public void tokenize(String str)
	{
		String tokens[]=new String[str.length()];
		str+=' ';String temp="";
		int l=str.length(),i,c=0;
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
		tokens[c]="~";
	}
	public static void main(String args[])
	{
		Tokenizer o=new Tokenizer();
		o.tokenize();
	}
}