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

import net.atos.suiviproduction.exception.SousTraitantNotFound;
import net.atos.suiviproduction.model.Equipe;
import net.atos.suiviproduction.model.Profil;
import net.atos.suiviproduction.model.Societe;
import net.atos.suiviproduction.model.SousTraitant;
import net.atos.suiviproduction.service.EquipeService;
import net.atos.suiviproduction.service.ProfilService;
import net.atos.suiviproduction.service.SocieteService;
import net.atos.suiviproduction.service.SousTraitantService;
import net.atos.suiviproduction.validation.SousTraitantValidator;

@Controller
@RequestMapping(value = "/sousTraitant")
public class SousTraitantController {

	@Autowired
	private SousTraitantService sousTraitantService;

	@Autowired
	private EquipeService equipeService;
	@Autowired
	private ProfilService profilService;
	@Autowired
	private SocieteService societeService;

	@Autowired
	private SousTraitantValidator sousTraitantValidator;

	private List<Equipe> equipesList;
	private List<Profil> profilsList;
	private List<Societe> societesList;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(sousTraitantValidator);
		// The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newAstreintePage() {

		ModelAndView mav = new ModelAndView("sousTraitant-new", "sousTraitant", new SousTraitant());

		equipesList = equipeService.findAll();
		profilsList = profilService.findAll();
		societesList = societeService.findAll();

		mav.addObject("equipes", equipesList);
		mav.addObject("profils", profilsList);
		mav.addObject("societes", societesList);

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSousTraitant(@ModelAttribute @Valid SousTraitant sousTraitant, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("sousTraitant-new");
			mav.addObject("equipes", equipesList);
			mav.addObject("profils", profilsList);
			mav.addObject("societes", societesList);
			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "La nouveau sous-traitant " + sousTraitant.getPrenom() + " " + sousTraitant.getNom()
				+ " a été ajouté avec succès.";

		sousTraitantService.create(sousTraitant);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView sousTraitantListPage() {
		ModelAndView mav = new ModelAndView("sousTraitant-list");
		List<SousTraitant> sousTraitantList = sousTraitantService.findAll();
		mav.addObject("sousTraitantList", sousTraitantList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSousTraitantPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("sousTraitant-edit");
		SousTraitant sousTraitant = sousTraitantService.findById(id);
		mav.addObject("sousTraitant", sousTraitant);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editSousTraitant(@ModelAttribute @Valid SousTraitant sousTraitant, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws SousTraitantNotFound {

		if (result.hasErrors())
			return new ModelAndView("sousTraitant-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Le sous-traitant a été mis-à-jour avec succès.";

		sousTraitantService.update(sousTraitant);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSousTraitant(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws SousTraitantNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		SousTraitant sousTraitant = sousTraitantService.delete(id);
		String message = "Le sous-traitant " + sousTraitant.getPrenom() + " " + sousTraitant.getNom()
				+ " a  été supprimé avec succès.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
