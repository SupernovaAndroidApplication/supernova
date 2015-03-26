package imac.supernova.datamodel;

import java.io.Serializable;

/**
 * Created by Clara on 05/02/2015.
 */
public enum Race implements Serializable{
    TERRAN("Terran", "Derniers arrivés dans la lutte pour la conquête de la galaxie, les Terrans ont dû quitter leur planète d’origine, devenue invivable, pour chercher à coloniser de nouvelles planètes plus hospitalières. Malheureusement, ils ne sont pas les seuls à s’intéresser à ces planètes, vitales pour leur espèce ! Technologiquement moins avancés que les autres races, ils compensent cette faiblesse par leur sens aiguisé de la stratégie. Aujourd’hui, ils luttent pour défendre leurs nouvelles colonies et conserver leur place difficilement acquise parmi les leaders de la galaxie.\n"),
    BOHREGON("Bohregon", "Ils sont l’espèce intelligente la plus ancienne de la galaxie. Premiers à se lancer dans l’exploration intergalactique, leur technologie est extrêmement avancée. Les Nérénides sont une espèce d’une grande sagesse. Pacifistes dans l’âme, ils ont beaucoup étudié les autres races, ont partagé leur savoir et ont énormément contribué à l’élaboration de la langue universelle. Malheureusement, leur savoir a également permis aux autres races de concevoir les armes désormais tournées contre eux. Contraints d’utiliser la force, ils souhaitent avant tout rétablir l’ordre dans la galaxie.\n"),
    NERENIDE("Nerenide", "Neutres, ils ont toujours évité de prendre part aux conflits. Les Bohregons vivent dans des milieux hostiles aux autres races, sous la surface des planètes. Ces mineurs sont capables de construire des villes entières sous terre. Ils se sont tournés vers l’espace quand ils ont commencé à manquer de minerais sur leur planète. Ils ne sont pas intéressés par le pouvoir et cherchent simplement à subvenir à leurs besoins par leurs propres moyens, comme ils l’ont toujours fait. Cependant, leur docilité et leur capacité à extraire des minerais précieux ont fait d’eux de très bons esclaves pour certains commerçants sans scrupule. Aujourd’hui, ils prennent part à ce conflit pour reprendre leur indépendance."),
    YTTRIKT("Yttrikt", " Féroces guerriers, ils ne veulent qu’une chose : dominer la galaxie. Ils volent de planète en planète, de galaxie en galaxie, pillant les ressources et terrifiant les peuples. Redoutés de tous, ils ne vivent que pour combler leur soif de pouvoir. Adeptes de la force brute, ils agissent la plupart du temps avant de réfléchir. Arrivés depuis peu dans ce secteur de l’univers, ils sont en grande partie à l’origine du conflit actuel.");

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
