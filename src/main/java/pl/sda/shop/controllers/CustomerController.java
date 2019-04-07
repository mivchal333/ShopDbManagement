package pl.sda.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.shop.domain.Customer;
import pl.sda.shop.service.CustomerService;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @RequestMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }

    @RequestMapping("/customers/{id}")
    public String showCustomer(@PathVariable Integer id, Model model) {
        Optional<Customer> customerOpt = customerService.getCustomerById(id);
        if (customerOpt.isPresent()) {
            model.addAttribute("customer", customerOpt.get());
        }
        return "customer";
    }

    @RequestMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerForm";
    }

    @PostMapping("/customers")
    public String saveOrUpdateCustomer(Customer customer) {
        Customer savedCustomer = customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customers/" + savedCustomer.getId();
    }

    @RequestMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    @RequestMapping(value = "/customers/new")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

}
