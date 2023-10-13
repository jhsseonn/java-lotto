package lotto;

public class LottoException {

    public void isPurchaseDividable(int purchase) {
        if (purchase%1000!=0) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumberInRange(int number){
        if (number>45 && number<1) {
            throw new IllegalArgumentException();
        }
    }
}
