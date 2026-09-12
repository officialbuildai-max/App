package androidx.core.text;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final t f8333a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final t f8334b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final t f8335c;

    /* renamed from: d, reason: collision with root package name */
    public static final t f8336d;

    /* renamed from: e, reason: collision with root package name */
    public static final t f8337e;

    /* renamed from: f, reason: collision with root package name */
    public static final t f8338f;

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        static final a f8339b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        private final boolean f8340a;

        private a(boolean z10) {
            this.f8340a = z10;
        }

        @Override // androidx.core.text.u.c
        public int a(CharSequence charSequence, int i11, int i12) {
            int i13 = i12 + i11;
            boolean z10 = false;
            while (i11 < i13) {
                int a11 = u.a(Character.getDirectionality(charSequence.charAt(i11)));
                if (a11 != 0) {
                    if (a11 != 1) {
                        continue;
                        i11++;
                        z10 = z10;
                    } else if (!this.f8340a) {
                        return 1;
                    }
                } else if (this.f8340a) {
                    return 0;
                }
                z10 = true;
                i11++;
                z10 = z10;
            }
            if (z10) {
                return this.f8340a ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f8341a = new b();

        private b() {
        }

        @Override // androidx.core.text.u.c
        public int a(CharSequence charSequence, int i11, int i12) {
            int i13 = i12 + i11;
            int i14 = 2;
            while (i11 < i13 && i14 == 2) {
                i14 = u.b(Character.getDirectionality(charSequence.charAt(i11)));
                i11++;
            }
            return i14;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i11, int i12);
    }

    /* loaded from: classes.dex */
    private static abstract class d implements t {

        /* renamed from: a, reason: collision with root package name */
        private final c f8342a;

        d(c cVar) {
            this.f8342a = cVar;
        }

        private boolean c(CharSequence charSequence, int i11, int i12) {
            int a11 = this.f8342a.a(charSequence, i11, i12);
            if (a11 == 0) {
                return true;
            }
            if (a11 != 1) {
                return b();
            }
            return false;
        }

        @Override // androidx.core.text.t
        public boolean a(CharSequence charSequence, int i11, int i12) {
            if (charSequence == null || i11 < 0 || i12 < 0 || charSequence.length() - i12 < i11) {
                throw new IllegalArgumentException();
            }
            return this.f8342a == null ? b() : c(charSequence, i11, i12);
        }

        protected abstract boolean b();
    }

    /* loaded from: classes.dex */
    private static class e extends d {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f8343b;

        e(c cVar, boolean z10) {
            super(cVar);
            this.f8343b = z10;
        }

        @Override // androidx.core.text.u.d
        protected boolean b() {
            return this.f8343b;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        static final f f8344b = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.text.u.d
        protected boolean b() {
            return v.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f8341a;
        f8335c = new e(bVar, false);
        f8336d = new e(bVar, true);
        f8337e = new e(a.f8339b, false);
        f8338f = f.f8344b;
    }

    static int a(int i11) {
        if (i11 != 0) {
            return (i11 == 1 || i11 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i11) {
        if (i11 != 0) {
            if (i11 == 1 || i11 == 2) {
                return 0;
            }
            switch (i11) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
