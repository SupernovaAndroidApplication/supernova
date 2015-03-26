package imac.supernova.ARVuforia.utils;

import java.nio.Buffer;

/**
 * Created by Angecroft on 05/03/2015.
 */
public class PlaneObject extends MeshObject
{
    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    private Buffer mIndBuff;

    private int indicesNumber = 0;
    private int verticesNumber = 0;


    public PlaneObject()
    {
        setVerts();
        setTexCoords();
        setNorms();
    }


    private void setVerts()
    {
        double[] PLANE_VERTS = {
                -1.00f, -1.00f, 0,
                1.00f, -1.00f, 0,
                1.00f, 1.00f, 0,
                1.00f, 1.00f, 0,
                -1.00f, 1.00f, 0,
                -1.00f, -1.00f, 0
        };
        mVertBuff = fillBuffer(PLANE_VERTS);
        verticesNumber = PLANE_VERTS.length / 3;
    }

    private void setTexCoords()
    {
        double[] PLANE_TEX_COORDS = {
                0,0,  1,0,  1,1,  1,1,  0,1,  0,0
        };
        mTexCoordBuff = fillBuffer(PLANE_TEX_COORDS);
    }

    private void setNorms()
    {
        double[] PLANE_NORMS = {
                0,0,1,  0,0,1,  0,0,1, 0,0,1,  0,0,1,  0,0,1
        };
        mNormBuff = fillBuffer(PLANE_NORMS);
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

    @Override
    public int getNumObjectVertex() {
        return verticesNumber;
    }

    @Override
    public int getNumObjectIndex() {
        return 0;
    }
}
