package com.example.app.security;

import com.example.app.security.crypto.AesEncryptionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AesEncryptionUtilTest {

    private AesEncryptionUtil encryptionUtil;

    @BeforeEach
    void setUp() {
        encryptionUtil = new AesEncryptionUtil("TestMasterKeySecret2026!#$ForEncryptionUnitTesting");
    }

    @Test
    @DisplayName("Mã hóa và giải mã chuỗi API Key thành công (AES-256-GCM)")
    void testEncryptAndDecrypt() {
        String rawKey = "AIzaSyD_TestApiKey1234567890abcdef";

        String encrypted = encryptionUtil.encrypt(rawKey);
        assertNotNull(encrypted);
        assertNotEquals(rawKey, encrypted);

        String decrypted = encryptionUtil.decrypt(encrypted);
        assertEquals(rawKey, decrypted);
    }

    @Test
    @DisplayName("Che ký tự API Key an toàn dạng masked (AIzaSy...cdef)")
    void testMaskKey() {
        String rawKey = "AIzaSyD_TestApiKey1234567890abcdef";
        String masked = encryptionUtil.maskKey(rawKey);

        assertEquals("AIzaSy...cdef", masked);
    }

    @Test
    @DisplayName("Xử lý chuỗi null hoặc rỗng an toàn")
    void testNullAndEmpty() {
        assertNull(encryptionUtil.encrypt(null));
        assertNull(encryptionUtil.decrypt(null));
        assertNull(encryptionUtil.encrypt(""));
        assertNull(encryptionUtil.decrypt(""));
        assertEquals("********", encryptionUtil.maskKey(null));
        assertEquals("********", encryptionUtil.maskKey("123"));
    }
}
