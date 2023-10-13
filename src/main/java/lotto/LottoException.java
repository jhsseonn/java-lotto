package lotto;

public class LottoException {

    public void isPurchaseDividable(int purchase) {
        if (purchase%1000!=0) {
            throw new IllegalArgumentException();
        }
    }
}
