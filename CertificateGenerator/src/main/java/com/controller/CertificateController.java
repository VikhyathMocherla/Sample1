package com.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bouncycastle.asn1.x500.X500Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.issuer.CertificateIssuer;
import com.rest.CertificateGenerator;
import com.service.CertificateService;

@RestController
public class CertificateController {

	@Autowired
	CertificateService service;
	
	/*@PostMapping("/acceptdetails")
	 public ResponseEntity generateCertificate(@RequestBody CertificateIssuer req)
	 {
		X509 x= new X509(req.getCOMMON_NAME());
		X509 x= new X509(req.getORGANIZATION());
		X509 x= new X509(req.getORGANIZATIONAL_UNIT());
		X509 x= new X509(req.getCOUNTRY());
		X509 x= new X509(req.getLOCALITY());
		X509 x= new X509(req.getSTATE());
		X509 x= new X509(req.getE_MAIL_ADDRESS());
	 }
	*/
	
	@GetMapping("/displaydetails")
	public ArrayList<CertificateIssuer> displayCertificate()
	{
		return service.getCertificateList();
	}
	
	@PostMapping("/acceptdetails")
	public ResponseEntity<?> generateCertificate(@RequestBody CertificateIssuer c) throws Exception
	{
		CertificateGenerator cGen=new CertificateGenerator();
		cGen.certificateGenerator(c.getCOMMON_NAME(), c.getORGANIZATION(), c.getORGANIZATIONAL_UNIT(), c.getCOUNTRY(), c.getLOCALITY(), c.getSTATE(), c.getE_MAIL_ADDRESS());
		service.addCertificate(c);
		return new ResponseEntity<>("Certificate generated",HttpStatus.CREATED);
	}
	
}
	