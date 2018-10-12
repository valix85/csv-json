package csv;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.beans.binding.ObjectExpression;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestoreJson <T> {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Class<T> dataType;
    public GestoreJson(){

    }

    public String trasformaRubricaJson(List<Rubrica> rub){
        return gson.toJson(rub);
    }

    public List<T> leggiRubricaJson(String json){
        //TypeToken<List<T>> listType = new TypeToken<List<T>>() {};
        TypeToken<T> listType = new TypeToken<T>() {};
        List<T> rubr = (List<T>) gson.fromJson(json, listType.getType());
        //List<Rubrica> rubr=gson.fromJson(json, List.class );
        //System.out.println(rubr.getClass());
        System.out.println(rubr.get(0));
        return rubr;
    }
}
