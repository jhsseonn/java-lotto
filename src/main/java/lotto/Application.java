package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoException lottoException = new LottoException();

        System.out.println("구입금액을 입력해 주세요.");

        int purchase = Integer.parseInt(Console.readLine());
        int lottoAmount = 0;

        lottoException.isPurchaseDividable(purchase);
        lottoAmount+=purchase/1000;

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
            lottoException.isValidNumberRange(Integer.parseInt(number));
            winning.add(Integer.parseInt(number));
        }

        lottoException.isValidLottoSize(winning);

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        lottoException.isValidNumberRange(bonusNumber);

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

        int revenue = first*2000000000+second*30000000+third*1500000+fourth*50000+fifth*5000;

        int revPercent = revenue/purchase*100;

        System.out.println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - "+fifth+"개\n" +
                "4개 일치 (50,000원) - "+fourth+"개\n" +
                "5개 일치 (1,500,000원) - "+third+"개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - "+second+"개\n" +
                "6개 일치 (2,000,000,000원) - "+first+"개\n" +
                "총 수익률은 "+revPercent+"%입니다.");

    }
}
