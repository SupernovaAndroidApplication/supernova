package imac.supernova.datamodel;

/**
 * Created by Clara on 08/03/2015.
 */
public class Sun {

    int life;
    boolean supernova;

    public Sun(int life){
        this.supernova = false; this.life = life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setSupernova(boolean supernova) {

        this.supernova = supernova;

    }

    public boolean getSupernova(){
        return supernova;
    }
}
