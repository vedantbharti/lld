package commonLLDQuestions.cricbuzz.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Over {

    private String overId;
    private int overNum;
    private int totalValidBowls;
    private List<String> bowlIds;

    public Over(int overNum) {
        this.overId = UUID.randomUUID().toString();
        this.overNum = overNum;
        this.totalValidBowls = 0;
        this.bowlIds = new ArrayList<>();
    }
}
