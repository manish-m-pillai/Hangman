import java.io.*;
import java.util.*;
public class Hangman 
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int choice=0;
        String choic="YES";
        String Design="*********************************************************************************************";
        int t;
        int size;
        String temp="";
        String FileName="";
        boolean EOF;
        while((choic.equalsIgnoreCase("YES"))||(choic.equalsIgnoreCase("Y")))
        {
            t=0;
            size=0;
        try{
            System.out.println(Design);
            System.out.println("                                       HANGMAN");
            System.out.println(Design);
            System.out.println("Enter 1 for Country Name");
            System.out.println("Enter 2 for Fruits Name");
            System.out.println("Enter 3 for KPop Idols");
            System.out.println("Enter your Choice");
            choice=Integer.parseInt(in.readLine());
        }
        catch(Exception e)
        {
            System.out.println();
            System.out.println("You have Entered Wrong Statement");
            System.out.println("Please Enter it Again");
            continue;
        }
    String word[];
    switch(choice)
    {
        case 1:FileName="Data/Country.txt";t=1;break;
        case 2:FileName="Data/Fruits Name.txt";t=1;break;
        case 3:FileName="Data/KPop.txt";t=1;break;
        default:
        System.out.println();
        System.out.println("You have Entered Wrong Choice");
        System.out.println("Please Enter it Again");
        System.out.println();
    }
    if(t==1)
    {
        EOF=false;
        {
        FileReader fr = new FileReader(FileName);
        BufferedReader br = new BufferedReader(fr);
        while(!EOF)
        {
           temp=br.readLine();
           if(temp==null)
           {
            EOF=true;
           }
           else
           {
            size++;
           }
        }
        br.close();
        }
        {        
        FileReader fr = new FileReader(FileName);
        BufferedReader br = new BufferedReader(fr);
        word=new String[size];
        for(int i=0;i<size;i++)
        word[i]=br.readLine().toUpperCase();
        br.close();
        }
        FileReader fr = new FileReader("Data/Number in Words.txt");
        BufferedReader br = new BufferedReader(fr);
        String NIW[] = new String[31];
        for(int i=0;i<31;i++)
        {
            NIW[i]=br.readLine().toLowerCase();
        }
        br.close();
        int n=word.length;
        int i,j,pos,l;
        char ch;
        pos=r.nextInt(n);
        //pos=(int)(Math.random()*n);    This is the old line for random number generation
        String st="";
        for(i=0;i<word[pos].length();i++)
        {
            if(Character.isWhitespace(word[pos].charAt(i)))
            {}
            else
            {
                st=st+word[pos].charAt(i);
            }
        }
        String s="";
        String str="";
        String stri=" ";
        String strin="";
        String FGuess="";
        l=st.length();
        for(i=0;i<((l*2)-1);i++)
        {
            if(i%2==1)
            {
                strin=strin+" ";
            }
            else
            {
                strin=strin+st.charAt(i/2);
            }
        }
        for(i=0;i<((l*2));i++)
        {
            if(i%2==1)
            {
                str=str+" ";
            }
            else
            {
                str=str+"_";
            }
        }
        System.out.println(Design);
        System.out.println("                                       HANGMAN");
        System.out.println(Design);
        System.out.println("Find a "+l+" digit word ");
        System.out.println("You have only "+(l+2)+" Chances!!!!!!!!");
        System.out.println("For Words Containg 'and' enter & if you think there is 'and' present ");
        System.out.println();
        for(i=1;i<=l+2;i++)
        {
            System.out.println(NIW[i]+" Chance");
            System.out.println(str+"  [Characters Entered So Far:"+stri+"]");
            System.out.println("Enter the Character");
            ch=sc.next().charAt(0);
            ch=Character.toUpperCase(ch);
            if(i==1)
            {
                stri=stri+ch;
            }
            else
            {
                stri=stri+", "+ch;
            }
            System.out.println();
            s=str;
            str="";
            for(j=0;j<((l*2)-1);j++)
            {
                if(j%2==1)
                {
                    str=str+" ";
                }
                else
                {
                    if(ch==st.charAt(j/2))
                    {
                        str=str+ch;
                    }
                    else
                    {
                        if(Character.isLetterOrDigit(s.charAt(j)))
                        {
                            str=str+s.charAt(j);
                        }
                        else if(s.charAt(j)=='&')
                        {
                            str=str+s.charAt(j);
                        }
                        else
                        {
                            str=str+"_";
                        }
                    }
                }
            }
            s=str;
            if(s.equals(strin))
            {
                System.out.println(Design);
                System.out.println(s);
                System.out.println("Characters Entered =>"+stri);
                break;
            }
        }
        System.out.println();
        if(str.equals(strin))
        {
            System.out.println();
            System.out.println("*******************************CONGRATULATIONS************************************************");
            System.out.println("You have found out the word in " +i+" Steps!!!!!!!!!!!!!");
            System.out.println("The Word is => "+st);
        }
        else
        {
            System.out.println(Design);
            System.out.println("Since You Lost All the Chances!!!!!!");
            System.out.println("Final Chance!!!!!");
            System.out.println("Guess the Whole Word Withiut Dashes or Spaces");
            System.out.println("You Guessed till :- "+s);
            FGuess=sc.next().trim();
            if(FGuess.equalsIgnoreCase(st))
            {
                System.out.println("*******************************CONGRATULATIONS************************************************");
                System.out.println("You have found out the word in your Last Chance");
                System.out.println("The Word is => "+st);
            }
            else
            {
                System.out.println();
                System.out.println(Design);
                System.out.println("Your Chances are OVER !!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("The Word was => "+st);
                System.out.println("Better Luck Next Time");
            }
            
        }
    }
        if((choice>=1)&&(choice<=3))
        {
                System.out.println();
                System.out.println("Enter Y or Yes if you Want to Input Again");
                System.out.println("Enter any Other Button to Quit");
                choic=in.readLine();
        }
    }
        System.out.println(Design);
        System.out.println("Thank You for Playing");
        System.out.println("This Program was developed by Manish M. Pillai");
        System.out.println(Design);
        sc.close();
    }
}
// Country Hints ki line ki famous cheez