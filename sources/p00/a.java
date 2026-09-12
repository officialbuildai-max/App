package p00;

import androidx.core.view.InputDeviceCompat;
import com.cloud.config.utils.CommonUtils;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.transsion.baselib.db.download.DownloadException;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.r;

/* loaded from: classes7.dex */
public class a implements o00.a {

    /* renamed from: w, reason: collision with root package name */
    private static final a[] f72354w = new a[0];

    /* renamed from: a, reason: collision with root package name */
    private String f72355a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f72356b;

    /* renamed from: c, reason: collision with root package name */
    private int f72357c;

    /* renamed from: d, reason: collision with root package name */
    private long f72358d;

    /* renamed from: e, reason: collision with root package name */
    private long f72359e;

    /* renamed from: f, reason: collision with root package name */
    private long f72360f;

    /* renamed from: g, reason: collision with root package name */
    private long f72361g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f72362h;

    /* renamed from: i, reason: collision with root package name */
    private byte f72363i;

    /* renamed from: j, reason: collision with root package name */
    private String f72364j;

    /* renamed from: k, reason: collision with root package name */
    private String f72365k;

    /* renamed from: l, reason: collision with root package name */
    private String f72366l;

    /* renamed from: m, reason: collision with root package name */
    private String f72367m;

    /* renamed from: n, reason: collision with root package name */
    private String f72368n;

    /* renamed from: o, reason: collision with root package name */
    private int f72369o;

    /* renamed from: p, reason: collision with root package name */
    private int f72370p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f72371q;

    /* renamed from: r, reason: collision with root package name */
    private long f72372r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f72373s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f72374t;

    /* renamed from: u, reason: collision with root package name */
    private final File f72375u;

    /* renamed from: v, reason: collision with root package name */
    private final Map f72376v;

    private a(boolean z10) {
        this.f72355a = "";
        this.f72358d = 0L;
        this.f72359e = 0L;
        this.f72360f = 0L;
        this.f72364j = "";
        this.f72365k = "ustar\u0000";
        this.f72366l = "00";
        this.f72368n = "";
        this.f72369o = 0;
        this.f72370p = 0;
        this.f72376v = new HashMap();
        String property = System.getProperty("user.name", "");
        this.f72367m = property.length() > 31 ? property.substring(0, 31) : property;
        this.f72375u = null;
        this.f72356b = z10;
    }

    public a(byte[] bArr, r rVar, boolean z10) {
        this(false);
        q(bArr, rVar, false, z10);
    }

    private int b(byte[] bArr) {
        if (q00.a.c("ustar ", bArr, InputDeviceCompat.SOURCE_KEYBOARD, 6)) {
            return 2;
        }
        if (q00.a.c("ustar\u0000", bArr, InputDeviceCompat.SOURCE_KEYBOARD, 6)) {
            return q00.a.c("tar\u0000", bArr, DownloadException.EXCEPTION_IO_MALFORMED_URL, 4) ? 4 : 3;
        }
        return 0;
    }

    private static String o(String str, boolean z10) {
        String lowerCase;
        int indexOf;
        if (!z10 && (lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH)) != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char charAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (indexOf = str.indexOf(58)) != -1) {
                str = str.substring(indexOf + 1);
            }
        }
        String replace = str.replace(File.separatorChar, '/');
        while (!z10 && replace.startsWith("/")) {
            replace = replace.substring(1);
        }
        return replace;
    }

    private long p(byte[] bArr, int i11, int i12, boolean z10) {
        if (!z10) {
            return d.h(bArr, i11, i12);
        }
        try {
            return d.h(bArr, i11, i12);
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private void q(byte[] bArr, r rVar, boolean z10, boolean z11) {
        this.f72355a = z10 ? d.e(bArr, 0, 100) : d.f(bArr, 0, 100, rVar);
        this.f72357c = (int) p(bArr, 100, 8, z11);
        this.f72358d = (int) p(bArr, TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, 8, z11);
        this.f72359e = (int) p(bArr, Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE, 8, z11);
        this.f72360f = d.h(bArr, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 12);
        this.f72361g = p(bArr, Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE, 12, z11);
        this.f72362h = d.i(bArr);
        this.f72363i = bArr[156];
        this.f72364j = z10 ? d.e(bArr, 157, 100) : d.f(bArr, 157, 100, rVar);
        this.f72365k = d.e(bArr, InputDeviceCompat.SOURCE_KEYBOARD, 6);
        this.f72366l = d.e(bArr, 263, 2);
        this.f72367m = z10 ? d.e(bArr, 265, 32) : d.f(bArr, 265, 32, rVar);
        this.f72368n = z10 ? d.e(bArr, 297, 32) : d.f(bArr, 297, 32, rVar);
        byte b11 = this.f72363i;
        if (b11 == 51 || b11 == 52) {
            this.f72369o = (int) p(bArr, 329, 8, z11);
            this.f72370p = (int) p(bArr, 337, 8, z11);
        }
        int b12 = b(bArr);
        if (b12 == 2) {
            this.f72371q = d.d(bArr, 482);
            this.f72372r = d.g(bArr, 483, 12);
            return;
        }
        if (b12 == 4) {
            String e11 = z10 ? d.e(bArr, 345, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE) : d.f(bArr, 345, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, rVar);
            if (e11.length() > 0) {
                this.f72355a = e11 + "/" + this.f72355a;
                return;
            }
            return;
        }
        String e12 = z10 ? d.e(bArr, 345, 155) : d.f(bArr, 345, 155, rVar);
        if (h() && !this.f72355a.endsWith("/")) {
            this.f72355a += "/";
        }
        if (e12.length() > 0) {
            this.f72355a = e12 + "/" + this.f72355a;
        }
    }

    private void r(String str, String str2, Map map) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1916861932:
                if (str.equals("SCHILY.devmajor")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1916619760:
                if (str.equals("SCHILY.devminor")) {
                    c11 = 1;
                    break;
                }
                break;
            case -277496563:
                if (str.equals("GNU.sparse.realsize")) {
                    c11 = 2;
                    break;
                }
                break;
            case -160380561:
                if (str.equals("GNU.sparse.size")) {
                    c11 = 3;
                    break;
                }
                break;
            case 102338:
                if (str.equals("gid")) {
                    c11 = 4;
                    break;
                }
                break;
            case 115792:
                if (str.equals(CommonUtils.PARAM_UID)) {
                    c11 = 5;
                    break;
                }
                break;
            case 3433509:
                if (str.equals("path")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    c11 = 7;
                    break;
                }
                break;
            case 98496370:
                if (str.equals("gname")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 104223930:
                if (str.equals("mtime")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 111425664:
                if (str.equals("uname")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 530706950:
                if (str.equals("SCHILY.filetype")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1195018015:
                if (str.equals("linkpath")) {
                    c11 = '\f';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                s(Integer.parseInt(str2));
                return;
            case 1:
                t(Integer.parseInt(str2));
                return;
            case 2:
                d(map);
                return;
            case 3:
                c(map);
                return;
            case 4:
                u(Long.parseLong(str2));
                return;
            case 5:
                A(Long.parseLong(str2));
                return;
            case 6:
                y(str2);
                return;
            case 7:
                z(Long.parseLong(str2));
                return;
            case '\b':
                v(str2);
                return;
            case '\t':
                x((long) (Double.parseDouble(str2) * 1000.0d));
                return;
            case '\n':
                B(str2);
                return;
            case 11:
                if ("sparse".equals(str2)) {
                    e(map);
                    return;
                }
                return;
            case '\f':
                w(str2);
                return;
            default:
                this.f72376v.put(str, str2);
                return;
        }
    }

    public void A(long j11) {
        this.f72358d = j11;
    }

    public void B(String str) {
        this.f72367m = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            r((String) entry.getKey(), (String) entry.getValue(), map);
        }
    }

    public boolean a(a aVar) {
        return aVar != null && f().equals(aVar.f());
    }

    void c(Map map) {
        this.f72373s = true;
        this.f72372r = Integer.parseInt((String) map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.f72355a = (String) map.get("GNU.sparse.name");
        }
    }

    void d(Map map) {
        this.f72373s = true;
        this.f72372r = Integer.parseInt((String) map.get("GNU.sparse.realsize"));
        this.f72355a = (String) map.get("GNU.sparse.name");
    }

    void e(Map map) {
        this.f72374t = true;
        if (map.containsKey("SCHILY.realsize")) {
            this.f72372r = Long.parseLong((String) map.get("SCHILY.realsize"));
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return a((a) obj);
    }

    public String f() {
        return this.f72355a;
    }

    public long g() {
        return this.f72360f;
    }

    public boolean h() {
        File file = this.f72375u;
        if (file != null) {
            return file.isDirectory();
        }
        if (this.f72363i == 53) {
            return true;
        }
        return (n() || l() || !f().endsWith("/")) ? false : true;
    }

    public int hashCode() {
        return f().hashCode();
    }

    public boolean i() {
        return this.f72371q;
    }

    public boolean j() {
        return this.f72363i == 75;
    }

    public boolean k() {
        return this.f72363i == 76;
    }

    public boolean l() {
        return this.f72363i == 103;
    }

    public boolean m() {
        return this.f72363i == 83;
    }

    public boolean n() {
        byte b11 = this.f72363i;
        return b11 == 120 || b11 == 88;
    }

    public void s(int i11) {
        if (i11 >= 0) {
            this.f72369o = i11;
            return;
        }
        throw new IllegalArgumentException("Major device number is out of range: " + i11);
    }

    public void t(int i11) {
        if (i11 >= 0) {
            this.f72370p = i11;
            return;
        }
        throw new IllegalArgumentException("Minor device number is out of range: " + i11);
    }

    public void u(long j11) {
        this.f72359e = j11;
    }

    public void v(String str) {
        this.f72368n = str;
    }

    public void w(String str) {
        this.f72364j = str;
    }

    public void x(long j11) {
        this.f72361g = j11 / 1000;
    }

    public void y(String str) {
        this.f72355a = o(str, this.f72356b);
    }

    public void z(long j11) {
        if (j11 >= 0) {
            this.f72360f = j11;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j11);
    }
}
