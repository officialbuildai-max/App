package l8;

import android.util.Log;
import java.net.HttpURLConnection;
import java.util.Map;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private int f68873a;

    /* renamed from: b, reason: collision with root package name */
    private String f68874b;

    /* renamed from: c, reason: collision with root package name */
    private Map f68875c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f68876d;

    public e(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f68873a = httpURLConnection.getResponseCode();
            this.f68874b = httpURLConnection.getURL().toString();
            this.f68875c = httpURLConnection.getHeaderFields();
        } catch (Throwable th2) {
            Log.e("HttpResponse", "Failed to createHttpResponse", th2);
        }
        this.f68876d = bArr;
    }

    public int a() {
        return this.f68873a;
    }
}
