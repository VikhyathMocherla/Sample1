package com.service;
import java.util.*;
import org.springframework.stereotype.Service;
import com.issuer.CertificateIssuer;

@Service
public class CertificateService {

	ArrayList<CertificateIssuer> certificatelist=new ArrayList<>();
	
	public void addCertificate(CertificateIssuer c)
	{
		certificatelist.add(c);
	}
	public ArrayList<CertificateIssuer> getCertificateList()
	{
		return certificatelist;
	}
}
