package l2;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import i3.s;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class m implements x {

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f68744s = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};

    /* renamed from: t, reason: collision with root package name */
    private static final a f68745t = new a(new a.InterfaceC0854a() { // from class: l2.k
        @Override // l2.m.a.InterfaceC0854a
        public final Constructor a() {
            Constructor j11;
            j11 = m.j();
            return j11;
        }
    });

    /* renamed from: u, reason: collision with root package name */
    private static final a f68746u = new a(new a.InterfaceC0854a() { // from class: l2.l
        @Override // l2.m.a.InterfaceC0854a
        public final Constructor a() {
            Constructor k11;
            k11 = m.k();
            return k11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private boolean f68747b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f68748c;

    /* renamed from: d, reason: collision with root package name */
    private int f68749d;

    /* renamed from: e, reason: collision with root package name */
    private int f68750e;

    /* renamed from: f, reason: collision with root package name */
    private int f68751f;

    /* renamed from: g, reason: collision with root package name */
    private int f68752g;

    /* renamed from: h, reason: collision with root package name */
    private int f68753h;

    /* renamed from: i, reason: collision with root package name */
    private int f68754i;

    /* renamed from: j, reason: collision with root package name */
    private int f68755j;

    /* renamed from: l, reason: collision with root package name */
    private int f68757l;

    /* renamed from: m, reason: collision with root package name */
    private ImmutableList f68758m;

    /* renamed from: q, reason: collision with root package name */
    private int f68762q;

    /* renamed from: r, reason: collision with root package name */
    private int f68763r;

    /* renamed from: k, reason: collision with root package name */
    private int f68756k = 1;

    /* renamed from: n, reason: collision with root package name */
    private int f68759n = 112800;

    /* renamed from: p, reason: collision with root package name */
    private s.a f68761p = new i3.h();

    /* renamed from: o, reason: collision with root package name */
    private boolean f68760o = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0854a f68764a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f68765b = new AtomicBoolean(false);

        /* renamed from: c, reason: collision with root package name */
        private Constructor f68766c;

        /* renamed from: l2.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0854a {
            Constructor a();
        }

        public a(InterfaceC0854a interfaceC0854a) {
            this.f68764a = interfaceC0854a;
        }

        private Constructor b() {
            synchronized (this.f68765b) {
                if (this.f68765b.get()) {
                    return this.f68766c;
                }
                try {
                    return this.f68764a.a();
                } catch (ClassNotFoundException unused) {
                    this.f68765b.set(true);
                    return this.f68766c;
                } catch (Exception e11) {
                    throw new RuntimeException("Error instantiating extension", e11);
                }
            }
        }

        public r a(Object... objArr) {
            Constructor b11 = b();
            if (b11 == null) {
                return null;
            }
            try {
                return (r) b11.newInstance(objArr);
            } catch (Exception e11) {
                throw new IllegalStateException("Unexpected error creating extractor", e11);
            }
        }
    }

    private void g(int i11, List list) {
        switch (i11) {
            case 0:
                list.add(new s3.b());
                return;
            case 1:
                list.add(new s3.e());
                return;
            case 2:
                list.add(new s3.h(this.f68749d | (this.f68747b ? 1 : 0) | (this.f68748c ? 2 : 0)));
                return;
            case 3:
                list.add(new m2.b(this.f68750e | (this.f68747b ? 1 : 0) | (this.f68748c ? 2 : 0)));
                return;
            case 4:
                r a11 = f68745t.a(Integer.valueOf(this.f68751f));
                if (a11 != null) {
                    list.add(a11);
                    return;
                } else {
                    list.add(new q2.d(this.f68751f));
                    return;
                }
            case 5:
                list.add(new androidx.media3.extractor.flv.b());
                return;
            case 6:
                list.add(new d3.e(this.f68761p, (this.f68760o ? 0 : 2) | this.f68752g));
                return;
            case 7:
                list.add(new e3.f(this.f68755j | (this.f68747b ? 1 : 0) | (this.f68748c ? 2 : 0)));
                return;
            case 8:
                list.add(new f3.h(this.f68761p, this.f68754i | f3.h.j(this.f68762q) | (this.f68760o ? 0 : 32)));
                list.add(new f3.n(this.f68761p, this.f68753h | f3.n.m(this.f68762q) | (this.f68760o ? 0 : 16)));
                return;
            case 9:
                list.add(new g3.d());
                return;
            case 10:
                list.add(new s3.c0());
                return;
            case 11:
                if (this.f68758m == null) {
                    this.f68758m = ImmutableList.of();
                }
                list.add(new s3.k0(this.f68756k, !this.f68760o ? 1 : 0, this.f68761p, new androidx.media3.common.util.p0(0L), new s3.j(this.f68757l, this.f68758m), this.f68759n));
                return;
            case 12:
                list.add(new t3.b());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new t2.a(this.f68763r));
                return;
            case 15:
                r a12 = f68746u.a(new Object[0]);
                if (a12 != null) {
                    list.add(a12);
                    return;
                }
                return;
            case 16:
                list.add(new n2.b(1 ^ (this.f68760o ? 1 : 0), this.f68761p));
                return;
            case 17:
                list.add(new h3.a());
                return;
            case 18:
                list.add(new u3.a());
                return;
            case 19:
                list.add(new p2.a());
                return;
            case 20:
                int i12 = this.f68753h;
                if ((i12 & 2) == 0 && (i12 & 4) == 0) {
                    list.add(new s2.a());
                    return;
                }
                return;
            case 21:
                list.add(new o2.a());
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor j() {
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(r.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor k() {
        return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(r.class).getConstructor(null);
    }

    @Override // l2.x
    public synchronized r[] c(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = f68744s;
            arrayList = new ArrayList(iArr.length);
            int b11 = androidx.media3.common.o.b(map);
            if (b11 != -1) {
                g(b11, arrayList);
            }
            int c11 = androidx.media3.common.o.c(uri);
            if (c11 != -1 && c11 != b11) {
                g(c11, arrayList);
            }
            for (int i11 : iArr) {
                if (i11 != b11 && i11 != c11) {
                    g(i11, arrayList);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (r[]) arrayList.toArray(new r[arrayList.size()]);
    }

    @Override // l2.x
    public synchronized r[] createExtractors() {
        return c(Uri.EMPTY, new HashMap());
    }

    @Override // l2.x
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized m b(int i11) {
        this.f68762q = i11;
        return this;
    }

    @Override // l2.x
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public synchronized m d(boolean z10) {
        this.f68760o = z10;
        return this;
    }

    public synchronized m l(int i11) {
        this.f68763r = i11;
        return this;
    }

    @Override // l2.x
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public synchronized m a(s.a aVar) {
        this.f68761p = aVar;
        return this;
    }
}
