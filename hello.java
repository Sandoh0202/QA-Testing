import java . util . * ;
import java . io . * ;
class hello
{
	public static void main ( String args [ ] ) throws IOException
	{
		Scanner in = new Scanner ( System . in ) ;
		String str = in . next ( ) ;
		int i ;
		File f = new File ( str ) ;
		BufferedReader br = new BufferedReader ( new InputStreamReader ( new FileInputStream ( f ) ) ) ;
		str = br . readLine ( ) ;
		while ( str != null )
		{
			System . out . println ( str ) ;
			str = br . readLine ( ) ;
		}
	}
	static void alter ( String str )
	{
		System . out . println ( str ) ;
	}
}