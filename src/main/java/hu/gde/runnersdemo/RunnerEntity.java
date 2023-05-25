package hu.gde.runnersdemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;
    private String runnerName;
    private long averagePace;
    private int runnerHeight;

    @OneToMany(mappedBy = "runner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LapTimeEntity> laptimes = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = true)
    private SponsorEntity sponsor;


    public RunnerEntity() {
    }

    public SponsorEntity getSponsor() {
        return sponsor;
    }

    public void setSponsor(SponsorEntity sponsor) {
        this.sponsor = sponsor;
    }

    public long getRunnerId() {
        return runnerId;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public long getAveragePace() {
        return averagePace;
    }

    public int getRunnerHeight() { return runnerHeight; }

    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public void setAveragePace(long averagePace) {
        this.averagePace = averagePace;
    }

    public void setRunnerHeight(int runnerHeight) { this.runnerHeight = runnerHeight; }

    public List<LapTimeEntity> getLaptimes() {
        return laptimes;
    }
}
