package com.cognizant.loan;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Loan getMethodName(@PathVariable String number) {
        return new Loan(number, "car", 400000, 3258, 18);
    }
    
    static class Loan{
        private String number;
        private String type;
        private Integer loan;
        private Integer emi;
        private Integer tenure;

        public Loan(String number, String type, Integer loan, Integer emi, Integer tenure){
            this.number = number;
            this.type = type;
            this.loan = loan;
            this.emi = emi;
            this.tenure = tenure;
        }

        public String getNumber(){
            return number;
        }

        public String getType(){
            return type;
        }

        public Integer getLoan(){
            return loan;
        }

        public Integer getEmi(){
            return emi;
        }

        public Integer getTenure(){
            return tenure;
        }

    }
}
