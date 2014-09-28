package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.Evento;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.eventos.*;
public class EventosController extends Controller {

	private static Form<Evento> eventoForm = Form.form(Evento.class);
	
	public static Result novo(){
		Html view = novo.render(); 
		return ok(view);
	}
	
	public static Result cria(){
		Form<Evento> formFromRequest = eventoForm.bindFromRequest();
		Evento evento = formFromRequest.get();
		Ebean.save(evento);
		return redirect(routes.EventosController.lista());
	}
	
	public static Result lista(){
		List<Evento> eventos = Ebean.find(Evento.class).findList();
		return ok(lista.render(eventos));
	}
}
