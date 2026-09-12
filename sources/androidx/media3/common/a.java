package androidx.media3.common;

import android.view.View;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final View f9868a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9869b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9870c;

    /* renamed from: androidx.media3.common.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0095a {

        /* renamed from: a, reason: collision with root package name */
        private final View f9871a;

        /* renamed from: b, reason: collision with root package name */
        private final int f9872b;

        /* renamed from: c, reason: collision with root package name */
        private String f9873c;

        public C0095a(View view, int i11) {
            this.f9871a = view;
            this.f9872b = i11;
        }

        public a a() {
            return new a(this.f9871a, this.f9872b, this.f9873c);
        }

        public C0095a b(String str) {
            this.f9873c = str;
            return this;
        }
    }

    public a(View view, int i11, String str) {
        this.f9868a = view;
        this.f9869b = i11;
        this.f9870c = str;
    }
}
