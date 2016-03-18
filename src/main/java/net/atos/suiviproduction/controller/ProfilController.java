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

import net.atos.suiviproduction.exception.ProfilNotFound;
import net.atos.suiviproduction.model.Profil;
import net.atos.suiviproduction.service.ProfilService;
import net.atos.suiviproduction.validation.ProfilValidator;

@Controller
@RequestMapping(value = "/profil")
public class ProfilController {

	@Autowired
	private ProfilService profilService;

	@Autowired
	private ProfilValidator profilValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(profilValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newProfilPage() {

		ModelAndView mav = new ModelAndView("profil-new", "profil", new Profil());

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewProfil(@ModelAttribute @Valid Profil profil, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("profil-new");

			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "La nouveau profil a été ajouté.";

		profilService.create(profil);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView profilListPage() {
		ModelAndView mav = new ModelAndView("profil-list");
		List<Profil> profilList = profilService.findAll();
		mav.addObject("profilList", profilList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProfilPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("profil-edit");
		Profil profil = profilService.findById(id);
		mav.addObject("profil", profil);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editValidation(@ModelAttribute @Valid Profil profil, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ProfilNotFound {

		if (result.hasErrors())
			return new ModelAndView("profil-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Le profil a été modifié avec succès.";

		profilService.update(profil);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteValidation(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws ProfilNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		profilService.delete(id);
		String message = "Le profil a été retiré avec succès.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
