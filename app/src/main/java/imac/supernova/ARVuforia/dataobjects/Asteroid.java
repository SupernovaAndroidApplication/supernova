package imac.supernova.ARVuforia.dataobjects;

import android.content.res.AssetManager;

import java.nio.Buffer;

import imac.supernova.ARVuforia.utils.MeshObject;
import imac.supernova.ARVuforia.utils.ModelLoader;

/**
 * Created by Angecroft on 25/03/2015.
 */
public class Asteroid extends MeshObject
{
    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    AssetManager am;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    public Asteroid(AssetManager am_)
    {
        am = am_;
        setVerts();
        setTexCoords();
        setNorms();
    }

    private void setVerts() {
        double[] ASTEROID_VERTS = new double[8640];
        ModelLoader.loadContent(ASTEROID_VERTS, "asteroid_verts.txt", am);
        mVertBuff = fillBuffer(ASTEROID_VERTS);
        verticesNumber = 2880;
    }

    private void setTexCoords() {
        double[] ASTEROID_TEX_COORDS = new double[5760];
        ModelLoader.loadContent(ASTEROID_TEX_COORDS, "asteroid_texCoords.txt", am);
        mTexCoordBuff = fillBuffer(ASTEROID_TEX_COORDS);
    }

    private void setNorms()
    {
        double[] ASTEROID_NORMS = new double[8640];
        ModelLoader.loadContent(ASTEROID_NORMS, "asteroid_norms.txt", am);
        mNormBuff = fillBuffer(ASTEROID_NORMS);
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
