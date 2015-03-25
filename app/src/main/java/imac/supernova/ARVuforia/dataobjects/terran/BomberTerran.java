package imac.supernova.ARVuforia.dataobjects.terran;

import android.content.res.AssetManager;

import java.nio.Buffer;

import imac.supernova.ARVuforia.utils.MeshObject;
import imac.supernova.ARVuforia.utils.ModelLoader;

/**
 * Created by Angecroft on 24/03/2015.
 */
public class BomberTerran extends MeshObject
{
    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    AssetManager am;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    public BomberTerran(AssetManager am_)
    {
        am = am_;
        setVerts();
        setTexCoords();
        setNorms();
    }

    private void setVerts() {
        double[] BOMBER_VERTS = new double[10242];
        ModelLoader.loadContent(BOMBER_VERTS, "terran_bomber_verts.txt", am);
        mVertBuff = fillBuffer(BOMBER_VERTS);
        verticesNumber = 3414;
    }

    private void setTexCoords() {
        double[] BOMBER_TEX_COORDS = new double[6828];
        ModelLoader.loadContent(BOMBER_TEX_COORDS, "terran_bomber_texCoords.txt", am);
        mTexCoordBuff = fillBuffer(BOMBER_TEX_COORDS);
    }

    private void setNorms()
    {
        double[] BOMBER_NORMS = new double[10242];
        ModelLoader.loadContent(BOMBER_NORMS, "terran_bomber_norms.txt", am);
        mNormBuff = fillBuffer(BOMBER_NORMS);
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
