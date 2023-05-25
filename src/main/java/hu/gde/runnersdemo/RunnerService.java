package hu.gde.runnersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public double getAverageLaptime(Long runnerId) {
        RunnerEntity runner = runnerRepository.findById(runnerId).orElse(null);
        if (runner != null) {
            List<LapTimeEntity> laptimes = runner.getLaptimes();
            int totalTime = 0;
            for (LapTimeEntity laptime : laptimes) {
                totalTime += laptime.getTimeSeconds();
            }
            return (double) totalTime / laptimes.size();
        } else {
            return -1.0;
        }
    }

    public String getHeigthestRunnerName() {
        List<RunnerEntity> runners = runnerRepository.findAll();
        int maxHeight = 0;
        String runnerName = "";
        for (RunnerEntity runner : runners) {
            if(runner.getRunnerHeight() > maxHeight) {
                maxHeight = runner.getRunnerHeight();
                runnerName = runner.getRunnerName();
            }
        }
        return runnerName;
    }

    public double getRunnersAverageHeight() {
        List<RunnerEntity> runners = runnerRepository.findAll();
        int totalHeight = 0;
        for (RunnerEntity runner : runners) {
            totalHeight += runner.getRunnerHeight();
        }
        return (double) totalHeight / runners.size();
    }
}
