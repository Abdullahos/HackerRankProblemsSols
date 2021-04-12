import java.io.*;
import java.lang.reflect.*;
import java.util.*;
//java varages
class Add {
    public void add(int ...pars){
        int sum = 0;
        for(int i = 0; i <pars.length; i++){
            System.out.print(pars[i]);
            //print + if only it's not the last number
            if(i+1<pars.length) System.out.print("+");
            //acc sum
            sum = sum + pars[i];
        }
        System.out.println("="+sum);
    }
}


public class JavaVarargs {

    public static void main(String[] args) {
       try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			int n6=Integer.parseInt(br.readLine());
			Add ob=new Add();
			ob.add(n1,n2);
			ob.add(n1,n2,n3);
			ob.add(n1,n2,n3,n4,n5);	
			ob.add(n1,n2,n3,n4,n5,n6);
			
			//to check if there's overloading
			//get the declared methodes only inside the class
			Method[] methods=Add.class.getDeclaredMethods();
			Set<String> set=new HashSet<>();
			boolean overload=false;
			for(int i=0;i<methods.length;i++)
			{
				if(set.contains(methods[i].getName()))
				{
					overload=true;
					break;
				}
				set.add(methods[i].getName());
				
			}
			if(overload)
			{
				throw new Exception("Overloading not allowed");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}

