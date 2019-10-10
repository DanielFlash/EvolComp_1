package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {
    private static double iter_count = 0;
    private static double max_iter = 10050;

    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!

        // your implementation:
        iter_count += 1;

        for(double[] solution: population){
            double alpha = random.nextDouble();
            if(alpha >= 0.4) {
                for(int i = 0; i < solution.length; i++){
                    double sigma = random.nextDouble();
                    if(sigma < 1./solution.length){
                        solution[i] = solution[i] + random.nextGaussian() *
                                (0.7 * (1.0 - iter_count/max_iter) + 0.8);

//                        solution[i] = solution[i] + random.nextGaussian() *
//                                (2 * Math.pow((1.0 - iter_count/max_iter), 0.5) + 0.1);

//                        solution[i] = solution[i] + random.nextGaussian() *
//                                (2 * Math.pow((iter_count/max_iter * 100), 0.5));


//                        solution[i] = solution[i] + random.nextGaussian() *
//                                (5 * (1.0 - iter_count/max_iter) +
//                                        5 * Math.pow((iter_count/max_iter * 100), 0.5) + 0.5);

//                        if(solution[i] < -5.0)
//                            solution[i] = -5.0;
//                        else if(solution[i] > 5.0)
//                            solution[i] = 5.0;

//                        double range = 5.0 - Math.abs(solution[i]);
//                        int sign = (random.nextDouble() < 0.5) ? -1 : 1;
//                        solution[i] += sign * range * random.nextDouble();

//                        solution[i] = random.nextDouble() * 10 - 5.0;
                    }
                }
            }
        }

        //result population
        return population;
    }
}
