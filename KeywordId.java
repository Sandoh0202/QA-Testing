import java.util.*;
class KeywordId
{
	public boolean keyword(String str)
	{
		String keywords[]={"int","double","public","static","void","String","Scanner","BufferedReader","InputStreamReader","File","for","if","else","break","import","class"};
		String others[]={"length","charAt","main","args"};
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
	}
	public static void main(String args[])
	{
		KeywordId o=new KeywordId();
		o.keyword();
	}
}