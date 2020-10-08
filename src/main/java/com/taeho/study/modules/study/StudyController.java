package com.taeho.study.modules.study;

import com.taeho.study.modules.account.CurrentAccount;
import com.taeho.study.modules.account.Account;
import com.taeho.study.modules.study.form.StudyForm;
import com.taeho.study.modules.study.validator.StudyFormValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class StudyController {
    private final StudyRepository studyRepository;
    private final StudyService studyService;
    private final ModelMapper modelMapper;
    private final StudyFormValidator studyFormValidator;

    @InitBinder("studyForm")
    public void studyFormInitBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(studyFormValidator);
    }

    @GetMapping("/new-study")
    public String newStudyForm(@CurrentAccount Account account, Model model) {
        model.addAttribute(account);
        model.addAttribute(new StudyForm());
        return "study/form";
    }

    @PostMapping("/new-study")
    public String newStudySubmit(@CurrentAccount Account account, @Valid StudyForm studyForm, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute(account);
            return "study/form";
        }

        Study newStudy = studyService.createNewStudy(modelMapper.map(studyForm, Study.class), account);

        return "redirect:/study/" + newStudy.getEncodedPath();
    }

    @GetMapping("/study/{path}")
    public String viewStudy(@CurrentAccount Account account, @PathVariable String path, Model model){
        Study study = studyService.getStudy(path);

        model.addAttribute(account);
        model.addAttribute(study);
        return "study/view";
    }

    @GetMapping("/study/{path}/members")
    public String viewStudyMembers(@CurrentAccount Account account, @PathVariable String path, Model model){
        Study study = studyService.getStudy(path);
        model.addAttribute(account);
        model.addAttribute(study);
        return "study/members";
    }

    @GetMapping("/study/{path}/join")
    public String joinStudy(@CurrentAccount Account account, @PathVariable String path){
        Study study = studyRepository.findStudyWithMembersByPath(path);
        studyService.addMember(study, account);

        return "redirect:/study/" + study.getEncodedPath() + "/members";
    }

    @GetMapping("/study/{path}/leave")
    public String leaveStudy(@CurrentAccount Account account, @PathVariable String path){
        Study study = studyRepository.findStudyWithMembersByPath(path);
        studyService.removeMember(study, account);

        return "redirect:/study/" + study.getEncodedPath() + "/members";
    }

    @GetMapping("/study/data")
    public String generateTestData(@CurrentAccount Account account){
        studyService.generateTestStudies(account);
        return "redirect:/";
    }
}