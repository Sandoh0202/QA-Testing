import java.io.*;
class DumpReader
{
	public static void main(String args[])throws IOException
	{
		File f=new File("hello.java");
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		//PrintWriter pw=new PrintWriter(new FileOutputStream(f),true);
		String str=br.readLine();
		while(str!=null)
		{
			str=str.trim();
			System.out.println(str);		//Send wherever you want to.
			str=br.readLine();
		}
	}
}