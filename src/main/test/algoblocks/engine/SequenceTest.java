package algoblocks.engine;

import algoblocks.engine.action.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SequenceTest {

    @Test
    public void newSequenceWithAnActionAndTheFirstIsThatAction() {
        Action action = new MoveUpAction();
        Sequence sequence = new Sequence(action);

        assertEquals(action, sequence.get(0));
    }

    @Test
    public void newEmptySequenceAddsActionAndTheFirstIsThatAction() {
        Action action = new MoveUpAction();
        Sequence sequence = new Sequence();
        sequence.addAction(action);

        assertEquals(action, sequence.get(0));
    }

    @Test
    public void newSequenceIsEmpty() {
        Sequence sequence = new Sequence();

        assertTrue(sequence.isEmpty());
    }

    @Test
    public void sequenceConcatenateAndIsTheSameThanAddingTwoAction() {
        Sequence firstSequence = new Sequence(new MoveUpAction());
        Sequence lastSequence = new Sequence(new MoveLeftAction());
        firstSequence.concatenate(lastSequence);

        Sequence sequence = new Sequence(new MoveUpAction());
        sequence.addAction(new MoveLeftAction());

        assertTrue(firstSequence.equals(sequence));
    }

    @Test
    public void sequenceIsDifferentToNull() {
        Sequence sequence = new Sequence();

        assertFalse(sequence.equals(null));
    }

    @Test
    public void sequenceIsTheSameThatItself() {
        Sequence sequence = new Sequence();

        assertTrue(sequence.equals(sequence));
    }

    @Test
    public void sequenceWithDifferentActionsAreNotEqual() {
        Sequence sequenceOne = new Sequence(new MoveLeftAction());
        Sequence sequenceTwo = new Sequence(new MoveUpAction());

        assertFalse(sequenceOne.equals(sequenceTwo));
    }

    @Test
    public void sequencesWithSameActionsInSameOrderAreEquals() {
        Sequence sequenceOne = new Sequence(new MoveDownAction());
        Sequence sequenceTwo = new Sequence(new MoveDownAction());

        assertTrue(sequenceOne.equals(sequenceTwo));
    }

    @Test
    public void sequencesWithDifferentSizeAreDifferent() {
        Sequence sequenceOne = new Sequence(new MoveUpAction());
        Sequence sequenceTwo = new Sequence(new MoveUpAction());
        sequenceOne.addAction(new MoveLeftAction());

        assertFalse(sequenceOne.equals(sequenceTwo));
    }

    @Test
    public void sequenceIsDifferentToAnObjectOfADifferentClass() {
        Sequence sequence = new Sequence(new MoveUpAction());
        int integer = 10;

        assertFalse(sequence.equals(integer));
    }

    @Test
    public void accessingIndexOutOfBoundsThrowsException() {
        Sequence sequence = new Sequence(new MoveDownAction());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            sequence.get(5);
        });
    }
}