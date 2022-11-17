package tn.esb.bis.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bis.demo.Repositories.R_Book;

@Service
public class S_Address {
    @Autowired
    private R_Book repository;

}
