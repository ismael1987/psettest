package at.problemtest.problemtest.pset1.model;

import java.util.List;

public class Actor {
    private String actotName;
    private List<String> ActorsMaleFemaleRatio ;




    public void setActorsMaleFemaleRatio(List<String> actorsMaleFemaleRatio) {
        ActorsMaleFemaleRatio = actorsMaleFemaleRatio;
    }



    public List<String> getActorsMaleFemaleRatio() {
        return ActorsMaleFemaleRatio;
    }

    public String getActotName() {
        return actotName;
    }

    public void setActotName(String actotName) {
        this.actotName = actotName;
    }
}
