package com.projects.imatia;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projects.model.Tarea;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	ArrayList<Tarea> listaTareas;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//index y generar tareas por defecto
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		String texto = "texto";
		model.addAttribute("Generando Tareas", texto);

		listaTareas = new ArrayList<Tarea>();

		for (int i = 0; i <= 5; i++) {
			Tarea t = new Tarea(i, "Tarea " + (i * 5), false);
			listaTareas.add(t);
		}
		model.addAttribute("tareas", listaTareas);
		return "home";
	}

	//listar tareas
	@RequestMapping(value = "/tareas", method = RequestMethod.GET)
	public String tarea(@Validated Tarea tarea, Model model) {

		System.out.println("Lista de tareas - id : titulo");
		for (int i = 0; i < listaTareas.size(); i++) {
			System.out.println(listaTareas.get(i).getId() + " : " + listaTareas.get(i).getName());
		}

		model.addAttribute("tareas", listaTareas);

		return "tareas";
	}

	// Eliminar Tarea
	@RequestMapping(value = "/tarea/{id}/borrar", method = RequestMethod.GET)
	public String deleteTarea(@PathVariable("id") int id, final RedirectAttributes redirectAttributes, Model model) {

		logger.debug("deleteTarea() : {}", id);
		Tarea eliminada = new Tarea();
		try {
			Tarea t = new Tarea();
			for (Tarea i : listaTareas) {
				if (i.getId() == id) {
					t = i;
					eliminada = t;
					System.out.println("Tarea borrada: " + id);
				}
			}
			listaTareas.remove(t);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		}
		System.out.println("Tamaño actual: " + listaTareas.size());
		model.addAttribute("tarea", eliminada);
		return "delete";
	}

	@RequestMapping(value = "/tarea", method = RequestMethod.GET)
	public String tareaItem(@Validated Tarea tarea, Model model) {
		return "redirect:/tarea";
	}

	// formulario crear tarea y accion post
	@RequestMapping(value = "crear", method = RequestMethod.GET)
	public String loadFormPage(Model m) {
		m.addAttribute("tarea", new Tarea());
		return "create";
	}
	//guardar tarea
	@RequestMapping(value = "crear", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("tareaForm") Tarea tarea, Model model) {
		model.addAttribute("tarea", tarea);

		try {
			Integer nuevoId = listaTareas.get(listaTareas.size()-1).getId()+1;
			tarea.setId(nuevoId);
			listaTareas.add(tarea);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		}

		for (int i = 0; i < listaTareas.size(); i++) {
			System.out.println(listaTareas.get(i).getId() + " : " + listaTareas.get(i).getName());
		}

		model.addAttribute("tareas", listaTareas);
		return "tareas";
	}
	
	@RequestMapping(value = "/tarea/{id}/realizada", method = RequestMethod.GET)
	public String doneTarea(@PathVariable("id") int id, final RedirectAttributes redirectAttributes, Model model) {

		
		Tarea realizada = new Tarea();
		try {
			
			for (Tarea i : listaTareas) {
				if (i.getId() == id) {
					if(i.getDone()==false) {
					i.setDone(true);		
					System.out.println("Tarea realizada: " + id);
					}
					realizada = i;
				}
			}
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		}
		
		model.addAttribute("tarea", realizada);
		return "realizada";
	}

}
