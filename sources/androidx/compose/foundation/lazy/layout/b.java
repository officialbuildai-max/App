package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f3106a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3107b;

        /* renamed from: c, reason: collision with root package name */
        private final Object f3108c;

        public a(int i11, int i12, Object obj) {
            this.f3106a = i11;
            this.f3107b = i12;
            this.f3108c = obj;
            if (i11 < 0) {
                throw new IllegalArgumentException(("startIndex should be >= 0, but was " + i11).toString());
            }
            if (i12 > 0) {
                return;
            }
            throw new IllegalArgumentException(("size should be >0, but was " + i12).toString());
        }

        public final int a() {
            return this.f3107b;
        }

        public final int b() {
            return this.f3106a;
        }

        public final Object c() {
            return this.f3108c;
        }
    }

    void a(int i11, int i12, Function1 function1);

    a get(int i11);

    int getSize();
}
