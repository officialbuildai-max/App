package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.view.Lifecycle;
import androidx.view.ProcessLifecycleInitializer;
import androidx.view.u;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements e4.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.core.os.s.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.i()) {
                    EmojiCompat.c().l();
                }
            } finally {
                androidx.core.os.s.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements androidx.view.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Lifecycle f9145a;

        a(Lifecycle lifecycle) {
            this.f9145a = lifecycle;
        }

        @Override // androidx.view.f
        public /* synthetic */ void onCreate(u uVar) {
            androidx.view.e.a(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onDestroy(u uVar) {
            androidx.view.e.b(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onPause(u uVar) {
            androidx.view.e.c(this, uVar);
        }

        @Override // androidx.view.f
        public void onResume(u uVar) {
            EmojiCompatInitializer.this.e();
            this.f9145a.d(this);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onStart(u uVar) {
            androidx.view.e.e(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onStop(u uVar) {
            androidx.view.e.f(this, uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends EmojiCompat.c {
        protected b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements EmojiCompat.g {

        /* renamed from: a, reason: collision with root package name */
        private final Context f9147a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends EmojiCompat.h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ EmojiCompat.h f9148a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f9149b;

            a(EmojiCompat.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f9148a = hVar;
                this.f9149b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void a(Throwable th2) {
                try {
                    this.f9148a.a(th2);
                } finally {
                    this.f9149b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void b(n nVar) {
                try {
                    this.f9148a.b(nVar);
                } finally {
                    this.f9149b.shutdown();
                }
            }
        }

        c(Context context) {
            this.f9147a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.g
        public void a(final EmojiCompat.h hVar) {
            final ThreadPoolExecutor b11 = androidx.emoji2.text.c.b("EmojiCompatInitializer");
            b11.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.c.this.d(hVar, b11);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(EmojiCompat.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                j a11 = d.a(this.f9147a);
                if (a11 == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                a11.c(threadPoolExecutor);
                a11.a().a(new a(hVar, threadPoolExecutor));
            } catch (Throwable th2) {
                hVar.a(th2);
                threadPoolExecutor.shutdown();
            }
        }
    }

    @Override // e4.a
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // e4.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        EmojiCompat.h(new b(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        Lifecycle lifecycle = ((u) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    void e() {
        androidx.emoji2.text.c.d().postDelayed(new LoadEmojiCompatRunnable(), 500L);
    }
}
