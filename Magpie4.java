/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *         Uses advanced search for keywords 
 *</li><li>
 *         Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */

public class Magpie4
{
    /**
     * Get a default greeting     
     * @return a greeting
     */    
    public String getGreeting()
    {
        return "Hello, let's talk about video games.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
  private void setState(int currState){
    switch (currState) {
      case 1:
        System.out.println("I love that game! What do you like about it?");
        break;
      case 2:
        System.out.println("Say something, please.");
        break;
      case 3:
        System.out.println("That is a good genre. Which game do you like in it?");
        break;
      case 4:
        System.out.println("What genres do you enjoy?");
        break;
      case 5:
        likeGame();
        break;
      case 6:
        getRandomResponse();
        break;
      case 7:
        greeting();
        break;
      case 8:
        gameplay();
        break;
    }
    
    public String parseInput(String statement)
    {
        String response = "";
        int currState=0;
        if (statement.length() == 0)
        {
            currState=2;
        }
        else if (findKeyword(statement, "bad") >= 0)
        {
            currState=1;
        }
        else if (findKeyword(statement, "boring") >= 0)
        {
            currState=3;
        }
        else if (findKeyword(statement, "fun") >= 0)
        {
          currState=4;
  }
        else if (findKeyword(statement, "good") >= 0)
        {
            currState=5;
        }
        else if (findKeyword(statement, "first person") >= 0
                || findKeyword(statement, "fps") >= 0
                || findKeyword(statement, "third person") >= 0
                || findKeyword(statement, "action") >= 0
                || findKeyword(statement, "rpg") >= 0
                || findKeyword(statement, "role playing") >= 0
                || findKeyword(statement, "survival") >= 0
                || findKeyword(statement, "fighting") >= 0
                || findKeyword(statement, "battle royale") >= 0
                || findKeyword(statement, "platformer") >= 0)
        {
            currState=6;
        }        
        else if (findKeyword(statement, "mario") >= 0
                || findKeyword(statement, "cyberpunk") >= 0
                || findKeyword(statement, "overwatch") >= 0
                || findKeyword(statement, "valorant") >= 0
                || findKeyword(statement, "fortnite") >= 0
                || findKeyword(statement, "elden Ring") >= 0
                || findKeyword(statement, "god of war") >= 0
                || findKeyword(statement, "call of duty") >= 0
                || findKeyword(statement, "assassins creed") >= 0
                || findKeyword(statement, "zelda") >= 0
                || findKeyword(statement, "red dead") >= 0)
        {
            currState=7;
        }
        else if (findKeyword(statement, "graphics") >= 0
                || findKeyword(statement, "gameplay") >= 0
                || findKeyword(statement, "movement") >= 0
                || findKeyword(statement, "design") >= 0
                || findKeyword(statement, "map") >= 0
                || findKeyword(statement, "story") >= 0
                || findKeyword(statement, "character") >= 0
                || findKeyword(statement, "combat") >= 0)
        {
            currState=8;
        }
          else if (findKeyword(statement, "hi") >= 0
                || findKeyword(statement, "hello") >= 0
                || findKeyword(statement, "hey") >= 0
                || findKeyword(statement, "ok") >= 0)
        {
            response=greeting();
        }
            else if (findKeyword(statement, "yes") >= 0)
        {
            response = "Nice! Why do you say "+statement;
        }
              else if (findKeyword(statement, "no") >= 0)
        {
            response = "Aw man... Why do you say "+statement;
        }
                else if (findKeyword(statement, "not played") >= 0)
        {
            response = "You should try it!";
        }
                  else if (findKeyword(statement, "played") >= 0)
        {
            response = "Unfortunately not... have you?";
        }  else if (findKeyword(statement, "peach") >= 0)
        {
            response = "That's me!";
        } //QUOTES-------------------------------------
        else if (findKeyword(statement, "kratos") >= 0)
        {
            response = "Boy! Don't Be Sorry, Be Better.";
          
        } else if (findKeyword(statement, "silverhand") >= 0)
        {
            response = " Give yourself time. Ideas'll come. Life'll shake you, roll you, maybe embrace you.";
        }else if (findKeyword(statement, "luigi") >= 0)
        {
            response = "I wanna be a great plumber like my brother Mario.";
        }else if (findKeyword(statement, "winston") >= 0)
        {
            response = "Never accept the world as it appears to be, dare to see it for what it could be.";
        }else if (findKeyword(statement, "ezio") >= 0)
        {
            response = "There Is No Book Or Teacher To Give You The Answers, Show You The Path.";
        }else if (findKeyword(statement, "marston") >= 0)
        {
            response = "Some trees flourish, others die. Some cattle grow strong, others are taken by wolves. Some men are born rich enough and dumb enough to enjoy their lives. Ain't nothing fair. You know that.";
        }else if (findKeyword(statement, "batman") >= 0)
        {
            response = "B: You want to know something funny? Even after everything you've done, I would have saved you. J: Actually that is pretty funny.";
        }else if (findKeyword(statement, "witcher") >= 0)
        {
            response = "Hatred and prejudice will never be eradicated. And the witch hunts will never be about witches. To have a scapegoat, that's the key.";
        }else if (findKeyword(statement, "zelda") >= 0)
        {
            response = "A sword wields no strength unless the hands that holds it has courage.";
        }else if (findKeyword(statement, "spiderman") >= 0)
        {
            response = "You do what you think is best, Doc. It’s all any of us can… even when it hurts like Hell.";
        }
          
        // Responses which require transformations
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }

        else
        {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(statement, "you", 0);

            if (psn >= 0
                    && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement);
            }
            else
            {
                response = getRandomResponse(statement);
            }
        }
        return response;
    }
    
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

    
    
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
        
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
    

    
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        
        return -1;
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    


    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String greeting()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Hi. What are you playing right now?";
        }
        else if (whichResponse == 1)
        {
            response = "Hi there. Have you played Mario?";
        }
        else if (whichResponse == 2)
        {
            response = "Hello. What is your least favorite game?";
        }
        else if (whichResponse == 3)
        {
            response = "What's up! What genre of game do you like?";
        }

        return response;
    }
    private String getGenre()
        {
            final int NUMBER_OF_RESPONSES = 4;
            double r = Math.random();
            int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
            String response = "";
            
            if (whichResponse == 0)
            {
                response="I like that genre! Which game do you play in that genre?";
            } 
            else if (whichResponse == 1)
            {
                response = "I haven't tried that genre, is it fun?";
            }
            else if (whichResponse == 2)
            {
                response = "I'm not a fan...";
            }
            else if (whichResponse == 3)
            {
                response = "You should try Mario.";
            }
    
            return response;
}
  private String likeGame(String statement)
        {
            final int NUMBER_OF_RESPONSES = 4;
            double r = Math.random();
            int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
            String response = "";
            
            if (whichResponse == 0)
            {
              response="That's an amazing game! What do you like and dislike about it?";
            } 
            else if (whichResponse == 1)
            {
                response = "I haven't tried that game, is it fun?";
            }
            else if (whichResponse == 2)
            {
                response = "You have good taste.";
            }
            else if (whichResponse == 3)
            {
                response = "How are the graphics?";
            }
            return response;
}
    private String gameplay()
        {
            final int NUMBER_OF_RESPONSES = 4;
            double r = Math.random();
            int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
            String response = "";
            
            if (whichResponse == 0)
            {
                response="I agree!";
            } 
            else if (whichResponse == 1)
            {
                response = "What about it?";
            }
            else if (whichResponse == 2)
            {
                response = "I like that!";
            }
            else if (whichResponse == 3)
            {
                response = "Interesting. What else?";
            }
    
            return response;
}
    private String getRandomResponse(String statement)
        {
            final int NUMBER_OF_RESPONSES = 4;
            double r = Math.random();
            int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
            String response = "";
            
            if (whichResponse == 0)
            {
                response="Interesting, tell me more.";
            } 
            else if (whichResponse == 1)
            {
                response = "What do you mean "+statement+"?";
            }
            else if (whichResponse == 2)
            {
                response = "I like that!";
            }
            else if (whichResponse == 3)
            {
                response = "Do you play a lot of video games?";
            }
    
            return response;
}
}
