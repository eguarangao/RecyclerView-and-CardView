package com.example.uteqlibros.Interfaz;
import com.example.uteqlibros.Modelo.*;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterListaLibros {

    @GET("/ws/issues.php?j_id=2")
    Call< List<ListaLibrosUteq> > getLibros();
}
