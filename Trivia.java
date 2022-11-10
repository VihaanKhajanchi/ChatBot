import java.lang.Math;
import java.util.Scanner;
public class Trivia {
  public void start(){
    String[] quotes= new String[]{"Boy! Don't Be Sorry, Be Better."," Give yourself time. Ideas'll come. Life'll shake you, roll you, maybe embrace you.","I wanna be a great plumber like my brother Mario.","Never accept the world as it appears to be, dare to see it for what it could be.","There Is No Book Or Teacher To Give You The Answers, Show You The Path.","Some trees flourish, others die. Some cattle grow strong, others are taken by wolves. Some men are born rich enough and dumb enough to enjoy their lives. Ain't nothing fair. You know that.","B: You want to know something funny? Even after everything you've done, I would have saved you. J: Actually that is pretty funny.","Hatred and prejudice will never be eradicated. And the witch hunts will never be about witches. To have a scapegoat, that's the key.","A sword wields no strength unless the hands that holds it has courage.","You do what you think is best, Doc. It’s all any of us can… even when it hurts like Hell."};
    String answer0="kratos";
    String answer1="johnny silverhand";
    String answer2="luigi";
    String answer3="winston";
    String answer4="ezio";
    String answer5="marston";
    String answer6="batman";
    String answer7="geralt";
    String answer8="zelda";
    String answer9="spiderman";
    int index=(int)(Math.random()*10);
    System.out.println(quotes[index]+" ------ Which video game character said this quote?");
    Scanner input = new Scanner (System.in);
    String inp = input.nextLine();
    if (inp.contains(answer0)&&index==0){
      System.out.print("Correct!");
    } else if (inp.contains(answer1)&&index==1){
      System.out.print("Correct!");
    }else if (inp.contains(answer2)&&index==2){
      System.out.print("Correct!");
    }else if (inp.contains(answer3)&&index==3){
      System.out.print("Correct!");
    }else if (inp.contains(answer4)&&index==4){
      System.out.print("Correct!");
    }else if (inp.contains(answer5)&&index==5){
      System.out.print("Correct!");
    }else if (inp.contains(answer6)&&index==6){
      System.out.print("Correct!");
    }else if (inp.contains(answer7)&&index==7){
      System.out.print("Correct!");
    }else if (inp.contains(answer8)&&index==8){
      System.out.print("Correct!");
    }else if (inp.contains(answer9) && index==9){
      System.out.print("Correct!");
    } else {
      System.out.print(index+inp);
      
    }
  }
    








  
}