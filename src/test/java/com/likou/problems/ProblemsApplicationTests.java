package com.likou.problems;

import com.likou.problems.solutions.LongestPalindrome;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ProblemsApplicationTests {

    @Test
    void contextLoads() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        //Assert.isTrue(longestPalindrome.isPalindrome("abavaba"),"回文");
        String abavaba = longestPalindrome.longestPalindrome_2("cbbd");
        System.out.println(abavaba);

    }

}
