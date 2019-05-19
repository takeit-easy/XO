package controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerIsRow() throws Exception {
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsColumn() throws Exception {
        final Field field = new Field(3);
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsDiag() throws Exception {
        final Field field = new Field(3);
        WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerNoDiag() throws Exception {
        final Field field = new Field(3);
        WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerIsDiag2() throws Exception {
        final Field field = new Field(3);
        WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerNoDiag2() throws Exception {
        final Field field = new Field(3);
        WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(winnerController.getWinner(field));
    }


}