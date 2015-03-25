package imac.supernova.ARVuforia.dataobjects.terran;

import android.content.res.AssetManager;

import java.nio.Buffer;

import imac.supernova.ARVuforia.utils.MeshObject;
import imac.supernova.ARVuforia.utils.ModelLoader;

/**
 * Created by Angecroft on 24/03/2015.
 */
public class FighterTerran extends MeshObject
{
    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    AssetManager am;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    public FighterTerran(AssetManager am_)
    {
        am = am_;
        setVerts();
        setTexCoords();
        setNorms();
    }

    private void setVerts() {
        double[] FIGHTER_VERTS = new double[24660];
        ModelLoader.loadContent(FIGHTER_VERTS, "terran_fighter_verts.txt", am);
        mVertBuff = fillBuffer(FIGHTER_VERTS);
        verticesNumber = 8220;
    }

    private void setTexCoords() {
        double[] FIGHTER_TEX_COORDS = new double[16440];
        ModelLoader.loadContent(FIGHTER_TEX_COORDS, "terran_fighter_texCoords.txt", am);
        mTexCoordBuff = fillBuffer(FIGHTER_TEX_COORDS);
    }

    private void setNorms()
    {
        double[] FIGHTER_NORMS = new double[24660];
        ModelLoader.loadContent(FIGHTER_NORMS, "terran_fighter_norms.txt", am);
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
