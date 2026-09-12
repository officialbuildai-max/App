package com.amazonaws.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes2.dex */
public class PropertiesCredentials implements AWSCredentials {

    /* renamed from: a, reason: collision with root package name */
    private final String f18447a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18448b;

    public PropertiesCredentials(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File doesn't exist:  " + file.getAbsolutePath());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            if (properties.getProperty("accessKey") == null || properties.getProperty("secretKey") == null) {
                throw new IllegalArgumentException("The specified file (" + file.getAbsolutePath() + ") doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
            this.f18447a = properties.getProperty("accessKey");
            this.f18448b = properties.getProperty("secretKey");
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            throw th2;
        }
    }

    public PropertiesCredentials(InputStream inputStream) {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            if (properties.getProperty("accessKey") == null || properties.getProperty("secretKey") == null) {
                throw new IllegalArgumentException("The specified properties data doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
            this.f18447a = properties.getProperty("accessKey");
            this.f18448b = properties.getProperty("secretKey");
        } finally {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String b() {
        return this.f18447a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String c() {
        return this.f18448b;
    }
}
