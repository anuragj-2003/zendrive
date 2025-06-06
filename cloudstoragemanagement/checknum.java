class checknum
{
	public boolean onlyDigits(String str)
    {
    	boolean flag=false;
       
        for (int i = 0; i <str.length(); i++) {
  
            // Check if character is
            // digit from 0-9
            // then return true
            // else false
            if (str.charAt(i) >= 48
                && str.charAt(i) <= 57) {
                flag= true;
            }
            else {
                flag= false;
                break;
            }
        }
        return flag;
    }
    
    
    public static void main(String args[])
    {
    	 String str = "1234";
        int len = str.length();
  
        // Function Call
        System.out.println(new checknum().onlyDigits(str));
    }
}