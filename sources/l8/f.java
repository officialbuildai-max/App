package l8;

import android.util.Base64;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes4.dex */
public abstract class f {
    private static String a(byte[] bArr, String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.reset();
        return Base64.encodeToString(messageDigest.digest(bArr), 0);
    }

    public static void b(HttpsURLConnection httpsURLConnection, Set set, Set set2) {
        for (Certificate certificate : httpsURLConnection.getServerCertificates()) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            String a11 = a(x509Certificate.getEncoded(), EncoderUtil.ALGORITHM_SHA_1);
            if (set != null && set.contains(a11)) {
                return;
            }
            String a12 = a(x509Certificate.getPublicKey().getEncoded(), EncoderUtil.ALGORITHM_SHA_1);
            if (set2 != null && set2.contains(a12)) {
                return;
            }
        }
        throw new CertificateException("Unable to find valid certificate or public key.");
    }
}
