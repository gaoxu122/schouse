package com.example.sc.until.ding;

import com.example.sc.baseResource.ITStaticConstant;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BasicMethod {

    public  static   String resultSignature(String timestamp ,String suiteTicket ,String suiteSecret) throws Exception {
        String stringToSign = timestamp+"\n"+suiteTicket;
        Mac mac = Mac.getInstance(ITStaticConstant.ALGORITHM_SIGNATURE);
        mac.init(new SecretKeySpec(suiteSecret.getBytes(ITStaticConstant.ENCODING_RULE), ITStaticConstant.ALGORITHM_SIGNATURE));
        byte[] signData = mac.doFinal(stringToSign.getBytes());
        return new String(Base64.encodeBase64(signData));
    }

    public static String urlEncode(String value, String encoding) {
        if (value == null) {
            return "";
        }

        try {
            String encoded = URLEncoder.encode(value, encoding);
            return encoded.replace("+", "%20").replace("*", "%2A")
                    .replace("~", "%7E").replace("/", "%2F");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("FailedToEncodeUri", e);
        }
    }
}
