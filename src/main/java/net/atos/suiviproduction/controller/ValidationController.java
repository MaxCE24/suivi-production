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

import net.atos.suiviproduction.exception.ValidationNotFound;
import net.atos.suiviproduction.model.Collaborateur;
import net.atos.suiviproduction.model.DemandeDAchat;
import net.atos.suiviproduction.model.Validation;
import net.atos.suiviproduction.service.CollaborateurService;
import net.atos.suiviproduction.service.DemandeDAchatService;
import net.atos.suiviproduction.service.ValidationService;
import net.atos.suiviproduction.validation.ValidationValidator;

@Controller
@RequestMapping(value = "/validation")
public class ValidationController {

	@Autowired
	private ValidationService validationService;

	@Autowired
	private DemandeDAchatService demandeDAchatService;

	@Autowired
	private CollaborateurService collaborateurService;

	private List<DemandeDAchat> demandesDAchatList;

	private List<Collaborateur> collaborateursList;

	@Autowired
	private ValidationValidator validationValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validationValidator);
		// The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newValidationPage() {

		ModelAndView mav = new ModelAndView("validation-new", "validation", new Validation());

		demandesDAchatList = demandeDAchatService.findAll();
		collaborateursList = collaborateurService.findAll();

		mav.addObject("demandesDAchat", demandesDAchatList);
		mav.addObject("collaborateurs", collaborateursList);

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewDemandeDAchat(@ModelAttribute @Valid Validation validation, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("validation-new");
			mav.addObject("demandesDAchat", demandesDAchatList);
			mav.addObject("collaborateurs", collaborateursList);
			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "La nouvelle validation a été prise en compte.";

		validationService.create(validation);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView validationListPage() {
		ModelAndView mav = new ModelAndView("validation-list");
		List<Validation> validationList = validationService.findAll();
		mav.addObject("validationList", validationList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editValidationPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("validation-edit");
		Validation validation = validationService.findById(id);
		mav.addObject("validation", validation);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editValidation(@ModelAttribute @Valid Validation validation, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ValidationNotFound {

		if (result.hasErrors())
			return new ModelAndView("validation-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "La validation a été prise en compte avec succès.";

		validationService.update(validation);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteValidation(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws ValidationNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		validationService.delete(id);
		String message = "La validation a été retirée avec succès.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
