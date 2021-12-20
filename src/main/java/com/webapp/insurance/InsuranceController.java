package com.webapp.insurance;

import com.webapp.classes.accidentInsurance.AccidentInfoModel;
import com.webapp.classes.cascoInsurance.CascoInfoModel;
import com.webapp.classes.householdInsurance.HouseholdInfoModel;
import com.webapp.classes.liabilityInsurance.AOInfoModel;
import com.webapp.classes.travelInsurance.BookTPLModel;
import com.webapp.classes.travelInsurance.TravelInfoModel;
import com.webapp.webservice.ver2.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping(path = "/insurance")
public class InsuranceController {

    private String daysUpdate;

    // TRAVEL
    private String premiumTravel;
    private String messageTravel;
    // HOUSEHOLD
    private String premiumHousehold;
    private String messageHousehold;
    // AO
    private String premiumAO;
    private String messageAO;
    // CASCO
    private String premiumCasco;
    private String messageCasco;
    // ACCIDENT
    private String premiumAccident;
    private String messageAccident;

    /* GET TRAVEL REQUEST */
    @GetMapping(path = "/travel")
    public String showTravelInsurance(Model model) {
        model.addAttribute("travelInfo", new TravelInfoModel());
        model.addAttribute("premiumTravel", premiumTravel);
        model.addAttribute("daysUpdate", daysUpdate);
        model.addAttribute("messageTravel", messageTravel);
        return "travel_form";
    }
    /* POST TRAVEL REQUEST */
    @PostMapping(path = "/travelPost")
    public String processTravelHealth(@ModelAttribute TravelInfoModel travelInfoModel, Model model) {
        
        MyServiceService service = new MyServiceService();
        MyService port = service.getMyServicePort();

        TravelInfo travelInfo = new TravelInfo();
        travelInfo.setType(TypeTravelPolicy.valueOf(travelInfoModel.getType().toString()));
        travelInfo.setCover(TypeCover.valueOf(travelInfoModel.getCover().toString()));
        travelInfo.setDays(travelInfoModel.getDays());
        travelInfo.setNumPeople(travelInfoModel.getNumPeople());
        travelInfo.setIsabove65(travelInfoModel.isIsabove65());
        travelInfo.setIsbelow18(travelInfoModel.isIsbelow18());
        
        QuotationResponse qr = port.getTravelQuotation(travelInfo, AppAuthenticationSuccessHandler.defaultProperties.getProperty("sessionID"));
        if (qr == null) {
            premiumTravel = "0";
            messageTravel = "Настана грешка! Обидете се повторно!";
            return "redirect:/insurance/travel";
        } else {
            if (qr.getCode() == 100) {
                System.out.println("code: " + qr.getCode() + ", premium: " + qr.getPremium());
                daysUpdate = String.valueOf(travelInfoModel.getDays());
                premiumTravel = String.valueOf(qr.getPremium());
                System.out.println("UPDATED DAYS:" + daysUpdate + ";" + travelInfoModel.getDays() + " " + travelInfoModel.getCountry() + " " + travelInfoModel.getCover() + " " + travelInfoModel.getType());
                model.addAttribute("travelInfo", travelInfoModel);
                messageTravel = "Премијата изнесува:";
                return "redirect:/insurance/travel/createTPL";
            } else if (qr.getCode() == 106) {
                messageTravel = "Максимален број на осигурани лица е 10";
            } else if (qr.getCode() == 107) {
                messageTravel = "За групно патничко осигурување ве молиме внесете над четири лице";
            } else if (qr.getCode() == 108) {
                messageTravel = "За семејно патничко осигурување ве молиме внесете над едно лице";
            } else if (qr.getCode() == 109) {
                messageTravel = "Минимален број на денови е 3, максимален е 365";
            } else if (qr.getCode() == 110) {
                messageTravel = "Ве молиме внесете го видот на патничкото осигурување(INDIVIDUAL, FAMILY, STUDENT, GROUP, BUSINESS)";
            } else if (qr.getCode() == 111) {
                messageTravel = "Ве молиме внесете го типот на покритие(CLASSIC, VISA, VIP)";
            } else if (qr.getCode() == 101) {
                messageTravel = "Недостасува број на сесија!";
            } else if (qr.getCode() == 102) {
                messageTravel = "Погрешен број на сесија";
            }
        }
        
        return "redirect:/insurance/travel";
    }

    @GetMapping(path = "/travel/createTPL")
    public String bookTravelPolicy(Model model) {
        model.addAttribute("bookTPLInfo", new BookTPLModel());
        model.addAttribute("premiumTravel", premiumTravel);
        model.addAttribute("messageTravel", messageTravel);
        return "book_tpl_form";
    }

    @PostMapping(path = "/travel/createTPLPost")
    public String processCreateTPL(@ModelAttribute BookTPLModel bookTPLModel, Model model) {
        return "redirect:/insurance/travel/createTPL";
    }
    /* GET HOUSEHOLD REQUEST */
    @GetMapping(path = "/household")
    public String showHouseholdInsurance(Model model) {
        model.addAttribute("householdInfo", new HouseholdInfoModel());
        model.addAttribute("premiumHousehold", premiumHousehold);
        model.addAttribute("messageHousehold", messageHousehold);
        return "household_form";
    }
    /* POST HOUSEHOLD REQUEST */
    @PostMapping(path = "/householdPost")
    public String processHousehold(@ModelAttribute HouseholdInfoModel householdInfoModel, Model model) {
        MyServiceService service = new MyServiceService();
        MyService port = service.getMyServicePort();

        HouseholdInfo householdInfo = new HouseholdInfo();
        householdInfo.setTypeObject(TypeObject.valueOf(householdInfoModel.getTypeObject().toString()));
        householdInfo.setTypeHouseholdCover(TypeHouseholdCover.valueOf(householdInfoModel.getTypeHouseholdCover().toString()));
        householdInfo.setAreaOfObject(householdInfoModel.getAreaOfObject());
        householdInfo.setContractLenght(householdInfoModel.getContractLenght());

        QuotationResponse qr = port.getHouseholdQuotation(householdInfo, "");
        if (qr == null) {
            System.out.println("qr is null!");
            premiumHousehold = "0";
            messageHousehold = "Настана грешка! Обидете се повторно!";
            return "redirect:/insurance/household";
        } else {
            if (qr.getCode() == 100) {
                System.out.println("code: " + qr.getCode() + ", premium: " + qr.getPremium());
                daysUpdate = String.valueOf(householdInfoModel.getAreaOfObject());
                premiumHousehold = String.valueOf(qr.getPremium());
                System.out.println("typeobject: " + householdInfoModel.getTypeObject() + ", area: " + householdInfoModel.getAreaOfObject());                
                model.addAttribute("householdInfoModel", householdInfoModel);
                messageHousehold = "Премијата изнесува:";
            } 
            // TODO
            // vnesi statusni kodovi po potreba
        }

        return "redirect:/insurance/household";
    }

    /* GET LIABILITY REQUEST */
    @GetMapping(path = "/liability")
    public String showAOInsurance(Model model) {
        model.addAttribute("aoInfo", new AOInfoModel());
        model.addAttribute("premiumAO", premiumAO);
        model.addAttribute("messageAO", messageAO);
        return "ao_form";
    }
    /* POST LIABILITY REQUEST */
    @PostMapping(path = "/liabilityPost")
    public String processAO(@ModelAttribute AOInfoModel aoInfoModel, Model model) {
        MyServiceService service = new MyServiceService();
        MyService port = service.getMyServicePort();

        AoInfo aoInfo = new AoInfo();
        aoInfo.setChassis(aoInfoModel.getChassis());
        aoInfo.setRegNum(aoInfoModel.getRegNum());
        aoInfo.setIsNew(aoInfoModel.isNew());
        aoInfo.setKW(aoInfoModel.getKW());

        QuotationResponse qr = port.getAOQuotation(aoInfo, aoInfoModel.getSsn(), "");
        if (qr == null) {
            System.out.println("qr is null!");
            premiumAO = "0";
            messageAO = "Настана грешка! Обидете се повторно!";
            return "redirect:/insurance/liability";
        } else {
            if (qr.getCode() == 100) {
                System.out.println("code: " + qr.getCode() + ", premium: " + qr.getPremium());
                premiumAO = String.valueOf(qr.getPremium());
                System.out.println("chassis: " + aoInfoModel.getChassis() + ", regnum: " + aoInfoModel.getRegNum());                
                model.addAttribute("aoInfoModel", aoInfoModel);
                messageAO = "Премијата изнесува:";
            } 
            // TODO
        }

        return "redirect:/insurance/liability";
    }
    /* GET CASCO REQUEST */
    @GetMapping(path = "/casco")
    public String showCascoInsurance(Model model) {
        model.addAttribute("cascoInfo", new CascoInfoModel());
        model.addAttribute("premiumCasco", premiumCasco);
        model.addAttribute("messageCasco", messageCasco);
        return "casco_form";
    }
    /* POST CASCO REQUEST */
    @PostMapping(path = "/cascoPost")
    public String processCasco(@ModelAttribute CascoInfoModel cascoInfoModel, Model model) {
        MyServiceService service = new MyServiceService();
        MyService port = service.getMyServicePort();

        CascoInfo cascoInfo = new CascoInfo();
        cascoInfo.setTypeCasco(TypeCasco.valueOf(cascoInfoModel.getTypeCascoPolicy().toString()));
        cascoInfo.setTypeValue(TypeValue.valueOf(cascoInfoModel.getTypeValue().toString()));
        cascoInfo.setVehiclePrice(cascoInfoModel.getVehiclePrice());
        cascoInfo.setWindows(cascoInfoModel.isWindows());
        cascoInfo.setFranchise(cascoInfoModel.getFranchise());

        QuotationResponse qr = port.getCascoQuotation(cascoInfo, "");
        if (qr == null) {
            System.out.println("qr is null!");
            premiumCasco = "0";
            messageCasco = "Настана грешка! Обидете се повторно!";
            return "redirect:/insurance/casco";
        } else {
            if (qr.getCode() == 100) {
                System.out.println("code: " + qr.getCode() + ", premium: " + qr.getPremium());
                premiumCasco = String.valueOf(qr.getPremium());
                System.out.println("veh price: " + cascoInfoModel.getVehiclePrice() + ", franchise: " + cascoInfoModel.getFranchise());                
                model.addAttribute("cascoInfoModel", cascoInfoModel);
                messageCasco = "Премијата изнесува:";
            } else {
                messageCasco = String.valueOf(qr.getCode());
                premiumCasco = String.valueOf(qr.getPremium());
            }
            // TODO
        }

        return "redirect:/insurance/casco";
    }
    /* GET ACCIDENT REQUEST */
    @GetMapping(path = "/accident")
    public String showAccidentInsurance(Model model) {
        model.addAttribute("accidentInfo", new AccidentInfoModel());
        model.addAttribute("premiumAccident", premiumAccident);
        model.addAttribute("messageAccident", messageAccident);
        return "accident_form";
    }
    /* POST ACCIDENT REQUEST */
    // @PostMapping(path = "/accidentPost")
    // public String processAccident(@ModelAttribute AccidentInfoModel accidentInfoModel, Model model) {
    //     MyServiceService service = new MyServiceService();
    //     MyService port = service.getMyServicePort();

    //     System.out.println("Date entered is: " + accidentInfoModel.getStartDate());
    //     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    //     GregorianCalendar c = new GregorianCalendar();
    //     XMLGregorianCalendar startDate;
    //     AccidentInfo accidentInfo = new AccidentInfo();
    //     try {
    //         c.setTime(format.parse(accidentInfoModel.getStartDate()));
    //         startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    //         accidentInfo.setStartDate(startDate);
    //     } catch (ParseException e1) {
    //         e1.printStackTrace();
    //     } catch (DatatypeConfigurationException e) {
    //         e.printStackTrace();
    //     }

    //     accidentInfo.setIsStudent(accidentInfoModel.isStudent());
    //     accidentInfo.setPack(accidentInfoModel.getPack());

    //     QuotationResponse qr = port.getAccidentQuotation(accidentInfo, "");
    //     if (qr == null) {
    //         System.out.println("qr is null!");
    //         premiumAccident = "0";
    //         messageAccident = "Настана грешка! Обидете се повторно!";
    //         return "redirect:/insurance/accident";
    //     } else {
    //         if (qr.getCode() == 100) {
    //             System.out.println("code: " + qr.getCode() + ", premium: " + qr.getPremium());
    //             premiumAccident = String.valueOf(qr.getPremium());
    //             System.out.println("pack: " + accidentInfoModel.getPack() + ", startdate: " + accidentInfoModel.getStartDate());                
    //             model.addAttribute("accidentInfoModel", accidentInfoModel);
    //             messageAccident = "Премијата изнесува:";
    //         } else {
    //             messageAccident = String.valueOf(qr.getCode());
    //             premiumAccident = String.valueOf(qr.getPremium());
    //         }
    //         // TODO
    //     }

    //     return "redirect:/insurance/accident";
    // }

    public String getUserDetails(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("username:" + auth.getDetails().toString());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String loggedInEmail = "";
        if (principal instanceof UserDetails) {
            loggedInEmail = ((UserDetails)principal).getUsername();
        } else {
            loggedInEmail = principal.toString();
        }
        System.out.println("loggedinuser: " + loggedInEmail);
        return loggedInEmail;
    }
}
