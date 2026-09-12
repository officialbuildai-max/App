package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes5.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    protected static char[] f35823a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    protected static MessageDigest f35824b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f35825c = "SameFileMD5";

    static {
        try {
            f35824b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e11) {
            System.err.println(l0.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e11.printStackTrace();
        }
    }

    public static String a(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        MessageDigest messageDigest;
        if (file == null || !file.exists()) {
            return "";
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            randomAccessFile = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        try {
            byte[] bArr = new byte[10485760];
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            String a11 = a(messageDigest.digest());
            try {
                randomAccessFile.close();
            } catch (IOException e11) {
                o0.b(f35825c, e11.getMessage());
            }
            return a11;
        } catch (Throwable th3) {
            th = th3;
            try {
                o0.b(f35825c, th.getMessage());
                return "";
            } finally {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e12) {
                        o0.b(f35825c, e12.getMessage());
                    }
                }
            }
        }
    }

    private static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i11, int i12) {
        StringBuffer stringBuffer = new StringBuffer(i12 * 2);
        int i13 = i12 + i11;
        while (i11 < i13) {
            a(bArr[i11], stringBuffer);
            i11++;
        }
        return stringBuffer.toString();
    }

    private static void a(byte b11, StringBuffer stringBuffer) {
        char[] cArr = f35823a;
        char c11 = cArr[(b11 & 240) >> 4];
        char c12 = cArr[b11 & 15];
        stringBuffer.append(c11);
        stringBuffer.append(c12);
    }
}
