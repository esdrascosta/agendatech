package controllers.admin;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.Evento;
import persistencia.Eventos;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.eventos.admin.tela_admin;

public class TodosEventosController extends Controller {
 
	public static Result todos(){
		
		List<Evento> aprovados = Eventos.aprovados(true);
		List<Evento> naoAprovados = Eventos.aprovados(false);
		
		return ok(tela_admin.render(naoAprovados, aprovados));
	}
	
	public static Result aprova(Integer id){
		
		Evento evento = Ebean.find(Evento.class,id);
		evento.setAprovado(true);
		Ebean.update(evento);
		
		return redirect(routes.TodosEventosController.todos());
	}
}
