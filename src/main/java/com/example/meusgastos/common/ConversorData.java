package com.example.meusgastos.common;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConversorData {

    public static String converterDateParaDataEHora(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatador.format(data);
    }
}
