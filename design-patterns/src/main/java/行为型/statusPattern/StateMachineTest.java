package 行为型.statusPattern;




import org.junit.Test;

import java.util.Random;

public class StateMachineTest {
    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine(6);

        System.out.println(stateMachine);

        stateMachine.insertQuarter();
        stateMachine.turnCrank();

        System.out.println(stateMachine);

        stateMachine.insertQuarter();
        stateMachine.turnCrank();
        stateMachine.insertQuarter();
        stateMachine.turnCrank();

        System.out.println(stateMachine);

    }

    @Test
    public void outputRandom() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(10)); //0-9
        }
    }
}
