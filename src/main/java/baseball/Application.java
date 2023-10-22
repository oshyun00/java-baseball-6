package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 1. 임의의 세자리 숫자(정답) 생성
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        // 2. 숫자 입력 받고 검증하기

        System.out.println("입력하세요: ");
        String input = Console.readLine();

        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputList = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            inputList.add(input.charAt(i) - '0');
        }

        if (inputList.stream().distinct().collect(Collectors.toList()).size() != inputList.size()) {
            throw new IllegalArgumentException();
        }
    }
}
