/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;
import java.time.*;

/**
 *
 * @author child
 */
public class CertOfDeposit {
    private int certificateNumber;
    private String lastName;
    private float balance;
    private LocalDate issueDate;
    private LocalDate maturityDate;

    public CertOfDeposit(int certificateNumber, String lastName, float balance, LocalDate issueDate) {
        this.certificateNumber = certificateNumber;
        this.lastName = lastName;
        this.balance = balance;
        this.issueDate = issueDate;
        this.maturityDate = issueDate.plusYears(1);
    }

    
    public int getCertificateNumber() {
        return this.certificateNumber;
    }

    public void setCertificateNumber(int certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }
   
}
