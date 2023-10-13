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

        System.out.println("당첨 번호를 입력해주세요.");

        String win[] = Console.readLine().split(",");
        List<Integer> winning = new ArrayList<Integer>();

        for (String number:win){
            winning.add(Integer.parseInt(number));
        }

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int fifth = 0;

        for (Lotto list:lottoList){
            int countSame = 0;
            for (Integer num:winning){
                List<Integer> numbers = list.getNumbers();
                if (numbers.contains(num)) {
                    countSame+=1;
                }
            }

            if (countSame==6){
                list.setLottoWinning(LottoWinning.FIRST);
            } else if (countSame==5){
                if (list.getNumbers().contains(bonusNumber)) {
                    list.setLottoWinning(LottoWinning.SECOND);
                } else {
                    list.setLottoWinning(LottoWinning.THIRD);
                }
            } else if (countSame==4) {
                list.setLottoWinning(LottoWinning.FOURTH);
            } else if (countSame==3) {
                list.setLottoWinning(LottoWinning.FIFTH);
            }

            if (list.getLottoWinning()==LottoWinning.FIRST) {
                first+=1;
            } else if (list.getLottoWinning()==LottoWinning.SECOND) {
                second+=1;
            } else if (list.getLottoWinning()==LottoWinning.THIRD) {
                third+=1;
            } else if (list.getLottoWinning()==LottoWinning.FOURTH) {
                fourth+=1;
            } else if (list.getLottoWinning()==LottoWinning.FIFTH) {
                fifth+=1;
            }
        }




    }
}
