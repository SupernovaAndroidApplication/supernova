package imac.supernova.ARVuforia.dataobjects.nerenide;

import android.content.res.AssetManager;

import java.nio.Buffer;

import imac.supernova.ARVuforia.utils.MeshObject;
import imac.supernova.ARVuforia.utils.ModelLoader;

/**
 * Created by Angecroft on 24/03/2015.
 */
public class FighterNerenide extends MeshObject
{
    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    AssetManager am;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    public FighterNerenide(AssetManager am_)
    {
        am = am_;
        setVerts();
        setTexCoords();
        setNorms();
    }

    private void setVerts() {
        double[] FIGHTER_VERTS = new double[21258];
        ModelLoader.loadContent(FIGHTER_VERTS, "nerenide_fighter_verts.txt", am);
        mVertBuff = fillBuffer(FIGHTER_VERTS);
        verticesNumber = 7086;
    }

    private void setTexCoords() {
        double[] FIGHTER_TEX_COORDS = new double[14172];
        ModelLoader.loadContent(FIGHTER_TEX_COORDS, "nerenide_fighter_texCoords.txt", am);
        mTexCoordBuff = fillBuffer(FIGHTER_TEX_COORDS);
    }

    private void setNorms()
    {
        double[] FIGHTER_NORMS = new double[21258];
        ModelLoader.loadContent(FIGHTER_NORMS, "nerenide_fighter_norms.txt", am);
        mNormBuff = fillBuffer(FIGHTER_NORMS);
    }

    public int getNumObjectIndex()
    {
        return indicesNumber;
    }

    @Override
    public int getNumObjectVertex()
    {
        return verticesNumber;
    }

    @Override
    public Buffer getBuffer(BUFFER_TYPE bufferType)
    {
        Buffer result = null;
        switch (bufferType)
        {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            case BUFFER_TYPE_NORMALS:
                result = mNormBuff;
                break;
            default:
                break;

        }

        return result;
    }
}
