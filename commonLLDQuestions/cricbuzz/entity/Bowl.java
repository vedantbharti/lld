package commonLLDQuestions.cricbuzz.entity;

import commonLLDQuestions.cricbuzz.enums.BowlType;
import commonLLDQuestions.cricbuzz.enums.WicketType;
import lombok.Data;

import java.util.UUID;


@Data
public class Bowl {

    private String bowlId;
    private String bowlerId;
    private String batsmanId;
    private int run;
    private boolean isAWicket;
    private WicketType wicketType;
    private BowlType bowlType;

    public Bowl(BowlType bowlType, String bowlerId, String batsmanId, int run, boolean isAWicket, WicketType wicketType){
        this.bowlId = UUID.randomUUID().toString();
        this.bowlType = bowlType;
        this.bowlerId = bowlerId;
        this.batsmanId = batsmanId;
        this.run = run;
        this.isAWicket = isAWicket;
        this.wicketType = wicketType;
    }
}
