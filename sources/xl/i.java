package xl;

import android.util.LruCache;
import cm.c;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import xl.k;

/* loaded from: classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final LruCache f78483a = new LruCache(1000);

    /* renamed from: b, reason: collision with root package name */
    private final cm.f f78484b = cm.c.c(10, new a(this));

    /* loaded from: classes6.dex */
    class a implements c.a {
        a(i iVar) {
        }

        @Override // cm.c.a
        public Object create() {
            try {
                return new b(MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256));
            } catch (NoSuchAlgorithmException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements c.b {

        /* renamed from: a, reason: collision with root package name */
        private final MessageDigest f78485a;

        /* renamed from: b, reason: collision with root package name */
        private final k f78486b = new k.b(null);

        b(MessageDigest messageDigest) {
            this.f78485a = messageDigest;
        }

        @Override // cm.c.b
        public k getVerifier() {
            return this.f78486b;
        }
    }

    public String a(wl.e eVar) {
        String str;
        synchronized (this.f78483a) {
            str = (String) this.f78483a.get(eVar);
        }
        if (str == null) {
            b bVar = (b) this.f78484b.acquire();
            try {
                eVar.a(bVar.f78485a);
                str = d.a(bVar.f78485a.digest());
            } finally {
                this.f78484b.release(bVar);
            }
        }
        synchronized (this.f78483a) {
            this.f78483a.put(eVar, str);
        }
        return str;
    }
}
