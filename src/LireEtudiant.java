import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class LireEtudiant {
    private static final Gson gson = new Gson();
    private static final Type ETUDIANT_LIST_TYPE = new TypeToken<List<Etudiant>>() {}.getType();

    public static List<Etudiant> lireDeJSON(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        return gson.fromJson(reader, ETUDIANT_LIST_TYPE);
    }

    public static void sauvegarderEtudiants(String filePath, List<Etudiant> etudiants) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        gson.toJson(etudiants, writer);
        writer.flush();
        writer.close();
    }
}
