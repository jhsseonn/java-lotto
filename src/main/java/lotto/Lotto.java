package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private LottoWinning lottoWinning;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setLottoWinning(LottoWinning lottoWinning){
        this.lottoWinning = lottoWinning;
    }

    public LottoWinning getLottoWinning() {
        return lottoWinning;
    }

}
