package edu.vsu.ru.project;

import edu.vsu.ru.util.ListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class TestsOfDifferentSituations {
    @Test
    public void testFileWithDecreasingArithmeticProgression() throws FileNotFoundException {
        List<Integer> listForTest = ListUtils.readListFromFile("TestCase/testFileWithDecreasingArithmeticProgression.txt");
        listForTest = LongestSequenceFinder.createNewList(listForTest);
        List<Integer> resultList = ListUtils.readListFromFile("TestResult/ResultOfDecreasingArithmeticProgression.txt");
        Assert.assertEquals(resultList, listForTest);
    }

    @Test
    public void testFileWithIncreasingArithmeticProgression() throws FileNotFoundException {
        List<Integer> listForTest = ListUtils.readListFromFile("TestCase/testFileWithIncreasingArithmeticProgression.txt");
        listForTest = LongestSequenceFinder.createNewList(listForTest);
        List<Integer> resultList = ListUtils.readListFromFile("TestResult/ResultOfIncreasingArithmeticProgression.txt");
        Assert.assertEquals(resultList, listForTest);
    }

    @Test
    public void testFileWithIncreasingArithmeticProgression2() throws FileNotFoundException {
        List<Integer> listForTest = ListUtils.readListFromFile("TestCase/testFileWithIncreasingArithmeticProgression2.txt");
        listForTest = LongestSequenceFinder.createNewList(listForTest);
        List<Integer> resultList = ListUtils.readListFromFile("TestResult/ResultOfIncreasingArithmeticProgression2.txt");
        Assert.assertEquals(resultList, listForTest);
    }

    @Test
    public void testFileWithOneNumber() throws FileNotFoundException {
        List<Integer> listForTest = ListUtils.readListFromFile("TestCase/testFileWithOneNumber.txt");
        listForTest = LongestSequenceFinder.createNewList(listForTest);
        List<Integer> resultList = ListUtils.readListFromFile("TestResult/ResultOfOneNumber.txt");
        Assert.assertEquals(resultList, listForTest);
    }

    @Test
    public void testFileWithTwoNumber() throws FileNotFoundException {
        List<Integer> listForTest = ListUtils.readListFromFile("TestCase/testFileWithTwoNumber.txt");
        listForTest = LongestSequenceFinder.createNewList(listForTest);
        List<Integer> resultList = ListUtils.readListFromFile("TestResult/ResultOfTwoNumber.txt");
        Assert.assertEquals(resultList, listForTest);
    }

    @Test
    public void testFileWithTwoNumber2() throws FileNotFoundException {
        List<Integer> listForTest = ListUtils.readListFromFile("TestCase/testFileWithTwoNumber2.txt");
        listForTest = LongestSequenceFinder.createNewList(listForTest);
        List<Integer> resultList = ListUtils.readListFromFile("TestResult/ResultOfTwoNumber2.txt");
        Assert.assertEquals(resultList, listForTest);
    }
}
