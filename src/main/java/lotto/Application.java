package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");

        int purchase = Integer.parseInt(Console.readLine());
        int lottoAmount = 0;

        if (purchase%1000==0) {
            lottoAmount=purchase/1000;
        }

        System.out.println(lottoAmount+"개를 구매했습니다.");

    }
}
