package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import models.Evento;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Http.RequestBody;
import play.mvc.Result;
import play.twirl.api.Html;

import com.avaje.ebean.Ebean;
public class EventosController extends Controller {

	private static final Form<Evento> eventoForm = Form.form(Evento.class);
	
	public static Result novo(){
		Html view = novo.render(eventoForm); 
		return ok(view);
	}
	
	public static Result cria(){
		Form<Evento> formFromRequest = eventoForm.bindFromRequest();
		if(formFromRequest.hasErrors()){
			return badRequest(novo.render(formFromRequest));
		}else{
			Evento evento = formFromRequest.get();
			String caminhoImagem = gravarImagem();
			evento.setCaminhoImagem(caminhoImagem);
			Ebean.save(evento);
			return redirect(routes.EventosController.lista());
		}
	}
	
	private static String gravarImagem(){
		
		RequestBody requestBody = request().body();
		MultipartFormData multipartFormData = requestBody.asMultipartFormData();
		FilePart filePart = multipartFormData.getFile("destaque");
		File destaque = filePart.getFile();
		File destino = new File("public/images/destaques",System.currentTimeMillis() + " " +filePart.getFilename());
		try {
			FileUtils.moveFile(destaque, destino);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destino.getName();
	}
	
	public static Result lista(){
		List<Evento> eventos = Ebean.find(Evento.class).findList();
		return ok(lista.render(eventos));
	}
}
