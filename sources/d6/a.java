package d6;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC;
import com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.b;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class a extends MediaDataSource {

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap f61357e = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.a f61358a;

    /* renamed from: b, reason: collision with root package name */
    private long f61359b = -2147483648L;

    /* renamed from: c, reason: collision with root package name */
    private final Context f61360c;

    /* renamed from: d, reason: collision with root package name */
    private final TKC f61361d;

    public a(Context context, TKC tkc) {
        this.f61360c = context;
        this.f61361d = tkc;
        this.f61358a = new b(context, tkc);
    }

    public static a h(Context context, TKC tkc) {
        a aVar = new a(context, tkc);
        f61357e.put(tkc.sef(), aVar);
        return aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f61361d.Fmk();
        com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.a aVar = this.f61358a;
        if (aVar != null) {
            aVar.sP();
        }
        f61357e.remove(this.f61361d.sef());
    }

    public TKC d() {
        return this.f61361d;
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        if (this.f61359b == -2147483648L) {
            if (this.f61360c == null || TextUtils.isEmpty(this.f61361d.Fmk())) {
                return -1L;
            }
            this.f61359b = this.f61358a.TKC();
        }
        return this.f61359b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j11, byte[] bArr, int i11, int i12) {
        int a11 = this.f61358a.a(j11, bArr, i11, i12);
        int length = bArr.length;
        Objects.toString(Thread.currentThread());
        return a11;
    }
}
