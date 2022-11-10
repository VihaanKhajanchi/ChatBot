import java.util.Scanner;

class Main {
  public static void main(String[] args)
    {
        Magpie4 maggie = new Magpie4();
        Trivia triv=new Trivia();
        System.out.println (maggie.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        if (statement.equals("trivia")){
          triv.start();
        }
        while (!statement.equals("Bye")&&!statement.equals("trivia"))
        {
            System.out.println (maggie.getResponse(statement));
            statement = in.nextLine();
        }
    }
}
