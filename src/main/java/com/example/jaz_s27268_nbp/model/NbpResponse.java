package com.example.jaz_s27268_nbp.model;

import java.util.ArrayList;
import java.util.List;

//not every field handled
public class NbpResponse {

    public static class Rate {
        private String no, effectiveDate;
        private double mid;

        public Rate() {
        }


        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getEffectiveDate() {
            return effectiveDate;
        }

        public void setEffectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }

    }

    private List<Rate> rates = new ArrayList<>() {
    };

    public NbpResponse() {
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}



