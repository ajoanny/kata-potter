package com.potterkata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest
{
    @Test
    public void when_no_books()
    {
        Integer [] books = {};
        assertEquals(0, Potter.price(books) );
    }

    @Test
    public void when_one_books()
    {
        Integer [] books = { 1 };
        assertEquals(8, Potter.price(books) );
    }


    @Test
    public void when_two_books()
    {
        Integer [] books = { 1, 2 };
        assertEquals((8 * 2) * 0.95, Potter.price(books) );
    }

    @Test
    public void when_three_books()
    {
        Integer [] books = { 1, 2, 3 };
        assertEquals((8 * 3) * 0.90, Potter.price(books) );
    }

    @Test
    public void when_four_books()
    {
        Integer [] books = { 1, 2, 3, 4 };
        assertEquals((8 * 4) * 0.80, Potter.price(books) );
    }

    @Test
    public void when_five_books()
    {
        Integer [] books = { 1, 2, 3, 4, 5 };
        assertEquals((8 * 5) * 0.75, Potter.price(books) );
    }

    @Test
    public void when_five_1_1_2()
    {
        Integer [] books = { 1, 1, 2 };
        assertEquals(8 +(8 * 2) * 0.95, Potter.price(books) );
    }


    @Test
    public void when_five_1_1_1_2_3()
    {
        Integer [] books = { 1, 1, 1, 2, 3 };
        assertEquals((8 * 2) + ((8 * 3) * 0.90), Potter.price(books) );
    }

    @Test
    public void when_edge_case()
    {
        Integer [] books_1 = {0, 0, 1, 1, 2, 2, 3, 4};
        Integer [] books_2 = {
                0, 0, 0, 0, 0,
                1, 1, 1, 1, 1,
                2, 2, 2, 2,
                3, 3, 3, 3, 3,
                4, 4, 4, 4
        };

        assertEquals(2 * (8 * 4 * 0.8), Potter.price(books_1));
        assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
                Potter.price(books_2));
    }
}
