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

import net.atos.suiviproduction.exception.EquipeNotFound;
import net.atos.suiviproduction.model.Equipe;
import net.atos.suiviproduction.service.EquipeService;
import net.atos.suiviproduction.validation.EquipeValidator;

@Controller
@RequestMapping(value = "/equipe")
public class EquipeController {

	@Autowired
	private EquipeService equipeService;

	@Autowired
	private EquipeValidator equipeValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(equipeValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newEquipePage() {

		ModelAndView mav = new ModelAndView("equipe-new", "equipe", new Equipe());

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewEquipe(@ModelAttribute @Valid Equipe equipe, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("equipe-new");

			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "La nouvelle équipe a été ajoutée.";

		equipeService.create(equipe);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView equipeListPage() {
		ModelAndView mav = new ModelAndView("equipe-list");
		List<Equipe> equipeList = equipeService.findAll();
		mav.addObject("equipeList", equipeList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEquipePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("equipe-edit");
		Equipe equipe = equipeService.findById(id);
		mav.addObject("equipe", equipe);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editValidation(@ModelAttribute @Valid Equipe equipe, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws EquipeNotFound {

		if (result.hasErrors())
			return new ModelAndView("equipe-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "L'équipe a été modifiée avec succès.";

		equipeService.update(equipe);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteValidation(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws EquipeNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		equipeService.delete(id);
		String message = "L'équipe a été retirée avec succès.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
