package com.epam.text.logic.sorter;

import com.epam.text.model.Component;
import com.epam.text.model.Composite;
import com.epam.text.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SorterTest {

    private static final Leaf FIRST_LEAF = Leaf.word("It's ");
    private static final Leaf SECOND_LEAF = Leaf.word("[4 5+]. ");
    private static final Leaf THIRD_LEAF = Leaf.word("Fact. ");

    public static Component getUnsortedParagraphText(){
        Component sentence = new Composite(Arrays.asList(THIRD_LEAF, SECOND_LEAF, FIRST_LEAF));
        Component twoParagraphs = new Composite(Arrays.asList(sentence, sentence));
        Component threeParagraphs = new Composite(Arrays.asList(sentence, sentence, sentence));
        return new Composite(Arrays.asList(threeParagraphs, twoParagraphs));
    }

    public static Component getSortedParagraphText() {
        Component sentence = new Composite(Arrays.asList(THIRD_LEAF, SECOND_LEAF, FIRST_LEAF));
        Component twoParagraphs = new Composite(Arrays.asList(sentence, sentence));
        Component threeParagraphs = new Composite(Arrays.asList(sentence, sentence, sentence));
        return new Composite(Arrays.asList(twoParagraphs, threeParagraphs));
    }

    public static Component getUnsortedWordText() {
        Component sentence = new Composite(Arrays.asList(THIRD_LEAF, SECOND_LEAF, FIRST_LEAF));
        Component paragraph = new Composite(Arrays.asList(sentence, sentence));
        return new Composite(Arrays.asList(paragraph, paragraph));
    }

    public static Component getSortedWordText(){
        Component sortedSentence = new Composite(Arrays.asList(FIRST_LEAF, THIRD_LEAF, SECOND_LEAF));
        Component sortedParagraph = new Composite(Arrays.asList(sortedSentence, sortedSentence));
        return new Composite(Arrays.asList(sortedParagraph, sortedParagraph));
    }

    public static String getExpectedText() {
        return "Fact. [4 5+]. It's Fact. [4 5+]. It's \r\nFact. [4 5+]. It's Fact. [4 5+]. It's";
    }

    @Test
    public void testSortParagraphsBySentenceLengthShouldReturnSortedText(){
        Sorter sorter = new Sorter();
        Component component = getUnsortedParagraphText();
        Component actual = sorter.sortParagraphsBySentenceLength(component);
        Component expected = getSortedParagraphText();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortSentencesByWordsLengthShouldReturnSortedText(){
        Sorter sorter = new Sorter();
        Component component = getUnsortedWordText();
        Component actual = sorter.sortSentencesByWordsLength(component);
        Component expected = getSortedWordText();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRestoreShouldReturnRestoredText(){
        Sorter sorter = new Sorter();
        Component actualComponent = getUnsortedWordText();
        String actual = sorter.restore(actualComponent);
        String expected = getExpectedText();

        Assert.assertEquals(expected, actual);
    }
}
