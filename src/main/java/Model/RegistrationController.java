package Model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @GetMapping("/home")
    public String homeIndex(Model model){
        return "index";
    }

    @GetMapping("/indexLogin")
    public String indexLoginForm(Model model){
        return "indexLogin";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        return "registration";
    }

    @PostMapping("/add")
    public String userFormSubmit(@RequestParam String fname, @RequestParam String lname, @RequestParam String email,
                                 @RequestParam String pnumber, @RequestParam String uname, @RequestParam String pword,
                                 @RequestParam String homeAddress, @RequestParam String homeAddress2, @RequestParam String homeCity,
                                 @RequestParam String homeState, @RequestParam String homeZip, @RequestParam String cardName,
                                 @RequestParam String cardNumber, @RequestParam String expirationMonth, @RequestParam String expirationYear,
                                 @RequestParam String billingAddress, @RequestParam String billingAddress2, @RequestParam String subscribe,
                                 @RequestParam String billingCity, @RequestParam String billingState, @RequestParam String billingZip) {

        Email em = new Email(email);
        em.sendVerificationEmail();
        int userID = DBConn.getUserID(uname);
        int emailCheck = DBConn.getEmailID(email);
        pword = DBConn.encryptPassword(pword);

        if(userID == 0 && emailCheck == 0) {
            String userQuery = "INSERT INTO User (userName, password, status) VALUES ( '" + uname + "', '" + pword + "', 'INACTIVE');";
            DBConn.updateDB(userQuery);
            userID = DBConn.getUserID(uname);

            String custQuery = "INSERT INTO Customer (firstName, lastName, emailAddress, emailPromo, userID) VALUES ('" +
                    fname + "', '" + lname + "', '" + email + "', '" + subscribe + "', " + userID + ");";
            DBConn.updateDB(custQuery);

            String homeQuery = "INSERT INTO HomeAddress (street1, street2, city, state, zipCode, userID) VALUES ('" + homeAddress + "', '" +
                    homeAddress2 + "', '" + homeCity + "', '" + homeState + "', '" + homeZip + "', " + userID + ");";
            DBConn.updateDB(homeQuery);
        }else {
            System.out.println("Cannot be entered: Duplicate");
        }

        if(!cardNumber.equals("")){
            String billingQuery = "INSERT INTO BillingAddress (street1, street2, city, state, zipCode) VALUES ('" + billingAddress + "', '" +
                    billingAddress2 + "', '" + billingCity + "', '" + billingState + "', '" + billingZip + "');";
            DBConn.updateDB(billingQuery);
            String ccardQuery = "INSERT INTO CreditCard (cardNumber, expirationMonth, expirationYear, nameOnCard, userID) VALUES ('" +
                    cardNumber +  "', '" + expirationMonth + "', '" + expirationYear + "', '" + cardName + "', " + userID+ ");";
            DBConn.updateDB(ccardQuery);
        }
        return "/regisConfirmPage";
    }

    @PostMapping("/verify")
    public String emailVerify(@RequestParam String inputVerify){
        //do stuff
        if(inputVerify.equalsIgnoreCase("A1B"))
            return "/login";
        else
        {
            return "regisConfirmPage";
        }
    }
    @GetMapping("/fpass")
    public String forgotPassForm(Model model) {
        return "forgotpass";
    }

    @PostMapping("/fpass")
    public String forgotPassVerify(@RequestParam String forgot_username, @RequestParam String forgot_email){
        Email em = new Email(forgot_email);
        em.sendForgetpassEmail();
        return "login";
    }

    @GetMapping("/login")
    public String loginUserForm(Model model) {
        return "login";
    }

    int uid = 0;
    String username = "";
    String password = "";
    @PostMapping("/login")
    public String loginVerify(@RequestParam String lg_username, @RequestParam String lg_password){
        uid = DBConn.getUserID(lg_username);
        username = lg_username;
        password = lg_password;
        password = DBConn.encryptPassword(password);
        String checkPassword = DBConn.getUserPass(username);

        System.out.println("Entered Password: " + password);
        System.out.println("Checked Password: " + checkPassword);

        if(password.equals(checkPassword)) {
            String userQuery = "UPDATE User SET status = 'ACTIVE' WHERE userID = " + uid + ";";
            DBConn.updateDB(userQuery);
            System.out.println(DBConn.getStatus(lg_username));
            return "indexLogin";
        } else {
            return "login";
        }
    }

    @RequestMapping("/editPro")
    public ModelAndView showEditProfilePage(){
        ModelAndView mav = new ModelAndView("editProfile");
        Customer customer = DBConn.getCustomerInfo(username, password);
        BillingAddress billingAddr = DBConn.getBillingAddress(uid);
        mav.addObject("customer", customer);
        mav.addObject("billingAddr", billingAddr);

        return mav;
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String saveProduct(@ModelAttribute("customer") Customer customer) {
        System.out.println("im here");

        return "redirect:/indexLogin";
    }

    @GetMapping("/logout")
    public String logoutForm(Model model){
        uid = DBConn.getUserID(username);
        //do stuff
        String userQuery = "UPDATE User SET status = 'INACTIVE' WHERE userID = "+ uid +";";
        DBConn.updateDB(userQuery);
        System.out.println(DBConn.getStatus(username));
        return "logout";
    }

    @PostMapping("/logout")
    public String logoutProfile(){
        return "/home";
    }





}