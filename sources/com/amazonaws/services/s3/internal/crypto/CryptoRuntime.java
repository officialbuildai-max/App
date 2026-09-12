package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;

@Deprecated
/* loaded from: classes2.dex */
public class CryptoRuntime {

    /* renamed from: a, reason: collision with root package name */
    private static final Log f18760a = LogFactory.b(CryptoRuntime.class);

    /* loaded from: classes2.dex */
    private static final class AesGcm {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(Provider provider) {
            try {
                Cipher.getInstance(ContentCryptoScheme.f18758b.b(), provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static synchronized void a() {
        synchronized (CryptoRuntime.class) {
            if (c()) {
                return;
            }
            try {
                Security.addProvider((Provider) Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider").newInstance());
            } catch (Exception e11) {
                f18760a.g("Bouncy Castle not available", e11);
            }
        }
    }

    public static boolean b(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider("BC");
        }
        return AesGcm.b(provider);
    }

    public static synchronized boolean c() {
        boolean z10;
        synchronized (CryptoRuntime.class) {
            z10 = Security.getProvider("BC") != null;
        }
        return z10;
    }
}
