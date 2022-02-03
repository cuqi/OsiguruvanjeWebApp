package com.webapp.insurance;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import java.util.prefs.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.webapp.classes.accidentInsurance.AccidentInfoModel;
import com.webapp.classes.cascoInsurance.CascoInfoModel;
import com.webapp.classes.householdInsurance.HouseholdInfoModel;
import com.webapp.classes.liabilityInsurance.AOInfoModel;
import com.webapp.classes.travelInsurance.BookInfoModel;
import com.webapp.classes.travelInsurance.TravelInfoModel;
import com.webapp.webservice.ver2.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller 
@RequestMapping(path = "/insurance")
public class InsuranceController {

    public boolean canProceed;
    public int typePolicy;
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

    public TravelInfo g_travelInfo;
    public AoInfo g_aoInfo;
    public HouseholdInfo g_householdInfo;
    public CascoInfo g_cascoInfo;
    public AccidentInfo g_accidentInfo;

    public HouseholdInfoModel g_householdInfoModel;
    public TravelInfoModel g_travelInfoModel;
    public AOInfoModel g_aoInfoModel;
    public AccidentInfoModel g_accidentInfoModel;
    public CascoInfoModel g_cascoInfoModel;

    

    /* GET TRAVEL REQUEST */
    @GetMapping(path = "/travel")
    public String showTravelInsurance(Model model) {
        model.addAttribute("travelInfo", new TravelInfoModel());
        model.addAttribute("premiumTravel", premiumTravel);
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
                premiumTravel = String.valueOf(qr.getPremium());
                model.addAttribute("travelInfo", travelInfoModel);
                messageTravel = qr.getMessage();
                g_travelInfo = travelInfo;
                return "redirect:/insurance/travel/createTPL";
            } else {
                messageTravel = qr.getMessage();
            }
        }
        return "redirect:/insurance/travel";
    }

    @GetMapping(path = "/travel/createTPL")
    public String bookTravelPolicy(Model model) {
        model.addAttribute("bookTPLInfo", new BookInfoModel());
        model.addAttribute("premiumTravel", premiumTravel);
        model.addAttribute("messageTravel", messageTravel);
        return "book_tpl_form";
    }

    @PostMapping(path = "/travel/createTPLPost")
    public String processCreateTPL(@ModelAttribute BookInfoModel bookModel, Model model) {
        MyServiceService service = new MyServiceService();
        MyService port = service.getMyServicePort();

        InsuredInfo owner = new InsuredInfo();
        InsuredInfo insured = new InsuredInfo();

        owner.setFirstName(bookModel.getC_firstName());
        owner.setLastName(bookModel.getC_lastName());
        owner.setAddress(bookModel.getC_address());
        owner.setCity(bookModel.getC_city());
        owner.setSsn(bookModel.getC_ssn());
        owner.setPostalCode(bookModel.getC_postalCode());

        insured.setFirstName(bookModel.getI_firstName());
        insured.setLastName(bookModel.getI_lastName());
        insured.setAddress(bookModel.getI_address());
        insured.setCity(bookModel.getI_city());
        insured.setSsn(bookModel.getI_ssn());
        insured.setPostalCode(bookModel.getI_postalCode());

        System.out.println(bookModel.toString());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar c = new GregorianCalendar();
        XMLGregorianCalendar startDate = null;
        try {
            c.setTime(format.parse(bookModel.getStartDate()));
            startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        BookResponse bookResponse = port.bookTravelPolicy(g_travelInfo, owner, insured, AppAuthenticationSuccessHandler.defaultProperties.getProperty("sessionID"), startDate);
        if (bookResponse == null) {
            System.out.println("bookResponse is null");
            premiumTravel = "0";
            messageTravel = "Настана грешка! Обидете се повторно!";
            return "redirect:/insurance/travel/createTPL";
        } else {
            if (bookResponse.getCode() == 100) {
                System.out.println(bookResponse.getCode() + " " + bookResponse.getMessage());
                return "redirect:/checkout";
            } else {
                return "redirect:/insurance/travel/createTPL";
            }
        }
    }
    /* GET HOUSEHOLD REQUEST */
    @GetMapping(path = "/household")
    public String showHouseholdInsurance(Model model) {
        if (!model.containsAttribute("householdInfo")) {
            model.addAttribute("householdInfo", new HouseholdInfoModel());
        }
        model.addAttribute("premiumHousehold", premiumHousehold);
        model.addAttribute("messageHousehold", messageHousehold);
        return "household_form";
    }
    /* POST HOUSEHOLD REQUEST */
    @PostMapping(path = "/householdPost")
    public String processHousehold(@ModelAttribute HouseholdInfoModel householdInfoModel, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        MyServiceService service = new MyServiceService();
        MyService port = service.getMyServicePort();

        HouseholdInfo householdInfo = new HouseholdInfo();
        householdInfo.setTypeObject(TypeObject.valueOf(householdInfoModel.getTypeObject().toString()));
        householdInfo.setTypeHouseholdCover(TypeHouseholdCover.valueOf(householdInfoModel.getTypeHouseholdCover().toString()));
        householdInfo.setAreaOfObject(householdInfoModel.getAreaOfObject());
        householdInfo.setContractLenght(Integer.valueOf(householdInfoModel.getContractLenght()));

        QuotationResponse qr = port.getHouseholdQuotation(householdInfo, AppAuthenticationSuccessHandler.defaultProperties.getProperty("sessionID"));
        if (qr == null) {
            System.out.println("qr is null!");
            premiumHousehold = "0";
            messageHousehold = "Настана грешка! Обидете се повторно!";
            return "redirect:/insurance/household";
        } else {
            if (qr.getCode() == 100) {
                premiumHousehold = String.valueOf(qr.getPremium());        
                g_householdInfoModel = householdInfoModel;
                g_householdInfo = householdInfo;
                messageHousehold = qr.getMessage();
                typePolicy = 2;
                redirectAttributes.addFlashAttribute("householdInfo", householdInfoModel);
                return "redirect:/insurance/household";
            } else {
                messageHousehold = qr.getMessage();
                return "redirect:/insurance/household";
            }
        }
    }

    @GetMapping(path = "/createPolicy")
    public String createPolicy(Model model) {
        System.out.print("Vnatre vo GET /createPolicy");
        model.addAttribute("bookInfoModel", new BookInfoModel());
        return "book_hh_form";
    }

    @PostMapping(path = "/createPolicy")
    public String createHousehold(@ModelAttribute BookInfoModel bookInfoModel, Model model, RedirectAttributes redirectAttributes) {

        System.out.println("Vrednost na globalbook" + g_householdInfoModel.toString());

        String paymentAmount = "0";

        MyServiceService service = new MyServiceService();
        MyService port = service.getMyServicePort();

        InsuredInfo owner = new InsuredInfo();
        InsuredInfo insured = new InsuredInfo();

        owner.setFirstName(bookInfoModel.getC_firstName());
        owner.setLastName(bookInfoModel.getC_lastName());
        owner.setAddress(bookInfoModel.getC_address());
        owner.setCity(bookInfoModel.getC_city());
        owner.setSsn(bookInfoModel.getC_ssn());
        owner.setPostalCode(bookInfoModel.getC_postalCode());

        if (bookInfoModel.getI_firstName() == null) {
            insured = owner;
        } else {
            insured.setFirstName(bookInfoModel.getI_firstName());
            insured.setLastName(bookInfoModel.getI_lastName());
            insured.setAddress(bookInfoModel.getI_address());
            insured.setCity(bookInfoModel.getI_city());
            insured.setSsn(bookInfoModel.getI_ssn());
            insured.setPostalCode(bookInfoModel.getI_postalCode());
        }


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar c = new GregorianCalendar();
        XMLGregorianCalendar startDate = null;
        try {
            c.setTime(format.parse(bookInfoModel.getStartDate()));
            startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        BookResponse bookResponse = new BookResponse();

        String sessionID = AppAuthenticationSuccessHandler.defaultProperties.getProperty("sessionID");

        switch(typePolicy) {
            case 1:
                bookResponse = port.bookTravelPolicy(g_travelInfo, owner, insured, sessionID, startDate);
                paymentAmount = premiumTravel;

                Preferences prefs = Preferences.userNodeForPackage(ChargeController.class);
                prefs.put("payment", paymentAmount);
                break;
            case 2:
                bookResponse = port.bookHouseholdPolicy(g_householdInfo, owner, startDate, sessionID);
                paymentAmount = premiumHousehold;
                break;
            case 3:
                bookResponse = port.bookAOPolicy(g_aoInfo, owner, startDate, sessionID);
                paymentAmount = premiumAO;
                break;
            case 4:
                bookResponse = port.bookCascoPolicy(g_cascoInfo, owner, startDate, sessionID);
                paymentAmount = premiumCasco;
                break;
            case 5:
                bookResponse = port.bookAccidentPolicy(g_accidentInfo, owner, sessionID);
                paymentAmount = premiumAccident;
                break;
            default:
                return "redirect:/insurance/createPolicy";
        }       
        
        if (bookResponse.getCode() == 100) {
            model.addAttribute("payment", paymentAmount);
            return "redirect:/checkout";
        } else {
            redirectAttributes.addFlashAttribute("bookInfoModel", bookInfoModel);
            return "redirect:/insurance/createPolicy";
        }


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
    @PostMapping(path = "/accidentPost")
    public String processAccident(@ModelAttribute AccidentInfoModel accidentInfoModel, Model model) {
        MyServiceService service = new MyServiceService();
        MyService port = service.getMyServicePort();

        System.out.println("Date entered is: " + accidentInfoModel.getStartDate());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar c = new GregorianCalendar();
        XMLGregorianCalendar startDate;
        AccidentInfo accidentInfo = new AccidentInfo();
        try {
            c.setTime(format.parse(accidentInfoModel.getStartDate()));
            startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            accidentInfo.setStartDate(startDate);
        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        accidentInfo.setIsStudent(accidentInfoModel.isStudent());
        accidentInfo.setPack(accidentInfoModel.getPack());

        // QuotationResponse qr = port.getAccidentQuotation(accidentInfo, "");
        // if (qr == null) {
        //     System.out.println("qr is null!");
        //     premiumAccident = "0";
        //     messageAccident = "Настана грешка! Обидете се повторно!";
        //     return "redirect:/insurance/accident";
        // } else {
        //     if (qr.getCode() == 100) {
        //         System.out.println("code: " + qr.getCode() + ", premium: " + qr.getPremium());
        //         premiumAccident = String.valueOf(qr.getPremium());
        //         System.out.println("pack: " + accidentInfoModel.getPack() + ", startdate: " + accidentInfoModel.getStartDate());                
        //         model.addAttribute("accidentInfoModel", accidentInfoModel);
        //         messageAccident = "Премијата изнесува:";
        //     } else {
        //         messageAccident = String.valueOf(qr.getCode());
        //         premiumAccident = String.valueOf(qr.getPremium());
        //     }
        //     // TODO
        // }

        return "redirect:/insurance/accident";
    }

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
