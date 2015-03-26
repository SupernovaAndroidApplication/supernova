package imac.supernova.datamodel;

/**
 * Created by Clara on 05/02/2015.
 */
public enum Race {
    TERRAN("Terran", "Derniers arrivés dans la lutte pour la conquête de la galaxie, les Terrans ont dû quitter leur planète d’origine, devenue invivable, pour chercher à coloniser de nouvelles planètes plus hospitalières. Malheureusement, ils ne sont pas les seuls à s’intéresser à ces planètes, vitales pour leur espèce ! Technologiquement moins avancés que les autres races, ils compensent cette faiblesse par leur sens aiguisé de la stratégie."),
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
