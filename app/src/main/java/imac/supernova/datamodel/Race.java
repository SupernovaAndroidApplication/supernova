package imac.supernova.datamodel;

/**
 * Created by Clara on 05/02/2015.
 */
public enum Race {
    TERRAN("Terran", "Description Terran"),
    BOHREGON("Bohregon", "Description Bohregon"),
    NERENIDE("Nerenide", "Description Nerenide"),
    YTTRIKT("Yttrikt", "Description Yttrikt");

    private String name = "";
    private String description = "";

    Race(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
}
