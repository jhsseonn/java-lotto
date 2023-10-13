package lotto;

import java.util.List;

public class LottoException {

    public void isPurchaseDividable(int purchase) {
        if (purchase%1000!=0) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidNumberRange(int number){
        if (number>45 && number<1) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidLottoSize(List<Integer> lottolist){
        if (lottolist.size()!=6){
            throw new IllegalArgumentException();
        }
    }
}
