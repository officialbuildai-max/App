package g9;

import android.net.Uri;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class i implements r {

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f63557n = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* renamed from: o, reason: collision with root package name */
    private static final a f63558o = new a(new a.InterfaceC0794a() { // from class: g9.g
        @Override // g9.i.a.InterfaceC0794a
        public final Constructor a() {
            Constructor e11;
            e11 = i.e();
            return e11;
        }
    });

    /* renamed from: p, reason: collision with root package name */
    private static final a f63559p = new a(new a.InterfaceC0794a() { // from class: g9.h
        @Override // g9.i.a.InterfaceC0794a
        public final Constructor a() {
            Constructor f11;
            f11 = i.f();
            return f11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private boolean f63560b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f63561c;

    /* renamed from: d, reason: collision with root package name */
    private int f63562d;

    /* renamed from: e, reason: collision with root package name */
    private int f63563e;

    /* renamed from: f, reason: collision with root package name */
    private int f63564f;

    /* renamed from: g, reason: collision with root package name */
    private int f63565g;

    /* renamed from: h, reason: collision with root package name */
    private int f63566h;

    /* renamed from: i, reason: collision with root package name */
    private int f63567i;

    /* renamed from: j, reason: collision with root package name */
    private int f63568j;

    /* renamed from: l, reason: collision with root package name */
    private int f63570l;

    /* renamed from: k, reason: collision with root package name */
    private int f63569k = 1;

    /* renamed from: m, reason: collision with root package name */
    private int f63571m = 112800;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0794a f63572a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f63573b = new AtomicBoolean(false);

        /* renamed from: c, reason: collision with root package name */
        private Constructor f63574c;

        /* renamed from: g9.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public interface InterfaceC0794a {
            Constructor a();
        }

        public a(InterfaceC0794a interfaceC0794a) {
            this.f63572a = interfaceC0794a;
        }

        private Constructor b() {
            synchronized (this.f63573b) {
                if (this.f63573b.get()) {
                    return this.f63574c;
                }
                try {
                    return this.f63572a.a();
                } catch (ClassNotFoundException unused) {
                    this.f63573b.set(true);
                    return this.f63574c;
                } catch (Exception e11) {
                    throw new RuntimeException("Error instantiating extension", e11);
                }
            }
        }

        public l a(Object... objArr) {
            Constructor b11 = b();
            if (b11 == null) {
                return null;
            }
            try {
                return (l) b11.newInstance(objArr);
            } catch (Exception e11) {
                throw new IllegalStateException("Unexpected error creating extractor", e11);
            }
        }
    }

    private void d(int i11, List list) {
        switch (i11) {
            case 0:
                list.add(new q9.b());
                return;
            case 1:
                list.add(new q9.e());
                return;
            case 2:
                list.add(new q9.h((this.f63561c ? 2 : 0) | this.f63562d | (this.f63560b ? 1 : 0)));
                return;
            case 3:
                list.add(new h9.b((this.f63561c ? 2 : 0) | this.f63563e | (this.f63560b ? 1 : 0)));
                return;
            case 4:
                l a11 = f63558o.a(Integer.valueOf(this.f63564f));
                if (a11 != null) {
                    list.add(a11);
                    return;
                } else {
                    list.add(new j9.d(this.f63564f));
                    return;
                }
            case 5:
                list.add(new com.google.android.exoplayer2.extractor.flv.b());
                return;
            case 6:
                list.add(new m9.e(this.f63565g));
                return;
            case 7:
                list.add(new n9.f((this.f63561c ? 2 : 0) | this.f63568j | (this.f63560b ? 1 : 0)));
                return;
            case 8:
                list.add(new o9.g(this.f63567i));
                list.add(new o9.k(this.f63566h));
                return;
            case 9:
                list.add(new p9.d());
                return;
            case 10:
                list.add(new q9.a0());
                return;
            case 11:
                list.add(new q9.h0(this.f63569k, this.f63570l, this.f63571m));
                return;
            case 12:
                list.add(new r9.b());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new l9.a());
                return;
            case 15:
                l a12 = f63559p.a(new Object[0]);
                if (a12 != null) {
                    list.add(a12);
                    return;
                }
                return;
            case 16:
                list.add(new i9.b());
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor e() {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(l.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor f() {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(l.class).getConstructor(null);
    }

    @Override // g9.r
    public synchronized l[] c(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = f63557n;
            arrayList = new ArrayList(iArr.length);
            int b11 = com.google.android.exoplayer2.util.l.b(map);
            if (b11 != -1) {
                d(b11, arrayList);
            }
            int c11 = com.google.android.exoplayer2.util.l.c(uri);
            if (c11 != -1 && c11 != b11) {
                d(c11, arrayList);
            }
            for (int i11 : iArr) {
                if (i11 != b11 && i11 != c11) {
                    d(i11, arrayList);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (l[]) arrayList.toArray(new l[arrayList.size()]);
    }

    @Override // g9.r
    public synchronized l[] createExtractors() {
        return c(Uri.EMPTY, new HashMap());
    }
}
