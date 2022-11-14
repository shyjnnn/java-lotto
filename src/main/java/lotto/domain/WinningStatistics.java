package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int MATCH_FIVE_CASE = 5;

    private static int compareWithAnswer(Lotto lotto, AnswerLotto answerLotto) {
        List<Integer> numbers = lotto.getLotto();
        List<Integer> winningNumbers = answerLotto.getAnswerLotto();
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean compareWithBonusNumber(Lotto lotto, AnswerLotto answerLotto, int matchingCount) {
        if (matchingCount != MATCH_FIVE_CASE) {
            return false;
        }
        List<Integer> numbers = lotto.getLotto();
        int bonusNumber = answerLotto.getBonusNumber();
        return numbers.contains(bonusNumber);
    }

    public static Map<WinningRank, Integer> getWinningDetails(LottoGroup lottoGroup, AnswerLotto answerLotto) {
        Map<WinningRank, Integer> winningDetails = WinningRank.getWinningDetails();
        
        for (Lotto lotto : lottoGroup.getLottoGroup()) {
            int count = compareWithAnswer(lotto, answerLotto);
            boolean containsBonusNumber = compareWithBonusNumber(lotto, answerLotto, count);
            WinningRank winningRank = WinningRank.findWinningRank(count, containsBonusNumber);
            winningDetails.replace(winningRank, winningDetails.get(winningRank) + 1);
        }
        
        return winningDetails;
    }



}