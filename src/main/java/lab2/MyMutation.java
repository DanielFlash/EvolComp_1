package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {
    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!

        // your implementation:

        for(double[] solution: population){
            double alpha = random.nextDouble();
            if(alpha >= 0.4) {
                for(int i = 0; i < solution.length; i++){
                    double sigma = random.nextDouble();
                    if(sigma < 1./solution.length){
                        double range = 5.0 - Math.abs(solution[i]);
                        int sign = (random.nextDouble() < 0.5) ? -1 : 1;
                        solution[i] += sign * range * random.nextDouble();

//                        solution[i] = random.nextDouble() * 10 - 5.0;
                    }
                }
            }
        }

        //result population
        return population;
    }
}
