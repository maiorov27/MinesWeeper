package logic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FieldTest {
    public static final int CELL_NUMBER_IN_MATRIX = 56;

    private Field field;
    @Mock private Miner miner;

    @Before
    public void setUp(){
        when(miner.calculateMinesPositions(anyInt(),anyInt())).thenReturn(new MinesPositionsContainer());
        field = new Field(miner,10);
    }

    @Test
    public void convertPositionToLineNumber(){
        assertThat(field.convertPosToLineNumber(CELL_NUMBER_IN_MATRIX), is(5));
    }

    @Test
    public void convertPositionToCellNumber(){
        assertThat(field.convertPosToCellNumber(CELL_NUMBER_IN_MATRIX),is(6));
    }
}
