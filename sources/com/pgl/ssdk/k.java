package com.pgl.ssdk;

import com.pgl.ssdk.c;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.pgl.ssdk.f;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class k {
    @DungeonFlag
    private static e a(ByteBuffer byteBuffer) throws a, NoSuchAlgorithmException, CertificateException {
        ByteBuffer a11 = f.a(byteBuffer);
        a11.get(new byte[a11.remaining()]);
        a11.flip();
        a11.position(0);
        f.a(a11);
        byte[] b11 = f.b(f.a(a11));
        try {
            Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b11));
            if (generateCertificate instanceof X509Certificate) {
                return new e(String.valueOf(((X509Certificate) generateCertificate).getSubjectDN()), b11);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<e> a(o oVar, c.a aVar) throws IOException, f.a {
        return b(f.a(oVar, aVar, 1896449818).f40187a);
    }

    public static List<e> b(ByteBuffer byteBuffer) {
        try {
            ByteBuffer a11 = f.a(byteBuffer);
            if (!a11.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (a11.hasRemaining()) {
                try {
                    arrayList.add(a(f.a(a11)));
                } catch (a | BufferUnderflowException unused) {
                    return null;
                } catch (NoSuchAlgorithmException | CertificateException unused2) {
                }
            }
            return arrayList;
        } catch (a unused3) {
            return null;
        }
    }
}
