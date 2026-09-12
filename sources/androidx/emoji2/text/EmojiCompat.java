package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class EmojiCompat {

    /* renamed from: o, reason: collision with root package name */
    private static final Object f9114o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private static final Object f9115p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static volatile EmojiCompat f9116q;

    /* renamed from: b, reason: collision with root package name */
    private final Set f9118b;

    /* renamed from: e, reason: collision with root package name */
    private final b f9121e;

    /* renamed from: f, reason: collision with root package name */
    final g f9122f;

    /* renamed from: g, reason: collision with root package name */
    private final i f9123g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f9124h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f9125i;

    /* renamed from: j, reason: collision with root package name */
    final int[] f9126j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f9127k;

    /* renamed from: l, reason: collision with root package name */
    private final int f9128l;

    /* renamed from: m, reason: collision with root package name */
    private final int f9129m;

    /* renamed from: n, reason: collision with root package name */
    private final e f9130n;

    /* renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f9117a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private volatile int f9119c = 3;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f9120d = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ListenerDispatcher implements Runnable {
        private final List<f> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(@NonNull f fVar, int i11) {
            this(Arrays.asList((f) androidx.core.util.i.h(fVar, "initCallback cannot be null")), i11, null);
        }

        ListenerDispatcher(@NonNull Collection<f> collection, int i11) {
            this(collection, i11, null);
        }

        ListenerDispatcher(@NonNull Collection<f> collection, int i11, @Nullable Throwable th2) {
            androidx.core.util.i.h(collection, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(collection);
            this.mLoadState = i11;
            this.mThrowable = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.mInitCallbacks.size();
            int i11 = 0;
            if (this.mLoadState != 1) {
                while (i11 < size) {
                    this.mInitCallbacks.get(i11).a(this.mThrowable);
                    i11++;
                }
            } else {
                while (i11 < size) {
                    this.mInitCallbacks.get(i11).b();
                    i11++;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.h f9131b;

        /* renamed from: c, reason: collision with root package name */
        private volatile n f9132c;

        /* renamed from: androidx.emoji2.text.EmojiCompat$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0086a extends h {
            C0086a() {
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void a(Throwable th2) {
                a.this.f9134a.n(th2);
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void b(n nVar) {
                a.this.d(nVar);
            }
        }

        a(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        void a() {
            try {
                this.f9134a.f9122f.a(new C0086a());
            } catch (Throwable th2) {
                this.f9134a.n(th2);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        CharSequence b(CharSequence charSequence, int i11, int i12, int i13, boolean z10) {
            return this.f9131b.h(charSequence, i11, i12, i13, z10);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f9132c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f9134a.f9124h);
        }

        void d(n nVar) {
            if (nVar == null) {
                this.f9134a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f9132c = nVar;
            n nVar2 = this.f9132c;
            i iVar = this.f9134a.f9123g;
            e eVar = this.f9134a.f9130n;
            EmojiCompat emojiCompat = this.f9134a;
            this.f9131b = new androidx.emoji2.text.h(nVar2, iVar, eVar, emojiCompat.f9125i, emojiCompat.f9126j, androidx.emoji2.text.g.a());
            this.f9134a.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final EmojiCompat f9134a;

        b(EmojiCompat emojiCompat) {
            this.f9134a = emojiCompat;
        }

        abstract void a();

        abstract CharSequence b(CharSequence charSequence, int i11, int i12, int i13, boolean z10);

        abstract void c(EditorInfo editorInfo);
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final g f9135a;

        /* renamed from: b, reason: collision with root package name */
        i f9136b;

        /* renamed from: c, reason: collision with root package name */
        boolean f9137c;

        /* renamed from: d, reason: collision with root package name */
        boolean f9138d;

        /* renamed from: e, reason: collision with root package name */
        int[] f9139e;

        /* renamed from: f, reason: collision with root package name */
        Set f9140f;

        /* renamed from: g, reason: collision with root package name */
        boolean f9141g;

        /* renamed from: h, reason: collision with root package name */
        int f9142h = -16711936;

        /* renamed from: i, reason: collision with root package name */
        int f9143i = 0;

        /* renamed from: j, reason: collision with root package name */
        e f9144j = new androidx.emoji2.text.e();

        /* JADX INFO: Access modifiers changed from: protected */
        public c(g gVar) {
            androidx.core.util.i.h(gVar, "metadataLoader cannot be null.");
            this.f9135a = gVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final g a() {
            return this.f9135a;
        }

        public c b(int i11) {
            this.f9143i = i11;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements i {
        @Override // androidx.emoji2.text.EmojiCompat.i
        public androidx.emoji2.text.i a(p pVar) {
            return new q(pVar);
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean a(CharSequence charSequence, int i11, int i12, int i13);
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public void a(Throwable th2) {
        }

        public void b() {
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(h hVar);
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public abstract void a(Throwable th2);

        public abstract void b(n nVar);
    }

    /* loaded from: classes.dex */
    public interface i {
        androidx.emoji2.text.i a(p pVar);
    }

    private EmojiCompat(c cVar) {
        this.f9124h = cVar.f9137c;
        this.f9125i = cVar.f9138d;
        this.f9126j = cVar.f9139e;
        this.f9127k = cVar.f9141g;
        this.f9128l = cVar.f9142h;
        this.f9122f = cVar.f9135a;
        this.f9129m = cVar.f9143i;
        this.f9130n = cVar.f9144j;
        androidx.collection.b bVar = new androidx.collection.b();
        this.f9118b = bVar;
        i iVar = cVar.f9136b;
        this.f9123g = iVar == null ? new d() : iVar;
        Set set = cVar.f9140f;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f9140f);
        }
        this.f9121e = new a(this);
        m();
    }

    public static EmojiCompat c() {
        EmojiCompat emojiCompat;
        synchronized (f9114o) {
            emojiCompat = f9116q;
            androidx.core.util.i.i(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i11, int i12, boolean z10) {
        return androidx.emoji2.text.h.b(inputConnection, editable, i11, i12, z10);
    }

    public static boolean g(Editable editable, int i11, KeyEvent keyEvent) {
        return androidx.emoji2.text.h.c(editable, i11, keyEvent);
    }

    public static EmojiCompat h(c cVar) {
        EmojiCompat emojiCompat = f9116q;
        if (emojiCompat == null) {
            synchronized (f9114o) {
                try {
                    emojiCompat = f9116q;
                    if (emojiCompat == null) {
                        emojiCompat = new EmojiCompat(cVar);
                        f9116q = emojiCompat;
                    }
                } finally {
                }
            }
        }
        return emojiCompat;
    }

    public static boolean i() {
        return f9116q != null;
    }

    private boolean k() {
        return e() == 1;
    }

    private void m() {
        this.f9117a.writeLock().lock();
        try {
            if (this.f9129m == 0) {
                this.f9119c = 0;
            }
            this.f9117a.writeLock().unlock();
            if (e() == 0) {
                this.f9121e.a();
            }
        } catch (Throwable th2) {
            this.f9117a.writeLock().unlock();
            throw th2;
        }
    }

    public int d() {
        return this.f9128l;
    }

    public int e() {
        this.f9117a.readLock().lock();
        try {
            return this.f9119c;
        } finally {
            this.f9117a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f9127k;
    }

    public void l() {
        androidx.core.util.i.i(this.f9129m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f9117a.writeLock().lock();
        try {
            if (this.f9119c == 0) {
                return;
            }
            this.f9119c = 0;
            this.f9117a.writeLock().unlock();
            this.f9121e.a();
        } finally {
            this.f9117a.writeLock().unlock();
        }
    }

    void n(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f9117a.writeLock().lock();
        try {
            this.f9119c = 2;
            arrayList.addAll(this.f9118b);
            this.f9118b.clear();
            this.f9117a.writeLock().unlock();
            this.f9120d.post(new ListenerDispatcher(arrayList, this.f9119c, th2));
        } catch (Throwable th3) {
            this.f9117a.writeLock().unlock();
            throw th3;
        }
    }

    void o() {
        ArrayList arrayList = new ArrayList();
        this.f9117a.writeLock().lock();
        try {
            this.f9119c = 1;
            arrayList.addAll(this.f9118b);
            this.f9118b.clear();
            this.f9117a.writeLock().unlock();
            this.f9120d.post(new ListenerDispatcher(arrayList, this.f9119c));
        } catch (Throwable th2) {
            this.f9117a.writeLock().unlock();
            throw th2;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence q(CharSequence charSequence, int i11, int i12) {
        return r(charSequence, i11, i12, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i11, int i12, int i13) {
        return s(charSequence, i11, i12, i13, 0);
    }

    public CharSequence s(CharSequence charSequence, int i11, int i12, int i13, int i14) {
        boolean z10;
        androidx.core.util.i.i(k(), "Not initialized yet");
        androidx.core.util.i.e(i11, "start cannot be negative");
        androidx.core.util.i.e(i12, "end cannot be negative");
        androidx.core.util.i.e(i13, "maxEmojiCount cannot be negative");
        androidx.core.util.i.b(i11 <= i12, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        androidx.core.util.i.b(i11 <= charSequence.length(), "start should be < than charSequence length");
        androidx.core.util.i.b(i12 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i11 == i12) {
            return charSequence;
        }
        if (i14 != 1) {
            z10 = i14 != 2 ? this.f9124h : false;
        } else {
            z10 = true;
        }
        return this.f9121e.b(charSequence, i11, i12, i13, z10);
    }

    public void t(f fVar) {
        androidx.core.util.i.h(fVar, "initCallback cannot be null");
        this.f9117a.writeLock().lock();
        try {
            if (this.f9119c != 1 && this.f9119c != 2) {
                this.f9118b.add(fVar);
                this.f9117a.writeLock().unlock();
            }
            this.f9120d.post(new ListenerDispatcher(fVar, this.f9119c));
            this.f9117a.writeLock().unlock();
        } catch (Throwable th2) {
            this.f9117a.writeLock().unlock();
            throw th2;
        }
    }

    public void u(f fVar) {
        androidx.core.util.i.h(fVar, "initCallback cannot be null");
        this.f9117a.writeLock().lock();
        try {
            this.f9118b.remove(fVar);
        } finally {
            this.f9117a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f9121e.c(editorInfo);
    }
}
