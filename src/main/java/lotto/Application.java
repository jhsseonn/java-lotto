package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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

        List<Lotto> lottoList = new ArrayList<>();

        for (int i=0; i<lottoAmount; i++){
            Lotto lottoNumbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lottoNumbers);
            System.out.println(lottoList.get(i));
        }




    }
}
