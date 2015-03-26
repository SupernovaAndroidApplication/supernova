package imac.supernova.ARVuforia.dataobjects.yttrikt;

import android.content.res.AssetManager;

import java.nio.Buffer;

import imac.supernova.ARVuforia.utils.MeshObject;
import imac.supernova.ARVuforia.utils.ModelLoader;

/**
 * Created by Angecroft on 24/03/2015.
 */
public class CruiserYttrikt extends MeshObject
{
    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    AssetManager am;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    public CruiserYttrikt(AssetManager am_)
    {
        am = am_;
        setVerts();
        setTexCoords();
        setNorms();
    }

    private void setVerts() {
        double[] CRUISER_VERTS = new double[10242];
        ModelLoader.loadContent(CRUISER_VERTS, "yttrikt_cruiser_verts.txt", am);
        mVertBuff = fillBuffer(CRUISER_VERTS);
        verticesNumber = 3414;
    }

    private void setTexCoords() {
        double[] CRUISER_TEX_COORDS = new double[6828];
        ModelLoader.loadContent(CRUISER_TEX_COORDS, "yttrikt_cruiser_texCoords.txt", am);
        mTexCoordBuff = fillBuffer(CRUISER_TEX_COORDS);
    }

    private void setNorms()
    {
        double[] CRUISER_NORMS = new double[10242];
        ModelLoader.loadContent(CRUISER_NORMS, "yttrikt_cruiser_norms.txt", am);
        mNormBuff = fillBuffer(CRUISER_NORMS);
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
