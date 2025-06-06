class alphanum
{
	public static void main(String args[])
	{
		String s="AZadz23";
		alphanum a=new alphanum();
		System.out.println(a.check(s));
	}
	
	boolean check(String s)
	{
		boolean digit=false,alphabet=false;
		
		for (int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			int ascii=(int)c;
			System.out.println(ascii);
			if (ascii>=48 && ascii<=57)
			{
				digit=true;
			}
			else
			if ((ascii>=65 && ascii<=90) || (ascii>=97 && ascii<=122))
			{
				alphabet=true;	
			}
			
			if (digit && alphabet)
			break;
			
			
		}
		
		if (digit && alphabet)
			return true;
		else
		 return false;	
	}
}