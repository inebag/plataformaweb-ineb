package com.plataformawebproygraduacion.umg.app.servb;

import java.util.List;

import com.plataformawebproygraduacion.umg.app.entities.Docente;

public interface IDocenteSer {
	
	List<Docente> buscarDocentedpi(String dpiDocente);

}
