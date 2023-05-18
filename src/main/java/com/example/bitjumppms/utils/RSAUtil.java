package com.example.bitjumppms.utils;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAUtil {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final int KEY_SIZE = 1024;

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(KEY_SIZE);
        return keyPairGen.generateKeyPair();
    }

    //将密码写入文件
    public static void writeToFile(String path, Key key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(key.getEncoded());
            fos.flush();
        }
    }

    //加密
    public static byte[] encrypt(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    //解密
    public static byte[] decrypt(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    //获取私钥
    public static PrivateKey getPrivateKeyFromPemResource(String path) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        try (InputStream is = RSAUtil.class.getClassLoader().getResourceAsStream(path);
             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("-----")) {
                    sb.append(line);
                }
            }
            byte[] privKeyBytes = Base64.getDecoder().decode(sb.toString().getBytes(StandardCharsets.UTF_8));
            PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(privKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(privKeySpec);
        }
    }

    //获取公钥
    public static PublicKey getPublicKeyFromResource(String path) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        try (InputStream is = RSAUtil.class.getClassLoader().getResourceAsStream(path)) {
            byte[] pubKeyBytes = is.readAllBytes();
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(pubKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(pubKeySpec);
        }
    }




    @Test
    public void MyTest() throws Exception {
        String codeMsg = "M45yrK4E5Qm7LOyJ+BmfTAIlaEfddav6dnZZ63yTDoOCklkvTDupatYgdiRXvVVq97M5YpPCqd9muFXvK7vhHYlK7TkVDK7eSuhM4S3HypowoQ0TKSXIswRYwrqlUF2GuajBG49rqhTLuAB7DsZ4rhGCeRGsxhIfYjsRv5Vl06g=";
        PrivateKey privateKey = getPrivateKeyFromPemResource("rsa_1024_priv.pem");
        byte[] result = decrypt(Base64.getDecoder().decode(codeMsg),privateKey);
        System.out.println(new String(result));
    }
}

