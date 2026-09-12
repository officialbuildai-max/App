package cv;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.w;
import com.transsion.transfer.androidasync.s;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    Headers f61039a;

    /* renamed from: b, reason: collision with root package name */
    Multimap f61040b;

    /* renamed from: c, reason: collision with root package name */
    private long f61041c;

    public d(Headers headers) {
        this.f61041c = -1L;
        this.f61039a = headers;
        this.f61040b = Multimap.parseSemicolonDelimited(headers.c(HttpHeaders.CONTENT_DISPOSITION));
    }

    public d(String str, long j11, List list) {
        this.f61041c = j11;
        this.f61039a = new Headers();
        StringBuilder sb2 = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", str));
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                sb2.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", wVar.getName(), wVar.getValue()));
            }
        }
        this.f61039a.f(HttpHeaders.CONTENT_DISPOSITION, sb2.toString());
        this.f61040b = Multimap.parseSemicolonDelimited(this.f61039a.c(HttpHeaders.CONTENT_DISPOSITION));
    }

    public String a() {
        return this.f61040b.getString("name");
    }

    public Headers b() {
        return this.f61039a;
    }

    public long c() {
        return this.f61041c;
    }

    public void d(s sVar, bv.a aVar) {
    }
}
