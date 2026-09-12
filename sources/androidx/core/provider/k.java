package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class k {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f8293a;

        /* renamed from: b, reason: collision with root package name */
        private final List f8294b;

        a(int i11, List list) {
            this.f8293a = i11;
            this.f8294b = list;
        }

        public a(int i11, b[] bVarArr) {
            this.f8293a = i11;
            this.f8294b = Collections.singletonList(bVarArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i11, List list) {
            return new a(i11, list);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a b(int i11, b[] bVarArr) {
            return new a(i11, bVarArr);
        }

        public b[] c() {
            return (b[]) this.f8294b.get(0);
        }

        public List d() {
            return this.f8294b;
        }

        public int e() {
            return this.f8293a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean f() {
            return this.f8294b.size() > 1;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f8295a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8296b;

        /* renamed from: c, reason: collision with root package name */
        private final int f8297c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f8298d;

        /* renamed from: e, reason: collision with root package name */
        private final int f8299e;

        public b(Uri uri, int i11, int i12, boolean z10, int i13) {
            this.f8295a = (Uri) androidx.core.util.i.g(uri);
            this.f8296b = i11;
            this.f8297c = i12;
            this.f8298d = z10;
            this.f8299e = i13;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i11, int i12, boolean z10, int i13) {
            return new b(uri, i11, i12, z10, i13);
        }

        public int b() {
            return this.f8299e;
        }

        public int c() {
            return this.f8296b;
        }

        public Uri d() {
            return this.f8295a;
        }

        public int e() {
            return this.f8297c;
        }

        public boolean f() {
            return this.f8298d;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public void a(int i11) {
        }

        public void b(Typeface typeface) {
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return z0.i.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        List a11;
        a11 = z0.h.a(new Object[]{eVar});
        return d.e(context, a11, cancellationSignal);
    }

    public static Typeface c(Context context, List list, int i11, boolean z10, int i12, Handler handler, c cVar) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(cVar, RequestExecutor.b(handler));
        if (!z10) {
            return i.d(context, list, i11, null, callbackWrapper);
        }
        if (list.size() <= 1) {
            return i.e(context, (e) list.get(0), callbackWrapper, i11, i12);
        }
        throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
    }
}
