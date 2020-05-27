package com.navi.mini.program.common.utils;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * Created by hgg on 2018/2/24.
 * 小程序AES解密
 */
public class AESDecodeUtils {

	public static void main(String[] args) throws Exception {
		byte[] encrypData = Base64.decodeBase64("CG/GkKV/AIszxMJG+pSCJI0r994Hv4eycijwqI5XnwzyQCOzSsnW/eybT17GO4DwZjUnwU6rrpMCylWibcGM/gPbxev4g0JTyBuFl7AAuVA8ywcavKdT9BhHl0wQ7428XGZbSWyQNcM7FlmNy8GJDW97ouocneUBaK/Qxd19koUMqvbXF0N2Gl84PrHXGs/+gp9U5mQQXZzE7aArZNeqhA==");
		byte[] ivData = Base64.decodeBase64("hnjfx7MHOrMGy994gsHN2w==");
		byte[] sessionKey = Base64.decodeBase64("28divToWc/EDHHa3W1rYww==");
		System.out.println(decrypt(sessionKey,ivData,encrypData));
	}

	public static String decrypt(byte[] key, byte[] iv, byte[] encData) throws Exception {
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
		//解析解密后的字符串
		return new String(cipher.doFinal(encData),"UTF-8");
	}
}
