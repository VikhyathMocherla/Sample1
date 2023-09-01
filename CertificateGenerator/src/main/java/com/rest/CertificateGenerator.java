package com.rest;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class CertificateGenerator{

    public void certificateGenerator(String cOMMON_NAME, String oRGANIZATION, String oRGANIZATIONAL_UNIT, String cOUNTRY,
			String lOCALITY, String sTATE, String e_MAIL_ADDRESS) throws Exception {
        // Add Bouncy Castle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        // Generate key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Create self-signed certificate
        
        X500Name issuer = new X500Name("CN="+cOMMON_NAME+",O="+oRGANIZATION+",C="+cOUNTRY+",L="+lOCALITY+"");
        BigInteger serial = BigInteger.valueOf(new SecureRandom().nextInt(Integer.MAX_VALUE));
        Date notBefore = Date.from(LocalDate.now().atStartOfDay(ZoneOffset.UTC).toInstant());
        Date notAfter = Date.from(LocalDate.now().plusYears(1).atStartOfDay(ZoneOffset.UTC).toInstant());

        // Cast the public key to SubjectPublicKeyInfo
        SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded());

        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(keyPair.getPrivate());

        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(
                issuer,
                serial,
                notBefore,
                notAfter,
                issuer, // Using issuer as subject for self-signed certificate
                publicKeyInfo // Casted public key
        );

        X509CertificateHolder selfSignedCert = certBuilder.build(signer);

        // Define absolute paths for file storage
        String projectRoot = System.getProperty("user.dir");
        String privateKeyPath = projectRoot + "/private.key";
        String certificatePath = projectRoot + "/certificate.crt";
        String csrPath = projectRoot + "/csr.csr";

        // Save private key
        try (FileOutputStream keyOut = new FileOutputStream(privateKeyPath)) {
            keyOut.write(keyPair.getPrivate().getEncoded());
        }

        // Save certificate
        try (FileOutputStream certOut = new FileOutputStream(certificatePath)) {
            certOut.write(selfSignedCert.getEncoded());
        }

        // Print the absolute paths for reference
        System.out.println("Private Key Path: " + privateKeyPath);
        System.out.println("Certificate Path: " + certificatePath);
        System.out.println("CSR Path: " + csrPath);

       
    }
}