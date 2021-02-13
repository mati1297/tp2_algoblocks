package algoblocks.engine;

import algoblocks.engine.action.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SequenceTest {

    @Test
    public void NewSequenceWithAnActionAndTheFirstIsThatAction(){
        Action action = new MoveUpAction();
        Sequence sequence = new Sequence(action);

        assertEquals(action, sequence.get(0));
    }

    @Test
    public void NewEmptySequenceAddsActionAndTheFirstIsThatAction(){
        Action action = new MoveUpAction();
        Sequence sequence = new Sequence();
        sequence.addAction(action);

        assertEquals(action, sequence.get(0));
    }

    @Test
    public void NewSequenceIsEmpty(){
        Sequence sequence = new Sequence();

        assertTrue(sequence.isEmpty());
    }

    @Test
    public void SequenceConcatenateAndIsTheSameThanAddingTwoAction(){
        Sequence firstSequence = new Sequence(new MoveUpAction());
        Sequence lastSequence = new Sequence(new MoveLeftAction());
        firstSequence.concatenate(lastSequence);

        Sequence sequence = new Sequence(new MoveUpAction());
        sequence.addAction(new MoveLeftAction());

        assertTrue(firstSequence.equals(sequence));
    }

    @Test
    public void SequenceIsDifferentToNull(){
        Sequence sequence = new Sequence();

        assertFalse(sequence.equals(null));
    }

    @Test
    public void SequenceIsTheSameThatItself(){
        Sequence sequence = new Sequence();

        assertTrue(sequence.equals(sequence));
    }

    @Test
    public void SequenceWithDifferentActionsAreNotEqual(){
        Sequence sequenceOne = new Sequence(new MoveLeftAction());
        Sequence sequenceTwo = new Sequence(new MoveUpAction());

        assertFalse(sequenceOne.equals(sequenceTwo));
    }

    @Test
    public void SequencesWithSameActionsInSameOrderAreEquals(){
        Sequence sequenceOne = new Sequence(new MoveDownAction());
        Sequence sequenceTwo = new Sequence(new MoveDownAction());

        assertTrue(sequenceOne.equals(sequenceTwo));
    }

    @Test
    public void SequencesWithDifferentSizeAreDifferent(){
        Sequence sequenceOne = new Sequence(new MoveUpAction());
        Sequence sequenceTwo = new Sequence(new MoveUpAction());
        sequenceOne.addAction(new MoveLeftAction());

        assertFalse(sequenceOne.equals(sequenceTwo));
    }

    @Test
    public void SequenceIsDifferentToAnObjectOfADifferentClass(){
        Sequence sequence = new Sequence(new MoveUpAction());
        int integer = 10;

        assertFalse(sequence.equals(integer));
    }
}