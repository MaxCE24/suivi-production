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

import net.atos.suiviproduction.exception.DemandeDAchatNotFound;
import net.atos.suiviproduction.model.Collaborateur;
import net.atos.suiviproduction.model.DemandeDAchat;
import net.atos.suiviproduction.service.CollaborateurService;
import net.atos.suiviproduction.service.DemandeDAchatService;
import net.atos.suiviproduction.validation.DemandeDAchatValidator;

@Controller
@RequestMapping(value = "/demandeDAchat")
public class DemandeDAchatController {

	@Autowired
	private DemandeDAchatService demandeDAchatService;

	@Autowired
	private CollaborateurService collaborateurService;

	@Autowired
	private DemandeDAchatValidator demandeDAchatValidator;

	private List<Collaborateur> collaborateursList;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(demandeDAchatValidator);
		// The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newAstreintePage() {

		ModelAndView mav = new ModelAndView("demandeDAchat-new", "demandeDAchat", new DemandeDAchat());

		collaborateursList = collaborateurService.findAll();

		mav.addObject("collaborateurs", collaborateursList);

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewDemandeDAchat(@ModelAttribute @Valid DemandeDAchat demandeDAchat, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("demandeDAchat-new");
			mav.addObject("collaborateurs", collaborateursList);
			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "La nouvelle demande d'achat " + demandeDAchat.getNumero() + " a été créée avec succès.";

		demandeDAchatService.create(demandeDAchat);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView demandeDAchatListPage() {
		ModelAndView mav = new ModelAndView("demandeDAchat-list");
		List<DemandeDAchat> demandeDAchatList = demandeDAchatService.findAll();
		mav.addObject("demandeDAchatList", demandeDAchatList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editDemandeDAchatPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("demandeDAchat-edit");
		DemandeDAchat demandeDAchat = demandeDAchatService.findById(id);
		mav.addObject("demandeDAchat", demandeDAchat);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editDemandeDAchat(@ModelAttribute @Valid DemandeDAchat demandeDAchat, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws DemandeDAchatNotFound {

		if (result.hasErrors())
			return new ModelAndView("demandeDAchat-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "La demande d'achat a été mise-à-jour avec succès.";

		demandeDAchatService.update(demandeDAchat);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDemandeDAchat(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws DemandeDAchatNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		DemandeDAchat demandeDAchat = demandeDAchatService.delete(id);
		String message = "La demande d'achat " + demandeDAchat.getNumero() + " a  été supprimée avec succès.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
