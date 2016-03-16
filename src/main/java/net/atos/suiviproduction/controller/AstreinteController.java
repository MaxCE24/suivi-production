package net.atos.suiviproduction.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import net.atos.suiviproduction.exception.AstreinteNotFound;
import net.atos.suiviproduction.model.Astreinte;
import net.atos.suiviproduction.model.Collaborateur;
import net.atos.suiviproduction.service.AstreinteService;
import net.atos.suiviproduction.service.CollaborateurService;
import net.atos.suiviproduction.validation.AstreinteValidator;

@Controller
@RequestMapping(value = "/astreinte")
public class AstreinteController {

	@Autowired
	private AstreinteService astreinteService;

	@Autowired
	private CollaborateurService collaborateurService;

	@Autowired
	private AstreinteValidator astreinteValidator;

	private List<Collaborateur> collaborateursList;

	// private SortedMap<Integer, Collaborateur> collaborateurs;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(astreinteValidator);
		// The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newAstreintePage() {

		ModelAndView mav = new ModelAndView("astreinte-new", "astreinte", new Astreinte());
		collaborateursList = collaborateurService.findAll();

		/*
		 * collaborateurs = new TreeMap<Integer, Collaborateur>(); for
		 * (Collaborateur collaborateur : collaborateursList) {
		 * collaborateurs.put(collaborateur.getId(), collaborateur); }
		 */
		mav.addObject("collaborateurs", collaborateursList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewAstreinte(@ModelAttribute @Valid Astreinte astreinte, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("astreinte-new");
			mav.addObject("collaborateurs", collaborateursList);
			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "La nouvelle astreinte " + astreinte.getReference() + " a été créée avec succès.";
		System.out.println("ID: " + astreinte.getCollaborateur().getId());

		astreinteService.create(astreinte);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView astreinteListPage() {
		ModelAndView mav = new ModelAndView("astreinte-list");
		List<Astreinte> astreinteList = astreinteService.findAll();
		mav.addObject("astreinteList", astreinteList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editAstreintePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("astreinte-edit");
		Astreinte astreinte = astreinteService.findById(id);
		mav.addObject("astreinte", astreinte);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editAstreinte(@ModelAttribute @Valid Astreinte astreinte, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws AstreinteNotFound {

		if (result.hasErrors())
			return new ModelAndView("astreinte-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "L'astreinte a été mise-à-jour avec succès.";

		astreinteService.update(astreinte);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteAstreinte(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws AstreinteNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Astreinte astreinte = astreinteService.delete(id);
		String message = "L'astreinte " + astreinte.getReference() + " a été supprimée avec succès.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
