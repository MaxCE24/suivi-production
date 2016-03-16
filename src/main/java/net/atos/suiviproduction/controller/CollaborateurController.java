package net.atos.suiviproduction.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.atos.suiviproduction.exception.CollaborateurNotFound;
import net.atos.suiviproduction.model.Collaborateur;
import net.atos.suiviproduction.service.CollaborateurService;
import net.atos.suiviproduction.validation.CollaborateurValidator;

@Controller
@RequestMapping(value = "/collaborateur")
public class CollaborateurController {

	@Autowired
	private CollaborateurService collaborateurService;

	@Autowired
	private CollaborateurValidator collaborateurValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(collaborateurValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newCollaborateurPage() {
		ModelAndView mav = new ModelAndView("collaborateur-new", "collaborateur", new Collaborateur());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewCollaborateur(@ModelAttribute @Valid Collaborateur collaborateur, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("collaborateur-new");

		ModelAndView mav = new ModelAndView();
		String message = "Le nouveau collaborateur " + collaborateur.getPrenom() + " " + collaborateur.getNom()
				+ " a été créé avec succès.";

		collaborateurService.create(collaborateur);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView collaborateurListPage() {
		ModelAndView mav = new ModelAndView("collaborateur-list");
		List<Collaborateur> collaborateurList = collaborateurService.findAll();
		mav.addObject("collaborateurList", collaborateurList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCollaborateurPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("collaborateur-edit");
		Collaborateur collaborateur = collaborateurService.findById(id);
		mav.addObject("collaborateur", collaborateur);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editCollaborateur(@ModelAttribute @Valid Collaborateur collaborateur, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws CollaborateurNotFound {

		if (result.hasErrors())
			return new ModelAndView("collaborateur-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Collaborateur was successfully updated.";

		collaborateurService.update(collaborateur);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCollaborateur(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws CollaborateurNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Collaborateur collaborateur = collaborateurService.delete(id);
		String message = "The collaborateur " + collaborateur.getPrenom() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
