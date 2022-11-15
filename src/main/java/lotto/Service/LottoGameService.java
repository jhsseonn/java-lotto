package lotto.Service;

import lotto.Console.OutputMessages;

public class LottoGameService {

    //Number -> Num으로 줄여 사용
    OutputMessages outputMessages = new OutputMessages();
    public void isCashInt(String cash) {
        if(!cash.matches("[0-9]+")) {
            System.out.println(outputMessages.CashIsNotInt());
            throw new IllegalArgumentException();
        }
    }
    public void isValidCash(Integer cash) {
        if (cash%1000!=0) {
            throw new IllegalArgumentException();
        }
    }

}
