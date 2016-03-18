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

import net.atos.suiviproduction.exception.SocieteNotFound;
import net.atos.suiviproduction.model.Societe;
import net.atos.suiviproduction.service.SocieteService;
import net.atos.suiviproduction.validation.SocieteValidator;

@Controller
@RequestMapping(value = "/societe")
public class SocieteController {

	@Autowired
	private SocieteService societeService;

	@Autowired
	private SocieteValidator societeValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(societeValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSocietePage() {

		ModelAndView mav = new ModelAndView("societe-new", "societe", new Societe());

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSociete(@ModelAttribute @Valid Societe societe, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("societe-new");

			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "La nouvelle société a été ajoutée.";

		societeService.create(societe);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView societeListPage() {
		ModelAndView mav = new ModelAndView("societe-list");
		List<Societe> societeList = societeService.findAll();
		mav.addObject("societeList", societeList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSocietePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("societe-edit");
		Societe societe = societeService.findById(id);
		mav.addObject("societe", societe);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editValidation(@ModelAttribute @Valid Societe societe, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws SocieteNotFound {

		if (result.hasErrors())
			return new ModelAndView("societe-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "La société a été modifiée avec succès.";

		societeService.update(societe);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteValidation(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws SocieteNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		societeService.delete(id);
		String message = "La société a été retirée avec succès.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
