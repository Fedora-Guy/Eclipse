
import java.util.Scanner;

// required - must use this class at least once
// When instantiating this object within your game, the lock will initially be locked.
// You will give it the combination and optionally a hint (via constructors).
// Call the unlock() method when the player is trying to unlock it.
//   This will prompt them to enter the combination (and the hint if you have provided one).
//   You do not need to prompt yourself.  This will take care of prompting and possibly unlocking if the combination is correct.
// Use the method isUnlocked() to check the status of the lock.

public class CombinationLock
{
    private String combination,hint;
    private boolean openFlag;
    
    // Constructor
    // The combination is required when creating this object
    // Using this constructor will leave the hint blank.
    // If you want to use the hint, use the other constructor.
    public CombinationLock(String argCombination)
    {
        // Set the combination.
        combination = argCombination;
        
        // Set the hint
        hint = "";
        
        // This starts out being locked.
        openFlag = false;
    } // end constructor
    // The combination is required when creating this object
    // The hint is also required.  This can be something like the format for what should be entered.
    //    For example:  (format: ##-##-##)
    //    If you don't want to use the hint, use the other constructor.
    public CombinationLock(String argCombination, String argHint)
    {
        // Set the combination.
        combination = argCombination;
        
        // Set the hint
        hint = argHint;
        
        // This starts out being locked.
        openFlag = false;
    } // end constructor
    
    // This method will prompt the player for the combination and possibly unlock the combination lock.
    // It will return true if successful, false if not.
    public boolean unlock()
    {
        // If the lock is already open, nothing should be done.
        if (openFlag) return openFlag;
        
        // Prompt the player for the combination
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the combination " + hint + ":  ");
        String enteredCombination = in.nextLine();
        
        // Check if the combination is correct
        if (enteredCombination.equals(combination))
        {
            // The combination is correct.
            openFlag = true;
        }
        
        // Return the status of the lock.
        return openFlag;
    } // end unlock
    
    // This method will return the status of the lock.
    // TRUE if unlocked, FALSE if locked.
    public boolean isUnlocked()
    {
        return openFlag;
    } // end isUnlocked
} // end class CombinationLock