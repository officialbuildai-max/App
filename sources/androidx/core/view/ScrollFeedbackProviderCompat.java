package androidx.core.view;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import android.view.View;

/* loaded from: classes.dex */
public class ScrollFeedbackProviderCompat {
    private final d mImpl;

    /* loaded from: classes.dex */
    private static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ScrollFeedbackProvider f8373a;

        b(View view) {
            this.f8373a = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void a(int i11, int i12, int i13, boolean z10) {
            this.f8373a.onScrollLimit(i11, i12, i13, z10);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void b(int i11, int i12, int i13, int i14) {
            this.f8373a.onScrollProgress(i11, i12, i13, i14);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void c(int i11, int i12, int i13) {
            this.f8373a.onSnapToItem(i11, i12, i13);
        }
    }

    /* loaded from: classes.dex */
    private static class c implements d {
        private c() {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void a(int i11, int i12, int i13, boolean z10) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void b(int i11, int i12, int i13, int i14) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void c(int i11, int i12, int i13) {
        }
    }

    /* loaded from: classes.dex */
    private interface d {
        void a(int i11, int i12, int i13, boolean z10);

        void b(int i11, int i12, int i13, int i14);

        void c(int i11, int i12, int i13);
    }

    private ScrollFeedbackProviderCompat(View view) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.mImpl = new b(view);
        } else {
            this.mImpl = new c();
        }
    }

    public static ScrollFeedbackProviderCompat createProvider(View view) {
        return new ScrollFeedbackProviderCompat(view);
    }

    public void onScrollLimit(int i11, int i12, int i13, boolean z10) {
        this.mImpl.a(i11, i12, i13, z10);
    }

    public void onScrollProgress(int i11, int i12, int i13, int i14) {
        this.mImpl.b(i11, i12, i13, i14);
    }

    public void onSnapToItem(int i11, int i12, int i13) {
        this.mImpl.c(i11, i12, i13);
    }
}
