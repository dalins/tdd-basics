import java.util.ArrayList;
import java.util.List;

public class BowlingGame
{
    List<Integer> frames = new ArrayList<>();
    BowlingGame()
    {
        frames.add(0);
    }
    
    public void roll(int knockedDownPins) {
        final int i = frames.size() - 1;

        final int currentFrame = frames.get(i);
        if(10 < currentFrame + knockedDownPins)
        {
            throw new IllegalArgumentException("Shit");
        }
        else
        {
            frames.set(i, currentFrame + knockedDownPins);
            if(currentFrame != 0)
            {
                frames.add(0);
            }
        }
    }

    public int score() {
        int score = 0;

        for( Integer frame : frames)
        {
            score += frame;
        }
        
        return score;
    }
}