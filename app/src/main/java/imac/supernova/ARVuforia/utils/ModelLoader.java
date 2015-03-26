package imac.supernova.ARVuforia.utils;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Angecroft on 24/03/2015.
 */
public class ModelLoader
{
    static public void loadContent(double[] destinationArray, String filePath, AssetManager am) {
        try {
            InputStream is = am.open(filePath);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            try {
                String line = br.readLine();
                int i = 0;

                while (line != null) {
                    if (!line.contains("//")) {
                        destinationArray[i] = Double.parseDouble(line);
                        i++;
                    }
                    line = br.readLine();
                }

                br.close();
                //fr.close();
            } catch (IOException exception) {
                System.err.println("Erreur lors de la lecture : " + exception.getMessage());
            }
        } catch (IOException exception) {
            System.err.println("Erreur : Le fichier n'a pas été trouvé");
        }
    }
}
